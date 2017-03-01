package by.kalilaska.utilities.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import by.kalilaska.beans.annotations.ValidEmail;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

	private Pattern pattern;
	private Matcher matcher;
	// private static final String EMAIL_PATTERN =
	// "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@"
	// + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"
			+ "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		System.out.println("in isValid()");

		return (validateEmail(email));
	}

	private boolean validateEmail(String email) {
		System.out.println("in validateEmail()");
		pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
