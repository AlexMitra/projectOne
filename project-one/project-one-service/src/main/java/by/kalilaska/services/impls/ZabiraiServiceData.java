package by.kalilaska.services.impls;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.daoHibernate.repositories.springData.AccountsRepositoryData;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.services.RoleService;
import by.kalilaska.services.ServiceOne;
import by.kalilaska.utilities.EntityToBeanConverter;

@Service
@Transactional
public class ZabiraiServiceData implements ServiceOne {

	@Autowired
	private AccountsRepositoryData accountsRepository;

	@Autowired
	private RoleService rolesService;

	@Autowired
	private EntityToBeanConverter entityToBeanConverter;

	// @Autowired
	// private AccountsSearcher accountsSearcher;

	private RoleEntityHibernate roleUser;

	private RoleEntityHibernate roleAdmin;

	private RoleEntityHibernate roleModer;

	private RoleEntityHibernate getRoleUser() {
		if (roleUser == null) {
			roleUser = rolesService.findByRoleStatus("User");
		}
		return roleUser;

	}

	private RoleEntityHibernate getRoleAdmin() {
		if (roleAdmin == null) {
			roleAdmin = rolesService.findByRoleStatus("Administrator");
		}
		return roleAdmin;

	}

	private RoleEntityHibernate getRoleModer() {
		if (roleModer == null) {
			roleModer = rolesService.findByRoleStatus("Moderator");
		}
		return roleModer;

	}

	@Override
	public boolean insertNewAccount(AccountDetailsPageBean account) {
		String check = getAccountsByLoginAndEmail(account);
		System.out.println(check);

		if (check.equals("login and email are unique")) {
			// System.out.println("in ZabiraiServiceHibernate insertNewAccount()
			// account:" + account);
			AccountEntityHibernate accountEntity = new AccountEntityHibernate(account.getAccountLogin(),
					account.getAccountEmail(), account.getAccountPassword());
			List<RoleEntityHibernate> roleList = new ArrayList<>();
			roleList.add(getRoleUser());
			accountEntity.setAccountRoles(roleList);

			accountEntity = accountsRepository.save(accountEntity);

			account.setId(accountEntity.getAccountId());
			return true;
		} else if (check.equals("this login already exist")) {
			// account.setLoginCheck(check);
			return false;
		} else if (check.equals("this email already exist")) {
			// account.setEmailCheck(check);
		}
		return false;
	}

	@Override
	public String getAccountsByLoginAndEmail(AccountDetailsPageBean account) {
		List<AccountEntityHibernate> accounts = accountsRepository
				.findByAccountLoginOrAccountEmail(account.getAccountLogin(), account.getAccountEmail());

		if (accounts != null) {
			for (AccountEntityHibernate accountEntity : accounts) {
				if (accountEntity.getAccountLogin().equals(account.getAccountLogin())) {
					return "this login already exist";
				}
				if (accountEntity.getAccountEmail().equals(account.getAccountEmail())) {
					return "this email already exist";
				}
			}
		}
		return "login and email are unique";
	}

	@Override
	public boolean checkAccount(UserAccountPageBean account) {
		AccountEntityHibernate accountEntity = accountsRepository.findByAccountLogin(account.getAccountLogin());

		if (accountEntity == null) {
			account.setLoginCheck("this login does not exist");
			return false;
		} else if (!accountEntity.getAccountPassword().equals(account.getAccountPassword())) {
			account.setPasswordCheck("incorrect password");
			return false;
		} else {
			account.setId(accountEntity.getAccountId());
			account.setAccountEmail(accountEntity.getAccountEmail());

			// account.setStatus(accountEntity.getAccountRole().getRoleStatus());
			account.setAllRoles(getAllRoles());
			System.out.println("in ZabiraiService checkAccount() account after check: " + account);
			return true;
		}
	}

	@Override
	public void test() {
		System.out.println("in test, before: ");
		// List<AccountEntityHibernate> accountEntityList =
		// accountsRepository.findByAccountRole("User");
		// System.out.println("in test, after: " + accountEntityList);
	}

