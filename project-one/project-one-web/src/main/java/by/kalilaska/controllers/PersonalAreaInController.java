package by.kalilaska.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.beans.AccountDetailsPageBean;

@Controller
public class PersonalAreaInController {

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

	private AccountDetailsPageBean getAccountPageBean() {
		AccountDetailsPageBean account = (AccountDetailsPageBean) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		return account;
	}

}
