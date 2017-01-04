package by.kalilaska;

import by.kalilaska.beans.AccountForLogInBean;
import by.kalilaska.beans.AccountForRegistrationBean;
import by.kalilaska.beans.AdminAccountPageBean;
import by.kalilaska.beans.UserAccountPageBean;

public interface BeansPool {
	
	public AccountForRegistrationBean getAccountForRegistration();
	
	public AdminAccountPageBean getAdminAccountPageBean();
	
	public UserAccountPageBean getUserAccountPageBean();
	
	public AccountForLogInBean getAccountForLogInBean();

}
