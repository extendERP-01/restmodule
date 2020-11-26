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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.production.dao.ProductionPipeScrapDao; 
import nirmalya.aatithya.restmodule.production.model.ProductionPipeScrapModel;

@RestController
@RequestMapping("production/")
public class ProductionPipeScrapController {
	@Autowired
	ProductionPipeScrapDao productionPipeScrapDao;
	Logger logger = LoggerFactory.getLogger(RestMotherCoilController.class);
	
	/*
	 * for view all pipe production reports
	 */
	@RequestMapping(value = "getAllScrapReports", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductionPipeScrapModel>>> getAllScrapReports(
			@RequestParam String grade, @RequestParam String thickness, @RequestParam String startDate,
			@RequestParam String endDate, @RequestParam String slitWidth, @RequestParam String pipeSize) {
		logger.info("Method : getAllScrapReports starts");

		logger.info("Method : getAllScrapReports ends");

		return productionPipeScrapDao.getAllScrapReports(grade, thickness, startDate, endDate, slitWidth,
				pipeSize);
	}
	
}
