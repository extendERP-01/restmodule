/**Defines Rejected  Rest Controller*/
package nirmalya.aatithya.restmodule.leave.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest; 
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;  
import nirmalya.aatithya.restmodule.leave.dao.RestLeaveEntitleDao;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveEmpEntitleModel;  
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave/")
public class RestEmpEntitlementController {

	Logger logger = LoggerFactory.getLogger(RestEmpEntitlementController.class);
	@Autowired
	RestLeaveEntitleDao leaveEntitleDao;
	
	 
	 
	/*
	 * Get 	getPLeaveType
	 *
	 */
	 /* @RequestMapping(value = "getRLeaveType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRLeaveType(String getRLeaveType) {
        	logger.info("Method : getRLeaveType starts");

			logger.info("Method : getRLeaveType ends");
		return leaveEntitleDao.getRLeaveType("getRLeaveType");
	}  */
	 
	 /*
	  * Get 	getLEntitleData
	  *
	  */
		 
		@RequestMapping(value = "getLEntitleData", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<List<RestLeaveEmpEntitleModel>>> getLEntitleData(
				@RequestBody DataTableRequest request) {
			logger.info("Method : getLEntitleData starts"); 
			
 			logger.info("Method : getLEntitleData ends");
			return leaveEntitleDao.getLEntitleData(request);
		} 
		
	 

	
	 
	/*
	 * returns particular  leave Apply to view
	 */
   /* @RequestMapping(value = "/getLeaveRejectedById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeaveApplyModel>> getLeaveRejectedById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeaveRejectedById starts");
		//System.out.println("in rest controller for model view id----"+id);
		//System.out.println("in rest controller for model view action----"+action);
		logger.info("Method : getLeaveRejectedById ends");
		return leaveEntitleDao.getLeaveRejectedById(id,action);
	} */
	
}

