/**Defines District master Rest Controller*/
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
import nirmalya.aatithya.restmodule.leave.dao.RestLeaveApplyAdminDao;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyAdminModel;  
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave/")
public class RestLeaveApplyAdminController {

	Logger logger = LoggerFactory.getLogger(RestLeaveApplyAdminController.class);
	@Autowired
	RestLeaveApplyAdminDao leaveApplyAdminDao;
	
 
	/*
	 * Get 	getLeaveTypeName
	 *
	 */
	@RequestMapping(value = "getAdminLeaveType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAdminLeaveType(String getAdminLeaveType) {
        	logger.info("Method : getAdminLeaveType starts");

			logger.info("Method : getAdminLeaveType ends");
		return leaveApplyAdminDao.getAdminLeaveType("getAdminLeaveType");
	}

	/*
	 * Get 	getStatusType
	 *
	 */
	@RequestMapping(value = "getStatusType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStatusType(String getStatusType) {
        	logger.info("Method : getStatusType starts");

			logger.info("Method : getStatusType ends");
		return leaveApplyAdminDao.getStatusType("getStatusType");
	}
	
	
	 /*
	  * Get 	getLApplyData
	  *
	  */
		
		
		 @RequestMapping(value = "getAllLApplyData", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<List<RestLeaveApplyAdminModel>>> getAllLApplyData(
				@RequestBody DataTableRequest request) {
			logger.info("Method : getAllLApplyData starts"); 
			
 			logger.info("Method : getAllLApplyData ends");
			return leaveApplyAdminDao.getAllLApplyData(request);
		} 
		
	 

		 
		 
		 /*
			 * Post Mapping to Change Status
			 *
			 */
			 
			@RequestMapping(value = "restChangeStatus", method = { RequestMethod.POST })
			public ResponseEntity<JsonResponse<Object>> restChangeStatus(@RequestBody RestLeaveApplyAdminModel table) {
				logger.info("Method : restChangeStatus starts");
				System.out.println("restChangeStatus data :-----------------------------11111111111 "+table);
				logger.info("Method : restChangeStatus ends");
				// System.out.println("restAddLeavePeriod data : "+table);
				return leaveApplyAdminDao.restChangeStatus(table);
			}
			
			
			
			/*
			 * returns particular  leave Apply Model
			 *
			 */
		    @RequestMapping(value = "/getLeaveAdmById", method = { RequestMethod.GET })
			public ResponseEntity<JsonResponse<RestLeaveApplyAdminModel>> getLeaveAdmById(@RequestParam("id")String id,@RequestParam("Action") String action) {
				logger.info("Method : getLeaveAdmById starts"); 
				logger.info("Method : getLeaveAdmById ends");
				return leaveApplyAdminDao.getLeaveAdmById(id,action);
			} 
	
	/*
	 * returns particular to cancel LeaveBy 
	 *
	 */
	/*@RequestMapping(value="cancelLeaveById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> cancelLeaveById(@RequestParam("id") String id) 
	{
		logger.info("Method : cancelLeaveById starts");
		
		logger.info("Method : cancelLeaveById ends");
		return leaveApplyDao.cancelLeaveById(id);
	}*/
	
	/*
	 * returns particular  leave Apply to view/edit
	 *
	 */
   /* @RequestMapping(value = "/getLeaveApplyById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeaveApplyModel>> getLeaveApplyById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeaveApplyById starts");
		//System.out.println("in rest controller for model view id----"+id);
		//System.out.println("in rest controller for model view action----"+action);
		logger.info("Method : getLeaveApplyById ends");
		return leaveApplyDao.getLeaveApplyById(id,action);
	} */
	
}
