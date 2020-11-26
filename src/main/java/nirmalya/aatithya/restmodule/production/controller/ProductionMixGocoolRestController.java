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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.dao.ProductionMixGocoolDao;
import nirmalya.aatithya.restmodule.production.model.ProductionGoCoolModel;
import nirmalya.aatithya.restmodule.production.model.RestMotherCoilModel;

@RestController
@RequestMapping("production/")
public class ProductionMixGocoolRestController {
	@Autowired
	ProductionMixGocoolDao productionGocoolDao;

	Logger logger = LoggerFactory.getLogger(ProductionMixGocoolRestController.class);

	/**
	 * GET production planning list
	 *
	 */

	@GetMapping(value = "getProdPlanning")
	public List<DropDownModel> getProdPlanning() {
		logger.info("Method : RESTMODULE ProductionGocoolRestController getProdPlanning starts");
		logger.info("Method : RESTMODULE ProductionGocoolRestController getProdPlanning ends");
		return productionGocoolDao.getProdPlanning();
	}

	/**
	 * GET production planning list
	 *
	 */

	@GetMapping(value = "getPlant")
	public List<DropDownModel> getPlant(String userId) {
		logger.info("Method : RESTMODULE ProductionGocoolRestController getPlant starts");
		logger.info("Method : RESTMODULE ProductionGocoolRestController getPlant ends");
		return productionGocoolDao.getPlant(userId);
	}

	/*
	 * Get mapping for get production item change
	 */

	@GetMapping(value = "rest-get-production-items")

	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> getProductionItem(@RequestParam String planId) {
		logger.info("Method : getProductionItem starts");
		logger.info("Method : getProductionItem ends");
		return productionGocoolDao.getProductionItem(planId);
	}

	/*
	 * Get mapping for get batch details on production item change
	 */

	@GetMapping(value = "rest-get-batch-details")

	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> getBatchDetails(@RequestParam String planId,  @RequestParam String storeId) {
		logger.info("Method : getBatchDetails starts");
		logger.info("Method : getBatchDetails ends");
		return productionGocoolDao.getBatchDetails(planId, storeId);
	}

	/*
	 *
	 * PostMapping for add Mother Coil Slit details
	 *
	 *
	 */
	@PostMapping(value = "add-production-mix")
	public ResponseEntity<JsonResponse<Object>> addProductionMixPost(
			@RequestBody List<ProductionGoCoolModel> motherCoil) {
		logger.info("Method : addProductionMixPost starts");
		logger.info("Method : addProductionMixPost ends");
		return productionGocoolDao.addProductionMixPost(motherCoil);

	}

	/*
	 * view production mix
	 */
	@PostMapping(value = "view-production-mix")
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> viewProdctionMix(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewProdctionMix starts");

		logger.info("Method : viewProdctionMix ends");

		return productionGocoolDao.viewProdctionMix(request);
	}

	@GetMapping(value = "getProdItemList")
	public List<DropDownModel> getProdItemList() {
		logger.info("Method : RESTMODULE ProductionGocoolRestController getProdItemList starts");
		logger.info("Method : RESTMODULE ProductionGocoolRestController getProdItemList ends");
		return productionGocoolDao.getProdItemList();
	}

	@GetMapping(value = "viewProductionMixId")
	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> viewProductionMixId(
			@RequestParam("mplanId") String mplanId, @RequestParam("mBatchId") String mBatchId) {
		logger.info("Method : viewProductionMixId starts");

		logger.info("Method : viewProductionMixId ends");

		return productionGocoolDao.viewProductionMixId(mplanId, mBatchId);
	}
	
	/*
	 * Get mapping for get production item change
	 */

	@GetMapping(value = "rest-get-plannings") 
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPlanningsDetails(@RequestParam String storeId) {
		logger.info("Method : getPlanningsDetails starts");
		logger.info("Method : getPlanningsDetails ends");
		return productionGocoolDao.getPlanningsDetails(storeId);
	}
	
}
