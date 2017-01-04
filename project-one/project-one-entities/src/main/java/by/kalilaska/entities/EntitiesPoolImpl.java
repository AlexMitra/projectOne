package by.kalilaska.entities;

import org.springframework.stereotype.Component;

import by.kalilaska.EntitiesPool;
import by.kalilaska.entities.AccountEntity;
import by.kalilaska.entities.AccountRoleEntity;
import by.kalilaska.entities.AccountToRoleEntity;

@Component
public class EntitiesPoolImpl implements EntitiesPool{
	
	@Override
	public AccountEntity getAccount(){
		return new AccountEntity();
	}

	@Override
	public AccountRoleEntity getRole() {
		
		return new AccountRoleEntity();
	}

	@Override
	public AccountToRoleEntity getAccountToRole() {
		
		return new AccountToRoleEntity();
	}

}
