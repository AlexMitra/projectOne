package by.kalilaska.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.UserAccountPageBean;

@Controller
public class MenuBarController {
	
	//@Autowired
	//@Qualifier(value = "ZabiraiServiceJDBC")
	//@Qualifier(value = "zabiraiServiceHibernate")
	//private ServiceOne zabiraiService;
	
	@Autowired
	private BeansPool beansPool;
	
	@RequestMapping(value = {"/personalArea.html"}, method = RequestMethod.GET)
	public ModelAndView persinalArea(@ModelAttribute(name="accountPageBean") UserAccountPageBean account) {
		
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
	
	@RequestMapping(value = {"/ads.html"}, method = RequestMethod.GET)
	public ModelAndView ads(/*@ModelAttribute(name="accountPageBean" UserAccountPageBean account*/){
		ModelAndView modelAndView = new ModelAndView("ads"/*, "accountPageBean", account*/);
		return modelAndView;
	}
	
	/*@ModelAttribute
	private Entity getAccount(){
		//return EntitiesPool.getAccount();
		return new Account();
	}*/
}
