
/**Defines Pending  Rest Controller*/
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
import nirmalya.aatithya.restmodule.leave.dao.RestLeavePendingDao;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyModel;   
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave/")
public class RestLeavePendingController {

	Logger logger = LoggerFactory.getLogger(RestLeavePendingController.class);
	@Autowired
	RestLeavePendingDao leavePendingDao;
	 
	/*
	 * Get 	getPLeaveType
	 *
	 */
	  @RequestMapping(value = "getPLeaveType", method = { RequestMethod.GET })
	  public ResponseEntity<JsonResponse<List<DropDownModel>>> getPLeaveType(String getPLeaveType) {
	      logger.info("Method : getPLeaveType starts");
	      logger.info("Method : getPLeaveType ends");
	  return leavePendingDao.getPLeaveType("getPLeaveType");
	} 
	 
	 /*
	  * Get 	getLApplyData
	  *
	  */ 
		@RequestMapping(value = "getPLApplyData", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getPLApplyData(
				@RequestBody DataTableRequest request) {
			logger.info("Method : getPLApplyData starts"); 
 			logger.info("Method : getPLApplyData ends");
			return leavePendingDao.getPLApplyData(request);
		} 
		 
	/*
	 * returns particular  leave Apply to view
	 */
    @RequestMapping(value = "/getLeavePendingById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeaveApplyModel>> getLeavePendingById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeavePendingById starts");
		logger.info("Method : getLeavePendingById ends");
		return leavePendingDao.getLeavePendingById(id,action);
	} 
	
}

