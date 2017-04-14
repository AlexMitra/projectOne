package by.kalilaska.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kalilaska.beans.AdCategoryBean;
import by.kalilaska.services.AdCategoryService;

@RestController
public class PersonalAreaMenuAllEnabledAdCategoriesController {

	@Autowired
	private AdCategoryService AdCategoryService;

	// ENABLED
	@RequestMapping(value = "/personalArea/admin/api/ad_categories/enabled", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AdCategoryBean>> getAllEnabledAdCategories() {
		List<AdCategoryBean> adCategoryBeanList = AdCategoryService.findAllCategoriesWithFieldEnabled(true);
		return new ResponseEntity<List<AdCategoryBean>>(adCategoryBeanList, HttpStatus.ACCEPTED);
	}

	// DISABLED
	@RequestMapping(value = "/personalArea/admin/api/ad_categories/disabled", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AdCategoryBean>> getAllDisabledAdCategories() {
		List<AdCategoryBean> adCategoryBeanList = AdCategoryService.findAllCategoriesWithFieldEnabled(false);
		return new ResponseEntity<List<AdCategoryBean>>(adCategoryBeanList, HttpStatus.ACCEPTED);
	}

}
