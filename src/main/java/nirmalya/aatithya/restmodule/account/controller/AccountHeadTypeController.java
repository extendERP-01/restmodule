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

import nirmalya.aatithya.restmodule.account.dao.AccountHeadTypeDao;
import nirmalya.aatithya.restmodule.account.model.AccountHeadTypeModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping("account/")
public class AccountHeadTypeController {

	Logger logger = LoggerFactory.getLogger(AccountHeadTypeController.class);

	@Autowired
	AccountHeadTypeDao accountHeadTypeDao;
	/*
	 * for All account head
	 */
	@RequestMapping(value="getAllAccountHead" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountHeadTypeModel>>> getAllAccountHead(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllAccountHead starts");
		
		logger.info("Method : getAllAccountHead ends");
		
		return accountHeadTypeDao.getAllAccountHead(request);
	}
	/*
	 * for All  account id
	 */
	@RequestMapping(value="restAddAccountHead" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddAccountHead(@RequestBody AccountHeadTypeModel accountHeadTypeModel) 
	{
		logger.info("Method : restAddAccountHead starts");
		
		logger.info("Method : restAddAccountHead ends");
		
		return accountHeadTypeDao.restAddAccountHead(accountHeadTypeModel);
	}
	/*
	 * for  edit account id
	 */
	@RequestMapping(value="getAccountById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<AccountHeadTypeModel>> getAccountById(@RequestParam String id) 
	{
		logger.info("Method : getAccountById starts");
		
		logger.info("Method : getAccountById ends");
		
		return accountHeadTypeDao.getAccountById(id);
	}
	/*
	 * for delete account head
	 */
	@RequestMapping(value="deleteAccountById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteAccountById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deleteAccountById starts");
		
		logger.info("Method : deleteAccountById ends");
		
		return accountHeadTypeDao.deleteAccountById(id,createdBy);
	}
	
}
