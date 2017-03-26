package by.kalilaska.services;

import java.util.List;

import by.kalilaska.beans.AdBean;
import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;

public interface AdService {

	List<AdBean> getAllAdsWithFieldEnabled(boolean enabled, int page, int size);

	List<AdBean> getAdsByAdCategoryWithFieldEnabled(List<AdCategoryEntityHibernate> adCategoryList, boolean enabled,
			int page, int size);

	Long getAdEnabledCount(boolean enabled);
}
