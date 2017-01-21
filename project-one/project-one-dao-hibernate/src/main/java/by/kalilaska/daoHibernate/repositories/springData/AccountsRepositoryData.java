package by.kalilaska.daoHibernate.repositories.springData;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import by.kalilaska.entities.forHibernate.AccountEntityHibernate;

public interface AccountsRepositoryData 
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
