package by.kalilaska.services;

import java.util.List;

import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

public interface RoleService {

	List<RoleEntityHibernate> findAllRoles();

}
