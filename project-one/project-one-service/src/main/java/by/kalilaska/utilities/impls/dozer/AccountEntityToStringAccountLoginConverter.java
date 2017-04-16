package by.kalilaska.utilities.impls.dozer;

import org.dozer.ConfigurableCustomConverter;

import by.kalilaska.entities.forHibernate.AccountEntityHibernate;

@SuppressWarnings("rawtypes")
public class AccountEntityToStringAccountLoginConverter implements ConfigurableCustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		AccountEntityHibernate account = (AccountEntityHibernate) sourceFieldValue;
		String destination = account.getAccountLogin();

		return destination;
	}

	@Override
	public void setParameter(String parameter) {
		// TODO Auto-generated method stub

	}

	public String convertTo(AccountEntityHibernate source, String destination) {
		destination = source.getAccountLogin();

		return destination;
	}

	public AccountEntityHibernate convertFrom(String source, AccountEntityHibernate destination) {
		destination.setAccountLogin(source);

		return destination;
	}

}