	@Override
	public List<AccountBean> getAllAccounts() {

		List<AccountEntityHibernate> accountEntityList = accountsRepository.findAll();

		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(accountEntityList,
				AccountBean.class);

		return accountBeanList;
	}

	/*
	 * @Override public List<AccountBean> getSearchedAccounts(String part,
	 * String searchField, String searchPlace, String roles){
	 * System.out.println("in getSearchedAccounts(), roles: " + roles +
	 * ", length: " + roles.length());
	 * 
	 * if(roles.length() == 0){ System.out.println(
	 * "in getSearchedAccounts(), 1 if(): " + roles);
	 * if(searchField.equalsIgnoreCase("byLogin")){
	 * if(searchPlace.equalsIgnoreCase("atFirstLetters")){
	 * List<AccountEntityHibernate> accountEntityList =
	 * accountsRepository.findByAccountLoginStartingWith(part.trim());
	 * //findByAccountLoginLike(part.trim() + "%"); List<AccountBean>
	 * accountBeanList = entityToBeanConverter.convertToBeanList(
	 * accountEntityList, AccountBean.class); return accountBeanList; }else
	 * if(searchPlace.equalsIgnoreCase("anywhere")){
	 * List<AccountEntityHibernate> accountEntityList =
	 * accountsRepository.findByAccountLoginContaining(part.trim());
	 * List<AccountBean> accountBeanList =
	 * entityToBeanConverter.convertToBeanList( accountEntityList,
	 * AccountBean.class); return accountBeanList; }else{ return null; }
	 * 
	 * }else if(searchField.equalsIgnoreCase("byEmail")){
	 * if(searchPlace.equalsIgnoreCase("atFirstLetters")){
	 * List<AccountEntityHibernate> accountEntityList =
	 * accountsRepository.findByAccountEmailStartingWith(part.trim());
	 * //findByAccountEmailLike(part.trim() + "%"); List<AccountBean>
	 * accountBeanList = entityToBeanConverter.convertToBeanList(
	 * accountEntityList, AccountBean.class); return accountBeanList; }else
	 * if(searchPlace.equalsIgnoreCase("anywhere")){
	 * List<AccountEntityHibernate> accountEntityList =
	 * accountsRepository.findByAccountEmailContaining(part.trim());
	 * List<AccountBean> accountBeanList =
	 * entityToBeanConverter.convertToBeanList( accountEntityList,
	 * AccountBean.class); return accountBeanList; }else{ return null; } }
	 * }else{ String[] rolesArr = roles.split("checkbox-"); for (String role :
	 * rolesArr) { System.out.println("in getSearchedAccounts(), 2 if(), role: "
	 * + role); if(role.length()>=1){
	 * if(searchField.equalsIgnoreCase("byLogin")){
	 * if(searchPlace.equalsIgnoreCase("atFirstLetters")){
	 * List<AccountEntityHibernate> accountEntityList =
	 * accountsRepository.findByAccountLoginAndAccountRole("%" + part.trim(),
	 * role); //findByAccountLoginLike(part.trim() + "%"); List<AccountBean>
	 * accountBeanList = entityToBeanConverter.convertToBeanList(
	 * accountEntityList, AccountBean.class); return accountBeanList; }else
	 * if(searchPlace.equalsIgnoreCase("anywhere")){
	 * List<AccountEntityHibernate> accountEntityList =
	 * accountsRepository.findByAccountLoginAndAccountRole("%" + part.trim() +
	 * "%", role); List<AccountBean> accountBeanList =
	 * entityToBeanConverter.convertToBeanList( accountEntityList,
	 * AccountBean.class); return accountBeanList; }else{ return null; }
	 * 
	 * }else if(searchField.equalsIgnoreCase("byEmail")){
	 * if(searchPlace.equalsIgnoreCase("atFirstLetters")){
	 * List<AccountEntityHibernate> accountEntityList =
	 * accountsRepository.findByAccountEmailAndAccountRole("%" + part.trim(),
	 * role); //findByAccountEmailLike(part.trim() + "%"); List<AccountBean>
	 * accountBeanList = entityToBeanConverter.convertToBeanList(
	 * accountEntityList, AccountBean.class); return accountBeanList; }else
	 * if(searchPlace.equalsIgnoreCase("anywhere")){
	 * List<AccountEntityHibernate> accountEntityList =
	 * accountsRepository.findByAccountEmailAndAccountRole("%" + part.trim() +
	 * "%", role); List<AccountBean> accountBeanList =
	 * entityToBeanConverter.convertToBeanList( accountEntityList,
	 * AccountBean.class); return accountBeanList; }else{ return null; } } } }
	 * 
	 * }
	 * 
	 * return null; }
	 */

