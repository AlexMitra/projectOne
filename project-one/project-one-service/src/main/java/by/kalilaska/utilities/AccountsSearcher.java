package by.kalilaska.utilities;

import java.util.List;

import by.kalilaska.beans.AccountBean;

public interface AccountsSearcher {
	
	List<AccountBean> getSearchedAccounts(String part, String searchField, String searchPlace);

}
