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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmsDailyExcelAttendanceDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsDailyAttendanceExcelModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsSalaryModel;

@RestController
@RequestMapping("employee/")
public class HrmsDailyExcelAttendanceController {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeDependentRestController.class);

	@Autowired
	HrmsDailyExcelAttendanceDao hrmsDailyExcelAttendanceDao;

	/*
	 * for Add Other Service price getAssignEduDetails
	 */
	@RequestMapping(value = "saveAllExcelAttendanceData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveAllExcelAttendanceData(
			@RequestBody List<HrmsDailyAttendanceExcelModel> hrmEmployeeDependentModel) {
		logger.info("Method in rest: saveAllExcelAttendanceData starts");

		logger.info("Method in rest: saveAllExcelAttendanceData ends");

		return hrmsDailyExcelAttendanceDao.saveAllExcelAttendanceData(hrmEmployeeDependentModel);
	}

	@RequestMapping(value = "/get-daily-data", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsDailyAttendanceExcelModel>>> getDailyData(@RequestParam String date) {
		logger.info("Method : getDailyData starts");

		logger.info("Method : getDailyData ends");
		return hrmsDailyExcelAttendanceDao.getDailyData(date);
	}

	/*
	 * for Add Other Service price getAssignEduDetails
	 */
	@RequestMapping(value = "saveAllAttendanceData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveAllAttendanceData(
			@RequestBody List<HrmsDailyAttendanceExcelModel> hrmEmployeeDependentModel) {
		logger.info("Method in rest: saveAllAttendanceData starts");

		logger.info("Method in rest: saveAllAttendanceData ends");

		return hrmsDailyExcelAttendanceDao.saveAllAttendanceData(hrmEmployeeDependentModel);
	}

	@RequestMapping(value = "/get-daily-updated-data", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsDailyAttendanceExcelModel>>> getDailyUpdatedData(
			@RequestParam String date) {
		logger.info("Method : getDailyUpdatedData starts");

		logger.info("Method : getDailyUpdatedData ends");
		return hrmsDailyExcelAttendanceDao.getDailyUpdatedData(date);
	}
}
