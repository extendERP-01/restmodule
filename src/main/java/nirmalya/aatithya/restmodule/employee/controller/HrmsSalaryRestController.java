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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeSalaryDao;
import nirmalya.aatithya.restmodule.employee.model.EmployeeFoodTrackingRestModel;
import nirmalya.aatithya.restmodule.employee.model.EmployeeIncomeTaxDetails;
import nirmalya.aatithya.restmodule.employee.model.HrmsAdvancePaymentModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsAttendanceApprovalModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeBonousModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEpfExcelModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEsicExcelModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsExtraSalaryModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsLeaveApprovalRestModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsSalaryApproveCountModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsSalaryModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("employee")
public class HrmsSalaryRestController {

	Logger logger = LoggerFactory.getLogger(HrmsSalaryRestController.class);

	@Autowired
	HrmsEmployeeSalaryDao hrmsEmployeeSalaryDao;

	@RequestMapping(value = "/getSalaryDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsSalaryModel>>> getEmployeeSalaryList(@RequestParam String fromDate,
			@RequestParam String toDate, String status) {
		logger.info("Method : getEmployeeSalaryList starts");

		logger.info("Method : getEmployeeSalaryList ends");
		return hrmsEmployeeSalaryDao.getEmployeeSalaryList(fromDate, toDate, status);
	}

