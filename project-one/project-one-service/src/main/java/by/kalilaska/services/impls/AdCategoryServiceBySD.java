package by.kalilaska.services.impls;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AdCategoryBean;
import by.kalilaska.daoHibernate.repositories.springData.AdCategoryRepositoryData;
import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;
import by.kalilaska.entities.forHibernate.AdEntityHibernate;
import by.kalilaska.services.AdCategoryService;
import by.kalilaska.services.exceptions.AdCategoryExistsException;
import by.kalilaska.services.exceptions.AdCategoryNameExistsException;
import by.kalilaska.services.exceptions.AdCategoryTranslationExistsException;
import by.kalilaska.utilities.EntityToBeanConverter;

@Service
public class AdCategoryServiceBySD implements AdCategoryService {

	@Autowired
	private EntityToBeanConverter entityToBeanConverter;

	@Autowired
	private AdCategoryRepositoryData adCategoryRepository;

	public AdCategoryServiceBySD() {
		super();
	}

	@Transactional
	@Override
	public AdCategoryBean findByCategoryId(Long id) {
		AdCategoryEntityHibernate adCategoryEntity = adCategoryRepository.findOne(id);

		AdCategoryBean adCategoryBean = entityToBeanConverter.convertToBean(adCategoryEntity, AdCategoryBean.class);
		return adCategoryBean;
	}

	@Transactional
	@Override
	public AdCategoryBean findByCategoryName(String name) {
		AdCategoryEntityHibernate adCategoryEntity = adCategoryRepository.findByAdCategoryName(name);

		if (adCategoryEntity != null) {
			AdCategoryBean adCategoryBean = entityToBeanConverter.convertToBean(adCategoryEntity, AdCategoryBean.class);
			return adCategoryBean;
		}
		return null;
	}

	@Transactional
	@Override
	public List<AdCategoryEntityHibernate> findAllCategories() {
		return adCategoryRepository.findAll();
	}

	@Transactional
	@Override
	public List<AdCategoryBean> findAllCategoryNames() {
		List<AdCategoryEntityHibernate> adCategoryEntityList = findAllCategories();
		List<AdCategoryBean> adCategoryBeanList = entityToBeanConverter.convertToBeanList(adCategoryEntityList,
				AdCategoryBean.class);
		return adCategoryBeanList;
	}

	@Transactional
	@Override
	public List<AdCategoryBean> findAllCategoriesWithFieldEnabled(boolean enabled) {
		List<AdCategoryEntityHibernate> adCategoryEntityList = adCategoryRepository.findByAdCategoryEnabled(enabled);
		List<AdCategoryBean> adCategoryBeanList = entityToBeanConverter.convertToBeanList(adCategoryEntityList,
				AdCategoryBean.class);
		return adCategoryBeanList;
	}

	@Transactional
	@Override
	public List<AdCategoryBean> findAllCategoryNamesWithFieldEnabled(boolean enabled) {
		List<AdCategoryBean> adCategoryBeanList = findAllCategoriesWithFieldEnabled(enabled);

		return adCategoryBeanList;
	}

	@Transactional
	@Override
	public AdCategoryBean createNewAdCategory(AdCategoryBean adCategoryBean) throws AdCategoryExistsException {

		AdCategoryBean created = null;

		if (findByCategoryName(adCategoryBean.getAdCategoryName()) != null) {

			throw new AdCategoryExistsException("this category already exists");
		}

		AdCategoryEntityHibernate adCategoryEntity = entityToBeanConverter.convertToEntity(adCategoryBean,
				AdCategoryEntityHibernate.class);

		adCategoryEntity = adCategoryRepository.save(adCategoryEntity);

		created = findByCategoryName(adCategoryBean.getAdCategoryName());
		return created;

	}

	@Transactional
	@Override
	public boolean disableAdCategory(AdCategoryBean adCategoryBean) {

		AdCategoryEntityHibernate adCategoryEntity = adCategoryRepository.findOne(adCategoryBean.getAdCategoryId());

		if (adCategoryEntity != null) {
			adCategoryEntity.setAdCategoryEnabled(adCategoryBean.isAdCategoryEnabled());
			Hibernate.initialize(adCategoryEntity.getAdsList());
			List<AdEntityHibernate> adEntityList = adCategoryEntity.getAdsList();
			if (adEntityList != null) {
				for (AdEntityHibernate adEntityHibernate : adEntityList) {
					adEntityHibernate.setAdEnabled(false);
				}
			}

			if (adCategoryRepository.findOne(adCategoryBean.getAdCategoryId()).isAdCategoryEnabled() == false) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	@Override
	public boolean enableAdCategory(AdCategoryBean adCategoryBean) {

		AdCategoryEntityHibernate adCategory = adCategoryRepository.findOne(adCategoryBean.getAdCategoryId());

		if (adCategory != null) {
			adCategory.setAdCategoryEnabled(true);
			adCategoryRepository.save(adCategory);
			if (adCategoryRepository.findOne(adCategoryBean.getAdCategoryId()).isAdCategoryEnabled()) {

				return true;
			}
		}

		return false;
	}

	@Transactional
	@Override
	public boolean deleteAdCategory(long adCategoryId) {

		AdCategoryEntityHibernate adCategory = adCategoryRepository.findOne(adCategoryId);

		if (adCategory != null) {
			Hibernate.initialize(adCategory.getAdsList());
			List<AdEntityHibernate> adEntityList = adCategory.getAdsList();
			if (adEntityList != null) {
				for (AdEntityHibernate adEntityHibernate : adEntityList) {
					adEntityHibernate.setAdEnabled(false);
				}
			}
			adCategoryRepository.delete(adCategory);
			if (adCategoryRepository.findOne(adCategoryId) == null) {

				return true;
			}
		}

		return false;
	}

	@Transactional
	@Override
	public void editAdCategory(AdCategoryBean adCategoryBean)
			throws AdCategoryNameExistsException, AdCategoryTranslationExistsException {

		try {
			AdCategoryEntityHibernate entityByName = adCategoryRepository
					.findByAdCategoryName(adCategoryBean.getAdCategoryName());
			if (entityByName.getAdCategoryId() != adCategoryBean.getAdCategoryId()) {

				throw new AdCategoryNameExistsException("Ad category with this name already exists");
			}
		} catch (NullPointerException e) {

		}

		try {
			AdCategoryEntityHibernate entityByI18n = adCategoryRepository
					.findByAdCategoryI18n(adCategoryBean.getAdCategoryI18n());
			if (entityByI18n.getAdCategoryId() != adCategoryBean.getAdCategoryId()) {
				throw new AdCategoryTranslationExistsException("Ad category with this i18n already exists");
			}
		} catch (NullPointerException e) {

		}

		AdCategoryEntityHibernate adCategoryEntity = adCategoryRepository.findOne(adCategoryBean.getAdCategoryId());

		if (adCategoryEntity != null) {
			adCategoryEntity.setAdCategoryName(adCategoryBean.getAdCategoryName());
			adCategoryEntity.setAdCategoryDescription(adCategoryBean.getAdCategoryDescription());
			adCategoryEntity.setAdCategoryI18n(adCategoryBean.getAdCategoryI18n());
		}

		adCategoryRepository.save(adCategoryEntity);

	}

}
