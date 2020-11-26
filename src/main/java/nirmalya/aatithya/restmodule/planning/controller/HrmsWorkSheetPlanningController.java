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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.RestGradeSalaryMasterModel;
import nirmalya.aatithya.restmodule.planning.dao.HrmsWorkSheetPlanningDao; 
import nirmalya.aatithya.restmodule.planning.model.HrmsWorksheetPlanningModel;

@RestController
@RequestMapping("planning/")
public class HrmsWorkSheetPlanningController {

	Logger logger = LoggerFactory.getLogger(HrmsWorkSheetPlanningController.class);

	@Autowired
	HrmsWorkSheetPlanningDao hrmsWorkSheetPlanningDao;

	/*
	 * for drop down of employee details
	 */
	@RequestMapping(value = "get-apprisal-employee-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>> getEmployeeDetails(
			@RequestParam String deptId) {
		logger.info("Method in rest: getEmployeeDetails starts");

		logger.info("Method in rest: getEmployeeDetails ends");
		return hrmsWorkSheetPlanningDao.getEmployeeDetails(deptId);
	}
	/**
	 * Save grave salary revision
	 * 
	 * @param List Data
	 * @return
	 */
	@RequestMapping(value = "saveWorkSheetData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveWorkSheetData(
			@RequestBody List<HrmsWorksheetPlanningModel> hrmsWorksheetPlanningModelList) {
		logger.info("Method : saveWorkSheetData starts");
		logger.info("Method : saveWorkSheetData ends");
		return hrmsWorkSheetPlanningDao.saveWorkSheetData(hrmsWorksheetPlanningModelList);
	}
	
	
	/*
	 * for All Grade Salary Master details
	 */
	@RequestMapping(value = "get-work-sheet-planning-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>> getWorkPlanningDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getWorkPlanningDetails starts");

		logger.info("Method : getWorkPlanningDetails ends");

		return hrmsWorkSheetPlanningDao.getWorkPlanningDetails(request);
	}
	
	
	/*
	 * Get Grade Salary Master details to View in Modal
	 *
	 */

	@RequestMapping(value = "get-work-plan-details-by-id", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsWorksheetPlanningModel>>> modalGradeSalaryMaster(
			@RequestParam String id) {
		logger.info("Method : modalGradeSalaryMaster starts");

		logger.info("Method : modalGradeSalaryMaster ends");

		return hrmsWorkSheetPlanningDao.modalGradeSalaryMaster(id);
	}

}
