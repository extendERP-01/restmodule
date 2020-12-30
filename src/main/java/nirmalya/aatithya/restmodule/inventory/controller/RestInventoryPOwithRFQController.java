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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.RestPORFQDetailsDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryPORFQVendorDetailModel; 
 

@RestController
@RequestMapping(value = "inventory")
public class RestInventoryPOwithRFQController {
	Logger logger = LoggerFactory.getLogger(RestInventoryPOwithRFQController.class);
	@Autowired
	RestPORFQDetailsDao restPORFQDetailsDao;
	
	
	/*
	 * 
	 * REST CONTROLLER FOR GET PO WITH RFQ DETAILS DATA
	 * 
	 * 
     */
	 @RequestMapping(value = "/getPORFQById", method = { RequestMethod.GET })
	public List<RestInventoryPORFQVendorDetailModel> getPORFQById(@RequestParam("id")String id) {
		logger.info("Method : getPORFQById for rest controller starts");
		
		logger.info("Method : getPORFQById for rest controller ends");
		return restPORFQDetailsDao.getPORFQById(id);
	}
	 
	 
	 
	 

/*
	 * 
	 * PostMapping for add Purchase order with RFQ
	 * 
	 * 
	 */
	@RequestMapping(value = "restAddPOrderRFQ", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<Object>> addPurOrRFQDtls(@RequestBody  List<RestInventoryPORFQVendorDetailModel> addPurOrRFQDtls) {
		logger.info("Method : addPurOrRFQDtls starts");
		//System.out.println("addPurOrRFQDtls--------------"+addPurOrRFQDtls);
		logger.info("Method : addVenRFQDtls ends");
		return restPORFQDetailsDao.addPurOrRFQDtls(addPurOrRFQDtls);
	}

}	