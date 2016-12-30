package by.kalilaska.entities;

import org.springframework.stereotype.Component;

import by.kalilaska.Pool;

@Component
public class EntitiesPool implements Pool{
	
	/*public static Account getAccount(){
		return new Account();
	}*/
	
	public Account getAccount(){
		return new Account();
	}

}
