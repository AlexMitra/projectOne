package by.kalilaska.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.EntitiesPool;
import by.kalilaska.daoJDBC.ZabiraiJDBC;
import by.kalilaska.daoJDBC.ZabiraiJDBCPool;
import by.kalilaska.entities.Account;

@Controller
public class MenuBarController {
	
	@Autowired
	private EntitiesPool entitiesPool;
	
	@Autowired
	private ZabiraiJDBC zabiraiJDBC;
	
	@RequestMapping(value = {"/personalArea"})
	public String LogIn() {
		Object acc = zabiraiJDBC.getAllAccounts();
		System.out.println("acc:\n" + acc);
		//System.out.println(zabiraiJDBC);
		//zabiraiJDBC.insertAccount();
		return "personalArea";
	}
	
	@RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
	public ModelAndView showRegistration() {
		return new ModelAndView("registration", "account", entitiesPool.getAccount());
	}
	
	@RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
	public ModelAndView registrationOn(@Valid @ModelAttribute(name="account") Account account, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return new ModelAndView("registration", "account", account);
		}
		zabiraiJDBC.insertAccount(account);
		ModelAndView modelAndView = new ModelAndView("personalAreaIn", "account", account);
		return modelAndView;
	}
	
	/*@ModelAttribute
	private Entity getAccount(){
		//return EntitiesPool.getAccount();
		return new Account();
	}*/
}
