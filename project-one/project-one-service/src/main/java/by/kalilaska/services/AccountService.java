package by.kalilaska.services;

import java.util.List;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;

public interface AccountService {

	AccountEntityHibernate findByAccountLogin(String login);

	List<AccountBean> getAllAccounts();

	// List<AccountBean> getSearchedAccounts(String part, String searchField,
	// String searchPlace, String roles);

	// List<AccountBean> getSelectedRoleAccounts(String[] roleStatus);

	// List<AccountBean> getSelectedLoginAccounts(String accountLoginPart);

	// List<AccountBean> getSelectedEmailAccounts(String accountEmailPart);

	// List<AccountBean> getSelectedLoginAndRoleAccounts(String
	// accountLoginPart, List<RoleEntityHibernate> roleList);

	// List<AccountBean> getSelectedEmailAndRoleAccounts(String
	// accountEmailPArt, List<RoleEntityHibernate> roleList);

	// void test();

}
