package by.kalilaska.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kalilaska.Pool;
import by.kalilaska.entities.Account;

@Service
public class ZabiraiService {
	
	@Autowired
	private Pool entitiesPool;
	
	private Account getAccount(){
		return entitiesPool.getAccount();
	}

}
