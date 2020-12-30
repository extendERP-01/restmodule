package nirmalya.aatithya.restmodule.reimbursement.controller;


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
import nirmalya.aatithya.restmodule.reimbursement.dao.HrmsReimbursementDao;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsTravelingReqHistoryModel;
import nirmalya.aatithya.restmodule.reimbursement.model.HrmsTravelingRequisituionModel;




@RestController
@RequestMapping(value = "reimbursement")
public class HrmsReimbursementRestController {
	Logger logger = LoggerFactory.getLogger(HrmsReimbursementRestController.class);
	
	@Autowired
	HrmsReimbursementDao hrmsReimbursementDao ;
	
	/**
	 * 
	 * @return requisition  list
	 */
	@RequestMapping(value = "/getReqList", method = { RequestMethod.GET })
	public List<DropDownModel> getReqList(@RequestParam String id) {

		logger.info("Method : getReqList starts");
		logger.info("Method : getReqList ends");

		return hrmsReimbursementDao.getReqList(id);
	}
	
	/**
	 * 
	 * @return requisition type list
	 */
	@RequestMapping(value = "/getReimbTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getReimbTypeList() {

		logger.info("Method : getReimbTypeList starts");
		logger.info("Method : getReimbTypeList ends");

		return hrmsReimbursementDao.getReimbTypeList();
	}
	
	/*
	 * for drop down of Rrequisition
	 */
	@RequestMapping(value = "/getRequisitionDtls", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsTravelingRequisituionModel>>> getRrequisitionDtls(@RequestParam String travelReq) {
		logger.info("Method in rest: getRrequisitionDtls starts");

		logger.info("Method in rest: getRrequisitionDtls ends");
		return hrmsReimbursementDao.getRrequisitionDtls(travelReq);
	}
	
	/*
	 * for Add reimbursement details
	 */
	@RequestMapping(value = "restAddReimbursement", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddReimbursement(
			@RequestBody List<HrmsReimbursementModel> hrmsReimbursementModel) {
		logger.info("Method in rest: restAddReimbursement starts");
		logger.info("Method in rest: restAddReimbursement ends");

		return hrmsReimbursementDao.restAddReimbursement(hrmsReimbursementModel);
	}
	/*
	 * for Add reimbursement details
	 */
	@RequestMapping(value = "restAddOtherReimbursement", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddOtherReimbursement(
			@RequestBody List<HrmsReimbursementModel> hrmsReimbursementModel) {
		logger.info("Method in rest: restAddReimbursement starts");
		logger.info("Method in rest: restAddReimbursement ends");
		
		return hrmsReimbursementDao.restAddOtherReimbursement(hrmsReimbursementModel);
	}

	/*
	 * for All reimbursement
	 */
	@RequestMapping(value = "getReimbursementDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> getReimbursementDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getReimbursementDetails starts");

		logger.info("Method : getReimbursementDetails ends");

		return hrmsReimbursementDao.getReimbursementDetails(request);
	}
	
	/*
	 * for get reimbursement by id
	 */
	@RequestMapping(value = "getReimbusementById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> getReimbusementById(
			@RequestParam String reimId) {
		logger.info("Method : getReimbusementById starts");

		logger.info("Method : getReimbusementById ends");

		return hrmsReimbursementDao.getReimbusementById(reimId);
	}
	
	/*
	 * for All Traveling reimbursement details of  first approval
	 */
	@RequestMapping(value = "getTravelingreimbursementDetailsFirst", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsReimbursementModel>>> getTravelingreimbursementDetailsFirst(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getTravelingreimbursementDetailsFirst starts");

		logger.info("Method : getTravelingreimbursementDetailsFirst ends");

		return hrmsReimbursementDao.getTravelingreimbursementDetailsFirst(request);
	}
	/*
	 * 
	 * GetMapping for save-reimbursement-approval-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-reimbursement-approval-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> savereimbursementApprovalAction(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : savereimbursementApprovalAction starts");
		logger.info("Method : savereimbursementApprovalAction endss");
		return hrmsReimbursementDao.savereimbursementApprovalAction(id,createdBy);
	}
	
	/*
	 * 
	 * GetMapping for save-reimbursement-reject-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-reimbursement-reject-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> savereimbursementRejectAction(@RequestParam String id,@RequestParam String createdBy ,@RequestParam String desc ,@RequestParam String rejectType) {
		logger.info("Method : savereimbursementRejectAction starts");
		logger.info("Method : savereimbursementRejectAction endss");
		return hrmsReimbursementDao.savereimbursementRejectAction(id,createdBy,desc,rejectType);
	}
	
	/*
	 * for Traveling reimbursement Edit
	 */
	@RequestMapping(value = "getTravelingreimbursementHistoryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsTravelingReqHistoryModel>>> getTravelingreimbursementHistoryById(@RequestParam String id) {
		logger.info("Method : getTravelingreimbursementHistoryById starts");

		logger.info("Method : getTravelingreimbursementHistoryById ends");

		return hrmsReimbursementDao.getTravelingreimbursementHistoryById(id);
	}
	
	/*
	 * for validate the amount of policy
	 */
	@RequestMapping(value = "/getValidPolicy", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getValidPolicy(@RequestParam String policyId ,@RequestParam String empId) {
		logger.info("Method in rest: getValidPolicy starts");

		logger.info("Method in rest: getValidPolicy ends");
		return hrmsReimbursementDao.getValidPolicy(policyId ,empId);
	}
	
	
	/*
	 * for drop down of policy on reimbursement on change
	 */
	@RequestMapping(value = "/getPolicyReimbOnchange", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPolicyReimbOnchange(@RequestParam String reimType ,@RequestParam String empId) {
		logger.info("Method in rest: getPolicyReimbOnchange starts");

		logger.info("Method in rest: getPolicyReimbOnchange ends");
		return hrmsReimbursementDao.getPolicyReimbOnchange(reimType ,empId);
	}
	
	/**
	 * 
	 * @return requisition  list
	 */
	@RequestMapping(value = "/getPolicyList", method = { RequestMethod.GET })
	public List<DropDownModel> getPolicyList(@RequestParam String reimbType) {

		logger.info("Method : getPolicyList starts");
		logger.info("Method : getPolicyList ends");

		return hrmsReimbursementDao.getPolicyList(reimbType);
	}
	/**
	 * 
	 * @return requisition  list
	 */
	@RequestMapping(value = "/getEmployeeList1", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeList1() {

		logger.info("Method : getEmployeeList1 starts");
		logger.info("Method : getEmployeeList1 ends");

		return hrmsReimbursementDao.getEmployeeList1();
	}
}
