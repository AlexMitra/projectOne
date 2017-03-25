package by.kalilaska.daoHibernate.repositories.springData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;

public interface AdCategoryRepositoryData extends JpaRepository<AdCategoryEntityHibernate, Long> {

	AdCategoryEntityHibernate findByAdCategoryName(String name);

	List<AdCategoryEntityHibernate> findByAdCategoryEnabled(boolean enabled);

	AdCategoryEntityHibernate findByAdCategoryNameAndAdCategoryEnabled(String name, boolean enabled);

}
