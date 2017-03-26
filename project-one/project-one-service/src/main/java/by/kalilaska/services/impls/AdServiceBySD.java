package by.kalilaska.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AdBean;
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
	public List<AdBean> getAdsByAdCategoryWithFieldEnabled(List<AdCategoryEntityHibernate> adCategoryList,
			boolean enabled, int page, int size) {
		List<AdEntityHibernate> adEntityList = adRepositoryData.findByAdEnabledAndAdCategoryInOrderByAdCreationDateDesc(
				enabled, adCategoryList, new PageRequest(page, size));
		List<AdBean> adBeanList = entityToBeanConverter.convertToBeanList(adEntityList, AdBean.class);

		return adBeanList;
	}

	@Override
	public Long getAdEnabledCount(boolean enabled) {
		return adRepositoryData.countByAdEnabled(enabled);
	}

}
