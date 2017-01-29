package by.kalilaska.dao.forHibernate;

import java.util.List;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;

public interface AccountsRepository {
	
	void insertAccount(String login, String email, String password);	
	
	AccountEntityHibernate insertAccountWithReturn(String login, String email, String password);	

	void deleteAccount(String login);	

	AccountEntityHibernate getAccountByLogin(String login);	
	
	AccountEntityHibernate getAccountByEmail(String email);
	
	AccountEntityHibernate getAccountById(long id);
	
	List<AccountEntityHibernate> getAccountsByLoginAndEmail(String login, String email);
	
	RoleEntityHibernate getAccountRoleByAccountId(long id);
	
	List<AccountEntityHibernate> getAllAccounts();

}
