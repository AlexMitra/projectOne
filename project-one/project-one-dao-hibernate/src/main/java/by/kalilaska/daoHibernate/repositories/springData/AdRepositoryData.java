package by.kalilaska.daoHibernate.repositories.springData;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.kalilaska.entities.forHibernate.AdCategoryEntityHibernate;
import by.kalilaska.entities.forHibernate.AdEntityHibernate;

@Repository
public interface AdRepositoryData extends JpaRepository<AdEntityHibernate, Long> {

	List<AdEntityHibernate> findByAdEnabledOrderByAdCreationDateDesc(boolean enabled, Pageable pageable);

	List<AdEntityHibernate> findByAdEnabled(boolean enabled);

	List<AdEntityHibernate> findByAdEnabledAndAdCategoryInOrderByAdCreationDateDesc(boolean enabled,
			List<AdCategoryEntityHibernate> categories, Pageable pageable);

	Long countByAdEnabled(boolean enabled);

	Long countByAdEnabledAndAdCategoryIn(boolean enabled, List<AdCategoryEntityHibernate> adCategoryEntityList);

}
