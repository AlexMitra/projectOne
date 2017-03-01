package by.kalilaska.beans;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserAccountPageBean{

	private long id;

	@NotNull
	@Size(min=5, max=20, message="login have to have more than 5 symbols and less than 21 symbol")
	private String accountLogin;

	@NotNull
	@Size(min=5, max=20, message="email have to be correct")
	private String accountEmail;

	@NotNull
	@Size(min=5, max=20, message="login have to have more than 5 symbols and less than 21 symbol")
	private String accountPassword;

	private String status;

	private String loginCheck;

	private String emailCheck;

	private String passwordCheck;

	private List<String> allRoles;

	public List<String> getAllRoles() {
		return allRoles;
	}

	public void setAllRoles(List<String> roles) {
		this.allRoles = roles;
	}

	public long getId() {
		return id;
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

	public String getStatus() {
		return status;
	}

	public String getLoginCheck() {
		return loginCheck;
	}

	public String getEmailCheck() {
		return emailCheck;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setStatus(String status) {
		this.status = status;
	}

	public void setLoginCheck(String loginCheck) {
		this.loginCheck = loginCheck;
	}

	public void setEmailCheck(String emailCheck) {
		this.emailCheck = emailCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	@Override
	public String toString() {
		return "UserAccountPageBean [id=" + id + ", accountLogin=" + accountLogin + ", accountEmail=" + accountEmail
				+ ", accountPassword=" + accountPassword + ", status=" + status + ", loginCheck=" + loginCheck
				+ ", emailCheck=" + emailCheck + ", passwordCheck=" + passwordCheck + "]";
	}
}
