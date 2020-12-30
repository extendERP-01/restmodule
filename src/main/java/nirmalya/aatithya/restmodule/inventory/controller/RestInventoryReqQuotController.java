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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.inventory.dao.RestReqQuotDetailsDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryReqDetailsModel; 

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class RestInventoryReqQuotController {
	
	Logger logger = LoggerFactory.getLogger(RestInventoryReqQuotController.class);
	@Autowired
	RestReqQuotDetailsDao restReqQuotDetailsDao;
	

	/*
	 * Post Mapping to Add New RFQ
	 *
	 */
	@RequestMapping(value = "restAddReqQuotation", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddReqQuotation(@RequestBody RestInventoryReqDetailsModel table) {
		logger.info("Method : restAddReqQuotation starts");

		logger.info("Method : restAddReqQuotation ends");
		// System.out.println("restAddLeavePeriod data : "+table);
		return restReqQuotDetailsDao.addReqQuotation(table);
	}
	 
	
	/*
	 * Get 	View RFQ FOR Assigned Vendor By MAnager
	 *
	 */ 
	
	@RequestMapping(value = "getReqQuotData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> getReqQuotData(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getReqQuotData starts");
		//System.out.println("param is Rest controller-----"+request.getParam1());
		logger.info("Method : getReqQuotData ends");
		return restReqQuotDetailsDao.getReqQuotData(request);
	} 
	
	/*
	 * Get 	getRFQApproveData for approved RFQ
	 *
	 */
	
	
	@RequestMapping(value = "getRFQApproveData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> getRFQApproveData(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getRFQApproveData starts");
		//System.out.println("param is Rest controller-----"+request.getParam1());
		logger.info("Method : getRFQApproveData ends");
		return restReqQuotDetailsDao.getRFQApproveData(request);
	} 
	

	/**
	 * CHANGE STATUS Inventory Approve Status
	 *
	 */

	@RequestMapping(value = "approveRFQStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveRFQStatus(@RequestParam String checkedRFQId) {
		logger.info("Method : RestController approveRFQStatus starts");
		//System.out.println("id in rest ---------------"+checkedRFQId); 
		logger.info("Method : RestController approveRFQStatus ends");
		return restReqQuotDetailsDao.approveRFQStatus(checkedRFQId);
	} 
	
	/*
	 * Get 	lPeriodData Staff
	 *
	 */ 
	
	@RequestMapping(value = "getReqQuotDataStaff", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryReqDetailsModel>>> getReqQuotDataStaff(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getReqQuotDataStaff starts");
		//System.out.println("param is Rest controller-----"+request.getParam1());
		logger.info("Method : getReqQuotDataStaff ends");
		return restReqQuotDetailsDao.getReqQuotDataStaff(request);
	} 
	
	
	/*
	 * returns particular  Request Quote to view/edit
	 *
	 */
	 @RequestMapping(value = "/getRFQById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestInventoryReqDetailsModel>> getRFQById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeavePeriodById starts");
		//System.out.println("in rest controller for model view id----"+id);
		//System.out.println("in rest controller for model view action----"+action);
		logger.info("Method : getLeavePeriodById ends");
		return restReqQuotDetailsDao.getRFQdById(id,action);
	} 
	
	  

 	/*
	 * Get 	GET VENDORS
	 *
	 */
	@RequestMapping(value = "getVendorsList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorsList(String getVendorsList) {
        	logger.info("Method : getVendorsList starts");

			logger.info("Method : getVendorsList ends");
		return restReqQuotDetailsDao.getVendorsList("getVendorsList");
	}
	
	
	/*
	 * Get 	GET CATEGORY
	 *
	 */
	@RequestMapping(value = "getCatList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCatList(String getCatList) {
        	logger.info("Method : getCatList starts");

			logger.info("Method : getCatList ends");
		return restReqQuotDetailsDao.getCatList("getCatList");
	} 

/**
	 * Rest Controller -  Vendor List for CATID.
	 *
	 */ 	
	@RequestMapping(value = "getVenListbyCat", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVenListbyCat(@RequestParam String id) {
		logger.info("Method : getVenListbyCat starts");

		logger.info("Method : getVenListbyCat ends");
		return restReqQuotDetailsDao.getVenListbyCat(id);
	}
	
	/*
	 * Get 	GET RFQ NAME
	 *
	 */
	@RequestMapping(value = "getRFQNameList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRFQNameList(String getRFQNameList) {
        	logger.info("Method : getRFQNameList starts");

			logger.info("Method : getRFQNameList ends");
		return restReqQuotDetailsDao.getRFQNameList("getRFQNameList");
	}
	
	
	
	/**
	 * ADD Vendors
	 *
	 */
	@RequestMapping(value = "restAddVendors", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddVendors(@RequestBody RestInventoryReqDetailsModel form) {
		logger.info("Method : RESTMODULE restAddVendors   starts");
	//	System.out.println("form posted data in add vendor through Model----------------"+form);
		logger.info("Method : RESTMODULE restAddVendors   end");
		return restReqQuotDetailsDao.restAddVendors(form);
	}
	
	@RequestMapping(value = "getVendorListForAsign", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorListForAsign(@RequestParam String id) {
        	logger.info("Method : getVendorListForAsign starts");

			logger.info("Method : getVendorListForAsign ends");
		return restReqQuotDetailsDao.getVendorListForAsign(id);
	}
	
}