	@Override
	public List<AccountBean> getSearchedAccounts(String part, String searchField, String searchPlace, String roles) {
		System.out.println("part: " + part);
		System.out.println("searchField: " + searchField);
		System.out.println("searchPlace: " + searchPlace);
		System.out.println("roles: " + roles);
		String searchedRolesArr[] = null;
		if (roles.length() > 0) {
			searchedRolesArr = roles.split("checkbox-");
			for (String s : searchedRolesArr) {
				System.out.println("<<<<<<<<searchedRole>>>>>>>>>: " + s);
			}

		}

		// System.out.println("in getSearchedAccounts(), 1 if(): " + roles);
		// if (searchField.equalsIgnoreCase("byLogin")) {
		// if (searchPlace.equalsIgnoreCase("atFirstLetters")) {
		// List<AccountEntityHibernate> accountEntityList = accountsRepository
		// .findByAccountLoginStartingWith(part.trim());
		// // findByAccountLoginLike(part.trim() + "%");
		// List<AccountBean> accountBeanList =
		// entityToBeanConverter.convertToBeanList(accountEntityList,
		// AccountBean.class);
		// return accountBeanList;
		// } else if (searchPlace.equalsIgnoreCase("anywhere")) {
		// List<AccountEntityHibernate> accountEntityList = accountsRepository
		// .findByAccountLoginContaining(part.trim());
		// List<AccountBean> accountBeanList =
		// entityToBeanConverter.convertToBeanList(accountEntityList,
		// AccountBean.class);
		// return accountBeanList;
		// } else {
		// return null;
		// }
		//
		// } else if (searchField.equalsIgnoreCase("byEmail")) {
		// if (searchPlace.equalsIgnoreCase("atFirstLetters")) {
		// List<AccountEntityHibernate> accountEntityList = accountsRepository
		// .findByAccountEmailStartingWith(part.trim());
		// // findByAccountEmailLike(part.trim() + "%");
		// List<AccountBean> accountBeanList =
		// entityToBeanConverter.convertToBeanList(accountEntityList,
		// AccountBean.class);
		// return accountBeanList;
		// } else if (searchPlace.equalsIgnoreCase("anywhere")) {
		// List<AccountEntityHibernate> accountEntityList = accountsRepository
		// .findByAccountEmailContaining(part.trim());
		// List<AccountBean> accountBeanList =
		// entityToBeanConverter.convertToBeanList(accountEntityList,
		// AccountBean.class);
		// return accountBeanList;
		// } else {
		// return null;
		// }
		// }

		return null;
	}

	@Override
	public List<String> getAllRoles() {
		List<RoleEntityHibernate> roleEntityList = rolesService.findAllRoles();
		List<String> roleNameList = new ArrayList<>();
		for (RoleEntityHibernate r : roleEntityList) {
			roleNameList.add(r.getRoleStatus());
		}

		return roleNameList;
	}

	@Override
	public List<AccountBean> getSelectedRoleAccounts(String roleStatus) {
		RoleEntityHibernate roleEntity = rolesService.findByRoleStatus(roleStatus);
		Hibernate.initialize(roleEntity.getAccountEntities());
		List<AccountEntityHibernate> accountEntityList = roleEntity.getAccountEntities();

		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(accountEntityList,
				AccountBean.class);
		return accountBeanList;
	}

}
