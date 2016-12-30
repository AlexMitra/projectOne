package by.kalilaska.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value="/project-one-web/personalArea/api/accounts", produces="application/json")
public class AdminAreaMenuController {
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getAllAccounts() {
		return new ResponseEntity<String>("getAllAccounts", HttpStatus.OK);
	}	

}
