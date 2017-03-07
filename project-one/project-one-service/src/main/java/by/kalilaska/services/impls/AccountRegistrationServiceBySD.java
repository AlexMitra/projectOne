package by.kalilaska.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.daoHibernate.repositories.springData.AccountsRepositoryData;
import by.kalilaska.daoHibernate.repositories.springData.RolesRepositoryData;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.services.AccountRegistrationService;
import by.kalilaska.services.exceptions.EmailExistsException;
import by.kalilaska.services.exceptions.LoginExistsException;
import by.kalilaska.services.exceptions.UnknownCauseAccountExistException;
import by.kalilaska.utilities.EntityToBeanConverter;

@Service
public class AccountRegistrationServiceBySD implements AccountRegistrationService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AccountsRepositoryData accountsRepository;

	@Autowired
	private RolesRepositoryData rolesRepository;

	@Autowired
	private EntityToBeanConverter entityToBeanConverter;

	private RoleEntityHibernate roleUser;

	private RoleEntityHibernate roleAdmin;

	private RoleEntityHibernate getRoleUser() {
		if (roleUser == null) {
			roleUser = rolesRepository.findByRoleStatus("User");
		}
		return roleUser;

	}

	private RoleEntityHibernate getRoleAdmin() {
		if (roleAdmin == null) {
			roleAdmin = rolesRepository.findByRoleStatus("Administrator");
		}
		return roleAdmin;

	}

	@Transactional
	@Override
	public AccountDetailsPageBean insertNewAccount(AccountDetailsPageBean account)
			throws LoginExistsException, EmailExistsException, UnknownCauseAccountExistException {
		AccountDetailsPageBean registered = null;
		boolean accountExistFlag = true;
		try {
			accountExistFlag = getAccountsByLoginAndEmail(account);
		} catch (LoginExistsException e) {
			throw e;

		} catch (EmailExistsException e) {
			throw e;
		}

		// System.out.println(check);

		if (accountExistFlag == false) {

			AccountEntityHibernate accountEntity = new AccountEntityHibernate(account.getAccountLogin(),
					account.getAccountEmail(), passwordEncoder.encode(account.getAccountPassword()));
			accountEntity.setAccountRole(getRoleUser());

			accountEntity = accountsRepository.save(accountEntity);

			registered = (AccountDetailsPageBean) userDetailsService.loadUserByUsername(account.getAccountLogin());
			return registered;
		} else {
			throw new UnknownCauseAccountExistException("don't know why, but this account already exist");
		}
	}

	@Transactional
	@Override
	public boolean getAccountsByLoginAndEmail(AccountDetailsPageBean account)
			throws LoginExistsException, EmailExistsException {

		List<AccountEntityHibernate> accounts = accountsRepository
				.findByAccountLoginOrAccountEmail(account.getAccountLogin(), account.getAccountEmail());

		if (accounts != null) {
			for (AccountEntityHibernate accountEntity : accounts) {
				if (accountEntity.getAccountLogin().toLowerCase().equals(account.getAccountLogin().toLowerCase())) {
					throw new LoginExistsException("this login already exist");
				}
				if (accountEntity.getAccountEmail().toLowerCase().equals(account.getAccountEmail().toLowerCase())) {
					throw new EmailExistsException("this email already exist");
				}
			}
		}
		return false;
	}

}
