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

import nirmalya.aatithya.restmodule.account.dao.AccountCashBookDao;
import nirmalya.aatithya.restmodule.account.model.AccountCashBookCreditModel;
import nirmalya.aatithya.restmodule.account.model.AccountCashBookDebitModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping("account/")
public class AccountCashBookRestController {
	Logger logger = LoggerFactory.getLogger(AccountTrialBalanceRestController.class);
	
	@Autowired
	AccountCashBookDao accountCashBookDao;
	/*
	 * for view all payment voucher
	 */
	@RequestMapping(value="getAllcashBookCreditReport" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountCashBookCreditModel>>> getAllcashBookCreditReport(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllcashBookCreditReport starts");
		
		logger.info("Method : getAllcashBookCreditReport ends");
		
		return accountCashBookDao.getAllCreditBalance(request);
	}
	@RequestMapping(value="getAllcashBookDebitReport" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountCashBookDebitModel>>> getAllcashBookDebitReport(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllcashBookDebitReport starts");
		
		logger.info("Method : getAllcashBookDebitReport ends");
		
		return accountCashBookDao.getAllDebitBalance(request);
	}
	/*
	 * for drop down for get cost center
	 */
	@RequestMapping(value = "getCostCenterCB", method = { RequestMethod.GET })
	public List<DropDownModel> getCostCenterTB() {

		logger.info("Method in rest: getCostCenterCB starts");

		logger.info("Method in rest: getCostCenterCB ends");

		return accountCashBookDao.getCostCenterCB();
	}
	
	/**
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-cashBook" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImageForPayVocher(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
	return accountCashBookDao.getHotelLogoForCashBook(logoType);
	}
}
