package by.kalilaska.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.AccountBean;
import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.dao.forHibernate.AccountsRepository;
import by.kalilaska.dao.forHibernate.RolesRepository;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.services.ServiceOne;

@Service
public class ZabiraiServiceHibernate implements ServiceOne {

	@Override
	public List<AccountBean> getSelectedRoleAccounts(String roleStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountBean> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	private BeansPool beansPool;

	@Autowired
	@Qualifier("accountsRepositoryHibernate")
	private AccountsRepository accountsRepository;

	@Autowired
	@Qualifier("rolesRepositoryHibernate")
	private RolesRepository rolesRepository;

	// TRUE
	@Override
	public boolean insertNewAccount(AccountDetailsPageBean account) {
		String check = getAccountsByLoginAndEmail(account);
		System.out.println(check);

		if (check.equals("login and email are unique")) {
			System.out.println("in ZabiraiServiceHibernate insertNewAccount() account:" + account);

			AccountEntityHibernate accountEntity = accountsRepository.insertAccountWithReturn(account.getAccountLogin(),
					account.getAccountEmail(), account.getAccountPassword());
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

	// TRUE
	@Override
	public String getAccountsByLoginAndEmail(AccountDetailsPageBean account) {

		List<AccountEntityHibernate> accounts = accountsRepository.getAccountsByLoginAndEmail(account.getAccountLogin(),
				account.getAccountEmail());

		System.out.println("in ZabiraiServiceHibernate getAccountsByLoginAndEmail() accounts:" + accounts);

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

	// TRUE
	@Override
	public boolean checkAccount(UserAccountPageBean account) {
		AccountEntityHibernate accountEntity = accountsRepository.getAccountByLogin(account.getAccountLogin());

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
			System.out.println("in ZabiraiService checkAccount() account after check: " + account);
			return true;
		}
	}

	@Override
	@Transactional
	public void test() {
		try {
			AccountEntityHibernate account = accountsRepository.getAccountByLogin("Jakubik");

			System.out.println("account: " + account);
			// System.out.println("account role: " +
			// account.getAccountRole().getRoleStatus());

		} catch (Exception e) {
			System.out.println("Exception info");
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getName());
		}

		try {
			RoleEntityHibernate role = rolesRepository.getAccountRoleById(3);
			System.out.println("role: " + role);
			System.out.println("accounts with this role: " + role.getAccountEntities());

		} catch (Exception e) {
			System.out.println("Exception info");
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getName());
		}
	}

	@Override
	public List<AccountBean> getSearchedAccounts(String part, String searchField, String searchPlace, String roles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}
}
