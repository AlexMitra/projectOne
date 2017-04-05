package by.kalilaska.beans;

import java.util.Set;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class EditAccountBean {

	private long accountId;

	@Pattern(regexp = "^[a-zA-Z_0-9]{5,20}$", message = "{error.accountLogin.pattern}")
	private String accountLogin;

	@Email(message = "{error.accountEmail.email}", regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String accountEmail;

	@Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "{error.accountPassword.pattern}")
	private String accountPassword;

	@NotEmpty
	private Set<String> authorities;

	public EditAccountBean() {
		super();
	}

	@Override
	public String toString() {
		return "EditAccountBean [accountId=" + accountId + ", accountLogin=" + accountLogin + ", accountEmail="
				+ accountEmail + ", accountPassword=" + accountPassword + ", authorities=" + authorities + "]";
	}

}
