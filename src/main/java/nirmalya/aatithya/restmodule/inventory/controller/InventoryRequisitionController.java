package nirmalya.aatithya.restmodule.inventory.controller;

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

import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryRequisitionDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryRequisitionModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class InventoryRequisitionController {
	Logger logger = LoggerFactory.getLogger(InventoryRequisitionController.class);

	@Autowired
	InventoryRequisitionDao inventoryRequisitionDao;

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-requisition-type")
	public List<DropDownModel> getRequisitionType() {
		logger.info("Method : getRequisitionType starts");
		logger.info("Method : getRequisitionType endss");
		return inventoryRequisitionDao.getRequisitionType();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-requisition-priority")
	public List<DropDownModel> getRequisitionPriority() {
		logger.info("Method : getRequisitionPriority starts");
		logger.info("Method : getRequisitionPriority endss");
		return inventoryRequisitionDao.getRequisitionPriority();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-uom")
	public List<DropDownModel> getUom() {
		logger.info("Method : getUom starts");
		logger.info("Method : getUom endss");
		return inventoryRequisitionDao.getUom();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-requisition-item-list")
	public List<InventoryRequisitionModel> getRequisitionItemList() {
		logger.info("Method : getRequisitionItemList starts");
		logger.info("Method : getRequisitionItemList endss");
		return inventoryRequisitionDao.getRequisitionItemList();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-requisition-edit")
	public List<InventoryRequisitionModel> getRequisitionEdit(@RequestParam String id) {
		logger.info("Method : getRequisitionEdit starts");
		logger.info("Method : getRequisitionEdit endss");
		return inventoryRequisitionDao.getRequisitionEdit(id);
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-activity-log")
	public List<ActivitylogModel> getActivityLog(@RequestParam String id) {
		logger.info("Method : getActivityLog starts");
		logger.info("Method : getActivityLog endss");
		return inventoryRequisitionDao.getActivityLog(id);
	}

	/*
	 * 
	 * PostMapping for add rest ItemRequisition
	 * 
	 * 
	 */
	@PostMapping(value = "rest-add-requisition")
	public ResponseEntity<JsonResponse<Object>> restAddRequisition(
			@RequestBody List<InventoryRequisitionModel> restItemRequisitonModel) {
		logger.info("Method : restAddRequisition starts");
		logger.info("Method : restAddRequisition ends");
		return inventoryRequisitionDao.restAddRequisition(restItemRequisitonModel);
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-req-cost-center")
	public List<DropDownModel> getCostCenter() {
		logger.info("Method : getCostCenter starts");
		logger.info("Method : getCostCenter endss");
		return inventoryRequisitionDao.getCostCenter();
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@GetMapping(value = "get-location")
	public List<DropDownModel> getLocation() {
		logger.info("Method : getLocation starts");
		logger.info("Method : getLocation endss");
		return inventoryRequisitionDao.getLocation();
	}

	/*
	 * Get mapping for get Item Name
	 */

	@GetMapping(value = "getProductListByAutoSearch")
	public ResponseEntity<JsonResponse<List<InventoryRequisitionModel>>> getProductListByAutoSearch(
			@RequestParam String id) {
		logger.info("Method : getProductListByAutoSearch starts");

		logger.info("Method : getProductListByAutoSearch endss");
		return inventoryRequisitionDao.getProductListByAutoSearch(id);
	}

	/*
	 * get all requisition for view
	 */
	@GetMapping(value = "get-requisition-view-list")
	public List<InventoryRequisitionModel> getRequisitionViewList() {
		logger.info("Method : getRequisitionViewList starts");
		logger.info("Method : getRequisitionViewList endss");
		return inventoryRequisitionDao.getRequisitionViewList();
	}

	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-delete-requisition")
	public ResponseEntity<JsonResponse<Object>> restDeleteRequisition(
			@RequestBody InventoryRequisitionModel restItemRequisitonModel) {
		logger.info("Method : restDeleteRequisition starts");
		logger.info("Method : restDeleteRequisition ends");
		return inventoryRequisitionDao.restDeleteRequisition(restItemRequisitonModel);
	}

	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-approve-requisition")
	public ResponseEntity<JsonResponse<Object>> restApproveRequisition(
			@RequestBody InventoryRequisitionModel restItemRequisitonModel) {
		logger.info("Method : restApproveRequisition starts");
		logger.info("Method : restApproveRequisition ends");
		return inventoryRequisitionDao.restApproveRequisition(restItemRequisitonModel);
	}

}
