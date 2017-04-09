package by.kalilaska.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.beans.AdBean;
import by.kalilaska.beans.AdCategoryBean;
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
			@ModelAttribute(name = "adsPageBean") AdsPageBean adsPageBean, HttpSession session,
			HttpServletRequest request) {

		ModelAndView modelAndView;
		adsPageBean = getAdsPageBeanFromSession(adsPageBean, session);

		int currentPage = Integer.valueOf(pageNumber) - 1;
		adsPageBean.setPageNumber(currentPage);

		long adsNumber = 0;
		long showedPagesNumber = 0;
		long adsNumberOnPage = 0;

		if (adsPageBean.getSelectedCategorues().size() > 0) {

			setSelectedCategories(adsPageBean, request);

			List<AdCategoryBean> adCategoryBeanList = new ArrayList<>();
			for (Long category : adsPageBean.getSelectedCategorues()) {
				adCategoryBeanList.add(adCategoryService.findByCategoryId(category));
			}

			adsNumber = adService.getSelectedCategoriesAdEnabledCount(adCategoryBeanList, true);

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
		adsPageBean.getSelectedCategorues().clear();

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

		System.out.println("ads: " + adsPageBean.getAllAds());
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

		if (adsPageBean.getAllAdCategories() == null || adsPageBean.getAllAdCategories().size() == 0) {
			adsPageBean.setAllAdCategories(adCategoryService.findAllCategoryNamesWithFieldEnabled(true));
		}

		return adsPageBean;
	}

	private void setSelectedCategories(AdsPageBean adsPageBean, HttpServletRequest request) {
		String selectedCategory = "";
		if (request.getParameter("selected") != null) {
			adsPageBean.getSelectedCategorues().clear();
		}
		for (AdCategoryBean categoryBean : adsPageBean.getAllAdCategories()) {
			if (request.getParameter("category-" + categoryBean.getAdCategoryId()) != null) {
				selectedCategory = request.getParameter("category-" + categoryBean.getAdCategoryId());

				if (!adsPageBean.getSelectedCategorues().contains(Long.valueOf(selectedCategory))) {
					adsPageBean.addCategoryToSelectedCategories(Long.valueOf(selectedCategory));
				}
			}
		}
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
