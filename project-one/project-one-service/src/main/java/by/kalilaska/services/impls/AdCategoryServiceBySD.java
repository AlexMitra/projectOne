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
	private AdCategoryRepositoryData adCategoryReposidoty;

	public AdCategoryServiceBySD() {
		super();
	}

	@Transactional
	@Override
	public AdCategoryEntityHibernate findByCategoryName(String name) {
		return adCategoryReposidoty.findByAdCategoryName(name);
	}

	@Transactional
	@Override
	public List<AdCategoryEntityHibernate> findAllCategories() {
		return adCategoryReposidoty.findAll();
	}

	@Override
	public List<AdCategoryBean> findAllCategoryNames() {
		List<AdCategoryEntityHibernate> adCategoryEntityList = findAllCategories();
		List<AdCategoryBean> adCategoryBeanList = entityToBeanConverter.convertToBeanList(adCategoryEntityList,
				AdCategoryBean.class);
		return adCategoryBeanList;
	}

}
