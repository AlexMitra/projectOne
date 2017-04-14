package by.kalilaska.services;

import java.util.List;

import by.kalilaska.beans.AdCategoryBean;
import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;
import by.kalilaska.services.exceptions.AdCategoryExistsException;
import by.kalilaska.services.exceptions.AdCategoryNameExistsException;
import by.kalilaska.services.exceptions.AdCategoryTranslationExistsException;

public interface AdCategoryService {

	AdCategoryBean findByCategoryId(Long id);

	AdCategoryBean findByCategoryName(String name);

	List<AdCategoryEntityHibernate> findAllCategories();

	List<AdCategoryBean> findAllCategoryNames();

	List<AdCategoryBean> findAllCategoriesWithFieldEnabled(boolean enabled);

	List<AdCategoryBean> findAllCategoryNamesWithFieldEnabled(boolean enabled);

	AdCategoryBean createNewAdCategory(AdCategoryBean adCategoryBean) throws AdCategoryExistsException;

	void editAdCategory(AdCategoryBean adCategoryBean)
			throws AdCategoryNameExistsException, AdCategoryTranslationExistsException;

	boolean disableAdCategory(AdCategoryBean adCategoryBean);

	boolean enableAdCategory(AdCategoryBean adCategoryBean);

	boolean deleteAdCategory(long adCategoryId);
}
