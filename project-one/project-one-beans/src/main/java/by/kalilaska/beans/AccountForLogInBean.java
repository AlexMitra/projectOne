package by.kalilaska.beans;

public class AccountForLogInBean{
	
	private String accountLogin;
	
	private String accountPassword;
	
	private String status;

	private String loginCheck;
	
	private String passwordCheck;
	
	public String getAccountLogin() {
		return accountLogin;
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

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setAccountLogin(String accountLogin) {
		this.accountLogin = accountLogin;
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

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	@Override
	public String toString() {
		return "AccountForLogInBean [accountLogin=" + accountLogin + ", accountPassword=" + accountPassword
				+ ", status=" + status + ", loginCheck=" + loginCheck + ", passwordCheck=" + passwordCheck + "]";
	}

}
