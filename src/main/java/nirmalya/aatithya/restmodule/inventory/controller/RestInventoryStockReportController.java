package nirmalya.aatithya.restmodule.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.model.RestDebitCreditLedgerModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.RestInventoryStockReportDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryStockReportModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class RestInventoryStockReportController {
	Logger logger = LoggerFactory.getLogger(RestInventoryStockReportController.class);
	@Autowired
	RestInventoryStockReportDao stockReportDao;
	
	
	/*
	 * 
	 * Get mapping for get Store name
	 * 
	 * 
	 */
	@RequestMapping(value = "report-restGet-store", method = { RequestMethod.GET })
	public List<DropDownModel> getStoreListReport() {
		logger.info("Method : getStoreListReport starts");
		logger.info("Method : getStoreListReport endss");
		return stockReportDao.getStoreListReport();
	}
	
	/*
	 * 
	 * Get mapping for get Godown Name
	 * 
	 * 
	 */
	@RequestMapping(value = "report-restGet-godown", method = { RequestMethod.GET })
	public List<DropDownModel> getGodownListReport() {
		logger.info("Method : getGodownListReport starts");
		logger.info("Method : getGodownListReport endss");
		return stockReportDao.getGodownListReport();
	}
	/*
	 * 
	 * Get mapping for get Item Name
	 * 
	 * 
	 */
	@RequestMapping(value = "report-restGet-item", method = { RequestMethod.GET })
	public List<DropDownModel> getItemListReport() {
		logger.info("Method : getItemListReport starts");
		logger.info("Method : getItemListReport endss");
		return stockReportDao.getItemListReport();
	}
	
	/*
	 * preview all  Report details 
	 *
	 */
	@RequestMapping(value = "/previewInventoryStockReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryStockReportModel>>> getInventoryStockPreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getInventoryStockPreview starts");
		logger.info("Method : getInventoryStockPreview endss");
		return stockReportDao.getInventoryStockPreview(request);
	}
	
	
	/*
	 * 
	 * returns all Inventory Stock Report PDF
	 *
	 */
	@RequestMapping(value = "generatInventoryStockReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryStockReportModel>>> getInventoryStockReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getInventoryStockReportPdf starts");
		logger.info("Method : getInventoryStockReportPdf ends");
		return stockReportDao.getInventoryStockReportPdf(request);
	}
}
