package by.kalilaska.beans;

import org.springframework.stereotype.Component;

import by.kalilaska.interfaces.Entity;
import by.kalilaska.interfaces.Pool;

@Component
public class EntitiesPool implements Pool{
	
	/*public static Account getAccount(){
		return new Account();
	}*/
	
	public Entity getAccount(){
		return new Account();
	}

}
