package by.kalilaska.services;

import by.kalilaska.entities.forHibernate.AccountEntityHibernate;

public interface AccountService {

	AccountEntityHibernate findByAccountLogin(String login);

}
