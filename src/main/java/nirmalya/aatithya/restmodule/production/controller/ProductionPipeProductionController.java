package nirmalya.aatithya.restmodule.production.controller;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.dao.ProductionPipeProductionDao;
import nirmalya.aatithya.restmodule.production.model.PipeProductionDashboardModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPipeProductionModel;

@RestController
@RequestMapping("production/")
public class ProductionPipeProductionController {
	@Autowired
	ProductionPipeProductionDao productionPipeProductionDao;
	Logger logger = LoggerFactory.getLogger(RestMotherCoilController.class);

	/*
	 * view all mother coil
	 */
	@RequestMapping(value = "viewMotherCoilForProduction", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> viewMotherCoilForProduction(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewMotherCoilForProduction starts");

		logger.info("Method : viewMotherCoilForProduction ends");

		return productionPipeProductionDao.productionDetails(request);
	}

	
	/*
	 * view all production Details
	 */
	@RequestMapping(value = "getProductionDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> getProductionDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getProductionDetails starts");

		logger.info("Method : getProductionDetails ends");

		return productionPipeProductionDao.getProductionDetails(request);
	}
	
	/*
	 * add production details
	 */
	@RequestMapping(value = "add-production-dtls", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addProductionDetails(
			@RequestBody List<ProductionPipeProductionModel> productionPipeProductionModelList) {
		logger.info("Method : addProductionDetails starts");
		logger.info("Method : addProductionDetails ends");
		return productionPipeProductionDao.addProductionDetails(productionPipeProductionModelList);
	}

	/*
	 * for view production model model
	 */
	@RequestMapping(value = "getProductionDetailsModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> getProductionDetailsModal(
			@RequestParam("mBatchId") String mBatchId, @RequestParam("mThickId") String mThickId,
			@RequestParam("slitBatchId") String slitBatchId, @RequestParam("slitWidth") String slitWidth,
			@RequestParam("pipeSize") String pipeSize) {
		logger.info("Method : getProductionDetailsModal starts");

		logger.info("Method : getProductionDetailsModal ends");

		return productionPipeProductionDao.getProductionDetailsModal(mBatchId, mThickId, slitBatchId, slitWidth,
				pipeSize);
	}

	/*
	 * for view all pipe production reports
	 */
	@RequestMapping(value = "getAllProductionReports", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> getAllProductionReports(
			@RequestParam String grade, @RequestParam String thickness, @RequestParam String startDate,
			@RequestParam String endDate, @RequestParam String slitWidth, @RequestParam String pipeSize) {
		logger.info("Method : getAllProductionReports starts");

		logger.info("Method : getAllProductionReports ends");

		return productionPipeProductionDao.getAllProductionReports(grade, thickness, startDate, endDate, slitWidth,
				pipeSize);
	}

	

	/*
	 * Get mapping for get Property Type
	 */

	@RequestMapping(value = "getSlitWidthByThicknessProduction", method = { RequestMethod.GET })

	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSlitWidthByThickness(@RequestParam String id,
			@RequestParam String thickness) {
		logger.info("Method : getSlitWidthByThickness starts");
		logger.info("Method : getSlitWidthByThickness ends");
		return productionPipeProductionDao.getSlitWidthByThickness(id, thickness);
	}
	@RequestMapping(value = "get-total-productions-dashboard", method = { RequestMethod.GET })
	public List<PipeProductionDashboardModel> viewTotalProductionDashBoard() {
		logger.info("Method : viewTotalProductionDashBoard starts");

		logger.info("Method : viewTotalProductionDashBoard ends");
		return productionPipeProductionDao.viewTotalProductionDashBoard();
	}
	
}
