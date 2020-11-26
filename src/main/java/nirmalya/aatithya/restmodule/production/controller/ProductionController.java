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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.dao.ProductionDao;
import nirmalya.aatithya.restmodule.production.model.ItemWiseReqModel;
import nirmalya.aatithya.restmodule.production.model.ProductionGoCoolModel;
import nirmalya.aatithya.restmodule.production.model.ProductionSummaryDetailsModel;

@RestController
@RequestMapping("production/")
public class ProductionController {

	@Autowired
	ProductionDao productionDao;

	Logger logger = LoggerFactory.getLogger(ProductionController.class);

	/*
	 *
	 * PostMapping for add Mother Coil Slit details
	 *
	 *
	 */
	@PostMapping(value = "add-production")
	public ResponseEntity<JsonResponse<Object>> addProductionMixPost(
			@RequestBody List<ProductionGoCoolModel> motherCoil) {
		logger.info("Method : addProductionMixPost starts");
		logger.info("Method : addProductionMixPost ends");
		return productionDao.addProductionMixPost(motherCoil);

	}

	/*
	 * view production mix
	 */
	@PostMapping(value = "view-production-details")
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> viewProdctionMix(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewProdctionMix starts");

		logger.info("Method : viewProdctionMix ends");

		return productionDao.viewProdctionMix(request);
	}
	
	@GetMapping(value = "view-production-details-by-id")
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> viewProductionDetailsById(
			@RequestParam("mplanId") String mplanId, @RequestParam String prodId) {
		logger.info("Method : viewProductionDetailsById starts");

		logger.info("Method : viewProductionDetailsById ends");

		return productionDao.viewProductionDetailsById(mplanId, prodId);
	}
	
	/*
	 * for view all item requisition reports
	 */
	@PostMapping(value = "get-requisition-items-reports" )
	public ResponseEntity<JsonResponse<List<ItemWiseReqModel>>> getRequisitionItems(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getRequisitionItems starts");

		logger.info("Method : getRequisitionItems ends");

		return productionDao.getRequisitionItems(request);
	}
	
	/*
	 * for view all item requisition reports
	 */
	@PostMapping(value = "get-sale-order-items-reports" )
	public ResponseEntity<JsonResponse<List<ItemWiseReqModel>>> getSaleOrderItems(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSaleOrderItems starts");

		logger.info("Method : getSaleOrderItems ends");

		return productionDao.getSaleOrderItems(request);
	}
	
	
	/*
	 * for view all item requisition reports
	 */
	@PostMapping(value = "get-production-summary-reports" )
	public ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>> getProductionSummaryDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getProductionSummaryDetails starts");

		logger.info("Method : getProductionSummaryDetails ends");

		return productionDao.getProductionSummaryDetails(request);
	}
	
	
	/*
	 * Get mapping for get production item change
	 */

	@GetMapping(value = "rest-get-plannings-all") 
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPlanningsDetails(@RequestParam String storeId) {
		logger.info("Method : getPlanningsDetails starts");
		logger.info("Method : getPlanningsDetails ends");
		return productionDao.getPlanningsDetailsAll(storeId);
	}
	
	/*
	 * for view all item requisition reports
	 */
	@PostMapping(value = "get-production-raw-items-reports" )
	public ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>> getProductionRawMaterialDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getProductionRawMaterialDetails starts");

		logger.info("Method : getProductionRawMaterialDetails ends");

		return productionDao.getProductionRawMaterialDetails(request);
	}
}
