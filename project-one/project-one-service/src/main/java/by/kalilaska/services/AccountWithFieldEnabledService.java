package by.kalilaska.services;

import java.util.List;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.beans.EditAccountBean;
import by.kalilaska.entities.forHibernate.RoleEntityHibernate;
import by.kalilaska.services.exceptions.EmailExistsException;
import by.kalilaska.services.exceptions.LoginExistsException;

public interface AccountWithFieldEnabledService {

	List<AccountBean> getAllAccountsWithFieldEnabled(boolean enabled);

	List<AccountBean> getSearchedEAccountsWithFieldEnabled(String part, String searchField, String searchPlace,
			String roles, boolean enabled);

	List<AccountBean> getSelectedRoleAccountsWithFieldEnabled(String[] roleStatus, boolean enabled);

	List<AccountBean> getSelectedLoginAccountsWithFieldEnabled(String accountLoginPart, boolean enabled);

	List<AccountBean> getSelectedEmailAccountsWithFieldEnabled(String accountEmailPart, boolean enabled);

	List<AccountBean> getSelectedLoginAndRoleAccountsWithFieldEnabled(String accountLoginPart,
			List<RoleEntityHibernate> roleList, boolean enabled);

	List<AccountBean> getSelectedEmailAndRoleAccountsWithFieldEnabled(String accountEmailPArt,
			List<RoleEntityHibernate> roleList, boolean enabled);

	void editAccount(EditAccountBean account) throws LoginExistsException, EmailExistsException;

	boolean disableAccount(long id);

	boolean enableAccount(long id);

	boolean deleteAccount(long id);

}
