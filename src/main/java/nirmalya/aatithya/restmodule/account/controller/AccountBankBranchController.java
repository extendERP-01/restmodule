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

import nirmalya.aatithya.restmodule.account.dao.AccountBankBranchDao;
import nirmalya.aatithya.restmodule.account.model.AccountBankBranchModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account/")
public class AccountBankBranchController {
	
	
	Logger logger = LoggerFactory.getLogger(AccountBankBranchController.class);
	@Autowired
	AccountBankBranchDao bankBranchDao;
	
	
	/**
	 * GET BANK
	 *
	 */

	@RequestMapping(value = "rest-account-branch-bank-list", method = { RequestMethod.GET })
	public List<DropDownModel> getBankList() {
		logger.info("Method : RESTMODULE AccountBankBranchController getBankList starts");
		logger.info("Method : RESTMODULE AccountBankBranchController getBankList ends");
		return bankBranchDao.getBankList();
	}
	
	/**
	 * GET STATE
	 *
	 */

	@RequestMapping(value = "rest-account-branch-state-list", method = { RequestMethod.GET })
	public List<DropDownModel> getStateList() {
		logger.info("Method : RESTMODULE AccountBankBranchController getStateList starts");
		logger.info("Method : RESTMODULE AccountBankBranchController getStateList ends");
		return bankBranchDao.getStateList();
	}

	/**
	 * GET DISTRICT
	 *
	 */

	@RequestMapping(value = "rest-account-branch-district-list", method = { RequestMethod.GET })
	public List<DropDownModel> getDistList() {
		logger.info("Method : RESTMODULE AccountBankBranchController getDistList starts");
		logger.info("Method : RESTMODULE AccountBankBranchController getDistList ends");
		return bankBranchDao.getDistList();
	}
	
	
	
	/**
	 * Submit Add Bank Branch Details
	 */
	@RequestMapping(value = "rest-submit-bank-branch-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restSubmitBankBranchDetails(@RequestBody AccountBankBranchModel form) {
		logger.info("Method : AccountBankBranchController restSubmitBankBranchDetails starts");
		logger.info("Method : AccountBankBranchController restSubmitBankBranchDetails end");
		return bankBranchDao.restSubmitBankBranchDetails(form);
	}

	/**
	 * View Bank Branch Details Ajax
	 */
	@RequestMapping(value = "rest-view-bank-branch-details-through-ajax", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AccountBankBranchModel>>> restViewBankBranchThroughAjax(
			@RequestBody DataTableRequest request) {
		logger.info("Method : AccountBankBranchController restViewBankBranchThroughAjax starts");
		logger.info("Method : AccountBankBranchController restViewBankBranchThroughAjax end");
		return bankBranchDao.restViewBankBranchThroughAjax(request);
	}

	/**
	 * Delete Bank Branch Record
	 */

	@RequestMapping(value = "rest-account-bank-branch-delete-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restDeleteBankBranchDeatils(@RequestParam String id) {
		logger.info("Method : AccountBankBranchController restDeleteBankBranchDeatils starts");
		logger.info("Method : AccountBankBranchController restDeleteBankBranchDeatils end");

		return bankBranchDao.restDeleteBankBranchDeatils(id);
	}

	/**
	 * Edit Account Bank Branch Details
	 */

	@RequestMapping(value = "rest-edit-account-bank-branch-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AccountBankBranchModel>> restEditBankBranchDetails(@RequestParam String id) {

		logger.info("Method : AccountBankBranchController restEditBankBranchDetails starts");
		logger.info("Method : AccountBankBranchController restEditBankBranchDetails end");

		return bankBranchDao.restEditBankBranchDetails(id);
	}
	
	/**
	 * ONCHANGE DATA FETCH FOR STATE DISTRICT
	 *
	 */
	
	@RequestMapping(value = "rest-account-bank-branch-state-onchange-district-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDIstrictListByCatId(@RequestParam String proCat) {
		logger.info("Method : AccountBankBranchController getDIstrictListByCatId starts");

		logger.info("Method : AccountBankBranchController getDIstrictListByCatId ends");
		return bankBranchDao.getDistListById(proCat);
	}

}
