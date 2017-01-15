package by.kalilaska.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@RequestMapping(value = {"/", "/home.html"}, method = RequestMethod.GET)
	public String Home() {
		return "home";
	}
}
