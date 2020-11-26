package nirmalya.aatithya.restmodule.inventory.controller;

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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.SubInventoryMasterDao;
import nirmalya.aatithya.restmodule.inventory.model.RestSubInventoryMasterModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class SubInventoryMasterRestController {

	@Autowired
	SubInventoryMasterDao subInventoryMasterDao;
	
	Logger logger = LoggerFactory.getLogger(SubInventoryMasterRestController.class);
	
	/**
	 * GET STORE MASTER LIST
	 */
	@RequestMapping(value = "getStoreForSubInv", method = { RequestMethod.GET })
	public List<DropDownModel> getStoreForSubInv() {
		logger.info("Method : getStoreForSubInv starts");
		
		logger.info("Method : getStoreForSubInv ends");
		return subInventoryMasterDao.getStoreForSubInv();
	}
	
	/**
	 * Save Sub-Inventory
	 * @param storeMaster
	 * @return
	 */
	@RequestMapping(value = "/restAddNewSubInventory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddNewSubInventory(@RequestBody RestSubInventoryMasterModel subInventory) {
		logger.info("Method : restAddNewSubInventory starts");
		logger.info("Method : restAddNewSubInventory endss");
		return subInventoryMasterDao.saveSubInventory(subInventory);
	}
	
	@RequestMapping(value = "/getAllSubInventoryDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestSubInventoryMasterModel>>> getAllSubInventoryDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllSubInventoryDetails starts");
		logger.info("Method : getAllSubInventoryDetails endss");
		return subInventoryMasterDao.getAllSubInventoryDetails(request);
	}
	
	@RequestMapping(value = "/viewSubInventoryData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestSubInventoryMasterModel>> viewSubInventoryData(@RequestParam("id") String id, @RequestParam("action") String action) {
		logger.info("Method : viewSubInventoryData starts");
		logger.info("Method : viewSubInventoryData ends");
		return subInventoryMasterDao.viewSubInventoryData(id, action);
	}
	
	@RequestMapping(value = "/deleteSubInventory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSubInventory(@RequestParam("id") String id, @RequestParam("deletedBy") String deletedBy) {
		logger.info("Method : deleteSubInventory starts");
		logger.info("Method : deleteSubInventory ends");
		return subInventoryMasterDao.deleteSubInventory(id, deletedBy);
	}
}
