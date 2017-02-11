package by.kalilaska.daoHibernate.repositories.springData;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

@Repository
public interface AccountsRepositoryData 
					extends JpaRepository<AccountEntityHibernate, Long>{
		
	//SELECT		
	AccountEntityHibernate findByAccountLogin(String login);
		
	//SELECT		
	AccountEntityHibernate findByAccountEmail(String email);

	////SELECT BY LOGIN AND EMAIL		
	List<AccountEntityHibernate> findByAccountLoginOrAccountEmail(String login, String email);
	
	List<AccountEntityHibernate> findByAccountLoginStartingWith(String reg);
	
	List<AccountEntityHibernate> findByAccountEmailStartingWith(String reg);
	
	List<AccountEntityHibernate> findByAccountLoginContaining(String reg);
	
	List<AccountEntityHibernate> findByAccountEmailContaining(String reg);

}
