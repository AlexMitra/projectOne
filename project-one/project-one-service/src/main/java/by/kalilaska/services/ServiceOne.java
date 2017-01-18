package by.kalilaska.services;
import by.kalilaska.beans.UserAccountPageBean;


public interface ServiceOne {
	
	public boolean insertNewAccount(UserAccountPageBean account);	
	
	public String getAccountsByLoginAndEmail(UserAccountPageBean account);	
	
	public boolean checkAccount(UserAccountPageBean account);
	
	public void test();

}
