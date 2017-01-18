package by.kalilaska.daoHibernate.impls.repositories;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.kalilaska.daoHibernate.impls.entities.RoleEntityHibernate;

@Repository
public class RolesHibernateImpl2 {

	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}	
	
	public RolesHibernateImpl2() {
		super();
	}

	//INSERT
	public void insertRole(String role) {
		currentSession().persist(new RoleEntityHibernate(role));

	}
	
	//DELETE
	public void deleteAccount(String role){
		Session session = currentSession();
		RoleEntityHibernate accountRoleEntity = getAccountRoleByRoleStatus(role);
		
		if(accountRoleEntity != null){
			session.delete(accountRoleEntity);
		}

	}
	
	//SELECT
	public RoleEntityHibernate getAccountRoleById(int id) {		
		Session session = currentSession();
		
		RoleEntityHibernate accountRoleEntity = session.load(
						RoleEntityHibernate.class, Integer.valueOf(id));

		return accountRoleEntity;
	}
	
	public RoleEntityHibernate getAccountRoleByRoleStatus(String	role) {		
		Session session = currentSession();
		TypedQuery<RoleEntityHibernate> query = 
				session.createNamedQuery("getAccountRoleByRoleStatus", RoleEntityHibernate.class);
		query.setParameter("role", role);
		RoleEntityHibernate accountRoleEntity = query.getSingleResult();	

		return accountRoleEntity;
	}
	
	public RoleEntityHibernate getAccountRoleByAccountId(long id) {		

		return null;
	}

}
