package by.kalilaska.daoHibernateImpl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.kalilaska.entitiesHibernate.AccountEntityHibernate;
import by.kalilaska.entitiesHibernate.AccountRoleEntityHibernate;


//@Repository
public class AccountsHibernateImpl {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	private RolesHibernateImpl rolesHibernateImpl;
	
	private AccountRoleEntityHibernate accountRoleUser = 
			rolesHibernateImpl.getAccountRoleByRoleStatus("User");
	
	private AccountRoleEntityHibernate accountRoleAdmin = 
			rolesHibernateImpl.getAccountRoleByRoleStatus("Administrator");

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	//!!!!INSERT
	public void insertAccount(String login, String email, String password) {
		AccountEntityHibernate accountEntity = new AccountEntityHibernate(login, email, password);
		accountEntity.setAccountRole(accountRoleUser);
		
		currentSession().persist(accountEntity);

	}
	
	//!!!!INSERT WITH RETURN
	public AccountEntityHibernate insertAccountWithReturn(String login, String email, String password) {
		AccountEntityHibernate accountEntity = new AccountEntityHibernate(login, email, password);
		accountEntity.setAccountRole(accountRoleUser);
		currentSession().persist(accountEntity);	
		
		return getAccountByLogin(login);
	}
	
	//DELETE
	public void deleteAccount(String login){
		Session session = currentSession();		
		AccountEntityHibernate accountEntity = getAccountByLogin(login);
		
		if(accountEntity != null){
			session.delete(accountEntity);
		}

	}
	
	//SELECT
	public AccountEntityHibernate getAccountByLogin(String login) {
		Session session = currentSession();
		TypedQuery<AccountEntityHibernate> query = 
				session.createNamedQuery("getAccountByLogin", AccountEntityHibernate.class);
		query.setParameter("login", login);
		
		AccountEntityHibernate accountEntity = query.getSingleResult();
		return accountEntity;
	}
	//SELECT
	public AccountEntityHibernate getAccountByEmail(String email) {
		Session session = currentSession();
		TypedQuery<AccountEntityHibernate> query = 
				session.createNamedQuery("getAccountByEmail", AccountEntityHibernate.class);
		query.setParameter("email", email);
		
		AccountEntityHibernate accountEntity = query.getSingleResult();
		return accountEntity;
	}
	
	public AccountEntityHibernate getAccountById(long id) {
		Session session = currentSession();
		
		AccountEntityHibernate accountEntity = 
				session.load(AccountEntityHibernate.class, Long.valueOf(id));

		return accountEntity;
	}	

	////SELECT BY LOGIN AND EMAIL
	public List<AccountEntityHibernate> getAccountsByLoginAndEmail(String login, String email) {
		Session session = currentSession();
		TypedQuery<AccountEntityHibernate> query = 
				session.createNamedQuery("getAccountsByLoginAndEmail", AccountEntityHibernate.class);
		query.setParameter("login", login);
		query.setParameter("email", email);
		
		List<AccountEntityHibernate> accountEntityList = query.getResultList();
		return accountEntityList;
	}
	
	//SELECT ALL
	public List<AccountEntityHibernate> getAllAccounts() {
		Session session = currentSession();
		TypedQuery<AccountEntityHibernate> query = 
				session.createNamedQuery("getAllAccounts", AccountEntityHibernate.class);
		List<AccountEntityHibernate> accountEntityList = query.getResultList();

		return accountEntityList;
	}	


}
