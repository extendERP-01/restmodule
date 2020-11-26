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


import nirmalya.aatithya.restmodule.account.dao.RestDebitLedgerDao;
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

public class RestDebitLedgerController {
Logger logger = LoggerFactory.getLogger(RestDebitLedgerController.class);
	
	@Autowired
	RestDebitLedgerDao debitLedgerDao;

	/*
	 * REST CONTROLLER - GET COST CENTER 
	 *
	 */
	@RequestMapping(value="debitLedgerCostCenter" , method={RequestMethod.GET})
	public List<DropDownModel> debitLedgerCostCenter() {
		logger.info("Method : debitLedgerCostCenter starts");

		logger.info("Method : debitLedgerCostCenter ends");
		return debitLedgerDao.debitLedgerCostCenter();
	}
	
	/*
	 * REST CONTROLLER - GET COST CENTER
	 *
	 */
	@RequestMapping(value="debitLedgerAccountHead" , method={RequestMethod.GET})
	public List<DropDownModel> debitLedgerAccountHead() {
		logger.info("Method : debitLedgerAccountHead starts");

		logger.info("Method :debitLedgerAccountHead ends");
		return debitLedgerDao.debitLedgerAccountHead();
	}
	
	
	/*
	 * 
	 * returns all Credit Ledger Report PDF
	 *
	 */
	@RequestMapping(value = "generateDebitLedgerReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> getDebitLedgerReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getDebitLedgerReportPdf starts");
		logger.info("Method : getDebitLedgerReportPdf ends");
		return debitLedgerDao.getDebitLedgerReportPdf(request);
	}
	

	/*
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-debitLedger" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
	return debitLedgerDao.getHotelLogo(logoType);
	}
	
	
	/*
	 * returns all Report details to downloads excel
	 *
	 */
	@RequestMapping(value = "getDebitLedgerReportList", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> getDebitLedgerReportDownload(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getDebitLedgerReportDownload starts");

		logger.info("Method : getDebitLedgerReportDownload ends");
		return debitLedgerDao.getDebitLedgerReportDownload(request);
	}
	
	
	/*
	 * preview all  Report details 
	 *
	 */
	@RequestMapping(value = "/previewDebitLedgerReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestDebitCreditLedgerModel>>> getDebitLedgerPreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getDebitLedgerPreview starts");
		logger.info("Method : getDebitLedgerPreview endss");
		return debitLedgerDao.getDebitLedgerPreview(request);
	}
}
