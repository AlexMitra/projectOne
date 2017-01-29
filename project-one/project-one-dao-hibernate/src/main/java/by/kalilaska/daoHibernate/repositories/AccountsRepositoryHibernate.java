package by.kalilaska.daoHibernate.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.entities.impls.AccountRoleEntity;
import by.kalilaska.dao.forHibernate.AccountsRepository;;

@Repository

public class AccountsRepositoryHibernate implements AccountsRepository{	

	@PersistenceContext
	EntityManager manager;
	
	@Autowired
	private RolesRepositoryHibernate rolesHibernate;
	
	private RoleEntityHibernate roleUser;
	
	private RoleEntityHibernate roleAdmin;

	public AccountsRepositoryHibernate() {		
		super();		
	}
	
	private RoleEntityHibernate getRoleUser(){
		if(roleUser==null){
			roleUser = rolesHibernate.getAccountRoleByRoleStatus("User");
		}
		return roleUser;
		
	}
	
	private RoleEntityHibernate getRoleAdmin(){
		if(roleAdmin==null){
			roleAdmin = rolesHibernate.getAccountRoleByRoleStatus("Administrator");
		}
		return roleAdmin;
		
	}

	//!!!!INSERT
	@Override
	public void insertAccount(String login, String email, String password) {
		AccountEntityHibernate accountEntity = new AccountEntityHibernate(login, email, password);		
		accountEntity.setAccountRole(getRoleUser());		
		manager.persist(accountEntity);

	}
	
	//!!!!INSERT WITH RETURN
	@Override	
	public AccountEntityHibernate insertAccountWithReturn(String login, String email, String password) {
		AccountEntityHibernate accountEntity = new AccountEntityHibernate(login, email, password);		
		accountEntity.setAccountRole(getRoleUser());		
		manager.persist(accountEntity);
		return getAccountByLogin(login);
	}
	
	//DELETE
	@Override
	public void deleteAccount(String login){			
		AccountEntityHibernate accountEntity = getAccountByLogin(login);		
		if(accountEntity != null){
			manager.remove(accountEntity);
		}

	}
	
	//SELECT
	@Override
	public AccountEntityHibernate getAccountByLogin(String login) {		
		TypedQuery<AccountEntityHibernate> query =
				manager.createNamedQuery("getAccountByLogin", AccountEntityHibernate.class);
		query.setParameter("login", login);
		AccountEntityHibernate accountEntity;

		try{
			accountEntity = query.getSingleResult();
		}catch(javax.persistence.NoResultException e){
			return null;
		}		

		System.out.println("getAccountByLogin() accountEntity: " + accountEntity);
		return accountEntity;
	}
	
	//SELECT
	@Override
	public AccountEntityHibernate getAccountByEmail(String email) {		
		TypedQuery<AccountEntityHibernate> query = 
				manager.createNamedQuery("getAccountByEmail", AccountEntityHibernate.class);
		query.setParameter("email", email);
		AccountEntityHibernate accountEntity;
		
		try{
			accountEntity = query.getSingleResult();
		}catch(javax.persistence.NoResultException e){
			return null;
		}	
		System.out.println("getAccountByEmail() accountEntity: " + accountEntity);
		return accountEntity;		
	}
	
	@Override
	public AccountEntityHibernate getAccountById(long id) {		
		AccountEntityHibernate accountEntity;
		try{
			accountEntity = manager.find(AccountEntityHibernate.class, Long.valueOf(id));
		}catch(javax.persistence.NoResultException e){
			return null;
		}
				
		System.out.println("getAccountById() accountEntity: " + accountEntity);
		return accountEntity;		
	}	

	////SELECT BY LOGIN AND EMAIL
	@Override
	public List<AccountEntityHibernate> getAccountsByLoginAndEmail(String login, String email) {		
		TypedQuery<AccountEntityHibernate> query = 
				manager.createNamedQuery("getAccountsByLoginAndEmail", AccountEntityHibernate.class);
		query.setParameter("login", login);
		query.setParameter("email", email);
		
		List<AccountEntityHibernate> accountEntityList;
		try{
			accountEntityList = query.getResultList();
		}catch(javax.persistence.NoResultException e){
			return null;
		}
		
		return accountEntityList;		
	}
	
	@Override
	public RoleEntityHibernate getAccountRoleByAccountId(long id) {
		AccountEntityHibernate accountEntity = getAccountById(id);
		return accountEntity.getAccountRole();
	}
	
	//SELECT ALL
	@Override
	public List<AccountEntityHibernate> getAllAccounts() {		
		TypedQuery<AccountEntityHibernate> query = 
				manager.createNamedQuery("getAllAccounts", AccountEntityHibernate.class);		
		List<AccountEntityHibernate> accountEntityList;
		try{
			accountEntityList = query.getResultList();
		}catch(javax.persistence.NoResultException e){
			return null;
		}		

		return accountEntityList;		
	}

}
