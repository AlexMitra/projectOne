package by.kalilaska.utilities.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.daoHibernate.repositories.springData.AccountsRepositoryData;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.utilities.AccountsSearcher;
import by.kalilaska.utilities.EntityToBeanConverter;

//@Service
//public class AccountsSearcherImpl implements AccountsSearcher{
//	
//	@Autowired	
//	private AccountsRepositoryData accountsRepository;
//	
//	@Autowired
//	private EntityToBeanConverter entityToBeanConverter;
//
//	@Override
//	public List<AccountBean> getSearchedAccounts(String part, String searchField, String searchPlace) {
//		if(searchField.equalsIgnoreCase("byLogin")){
//			List<AccountEntityHibernate> accountEntityList = accountsRepository.findByAccountLoginLike(part.trim() + "%");
//			List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(
//					accountEntityList, AccountBean.class);
//			return accountBeanList;
//		}else if(searchField.equalsIgnoreCase("byEmail")){
//			List<AccountEntityHibernate> accountEntityList = accountsRepository.findByAccountEmailLike(part.trim() + "%");
//			List<AccountBean> accountBeanList = entityToBeanConverter.convertToBeanList(
//					accountEntityList, AccountBean.class);
//			return accountBeanList;
//		}else if(searchField.equalsIgnoreCase("byRole")){
//			return null;
//		}
//		
//		return null;
//	}
//}
