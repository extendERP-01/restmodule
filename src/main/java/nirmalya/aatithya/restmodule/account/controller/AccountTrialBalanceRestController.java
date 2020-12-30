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

import nirmalya.aatithya.restmodule.account.dao.AccountTrialBalanceDao;
import nirmalya.aatithya.restmodule.account.model.AccountTrialBalanceModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


@RestController
@RequestMapping("account/")

public class AccountTrialBalanceRestController {

	Logger logger = LoggerFactory.getLogger(AccountTrialBalanceRestController.class);
	@Autowired
	AccountTrialBalanceDao accountTrialBalanceDao;
	/*
	 * for trial balance
	 */
	@RequestMapping(value="getAllTrialBalanceReport" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> getAllTrialBalanceReport(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllTrialBalanceReport starts");
		
		logger.info("Method : getAllTrialBalanceReport ends");
		
		return accountTrialBalanceDao.getAllTrialBalanceReport(request);
	}
	
	/*
	 * for trial balance
	 */
	@RequestMapping(value="all-trail-balance-report-view" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> allTrialBalanceReportview(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllTrialBalanceReport starts");
		
		logger.info("Method : getAllTrialBalanceReport ends");
		
		return accountTrialBalanceDao.getAllTrialBalanceReportWebViewMode(request);
	}
	
	/*
	 * for drop down for get cost center
	 */
	@RequestMapping(value = "getCostCenterTB", method = { RequestMethod.GET })
	public List<DropDownModel> getCostCenterTB() {

		logger.info("Method in rest: getCostCenterTB starts");

		logger.info("Method in rest: getCostCenterTB ends");

		return accountTrialBalanceDao.getCostCenterTB();
	}
	/*
	 * for drop down for get cost center
	 */
	@RequestMapping(value = "get-account-subgroups", method = { RequestMethod.GET })
	public List<DropDownModel> getSubgroupTB() {
		
		logger.info("Method in rest: getCostCenterTB starts");
		
		logger.info("Method in rest: getCostCenterTB ends");
		
		return accountTrialBalanceDao.getSubgrpTB();
	}
	/**
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-TrialBalance" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImageForPayVocher(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
	return accountTrialBalanceDao.getHotelLogoForVoucher(logoType);
	}

	/*
	 * for trial balance
	 */
	@RequestMapping(value="all-trail-balance-report-accountgroup" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> allTrialBalanceReportviewSubgrp(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllTrialBalanceReport starts");
		
		logger.info("Method : getAllTrialBalanceReport ends");
		
		return accountTrialBalanceDao.allTrialBalanceReportviewSubgrp(request);
	}
	
	/********** R A J E S H *****************/
	/*
	 * for trial balance
	 */
	@RequestMapping(value="all-trail-balance-report-detls" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<AccountTrialBalanceModel>>> allTrialBalanceReport(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllTrialBalanceReport starts");
		
		logger.info("Method : getAllTrialBalanceReport ends");
		
		return accountTrialBalanceDao.getAllTrialBalanceReportDetls(request);
	}
	
	/*
	 * get allAccHeads
	 */
	@RequestMapping(value="get-all-accHeads" , method={RequestMethod.GET})
	public List<DropDownModel> allAccHeads() 
	{
		logger.info("Method : getAllAccHeads starts");
		
		logger.info("Method : getAllAccHeads ends");
		
		return accountTrialBalanceDao.getAllAccHeads();
	}
	
}
