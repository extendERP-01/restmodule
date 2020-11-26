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

import nirmalya.aatithya.restmodule.account.dao.RestSalesAccountLedgerDao;

import nirmalya.aatithya.restmodule.account.model.RestSalesAccountLedgerModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account/")

public class RestSalesAccountLedgerController {

	Logger logger = LoggerFactory.getLogger(RestSalesAccountLedgerController.class);

	@Autowired
	RestSalesAccountLedgerDao salesLedgerDao;
	
	
	
	/*
	 * 
	 * returns sales Ledger Report PDF
	 *
	 */
	@RequestMapping(value = "generateSalesLedgerReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>> getSalesLedgerReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSalesLedgerReportPdf starts");
		
		logger.info("Method : getSalesLedgerReportPdf ends");
		return salesLedgerDao.getSalesLedgerReportPdf(request);
	}
	
	/*
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-salesLedger" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
	return salesLedgerDao.getHotelLogo(logoType);
	}
	/*
	 * preview all  Report details 
	 *
	 */
	@RequestMapping(value = "/previewSalesReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>> getSalesLedgerPreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSalesLedgerPreview starts");
		logger.info("Method : getSalesLedgerPreview endss");
		return salesLedgerDao.getSalesLedgerPreview(request);
	}
	/*
	 * returns all Report details to downloads excel
	 *
	 */
	@RequestMapping(value = "getSalesLedgerReportForDownload", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestSalesAccountLedgerModel>>> getSalesLedgerReportDownload(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSalesLedgerReportDownload starts");

		logger.info("Method : getSalesLedgerReportDownload ends");
		return salesLedgerDao.getSalesLedgerReportDownload(request);
	}

}
