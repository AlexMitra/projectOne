package by.kalilaska.daoHibernate.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

@Repository
public class RolesRepositoryHibernate {	
	
	@PersistenceContext
	private EntityManager manager;
	
	public RolesRepositoryHibernate() {
		super();
	}

	//INSERT
	public void insertRole(String role) {
		manager.persist(new RoleEntityHibernate(role));

	}
	
	//DELETE
	public void deleteAccount(String role){		
		RoleEntityHibernate accountRoleEntity = getAccountRoleByRoleStatus(role);
		
		if(accountRoleEntity != null){
			manager.remove(accountRoleEntity);
		}
	}
	
	//SELECT
	public RoleEntityHibernate getAccountRoleById(int id) {		
		RoleEntityHibernate accountRoleEntity = manager.find(
						RoleEntityHibernate.class, Integer.valueOf(id));

		return accountRoleEntity;		
	}
	
	public RoleEntityHibernate getAccountRoleByRoleStatus(String role) {		
		TypedQuery<RoleEntityHibernate> query = 
				manager.createNamedQuery("getAccountRoleByRoleStatus", RoleEntityHibernate.class);
		query.setParameter("role", role);
		RoleEntityHibernate accountRoleEntity = query.getSingleResult();	

		return accountRoleEntity;		
	}
	
	public RoleEntityHibernate getAccountRoleByAccountId(long id) {		

		return null;
	}

}
