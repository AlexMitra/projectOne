package by.kalilaska.entities;

import org.springframework.stereotype.Component;

import by.kalilaska.EntitiesPool;

@Component
public class EntitiesPoolImpl implements EntitiesPool{
	
	/*public static Account getAccount(){
		return new Account();
	}*/
	
	public Account getAccount(){
		return new Account();
	}

}
