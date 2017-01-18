package by.kalilaska.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.services.ServiceOne;
import by.kalilaska.services.ZabiraiService;

@Controller
public class RegistrationController {
	
	@Autowired
	private ZabiraiService zabiraiService;
	
	@Autowired
	private ServiceOne zabiraiServiceHibernate;
	
	@Autowired
	private BeansPool beansPool;
	
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

}
