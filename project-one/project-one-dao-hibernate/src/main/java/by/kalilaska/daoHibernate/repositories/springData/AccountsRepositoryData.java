package by.kalilaska.daoHibernate.repositories.springData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

@Repository
public interface AccountsRepositoryData extends JpaRepository<AccountEntityHibernate, Long> {

	// SELECT
	AccountEntityHibernate findByAccountLogin(String login);

	// SELECT
	AccountEntityHibernate findByAccountEmail(String email);

	//// SELECT BY LOGIN AND EMAIL
	List<AccountEntityHibernate> findByAccountEnabled(boolean enabled);

	List<AccountEntityHibernate> findByAccountLoginOrAccountEmail(String login, String email);

	List<AccountEntityHibernate> findByAccountLoginLikeAndAccountEnabled(String reg, boolean enabled);

	List<AccountEntityHibernate> findByAccountEmailLikeAndAccountEnabled(String reg, boolean enabled);

	List<AccountEntityHibernate> findByAccountRolesInAndAccountEnabled(List<RoleEntityHibernate> roles,
			boolean enabled);

	List<AccountEntityHibernate> findByAccountLoginLikeAndAccountRolesInAndAccountEnabled(String reg,
			List<RoleEntityHibernate> roles, boolean enabled);

	List<AccountEntityHibernate> findByAccountEmailLikeAndAccountRolesInAndAccountEnabled(String reg,
			List<RoleEntityHibernate> roles, boolean enabled);

}
