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
import nirmalya.aatithya.restmodule.employee.dao.HrmsIncomeTaxDetailsDao;
import nirmalya.aatithya.restmodule.employee.model.EmployeeIncomeTaxDetails;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("employee")
public class HrmsIncomeTaxDetailsController {

	Logger logger = LoggerFactory.getLogger(FoodTrackingRestController.class);

	@Autowired
	HrmsIncomeTaxDetailsDao hrmsIncomeTaxDetailsDao;

	@RequestMapping(value = "/getEmployeeDetailsForIncomeTax", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<EmployeeIncomeTaxDetails>>> getEmployeeDetailsForIncomeTax(
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : getEmployeeDetailsForFoodTracking starts");

		logger.info("Method : getEmployeeDetailsForIncomeTax ends");
		return hrmsIncomeTaxDetailsDao.getEmployeeDetailsForIncomeTax(fromDate, toDate);
	}

	@RequestMapping(value = "saveIncomeTaxData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveIncomeTaxData(
			@RequestBody List<EmployeeIncomeTaxDetails> testData) {
		logger.info("Method : saveIncomeTaxData for rest controller starts");

		logger.info("Method : saveIncomeTaxData for rest controller ends");
		return hrmsIncomeTaxDetailsDao.saveIncomeTaxData(testData);
	}

}
