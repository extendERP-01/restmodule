package nirmalya.aatithya.restmodule.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DataSetForPropType1;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.RestRFQDetailsDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRFQVendorDetailModel; 

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class RestInvRFQVendorDetlController {
	Logger logger = LoggerFactory.getLogger(RestInvRFQVendorDetlController.class);
	@Autowired
	RestRFQDetailsDao restRFQDetailsDao;
	
	/**
	 * Rest Controller - Auto Search for RFQ no.
	 *
	 */ 	
	@RequestMapping(value = "getRFQListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRFQAutoSearch(@RequestParam String id) {
		logger.info("Method : getRFQAutoSearch starts");

		logger.info("Method : getRFQAutoSearch ends");
		return restRFQDetailsDao.getRFQAutoSearch(id);
	}
	
	
	
	

	/*
	 * Get 	GET RFQ NAME
	 *
	 */
	@RequestMapping(value = "getRFQNameListd", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRFQNameListd(String getRFQNameListd) {
        	logger.info("Method : getRFQNameListd starts");

			logger.info("Method : getRFQNameListd ends");
		return restRFQDetailsDao.getRFQNameListd("getRFQNameListd");
	}
	
	
	/**
	 * Rest Controller - Auto Search for Item Menu.
	 *
	 */ 	 
	
	@RequestMapping(value = "getRFQItemList", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DataSetForPropType1>>> getRFQItemList(
			@RequestBody List<DataSetForPropType1> table) {
		logger.info("Method : getRFQItemList starts");
		logger.info("Method : getRFQItemList ends");
		return restRFQDetailsDao.getRFQItemList(table);
	}
	
	
	/**
	 * Rest Controller - Auto Search Vendor List for RFQ no.
	 *
	 */ 	
	@RequestMapping(value = "getRFQVenListbyRfq", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRFQVenListbyRfq(@RequestParam String id) {
		logger.info("Method : getRFQVenListbyRfq starts");

		logger.info("Method : getRFQVenListbyRfq ends");
		return restRFQDetailsDao.getRFQVenListbyRfq(id);
	} 
	
	/*
	 * 
	 * PostMapping for add VEndor RFQ
	 * 
	 * 
	 */
	@RequestMapping(value = "restAddVendorRFQ", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addVenRFQDtls(@RequestBody  List<RestInventoryRFQVendorDetailModel> vendorDtlsRFQ) {
		logger.info("Method : addVenRFQDtls starts");
		//System.out.println("vendorDtlsRFQ--------------"+vendorDtlsRFQ);
		logger.info("Method : addVenRFQDtls ends");
		return restRFQDetailsDao.addVenRFQDtls(vendorDtlsRFQ);
	}
 
	/*
	 * Get 	lPeriodData MAnager
	 *
	 */
	
	
	@RequestMapping(value = "getRFQVenDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> getRFQVenData(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getRFQVenData starts");
		//System.out.println("param is Rest controller-----"+request.getParam1());
		logger.info("Method : getRFQVenData ends");
		return restRFQDetailsDao.getRFQVenData(request);
	}
	
	

	
	
	/**
	 * REST CONTROLLER - Get Vendor DropDown List
	 *
	 */
	@RequestMapping(value="restGetVendor" , method={RequestMethod.GET})
	public List<DropDownModel> restGetVendor() {
		logger.info("Method : restGetVendor starts");

		logger.info("Method : restGetVendor ends");
		return restRFQDetailsDao.restGetVendor();
	}


	/*
	 * returns particular  RFQ Vendor Quote to view/edit
	 *
	 */
  

	 @RequestMapping(value = "/getRFQVDById", method = { RequestMethod.GET })
		public List<RestInventoryRFQVendorDetailModel> getRFQVDById(@RequestParam("id")String id) {
			logger.info("Method : getRFQVDById for rest controller starts");
			
			logger.info("Method : getRFQVDById for rest controller ends");
			return restRFQDetailsDao.getRFQVDById(id);
		} 

/*
	 * 
	 * Get mapping for get one VENDOR RFQ model view
	 * 
	 * 
	 */
	
	
	@RequestMapping(value = "getVendorRFQModel", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryRFQVendorDetailModel>>> getVendRFQModel(@RequestParam("id") String id) {
		logger.info("Method : getVendRFQModel starts");
		logger.info("Method : getVendRFQModel endss");
		return restRFQDetailsDao.getVendRFQModel(id);
	}

}