	@RequestMapping(value = "/search-by-emp", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsSalaryModel>>> searchByEmp(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String employeeName) {
		logger.info("Method : searchByEmp starts");

		logger.info("Method : searchByEmp ends");
		return hrmsEmployeeSalaryDao.searchByEmp(fromDate, toDate, employeeName);
	}

	@RequestMapping(value = "saveSalaryData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveSalaryData(@RequestBody List<HrmsSalaryModel> testData) {
		logger.info("Method : saveSalaryData for rest controller starts");

		logger.info("Method : saveSalaryData for rest controller ends");
		return hrmsEmployeeSalaryDao.saveSalaryData(testData);
	}

	@RequestMapping(value = "/getTripData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> getTripData(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String status) {
		logger.info("Method : getTripData starts");

		logger.info("Method : getTripData ends");
		return hrmsEmployeeSalaryDao.getTripData(fromDate, toDate, status);
	}

	@RequestMapping(value = "/getFoodData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>> getFoodData(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String empId, @RequestParam String status) {
		logger.info("Method : getFoodData starts");

		logger.info("Method : getFoodData ends");
		return hrmsEmployeeSalaryDao.getFoodData(fromDate, toDate, empId, status);
	}

	@RequestMapping(value = "/getExtraSalary", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsExtraSalaryModel>>> getExtraSalary(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String empId, @RequestParam String status) {
		logger.info("Method : getExtraSalary starts");

		logger.info("Method : getExtraSalary ends");
		return hrmsEmployeeSalaryDao.getExtraSalary(fromDate, toDate, empId, status);
	}

	@RequestMapping(value = "/getAttendanceDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsAttendanceApprovalModel>>> getAttendanceDetails(
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String empId,
			@RequestParam String status) {
		logger.info("Method : getFoodData starts");

		logger.info("Method : getFoodData ends");
		return hrmsEmployeeSalaryDao.getAttendanceDetails(fromDate, toDate, empId, status);
	}

	@RequestMapping(value = "/getAdvanceDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>> getAdvanceDetails(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam String empId, @RequestParam String status) {
		logger.info("Method : getAdvanceDetails starts");

		logger.info("Method : getAdvanceDetails ends");
		return hrmsEmployeeSalaryDao.getAdvanceDetails(fromDate, toDate, empId, status);
	}

	@RequestMapping(value = "/getIncomeTaxDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>> getIncomeTaxDetails(
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String empId,
			@RequestParam String status) {
		logger.info("Method : getIncomeTaxDetails starts");

		logger.info("Method : getIncomeTaxDetails ends");
		return hrmsEmployeeSalaryDao.getIncomeTaxDetails(fromDate, toDate, empId, status);
	}

	/*
	 * save advance data
	 */

	@RequestMapping(value = "saveAdvanceData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveAdvanceData(
			@RequestBody List<HrmsAdvancePaymentModel> hrmsAdvancePaymentModelList) {
		logger.info("Method : saveAdvanceData for rest controller starts");

		logger.info("Method : saveAdvanceData for rest controller ends");
		return hrmsEmployeeSalaryDao.saveAdvanceData(hrmsAdvancePaymentModelList);
	}
	/*
	 * save income tax data data
	 */

	@RequestMapping(value = "saveIncomeTaxApproveData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveIncomeTaxData(
			@RequestBody List<EmployeeIncomeTaxDetails> hrmsAdvancePaymentModelList) {
		logger.info("Method : saveIncomeTaxData for rest controller starts");

		logger.info("Method : saveIncomeTaxData for rest controller ends");
		return hrmsEmployeeSalaryDao.saveIncomeTaxData(hrmsAdvancePaymentModelList);
	}

	/*
	 * save trip data
	 */
	@RequestMapping(value = "saveTripData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveTripData(
			@RequestBody List<HrmsEmployeeBonousModel> hrmsEmployeeBonousModelList) {
		logger.info("Method : saveTripData for rest controller starts");

		logger.info("Method : saveTripData for rest controller ends");
		return hrmsEmployeeSalaryDao.saveTripData(hrmsEmployeeBonousModelList);
	}

	/*
	 * save food data
	 */
	@RequestMapping(value = "saveFoodData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveFoodData(
			@RequestBody List<EmployeeFoodTrackingRestModel> hrmsEmployeeBonousModelList) {
		logger.info("Method : saveFoodData for rest controller starts");

		logger.info("Method : saveFoodData for rest controller ends");
		return hrmsEmployeeSalaryDao.saveFoodData(hrmsEmployeeBonousModelList);
	}

	/*
	 * save extra salary data
	 */
	@RequestMapping(value = "saveExtraSalaryData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveExtraSalaryData(
			@RequestBody List<HrmsExtraSalaryModel> hrmsEmployeeBonousModelList) {
		logger.info("Method : saveFoodData for rest controller starts");

		logger.info("Method : saveFoodData for rest controller ends");
		return hrmsEmployeeSalaryDao.saveExtraSalaryData(hrmsEmployeeBonousModelList);
	}

	/*
	 * save attendance data
	 */
	@RequestMapping(value = "saveAttendanceData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveAttendanceData(
			@RequestBody List<HrmsAttendanceApprovalModel> hrmsAttendanceApprovalModelList) {
		logger.info("Method : saveAttendanceData for rest controller starts");

		logger.info("Method : saveAttendanceData for rest controller ends");
		return hrmsEmployeeSalaryDao.saveAttendanceData(hrmsAttendanceApprovalModelList);
	}
	/*
	 * save leave data
	 */
	@RequestMapping(value = "saveLeaveData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveLeaveData(
			@RequestBody List<HrmsLeaveApprovalRestModel> hrmsLeaveApprovalModelList) {
		logger.info("Method : saveAttendanceData for rest controller starts");
		
		logger.info("Method : saveAttendanceData for rest controller ends");
		return hrmsEmployeeSalaryDao.saveLeaveData(hrmsLeaveApprovalModelList);
	}

	@RequestMapping(value = "/getCountDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsSalaryApproveCountModel>>> getCountDetails(
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : getCountDetails starts");

		logger.info("Method : getCountDetails ends");
		return hrmsEmployeeSalaryDao.getCountDetails(fromDate, toDate);
	}

	/*
	 * excel for advance payment
	 */
	@RequestMapping(value = "/getAdvancePaymentDetailsExcel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>> getConsumptionReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAdvancePaymentDetailsExcel starts");
		logger.info("Method : getAdvancePaymentDetailsExcel ends");
		return hrmsEmployeeSalaryDao.getAdvancePaymentDetailsExcel(request);
	}

	/*
	 * excel for trip details
	 */
	@RequestMapping(value = "getTripExcelReports", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeBonousModel>>> getTripExcelReports(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getTripExcelReports starts");
		logger.info("Method : getTripExcelReports ends");
		return hrmsEmployeeSalaryDao.getTripExcelReports(request);
	}

	/*
	 * generate attendance details
	 */
	@RequestMapping(value = "generateAttendanceExcel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsAttendanceApprovalModel>>> generateAttendanceExcel(
			@RequestBody DataTableRequest request) {
		logger.info("Method : generateAttendanceExcel starts");
		logger.info("Method : generateAttendanceExcel ends");
		return hrmsEmployeeSalaryDao.generateAttendanceExcel(request);
	}
	/*
	 * generate attendance details
	 */
	@RequestMapping(value = "generateLeaveExcel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsLeaveApprovalRestModel>>> generateLeaveExcel(
			@RequestBody DataTableRequest request) {
		logger.info("Method : generateLeaveExcel starts");
		logger.info("Method : generateLeaveExcel ends");
		return hrmsEmployeeSalaryDao.generateLeaveExcel(request);
	}

	/*
	 * excel for food details
	 */
	@RequestMapping(value = "getFoodDetailsExcel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>> getFoodDetailsExcel(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getFoodDetailsExcel starts");
		logger.info("Method : getFoodDetailsExcel ends");
		return hrmsEmployeeSalaryDao.getFoodDetailsExcel(request);
	}

	/*
	 * excel for food details
	 */
	@RequestMapping(value = "getExtraSalDetailsExcel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsExtraSalaryModel>>> getExtraSalDetailsExcel(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getExtraSalDetailsExcel starts");
		logger.info("Method : getExtraSalDetailsExcel ends");
		return hrmsEmployeeSalaryDao.getExtraSalDetailsExcel(request);
	}

