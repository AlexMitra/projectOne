package by.kalilaska.services;
import java.util.List;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;


public interface ServiceOne {
	
	boolean insertNewAccount(UserAccountPageBean account);	
	
	String getAccountsByLoginAndEmail(UserAccountPageBean account);	
	
	boolean checkAccount(UserAccountPageBean account);
	
	void test();
	
	List<AccountBean> getAllAccounts();
	
	List<AccountBean> getSearchedAccounts(String part, String searchField, String searchPlace);

}
