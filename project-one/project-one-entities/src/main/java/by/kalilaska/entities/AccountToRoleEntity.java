package by.kalilaska.entities;

public class AccountToRoleEntity {
	
	private long id;
	
	private int fkRoleId;
	
	private long fkAccountId;

	public AccountToRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public int getFkRoleId() {
		return fkRoleId;
	}

	public long getFkAccountId() {
		return fkAccountId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFkRoleId(int fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	public void setFkAccountId(long fkAccountId) {
		this.fkAccountId = fkAccountId;
	}

	@Override
	public String toString() {
		return "AccountToRoleEntity [id=" + id + ", fkRoleId=" + fkRoleId + ", fkAccountId=" + fkAccountId + "]";
	}	

}
