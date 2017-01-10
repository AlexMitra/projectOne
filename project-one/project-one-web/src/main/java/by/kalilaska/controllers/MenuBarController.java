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
import by.kalilaska.beans.AdminAccountPageBean;
import by.kalilaska.beans.UserAccountPageBean;

import by.kalilaska.services.ZabiraiService;

@Controller
public class MenuBarController {
	
	@Autowired
	private ZabiraiService zabiraiService;
	
	@Autowired
	private BeansPool beansPool;	

	
	@RequestMapping(value = {"/personalArea.html"}, method = RequestMethod.GET)
	public ModelAndView showLogIn(@ModelAttribute(name="userAccountPageBean") UserAccountPageBean account) {
		
		zabiraiService.test();
		
		if(account==null || account.getAccountLogin() == null){
//!!!		redirect:/personalArea/login.html
			return new ModelAndView("personalArea", "accountPageBean", beansPool.getUserAccountPageBean());
		}
//!!!		redirect:/personalArea/userPage.html		
		return new ModelAndView("userPersonalAreaIn", "accountPageBean", account);
	}
	
	
	
	@RequestMapping(value = {"/personalArea.html"}, method = RequestMethod.POST)
	public ModelAndView LogIn(@ModelAttribute(name="accountPageBean") UserAccountPageBean account) {
		if(zabiraiService.checkAccount(account)){
			if(account.getStatus().equals("Administrator")){
//!!!		redirect:/personalArea/AdminPage.html
				ModelAndView modelAndView = new ModelAndView("adminPersonalAreaIn", "adminPage", account);
				return modelAndView;
			}else{
//!!!		redirect:/personalArea/userPage.html
				ModelAndView modelAndView = new ModelAndView("userPersonalAreaIn", "userPage", account);
				return modelAndView;
			}			
			
		}

		ModelAndView modelAndView = new ModelAndView("personalArea", "accountPageBean", account);
		return modelAndView;
	}
	
	@RequestMapping(value = {"/registration.html"}, method = RequestMethod.GET)
	public ModelAndView showRegistration() {
		return new ModelAndView("registration", "accountPageBean", beansPool.getUserAccountPageBean());
	}
	
	@RequestMapping(value = {"/registration.html"}, method = RequestMethod.POST)
	public ModelAndView registrationOn(@Valid @ModelAttribute(name="accountPageBean") UserAccountPageBean account, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return new ModelAndView("registration", "accountPageBean", account);
		}
		if(zabiraiService.insertNewAccount(account)){
//!!!		redirect:/personalArea/userPage.html
			ModelAndView modelAndView = new ModelAndView("userPersonalAreaIn", "accountPageBean", account);
			System.out.println("after registration: " + account);
			return modelAndView;
		}
		
		//System.out.println(account);
		ModelAndView modelAndView = new ModelAndView("registration", "accountPageBean", account);
		return modelAndView;
		
	}
	
	/*@ModelAttribute
	private Entity getAccount(){
		//return EntitiesPool.getAccount();
		return new Account();
	}*/
}
