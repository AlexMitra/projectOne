package by.kalilaska.entities.impls;

import org.springframework.stereotype.Component;

import by.kalilaska.EntitiesPool;
import by.kalilaska.entities.impls.AccountEntity;
import by.kalilaska.entities.impls.AccountRoleEntity;
import by.kalilaska.entities.impls.AccountToRoleEntity;

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
