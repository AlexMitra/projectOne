package by.kalilaska.daoHibernate.impls.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.kalilaska.daoHibernate.impls.entities.AccountRoleEntityHibernate;

@Repository
public class RolesHibernateImpl {	
	
	@PersistenceContext
	private EntityManager manager;
	
	public RolesHibernateImpl() {
		super();
	}

	//INSERT
	public void insertRole(String role) {
		manager.persist(new AccountRoleEntityHibernate(role));

	}
	
	//DELETE
	public void deleteAccount(String role){		
		AccountRoleEntityHibernate accountRoleEntity = getAccountRoleByRoleStatus(role);
		
		if(accountRoleEntity != null){
			manager.remove(accountRoleEntity);
		}
	}
	
	//SELECT
	public AccountRoleEntityHibernate getAccountRoleById(int id) {		
		AccountRoleEntityHibernate accountRoleEntity = manager.find(
						AccountRoleEntityHibernate.class, Integer.valueOf(id));

		return accountRoleEntity;		
	}
	
	public AccountRoleEntityHibernate getAccountRoleByRoleStatus(String	role) {		
		TypedQuery<AccountRoleEntityHibernate> query = 
				manager.createNamedQuery("getAccountRoleByRoleStatus", AccountRoleEntityHibernate.class);
		query.setParameter("role", role);
		AccountRoleEntityHibernate accountRoleEntity = query.getSingleResult();	

		return accountRoleEntity;		
	}
	
	public AccountRoleEntityHibernate getAccountRoleByAccountId(long id) {		

		return null;
	}

}
