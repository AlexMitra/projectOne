package by.kalilaska.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.beans.UserAccountPageBean;

@Controller
public class HomeController {

	@Autowired
	@Qualifier(value = "accountDetailsPageBean")
	UserDetails userDetails;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home() {
		// String redirect = "redirect:/home.html";
		// ModelAndView modelAndView = new ModelAndView(redirect);
		// return modelAndView;
		printUserDetails();
		return "home";
	}

	@RequestMapping(value = { "/home.html" }, method = RequestMethod.GET)
	public ModelAndView home2(@ModelAttribute(name = "accountPageBean") UserAccountPageBean account) {
		ModelAndView modelAndView = new ModelAndView("home", "accountPageBean", account);
		return modelAndView;
	}

	private void printUserDetails() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal.getClass() == userDetails.getClass()) {
			UserDetails userDetails = (UserDetails) principal;

			System.out.println("pass: " + userDetails.getPassword());
			System.out.println("userName: " + userDetails.getUsername());

			for (GrantedAuthority auth : userDetails.getAuthorities()) {
				System.out.println(auth.getAuthority());
			}

		}

	}
}
