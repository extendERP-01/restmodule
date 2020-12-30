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
import nirmalya.aatithya.restmodule.leave.dao.RestLeaveTypeDao;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveTypeModel;  
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave")
public class RestLeaveTypeController {

	Logger logger = LoggerFactory.getLogger(RestLeavePeriodController.class);
	@Autowired
	RestLeaveTypeDao leaveTypeDao;
	  
	/*
	 * Post Mapping to Add New restAddLeaveType
	 *
	 */
	@RequestMapping(value = "restAddLeaveType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddLeaveType(@RequestBody RestLeaveTypeModel table) {
		logger.info("Method : restAddLeaveType starts");
        logger.info("Method : restAddLeaveType ends");
		return leaveTypeDao.restAddLeaveType(table);
	}
	
	/*
	 * returns  getLtypeData
	 *
	 */
	 
	 @RequestMapping(value = "getLtypeData", method = { RequestMethod.POST })
	 public ResponseEntity<JsonResponse<List<RestLeaveTypeModel>>> getLtypeData(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getLtypeData starts");
	    logger.info("Method : getLtypeData ends");
		return leaveTypeDao.getLtypeData(request);
	} 
	/*
	 * returns particular to delete  Leave Type
	 *
	 */
	@RequestMapping(value="deleteLtypeById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteLtypeById(@RequestParam("id") String id) {
		logger.info("Method : deleteLtypeById starts");
		logger.info("Method : deleteLtypeById ends");
		return leaveTypeDao.deleteLtypeById(id);
	}
	
	/*
	 * returns particular  leave Period to view/edit
	 *
	 */
	@RequestMapping(value = "/getLeaveTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeaveTypeModel>> getLeaveTypeById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeaveTypeById starts");
		logger.info("Method : getLeaveTypeById ends");
		return leaveTypeDao.getLeaveTypeById(id,action);
	} 
	 
	/*
	 * Get getTypeName
	 *
	 */
	@RequestMapping(value = "getTypeName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getTypeName(String getTypeName) {
        	logger.info("Method : getTypeName starts");
            logger.info("Method : getTypeName ends");
		return leaveTypeDao.getTypeName("getTypeName");
	}
	 
	/*
	 * Get 	getAvailPeriod
	 *
	 */
	@RequestMapping(value = "getAvailPeriod", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAvailPeriod(String getAvailPeriod) {
        	logger.info("Method : getAvailPeriod starts");
            logger.info("Method : getAvailPeriod ends");
		return leaveTypeDao.getAvailPeriod("getAvailPeriod");
	}
	
}
