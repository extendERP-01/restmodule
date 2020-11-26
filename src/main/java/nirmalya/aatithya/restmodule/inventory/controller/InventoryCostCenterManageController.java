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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryCostCenterManageDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryManageCostcenterModel;
@RestController
@RequestMapping("inventory/")

public class InventoryCostCenterManageController {
	
	Logger logger = LoggerFactory.getLogger(InventoryCostCenterManageController.class);
	@Autowired
	InventoryCostCenterManageDao inventoryCostCenterManageDao;

	
	/*
	 * for Add property Asset Assign
	 */
	@RequestMapping(value = "restAddCostcenterManage", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddCostcenterManage(
			@RequestBody InventoryManageCostcenterModel inventoryManageCostcenterModel) {
		logger.info("Method in rest: restAddCostcenterManage starts");

		logger.info("Method in rest: restAddCostcenterManage ends");

		return inventoryCostCenterManageDao.restAddCostcenterManage(inventoryManageCostcenterModel);
	}
	
	@RequestMapping(value="getManageCostCenter" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<InventoryManageCostcenterModel>>> getAllManageCostcenter(@RequestBody DataTableRequest request) 
	{
		logger.info("Method in rest: getAllManageCostcenter starts");
		
		logger.info("Method in rest: getAllManageCostcenter ends");
		
		return inventoryCostCenterManageDao.getAllManageCostcenter(request);
	}
	/*
	 * for  edit manage cost center
	 */
	@RequestMapping(value="getManageCostcenter" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<InventoryManageCostcenterModel>> getThemeById(@RequestParam String id) 
	{
		logger.info("Method in rest: getManageCostcenter starts");
		
		logger.info("Method in rest: getManageCostcenter ends");
		
		return inventoryCostCenterManageDao.getManageCostcenter(id);
	}
	/*
	 * for delete assigned asset
	 */
	@RequestMapping(value="deleteManageCostcenter" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteSittingById(@RequestParam String id) 
	{
		logger.info("Method : deleteAssignedAsset starts");
		
		logger.info("Method : deleteAssignedAsset ends");
		
		return inventoryCostCenterManageDao.deleteManageCostcenter(id);
	}
	
	/*
	 * for one modal view manage Cost Center
	 */
	@RequestMapping(value = "getManageCostcenterModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<InventoryManageCostcenterModel>> getManageCostcenterModal(@RequestParam String id) {
		logger.info("Method in rest : getManageCostcenterModal starts");

		logger.info("Method in rest: getManageCostcenterModal ends");

		return inventoryCostCenterManageDao.getManageCostcenterModal(id);
	}
	
}
