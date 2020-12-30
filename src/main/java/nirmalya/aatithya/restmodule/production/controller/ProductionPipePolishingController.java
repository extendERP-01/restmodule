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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.dao.ProductionPipePolishingDao;
import nirmalya.aatithya.restmodule.production.model.ProductionPipeNonpolishModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPipePolishingModel;
import nirmalya.aatithya.restmodule.production.model.RestMotherCoilModel;

@RestController
@RequestMapping("production/")
public class ProductionPipePolishingController {
	@Autowired
	ProductionPipePolishingDao productionPipePolishingDao;
	Logger logger = LoggerFactory.getLogger(ProductionPipePolishingController.class);

	/*
	 * add polishing details
	 */
	@RequestMapping(value = "addPolishingDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addProductionDetails(
			@RequestBody List<ProductionPipePolishingModel> productionPipePolishingModelList) {
		logger.info("Method : addPolishingDetails starts");
		logger.info("Method : addPolishingDetails ends");
		return productionPipePolishingDao.addPolishingDetails(productionPipePolishingModelList);
	}

	/*
	 * edit polishing Details
	 */
	@RequestMapping(value = "/edit-polishing-ById", method = { RequestMethod.GET })
	public List<ProductionPipePolishingModel> editpolishing(@RequestParam("mBatchId") String mBatchId,
			@RequestParam("mThickId") String mThickId, @RequestParam("slitBatchId") String slitBatchId) {
		logger.info("Method : editpolishing for rest controller starts");

		logger.info("Method : editpolishing for rest controller ends");
		return productionPipePolishingDao.editpolishing(mBatchId, mThickId, slitBatchId);
	}

	/*
	 * view all mother coil
	 */
	@RequestMapping(value = "viewPolishingDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestMotherCoilModel>>> viewPolishingDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewPolishingDetails starts");

		logger.info("Method : viewPolishingDetails ends");

		return productionPipePolishingDao.viewPolishingDetails(request);
	}

	/*
	 * for view polishing model model
	 */
	@RequestMapping(value = "getPolishingDetailsModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>> getPolishingDetailsModal(
			@RequestParam("mBatchId") String mBatchId, @RequestParam("mThickId") String mThickId,
			@RequestParam("slitBatchId") String slitBatchId, @RequestParam("slitWidth") String slitWidth,
			@RequestParam("pipeSize") String pipeSize) {
		logger.info("Method : getPolishingDetailsModal starts");

		logger.info("Method : getProductionDetailsModal ends");

		return productionPipePolishingDao.getPolishingDetailsModal(mBatchId, mThickId, slitBatchId, slitWidth,
				pipeSize);
	}

	/*
	 * for view all pipe production reports
	 */
	@RequestMapping(value = "getAllpolishingReports", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>> getAllpolishingReports(
			@RequestParam String grade, @RequestParam String thickness, @RequestParam String startDate,
			@RequestParam String endDate, @RequestParam String slitWidth, @RequestParam String pipeSize) {
		logger.info("Method : getAllpolishingReports starts");

		logger.info("Method : getAllpolishingReports ends");

		return productionPipePolishingDao.getAllpolishingReports(grade, thickness, startDate, endDate, slitWidth,
				pipeSize);
	}

	@RequestMapping(value = "getNonPolishReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ProductionPipeNonpolishModel>>> getNonPolishReport(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getNonPolishReport starts");

		logger.info("Method : getNonPolishReport ends");

		return productionPipePolishingDao.getNonPolishReport(request);
	}

	@RequestMapping(value = "getNonPolishReportPDF", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ProductionPipeNonpolishModel>>> getNonPolishReportPDF(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getNonPolishReportPDF starts");

		logger.info("Method : getNonPolishReportPDF ends");

		return productionPipePolishingDao.getNonPolishReportPDF(request);
	}
	
	/*
	 * view all mother coil
	 */
	@RequestMapping(value = "getPolishingDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ProductionPipePolishingModel>>> getPolishingDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPolishingDetails starts");

		logger.info("Method : getPolishingDetails ends");

		return productionPipePolishingDao.getPolishingDetails(request);
	}
	
}
