package by.kalilaska.beans;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import by.kalilaska.beans.annotations.PasswordMatches;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@PasswordMatches
public class AccountDetailsPageBean implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	@NotNull
	@Size(min = 5, max = 20, message = "login have to have more than 5 symbols and less than 21 symbol")
	@Pattern(regexp = "^[a-zA-Z_0-9]{5,20}$", message = "login must have norm symbols")
	private String accountLogin;

	// @ValidEmail(message = "@ValidEmail message")
	@NotNull
	@NotEmpty
	@Email(message = "bad email", regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	// @Size(min = 5, max = 20, message = "email have to be correct")
	private String accountEmail;

	@NotNull
	@Size(min = 5, max = 20)
	@Pattern(regexp = "^[a-zA-Z_0-9]{5,20}$", message = "login must have norm symbols")
	// @Size(min = 5, max = 20, message = "login have to have more than 5
	// symbols and less than 21 symbol")
	private String accountPassword;

	@NotNull
	@Size(min = 5, max = 20)
	private String accountPasswordOnceMore;

	private boolean enabled;

	private Set<GrantedAuthority> authorities;

	private String loginCheck;

	private String emailCheck;

	private String passwordCheck;

	public AccountDetailsPageBean() {
		super();
		this.id = 0;
		this.accountLogin = null;
		this.accountEmail = null;
		this.accountPassword = null;
		this.enabled = false;
		this.authorities = null;
		this.loginCheck = null;
		this.emailCheck = null;
		this.passwordCheck = null;
	}

	public AccountDetailsPageBean(long id, String accountLogin, String accountEmail, String accountPassword,
			boolean enabled, Set<GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.accountLogin = accountLogin;
		this.accountEmail = accountEmail;
		this.accountPassword = accountPassword;
		this.enabled = enabled;
		this.authorities = authorities;
		this.loginCheck = null;
		this.emailCheck = null;
		this.passwordCheck = null;
	}

	@Override
	public String getPassword() {
		return accountPassword;
	}

	@Override
	public String getUsername() {
		return accountLogin;
	}

	@Override
	public boolean isAccountNonExpired() {
		return enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return enabled;
	}

	@Override
	public String toString() {
		return "AccountDetailsPageBean [id=" + id + ", accountLogin=" + accountLogin + ", accountEmail=" + accountEmail
				+ ", accountPassword=" + accountPassword + ", enabled=" + enabled + ", authorities=" + authorities
				+ "]";
	}

}
