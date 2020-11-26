/**
 * 
 */
package nirmalya.aatithya.restmodule.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.AccountBankDao;
import nirmalya.aatithya.restmodule.account.model.AccountBankModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account/")
public class AccountBankController {

	Logger logger = LoggerFactory.getLogger(AccountBankController.class);
	@Autowired
	AccountBankDao bankDao;

	/**
	 * Submit Add Bank Details
	 */
	@RequestMapping(value = "rest-submit-bank-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restSubmitBankDetails(@RequestBody AccountBankModel form) {
		logger.info("Method : AccountBankController restSubmitBankDetails starts");
		logger.info("Method : AccountBankController restSubmitBankDetails end");
		return bankDao.restSubmitBankDetails(form);
	}

	/**
	 * View Bank Details Ajax
	 */
	@RequestMapping(value = "rest-view-bank-details-through-ajax", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AccountBankModel>>> restViewBankThroughAjax(
			@RequestBody DataTableRequest request) {
		logger.info("Method : AccountBankController restViewBankThroughAjax starts");
		logger.info("Method : AccountBankController restViewBankThroughAjax end");
		return bankDao.restViewBankThroughAjax(request);
	}

	/**
	 * Delete Bank Record
	 */

	@RequestMapping(value = "rest-account-bank-delete-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restDeleteBankDeatils(@RequestParam String id) {
		logger.info("Method : AccountBankController restDeleteBankDeatils starts");
		logger.info("Method : AccountBankController restDeleteBankDeatils end");

		return bankDao.restDeleteBankDeatils(id);
	}

	/**
	 * Edit Account Bank Details
	 */

	@RequestMapping(value = "rest-edit-account-bank-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AccountBankModel>> restEditBankDetails(@RequestParam String id) {

		logger.info("Method : AccountBankController restEditBankDetails starts");
		logger.info("Method : AccountBankController restEditBankDetails end");

		return bankDao.restEditBankDetails(id);
	}

}
