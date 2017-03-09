package by.kalilaska.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.loggers.LoggerMaster;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		UserDetails userDetails;
		LoggerMaster.setupClass(this.getClass());

		if (authentication != null && authentication.getDetails() != null) {
			try {
				userDetails = (UserDetails) authentication.getPrincipal();
				if (userDetails instanceof AccountDetailsPageBean) {
					LoggerMaster.setupClass(this.getClass());
					LoggerMaster.info(userDetails.getUsername() + " log out");

				}

				request.getSession().invalidate();

			} catch (Exception e) {
				LoggerMaster.error("Exception: " + e);
			}
		}

		response.setStatus(HttpServletResponse.SC_OK);
		request.getRequestDispatcher("/personalArea/logoutSuccess.html").forward(request, response);

	}

}
