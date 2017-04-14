package by.kalilaska.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.BeansPool;
import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.beans.AdCategoryBean;
import by.kalilaska.beans.AdsPageBean;
import by.kalilaska.services.AdCategoryService;
import by.kalilaska.services.AdService;

@Controller
public class MenuBarController {

	// @Autowired
	// @Qualifier(value = "ZabiraiServiceJDBC")
	// @Qualifier(value = "zabiraiServiceHibernate")
	// private ServiceOne zabiraiService;

	@Autowired
	@Qualifier(value = "accountDetailsPageBean")
	private UserDetails userDetails;

	@Autowired
	private AdCategoryService adCategoryService;

	@Autowired
	private AdService adService;

	@Autowired
	private BeansPool beansPool;

	@RequestMapping(value = { "/personalArea.html" }, method = RequestMethod.GET)
	public ModelAndView persinalArea() {

		if (isAuthenticated()) {
			return new ModelAndView("redirect:/personalArea/userPage.html");
		} else {
			return new ModelAndView("redirect:/personalArea/login.html");
		}

	}

	private boolean isAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("authentication: " + authentication);
		if (authentication != null) {
			if (authentication.getClass() == UsernamePasswordAuthenticationToken.class) {
				printDetails(authentication);
				return true;
			}
			if (authentication.getClass() == RememberMeAuthenticationToken.class) {
				printDetails(authentication);
				return true;
			}

		}

		return false;
	}

	private void printDetails(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		if (userDetails != null) {
			System.out.println("pass: " + userDetails.getPassword());
			System.out.println("userName: " + userDetails.getUsername());

			for (GrantedAuthority auth : userDetails.getAuthorities()) {
				System.out.println(auth.getAuthority());
			}
		}
	}

	@RequestMapping(value = { "/ads.html" }, method = RequestMethod.GET)
	public ModelAndView ads(@ModelAttribute(name = "adsPageBean") AdsPageBean adsPageBean, HttpSession session,
			HttpServletRequest request) {

		ModelAndView modelAndView;
		adsPageBean = getAdsPageBeanFromSession(adsPageBean, session);
		adsPageBean.setPageNumber(0);

		long adsNumber = 0;
		long showedPagesNumber = 0;
		long adsNumberOnPage = 0;

		if (request.getParameter("selected") != null) {

			setSelectedCategories(adsPageBean, request);
			System.out.println("in selected section selectedCategories: " + adsPageBean.getSelectedCategorues());

			List<AdCategoryBean> adCategoryBeanList = new ArrayList<>();
			for (Long category : adsPageBean.getSelectedCategorues()) {
				adCategoryBeanList.add(adCategoryService.findByCategoryId(category));
			}

			adsNumber = adService.getSelectedCategoriesAdEnabledCount(adCategoryBeanList, true);
			System.out.println("adseNumber: " + adsNumber);
			showedPagesNumber = adsPageBean.getPageNumber() + 1;
			adsNumberOnPage = adsPageBean.getAdsNumberOnPage();

			if ((adsNumber - showedPagesNumber * adsNumberOnPage) > 0) {
				adsPageBean.setLastPage(false);
			} else {
				adsPageBean.setLastPage(true);
			}

			adsPageBean.setAllAds(adService.getAdsByAdCategoryWithFieldEnabled(adCategoryBeanList, true,
					adsPageBean.getPageNumber(), adsPageBean.getAdsNumberOnPage()));

			session.setAttribute("adsPageBean", adsPageBean);

			modelAndView = new ModelAndView("ads", "adsPageBean", adsPageBean);
			return modelAndView;
		}
		if (request.getParameter("clearForm") != null) {
			adsPageBean.getSelectedCategorues().clear();
		}

		adsNumber = adService.getAdEnabledCount(true);
		showedPagesNumber = adsPageBean.getPageNumber() + 1;
		adsNumberOnPage = adsPageBean.getAdsNumberOnPage();

		if ((adsNumber - showedPagesNumber * adsNumberOnPage) > 0) {
			adsPageBean.setLastPage(false);
		} else {
			adsPageBean.setLastPage(true);
		}

		adsPageBean.setAllAds(adService.getAllAdsWithFieldEnabled(true, adsPageBean.getPageNumber(),
				adsPageBean.getAdsNumberOnPage()));

		session.setAttribute("adsPageBean", adsPageBean);
		modelAndView = new ModelAndView("ads", "adsPageBean", adsPageBean);

		return modelAndView;
	}

	private AdsPageBean getAdsPageBeanFromSession(AdsPageBean adsPageBean, HttpSession session) {
		if (session.getAttribute("adsPageBean") != null) {
			adsPageBean = (AdsPageBean) session.getAttribute("adsPageBean");
		} else {
			adsPageBean = new AdsPageBean();
		}

		adsPageBean.setAllAdCategories(adCategoryService.findAllCategoryNamesWithFieldEnabled(true));

		return adsPageBean;
	}

	private void setSelectedCategories(AdsPageBean adsPageBean, HttpServletRequest request) {
		String selectedCategory = "";
		if (request.getParameter("selected") != null) {
			adsPageBean.getSelectedCategorues().clear();
		}

		System.out.println("after clear: " + adsPageBean.getSelectedCategorues());
		for (AdCategoryBean categoryBean : adsPageBean.getAllAdCategories()) {
			if (request.getParameter("category-" + categoryBean.getAdCategoryId()) != null) {
				selectedCategory = request.getParameter("category-" + categoryBean.getAdCategoryId());

				if (!adsPageBean.getSelectedCategorues().contains(Long.valueOf(selectedCategory))) {
					adsPageBean.addCategoryToSelectedCategories(Long.valueOf(selectedCategory));
				}
			}
		}
	}

	private AccountDetailsPageBean getAccountPageBean() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null) {
			if (authentication.getClass() == UsernamePasswordAuthenticationToken.class) {
				return (AccountDetailsPageBean) authentication.getPrincipal();
			}
			if (authentication.getClass() == RememberMeAuthenticationToken.class) {
				return (AccountDetailsPageBean) authentication.getPrincipal();
			}

		}

		return null;
	}

	/*
	 * @ModelAttribute private Entity getAccount(){ //return
	 * EntitiesPool.getAccount(); return new Account(); }
	 */
}
