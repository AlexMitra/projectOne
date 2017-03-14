package by.kalilaska.services;

import java.util.List;

import by.kalilaska.beans.RoleBean;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

public interface RoleService {

	RoleEntityHibernate findByRoleStatus(String role);

	List<RoleEntityHibernate> findAllRoles();

	List<RoleBean> findAllRoleNames();

}
