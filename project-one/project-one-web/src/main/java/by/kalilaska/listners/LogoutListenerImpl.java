package by.kalilaska.listners;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.userdetails.UserDetails;

import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.loggers.LoggerMaster;

public class LogoutListenerImpl implements ApplicationListener<SessionDestroyedEvent> {

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {

		List<SecurityContext> lstSecurityContext = event.getSecurityContexts();
		UserDetails userDetails;
		for (SecurityContext securityContext : lstSecurityContext) {
			userDetails = (UserDetails) securityContext.getAuthentication().getPrincipal();
			if (userDetails instanceof AccountDetailsPageBean) {
				LoggerMaster.setupClass(this.getClass());
				LoggerMaster.info(userDetails.getUsername() + " log out");

			}
		}

	}

}
