package by.kalilaska.security.hlam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Component
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	@Qualifier(value = "bcryptEncoder")
	private PasswordEncoder passwordEncoder;

	public AccountAuthenticationProvider() {
		super();
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		System.out.println("in AccountAuthenticationProvider additionalAuthenticationChecks()");
		System.out.println("userDetails: " + userDetails);

		if (authentication.getCredentials() == null) {
			// logger.debug("Authentication failed: no credentials provided");

			// throw new BadCredentialsException(messages.getMessage(
			// "AbstractUserDetailsAuthenticationProvider.badCredentials",
			// "Bad credentials"));
		}

		String presentedPassword = authentication.getCredentials().toString();

		if (!passwordEncoder.matches((String) authentication.getCredentials(), userDetails.getPassword())) {
			// logger.debug("Authentication failed: password does not match
			// storedvalue");

			// throw new BadCredentialsException(messages.getMessage(
			// "AbstractUserDetailsAuthenticationProvider.badCredentials",
			// "Bad credentials"));
		}

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		System.out.println("in AccountAuthenticationProvider retrieveUser()");

		return userDetails;
	}

}
