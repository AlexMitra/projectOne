package by.kalilaska.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.beans.AdBean;
import by.kalilaska.beans.HomePageBean;
import by.kalilaska.beans.UserAccountPageBean;
import by.kalilaska.services.AdService;

@Controller
public class HomeController {

	@Autowired
	@Qualifier(value = "accountDetailsPageBean")
	private UserDetails userDetails;

	@Autowired
	private AdService adService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute(name = "homePagebean") HomePageBean homePagebean) {

		ModelAndView modelAndView;
		int adsNumber = 0;

		List<AdBean> adBeanList = adService.getAllAdsWithFieldEnabled(true, 0, 20);
		adsNumber = adBeanList.size();

		if (adsNumber > 5) {
			homePagebean.insertAdList(getListRandomIds(5, adBeanList));
		} else if (adsNumber > 3) {
			homePagebean.insertAdList(getListRandomIds(3, adBeanList));
		} else if (adsNumber >= 1) {
			homePagebean.insertAdList(adService.getAllAdsWithFieldEnabled(true));
		}

		System.out.println(homePagebean);
		modelAndView = new ModelAndView("home", "homePagebean", homePagebean);
		return modelAndView;
	}

	private List<AdBean> getListRandomIds(int listSize, List<AdBean> adBeanList) {

		Random rand = new Random();
		List<AdBean> randomAdsList = new ArrayList<>();
		int count = 0;
		int next;
		do {
			next = rand.nextInt(adBeanList.size());
			if (!randomAdsList.contains(adBeanList.get(next))) {
				randomAdsList.add(adBeanList.get(next));
				count++;
			}

		} while (count < listSize - 1);

		return randomAdsList;

	}

	@RequestMapping(value = { "/home.html" }, method = RequestMethod.GET)
	public ModelAndView home2(@ModelAttribute(name = "accountPageBean") UserAccountPageBean account) {
		ModelAndView modelAndView = new ModelAndView("home", "accountPageBean", account);
		return modelAndView;
	}

	private void printUserDetails() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal.getClass() == userDetails.getClass()) {
			UserDetails userDetails = (UserDetails) principal;

			System.out.println("pass: " + userDetails.getPassword());
			System.out.println("userName: " + userDetails.getUsername());

			for (GrantedAuthority auth : userDetails.getAuthorities()) {
				System.out.println(auth.getAuthority());
			}

		}

	}
}
