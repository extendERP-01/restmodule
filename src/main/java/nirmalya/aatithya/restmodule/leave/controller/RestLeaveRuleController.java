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
import nirmalya.aatithya.restmodule.leave.dao.RestLeaveRuleDao;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveRuleModel;   
/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave")
public class RestLeaveRuleController {

	Logger logger = LoggerFactory.getLogger(RestLeaveRuleController.class);
	@Autowired
	RestLeaveRuleDao leaveRuleDao;
	  
	/*
	 * Post Mapping to Add  restAddLeaveRule
	 *
	 */
	@RequestMapping(value = "restAddLeaveRule", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddLeaveRule(@RequestBody RestLeaveRuleModel table) {
		logger.info("Method : restAddLeaveRule starts");
        logger.info("Method : restAddLeaveRule ends");
		return leaveRuleDao.restAddLeaveRule(table);
	}
	
	/*
	 * returns  getLRuleData
	 *
	 */
	 
	@RequestMapping(value = "getLRuleData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestLeaveRuleModel>>> getLRuleData(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getLRuleData starts");
	    logger.info("Method : getLRuleData ends");
		return leaveRuleDao.getLRuleData(request);
	}
	
	/*
	 * Get 	getLeaveTypeName
	 *
	 */
	 @RequestMapping(value = "getLeaveTypeName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLeaveTypeName(String getLeaveTypeName) {
        	logger.info("Method : getLeaveTypeName starts");
            logger.info("Method : getLeaveTypeName ends");
		return leaveRuleDao.getLeaveTypeName("getLeaveTypeName");
	}
	  
	/*
	 * Get 	getJobTitle
	 *
	 */
	@RequestMapping(value = "getJobTitle", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTitle(String getJobTitle ,String id) {
        	logger.info("Method : getJobTitle starts");
            logger.info("Method : getJobTitle ends");
		return leaveRuleDao.getJobTitle("getJobTitle" ,id);
	}
	  
	/*
	 * Get 	getEmplmtStatus
	 *
	 */
	@RequestMapping(value = "getEmplmtStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmplmtStatus(String getEmplmtStatus , String id) {
        	logger.info("Method : getEmplmtStatus starts");
            logger.info("Method : getEmplmtStatus ends");
		return leaveRuleDao.getEmplmtStatus("getEmplmtStatus" , id);
	}
	 
	/*
	 * Get 	getEmpName
	 *
	 */
	@RequestMapping(value = "getEmpName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpName(String getEmpName ,String id) {
        	logger.info("Method : getEmpName starts");
            logger.info("Method : getEmpName ends");
		return leaveRuleDao.getEmpName("getEmpName" ,id);
	}
	 
	/*
	 * Get 	getDeptName
	 *
	 */
	@RequestMapping(value = "getDeptName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDeptName(String getDeptName) {
        	logger.info("Method : getDeptName starts");
            logger.info("Method : getDeptName ends");
		return leaveRuleDao.getDeptName("getDeptName");
	}
	 
	/*
	 * Get 	getLeavePeriod
	 *
	 */
	@RequestMapping(value = "getLeavePeriod", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLeavePeriod(String getLeavePeriod) {
        	logger.info("Method : getLeavePeriod starts");
            logger.info("Method : getLeavePeriod ends");
		return leaveRuleDao.getLeavePeriod("getLeavePeriod");
	}
	 
	/*
	 * Get 	getAvailPeriod
	 *
	 */
	@RequestMapping(value = "getRuleAvailPeriod", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRuleAvailPeriod(String getRuleAvailPeriod) {
        	logger.info("Method : getRuleAvailPeriod starts");
            logger.info("Method : getRuleAvailPeriod ends");
		return leaveRuleDao.getRuleAvailPeriod("getRuleAvailPeriod");
	}
	
	/*
	 * returns particular to delete  Leave Rule
	 *
	 */
	@RequestMapping(value="deleteLRuleById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteLRuleById(@RequestParam("id") String id) 
	{
		logger.info("Method : deleteLRuleById starts");
		logger.info("Method : deleteLRuleById ends");
		return leaveRuleDao.deleteLRuleById(id);
	}
	
	/*
	 * returns particular  leave Rule to view/edit
	 *
	 */
	@RequestMapping(value = "/getLeaveRuleById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeaveRuleModel>> getLeaveRuleById(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeaveRuleById starts");
		logger.info("Method : getLeaveRuleById ends");
		return leaveRuleDao.getLeaveRuleById(id,action);
	} 
	 
	/*
	 * returns particular  leave Rule to view Model
	 */
	@RequestMapping(value = "/getLeaveRuleByIdModel", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestLeaveRuleModel>> getLeaveRuleByIdModel(@RequestParam("id")String id,@RequestParam("Action") String action) {
		logger.info("Method : getLeaveRuleByIdModel starts");
		logger.info("Method : getLeaveRuleByIdModel ends");
		return leaveRuleDao.getLeaveRuleByIdModel(id,action);
	}
	
	/*
	 * for drop down of job type
	 */
	@RequestMapping(value = "/getJobTypeOnChange", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTypeOnChange(@RequestParam String deptId) {
		logger.info("Method in rest: getJobTypeOnChange starts");

		logger.info("Method in rest: getJobTypeOnChange ends");
		return leaveRuleDao.getJobTypeOnChange(deptId);
	}
	 
	
	
	/*
	 * for drop down of job type
	 */
	@RequestMapping(value = "/getEmployeeList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeList(@RequestParam String jobTitleId) {
		logger.info("Method in rest: getEmployeeList starts");

		logger.info("Method in rest: getEmployeeList ends");
		return leaveRuleDao.getEmployeeList(jobTitleId);
	}
	
	/*
	 * for drop down of job type
	 */
	@RequestMapping(value = "/getEmploymentList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmploymentList(@RequestParam String empId) {
		logger.info("Method in rest: getEmploymentList starts");

		logger.info("Method in rest: getEmploymentList ends");
		return leaveRuleDao.getEmploymentList(empId);
	}
}
