package by.kalilaska.entities.forHibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
		@NamedQuery(name = "getAccountRoleByRoleStatus", query = "select r from RoleEntityHibernate r where r.roleStatus = :role"),
		@NamedQuery(name = "getAllAccountRoles", query = "select r from RoleEntityHibernate r"),
		@NamedQuery(name = "deleteAccountRoleByRoleStatus", query = "delete from RoleEntityHibernate r where r.roleStatus = :role") })
@Table(name = "Roles")
@Getter
@Setter
public class RoleEntityHibernate {

	@Id
	@Column(name = "Role_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;

	@Column(name = "Role")
	private String roleStatus;

	@OneToMany(targetEntity = AccountEntityHibernate.class, mappedBy = "accountRole", fetch = FetchType.LAZY)
	private List<AccountEntityHibernate> accountEntities;

	public RoleEntityHibernate() {
		super();
	}

	public RoleEntityHibernate(String roleStatus) {
		super();
		this.roleStatus = roleStatus;
	}

	@Override
	public String toString() {
		return "RoleEntityHibernate [roleId=" + roleId + ", roleStatus=" + roleStatus + "]";
	}

}
