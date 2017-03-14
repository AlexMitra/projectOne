package by.kalilaska.services.impls;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.daoHibernate.repositories.springData.AccountsRepositoryData;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.services.AccountService;
import by.kalilaska.services.RoleService;
import by.kalilaska.utilities.EntityToBeanConverter;

@Service
public class AccountServiceData implements AccountService {

	@Autowired
	private AccountsRepositoryData accountRepository;

	@Autowired
	private EntityToBeanConverter entityToBeanConverter;

	@Autowired
	private RoleService roleService;

	@Transactional
	@Override
	public AccountEntityHibernate findByAccountLogin(String login) {
		AccountEntityHibernate accountEntity = accountRepository.findByAccountLogin(login);
		return accountEntity;
	}

	@Override
	public List<AccountBean> getAllAccounts() {

		List<AccountEntityHibernate> accountEntityList = accountRepository.findAll();

		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(accountEntityList,
				AccountBean.class);

		return accountBeanList;
	}

	@Override
	public List<AccountBean> getSearchedAccounts(String part, String searchField, String searchPlace, String roles) {
		boolean searchFlag = false;
		boolean loginFlag = false;
		boolean emailFlag = false;
		boolean rolesFlag = false;
		String searchedRolesArr[] = null;

		if (part.trim().length() > 0) {
			searchFlag = true;
		}

		if (roles.length() > 0) {
			rolesFlag = true;
			searchedRolesArr = roles.split("checkbox-");
		}

		if (searchPlace.equalsIgnoreCase("atFirstLetters")) {
			part = part + "%";
		}

		if (searchPlace.equalsIgnoreCase("anywhere")) {
			part = "%" + part + "%";
		}

		if (searchField.equalsIgnoreCase("byLogin")) {
			loginFlag = true;
			emailFlag = false;
		}

		if (searchField.equalsIgnoreCase("byEmail")) {
			loginFlag = false;
			emailFlag = true;
		}

		if (rolesFlag == false && searchFlag == false) {
			return getAllAccounts();
		}

		if (rolesFlag == true && searchFlag == false) {
			return getSelectedRoleAccounts(searchedRolesArr);
		}

		if (rolesFlag == false && searchFlag == true) {

			if (loginFlag) {
				return getSelectedLoginAccounts(part);
			}
			if (emailFlag) {
				return getSelectedEmailAccounts(part);
			}

			return null;
		}

		if (rolesFlag == true && searchFlag == true) {
			List<AccountEntityHibernate> accountEntityList = null;
			List<RoleEntityHibernate> roleList = new ArrayList<>();
			for (int i = 1; i < searchedRolesArr.length; i++) {
				RoleEntityHibernate roleEntity = roleService.findByRoleStatus(searchedRolesArr[i]);
				roleList.add(roleEntity);
			}
			if (loginFlag) {
				return getSelectedLoginAndRoleAccounts(part, roleList);
			}
			if (emailFlag) {
				return getSelectedEmailAndRoleAccounts(part, roleList);
			}

		}

		return null;
	}

	@Transactional
	@Override
	public List<AccountBean> getSelectedRoleAccounts(String[] roleStatus) {
		List<RoleEntityHibernate> roleList = new ArrayList<>();
		for (int i = 1; i < roleStatus.length; i++) {
			RoleEntityHibernate roleEntity = roleService.findByRoleStatus(roleStatus[i]);
			roleList.add(roleEntity);
		}
		SortedSet<AccountEntityHibernate> accountEntitySet = new TreeSet<>();
		accountEntitySet.addAll(accountRepository.findByAccountRolesIn(roleList));
		System.out.println("SET: " + accountEntitySet);

		// RoleEntityHibernate roleEntity = roleService.findByRoleStatus(s);
		// Hibernate.initialize(roleEntity.getAccountEntities());
		// List<AccountEntityHibernate> accountEntityList =
		// roleEntity.getAccountEntities();

		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(new ArrayList<>(accountEntitySet),
				AccountBean.class);
		return accountBeanList;
	}

	@Transactional
	@Override
	public List<AccountBean> getSelectedLoginAccounts(String accountLoginPart) {
		List<AccountEntityHibernate> accountEntityList = null;
		accountEntityList = accountRepository.findByAccountLoginLike(accountLoginPart);
		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(accountEntityList,
				AccountBean.class);

		return accountBeanList;
	}

	@Transactional
	@Override
	public List<AccountBean> getSelectedEmailAccounts(String accountEmailPart) {
		List<AccountEntityHibernate> accountEntityList = null;
		accountEntityList = accountRepository.findByAccountEmailLike(accountEmailPart);
		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(accountEntityList,
				AccountBean.class);

		return accountBeanList;
	}

	@Transactional
	@Override
	public List<AccountBean> getSelectedLoginAndRoleAccounts(String accountLoginPart,
			List<RoleEntityHibernate> roleList) {
		SortedSet<AccountEntityHibernate> accountEntitySet = new TreeSet<>();
		accountEntitySet.addAll(accountRepository.findByAccountLoginLikeAndAccountRolesIn(accountLoginPart, roleList));
		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(new ArrayList<>(accountEntitySet),
				AccountBean.class);
		return accountBeanList;
	}

	@Transactional
	@Override
	public List<AccountBean> getSelectedEmailAndRoleAccounts(String accountEmailPArt,
			List<RoleEntityHibernate> roleList) {
		SortedSet<AccountEntityHibernate> accountEntitySet = new TreeSet<>();
		accountEntitySet.addAll(accountRepository.findByAccountEmailLikeAndAccountRolesIn(accountEmailPArt, roleList));
		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(new ArrayList<>(accountEntitySet),
				AccountBean.class);
		return accountBeanList;
	}

	@Override
	public void test() {
		// RoleEntityHibernate role = roleService.findByRoleStatus("Moderator");
		// RoleEntityHibernate role2 =
		// roleService.findByRoleStatus("Administrator");
		// List<RoleEntityHibernate> roleList = new ArrayList<>();
		// roleList.add(role);
		// roleList.add(role2);
		// System.out.println(accountRepository.findByAccountLoginLikeAndAccountRolesIn("%m%",
		// roleList));
	}

}
