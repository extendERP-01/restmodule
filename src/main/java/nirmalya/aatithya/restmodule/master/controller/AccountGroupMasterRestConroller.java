package nirmalya.aatithya.restmodule.master.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.AccountGroupMasterDao;
import nirmalya.aatithya.restmodule.master.model.AccountGroupMasterModel; 



/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("master")
public class AccountGroupMasterRestConroller {
	Logger logger = LoggerFactory.getLogger(AccountGroupMasterRestConroller.class);
	@Autowired
	AccountGroupMasterDao accountGroupDao;
	/**
	 * Post Mapping to Add new payment mode
	 *
	 */
	@RequestMapping(value = "/addAccountGroup", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addAccountGroup(@RequestBody AccountGroupMasterModel form) {

		logger.info("Method : addAccountGroup starts");

		logger.info("Method : addAccountGroup end");

		return accountGroupDao.addAccountGroup(form);

	}
	/**
	 * returns all property payment mode
	 *
	 */
	@RequestMapping(value = "/getAllGroup", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AccountGroupMasterModel>>> getAllGroup(@RequestBody DataTableRequest request) {

		logger.info("Method : getAllGroup starts");

		logger.info("Method : getAllGroup end");

		return accountGroupDao.getAllGroup(request);
	}
	
	@RequestMapping(value = "/getAccountGroupById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AccountGroupMasterModel>> getAccountGroupById(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getAccountGroupById starts");

		logger.info("Method : getAccountGroupById end");

		return accountGroupDao.getAccountGroupById(id, action);
	}
	@RequestMapping(value = "/deleteAccountById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAccountGroup(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteAccountGroup starts");

		logger.info("Method : deleteAccountGroup end");

		return accountGroupDao.deleteAccountGroup(id,createdBy);
	}
}
