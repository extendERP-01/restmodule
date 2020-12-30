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
import nirmalya.aatithya.restmodule.employee.dao.FoodTrackingDao;
import nirmalya.aatithya.restmodule.employee.model.EmployeeFoodTrackingRestModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("employee")
public class FoodTrackingRestController {

	Logger logger = LoggerFactory.getLogger(FoodTrackingRestController.class);
	
	@Autowired
	FoodTrackingDao foodTrackingDao;
	
	@RequestMapping(value = "/getEmployeeDetailsForFoodTracking", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<EmployeeFoodTrackingRestModel>>> getEmployeeDetailsForFoodTracking(@RequestParam String id) {
		logger.info("Method : getEmployeeDetailsForFoodTracking starts");
		
		logger.info("Method : getEmployeeDetailsForFoodTracking ends");
		return foodTrackingDao.getEmployeeDetailsForFoodTracking(id);
	}
	
	@RequestMapping(value="saveFoodTrackIngData" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> saveFoodTrackIngData(@RequestBody List<EmployeeFoodTrackingRestModel> testData) {
		logger.info("Method : saveFoodTrackIngData for rest controller starts");
		
		logger.info("Method : saveFoodTrackIngData for rest controller ends");
		return foodTrackingDao.saveFoodTrackIngData(testData);
	}
}
