package by.kalilaska.daoHibernate.impls.repositories;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import by.kalilaska.daoHibernate.impls.entities.AccountEntityHibernate;

public interface AccountsRepositoryHibernate 
					extends JpaRepository<AccountEntityHibernate, Long>{
	
//	public AccountEntityHibernate getAccountByLogin(String login) {
//		Session session = currentSession();
//		TypedQuery<AccountEntityHibernate> query =
//				session.createNamedQuery("getAccountByLogin", AccountEntityHibernate.class);
//		query.setParameter("login", login);	
//
//		AccountEntityHibernate accountEntity = query.getSingleResult();
//		System.out.println("getAccountByLogin() accountEntity: " + accountEntity);
//		return accountEntity;
//	}

}
