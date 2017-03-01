package by.kalilaska.security;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.entities.forHibernate.AccountEntityHibernate;
import by.kalilaska.services.AccountService;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private HttpSession session;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AccountEntityHibernate accountEntity = accountService.findByAccountLogin(username);

		if (accountEntity != null) {
			Long id = accountEntity.getAccountId();
			String email = accountEntity.getAccountEmail();
			String password = accountEntity.getAccountPassword();

			boolean enabled = true;
			// boolean accountNonExpired = true;
			// boolean credentialsNonExpired = true;
			// boolean accountNonLocker = true;

			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(accountEntity.getAccountRole().getRoleStatus()));

			AccountDetailsPageBean accountPageBean = new AccountDetailsPageBean(id, username, email, password, enabled,
					authorities);

			return accountPageBean;
		} else {
			throw new UsernameNotFoundException("Account with this login not found!");

		}

	}

}
