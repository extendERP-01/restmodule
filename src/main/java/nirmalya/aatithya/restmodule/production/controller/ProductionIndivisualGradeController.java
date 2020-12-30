package nirmalya.aatithya.restmodule.production.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.dao.ProductionIndivisualGradeDao;
import nirmalya.aatithya.restmodule.production.model.ProductionGradeDetailsModel; 

@RestController
@RequestMapping("production/")
public class ProductionIndivisualGradeController {

	@Autowired
	ProductionIndivisualGradeDao productionIndivisualGradeDao;
	Logger logger = LoggerFactory.getLogger(ProductionIndivisualGradeController.class);
 
	/*
	 * for drop down for production grade details
	 */
	@RequestMapping(value = "/getProductionGradeDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductionGradeDetailsModel>>> getProductionGradeDetails(@RequestParam String fromDate ,@RequestParam String toDate ,@RequestParam String thickness) {
		logger.info("Method in rest: getProductionGradeDetails starts");

		logger.info("Method in rest: getProductionGradeDetails ends");
		return productionIndivisualGradeDao.getProductionGradeDetails(fromDate ,toDate ,thickness);
	}
	/**
	 * 
	 * @return Dependent list
	 */
	@RequestMapping(value = "getGrade", method = { RequestMethod.GET })
	public List<DropDownModel> getGrade() {

		logger.info("Method : getGrade starts");
		logger.info("Method : getGrade ends");

		return productionIndivisualGradeDao.getGrade();
	}
	
	/*
	 * Get mapping for get Property Type
	 */

	@RequestMapping(value="getThicknessByGrade",method={RequestMethod.GET})

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getThicknessByGrade(@RequestParam String id) {
		logger.info("Method : getThicknessByGrade starts");
		logger.info("Method : getThicknessByGrade ends");
		return productionIndivisualGradeDao.getThicknessByGrade(id);
	}
	
}
