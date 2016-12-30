package by.kalilaska.beans;

public class AccountBean{
	
	private int id;
	
	private String accountLogin;
	
	private String accountEmail;
	
	private String accountPassword;
	
	public AccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
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

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountLogin=" + accountLogin + ", accountEmail=" + accountEmail
				+ ", accountPassword=" + accountPassword + "]";
	}	
	
}
