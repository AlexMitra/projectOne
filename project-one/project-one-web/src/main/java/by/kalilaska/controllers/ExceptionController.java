package by.kalilaska.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	@RequestMapping(value = { "/exception.html" }, method = RequestMethod.GET)
	public ModelAndView throwException() {
		return new ModelAndView("exception", "exceptionMessage", "some exception message");

	}
}
