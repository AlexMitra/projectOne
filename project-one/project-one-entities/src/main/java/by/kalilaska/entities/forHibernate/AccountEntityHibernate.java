package by.kalilaska.entities.forHibernate;

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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
        		+ " or a.accountEmail = :email"
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
@Data
public class AccountEntityHibernate{
	
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

	@ManyToOne
	@JoinTable(name = "Accounts_to_roles",
	joinColumns = @JoinColumn(name = "FK_Account_id", referencedColumnName = "Account_Id"),
	inverseJoinColumns = @JoinColumn(name = "FK_Role_id", referencedColumnName = "Role_Id"))
	private RoleEntityHibernate accountRole;

	public AccountEntityHibernate() {
		super();		
	}	

	public AccountEntityHibernate(String accountLogin, String accountEmail, String accountPassword) {
		super();
		this.accountLogin = accountLogin;
		this.accountEmail = accountEmail;
		this.accountPassword = accountPassword;
	}

	@Override
	public String toString() {
		return "AccountEntityHibernate [accountId=" + accountId + ", accountLogin=" + accountLogin + ", accountEmail="
				+ accountEmail + ", accountPassword=" + accountPassword + "]";
	}	
	
}
