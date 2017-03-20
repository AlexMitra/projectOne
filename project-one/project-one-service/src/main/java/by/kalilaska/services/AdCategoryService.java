package by.kalilaska.services;

import java.util.List;

import by.kalilaska.beans.AdCategoryBean;
import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;

public interface AdCategoryService {

	AdCategoryEntityHibernate findByCategoryName(String name);

	List<AdCategoryEntityHibernate> findAllCategories();

	List<AdCategoryBean> findAllCategoryNames();
}
