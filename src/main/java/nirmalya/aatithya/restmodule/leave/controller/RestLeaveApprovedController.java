/**Defines Approved  Rest Controller*/
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
import nirmalya.aatithya.restmodule.leave.dao.RestLeaveApprovedDao;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyModel;  
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave/")
public class RestLeaveApprovedController {

	Logger logger = LoggerFactory.getLogger(RestLeaveApprovedController.class);
	@Autowired
	RestLeaveApprovedDao leaveApprovedDao;
	 
	/*
	 * Get 	getPLeaveType
	 *
	 */
	  @RequestMapping(value = "getALeaveType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getALeaveType(String getALeaveType) {
        	logger.info("Method : getALeaveType starts");

			logger.info("Method : getPLeaveType ends");
		return leaveApprovedDao.getALeaveType("getALeaveType");
	}  
	 
	 /*
	  * Get 	getALApplyData
	  *
	  */
		 
		 @RequestMapping(value = "getALApplyData", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getALApplyData(
				@RequestBody DataTableRequest request) {
			logger.info("Method : getALApplyData starts"); 
			
 			logger.info("Method : getALApplyData ends");
			return leaveApprovedDao.getALApplyData(request);
		} 
		 
	 
	/*
	 * returns particular  leave Apply to view
	 */
    @RequestMapping(value = "/getLeaveApprovedById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeaveApplyModel>> getLeaveApprovedById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeaveApprovedById starts");
		//System.out.println("in rest controller for model view id----"+id);
		//System.out.println("in rest controller for model view action----"+action);
		logger.info("Method : getLeaveApprovedById ends");
		return leaveApprovedDao.getLeaveApprovedById(id,action);
	} 
	
}

