package by.kalilaska.services.impls;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.beans.EditAccountBean;
import by.kalilaska.daoHibernate.repositories.springData.AccountsRepositoryData;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.services.AccountWithFieldEnabledService;
import by.kalilaska.services.RoleService;
import by.kalilaska.services.exceptions.EmailExistsException;
import by.kalilaska.services.exceptions.LoginExistsException;
import by.kalilaska.utilities.EntityToBeanConverter;

@Service
public class AccountServiceWithFieldEnabledBySD implements AccountWithFieldEnabledService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AccountsRepositoryData accountRepository;

	@Autowired
	private EntityToBeanConverter entityToBeanConverter;

	@Autowired
	private RoleService roleService;

	@Override
	public List<AccountBean> getAllAccountsWithFieldEnabled(boolean enabled) {

		List<AccountEntityHibernate> accountEntityList = accountRepository.findByAccountEnabled(enabled);

		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(accountEntityList,
				AccountBean.class);

		return accountBeanList;
	}

	@Override
	public List<AccountBean> getSearchedEAccountsWithFieldEnabled(String part, String searchField, String searchPlace,
			String roles, boolean enabled) {
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
			return getAllAccountsWithFieldEnabled(enabled);
		}

		if (rolesFlag == true && searchFlag == false) {
			return getSelectedRoleAccountsWithFieldEnabled(searchedRolesArr, enabled);
		}

		if (rolesFlag == false && searchFlag == true) {

			if (loginFlag) {

				return getSelectedLoginAccountsWithFieldEnabled(part, enabled);
			}
			if (emailFlag) {
				return getSelectedEmailAccountsWithFieldEnabled(part, enabled);
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
				return getSelectedLoginAndRoleAccountsWithFieldEnabled(part, roleList, enabled);
			}
			if (emailFlag) {
				return getSelectedEmailAndRoleAccountsWithFieldEnabled(part, roleList, enabled);
			}

		}

		return null;
	}

	@Transactional
	@Override
	public List<AccountBean> getSelectedRoleAccountsWithFieldEnabled(String[] roleStatus, boolean enabled) {
		List<RoleEntityHibernate> roleList = new ArrayList<>();
		for (int i = 1; i < roleStatus.length; i++) {
			RoleEntityHibernate roleEntity = roleService.findByRoleStatus(roleStatus[i]);
			roleList.add(roleEntity);
		}
		SortedSet<AccountEntityHibernate> accountEntitySet = new TreeSet<>();
		accountEntitySet.addAll(accountRepository.findByAccountRolesInAndAccountEnabled(roleList, enabled));
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
	public List<AccountBean> getSelectedLoginAccountsWithFieldEnabled(String accountLoginPart, boolean enabled) {
		List<AccountEntityHibernate> accountEntityList = null;
		accountEntityList = accountRepository.findByAccountLoginLikeAndAccountEnabled(accountLoginPart, enabled);
		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(accountEntityList,
				AccountBean.class);

		return accountBeanList;
	}

	@Transactional
	@Override
	public List<AccountBean> getSelectedEmailAccountsWithFieldEnabled(String accountEmailPart, boolean enabled) {
		List<AccountEntityHibernate> accountEntityList = null;
		accountEntityList = accountRepository.findByAccountEmailLikeAndAccountEnabled(accountEmailPart, enabled);
		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(accountEntityList,
				AccountBean.class);

		return accountBeanList;
	}

	@Transactional
	@Override
	public List<AccountBean> getSelectedLoginAndRoleAccountsWithFieldEnabled(String accountLoginPart,
			List<RoleEntityHibernate> roleList, boolean enabled) {
		SortedSet<AccountEntityHibernate> accountEntitySet = new TreeSet<>();
		accountEntitySet.addAll(accountRepository
				.findByAccountLoginLikeAndAccountRolesInAndAccountEnabled(accountLoginPart, roleList, enabled));
		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(new ArrayList<>(accountEntitySet),
				AccountBean.class);
		return accountBeanList;
	}

	@Transactional
	@Override
	public List<AccountBean> getSelectedEmailAndRoleAccountsWithFieldEnabled(String accountEmailPArt,
			List<RoleEntityHibernate> roleList, boolean enabled) {
		SortedSet<AccountEntityHibernate> accountEntitySet = new TreeSet<>();
		accountEntitySet.addAll(accountRepository
				.findByAccountEmailLikeAndAccountRolesInAndAccountEnabled(accountEmailPArt, roleList, enabled));
		List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(new ArrayList<>(accountEntitySet),
				AccountBean.class);
		return accountBeanList;
	}

	@Transactional
	@Override
	public boolean disableAccount(long id) {
		AccountEntityHibernate account = accountRepository.findOne(id);

		if (account != null) {
			account.setAccountEnabled(false);
			accountRepository.save(account);
			if (accountRepository.findOne(id).isAccountEnabled() == false) {
				return true;
			}
		}

		return false;

	}

	@Transactional
	@Override
	public boolean enableAccount(long id) {
		AccountEntityHibernate account = accountRepository.findOne(id);

		if (account != null) {
			account.setAccountEnabled(true);
			accountRepository.save(account);
			if (accountRepository.findOne(id).isAccountEnabled() == true) {
				return true;
			}
		}

		return false;

	}

	@Transactional
	@Override
	public boolean deleteAccount(long id) {
		AccountEntityHibernate account = accountRepository.findOne(id);

		if (account != null) {
			accountRepository.delete(account);
			if (accountRepository.findOne(id) == null) {

				return true;
			}
		}

		return false;
	}

	@Override
	public void editAccount(EditAccountBean account) throws LoginExistsException, EmailExistsException {
		AccountEntityHibernate entityByLogin = null;
		try {
			entityByLogin = accountRepository.findByAccountLogin(account.getAccountLogin());
			if (account.getAccountId() != entityByLogin.getAccountId()) {
				throw new LoginExistsException("this login already exist");
			}
		} catch (NullPointerException e) {

		}

		AccountEntityHibernate entityByEmail = null;
		try {
			entityByEmail = accountRepository.findByAccountEmail(account.getAccountEmail());
			if (account.getAccountId() != entityByEmail.getAccountId()) {
				throw new EmailExistsException("this email already exist");
			}
		} catch (NullPointerException e) {

		}

		AccountEntityHibernate accountEntity = accountRepository.findOne(account.getAccountId());
		accountEntity.setAccountLogin(account.getAccountLogin());
		accountEntity.setAccountEmail(account.getAccountEmail());

		if (account.getAccountPassword().length() > 0) {
			accountEntity.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
		}

		List<RoleEntityHibernate> roleList = new ArrayList<>();
		for (String authority : account.getAuthorities()) {
			roleList.add(roleService.findByRoleStatus(authority));
		}

		accountEntity.setAccountRoles(roleList);

		accountEntity = accountRepository.save(accountEntity);
	}

}
