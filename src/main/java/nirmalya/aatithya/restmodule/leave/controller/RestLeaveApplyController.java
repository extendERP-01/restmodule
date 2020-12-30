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
import nirmalya.aatithya.restmodule.leave.dao.RestLeaveApplyDao;
import nirmalya.aatithya.restmodule.leave.model.LeaveHistoryDetailsModel;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyModel;
import nirmalya.aatithya.restmodule.leave.model.RestLeaveEmpEntitleModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "leave/")
public class RestLeaveApplyController {

	Logger logger = LoggerFactory.getLogger(RestLeaveApplyController.class);
	@Autowired
	RestLeaveApplyDao leaveApplyDao;

	/*
	 * Get getLeaveTypeName
	 *
	 */
	@RequestMapping(value = "getLeaveType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getLeaveType(String getLeaveType) {
		logger.info("Method : getLeaveType starts");

		logger.info("Method : getLeaveType ends");
		return leaveApplyDao.getLeaveType("getLeaveType");
	}

	/*
	 * Get getAvailLeave
	 *
	 */
	@RequestMapping(value = "getAvailLeave", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAvailLeave(String empId) {
		logger.info("Method : getAvailLeave starts");

		logger.info("Method : getAvailLeave ends");
		return leaveApplyDao.getAvailLeave(empId);
	}

	/*
	 * Get getLApplyData
	 *
	 */
	@RequestMapping(value = "getLApplyData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getLApplyData(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getLApplyData starts");

		logger.info("Method : getLApplyData ends");
		return leaveApplyDao.getLApplyData(request);
	}

	/*
	 * Get getLApplyData
	 *
	 */
	@RequestMapping(value = "getLApplyDataApprove", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getLApplyDataApprove(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getLApplyDataApprove starts");

		logger.info("Method : getLApplyDataApprove ends");
		return leaveApplyDao.getLApplyDataApprove(request);
	}

	/*
	 * Get Leave list onchange
	 *
	 */

	@RequestMapping(value = "restGetLeaveList", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestLeaveEmpEntitleModel>>> restGetLeaveList(
			@RequestBody List<RestLeaveEmpEntitleModel> table) {
		logger.info("Method : restGetLeaveList starts");
		logger.info("Method : restGetLeaveList ends");
		return leaveApplyDao.restGetLeaveList(table);
	}

	/*
	 * returns particular to cancel LeaveBy
	 *
	 */
	@RequestMapping(value = "cancelLeaveById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> cancelLeaveById(@RequestParam("id") String id) {
		logger.info("Method : cancelLeaveById starts");

		logger.info("Method : cancelLeaveById ends");
		return leaveApplyDao.cancelLeaveById(id);
	}

	/*
	 * returns particular leave Apply Model
	 *
	 */
	@RequestMapping(value = "/getLeaveApplyById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestLeaveApplyModel>>> getLeaveApplyById(@RequestParam("id") String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getLeaveApplyById starts");
		logger.info("Method : getLeaveApplyById ends");
		return leaveApplyDao.getLeaveApplyById(id, action);
	}
	/*
	 * for Add Other Service price getAssignEduDetails
	 */

	@RequestMapping(value = "restAddLeave", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddLeave(
			@RequestBody List<RestLeaveApplyModel> restLeaveApplyModel) {
		logger.info("Method in rest: restAddLeave starts");

		logger.info("Method in rest: restAddLeave ends");

		return leaveApplyDao.restAddLeave(restLeaveApplyModel);
	}

	/*
	 * 
	 * GetMapping for save-leave-approval-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-leave-approval-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> saveLeaveApprovalAction(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : saveLeaveApprovalAction starts");
		logger.info("Method : saveLeaveApprovalAction endss");
		return leaveApplyDao.saveLeaveApprovalAction(id, createdBy);
	}

	/*
	 * 
	 * GetMapping for save-leave-reject-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-leave-reject-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> saveLeaveRejectAction(@RequestParam String id,
			@RequestParam String createdBy, @RequestParam String desc, @RequestParam String rejectType) {
		logger.info("Method : saveLeaveRejectAction starts");
		logger.info("Method : saveLeaveRejectAction endss");
		return leaveApplyDao.saveLeaveRejectAction(id, createdBy, desc, rejectType);
	}

	/*
	 * for Traveling leave edit
	 * 
	 */
	@RequestMapping(value = "getLeaveHistoryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<LeaveHistoryDetailsModel>>> getLeaveHistoryById(@RequestParam String id) {
		logger.info("Method : getLeaveHistoryById starts");

		logger.info("Method : getLeaveHistoryById ends");

		return leaveApplyDao.getLeaveHistoryById(id);
	}

}
