package by.kalilaska.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleBean {

	private int roleId;

	private String roleStatus;

	public RoleBean() {
		super();

	}

	@Override
	public String toString() {
		return "RoleBean [roleId=" + roleId + ", roleStatus=" + roleStatus + "]";
	}

}
