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
import nirmalya.aatithya.restmodule.production.dao.ProductionProdGocoolDao;
import nirmalya.aatithya.restmodule.production.model.ProductionGocoolPacakgeingModel;
import nirmalya.aatithya.restmodule.production.model.ProductionGocoolProdModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPipeProductionModel;

@RestController
@RequestMapping("production/")
public class ProductionProdGocoolRestController {
	@Autowired
	ProductionProdGocoolDao productionProdGocoolDao;

	Logger logger = LoggerFactory.getLogger(ProductionProdGocoolRestController.class);

	/*
	 * view production mix
	 */
	@PostMapping(value = "view-productions")
	public ResponseEntity<JsonResponse<List<ProductionGocoolProdModel>>> viewProdctions(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewProdctions starts");

		logger.info("Method : viewProdctions ends");

		return productionProdGocoolDao.viewProdctions(request);
	}

	/*
	 * add production details
	 */
	@PostMapping(value = "add-production-dtl")
	public ResponseEntity<JsonResponse<Object>> addProductionDetails(
			@RequestBody List<ProductionGocoolProdModel> productionPipeProductionModelList) {
		logger.info("Method : addProductionDetails starts");
		logger.info("Method : addProductionDetails ends");
		return productionProdGocoolDao.addProductionDetails(productionPipeProductionModelList);
	}
	/*
	 * for view  modal view production
	 */
	@GetMapping(value = "viewProductionById" )
	public ResponseEntity<JsonResponse<List<ProductionGocoolProdModel>>> getProductionDetailsModal(
			@RequestParam("prodId") String prodId) {
		logger.info("Method : getProductionDetailsModal starts");

		logger.info("Method : getProductionDetailsModal ends");

		return productionProdGocoolDao.getProductionDetailsModal(prodId);
	}
}
