package nirmalya.aatithya.restmodule.planning.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.planning.dao.HrmsGradeRevisionDao;
import nirmalya.aatithya.restmodule.planning.model.EmployeeSalaryIncementModel;
import nirmalya.aatithya.restmodule.planning.model.HrmsGraderevisionModel;

@RestController
@RequestMapping("planning/")
public class HrmsGradeRevisionController {

	Logger logger = LoggerFactory.getLogger(HrmsGradeRevisionController.class);

	@Autowired
	HrmsGradeRevisionDao hrmsGradeRevisionDao;

	/*
	 * for drop down of employee list
	 */
	@RequestMapping(value = "get-employee-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeList(@RequestParam String deptId,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method in rest: getEmployeeList starts");

		logger.info("Method in rest: getEmployeeList ends");
		return hrmsGradeRevisionDao.getEmployeeList(deptId ,fromDate ,toDate);
	}

	/*
	 * for drop down of employee details
	 */
	@RequestMapping(value = "get-employee-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsGraderevisionModel>>> getEmployeeDetails(@RequestParam String deptId,
			@RequestParam String empId ,@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method in rest: getEmployeeDetails starts");

		logger.info("Method in rest: getEmployeeDetails ends");
		return hrmsGradeRevisionDao.getEmployeeDetails(deptId, empId,fromDate ,toDate);
	}

	/**
	 * Save grave salary revision
	 * 
	 * @param List Data
	 * @return
	 */
	@RequestMapping(value = "saveGradeRevisionData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveGradeRevisionData(
			@RequestBody List<HrmsGraderevisionModel> HrmsGraderevisionList) {
		logger.info("Method : saveGradeRevisionData starts");
		logger.info("Method : saveGradeRevisionData ends");
		return hrmsGradeRevisionDao.saveGradeRevisionData(HrmsGraderevisionList);
	}
	
	/**
	 * Save grave salary revision
	 * 
	 * @param List Data
	 * @return
	 */
	@RequestMapping(value = "saveIncrementData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveIncrementData(
			@RequestBody List<EmployeeSalaryIncementModel> incrementList) {
		logger.info("Method : saveGradeRevisionData starts");
		logger.info("Method : saveGradeRevisionData ends");
		return hrmsGradeRevisionDao.saveIncrementData(incrementList);
	}
}
