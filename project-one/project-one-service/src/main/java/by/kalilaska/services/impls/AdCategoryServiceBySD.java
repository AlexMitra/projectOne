package by.kalilaska.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AdCategoryBean;
import by.kalilaska.daoHibernate.repositories.springData.AdCategoryRepositoryData;
import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;
import by.kalilaska.services.AdCategoryService;
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

		AdCategoryBean adCategoryBean = entityToBeanConverter.convertToBean(adCategoryEntity, AdCategoryBean.class);
		return adCategoryBean;
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
	public List<AdCategoryEntityHibernate> findAllCategoriesWithFieldEnabled(boolean enabled) {

		return adCategoryRepository.findByAdCategoryEnabled(enabled);
	}

	@Transactional
	@Override
	public List<AdCategoryBean> findAllCategoryNamesWithFieldEnabled(boolean enabled) {
		List<AdCategoryEntityHibernate> adCategoryEntityList = findAllCategoriesWithFieldEnabled(enabled);
		List<AdCategoryBean> adCategoryBeanList = entityToBeanConverter.convertToBeanList(adCategoryEntityList,
				AdCategoryBean.class);
		return adCategoryBeanList;
	}

}
