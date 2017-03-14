package by.kalilaska.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.services.AccountService;
import by.kalilaska.services.ServiceOne;

@RestController
// @RequestMapping(value="/project-one-web/personalArea/api/accounts",
// produces="application/json")
public class AdminAreaMenuController {

	@Autowired
	// @Qualifier(value = "ZabiraiServiceJDBC")
	// @Qualifier(value = "zabiraiServiceHibernate")
	@Qualifier(value = "zabiraiServiceData")
	private ServiceOne zabiraiService;

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/personalArea/admin/api/allAccounts", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AccountBean>> getAllAccounts() {
		List<AccountBean> accountBeanList = zabiraiService.getAllAccounts();
		return new ResponseEntity<List<AccountBean>>(accountBeanList, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/personalArea/admin/api/matchedAccounts", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AccountBean>> getMatchedAccounts(@RequestParam String part, String searchField,
			String searchPlace, String roles) {
		System.out.println("part: " + part + ", searchField: " + searchField + ", searchPlace: " + searchPlace
				+ ", roles: " + roles);

		List<AccountBean> accountBeanList = accountService.getSearchedAccounts(part, searchField, searchPlace, roles);
		return new ResponseEntity<List<AccountBean>>(accountBeanList, HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "/personalArea/admin/api/selectedRolesAccounts", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public ResponseEntity<List<AccountBean>> getSelectedRolesAccounts(@RequestParam String roles) {

		String[] rolesArr = roles.split("checkbox-");
		List<AccountBean> accountBeanList = new ArrayList<>();
		// for (String role : rolesArr) {
		// if (role.length() >= 1) {
		// accountBeanList.addAll(zabiraiService.getSelectedRoleAccounts(role));
		// }
		// }

		accountBeanList.addAll(accountService.getSelectedRoleAccounts(rolesArr));

		System.out.println(accountBeanList);

		return new ResponseEntity<List<AccountBean>>(accountBeanList, HttpStatus.ACCEPTED);
	}

	// @RequestMapping(value = "/personalArea/admin/api/allRoles", method =
	// RequestMethod.GET, headers = "Accept=application/json", produces = {
	// "application/json" })
	// @ResponseBody
	// public ResponseEntity<List<String>> getRoles() {
	// List<String> roleNameList = zabiraiService.getAllRoles();
	// return new ResponseEntity<List<String>>(roleNameList,
	// HttpStatus.ACCEPTED);
	// }

}