	/*
	 * excel for income tax details
	 */
	@RequestMapping(value = "getIncomeTaxDetailsExcel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>> getIncomeTaxDetailsExcel(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getIncomeTaxDetailsExcel starts");
		logger.info("Method : getIncomeTaxDetailsExcel ends");
		return hrmsEmployeeSalaryDao.getIncomeTaxDetailsExcel(request);
	}

	/*
	 * excel for epf details
	 */
	@RequestMapping(value = "generateEpfExcelReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEpfExcelModel>>> generateEpfExcelReport(
			@RequestBody DataTableRequest request) {
		logger.info("Method : generateEpfExcelReport starts");
		logger.info("Method : generateEpfExcelReport ends");
		return hrmsEmployeeSalaryDao.generateEpfExcelReport(request);
	}

	/*
	 * excel for esic details
	 */
	@RequestMapping(value = "generateEsicExcelReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEsicExcelModel>>> generateEsicExcelReport(
			@RequestBody DataTableRequest request) {
		logger.info("Method : generateEsicExcelReport starts");
		logger.info("Method : generateEsicExcelReport ends");
		return hrmsEmployeeSalaryDao.generateEsicExcelReport(request);
	}

	@RequestMapping(value = "getFinalSalaryExcel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsSalaryModel>>> getFinalSalaryExcel(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getFinalSalaryExcel starts");
		logger.info("Method : getFinalSalaryExcel ends");
		return hrmsEmployeeSalaryDao.getFinalSalaryExcel(request);
	}
	
	@RequestMapping(value = "/getLeaveDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsLeaveApprovalRestModel>>> getLeaveDetails(
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String empId,
			@RequestParam String status) {
		logger.info("Method : getFoodData starts");

		logger.info("Method : getFoodData ends");
		return hrmsEmployeeSalaryDao.getLeaveDetails(fromDate, toDate, empId, status);
	}

}
