package by.kalilaska.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.AccountForLogInBean;
import by.kalilaska.beans.AccountForRegistrationBean;
import by.kalilaska.beans.AdminAccountPageBean;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.daoJDBC.ZabiraiJDBC;
import by.kalilaska.services.ZabiraiService;

@Controller
public class MenuBarController {
	
	@Autowired
	private ZabiraiService zabiraiService;
	
	@Autowired
	private BeansPool beansPool;
	
	@Autowired
	private ZabiraiJDBC zabiraiJDBC;
	
	@RequestMapping(value = {"/personalArea"}, method = RequestMethod.GET)
	public ModelAndView showLogIn() {
		//Object acc = zabiraiJDBC.getAllAccounts();
		//System.out.println("in menuBarController:\n" + acc);
		//System.out.println(zabiraiJDBC);
		//zabiraiJDBC.insertAccount();
		return new ModelAndView("personalArea", "logInAccount", beansPool.getAccountForLogInBean());
	}
	
	@RequestMapping(value = {"/personalArea"}, method = RequestMethod.POST)
	public ModelAndView LogIn(@ModelAttribute(name="logInAccount") AccountForLogInBean account) {
		if(zabiraiService.checkAccount(account)){
			if(account.getStatus().equals("Administrator")){
				UserAccountPageBean userAccountPageBean = zabiraiService.getUserAccountPageBean(account);
				System.out.println(userAccountPageBean);
				ModelAndView modelAndView = new ModelAndView("adminPersonalAreaIn", "adminPage", userAccountPageBean);
				return modelAndView;
			}else{
				UserAccountPageBean userAccountPageBean = zabiraiService.getUserAccountPageBean(account);
				System.out.println(userAccountPageBean);
				ModelAndView modelAndView = new ModelAndView("userPersonalAreaIn", "userPage", userAccountPageBean);
				return modelAndView;
			}			
			
		}

		ModelAndView modelAndView = new ModelAndView("personalArea", "logInAccount", account);
		return modelAndView;
	}
	
	@RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
	public ModelAndView showRegistration() {
		return new ModelAndView("registration", "newAccount", beansPool.getAccountForRegistration());
	}
	
	@RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
	public ModelAndView registrationOn(@Valid @ModelAttribute(name="newAccount") AccountForRegistrationBean account, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return new ModelAndView("registration", "newAccount", account);
		}
		if(zabiraiService.insertNewAccount(account)){			
			UserAccountPageBean userAccountPageBean = zabiraiService.getUserAccountPageBean(account);
			System.out.println(userAccountPageBean);
			ModelAndView modelAndView = new ModelAndView("userPersonalAreaIn", "userPage", userAccountPageBean);
			return modelAndView;
		}
		
		//System.out.println(account);
		ModelAndView modelAndView = new ModelAndView("registration", "newAccount", account);
		return modelAndView;
		
	}
	
	/*@ModelAttribute
	private Entity getAccount(){
		//return EntitiesPool.getAccount();
		return new Account();
	}*/
}
