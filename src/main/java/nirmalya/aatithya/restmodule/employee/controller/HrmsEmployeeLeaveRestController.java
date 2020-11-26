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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeLeaveDetailsDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeLeaveModel;

/**
 * 
 * @author Nirmalya
 *
 */
@RestController
@RequestMapping("employee/")
public class HrmsEmployeeLeaveRestController {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeLeaveRestController.class);

	@Autowired
	HrmsEmployeeLeaveDetailsDao hrmsEmployeeLeaveDetailsDao;

	/*
	 * for All employee leave
	 */
	@RequestMapping(value = "getAllLeaveDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeLeaveModel>>> getAllLeaveDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllLeaveDetails starts");

		logger.info("Method : getAllLeaveDetails ends");

		return hrmsEmployeeLeaveDetailsDao.getLeaveDetails(request);
	}

	/*
	 * for Add leave details
	 */
	@RequestMapping(value = "restAddLeaveDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddLeaveDetails(@RequestBody HrmsEmployeeLeaveModel leaveDetails) {
		logger.info("Method : restAddLeaveDetails starts");

		logger.info("Method : restAddLeaveDetails ends");

		return hrmsEmployeeLeaveDetailsDao.addLeaveDetails(leaveDetails);
	}

	/*
	 * for Edit leave details
	 */
	@RequestMapping(value = "getLeaveDetailsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<HrmsEmployeeLeaveModel>> getLeaveDetailsById(@RequestParam String empId,
			@RequestParam String action) {
		logger.info("Method : getLeaveDetailsById starts");

		logger.info("Method : getLeaveDetailsById ends");

		return hrmsEmployeeLeaveDetailsDao.getLeaveDetailsById(empId, action);
	}
}
