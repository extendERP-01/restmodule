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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeAdvanceDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsAdvancePaymentModel;

/**
 * 
 * @author Nirmalya
 *
 */
@RestController
@RequestMapping("employee/")
public class HrmsEmployeeAdvanceController {
	Logger logger = LoggerFactory.getLogger(HrmsEmployeeAdvanceController.class);

	@Autowired
	HrmsEmployeeAdvanceDao hrmsEmployeeAdvanceDao;

	/*
	 * for All emergency
	 */
	@RequestMapping(value = "getAdvanceDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsAdvancePaymentModel>>> getAdvanceDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAdvanceDetails starts");

		logger.info("Method : getAdvanceDetails ends");

		return hrmsEmployeeAdvanceDao.getadvanceDetails(request);
	}

	/*
	 * for All Add emergency
	 */
	@RequestMapping(value = "restAddEmpAvance", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddEmpAvance(@RequestBody HrmsAdvancePaymentModel emergency) {
		logger.info("Method : restAddEmpAvance starts");

		logger.info("Method : restAddEmpAvance ends");

		return hrmsEmployeeAdvanceDao.addadvance(emergency);
	}

	/*
	 * for emergency Edit
	 */
	@RequestMapping(value = "getEmpAdvById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<HrmsAdvancePaymentModel>> getadvanceById(@RequestParam String empId ,@RequestParam String action) {
		logger.info("Method : getadvanceById starts");

		logger.info("Method : getadvanceById ends");

		return hrmsEmployeeAdvanceDao.getadvanceById(empId ,action);
	}

}
