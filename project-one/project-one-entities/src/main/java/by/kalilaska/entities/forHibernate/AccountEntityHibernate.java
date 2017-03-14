package by.kalilaska.entities.forHibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
		@NamedQuery(name = "getAccountByLogin", query = "select a from AccountEntityHibernate a where a.accountLogin = :login"),
		@NamedQuery(name = "getAccountByEmail", query = "select a from AccountEntityHibernate a where a.accountEmail = :email"),
		@NamedQuery(name = "getAccountsByLoginAndEmail", query = "select a from AccountEntityHibernate a where a.accountLogin = :login"
				+ " or a.accountEmail = :email"),
		@NamedQuery(name = "getAllAccounts", query = "select a from AccountEntityHibernate a"),
		@NamedQuery(name = "deleteAccountByLogin", query = "delete from AccountEntityHibernate a where a.accountLogin = :login"), })
@Table(name = "Accounts")
@Getter
@Setter
public class AccountEntityHibernate implements Comparable<AccountEntityHibernate> {

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Accounts_to_roles", joinColumns = @JoinColumn(name = "Accounts_to_roles_FK_Account_id", referencedColumnName = "Account_Id"), inverseJoinColumns = @JoinColumn(name = "Accounts_to_roles_FK_Role_id", referencedColumnName = "Role_Id"))
	private List<RoleEntityHibernate> accountRoles;

	@OneToMany(targetEntity = AdEntityHibernate.class, mappedBy = "adMaker", fetch = FetchType.LAZY)
	private List<AdEntityHibernate> accountAds;

	@Column(name = "Account_enabled")
	private boolean accountEnabled;

	public AccountEntityHibernate() {
		super();
	}

	public AccountEntityHibernate(String accountLogin, String accountEmail, String accountPassword) {
		super();
		this.accountLogin = accountLogin;
		this.accountEmail = accountEmail;
		this.accountPassword = accountPassword;
		this.accountEnabled = true;
	}

	@Override
	public String toString() {
		return "AccountEntityHibernate [accountId=" + accountId + ", accountLogin=" + accountLogin + ", accountEmail="
				+ accountEmail + ", accountPassword=" + accountPassword + ", accountEnabled=" + accountEnabled + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + ((accountLogin == null) ? 0 : accountLogin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AccountEntityHibernate other = (AccountEntityHibernate) obj;
		if (accountId != other.accountId) {
			return false;
		}
		if (accountLogin == null) {
			if (other.accountLogin != null) {
				return false;
			}
		} else if (!accountLogin.equals(other.accountLogin)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(AccountEntityHibernate o) {
		AccountEntityHibernate account = o;

		return new Long(this.accountId).compareTo(new Long(account.getAccountId()));
	}

}
