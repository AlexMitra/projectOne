package by.kalilaska.daoHibernate.repositories.springData;

import org.springframework.data.jpa.repository.JpaRepository;

import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;

public interface AdCategoryRepositoryData extends JpaRepository<AdCategoryEntityHibernate, Long> {

	AdCategoryEntityHibernate findByAdCategoryName(String name);

}
