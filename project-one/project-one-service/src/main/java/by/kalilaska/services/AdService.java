package by.kalilaska.services;

import java.util.List;

import by.kalilaska.beans.AdBean;
import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;

public interface AdService {

	List<AdBean> getAllAdsWithFieldEnabled(boolean enabled);

	List<AdBean> getAdsByAdCategoryWithFieldEnabled(List<AdCategoryEntityHibernate> adCategoryList, boolean enabled);
}
