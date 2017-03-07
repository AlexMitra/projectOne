package by.kalilaska.beans.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.beans.annotations.PasswordMatches;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {

	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		AccountDetailsPageBean account = (AccountDetailsPageBean) obj;
		return account.getPassword().equals(account.getAccountPasswordOnceMore());
	}

}
