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
import nirmalya.aatithya.restmodule.production.dao.ProductionPipePackagingDao;
import nirmalya.aatithya.restmodule.production.model.ProductionPipePackagingModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPipeProductionModel;

@RestController
@RequestMapping("production/")
public class ProductionPipePackagingController {
	@Autowired
	ProductionPipePackagingDao productionPipepackagingDao;
	Logger logger = LoggerFactory.getLogger(RestMotherCoilController.class);

	/*
	 * view all view Mother Coil For Packaging
	 */
	@RequestMapping(value = "viewMotherCoilForPackaging", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ProductionPipeProductionModel>>> viewMotherCoilForPackaging(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewMotherCoilForPackaging starts");

		logger.info("Method : viewMotherCoilForPackaging ends");

		return productionPipepackagingDao.viewMotherCoilForPackaging(request);
	}

	/*
	 * add packaging details
	 */
	@RequestMapping(value = "addpackagingDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addProductionDetails(
			@RequestBody List<ProductionPipePackagingModel> packaging) {
		logger.info("Method : addpackagingDetails starts");
		logger.info("Method : addpackagingDetails ends");
		return productionPipepackagingDao.addpackagingDetails(packaging);
	}

	/*
	 * edit packaging details
	 */
	@RequestMapping(value = "/edit-packaging-ById", method = { RequestMethod.GET })
	public List<ProductionPipePackagingModel> editpackaging(@RequestParam("mBatchId") String mBatchId,
			@RequestParam("mThickId") String mThickId, @RequestParam("slitBatchId") String slitBatchId) {
		logger.info("Method : editpackaging for rest controller starts");

		logger.info("Method : editpackaging for rest controller ends");
		return productionPipepackagingDao.editpackaging(mBatchId, mThickId, slitBatchId);
	}

	/*
	 * for view packaging edit
	 */
	@RequestMapping(value = "getPackagingDetailsModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> getPackagingDetailsModal(
			@RequestParam("mBatchId") String mBatchId, @RequestParam("mThickId") String mThickId,
			@RequestParam("slitBatchId") String slitBatchId, @RequestParam("slitWidth") String slitWidth,
			@RequestParam("pipeSize") String pipeSize) {
		logger.info("Method : getPackagingDetailsModal starts");

		logger.info("Method : getPackagingDetailsModal ends");

		return productionPipepackagingDao.getPackagingDetailsModal(mBatchId, mThickId, slitBatchId, slitWidth,
				pipeSize);
	}

	/*
	 * for save Draft data
	 */
	@RequestMapping(value = "draftPackagingDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> draftPackagingDetails(
			@RequestBody List<ProductionPipePackagingModel> draftObj) {
		logger.info("Method : draftPackagingDetails starts");
		logger.info("Method : draftPackagingDetails ends");
		return productionPipepackagingDao.draftPackagingDetails(draftObj);
	}

	/*
	 * get draft details
	 */
	@RequestMapping(value = "/get-packaging-draft-details", method = { RequestMethod.GET })
	public List<ProductionPipePackagingModel> getPackaingDetails(@RequestParam("mBatchId") String mBatchId,
			@RequestParam("mThickId") String mThickId, @RequestParam("slitBatchId") String slitBatchId,
			@RequestParam("slitWidth") String slitWidth, @RequestParam("pipeSize") String pipeSize ,@RequestParam("subBatch") String subBatch) {
		logger.info("Method : getPackaingDetails for rest controller starts");

		logger.info("Method : getPackaingDetails for rest controller ends");
		return productionPipepackagingDao.getPackaingDetails(mBatchId, mThickId, slitBatchId, slitWidth, pipeSize ,subBatch);
	}

	/*
	 * for view all pipe production reports
	 */
	@RequestMapping(value = "getAllpackagingReports", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> getAllpackagingReports(
			@RequestParam String grade, @RequestParam String thickness, @RequestParam String startDate,
			@RequestParam String endDate, @RequestParam String slitWidth, @RequestParam String pipeSize) {
		logger.info("Method : getAllpackagingReports starts");

		logger.info("Method : getAllpackagingReports ends");

		return productionPipepackagingDao.getAllpackagingReports(grade, thickness, startDate, endDate, slitWidth,
				pipeSize);
	}

	/*
	 * view all packaging details
	 */
	@RequestMapping(value = "getPackagingDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> getPackagingDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPackagingDetails starts");

		logger.info("Method : getPackagingDetails ends");

		return productionPipepackagingDao.getPackagingDetails(request);
	}
}
