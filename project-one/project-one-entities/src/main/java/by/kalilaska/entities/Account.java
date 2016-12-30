package by.kalilaska.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


public class Account{
	
	private int id;
	
	@NotNull
	@Size(min=5, max=20, message="login have to have more than 5 symbols and less than 21 symbol")
	private String accountLogin;
	
	@NotNull
	@Size(min=5, max=20, message="email have to be correct")	
	private String accountEmail;
	
	@NotNull
	@Size(min=5, max=20, message="login have to have more than 5 symbols and less than 21 symbol")
	private String accountPassword;
	
	public Account() {
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
