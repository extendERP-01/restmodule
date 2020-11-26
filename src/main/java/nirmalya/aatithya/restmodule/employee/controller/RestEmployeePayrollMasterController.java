package nirmalya.aatithya.restmodule.employee.controller;

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
import nirmalya.aatithya.restmodule.employee.dao.RestEmployeePayrollMasterDao;
import nirmalya.aatithya.restmodule.employee.model.EmployeePayrollMasterModel;

@RestController
@RequestMapping("employee/")
public class RestEmployeePayrollMasterController {
	Logger logger = LoggerFactory.getLogger(RestEmployeePayrollMasterController.class);

	@Autowired
	RestEmployeePayrollMasterDao payrollDao;

	/**
	 * 
	 * 
	 * 
	 * */

	@RequestMapping(value = "validateDate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> validateDate(@RequestParam("param1") String param1) {
		logger.info("Method : validateDate starts"); 

		logger.info("Method : validateDate ends");

		return payrollDao.validateDate(param1);
	}

	@RequestMapping(value = "getEmployeePayRollDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> getEmployeePayRollDetails(
			@RequestParam("param1") String param1) {
		logger.info("Method : getEmployeePayRollDetails starts");

		logger.info("Method : getEmployeePayRollDetails ends");

		return payrollDao.getEmployeePayRollDetails(param1);
	}
	/*
	 * Get Offer Letter Details Model View
	 */

	@RequestMapping(value = "/employeePayrollDetailsModagetEmployeePayRollDetailsl", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> employeePayrollDetailsModal(
			@RequestParam String id) {
		logger.info("Method : employeePayrollDetailsModal starts");

		logger.info("Method : employeePayrollDetailsModal ends");
		return payrollDao.employeePayrollDetailsModal(id);
	}

	/*
	 * for add goal
	 */
	@RequestMapping(value = "restAddEmployeePayRoll", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddEmployeePayRoll(
			@RequestBody List<EmployeePayrollMasterModel> payrollMaster) {
		System.out.println("payrollMaster" + payrollMaster);
		logger.info("Method : restAddEmployeePayRoll starts");

		logger.info("Method : restAddEmployeePayRoll ends");

		return payrollDao.restAddEmployeePayRoll(payrollMaster);
	}

	/*
	 * view all goal master
	 */
	@RequestMapping(value = "getPayrollMasterDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> getPayrollDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPayrollDetails starts");

		logger.info("Method : getPayrollDetails ends");

		return payrollDao.getPayrollDetails(request);
	}

	/*
	 * 
	 * PostMapping for get All list itemRequisition to be Approve
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-payroll-approve", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> getAllPayrollApprove(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllRequisitionsApprove starts");
		logger.info("Method :  getAllRequisitionsApprove endss");
		return payrollDao.getAllPayrollApprove(request);
	}

	/*
	 * 
	 * GetMapping for save-requisition-approval-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-payroll-approval-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> savePayrollApprovalAction(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : savePayrollApprovalAction starts");
		logger.info("Method : savePayrollApprovalAction endss");
		return payrollDao.savePayrollApprovalAction(id, createdBy);
	}

	/*
	 * 
	 * GetMapping for save-requisition-reject-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-payroll-reject-action", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> savePayrollRejectAction(
			@RequestBody EmployeePayrollMasterModel reqobject) {
		logger.info("Method : savePayrollRejectAction starts");
		logger.info("Method : savePayrollRejectAction endss");
		return payrollDao.savePayrollRejectAction(reqobject);
	}

	/*
	 * 
	 * View one Assigned Task in PDF
	 * 
	 * 
	 */
	@RequestMapping(value = "get-one-emp-forPDF", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<EmployeePayrollMasterModel>> getOneEmpPayrollForPDF(@RequestParam String id) {
		logger.info("Method : getOneEmpPayrollForPDF starts");
		logger.info("Method : getOneEmpPayrollForPDF ends");
		return payrollDao.getOneEmpPayrollForPDF(id);
	}

	/*
	 * 
	 * Get mapping for get One ItemRequisition for model view
	 * 
	 * 
	 */
	@RequestMapping(value = "/getPayrollById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<EmployeePayrollMasterModel>>> getPayrollById(
			@RequestParam("id") String id) {
		logger.info("Method : getPayrollById for rest controller starts");
		logger.info("Method : getPayrollById for rest controller ends");
		return payrollDao.getPayrollById(id);
	}
}
