package by.kalilaska.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kalilaska.beans.AdBean;
import by.kalilaska.services.AdService;

@RestController
public class PersonalAreaMenuAllEnabledAdsController {

	@Autowired
	private AdService adsService;

	// ENABLED
	@RequestMapping(value = "/personalArea/admin/api/ads/enabled", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AdBean>> getAllEnabledAds() {
		List<AdBean> adBeanList = adsService.getAllAdsWithFieldEnabled(true);
		return new ResponseEntity<List<AdBean>>(adBeanList, HttpStatus.ACCEPTED);
	}

	// DISABLED
	@RequestMapping(value = "/personalArea/admin/api/ads/disabled", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AdBean>> getAllDisabledAds() {
		List<AdBean> adBeanList = adsService.getAllAdsWithFieldEnabled(false);
		return new ResponseEntity<List<AdBean>>(adBeanList, HttpStatus.ACCEPTED);
	}

}
