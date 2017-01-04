package by.kalilaska.entities;

public class AccountRoleEntity {
	
	private int roleId;
	
	private String roleRole;	

	public AccountRoleEntity() {
		super();
	}

	public int getRoleId() {
		return roleId;
	}

	public String getRoleRole() {
		return roleRole;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setRoleRole(String roleRole) {
		this.roleRole = roleRole;
	}

	@Override
	public String toString() {
		return "AccountRoleEntity [roleId=" + roleId + ", roleRole=" + roleRole + "]";
	}

}
