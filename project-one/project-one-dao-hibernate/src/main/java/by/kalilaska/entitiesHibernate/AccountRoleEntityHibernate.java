package by.kalilaska.entitiesHibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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
	        query = "delete r from AccountRoleEntityHibernate r where r.roleStatus = :role"
	    )
})
@Table(name = "Roles")
public class AccountRoleEntityHibernate implements Serializable{
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name = "Roles")
	private String roleStatus;
	
	@OneToMany(mappedBy = "accountRole", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
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

	public void setAccountEntities(List<AccountEntityHibernate> accountEntities) {
		this.accountEntities = accountEntities;
	}

	@Override
	public String toString() {
		return "AccountRoleEntity [roleId=" + roleId + ", roleStatus=" + roleStatus + "]";
	}	

}
