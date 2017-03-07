package by.kalilaska.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.AccountDetailsPageBean;
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

	private AccountDetailsPageBean getAccountPageBean() {
		AccountDetailsPageBean account = (AccountDetailsPageBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		return account;
	}

	@RequestMapping(value = { "/personalArea/userPage.html" }, method = RequestMethod.GET)
	public ModelAndView loginSuccess() {

		AccountDetailsPageBean account = getAccountPageBean();
		String redirect = "redirect:/personalArea/" + account.getAccountLogin() + ".html";

		ModelAndView modelAndView = new ModelAndView(redirect);
		return modelAndView;
	}

	@RequestMapping(value = { "/personalArea/{accountLogin}.html" }, method = RequestMethod.GET)
	public ModelAndView showPersonalAreaPage(@PathVariable String accountLogin) {

		AccountDetailsPageBean account = getAccountPageBean();

		ModelAndView modelAndView = new ModelAndView("personalAreaIn", "accountPageBean", account);
		return modelAndView;
	}

}
