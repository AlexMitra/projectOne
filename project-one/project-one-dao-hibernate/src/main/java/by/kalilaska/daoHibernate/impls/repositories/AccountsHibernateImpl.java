package by.kalilaska.daoHibernate.impls.repositories;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.daoHibernate.impls.entities.AccountEntityHibernate;
import by.kalilaska.daoHibernate.impls.entities.AccountRoleEntityHibernate;

@Repository
public class AccountsHibernateImpl {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	private RolesHibernateImpl rolesHibernateImpl;
	
	private AccountRoleEntityHibernate accountRoleUser;
	
	private AccountRoleEntityHibernate accountRoleAdmin;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession(){		
		//System.out.println("sessionFactory: " + sessionFactory);
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
			System.out.println("in try");
		}catch(Exception e){
			session = sessionFactory.openSession();
			System.out.println("in catch");
		}		
		//System.out.println("session: " + session);
		return session;
	}	

	public AccountsHibernateImpl() {		
		super();		
	}

	//!!!!INSERT
	public void insertAccount(String login, String email, String password) {
		AccountEntityHibernate accountEntity = new AccountEntityHibernate(login, email, password);
		accountRoleUser = rolesHibernateImpl.getAccountRoleByRoleStatus("User");
		//accountRoleAdmin = rolesHibernateImpl.getAccountRoleByRoleStatus("Administrator");
		accountEntity.setAccountRole(accountRoleUser);
		
		currentSession().persist(accountEntity);

	}
	
	//!!!!INSERT WITH RETURN
	public AccountEntityHibernate insertAccountWithReturn(String login, String email, String password) {
		AccountEntityHibernate accountEntity = new AccountEntityHibernate(login, email, password);
		accountRoleUser = rolesHibernateImpl.getAccountRoleByRoleStatus("User");
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
//	@Transactional
	public AccountEntityHibernate getAccountByLogin(String login) {
		Session session = currentSession();
		TypedQuery<AccountEntityHibernate> query =
				session.createNamedQuery("getAccountByLogin", AccountEntityHibernate.class);
		query.setParameter("login", login);	

		AccountEntityHibernate accountEntity = query.getSingleResult();
		System.out.println("getAccountByLogin() accountEntity: " + accountEntity);
		return accountEntity;
	}
	
	//SELECT
	public AccountEntityHibernate getAccountByEmail(String email) {
		Session session = currentSession();
		TypedQuery<AccountEntityHibernate> query = 
				session.createNamedQuery("getAccountByEmail", AccountEntityHibernate.class);
		query.setParameter("email", email);
		
		AccountEntityHibernate accountEntity = query.getSingleResult();
		System.out.println("getAccountByEmail() accountEntity: " + accountEntity);
		return accountEntity;
	}
	
	public AccountEntityHibernate getAccountById(long id) {
		Session session = currentSession();
		
		AccountEntityHibernate accountEntity = 
				session.load(AccountEntityHibernate.class, Long.valueOf(id));
		System.out.println("getAccountById() accountEntity: " + accountEntity);

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
