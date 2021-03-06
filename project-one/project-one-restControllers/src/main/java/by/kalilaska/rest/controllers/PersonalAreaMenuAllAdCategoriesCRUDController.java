package by.kalilaska.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kalilaska.beans.AdCategoryBean;
import by.kalilaska.services.AdCategoryService;
import by.kalilaska.services.exceptions.AdCategoryExistsException;
import by.kalilaska.services.exceptions.AdCategoryNameExistsException;
import by.kalilaska.services.exceptions.AdCategoryTranslationExistsException;

@RestController
public class PersonalAreaMenuAllAdCategoriesCRUDController {

	@Autowired
	private AdCategoryService adCategoryService;

	@RequestMapping(value = "/personalArea/admin/api/ad_category/new", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addAdCategory(@Valid @RequestBody AdCategoryBean adCategory, BindingResult bindingResult) {
		System.out.println("adCategory: " + adCategory);

		if (bindingResult.hasErrors()) {
			System.out.println("not valid");
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}

		AdCategoryBean created = null;

		try {
			created = adCategoryService.createNewAdCategory(adCategory);
		} catch (AdCategoryExistsException e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		if (created == null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		List<AdCategoryBean> adCategoryBeanList = adCategoryService.findAllCategoriesWithFieldEnabled(true);
		return new ResponseEntity<List<AdCategoryBean>>(adCategoryBeanList, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/personalArea/admin/api/ad_category/{adCategoryId}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> editAdCategory(@PathVariable String adCategoryId,
			@Valid @RequestBody AdCategoryBean adCategoryBean, BindingResult bindingResult) {

		if (adCategoryBean == null) {
			System.out.println("INTERNAL_SERVER_ERROR");
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);// 500
		}

		if (bindingResult.hasErrors()) {

			System.out.println("not valid");
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);// 204

		}

		try {
			adCategoryService.editAdCategory(adCategoryBean);
		} catch (AdCategoryNameExistsException e) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);// 409
		} catch (AdCategoryTranslationExistsException e) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		List<AdCategoryBean> adCategoryBeanList = adCategoryService.findAllCategoriesWithFieldEnabled(true);
		return new ResponseEntity<List<AdCategoryBean>>(adCategoryBeanList, HttpStatus.OK);// 200
	}

	@RequestMapping(value = "/personalArea/admin/api/ad_category/{adCategoryId}/disable", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> disableAdCategory(@PathVariable String adCategoryId,
			@RequestBody AdCategoryBean adCategoryBean) {

		if (adCategoryService.disableAdCategory(adCategoryBean)) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value = "/personalArea/admin/api/ad_category/{adCategoryId}/enable", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> enableAdCategory(@PathVariable String adCategoryId,
			@ModelAttribute AdCategoryBean adCategoryBean) {
		if (adCategoryService.enableAdCategory(adCategoryBean)) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value = "/personalArea/admin/api/ad_category/{adCategoryId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteAdCategory(@PathVariable String adCategoryId) {
		System.out.println("deleteAdCategory, adCategoryId: " + adCategoryId);

		if (adCategoryService.deleteAdCategory(Long.valueOf(adCategoryId))) {
			System.out.println("delete method controller success");
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
