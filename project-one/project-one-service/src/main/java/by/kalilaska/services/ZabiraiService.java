package by.kalilaska.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.AccountForLogInBean;
import by.kalilaska.beans.AccountForRegistrationBean;
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
public class ZabiraiService {
	
	@Autowired
	private BeansPool beansPool;
	
	@Autowired
	private AccountsJDBC accountsJdbc;
	
	@Autowired
	private AccountsToRolesJDBC accountsToRolesJdbc;
	
	@Autowired
	private RolesJDBC rolesJdbc;
	
	public boolean insertNewAccount(AccountForRegistrationBean account){
		String check = getAccountsByLoginAndEmail(account);
		System.out.println(check);
		
		if(check.equals("login and email are unique")){
			accountsJdbc.insertAccount(account.getAccountLogin(),
					account.getAccountEmail(), account.getAccountPassword());			
			return true;
		}else if(check.equals("this login already exist")){
			account.setLoginCheck(check);
			return false;
		}else if(check.equals("this email already exist")){
			account.setEmailCheck(check);
		}

		return false;
	}
	
	public String getAccountsByLoginAndEmail(AccountForRegistrationBean account){
		
		/*List<AccountEntity> accounts= accountsJdbc.getAccountsByLoginAndEmail(
				account.getAccountLogin(), account.getAccountEmail());*/
		
		List<AccountEntity> accounts= accountsJdbc.getAllAccounts();
		
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
	
	public UserAccountPageBean getUserAccountPageBean(AccountForRegistrationBean account){
		UserAccountPageBean userAccountPageBean  = beansPool.getUserAccountPageBean();
		
		AccountEntity accountEntity = accountsJdbc.getAccountByLogin(account.getAccountLogin());
		
		//System.out.println("in service getUserAccountPageBean() accountEntity: " + accountEntity);
		
		userAccountPageBean.setId(accountEntity.getAccountId());
		userAccountPageBean.setAccountLogin(accountEntity.getAccountLogin());
		userAccountPageBean.setAccountEmail(accountEntity.getAccountEmail());
		userAccountPageBean.setAccountPassword(accountEntity.getAccountPassword());
		
		accountsToRolesJdbc.insertRole(3, accountEntity.getAccountId());
		
		AccountToRoleEntity accountToRoleEntity = 
				accountsToRolesJdbc.getAccountToRoleByAccountId(accountEntity.getAccountId());	
//		AccountToRoleEntity accountToRoleEntity = 
//		accountsToRolesJdbc.getAccountToRoleByAccountId(1);
		//System.out.println("in service getUserAccountPageBean() accountToRoleEntity: " + accountToRoleEntity);
		
		AccountRoleEntity accountRoleEntity = rolesJdbc.getAccountRoleById(accountToRoleEntity.getFkRoleId());
		
		//System.out.println("in service getUserAccountPageBean() accountRoleEntity: " + accountRoleEntity);
		
		userAccountPageBean.setStatus(accountRoleEntity.getRoleRole());
		
		return userAccountPageBean;
		
	}
	
	public UserAccountPageBean getUserAccountPageBean(AccountForLogInBean account){
		UserAccountPageBean userAccountPageBean  = beansPool.getUserAccountPageBean();
		
		AccountEntity accountEntity = accountsJdbc.getAccountByLogin(account.getAccountLogin());
		
		//System.out.println("in service getUserAccountPageBean() accountEntity: " + accountEntity);
		
		userAccountPageBean.setId(accountEntity.getAccountId());
		userAccountPageBean.setAccountLogin(accountEntity.getAccountLogin());
		userAccountPageBean.setAccountEmail(accountEntity.getAccountEmail());
		userAccountPageBean.setAccountPassword(accountEntity.getAccountPassword());
		
		AccountToRoleEntity accountToRoleEntity = 
				accountsToRolesJdbc.getAccountToRoleByAccountId(accountEntity.getAccountId());	
//		AccountToRoleEntity accountToRoleEntity = 
//		accountsToRolesJdbc.getAccountToRoleByAccountId(1);
		//System.out.println("in service getUserAccountPageBean() accountToRoleEntity: " + accountToRoleEntity);
		
		AccountRoleEntity accountRoleEntity = rolesJdbc.getAccountRoleById(accountToRoleEntity.getFkRoleId());
		
		//System.out.println("in service getUserAccountPageBean() accountRoleEntity: " + accountRoleEntity);
		
		userAccountPageBean.setStatus(accountRoleEntity.getRoleRole());
		
		return userAccountPageBean;
		
	}
	
	public boolean checkAccount(AccountForLogInBean account){
		
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
			AccountToRoleEntity accountToRoleEntity = 
					accountsToRolesJdbc.getAccountToRoleByAccountId(accountEntity.getAccountId());
			AccountRoleEntity accountRoleEntity = rolesJdbc.getAccountRoleById(accountToRoleEntity.getFkRoleId());
			account.setStatus(accountRoleEntity.getRoleRole());
			System.out.println("in ZabiraiService checkAccount() account after check: " + account);
			return true;
		}		
	}
	

}
