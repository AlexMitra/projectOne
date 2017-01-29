package by.kalilaska.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.AdminAccountPageBean;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.services.ServiceOne;
import by.kalilaska.services.impls.ZabiraiServiceJDBC;
import by.kalilaska.services.impls.ZabiraiServiceHibernate;

@Controller
public class MenuBarController {
	
	@Autowired
	//@Qualifier(value = "ZabiraiServiceJDBC")
	@Qualifier(value = "zabiraiServiceHibernate")
	private ServiceOne zabiraiService;
	
	/*@Autowired
	@Qualifier(value = "zabiraiServiceHibernate")
	private ServiceOne zabiraiServiceHibernate;*/
	
	@Autowired
	private BeansPool beansPool;	

	
	@RequestMapping(value = {"/personalArea.html"}, method = RequestMethod.GET)
	public ModelAndView persinalArea(@ModelAttribute(name="userAccountPageBean") UserAccountPageBean account) {
		
		//zabiraiService.test();
		
		if(account==null || account.getAccountLogin() == null){
			return new ModelAndView("redirect:/personalArea/login.html", "accountPageBean", beansPool.getUserAccountPageBean());
		}else if(account.getStatus().equals("Administrator")){
			String redirect = "redirect:/personalArea/admin/" + account.getAccountLogin() + ".html";				
			ModelAndView modelAndView = new ModelAndView(redirect, "accountPageBean", account);
			return modelAndView;
		}else{
			String redirect = "redirect:/personalArea/user/" + account.getAccountLogin() + ".html";
			ModelAndView modelAndView = new ModelAndView(redirect, "accountPageBean", account);
			return modelAndView;
		}
	}
	
	/*@RequestMapping(value = {"/personalArea/login.html"}, method = RequestMethod.GET)
	public ModelAndView showLogIn(@ModelAttribute(name="userAccountPageBean") UserAccountPageBean account) {

		return new ModelAndView("login", "accountPageBean", account);
	}	
	
	@RequestMapping(value = {"/personalArea/login.html"}, method = RequestMethod.POST)
	public ModelAndView LogIn(@ModelAttribute(name="accountPageBean") UserAccountPageBean account, Model model) {
		if(zabiraiService.checkAccount(account)){
			model.addAttribute("accountLogin", account.getAccountLogin());
			
			if(account.getStatus().equals("Administrator")){
				String redirect = "redirect:/personalArea/admin/" + account.getAccountLogin() + ".html";				
				ModelAndView modelAndView = new ModelAndView(redirect, "accountPageBean", account);
				return modelAndView;
			}else{
				String redirect = "redirect:/personalArea/user/" + account.getAccountLogin() + ".html";
				ModelAndView modelAndView = new ModelAndView(redirect, "accountPageBean", account);
				return modelAndView;
			}			
			
		}

		ModelAndView modelAndView = new ModelAndView("login", "accountPageBean", account);
		return modelAndView;
	}
	
	@RequestMapping(value = {"/personalArea/registration.html"}, method = RequestMethod.GET)
	public ModelAndView showRegistration() {
		return new ModelAndView("registration", "accountPageBean", beansPool.getUserAccountPageBean());
	}
	
	@RequestMapping(value = {"/personalArea/registration.html"}, method = RequestMethod.POST)
	public ModelAndView registrationOn(@Valid @ModelAttribute(name="accountPageBean") UserAccountPageBean account, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return new ModelAndView("registration", "accountPageBean", account);
		}
		if(zabiraiService.insertNewAccount(account)){
			
			String redirect = "redirect:/personalArea/user/" + account.getAccountLogin() + ".html";				
			ModelAndView modelAndView = new ModelAndView(redirect, "accountPageBean", account);
			return modelAndView;
		}
		
		//System.out.println(account);
		ModelAndView modelAndView = new ModelAndView("registration", "accountPageBean", account);
		return modelAndView;
		
	}
	
	@RequestMapping(value = {"/personalArea/admin/{accountLogin}.html"}, method = RequestMethod.GET)
	public ModelAndView showAdminPage(@PathVariable String accountLogin, @ModelAttribute(name="accountPageBean") UserAccountPageBean account) {

		ModelAndView modelAndView = new ModelAndView("adminPersonalAreaIn", "accountPageBean", account);
		return modelAndView;
	}
	
	@RequestMapping(value = {"/personalArea/user/{accountLogin}.html"}, method = RequestMethod.GET)
	public ModelAndView showUserPage(@PathVariable String accountLogin, @ModelAttribute(name="accountPageBean") UserAccountPageBean account) {

		ModelAndView modelAndView = new ModelAndView("userPersonalAreaIn", "accountPageBean", account);
		return modelAndView;
	}*/
	
	/*@ModelAttribute
	private Entity getAccount(){
		//return EntitiesPool.getAccount();
		return new Account();
	}*/
}
