package by.kalilaska.services.impls;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.entities.enums.Authorities;
import by.kalilaska.services.ContentService;
import by.kalilaska.services.RoleService;

@Service
public class ContentServiceBySD implements ContentService {

	@Autowired
	private RoleService roleService;

	@Override
	public void addContent(AccountDetailsPageBean pageBean) {
		Set<GrantedAuthority> authorities = null;

		try {
			authorities = pageBean.getAuthorities();
		} catch (Exception e) {

		}

		if (authorities != null) {
			for (GrantedAuthority authority : authorities) {
				if (authority.getAuthority().equals(Authorities.ADMINISTRATOR.getRole())) {
					pageBean.setAllAuthorities(roleService.findAllRoleNames());

				} else if (authority.getAuthority().equals(Authorities.MODERATOR.getRole())) {

				} else if (authority.getAuthority().equals(Authorities.USER.getRole())) {

				}

			}
		}

	}

}
