package by.kalilaska.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.dao.forHibernate.AccountsRepository;
import by.kalilaska.daoHibernate.repositories.springData.AccountsRepositoryData;
import by.kalilaska.daoHibernate.repositories.springData.RolesRepositoryData;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.services.ServiceOne;
import by.kalilaska.utilities.EntityToBeanConverter;

@Service
public class ZabiraiServiceData implements ServiceOne{

	@Autowired	
	private AccountsRepositoryData accountsRepository;
	
	@Autowired	
	private RolesRepositoryData rolesRepository;
	
	@Autowired
	private EntityToBeanConverter entityToBeanConverter;
	
	private RoleEntityHibernate roleUser;
	
	private RoleEntityHibernate roleAdmin;
	
	private RoleEntityHibernate getRoleUser(){
		if(roleUser==null){
			roleUser = rolesRepository.findByRoleStatus("User");
		}
		return roleUser;
		
	}
	
	private RoleEntityHibernate getRoleAdmin(){
		if(roleAdmin==null){
			roleAdmin = rolesRepository.findByRoleStatus("Administrator");
		}
		return roleAdmin;
		
	}

	@Override
	public boolean insertNewAccount(UserAccountPageBean account) {
		String check = getAccountsByLoginAndEmail(account);
		System.out.println(check);
		
		if(check.equals("login and email are unique")){
			//System.out.println("in ZabiraiServiceHibernate insertNewAccount() account:" + account);			
			AccountEntityHibernate accountEntity = new AccountEntityHibernate(
					account.getAccountLogin(), account.getAccountEmail(), 
					account.getAccountPassword());
			accountEntity.setAccountRole(getRoleUser());
			
			accountEntity = accountsRepository.save(accountEntity);

			account.setId(accountEntity.getAccountId());			
			return true;
		}else if(check.equals("this login already exist")){
			account.setLoginCheck(check);
			return false;
		}else if(check.equals("this email already exist")){
			account.setEmailCheck(check);
		}
		return false;
	}

	@Override
	public String getAccountsByLoginAndEmail(UserAccountPageBean account) {		
		List<AccountEntityHibernate> accounts= accountsRepository.findByAccountLoginOrAccountEmail(
				account.getAccountLogin(), account.getAccountEmail());		
		
		//System.out.println("in ZabiraiServiceHibernate getAccountsByLoginAndEmail() accounts:" + accounts);
		
		if(accounts!=null){
			for (AccountEntityHibernate accountEntity : accounts) {
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

	@Override
	public boolean checkAccount(UserAccountPageBean account) {
		AccountEntityHibernate accountEntity = 
				accountsRepository.findByAccountLogin(account.getAccountLogin());		
		
		if(accountEntity==null){
			account.setLoginCheck("this login does not exist");
			return false;
		}else if(!accountEntity.getAccountPassword().equals(account.getAccountPassword())){
			account.setPasswordCheck("incorrect password");
			return false;
		}else{
			account.setId(accountEntity.getAccountId());
			account.setAccountEmail(accountEntity.getAccountEmail());
			
			account.setStatus(accountEntity.getAccountRole().getRoleStatus());
			System.out.println("in ZabiraiService checkAccount() account after check: " + account);
			return true;
		}
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<AccountBean> getAllAccounts() {
		List<AccountEntityHibernate> accountEntityList = accountsRepository.findAll();
		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(
				accountEntityList, AccountBean.class);
		return accountBeanList;
	}

}
