package by.kalilaska.services;

import java.util.List;

import by.kalilaska.beans.AdBean;
import by.kalilaska.beans.AdCategoryBean;

public interface AdService {

	List<AdBean> getAllAdsWithFieldEnabled(boolean enabled, int page, int size);

	List<AdBean> getAllAdsWithFieldEnabled(boolean enabled);

	List<AdBean> getAdsByAdCategoryWithFieldEnabled(List<AdCategoryBean> adCategoryBeanList, boolean enabled, int page,
			int size);

	List<AdBean> getRandomAdsByAdIdWithFieldEnabled(boolean enabled, List<Long> ids);

	Long getAdEnabledCount(boolean enabled);

	Long getSelectedCategoriesAdEnabledCount(List<AdCategoryBean> adCategoryList, boolean enabled);

	AdBean getAdById(long id);

	boolean disableAd(AdBean adBean);
}
