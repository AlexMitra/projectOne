package by.kalilaska.beans;

public class AdminAccountPageBean extends UserAccountPageBean{
	
	private long id;

	private String accountLogin;	

	private String accountEmail;	

	private String accountPassword;
	
	private String status;
	
	public AdminAccountPageBean() {
		super();		
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

	@Override
	public String toString() {
		return "AdminPageBean [id=" + id + ", accountLogin=" + accountLogin + ", accountEmail=" + accountEmail
				+ ", accountPassword=" + accountPassword + ", status=" + status + "]";
	}

}
