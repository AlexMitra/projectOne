package by.kalilaska.services;
import java.util.List;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;


public interface ServiceOne {
	
	public boolean insertNewAccount(UserAccountPageBean account);	
	
	public String getAccountsByLoginAndEmail(UserAccountPageBean account);	
	
	public boolean checkAccount(UserAccountPageBean account);
	
	public void test();
	
	public List<AccountBean> getAllAccounts();

}
