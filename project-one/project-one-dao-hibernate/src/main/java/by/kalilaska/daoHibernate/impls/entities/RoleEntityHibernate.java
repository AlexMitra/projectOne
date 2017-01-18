package by.kalilaska.daoHibernate.impls.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
/*@NamedQueries({
    @NamedQuery(
	        name = "getAccountRoleByRoleStatus",
	        query = "select r from RoleEntityHibernate r where r.roleStatus = :role"
	    ),
    @NamedQuery(
	        name = "getAllAccountRoles",
	        query = "select r from RoleEntityHibernate r"
	    ),
    @NamedQuery(
	        name = "deleteAccountRoleByRoleStatus",
	        query = "delete from RoleEntityHibernate r where r.roleStatus = :role"
	    )
})*/
@Table(name = "Roles")
public class RoleEntityHibernate implements Serializable{

	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name = "Roles")
	private String roleStatus;
	
	//@OneToMany(mappedBy = "accountRole", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@OneToMany(mappedBy = "role")	
	private List<AccountEntityHibernate2> accountEntities = new ArrayList<AccountEntityHibernate2>();

	public RoleEntityHibernate() {
		super();
	}	

	public RoleEntityHibernate(String roleStatus) {
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
	
	public List<AccountEntityHibernate2> getAccountEntities() {
		return accountEntities;
	}

	public void setAccountEntities(List<AccountEntityHibernate2> accountEntities) {
		this.accountEntities = accountEntities;
	}

	@Override
	public String toString() {
		return "AccountRoleEntity [roleId=" + roleId + ", roleStatus=" + roleStatus + "]";
	}	

}
