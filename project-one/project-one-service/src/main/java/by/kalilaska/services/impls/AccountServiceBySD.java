package by.kalilaska.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.daoHibernate.repositories.springData.AccountsRepositoryData;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.services.AccountService;
import by.kalilaska.utilities.EntityToBeanConverter;

@Service
public class AccountServiceBySD implements AccountService {

	@Autowired
	private AccountsRepositoryData accountRepository;

	@Autowired
	private EntityToBeanConverter entityToBeanConverter;

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

}
