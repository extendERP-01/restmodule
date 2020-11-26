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

import nirmalya.aatithya.restmodule.account.dao.AccountIndividualAccountDao;
import nirmalya.aatithya.restmodule.account.model.AccountIndividualAccountDetailsModal;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping("account/")
public class AccountIndvidualAccountDetailsController {

	
	Logger logger = LoggerFactory.getLogger(AccountTrialBalanceRestController.class);
	@Autowired
	AccountIndividualAccountDao accountIndividualAccountDao;
	
	/*
	 * for drop down for get account Head
	 */
	@RequestMapping(value = "getAccountHeads", method = { RequestMethod.GET })
	public List<DropDownModel> getAccountHeads() {

		logger.info("Method in rest: getAccountHeads starts");

		logger.info("Method in rest: getAccountHeads ends");

		return accountIndividualAccountDao.getAccountHeads();
	}
	
	/*
	 * for trial balance
	 */
	@RequestMapping(value="getAIndividualAccountReportCr" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountIndividualAccountDetailsModal>>> getAIndividualAccountReportCr(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAIndividualAccountReportCr starts");
		
		logger.info("Method : getAIndividualAccountReportCr ends");
		
		return accountIndividualAccountDao.getAIndividualAccountReportCr(request);
	}
	/*
	 * for trial balance
	 */
	@RequestMapping(value="getAIndividualAccountReportDr" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountIndividualAccountDetailsModal>>> getAIndividualAccountReportDr(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAIndividualAccountReportDr starts");
		
		logger.info("Method : getAIndividualAccountReportDr ends");
		
		return accountIndividualAccountDao.getAIndividualAccountReportDr(request);
	}
	/**
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-IndvDtls" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImageForPayVocher(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
	return accountIndividualAccountDao.getHotelLogoForIndvDtls(logoType);
	}
}
