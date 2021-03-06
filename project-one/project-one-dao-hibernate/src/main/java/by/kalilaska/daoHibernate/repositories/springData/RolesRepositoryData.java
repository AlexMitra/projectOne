package by.kalilaska.daoHibernate.repositories.springData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

@Repository
public interface RolesRepositoryData extends JpaRepository<RoleEntityHibernate, Integer> {

	RoleEntityHibernate findByRoleStatus(String role);

	// RoleEntityHibernate findByRoleId(Integer roleId);

}
