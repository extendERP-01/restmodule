package nirmalya.aatithya.restmodule.account.controller;
 




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.AccountLedgerDao;  


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value="account/")

public class AccountLedgerController {
Logger logger = LoggerFactory.getLogger(AccountLedgerController.class);
	
	@Autowired
	AccountLedgerDao accountLedgerDao;

	/*
	 * REST CONTROLLER - GET COST CENTER restGetLedgerAccountHead
	 *
	 */
	/*@RequestMapping(value="restGetLedgerCostCenter" , method={RequestMethod.GET})
	public List<DropDownModel> restGetCostCenterList() {
		logger.info("Method : restGetCVType starts");

		logger.info("Method : restGetCostCenterList ends");
		return accountLedgerDao.getCostCenterList();
	}*/
	
	/*
	 * REST CONTROLLER - GET COST CENTER restGetLedgerAccountHead
	 *
	 */
	/*@RequestMapping(value="restGetLedgerAccountHead" , method={RequestMethod.GET})
	public List<DropDownModel> restGetAccountHeadList() {
		logger.info("Method : restGetCVType starts");

		logger.info("Method : restGetCostCenterList ends");
		return accountLedgerDao.getAccountHeadList();
	}*/

	/*
	 * 
	 * returns all Ledger Report PDF
	 *
	 */
	/*@RequestMapping(value = "generateLedgerReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AccountLedgerModel>>> getLedgerReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getLedgerReportPdf starts");
		logger.info("Method : getLedgerReportPdf ends");
		return accountLedgerDao.getLedgerReportPdf(request);
	}*/
	
	/*
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	/*@RequestMapping(value="restLogoImage-accountLedger" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
	return accountLedgerDao.getHotelLogo(logoType);
	}*/
	
	/*
	 * returns all Report details to downloads excel
	 *
	 */
	/*@RequestMapping(value = "getLedgerReportListForDownload", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AccountLedgerModel>>> getLedgerReportDownload(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getLedgerReportDownload starts");

		logger.info("Method : getLedgerReportDownload ends");
		return accountLedgerDao.getLedgerReportDownload(request);
	}*/
	
	/*
	 * preview all  Report details 
	 *
	 */
	/*@RequestMapping(value = "/previewReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AccountLedgerModel>>> getLedgerPreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getLedgerPreview starts");
		logger.info("Method : getLedgerPreview endss");
		return accountLedgerDao.getLedgerPreview(request);
	}*/
	

	/*
	 * Preview Excel Download
	 */

	/*@RequestMapping(value = "getExcelForDownload", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AccountLedgerModel>>> getExcelForDownload(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getExcelForDownload starts");

		logger.info("Method : getExcelForDownload ends");
		return accountLedgerDao.getExcelForDownload(request);
	}
*/
	
}
