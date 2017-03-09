package by.kalilaska.listners;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.loggers.LoggerMaster;

@Component
public class AuthenticationSuccessListenerImpl implements ApplicationListener<AuthenticationSuccessEvent> {

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent appEvent) {
		AuthenticationSuccessEvent event = appEvent;
		UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
		if (userDetails instanceof AccountDetailsPageBean) {
			LoggerMaster.setupClass(this.getClass());
			LoggerMaster.info(userDetails.getUsername() + " log In");
		}

	}

}
