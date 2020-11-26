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


import nirmalya.aatithya.restmodule.account.dao.RestCreditLedgerDao;

import nirmalya.aatithya.restmodule.account.model.RestDebitCreditLedgerModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value="account/")

public class RestCreditLedgerController {
Logger logger = LoggerFactory.getLogger(RestCreditLedgerController.class);
	
	@Autowired
RestCreditLedgerDao creditLedgerDao;
	
	

	/*
	 * REST CONTROLLER - GET COST CENTER 
	 *
	 */
	@RequestMapping(value="creditLedgerCostCenter" , method={RequestMethod.GET})
	public List<DropDownModel> creditLedgerCostCenter() {
		logger.info("Method : creditLedgerCostCenter starts");

		logger.info("Method : creditLedgerCostCenter ends");
		return creditLedgerDao.creditLedgerCostCenter();
	}
	
	/*
	 * REST CONTROLLER - GET COST CENTER
	 *
	 */
	@RequestMapping(value="creditLedgerAccountHead" , method={RequestMethod.GET})
	public List<DropDownModel> creditLedgerAccountHead() {
		logger.info("Method : creditLedgerAccountHead starts");

		logger.info("Method : creditLedgerAccountHead ends");
		return creditLedgerDao.creditLedgerAccountHead();
	}
	
	
	/*
	 * 
	 * returns all Credit Ledger Report PDF
	 *
	 */
	@RequestMapping(value = "generateCreditLedgerReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> getCreditLedgerReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getCreditLedgerReportPdf starts");
		logger.info("Method : getCreditLedgerReportPdf ends");
		return creditLedgerDao.getCreditLedgerReportPdf(request);
	}
	
	/*
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-creditLedger" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
	return creditLedgerDao.getHotelLogo(logoType);
	}
	
	/*
	 * returns all Report details to downloads excel
	 *
	 */
	@RequestMapping(value = "getCreditLedgerReportList", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> getCreditLedgerReportDownload(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getCreditLedgerReportDownload starts");

		logger.info("Method : getCreditLedgerReportDownload ends");
		return creditLedgerDao.getCreditLedgerReportDownload(request);
	}
	
	/*
	 * preview all  Report details 
	 *
	 */
	@RequestMapping(value = "/previewCreditLedgerReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> getCreditLedgerPreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getCreditLedgerPreview starts");
		logger.info("Method : getCreditLedgerPreview endss");
		return creditLedgerDao.getCreditLedgerPreview(request);
	}
	
}
