package by.kalilaska.entities.impls;

public class AccountEntity{
	
	private long accountId;
	
	private String accountLogin;
	
	private String accountEmail;
	
	private String accountPassword;
	
	public AccountEntity() {
		super();		
	}

	public long getAccountId() {
		return accountId;
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

	public void setAccountId(long id) {
		this.accountId = id;
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
		return "AccountEntity [accountId=" + accountId + ", accountLogin=" + accountLogin + ", accountEmail=" + accountEmail
				+ ", accountPassword=" + accountPassword + "]";
	}	
	
}
