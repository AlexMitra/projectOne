package by.kalilaska.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.services.AccountWithFieldEnabledService;

@RestController
public class PersonalAreaMenuAllEnabledAccountsController {

	@Autowired
	private AccountWithFieldEnabledService accountWithFieldEnabledService;

	@RequestMapping(value = "/personalArea/admin/api/allEnabledAccounts", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AccountBean>> getAllAccounts() {
		List<AccountBean> accountBeanList = accountWithFieldEnabledService.getAllAccountsWithFieldEnabled(true);
		return new ResponseEntity<List<AccountBean>>(accountBeanList, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/personalArea/admin/api/matchedEnabledAccounts", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AccountBean>> getMatchedAccounts(@RequestParam String part, String searchField,
			String searchPlace, String roles) {

		List<AccountBean> accountBeanList = accountWithFieldEnabledService.getSearchedEAccountsWithFieldEnabled(part,
				searchField, searchPlace, roles, true);
		return new ResponseEntity<List<AccountBean>>(accountBeanList, HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "/personalArea/admin/api/selectedRolesEnabledAccounts", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AccountBean>> getSelectedRolesAccounts(@RequestParam String roles) {

		String[] rolesArr = roles.split("checkbox-");
		List<AccountBean> accountBeanList = new ArrayList<>();
		accountBeanList.addAll(accountWithFieldEnabledService.getSelectedRoleAccountsWithFieldEnabled(rolesArr, true));

		return new ResponseEntity<List<AccountBean>>(accountBeanList, HttpStatus.ACCEPTED);
	}

}
