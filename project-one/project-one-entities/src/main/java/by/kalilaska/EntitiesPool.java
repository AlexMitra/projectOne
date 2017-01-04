package by.kalilaska;

import by.kalilaska.entities.AccountEntity;
import by.kalilaska.entities.AccountRoleEntity;
import by.kalilaska.entities.AccountToRoleEntity;
import by.kalilaska.entities.Account;

public interface EntitiesPool {
	
	AccountEntity getAccount();
	
	AccountRoleEntity getRole();
	
	AccountToRoleEntity getAccountToRole();

}
