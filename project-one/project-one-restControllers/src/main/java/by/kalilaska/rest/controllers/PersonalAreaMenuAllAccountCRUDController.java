package by.kalilaska.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import by.kalilaska.beans.AccountBean;
import by.kalilaska.beans.AccountDetailsPageBean;
import by.kalilaska.services.AccountRegistrationService;
import by.kalilaska.services.AccountService;
import by.kalilaska.services.AccountWithFieldEnabledService;
import by.kalilaska.services.exceptions.EmailExistsException;
import by.kalilaska.services.exceptions.LoginExistsException;
import by.kalilaska.services.exceptions.UnknownCauseAccountExistException;

@RestController
public class PersonalAreaMenuAllAccountCRUDController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRegistrationService registrationService;

	@Autowired
	private AccountWithFieldEnabledService accountWithFieldEnabledService;

	@RequestMapping(value = "/personalArea/admin/api/account/new", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addAccount(@Valid @RequestBody AccountDetailsPageBean account,
			BindingResult bindingResult) {
		System.out.println("account: " + account);

		if (bindingResult.hasErrors()) {
			System.out.println("not valid");
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}

		AccountDetailsPageBean added = null;

		try {
			added = registrationService.insertNewAccount(account);
		} catch (LoginExistsException e) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} catch (EmailExistsException e) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} catch (IncorrectResultSizeDataAccessException e) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} catch (UnknownCauseAccountExistException e) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		if (added == null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		List<AccountBean> accountBeanList = accountWithFieldEnabledService.getAllAccountsWithFieldEnabled(true);
		return new ResponseEntity<List<AccountBean>>(accountBeanList, HttpStatus.CREATED);
	}

}
