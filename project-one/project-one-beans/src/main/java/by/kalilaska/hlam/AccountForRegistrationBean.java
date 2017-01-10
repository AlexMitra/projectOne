package by.kalilaska.hlam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountForRegistrationBean{	
	
	@NotNull
	@Size(min=5, max=20, message="login have to have more than 5 symbols and less than 21 symbol")
	private String accountLogin;
	
	@NotNull
	@Size(min=5, max=20, message="email have to be correct")
	private String accountEmail;
	
	@NotNull
	@Size(min=5, max=20, message="login have to have more than 5 symbols and less than 21 symbol")
	private String accountPassword;
	
	private String loginCheck;
	
	private String emailCheck;
	
	public String getLoginCheck() {
		return loginCheck;
	}

	public String getEmailCheck() {
		return emailCheck;
	}

	public void setLoginCheck(String loginCheck) {
		this.loginCheck = loginCheck;
	}

	public void setEmailCheck(String emailCheck) {
		this.emailCheck = emailCheck;
	}

	public AccountForRegistrationBean() {
		super();		
	}

	public String getAccountLogin() {
		return accountLogin;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountLogin(String accountLogin) {
		this.accountLogin = accountLogin;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	@Override
	public String toString() {
		return "AccountForRegistrationBean [accountLogin=" + accountLogin + ", accountEmail=" + accountEmail
				+ ", accountPassword=" + accountPassword + ", loginCheck=" + loginCheck + ", emailCheck="
				+ emailCheck + "]";
	}


	
}
