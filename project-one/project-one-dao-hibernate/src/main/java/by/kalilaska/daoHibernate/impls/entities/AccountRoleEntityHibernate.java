package by.kalilaska.daoHibernate.impls.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
	        name = "getAccountRoleByRoleStatus",
	        query = "select r from AccountRoleEntityHibernate r where r.roleStatus = :role"
	    ),
    @NamedQuery(
	        name = "getAllAccountRoles",
	        query = "select r from AccountRoleEntityHibernate r"
	    ),
    @NamedQuery(
	        name = "deleteAccountRoleByRoleStatus",
	        query = "delete from AccountRoleEntityHibernate r where r.roleStatus = :role"
	    )
})
@Table(name = "Roles")
public class AccountRoleEntityHibernate implements Serializable{

	
	@Id
	@Column(name = "Role_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name = "Roles")
	private String roleStatus;
	
	//@OneToMany(mappedBy = "accountRole", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//@OneToMany(mappedBy = "accountRole", targetEntity = AccountEntityHibernate.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@OneToMany(mappedBy = "accountRole", fetch = FetchType.LAZY)
	/*@JoinTable(name = "Accounts_to_roles",
				joinColumns = @JoinColumn(name = "FK_Account_id", referencedColumnName = "Id"),
				inverseJoinColumns = @JoinColumn(name = "FK_Role_id", referencedColumnName = "Id"))*/
	private List<AccountEntityHibernate> accountEntities;

	public AccountRoleEntityHibernate() {
		super();
	}	

	public AccountRoleEntityHibernate(String roleStatus) {
		super();
		this.roleStatus = roleStatus;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setRoleStatus(String roleRole) {
		this.roleStatus = roleRole;
	}
	
	public List<AccountEntityHibernate> getAccountEntities() {
		return accountEntities;
	}

	public void setAccountEntities(Object accountEntities) {
		System.out.println("accountEntities: " + accountEntities.getClass().getSimpleName());
		
		this.accountEntities = (List<AccountEntityHibernate>)accountEntities;
	}

	@Override
	public String toString() {
		return "AccountRoleEntity [roleId=" + roleId + ", roleStatus=" + roleStatus + "]";
	}	

}
