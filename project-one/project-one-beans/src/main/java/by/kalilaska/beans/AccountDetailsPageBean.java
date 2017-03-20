package by.kalilaska.beans;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import by.kalilaska.beans.annotations.PasswordMatches;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@PasswordMatches(message = "{error.accountPasswordOnceMore.match}")
public class AccountDetailsPageBean implements UserDetails {

	private static final long serialVersionUID = 1L;

	private long id;

	@Pattern(regexp = "^[a-zA-Z_0-9]{5,20}$", message = "{error.accountLogin.pattern}")
	private String accountLogin;

	@Email(message = "{error.accountEmail.email}", regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String accountEmail;

	@Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "{error.accountPassword.pattern}")
	private String accountPassword;

	private String accountPasswordOnceMore;

	private boolean enabled;

	private Set<GrantedAuthority> authorities;

	private List<RoleBean> allAuthorities;

	private List<AdCategoryBean> allAdCategories;

	public AccountDetailsPageBean() {
		super();
		this.id = 0;
		this.accountLogin = null;
		this.accountEmail = null;
		this.accountPassword = null;
		this.enabled = false;
		this.authorities = null;
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
				+ ", accountPassword=" + accountPassword + ", accountPasswordOnceMore=" + accountPasswordOnceMore
				+ ", enabled=" + enabled + ", authorities=" + authorities + "]";
	}

}
