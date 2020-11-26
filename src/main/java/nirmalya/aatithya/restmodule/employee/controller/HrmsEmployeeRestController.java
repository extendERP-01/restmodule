package nirmalya.aatithya.restmodule.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeDao; 
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeSalaryStructureModel;
import nirmalya.aatithya.restmodule.employee.model.RestIncomeTaxModel;

@RestController
@RequestMapping("employee/")
public class HrmsEmployeeRestController {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeRestController.class);

	@Autowired
	HrmsEmployeeDao hrmsEmployeeDao;

	/*
	 * for get employment list
	 */
	@GetMapping(value = "getEmploymentList")
	public List<DropDownModel> getEmploymentList() {

		logger.info("Method : getEmploymentList starts");
		logger.info("Method : getEmploymentList ends");

		return hrmsEmployeeDao.getEmploymentList();
	}

	/**
	 * 
	 * @return department list
	 */
	@GetMapping(value = "getDepartmentList")
	public List<DropDownModel> getDepartmentList() {

		logger.info("Method : getDepartmentList starts");
		logger.info("Method : getDepartmentList ends");

		return hrmsEmployeeDao.getDepartmentList();
	}

	@GetMapping(value = "getBranchList")
	public List<DropDownModel> getBranchList() {
		logger.info("Method : getBranchList starts");

		logger.info("Method : getBranchList ends");
		return hrmsEmployeeDao.getBranchList();
	}

	/**
	 * 
	 * @return department list
	 */
	@GetMapping(value = "getGenderList")
	public List<DropDownModel> getGenderList() {

		logger.info("Method : getGenderList starts");
		logger.info("Method : getGenderList ends");

		return hrmsEmployeeDao.getGenderList();
	}

	/**
	 * 
	 * @return Marital list
	 */
	@GetMapping(value = "getMaritalList")
	public List<DropDownModel> getMaritalList() {

		logger.info("Method : getMaritalList starts");
		logger.info("Method : getMaritalList ends");

		return hrmsEmployeeDao.getMaritalList();
	}

	/**
	 * 
	 * @return department list
	 */
	@GetMapping(value = "getCountryList")
	public List<DropDownModel> getCountryList() {

		logger.info("Method : getCountryList starts");
		logger.info("Method : getCountryList ends");

		return hrmsEmployeeDao.getCountryList();
	}

	/**
	 * 
	 * @return blood group list
	 */
	@GetMapping(value = "getBloodGroupList")
	public List<DropDownModel> getBloodGroupList() {

		logger.info("Method : getBloodGroupList starts");
		logger.info("Method : getBloodGroupList ends");

		return hrmsEmployeeDao.getBloodGroupList();
	}

	/**
	 * 
	 * @return blood group list
	 */
	@GetMapping(value = "getDocumentTypeList")
	public List<DropDownModel> getDocumentTypeList() {

		logger.info("Method : getDocumentTypeList starts");
		logger.info("Method : getDocumentTypeList ends");

		return hrmsEmployeeDao.getDocumentTypeList();
	}

	/**
	 * 
	 * @return department list
	 */
	@GetMapping(value = "getPayGradeList")
	public List<DropDownModel> getPayGradeList() {

		logger.info("Method : getPayGradeList starts");
		logger.info("Method : getPayGradeList ends");

		return hrmsEmployeeDao.getPayGradeList();
	}

	/**
	 * 
	 * @return job title list
	 */
	@GetMapping(value = "getJobTitleList")
	public List<DropDownModel> getJobTitleList() {

		logger.info("Method : getJobTitleList starts");
		logger.info("Method : getJobTitleList ends");

		return hrmsEmployeeDao.getJobTitleList();
	}

	/**
	 * 
	 * @return designation list
	 */
	@GetMapping(value = "getDesingnationList")
	public List<DropDownModel> getDesingnationList() {

		logger.info("Method : getDesingnationList starts");
		logger.info("Method : getDesingnationList ends");

		return hrmsEmployeeDao.getDesingnationList();
	}

	/**
	 * Nationality list
	 * 
	 * @return
	 */
	@GetMapping(value = "getNationalityList")
	public List<DropDownModel> getNationalityList() {

		logger.info("Method : getNationalityList starts");
		logger.info("Method : getNationalityList ends");

		return hrmsEmployeeDao.getNationalityList();
	}

	/**
	 * Nationality list
	 * 
	 * @return
	 */
	@GetMapping(value = "getSupervisorList")
	public List<DropDownModel> getSupervisor() {

		logger.info("Method : getSupervisorList starts");
		logger.info("Method : getSupervisorList ends");

		return hrmsEmployeeDao.getSupervisor();
	}

	/**
	 * 
	 * @return supervisor list by item id
	 */
	@RequestMapping(value = "getSupervisorByDept", method = { RequestMethod.GET })
	public List<DropDownModel> getSupervisorByDept(@RequestParam String id) {

		logger.info("Method : getSupervisorByDept starts");
		logger.info("Method : getSupervisorByDept ends");

		return hrmsEmployeeDao.getSupervisorByDept(id);
	}

	/**
	 * add Employee
	 * 
	 * @param employee
	 * @return
	 */
	@RequestMapping(value = "restAddemployee", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddemployee(@RequestBody HrmsEmployeeModel employee) {
		logger.info("Method : restAddemployee starts"); 
		logger.info("Method : restAddemployee ends");
		return hrmsEmployeeDao.addemployee(employee);
	}

	/**
	 * for employee list view
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getemployeeDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getemployeeDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getemployeeDetails starts");

		logger.info("Method : getemployeeDetails ends");

		return hrmsEmployeeDao.getemployeeDetails(request);
	}

	/**
	 * for Employee Edit
	 */
	@RequestMapping(value = "getemployeeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<HrmsEmployeeModel>> getemployeeById(@RequestParam String id) {
		logger.info("Method : getemployeeById starts");

		logger.info("Method : getemployeeById ends");

		return hrmsEmployeeDao.getemployeeById(id);
	}

	/*
	 * for employee Delete
	 */
	@RequestMapping(value = "deleteemployee", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteemployeeById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteemployeeById starts");

		logger.info("Method : deleteemployeeById ends");

		return hrmsEmployeeDao.deleteemployeeById(id, createdBy);
	}

	/**
	 * Rest Controller - Get Employee Details For View
	 *
	 */
	@RequestMapping(value = "getEmployeeByIdForView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getEmployeeByIdForView(@RequestParam String id) {
		logger.info("Method : getEmployeeByIdForView starts");

		logger.info("Method : getEmployeeByIdForView ends");
		return hrmsEmployeeDao.getEmployeeByIdForView(id);
	}

	/**
	 * Rest Controller - Get Employee Details For View
	 *
	 */
	@RequestMapping(value = "getEmployeeByIdForModalView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeModel>>> getEmployeeByIdForModalView(@RequestParam String id) {
		logger.info("Method : getEmployeeByIdForModalView starts");

		logger.info("Method : getEmployeeByIdForModalView ends");
		return hrmsEmployeeDao.getEmployeeByIdForModalView(id);
	}

	/*
	 * for drop down of job type
	 */
	@RequestMapping(value = "/getJobTypeOnChange", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTypeOnChange(@RequestParam String deptId) {
		logger.info("Method in rest: getJobTypeOnChange starts");

		logger.info("Method in rest: getJobTypeOnChange ends");
		return hrmsEmployeeDao.getJobTypeOnChange(deptId);
	}

	/*
	 * for drop down of state change
	 */
	@RequestMapping(value = "/getStateChange", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateChange(@RequestParam String countryId) {
		logger.info("Method in rest: getStateChange starts");

		logger.info("Method in rest: getStateChange ends");
		return hrmsEmployeeDao.getStateChange(countryId);
	}
	
	
	/*
	 * for drop down of state change
	 */
	@RequestMapping(value = "/get-dist-change", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistChange(@RequestParam String stateId) {
		logger.info("Method in rest: getDistChange starts");

		logger.info("Method in rest: getDistChange ends");
		return hrmsEmployeeDao.getDistChange(stateId);
	}
	

	/** 
	 * @return state list
	 */
	@RequestMapping(value = "getStateforEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getStateforEdit(@RequestParam String id) {

		logger.info("Method : getStateforEdit starts");
		logger.info("Method : getStateforEdit ends");

		return hrmsEmployeeDao.getStateforEdit(id);
	}

	
	
	/** 
	 * 
	 * @return dist list
	 */
	@RequestMapping(value = "getDistforEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getDistforEdit(@RequestParam String id) {

		logger.info("Method : getDistforEdit starts");
		logger.info("Method : getDistforEdit ends");

		return hrmsEmployeeDao.getDistforEdit(id);
	}
	/**
	 * Rest Controller - Change The Status Of Employee
	 *
	 */
	@RequestMapping(value = "changeStatusById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changeStatusById(@RequestParam("id") String id,
			@RequestParam("status") Boolean status, @RequestParam("createdBy") String createdBy) {
		logger.info("Method : changeStatusById starts");

		logger.info("Method : changeStatusById ends");
		return hrmsEmployeeDao.changeStatusById(id, status, createdBy);
	}

	/*
	 * @RequestMapping(value = "getEmployeeSalaryDetails", method = {
	 * RequestMethod.GET }) public
	 * ResponseEntity<JsonResponse<HrmsEmployeeSalaryStructureModel>>
	 * getEmployeeSalaryDetails(
	 * 
	 * @RequestParam("id") String id) {
	 * logger.info("Method : getEmployeeSalaryDetails starts");
	 * 
	 * logger.info("Method : getEmployeeSalaryDetails ends");
	 * 
	 * return hrmsEmployeeDao.getEmployeeSalaryDetails(id); }
	 */
	@RequestMapping(value = "getEmployeeSalaryDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeSalaryStructureModel>>> getEmployeeSalaryDetails(
			@RequestParam("id") String id) {
		logger.info("Method : getEmployeeSalaryDetails starts");
		
		logger.info("Method : getEmployeeSalaryDetails ends");
		
		return hrmsEmployeeDao.getEmployeeSalaryDetails(id);
	}

	@RequestMapping(value = "/changePassword", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changePassword(@RequestParam String id, @RequestParam String password) {
		logger.info("Method : changePassword starts");

		logger.info("Method : changePassword ends");
		return hrmsEmployeeDao.changePassword(id, password);
	}

	@RequestMapping(value = "/addTerminationDate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restAddTerminationDate(@RequestParam String id,
			@RequestParam String date) {
		logger.info("Method : restAddTerminationDate starts");

		logger.info("Method : restAddTerminationDate ends");
		return hrmsEmployeeDao.addTerminationDateDao(id, date);
	}

	/*
	 * for getIncomeTaxList
	 */
	@GetMapping(value = "/getIncomeTaxList")
	public List<RestIncomeTaxModel> getIncomeTaxList() {

		logger.info("Method : getIncomeTaxList starts");
		logger.info("Method : getIncomeTaxList ends");

		return hrmsEmployeeDao.getIncomeTaxList();
	}

	/*
	 * 
	 * PostMapping for add Professional Tax Details
	 * 
	 * 
	 */
	@RequestMapping(value = "updateSalaryComponents", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> updateSalaryComponents(
			@RequestBody List<HrmsEmployeeSalaryStructureModel> salaryDetails) {
		logger.info("Method : updateSalaryComponents starts");
		logger.info("Method : updateSalaryComponents ends");
		return hrmsEmployeeDao.updateSalaryComponents(salaryDetails);
	}
}
