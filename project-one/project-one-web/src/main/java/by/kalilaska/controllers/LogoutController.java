package by.kalilaska.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = { "/personalArea/logoutSuccess.html" }, method = RequestMethod.POST)
	public ModelAndView logoutSuccess() {
		String redirect = "redirect:/personalArea/login.html";
		return new ModelAndView(redirect, "logOutSuccess", true);

	}
}
