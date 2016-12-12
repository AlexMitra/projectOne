package by.kalilaska.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.beans.EntitiesPool;
import by.kalilaska.interfaces.Entity;


@Controller
public class HomeController {
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String Home() {
		return "home";
	}
	
	@RequestMapping(value = {"/logIn"})
	public String LogIn() {
		return "logIn";
	}
	
//	@RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
//	public ModelAndView showRegistration() {
//		return new ModelAndView("registration", "account", new Account());
//	}
	
	@RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
	public ModelAndView showRegistration() {
		return new ModelAndView("registration");
	}
	
	@RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
	public ModelAndView registrationOn(@ModelAttribute(name="account") Entity account) {
		ModelAndView modelAndView = new ModelAndView("home", "account", account);
		return modelAndView;
	}
	
	@ModelAttribute
	private Entity getAccount(){
		return EntitiesPool.getAccount();
	}	

}
