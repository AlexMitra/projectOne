package by.kalilaska.daoHibernate.impls.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
/*@NamedQueries({
    @NamedQuery(
	        name = "getAccountByLogin",
	        query = "select a from AccountEntityHibernate2 a where a.accountLogin = :login"
	    ),
    @NamedQuery(
	        name = "getAccountByEmail",
	        query = "select a from AccountEntityHibernate2 a where a.accountEmail = :email"
	    ),
    @NamedQuery(
        name = "getAccountsByLoginAndEmail",
        query = "select a from AccountEntityHibernate2 a where a.accountLogin = :login"
        		+ " and a.accountEmail = :email"
    ),
    @NamedQuery(
	        name = "getAllAccounts",
	        query = "select a from AccountsEntityHibernate2 a"
	    ),
    @NamedQuery(
	        name = "deleteAccountByLogin",
	        query = "delete from AccountEntityHibernate2 a where a.accountLogin = :login"
	    ),
})*/
@Table(name = "Accounts")
public class AccountEntityHibernate2 implements Serializable{

	
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
	
	//@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id" ,foreignKey = @ForeignKey(name = "Accounts_to_roles"))
	private RoleEntityHibernate role;

	public AccountEntityHibernate2() {
		super();		
	}	

	public AccountEntityHibernate2(String accountLogin, String accountEmail, String accountPassword) {
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
	
	public String getAccountRole() {
		return role.getRoleStatus();
	}

	public void setAccountRole(RoleEntityHibernate role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", accountLogin=" + accountLogin + ", accountEmail=" + accountEmail
				+ ", accountPassword=" + accountPassword + "]";
	}
	
}
