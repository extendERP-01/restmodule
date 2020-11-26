package nirmalya.aatithya.restmodule.production.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.dao.ProductionPackDao;
import nirmalya.aatithya.restmodule.production.model.ProductionGocoolPacakgeingModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPipePackagingModel;

@RestController
@RequestMapping("production/")
public class ProductionPackCocoolRestController {

	@Autowired
	ProductionPackDao productionPackDao;
	Logger logger = LoggerFactory.getLogger(ProductionPackCocoolRestController.class);

	/*
	 * view all view Mother Coil For Packaging
	 */
	@RequestMapping(value = "view-production-packaging", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ProductionGocoolPacakgeingModel>>> viewProdctions(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewProdctions starts");

		logger.info("Method : viewProdctions ends");

		return productionPackDao.viewProdctions(request);
	}

	/*
	 * add packaging details
	 */
	@PostMapping(value = "addpackagingDetail" )
	public ResponseEntity<JsonResponse<Object>> addProductionDetails(
			@RequestBody List<ProductionGocoolPacakgeingModel> packaging) {
		logger.info("Method : addpackagingDetails starts");
		logger.info("Method : addpackagingDetails ends");
		return productionPackDao.addpackagingDetails(packaging);
	}

	/*
	 * edit packaging details
	 */
	@GetMapping(value = "/edit-packagings-ById" )
	public List<ProductionGocoolPacakgeingModel> editpackaging(@RequestParam("prodId") String prodId) {
		logger.info("Method : editpackaging for rest controller starts");

		logger.info("Method : editpackaging for rest controller ends");
		return productionPackDao.editpackaging(prodId);
	}

	/*
	 * for view  modal view packaging
	 */
	@GetMapping(value = "viewPackagingById" )
	public ResponseEntity<JsonResponse<List<ProductionGocoolPacakgeingModel>>> getPackagingDetailsModal(
			@RequestParam("prodId") String prodId) {
		logger.info("Method : getPackagingDetailsModal starts");

		logger.info("Method : getPackagingDetailsModal ends");

		return productionPackDao.getPackagingDetailsModal(prodId);
	}

	/*
	 * for save Draft data
	 */
	@RequestMapping(value = "draftPackagingDetail", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> draftPackagingDetails(
			@RequestBody List<ProductionPipePackagingModel> draftObj) {
		logger.info("Method : draftPackagingDetails starts");
		logger.info("Method : draftPackagingDetails ends");
		return productionPackDao.draftPackagingDetails(draftObj);
	}

	/*
	 * get draft details
	 */
	@RequestMapping(value = "/get-packaging-draft-detail", method = { RequestMethod.GET })
	public List<ProductionPipePackagingModel> getPackaingDetails(@RequestParam("mBatchId") String mBatchId,
			@RequestParam("mThickId") String mThickId, @RequestParam("slitBatchId") String slitBatchId,
			@RequestParam("slitWidth") String slitWidth, @RequestParam("pipeSize") String pipeSize,
			@RequestParam("subBatch") String subBatch) {
		logger.info("Method : getPackaingDetails for rest controller starts");

		logger.info("Method : getPackaingDetails for rest controller ends");
		return productionPackDao.getPackaingDetails(mBatchId, mThickId, slitBatchId, slitWidth, pipeSize, subBatch);
	}

	/*
	 * for view all pipe production reports
	 */
	@RequestMapping(value = "getAllpackagingReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> getAllpackagingReports(
			@RequestParam String grade, @RequestParam String thickness, @RequestParam String startDate,
			@RequestParam String endDate, @RequestParam String slitWidth, @RequestParam String pipeSize) {
		logger.info("Method : getAllpackagingReports starts");

		logger.info("Method : getAllpackagingReports ends");

		return productionPackDao.getAllpackagingReports(grade, thickness, startDate, endDate, slitWidth, pipeSize);
	}

	/*
	 * view all packaging details
	 */
	@RequestMapping(value = "getPackagingDetail", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ProductionPipePackagingModel>>> getPackagingDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPackagingDetails starts");

		logger.info("Method : getPackagingDetails ends");

		return productionPackDao.getPackagingDetails(request);
	}

}
