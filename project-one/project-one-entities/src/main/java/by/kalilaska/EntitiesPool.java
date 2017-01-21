package by.kalilaska;

import by.kalilaska.entities.impls.Account;
import by.kalilaska.entities.impls.AccountEntity;
import by.kalilaska.entities.impls.AccountRoleEntity;
import by.kalilaska.entities.impls.AccountToRoleEntity;

public interface EntitiesPool {
	
	AccountEntity getAccount();
	
	AccountRoleEntity getRole();
	
	AccountToRoleEntity getAccountToRole();

}
