package by.kalilaska.services;

import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.services.exceptions.EmailExistsException;
import by.kalilaska.services.exceptions.LoginExistsException;
import by.kalilaska.services.exceptions.UnknownCauseAccountExistException;

public interface AccountRegistrationService {

	AccountDetailsPageBean insertNewAccount(AccountDetailsPageBean account)
			throws LoginExistsException, EmailExistsException, UnknownCauseAccountExistException;

	boolean getAccountsByLoginAndEmail(AccountDetailsPageBean account)
			throws LoginExistsException, EmailExistsException;

}
