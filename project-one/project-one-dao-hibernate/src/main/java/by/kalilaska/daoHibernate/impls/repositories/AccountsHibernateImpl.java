package by.kalilaska.daoHibernate.impls.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

	@PersistenceContext
	EntityManager manager;
	
	@Autowired
	private RolesHibernateImpl rolesHibernateImpl;
	
	private AccountRoleEntityHibernate accountRoleUser;
	
	private AccountRoleEntityHibernate accountRoleAdmin;

	public AccountsHibernateImpl() {		
		super();		
	}

	//!!!!INSERT
	public void insertAccount(String login, String email, String password) {
		AccountEntityHibernate accountEntity = new AccountEntityHibernate(login, email, password);
		accountRoleUser = rolesHibernateImpl.getAccountRoleByRoleStatus("User");
		//accountRoleAdmin = rolesHibernateImpl.getAccountRoleByRoleStatus("Administrator");
		accountEntity.setAccountRole(accountRoleUser);
		
		manager.persist(accountEntity);

	}
	
	//!!!!INSERT WITH RETURN
	public AccountEntityHibernate insertAccountWithReturn(String login, String email, String password) {
		AccountEntityHibernate accountEntity = new AccountEntityHibernate(login, email, password);
		accountRoleUser = rolesHibernateImpl.getAccountRoleByRoleStatus("User");
		accountEntity.setAccountRole(accountRoleUser);			
		
		return getAccountByLogin(login);
	}
	
	//DELETE
	public void deleteAccount(String login){			
		AccountEntityHibernate accountEntity = getAccountByLogin(login);
		
		if(accountEntity != null){
			manager.remove(accountEntity);
		}

	}
	
	//SELECT
//	@Transactional
	public AccountEntityHibernate getAccountByLogin(String login) {		
		TypedQuery<AccountEntityHibernate> query =
				manager.createNamedQuery("getAccountByLogin", AccountEntityHibernate.class);
		query.setParameter("login", login);	

		AccountEntityHibernate accountEntity = query.getSingleResult();
		System.out.println("getAccountByLogin() accountEntity: " + accountEntity);
		return accountEntity;
	}
	
	//SELECT
	public AccountEntityHibernate getAccountByEmail(String email) {		
		TypedQuery<AccountEntityHibernate> query = 
				manager.createNamedQuery("getAccountByEmail", AccountEntityHibernate.class);
		query.setParameter("email", email);
		
		AccountEntityHibernate accountEntity = query.getSingleResult();
		System.out.println("getAccountByEmail() accountEntity: " + accountEntity);
		return accountEntity;		
	}
	
	public AccountEntityHibernate getAccountById(long id) {		
		AccountEntityHibernate accountEntity = 
				manager.find(AccountEntityHibernate.class, Long.valueOf(id));
		System.out.println("getAccountById() accountEntity: " + accountEntity);

		return accountEntity;		
	}	

	////SELECT BY LOGIN AND EMAIL
	public List<AccountEntityHibernate> getAccountsByLoginAndEmail(String login, String email) {		
		TypedQuery<AccountEntityHibernate> query = 
				manager.createNamedQuery("getAccountsByLoginAndEmail", AccountEntityHibernate.class);
		query.setParameter("login", login);
		query.setParameter("email", email);
		
		List<AccountEntityHibernate> accountEntityList = query.getResultList();
		return accountEntityList;
	}
	
	//SELECT ALL
	public List<AccountEntityHibernate> getAllAccounts() {		
		TypedQuery<AccountEntityHibernate> query = 
				manager.createNamedQuery("getAllAccounts", AccountEntityHibernate.class);
		List<AccountEntityHibernate> accountEntityList = query.getResultList();

		return accountEntityList;		
	}

}
