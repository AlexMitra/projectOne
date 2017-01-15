package by.kalilaska.entitiesHibernate;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(
	        name = "getAccountByLogin",
	        query = "select a from AccountEntityHibernate a where a.accountLogin = :login"
	    ),
    @NamedQuery(
	        name = "getAccountByEmail",
	        query = "select a from AccountEntityHibernate a where a.accountEmail = :email"
	    ),
    @NamedQuery(
        name = "getAccountsByLoginAndEmail",
        query = "select a from AccountEntityHibernate a where a.accountLogin = :login"
        		+ " and a.accountEmail = :email"
    ),
    @NamedQuery(
	        name = "getAllAccounts",
	        query = "select a from AccountEntityHibernate a"
	    ),
    @NamedQuery(
	        name = "deleteAccountByLogin",
	        query = "delete a from AccountEntityHibernate a where a.accountLogin = :login"
	    ),
})
@Table(name = "Accounts")
public class AccountEntityHibernate implements Serializable{
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;
	
	@Column(name = "Login")
	private String accountLogin;
	
	@Column(name = "Email")
	private String accountEmail;
	
	@Column(name = "Password")
	private String accountPassword;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name = "Accounts_to_roles",
	joinColumns = @JoinColumn(name = "FK_Account_id"),
	inverseJoinColumns = @JoinColumn(name = "FK_Role_id"))
	private AccountRoleEntityHibernate accountRole;

	public AccountEntityHibernate() {
		super();		
	}	

	public AccountEntityHibernate(String accountLogin, String accountEmail, String accountPassword) {
		super();
		this.accountLogin = accountLogin;
		this.accountEmail = accountEmail;
		this.accountPassword = accountPassword;
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
	
	public AccountRoleEntityHibernate getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(AccountRoleEntityHibernate accountRole) {
		this.accountRole = accountRole;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", accountLogin=" + accountLogin + ", accountEmail=" + accountEmail
				+ ", accountPassword=" + accountPassword + "]";
	}	
	
}
