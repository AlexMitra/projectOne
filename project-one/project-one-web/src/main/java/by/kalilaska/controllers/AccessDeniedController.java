package by.kalilaska.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessDeniedController {

	@RequestMapping(value = { "/accessDenied", "/home.html" }, method = RequestMethod.GET)
	public ModelAndView getAccessDenied() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("accessDenied");
		return modelAndView;
	}

}
