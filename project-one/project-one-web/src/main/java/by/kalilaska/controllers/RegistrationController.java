package by.kalilaska.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.services.AccountRegistrationService;
import by.kalilaska.services.ServiceOne;
import by.kalilaska.services.exceptions.EmailExistsException;
import by.kalilaska.services.exceptions.LoginExistsException;
import by.kalilaska.services.exceptions.UnknownCauseAccountExistException;

@Controller
@Transactional
public class RegistrationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	// @Qualifier(value = "ZabiraiServiceJDBC")
	// @Qualifier(value = "zabiraiServiceHibernate")
	@Qualifier(value = "zabiraiServiceData")
	private ServiceOne zabiraiService;

	@Autowired
	private AccountRegistrationService registrationService;

	@Autowired
	private BeansPool beansPool;

	@RequestMapping(value = { "/personalArea/registration.html" }, method = RequestMethod.GET)
	public ModelAndView showRegistration(WebRequest request) {
		return new ModelAndView("registration", "accountPageBean", new AccountDetailsPageBean());
	}
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// @RequestMapping(value = { "/personalArea/registration.html" }, method =
	// RequestMethod.POST)
	// public ModelAndView registrationOn(@Valid @ModelAttribute(name =
	// "accountPageBean") AccountDetailsPageBean account,
	// BindingResult bindingResult, WebRequest request, Errors errors) {
	// if (bindingResult.hasErrors()) {
	// return new ModelAndView("registration", "accountPageBean", account);
	// }
	// if (zabiraiService.insertNewAccount(account)) {
	//
	// String redirect = "redirect:/personalArea/" + account.getAccountLogin() +
	// ".html";
	// ModelAndView modelAndView = new ModelAndView(redirect, "accountPageBean",
	// account);
	// return modelAndView;
	// }
	//
	// // System.out.println(account);
	// ModelAndView modelAndView = new ModelAndView("registration",
	// "accountPageBean", account);
	// return modelAndView;
	//
	// }
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	@RequestMapping(value = { "/personalArea/registration.html" }, method = RequestMethod.POST)
	public ModelAndView registrationOn(@Valid @ModelAttribute(name = "accountPageBean") AccountDetailsPageBean account,
			BindingResult bindingResult, WebRequest request, Errors errors) {
		AccountDetailsPageBean registered = null;

		if (bindingResult.hasErrors()) {

			return new ModelAndView("registration", "accountPageBean", account);
		}

		try {
			registered = registrationService.insertNewAccount(account);
		} catch (LoginExistsException e) {

			bindingResult.rejectValue("accountLogin", "error.registration.form.loginAlreadyExists");
			return new ModelAndView("registration", "accountPageBean", account);
		} catch (EmailExistsException e) {

			bindingResult.rejectValue("accountEmail", "error.registration.form.emailAlreadyExists");
			return new ModelAndView("registration", "accountPageBean", account);
		} catch (UnknownCauseAccountExistException e) {

			bindingResult.rejectValue("accountEmail", "error.registration.form.unknownExistence");
			return new ModelAndView("registration", "accountPageBean", account);
		}

		if (registered == null) {
			bindingResult.rejectValue("accountEmail", "registration.form.unknownExistence");
		}

		String redirect = "redirect:/personalArea/" + account.getAccountLogin() + ".html";
		autologin(registered);

		ModelAndView modelAndView = new ModelAndView(redirect);
		return modelAndView;

	}

	private void autologin(UserDetails account) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(account,
				account.getPassword(), account.getAuthorities());

		if (authentication.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

	}

}
