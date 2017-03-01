package by.kalilaska.services;

import java.util.List;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.beans.UserAccountPageBean;

public interface ServiceOne {

	boolean insertNewAccount(AccountDetailsPageBean account);

	String getAccountsByLoginAndEmail(AccountDetailsPageBean account);

	boolean checkAccount(UserAccountPageBean account);

	void test();

	List<AccountBean> getAllAccounts();

	List<AccountBean> getSearchedAccounts(String part, String searchField, String searchPlace, String roles);

	List<String> getAllRoles();

	List<AccountBean> getSelectedRoleAccounts(String roleStatus);

}
