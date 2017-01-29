package by.kalilaska.dao.forHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

public interface RolesRepository {

	void insertRole(String role);	
	
	void deleteAccount(String role);	
	
	RoleEntityHibernate getAccountRoleById(int id);
	
	RoleEntityHibernate getAccountRoleByRoleStatus(String role);	

}
