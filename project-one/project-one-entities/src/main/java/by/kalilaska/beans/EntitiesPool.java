package by.kalilaska.beans;

import by.kalilaska.interfaces.Entity;

public class EntitiesPool {
	
	public static Entity getAccount(){
		return new Account();
	}

}
