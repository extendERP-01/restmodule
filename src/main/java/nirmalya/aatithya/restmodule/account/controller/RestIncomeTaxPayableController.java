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

import nirmalya.aatithya.restmodule.account.dao.RestIncomeTaxPayableDao;
import nirmalya.aatithya.restmodule.account.model.RestIncomeTaxPayableModel;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "account/")
public class RestIncomeTaxPayableController {
	Logger logger = LoggerFactory.getLogger(RestIncomeTaxPayableController.class);

	@Autowired
	RestIncomeTaxPayableDao incomeTaxDao;
	
	/*
	 * 
	 * returns sales Ledger Report PDF
	 *
	 */
	@RequestMapping(value = "generateIncomeTaxPayableReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>> getIncomeTaxPayableReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getIncomeTaxPayableReportPdf starts");
		logger.info("Method : getIncomeTaxPayableReportPdf ends");
		return incomeTaxDao.getIncomeTaxPayableReportPdf(request);
	}
	
	/*
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-incomeTaxPayable" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");
		logger.info("Method : restGetLogoImage ends");
	return incomeTaxDao.getHotelLogo(logoType);
	}
	
	/*
	 * returns all Report details to downloads excel
	 *
	 */
	@RequestMapping(value = "downloadExcelForIncomeTaxReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>> getIncomeTaxReportDownload(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getIncomeTaxReportDownload starts");

		logger.info("Method : getIncomeTaxReportDownload ends");
		return incomeTaxDao.getIncomeTaxReportDownload(request);
	}
	

	/*
	 * preview all  Report details 
	 *
	 */
	@RequestMapping(value = "/previewIncomeTaxPayableReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestIncomeTaxPayableModel>>> getIncomeTaxPayablePreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getIncomeTaxPayablePreview starts");
		logger.info("Method : getIncomeTaxPayablePreview endss");
		return incomeTaxDao.getIncomeTaxPayablePreview(request);
	}
}
