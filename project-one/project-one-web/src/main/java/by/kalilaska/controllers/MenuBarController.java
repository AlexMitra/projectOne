package by.kalilaska.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.services.AdCategoryService;

@Controller
public class MenuBarController {

	// @Autowired
	// @Qualifier(value = "ZabiraiServiceJDBC")
	// @Qualifier(value = "zabiraiServiceHibernate")
	// private ServiceOne zabiraiService;

	@Autowired
	@Qualifier(value = "accountDetailsPageBean")
	private UserDetails userDetails;

	@Autowired
	private AdCategoryService adCategoryService;

	@Autowired
	private BeansPool beansPool;

	@RequestMapping(value = { "/personalArea.html" }, method = RequestMethod.GET)
	public ModelAndView persinalArea() {

		if (isAuthenticated()) {
			return new ModelAndView("redirect:/personalArea/userPage.html");
		} else {
			return new ModelAndView("redirect:/personalArea/login.html");
		}

	}

	private boolean isAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("authentication: " + authentication);
		if (authentication != null) {
			if (authentication.getClass() == UsernamePasswordAuthenticationToken.class) {
				printDetails(authentication);
				return true;
			}
			if (authentication.getClass() == RememberMeAuthenticationToken.class) {
				printDetails(authentication);
				return true;
			}

		}

		return false;
	}

	private void printDetails(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		if (userDetails != null) {
			System.out.println("pass: " + userDetails.getPassword());
			System.out.println("userName: " + userDetails.getUsername());

			for (GrantedAuthority auth : userDetails.getAuthorities()) {
				System.out.println(auth.getAuthority());
			}
		}
	}

	@RequestMapping(value = { "/ads.html" }, method = RequestMethod.GET)
	public ModelAndView ads(/*
							 * @ModelAttribute(name="accountPageBean"
							 * UserAccountPageBean account
							 */) {
		AccountDetailsPageBean account = getAccountPageBean();
		ModelAndView modelAndView;
		if (account != null) {
			modelAndView = new ModelAndView("ads", "accountPageBean", account);
			return modelAndView;
		}
		account = new AccountDetailsPageBean();
		account.setAllAdCategories(adCategoryService.findAllCategoryNames());

		modelAndView = new ModelAndView("ads", "accountPageBean", account);

		return modelAndView;
	}

	private AccountDetailsPageBean getAccountPageBean() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null) {
			if (authentication.getClass() == UsernamePasswordAuthenticationToken.class) {
				return (AccountDetailsPageBean) authentication.getPrincipal();
			}
			if (authentication.getClass() == RememberMeAuthenticationToken.class) {
				return (AccountDetailsPageBean) authentication.getPrincipal();
			}

		}

		return null;
	}

	/*
	 * @ModelAttribute private Entity getAccount(){ //return
	 * EntitiesPool.getAccount(); return new Account(); }
	 */
}
