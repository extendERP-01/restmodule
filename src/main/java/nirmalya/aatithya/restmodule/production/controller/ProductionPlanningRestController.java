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
import nirmalya.aatithya.restmodule.production.dao.ProductionPlanningDao;
import nirmalya.aatithya.restmodule.production.model.ProductionGradePlanningModel;
import nirmalya.aatithya.restmodule.production.model.ProductionPlanningModel;
import nirmalya.aatithya.restmodule.production.model.ProductionSummaryDetailsModel;

@RestController
@RequestMapping("production/")
public class ProductionPlanningRestController {

	@Autowired
	ProductionPlanningDao productionPlanningDao;

	Logger logger = LoggerFactory.getLogger(ProductionPlanningRestController.class);

	/*
	 * for drop down for plan details
	 */
	@GetMapping(value = "getPlanDetails")
	public List<DropDownModel> getPlanDetails() {
		logger.info("Method in rest: getPlanDetails starts");

		logger.info("Method in rest: getPlanDetails starts");

		return productionPlanningDao.getPlanDetails();
	}

	/*
	 * for get production details
	 */
	@GetMapping(value = "getProductionDetails")
	public List<ProductionPlanningModel> getProductionDetails() {
		logger.info("Method in rest: getProductionDetails starts");

		logger.info("Method in rest: getProductionDetails starts");

		return productionPlanningDao.getProductionDetails();
	}

	/*
	 * for get production planning details
	 */
	@GetMapping(value = "/getProductionPlannaingDetails")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getProductionPlannaingDetails(
			@RequestParam String fromDate, @RequestParam String userId, @RequestParam String storeId) {
		logger.info("Method in rest: getProductionPlannaingDetails starts");

		logger.info("Method in rest: getProductionPlannaingDetails ends");
		return productionPlanningDao.getProductionPlannaingDetails(fromDate, userId, storeId);
	}

	/*
	 * for get production planning details
	 */
	@GetMapping(value = "/getProductionPlannaingBatch")
	public ResponseEntity<JsonResponse<DropDownModel>> getProductionPlannaingBatch(
			@RequestParam String batchQty, @RequestParam String prodQty) {
		logger.info("Method in rest: getProductionPlannaingBatch starts");

		logger.info("Method in rest: getProductionPlannaingBatch ends");
		return productionPlanningDao.getProductionPlannaingBatch(batchQty, prodQty);
	}

	/*
	 * for Add planning details
	 */
	@PostMapping(value = "restAddPlanning")
	public ResponseEntity<JsonResponse<Object>> restAddPlanning(
			@RequestBody List<ProductionPlanningModel> productionPlanningModel) {
		logger.info("Method in rest: restAddPlanning starts");

		logger.info("Method in rest: restAddPlanning ends");

		return productionPlanningDao.restAddPlanning(productionPlanningModel);
	}

	/*
	 * for All assignSkill
	 */
	@PostMapping(value = "getPlanningDetails")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getPlanningDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPlanningDetails starts");

		logger.info("Method : getPlanningDetails ends");

		return productionPlanningDao.getPlanningDetails(request);
	}

	/*
	 * forget planning edit
	 */
	@GetMapping(value = "getPlanningById")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getPlanningById(@RequestParam String pId,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : getPlanningById starts");

		logger.info("Method : getPlanningById ends");

		return productionPlanningDao.getPlanningById(pId, fromDate, toDate);
	}

	/*
	 * for get planning by id
	 */
	@GetMapping(value = "getPlanningByIdAndGrade")
	public ResponseEntity<JsonResponse<List<ProductionGradePlanningModel>>> getPlanningByIdAndGrade(
			@RequestParam String pId, String grade, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : getPlanningByIdAndGrade starts");

		logger.info("Method : getPlanningByIdAndGrade ends");

		return productionPlanningDao.getPlanningByIdAndGrade(pId, grade, fromDate, toDate);
	}

	/*
	 * for All planning details of first approval
	 */
	@PostMapping(value = "getProductionPlanningApprovalData")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getProductionPlanningApprovalData(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getProductionPlanningApprovalData starts");

		logger.info("Method : getProductionPlanningApprovalData ends");

		return productionPlanningDao.getProductionPlanningApprovalData(request);
	}

	/*
	 * 
	 * GetMapping for save-planning-approval-action
	 * 
	 * 
	 */
	@GetMapping(value = "save-planning-approval-action")
	public ResponseEntity<JsonResponse<Object>> saveplanningApprovalAction(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : saveplanningApprovalAction starts");
		logger.info("Method : saveplanningApprovalAction endss");
		return productionPlanningDao.saveplanningApprovalAction(id, createdBy);
	}

	/*
	 * 
	 * GetMapping for save-planning-reject-action
	 * 
	 * 
	 */
	@GetMapping(value = "save-planning-reject-action")
	public ResponseEntity<JsonResponse<Object>> saveplanningRejectAction(@RequestParam String id,
			@RequestParam String createdBy, @RequestParam String desc, @RequestParam String rejectType) {
		logger.info("Method : saveplanningRejectAction starts");
		logger.info("Method : saveplanningRejectAction endss");
		return productionPlanningDao.saveplanningRejectAction(id, createdBy, desc, rejectType);
	}

	/*
	 * for get production planning details
	 */
	@GetMapping(value = "getRawMaterialDetails")
	public ResponseEntity<JsonResponse<List<ProductionPlanningModel>>> getRawMaterialDetails(@RequestParam String id) {
		logger.info("Method in rest: getRawMaterialDetails starts");

		logger.info("Method in rest: getRawMaterialDetails ends");
		return productionPlanningDao.getRawMaterialDetails(id);
	}

	/*
	 * for Add planning details
	 */
	@GetMapping(value = "addRawMaterialDetails")
	public ResponseEntity<JsonResponse<Object>> addRawMaterialDetails(@RequestParam String batchCode,
			@RequestParam String batchQuantity, @RequestParam String storeId, String fromDate) {
		logger.info("Method in rest: addRawMaterialDetails starts");

		logger.info("Method in rest: addRawMaterialDetails ends");

		return productionPlanningDao.addRawMaterialDetails(batchCode, batchQuantity, storeId, fromDate);
	}

	/*
	 * for Add planning details
	 */
	@PostMapping(value = "saveRawData")
	public ResponseEntity<JsonResponse<Object>> saveRawData(
			@RequestBody List<ProductionPlanningModel> productionPlanningModel) {
		logger.info("Method in rest: saveRawData starts");

		logger.info("Method in rest: saveRawData ends");

		return productionPlanningDao.saveRawData(productionPlanningModel);
	}
	
	/*
	 * for view all item requisition reports
	 */
	@PostMapping(value = "get-plannings-raw-material-reports" )
	public ResponseEntity<JsonResponse<List<ProductionSummaryDetailsModel>>> getPlanningRawMaterialDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPlanningRawMaterialDetails starts");

		logger.info("Method : getPlanningRawMaterialDetails ends");

		return productionPlanningDao.getPlanningRawMaterialDetails(request);
	}
	
}
