package by.kalilaska.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.beans.AdsPageBean;
import by.kalilaska.services.AdCategoryService;
import by.kalilaska.services.AdService;

@Controller
public class AdsPageController {

	@Autowired
	private AdCategoryService adCategoryService;

	@Autowired
	private AdService adService;

	@RequestMapping(value = "/ads/page{pageNumber}.html")
	public ModelAndView getAdsPage(@PathVariable String pageNumber,
			@ModelAttribute(name = "adsPageBean") AdsPageBean adsPageBean) {

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

		adsPageBean.setAllAdCategories(adCategoryService.findAllCategoryNamesWithFieldEnabled(true));
		adsPageBean.setAllAds(adService.getAllAdsWithFieldEnabled(true, adsPageBean.getPageNumber(),
				adsPageBean.getAdsNumberOnPage()));

		modelAndView = new ModelAndView("ads", "adsPageBean", adsPageBean);

		return modelAndView;

	}

}
