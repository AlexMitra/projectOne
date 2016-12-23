package by.kalilaska.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.beans.Account;
import by.kalilaska.beans.EntitiesPool;
import by.kalilaska.interfaces.Entity;
import by.kalilaska.interfaces.Pool;


@Controller
public class HomeController {
	
	@Autowired
	private Pool entitiesPool;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String Home() {
		return "home";
	}
	
	@RequestMapping(value = {"/personalArea"})
	public String LogIn() {
		return "personalArea";
	}
	
//	@RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
//	public ModelAndView showRegistration() {
//		return new ModelAndView("registration", "account", new Account());
//	}
	
	@RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
	public ModelAndView showRegistration() {
		return new ModelAndView("registration", "account", entitiesPool.getAccount());
	}
	
	@RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
	public ModelAndView registrationOn(@Valid @ModelAttribute(name="account") Account account, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return new ModelAndView("registration", "account", account);
		}
		ModelAndView modelAndView = new ModelAndView("home", "account", account);
		return modelAndView;
	}
	
	/*@ModelAttribute
	private Entity getAccount(){
		//return EntitiesPool.getAccount();
		return new Account();
	}	*/

}
