package by.kalilaska.beans;

import org.springframework.stereotype.Component;
import by.kalilaska.BeansPool;

@Component
public class BeansPoolImpl implements BeansPool{

	@Override
	public AdminAccountPageBean getAdminAccountPageBean() {
		return new AdminAccountPageBean();
	}

	@Override
	public UserAccountPageBean getUserAccountPageBean() {
		return new UserAccountPageBean();
	}

}
