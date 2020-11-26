/**Defines Cancelled  Rest Controller*/
package nirmalya.aatithya.restmodule.leave.controller;

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
import nirmalya.aatithya.restmodule.leave.dao.RestLeaveCancelledDao;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyModel;  
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave/")
public class RestLeaveCancelledController {

	Logger logger = LoggerFactory.getLogger(RestLeaveCancelledController.class);
	@Autowired
	RestLeaveCancelledDao leaveCancelledDao;
	  
	/*
	 * Get 	getPLeaveType
	 *
	 */
	  @RequestMapping(value = "getCLeaveType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCLeaveType(String getCLeaveType) {
        	logger.info("Method : getCLeaveType starts");

			logger.info("Method : getCLeaveType ends");
		return leaveCancelledDao.getCLeaveType("getCLeaveType");
	}  
	 
	 /*
	  * Get 	getRLApplyData
	  *
	  */ 
		 @RequestMapping(value = "getCLApplyData", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getCLApplyData(
				@RequestBody DataTableRequest request) {
			logger.info("Method : getCLApplyData starts"); 
			
 			logger.info("Method : getCLApplyData ends");
			return leaveCancelledDao.getCLApplyData(request);
		}  
	/*
	 * returns particular  leave Apply to view
	 */
    @RequestMapping(value = "/getLeaveCancelById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeaveApplyModel>> getLeaveCancelById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeaveCancelById starts");
		//System.out.println("in rest controller for model view id----"+id);
		//System.out.println("in rest controller for model view action----"+action);
		logger.info("Method : getLeaveCancelById ends");
		return leaveCancelledDao.getLeaveCancelById(id,action);
	} 
	
}

