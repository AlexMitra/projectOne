package by.kalilaska.entities.enums;

public enum Authorities {
	ADMINISTRATOR("Administrator"), MODERATOR("Moderator"), USER("User");
	public String role;

	Authorities(String role) {
		this.role = role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return getRole();
	}

}
