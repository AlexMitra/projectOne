package by.kalilaska.daoHibernate.impls.repositories;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.kalilaska.daoHibernate.impls.entities.AccountRoleEntityHibernate;

@Repository
public class RolesHibernateImpl {

	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}	
	
	public RolesHibernateImpl() {
		super();
	}

	//INSERT
	public void insertRole(String role) {
		currentSession().persist(new AccountRoleEntityHibernate(role));

	}
	
	//DELETE
	public void deleteAccount(String role){
		Session session = currentSession();
		AccountRoleEntityHibernate accountRoleEntity = getAccountRoleByRoleStatus(role);
		
		if(accountRoleEntity != null){
			session.delete(accountRoleEntity);
		}

	}
	
	//SELECT
	public AccountRoleEntityHibernate getAccountRoleById(int id) {		
		Session session = currentSession();
		
		AccountRoleEntityHibernate accountRoleEntity = session.load(
						AccountRoleEntityHibernate.class, Integer.valueOf(id));

		return accountRoleEntity;
	}
	
	public AccountRoleEntityHibernate getAccountRoleByRoleStatus(String	role) {		
		Session session = currentSession();
		TypedQuery<AccountRoleEntityHibernate> query = 
				session.createNamedQuery("getAccountRoleByRoleStatus", AccountRoleEntityHibernate.class);
		query.setParameter("role", role);
		AccountRoleEntityHibernate accountRoleEntity = query.getSingleResult();	

		return accountRoleEntity;
	}
	
	public AccountRoleEntityHibernate getAccountRoleByAccountId(long id) {		

		return null;
	}

}
