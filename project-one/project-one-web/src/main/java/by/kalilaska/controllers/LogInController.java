package by.kalilaska.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.BeansPool;
import by.kalilaska.services.ServiceOne;

@Controller
public class LogInController {

	@Autowired
	// @Qualifier(value = "ZabiraiServiceJDBC")
	// @Qualifier(value = "zabiraiServiceHibernate")
	@Qualifier(value = "zabiraiServiceData")
	private ServiceOne zabiraiService;

	@Autowired
	private BeansPool beansPool;

	@RequestMapping(value = { "/personalArea/login.html" }, method = RequestMethod.GET)
	public ModelAndView showLogIn() {

		return new ModelAndView("login");
	}

	@RequestMapping(value = { "/personalArea/login.html" }, method = RequestMethod.POST)
	public ModelAndView showLogIn(@RequestParam(value = "error", required = false) String error) {

		if (error != null) {
			return new ModelAndView("login", "badAuthentication", true);
		}

		return new ModelAndView("login");
	}

	private void printUserDetails() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println("pass: " + userDetails.getPassword());
		System.out.println("userName: " + userDetails.getUsername());

		for (GrantedAuthority auth : userDetails.getAuthorities()) {
			System.out.println(auth.getAuthority());
		}
	}

}
