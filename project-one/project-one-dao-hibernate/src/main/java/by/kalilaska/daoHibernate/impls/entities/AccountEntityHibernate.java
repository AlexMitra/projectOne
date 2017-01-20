package by.kalilaska.daoHibernate.impls.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	        query = "delete from AccountEntityHibernate a where a.accountLogin = :login"
	    ),
})
@Table(name = "Accounts")
public class AccountEntityHibernate implements Serializable{

	
	@Id
	@Column(name = "Account_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;
	
	@Column(name = "Login")
	private String accountLogin;
	
	@Column(name = "Email")
	private String accountEmail;
	
	@Column(name = "Password")
	private String accountPassword;
	
	//@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//@ManyToOne(targetEntity = AccountRoleEntityHibernate.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	//@ManyToOne(fetch = FetchType.LAZY)
	/*@JoinTable(name = "Accounts_to_roles",
				joinColumns = @JoinColumn(name = "FK_Account_id", referencedColumnName = "Account_Id"),
				inverseJoinColumns = @JoinColumn(name = "FK_Role_id", referencedColumnName = "Role_Id"))*/
	@ManyToOne
	@JoinTable(name = "Accounts_to_roles",
	joinColumns = @JoinColumn(name = "FK_Account_id", referencedColumnName = "Account_Id"),
	inverseJoinColumns = @JoinColumn(name = "FK_Role_id", referencedColumnName = "Role_Id"))
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
		//System.out.println("accountRole: " + accountRole.getClass().getSimpleName());
		this.accountRole = (AccountRoleEntityHibernate)accountRole;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", accountLogin=" + accountLogin + ", accountEmail=" + accountEmail
				+ ", accountPassword=" + accountPassword + "]";
	}
	
}
