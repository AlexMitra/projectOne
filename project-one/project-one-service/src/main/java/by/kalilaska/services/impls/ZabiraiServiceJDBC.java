package by.kalilaska.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.daoJDBC.AccountsJDBC;
import by.kalilaska.daoJDBC.AccountsToRolesJDBC;
import by.kalilaska.daoJDBC.RolesJDBC;
import by.kalilaska.entities.Account;
import by.kalilaska.entities.AccountEntity;
import by.kalilaska.entities.AccountRoleEntity;
import by.kalilaska.entities.AccountToRoleEntity;
import by.kalilaska.entities.AccountEntity;

@Service
public class ZabiraiServiceJDBC {
	
	@Autowired
	private BeansPool beansPool;
	
	@Autowired
	private AccountsJDBC accountsJdbc;
	
	@Autowired
	private AccountsToRolesJDBC accountsToRolesJdbc;
	
	@Autowired
	private RolesJDBC rolesJdbc;
	
	//TRUE
	public boolean insertNewAccount(UserAccountPageBean account){
		String check = getAccountsByLoginAndEmail(account);
		System.out.println(check);
		
		if(check.equals("login and email are unique")){
			/*accountsJdbc.insertAccount(account.getAccountLogin(),
					account.getAccountEmail(), account.getAccountPassword());
			AccountEntity accountEntity = accountsJdbc.getAccountByLogin(account.getAccountLogin());*/
			
			AccountEntity accountEntity = accountsJdbc.insertAccountWithReturn(
					account.getAccountLogin(), account.getAccountEmail(),
					account.getAccountPassword());
			account.setId(accountEntity.getAccountId());
			
			accountsToRolesJdbc.insertRole(accountEntity.getAccountId(), 3);
			AccountRoleEntity accountRoleEntity = 
					rolesJdbc.getAccountRoleByAccountId(accountEntity.getAccountId());			
			return true;
		}else if(check.equals("this login already exist")){
			account.setLoginCheck(check);
			return false;
		}else if(check.equals("this email already exist")){
			account.setEmailCheck(check);
		}

		return false;
	}
	
	//TRUE
	public String getAccountsByLoginAndEmail(UserAccountPageBean account){
		
		List<AccountEntity> accounts= accountsJdbc.getAccountsByLoginAndEmail(
				account.getAccountLogin(), account.getAccountEmail());
		
		//List<AccountEntity> accounts= accountsJdbc.getAllAccounts();
		
		System.out.println("in service getAccountsByLoginAndEmail() accounts:" + accounts);
		
		if(accounts!=null){
			for (AccountEntity accountEntity : accounts) {
				if(accountEntity.getAccountLogin().equals(account.getAccountLogin())){
					return "this login already exist";
				}
				if(accountEntity.getAccountEmail().equals(account.getAccountEmail())){
					return "this email already exist";
				}
			}			
		}
		return "login and email are unique";		
	}
	
	//TRUE
	public boolean checkAccount(UserAccountPageBean account){
		
		System.out.println("in ZabiraiService checkAccount() account for check: " + account);
		
		AccountEntity accountEntity = accountsJdbc.getAccountByLogin(account.getAccountLogin());
		//System.out.println("in ZabiraiService checkAccount() accountEntity: " + accountEntity);
		
		if(accountEntity==null){
			account.setLoginCheck("this login does not exist");
			return false;
		}else if(!accountEntity.getAccountPassword().equals(account.getAccountPassword())){
			account.setPasswordCheck("incorrect password");
			return false;
		}else{
			account.setId(accountEntity.getAccountId());
			account.setAccountEmail(accountEntity.getAccountEmail());
			AccountToRoleEntity accountToRoleEntity = 
					accountsToRolesJdbc.getAccountToRoleByAccountId(accountEntity.getAccountId());
			AccountRoleEntity accountRoleEntity = rolesJdbc.getAccountRoleById(accountToRoleEntity.getFkRoleId());
			account.setStatus(accountRoleEntity.getRoleStatus());
			System.out.println("in ZabiraiService checkAccount() account after check: " + account);
			return true;
		}		
	}
	
	public void test(){
		/*try{
			System.out.println(accountsJdbc.getAccountByLogin("Megathrone"));
		}catch(Exception e){
			System.out.println("Exception in getAccountByLogin()");
		}
		
		try{
			System.out.println(accountsJdbc.getAccountByEmail("Optimus@tut.by"));
		}catch(Exception e){
			System.out.println("Exception in getAccountByEmail()");
		}
		
		try{
			System.out.println(accountsJdbc.getAccountById(3));
		}catch(Exception e){
			System.out.println("Exception in getAccountById()");
		}*/		
		
	}
	

}
