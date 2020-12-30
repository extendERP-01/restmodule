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

import nirmalya.aatithya.restmodule.account.dao.RestPurchaseAccountLedgerDao;
import nirmalya.aatithya.restmodule.account.model.RestPurchaseAccountLedgerModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account/")
public class RestPurchaseAccountLedgerController {
	Logger logger = LoggerFactory.getLogger(RestPurchaseAccountLedgerController.class);

	@Autowired
	RestPurchaseAccountLedgerDao purchaseLedgerDao;
	
	
	/*
	 * 
	 * returns sales Ledger Report PDF
	 *
	 */
	@RequestMapping(value = "generatePurchaseLedgerReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>> getPurchaseLedgerReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPurchaseLedgerReportPdf starts");
		logger.info("Method : getPurchaseLedgerReportPdf ends");
		return purchaseLedgerDao.getPurchaseLedgerReportPdf(request);
	}
	
	/*
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-purchaseLedger" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");
		logger.info("Method : restGetLogoImage ends");
	return purchaseLedgerDao.getHotelLogo(logoType);
	}
	
	/*
	 * preview all  Report details 
	 *
	 */
	@RequestMapping(value = "/previewPurchaseReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>> getPurchaseLedgerPreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPurchaseLedgerPreview starts");
		logger.info("Method : getPurchaseLedgerPreview endss");
		return purchaseLedgerDao.getPurchaseLedgerPreview(request);
	}
	
	/*
	 * returns all Report details to downloads excel
	 *
	 */
	@RequestMapping(value = "getPurchaseLedgerReportForDownload", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestPurchaseAccountLedgerModel>>> getPurchaseLedgerReportDownload(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPurchaseLedgerReportDownload starts");

		logger.info("Method : getPurchaseLedgerReportDownload ends");
		return purchaseLedgerDao.getPurchaseLedgerReportDownload(request);
	}
}
