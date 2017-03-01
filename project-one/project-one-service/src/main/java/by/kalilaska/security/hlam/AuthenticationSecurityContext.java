package by.kalilaska.security.hlam;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;

//@Service
public class AuthenticationSecurityContext implements SecurityContext {

	private Authentication authentication;

	public String getBadAuthenticationMessage() {
		return badAuthenticationMessage;
	}

	public void setBadAuthenticationMessage(String badAuthenticationMessage) {
		this.badAuthenticationMessage = badAuthenticationMessage;
	}

	private String badAuthenticationMessage;

	// ~ Methods
	// ========================================================================================================

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SecurityContextImpl) {
			SecurityContextImpl test = (SecurityContextImpl) obj;

			if ((this.getAuthentication() == null) && (test.getAuthentication() == null)) {
				return true;
			}

			if ((this.getAuthentication() != null) && (test.getAuthentication() != null)
					&& this.getAuthentication().equals(test.getAuthentication())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Authentication getAuthentication() {
		return authentication;
	}

	@Override
	public int hashCode() {
		if (this.authentication == null) {
			return -1;
		} else {
			return this.authentication.hashCode();
		}
	}

	@Override
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());

		if (this.authentication == null) {
			sb.append("Custom: Null authentication");
		} else {
			sb.append("Custom: Authentication: ").append(this.authentication);
		}

		return sb.toString();
	}

}
