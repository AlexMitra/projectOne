package by.kalilaska.beans;

import org.springframework.stereotype.Component;

import by.kalilaska.BeansPool;

@Component
public class BeansPoolImpl implements BeansPool{
	
	public AccountBean getAccount(){
		return new AccountBean();
	}

}
