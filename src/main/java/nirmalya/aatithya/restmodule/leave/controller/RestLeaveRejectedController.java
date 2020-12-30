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
import nirmalya.aatithya.restmodule.leave.dao.RestLeaveRejectedDao;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyModel;   
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave/")
public class RestLeaveRejectedController {

	Logger logger = LoggerFactory.getLogger(RestLeaveRejectedController.class);
	@Autowired
	RestLeaveRejectedDao leaveRejectedDao; 
	/*
	 * Get 	getPLeaveType
	 *
	 */
	  @RequestMapping(value = "getRLeaveType", method = { RequestMethod.GET })
	  public ResponseEntity<JsonResponse<List<DropDownModel>>> getRLeaveType(String getRLeaveType) {
        	logger.info("Method : getRLeaveType starts");
        	logger.info("Method : getRLeaveType ends");
		return leaveRejectedDao.getRLeaveType("getRLeaveType");
	}  
	 
	 /*
	  * Get getRLApplyData
	  *
	  */
		
	 
		@RequestMapping(value = "getRLApplyData", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getRLApplyData(
				@RequestBody DataTableRequest request) {
			logger.info("Method : getRLApplyData starts"); 
			logger.info("Method : getRLApplyData ends");
			return leaveRejectedDao.getRLApplyData(request);
		} 
		 
	/*
	 * returns particular  leave Apply to view
	 */
    @RequestMapping(value = "getLeaveRejectedById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeaveApplyModel>> getLeaveRejectedById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeaveRejectedById starts");
		logger.info("Method : getLeaveRejectedById ends");
		return leaveRejectedDao.getLeaveRejectedById(id,action);
	} 
	
}

