package by.kalilaska.entities;

public class AccountToRoleEntity {
	
	private long fkAccountId;
	
	private int fkRoleId;	

	public AccountToRoleEntity() {
		
	}

	public int getFkRoleId() {
		return fkRoleId;
	}

	public long getFkAccountId() {
		return fkAccountId;
	}

	public void setFkRoleId(int fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	public void setFkAccountId(long fkAccountId) {
		this.fkAccountId = fkAccountId;
	}

	@Override
	public String toString() {
		return "AccountToRoleEntity [fkAccountId=" + fkAccountId + ", fkRoleId=" + fkRoleId + "]";
	}	

}
