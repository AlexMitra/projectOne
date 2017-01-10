package by.kalilaska.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.beans.Account;


@RestController
//@RequestMapping(value="/project-one-web/personalArea/api/accounts", produces="application/json")
public class AdminAreaMenuController {
	
	static{
		System.out.println("AdminAreaMenuController");
	}
	
	/*@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getAllAccounts() {
		return new ResponseEntity<String>("getAllAccounts", HttpStatus.OK);
	}*/	
	
	@RequestMapping(value="/project-one-web/personalArea/api/accounts", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Account> getAllAccounts() {
		return new ArrayList<Account>();
	}	
	
	@RequestMapping(value="/project-one-web/personalArea/api/account", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Account getJsonAccount(@RequestParam("login") String login) {
		Account account = new Account();
		account.setAccountLogin(login);
		return account;
	}
	
	@RequestMapping(value="/project-one-web/personalArea/api/account/{login}", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Account getJsonAccount2(@PathVariable("login") String login) {
		Account account = new Account();
		account.setAccountLogin(login);
		System.out.println("getJsonAccount2() account: " + account);
		return account;
	}
	
	@RequestMapping(value="/project-one-web/personalArea/api/put-account", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<String> setJsonAccount(@RequestBody Account account) {
		System.out.println(account.getAccountLogin());
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

}
