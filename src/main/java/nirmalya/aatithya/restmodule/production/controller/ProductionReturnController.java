package nirmalya.aatithya.restmodule.production.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.production.dao.ProductionReturnDao;
import nirmalya.aatithya.restmodule.production.model.ProductionGoCoolModel; 
import nirmalya.aatithya.restmodule.production.model.ProductionReturnModel;

@Controller
@RequestMapping("/production")
public class ProductionReturnController {
	@Autowired
	ProductionReturnDao productionReturnDao;

	Logger logger = LoggerFactory.getLogger(ProductionReturnController.class);

	/*
	 * Get mapping for get production item change
	 */

	@GetMapping(value = "get-requisition")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPlanningsDetails(@RequestParam String storeId) {
		logger.info("Method : getPlanningsDetails starts");
		logger.info("Method : getPlanningsDetails ends");
		return productionReturnDao.getPlanningsDetails(storeId);
	}

	/*
	 * for Add planning details
	 */
	@PostMapping(value = "add-return-production")
	public ResponseEntity<JsonResponse<Object>> addProductionReturn(
			@RequestBody List<ProductionReturnModel> productionReturnModel) {
		logger.info("Method in rest: addProductionReturn starts");

		logger.info("Method in rest: addProductionReturn ends");

		return productionReturnDao.addProductionReturn(productionReturnModel);
	}
	
	/*
	 * Get mapping for get batch details on production item change
	 */

	@GetMapping(value = "rest-get-raw-details")

	public ResponseEntity<JsonResponse<List<ProductionGoCoolModel>>> getRawMaterialDetails(@RequestParam String planId,  @RequestParam String storeId) {
		logger.info("Method : getRawMaterialDetails starts");
		logger.info("Method : getRawMaterialDetails ends");
		return productionReturnDao.getRawMaterialDetails(planId, storeId);
	}
	
	/*
	 * view production mix
	 */
	@PostMapping(value = "get-goods-return")
	public ResponseEntity<JsonResponse<List<ProductionReturnModel>>> viewProdctionsReturn(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewProdctionsReturn starts");

		logger.info("Method : viewProdctionsReturn ends");

		return productionReturnDao.viewProdctionsReturn(request);
	}
	/*
	 * for view  modal view production
	 */
	@GetMapping(value = "get-goods-return-modal" )
	public ResponseEntity<JsonResponse<List<ProductionReturnModel>>> getProductionReturnModal(
			@RequestParam String id) {
		logger.info("Method : getProductionReturnModal starts");

		logger.info("Method : getProductionReturnModal ends");

		return productionReturnDao.getProductionReturnModal(id);
	}
}
