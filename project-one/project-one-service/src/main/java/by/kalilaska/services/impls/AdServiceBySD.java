package by.kalilaska.services.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AdBean;
import by.kalilaska.beans.AdCategoryBean;
import by.kalilaska.daoHibernate.repositories.springData.AdRepositoryData;
import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;
import by.kalilaska.entities.forHibernate.AdEntityHibernate;
import by.kalilaska.services.AdService;
import by.kalilaska.utilities.EntityToBeanConverter;

@Service
public class AdServiceBySD implements AdService {

	@Autowired
	private AdRepositoryData adRepositoryData;

	@Autowired
	private EntityToBeanConverter entityToBeanConverter;

	@Override
	@Transactional
	public List<AdBean> getAllAdsWithFieldEnabled(boolean enabled, int page, int size) {
		List<AdEntityHibernate> adEntityList = adRepositoryData.findByAdEnabledOrderByAdCreationDateDesc(enabled,
				new PageRequest(page, size));
		List<AdBean> adBeanList = entityToBeanConverter.convertToBeanList(adEntityList, AdBean.class);
		return adBeanList;
	}

	@Override
	@Transactional
	public List<AdBean> getAdsByAdCategoryWithFieldEnabled(List<AdCategoryBean> adCategoryBeanList, boolean enabled,
			int page, int size) {
		List<AdCategoryEntityHibernate> adCategoryEntityList = new ArrayList<>();
		for (AdCategoryBean adCategoryBean : adCategoryBeanList) {
			adCategoryEntityList
					.add(entityToBeanConverter.convertToEntity(adCategoryBean, AdCategoryEntityHibernate.class));
		}

		List<AdEntityHibernate> adEntityList = adRepositoryData.findByAdEnabledAndAdCategoryInOrderByAdCreationDateDesc(
				enabled, adCategoryEntityList, new PageRequest(page, size));
		List<AdBean> adBeanList = entityToBeanConverter.convertToBeanList(adEntityList, AdBean.class);

		return adBeanList;
	}

	@Override
	@Transactional
	public Long getAdEnabledCount(boolean enabled) {
		return adRepositoryData.countByAdEnabled(enabled);
	}

	@Override
	@Transactional
	public AdBean getAdById(long id) {
		AdEntityHibernate adEntity = adRepositoryData.findOne(id);
		AdBean adBean = entityToBeanConverter.convertToBean(adEntity, AdBean.class);
		return adBean;
	}

	@Override
	@Transactional
	public Long getSelectedCategoriesAdEnabledCount(List<AdCategoryBean> adCategoryBeanList, boolean enabled) {
		List<AdCategoryEntityHibernate> adCategoryEntityList = new ArrayList<>();
		for (AdCategoryBean adCategoryBean : adCategoryBeanList) {
			adCategoryEntityList
					.add(entityToBeanConverter.convertToEntity(adCategoryBean, AdCategoryEntityHibernate.class));
		}

		return adRepositoryData.countByAdEnabledAndAdCategoryIn(enabled, adCategoryEntityList);
	}

}
