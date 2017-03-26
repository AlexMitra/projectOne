package by.kalilaska.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.beans.AdBean;
import by.kalilaska.beans.AdsPageBean;
import by.kalilaska.services.AdCategoryService;
import by.kalilaska.services.AdService;

@Controller
public class AdsPageController {

	@Autowired
	private AdCategoryService adCategoryService;

	@Autowired
	private AdService adService;

	@RequestMapping(value = "/ads/page{pageNumber}.html", method = RequestMethod.GET)
	public ModelAndView getAdsPage(@PathVariable String pageNumber,
			@ModelAttribute(name = "adsPageBean") AdsPageBean adsPageBean, HttpSession session) {

		if (session.getAttribute("adsPageBean") != null) {
			adsPageBean = (AdsPageBean) session.getAttribute("adsPageBean");
		}

		if (adsPageBean.getAllAdCategories() == null || adsPageBean.getAllAdCategories().size() == 0) {
			adsPageBean.setAllAdCategories(adCategoryService.findAllCategoryNamesWithFieldEnabled(true));
		}

		ModelAndView modelAndView;

		adsPageBean.setPageNumber(Integer.valueOf(pageNumber));

		long allAdsNumber = adService.getAdEnabledCount(true);
		long allShowedPagesNumber = adsPageBean.getPageNumber() + 1;
		long adsNumberOnPage = adsPageBean.getAdsNumberOnPage();

		if ((allAdsNumber - allShowedPagesNumber * adsNumberOnPage) > 0) {
			adsPageBean.setLastPage(false);
		} else {
			adsPageBean.setLastPage(true);
		}

		// adsPageBean.setAllAdCategories(adCategoryService.findAllCategoryNamesWithFieldEnabled(true));
		adsPageBean.setAllAds(adService.getAllAdsWithFieldEnabled(true, adsPageBean.getPageNumber(),
				adsPageBean.getAdsNumberOnPage()));

		session.setAttribute("adsPageBean", adsPageBean);
		modelAndView = new ModelAndView("ads", "adsPageBean", adsPageBean);

		return modelAndView;

	}

	@RequestMapping(value = "/ads/ad_{adNumber}.html", method = RequestMethod.GET)
	public ModelAndView getAdPage(@PathVariable String adNumber,
			@ModelAttribute(name = "adsPageBean") AdsPageBean adsPageBean, HttpSession session) {

		AdBean adBean = null;

		long adId = Long.valueOf(adNumber);

		if (session.getAttribute("adsPageBean") != null) {
			adsPageBean = (AdsPageBean) session.getAttribute("adsPageBean");
			for (AdBean bean : adsPageBean.getAllAds()) {
				if (bean.getAdId() == adId) {
					adBean = bean;
				}
			}

		} else if (adBean == null) {
			adBean = adService.getAdById(Long.valueOf(adNumber));
		}

		ModelAndView modelAndView;

		modelAndView = new ModelAndView("ad", "adsPageBean", adsPageBean);
		modelAndView.addObject("adPageBean", adBean);

		return modelAndView;

	}

}
