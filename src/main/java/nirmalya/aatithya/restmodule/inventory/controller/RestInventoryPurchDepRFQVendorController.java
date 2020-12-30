package nirmalya.aatithya.restmodule.inventory.controller;

 
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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest; 
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;  
import nirmalya.aatithya.restmodule.inventory.dao.RestReqQuotVendorPurDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRFQVendorDetailModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryReqDetailsModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class RestInventoryPurchDepRFQVendorController {
	
	Logger logger = LoggerFactory.getLogger(RestInventoryPurchDepRFQVendorController.class);
	@Autowired
	RestReqQuotVendorPurDao restReqQuotVendorPurDao;
	 
	 
	/*
	 * Get 	lPeriodData MAnager
	 *
	 */ 
	
	@RequestMapping(value = "getReqQuotDataVendor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> getReqQuotData(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getReqQuotData starts");
		//System.out.println("param is Rest controller-----"+request.getParam1());
		logger.info("Method : getReqQuotData ends");
		return restReqQuotVendorPurDao.getReqQuotData(request);
	}
	 
	/*
	 * Get 	lPeriodData MAnager
	 *
	 */ 
	
	@RequestMapping(value = "getRFQDataVendorSelect", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> getRFQDataVendorSelect(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getRFQDataVendorSelect starts");
		//System.out.println("param is Rest controller-----"+request.getParam1());
		logger.info("Method : getRFQDataVendorSelect ends");
		return restReqQuotVendorPurDao.getRFQDataVendorSelect(request);
	}
	 

	/**
	 * CHANGE STATUS Inventory Approve Status
	 *
	 */

	@RequestMapping(value = "approveQuotStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveQuotStatus(@RequestParam String id,
			@RequestParam String rfqId, @RequestParam Byte approveStatus) {
		logger.info("Method : RestController approveQuotStatus starts");
		//System.out.println("id in rest ---------------"+id);
		//System.out.println("rfqId in rest -----------"+rfqId);
		//System.out.println("approveStatus in rest------------"+approveStatus);
		logger.info("Method : RestController approveQuotStatus ends");
		return restReqQuotVendorPurDao.approveQuotStatus(id, rfqId, approveStatus);
	} 
	
	/*
	 * 
	 * Get mapping for get Quotation Model data
	 * 
	 * 
	 */ 
	@RequestMapping(value = "getQuotationModel", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> getQuotationModel(@RequestParam("id") String id) {
		logger.info("Method : getQuotationModel starts");
		logger.info("Method : getQuotationModel endss");
		return restReqQuotVendorPurDao.getQuotationModel(id);
	} 
	
}
