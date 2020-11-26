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

import nirmalya.aatithya.restmodule.account.dao.AccountBankAccountDao;
import nirmalya.aatithya.restmodule.account.model.AccountBankAccountModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account/")
public class AccountBankAccountController {
	
	Logger logger = LoggerFactory.getLogger(AccountBankAccountController.class);
	@Autowired
	AccountBankAccountDao bankAccountDao;
	
	
	/**
	 * GET BANK
	 *
	 */

	@RequestMapping(value = "rest-bank-account-list", method = { RequestMethod.GET })
	public List<DropDownModel> restBankAccountList() {
		logger.info("Method : RESTMODULE AccountBankAccountController restBankAccountList starts");
		logger.info("Method : RESTMODULE AccountBankAccountController restBankAccountList ends");
		return bankAccountDao.bankAccountListData();
	}
	
	/**
	 * GET BRANCH
	 *
	 */

	@RequestMapping(value = "rest-branch-account-list", method = { RequestMethod.GET })
	public List<DropDownModel> restBranchAccountList() {
		logger.info("Method : RESTMODULE AccountBankAccountController restBranchAccountList starts");
		logger.info("Method : RESTMODULE AccountBankAccountController restBranchAccountList ends");
		return bankAccountDao.branchAccountListData();
	}
	
	/**
	 * Submit Add Bank Account Details
	 */
	@RequestMapping(value = "rest-submit-bank-account-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restSubmitBankAccountDetails(@RequestBody AccountBankAccountModel form) {
		logger.info("Method : AccountBankAccountController restSubmitBankAccountDetails starts");
		logger.info("Method : AccountBankAccountController restSubmitBankAccountDetails end");
		return bankAccountDao.submitBankAccountDetails(form);
	}

	/**
	 * View Bank Account Details Ajax
	 */
	@RequestMapping(value = "rest-view-bank-account-details-through-ajax", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AccountBankAccountModel>>> restViewBankAccountThroughAjax(
			@RequestBody DataTableRequest request) {
		logger.info("Method : AccountBankAccountController restViewBankAccountThroughAjax starts");
		logger.info("Method : AccountBankAccountController restViewBankAccountThroughAjax end");
		return bankAccountDao.viewBankAccountThroughAjax(request);
	}

	/**
	 * Delete Bank Account Record
	 */

	@RequestMapping(value = "rest-account-bank-account-delete-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restDeleteBankAccountDeatils(@RequestParam String br, @RequestParam String ac) {
		logger.info("Method : AccountBankAccountController restDeleteBankAccountDeatils starts");
		logger.info("Method : AccountBankAccountController restDeleteBankAccountDeatils end");

		return bankAccountDao.deleteBankAccountDeatils(br,ac);
	}

	/**
	 * Edit Account Bank Account Details
	 */

	@RequestMapping(value = "rest-edit-account-bank-account-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AccountBankAccountModel>> restEditBankAccountDetails(@RequestParam String br, @RequestParam String ac) {

		logger.info("Method : AccountBankAccountController restEditBankAccountDetails starts");
		logger.info("Method : AccountBankAccountController restEditBankAccountDetails end");

		return bankAccountDao.editBankAccountDetails(br,ac);
	}
	
	/**
	 * ONCHANGE DATA FETCH FOR BANK BRANCH
	 *
	 */
	
	@RequestMapping(value = "rest-account-bank-branch-bank-onchange-branch-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getBranchListByCatId(@RequestParam String proCat) {
		logger.info("Method : AccountBankAccountController getBranchListByCatId starts");

		logger.info("Method : AccountBankAccountController getBranchListByCatId ends");
		return bankAccountDao.getBranchList(proCat);
	}

}
