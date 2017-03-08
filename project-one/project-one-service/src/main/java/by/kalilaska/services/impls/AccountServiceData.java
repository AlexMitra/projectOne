package by.kalilaska.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kalilaska.daoHibernate.repositories.springData.AccountsRepositoryData;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.services.AccountService;

@Service
public class AccountServiceData implements AccountService {

	@Autowired
	private AccountsRepositoryData accountRepository;

	@Override
	public AccountEntityHibernate findByAccountLogin(String login) {
		AccountEntityHibernate accountEntity = accountRepository.findByAccountLogin(login);
		return accountEntity;
	}

}
