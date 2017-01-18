package by.kalilaska.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.daoHibernate.impls.entities.AccountEntityHibernate;
import by.kalilaska.daoHibernate.impls.entities.AccountEntityHibernate2;
import by.kalilaska.daoHibernate.impls.repositories.AccountsHibernateImpl;
import by.kalilaska.daoHibernate.impls.repositories.AccountsHibernateImpl2;
import by.kalilaska.daoHibernate.impls.repositories.RolesHibernateImpl;
import by.kalilaska.services.ServiceOne;

@Service
public class ZabiraiServiceHibernate implements ServiceOne{
	
	@Autowired
	private BeansPool beansPool;
	
	@Autowired
	private AccountsHibernateImpl accountsHibernate;
	
	@Autowired
	private RolesHibernateImpl rolesHibernate;
	
	//TRUE
	@Override
	public boolean insertNewAccount(UserAccountPageBean account){
		/*String check = getAccountsByLoginAndEmail(account);
		System.out.println(check);
		
		if(check.equals("login and email are unique")){
			
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
		}*/

		return false;
	}
	
	//TRUE
	@Override
	public String getAccountsByLoginAndEmail(UserAccountPageBean account){
		
		/*List<AccountEntity> accounts= accountsJdbc.getAccountsByLoginAndEmail(
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
		}*/
		return "login and email are unique";		
	}
	
	//TRUE
	@Override
	public boolean checkAccount(UserAccountPageBean account){
		
		/*System.out.println("in ZabiraiService checkAccount() account for check: " + account);
		
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
		}	*/
		return false;
	}	
	
	@Transactional
	public void test(){
		
//		try{
//			AccountEntityHibernate account = accountsHibernate.getAccountById(4);
//			
//		}catch(Exception e){
//			System.out.println("Exception in AccountsHibernateImpl.getAccountById()");
//		}
		
		try{
			//AccountEntityHibernate2 account = accountsHibernate.getAccountByLogin("Jakubik");
			AccountEntityHibernate account = accountsHibernate.getAccountByLogin("Jakubik");			
			System.out.println("status: " + account.getAccountRole());
			
		}catch(Exception e){
			System.out.println("Exception in AccountsHibernateImpl.getAccountByLogin()");
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getName());
		}
		
//		try{
//			AccountEntityHibernate account = accountsHibernate.getAccountByEmail("Jakubik@v.tubik");
//			
//		}catch(Exception e){
//			System.out.println("Exception in AccountsHibernateImpl.getAccountByEmail()");
//		}
		
	}
	

}
