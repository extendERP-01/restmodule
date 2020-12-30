package nirmalya.aatithya.restmodule.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.ActivitylogModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
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
	@GetMapping(value = "get-requisition-type" )
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
	@GetMapping(value = "get-activity-log")
	public List<ActivitylogModel> getActivityLog(@RequestParam String id) {
		logger.info("Method : getActivityLog starts");
		logger.info("Method : getActivityLog endss");
		return inventoryRequisitionDao.getActivityLog(id);
	}
}
