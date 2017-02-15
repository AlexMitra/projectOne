package by.kalilaska.daoHibernate.repositories.springData;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	List<AccountEntityHibernate> findByAccountRole(String role);
	
	////SELECT BY LOGIN AND EMAIL AND ROLE	
	
//	List<AccountEntityHibernate> findByAccountLoginStartingWithAndAccountRole(String reg, String role);
//	
//	List<AccountEntityHibernate> findByAccountEmailStartingWithAndAccountRole(String reg, String role);
//	
//	List<AccountEntityHibernate> findByAccountLoginContainingAndAccountRole(String reg, String role);
//	
//	List<AccountEntityHibernate> findByAccountEmailContainingAndAccountRole(String reg, String role);
	
	@Query("select a from AccountEntityHibernate a where a.accountLogin like :login and a.accountRole = :role")
	List<AccountEntityHibernate> findByAccountLoginAndAccountRole(
			@Param("login") String reg, @Param("role") String role);
	
	@Query("select a from AccountEntityHibernate a where a.accountEmail like :email and a.accountRole = :role")
	List<AccountEntityHibernate> findByAccountEmailAndAccountRole(
			@Param("email") String reg, @Param("role") String role);

}
