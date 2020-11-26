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
import nirmalya.aatithya.restmodule.inventory.dao.WarehouseMasterDao;
import nirmalya.aatithya.restmodule.inventory.model.WarehouseMasterRestModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class WarehouseMasterRestController {

	@Autowired
	WarehouseMasterDao warehouseMasterDao;
	
	Logger logger = LoggerFactory.getLogger(WarehouseMasterRestController.class);
	
	@RequestMapping(value = "/getDropDownSubInventory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownSubInventory(@RequestParam("id") String id) {
		logger.info("Method : getDropDownSubInventory starts");
		
		logger.info("Method : getDropDownSubInventory ends");
		return warehouseMasterDao.getDropDownSubInventory(id);
	}
	
	@RequestMapping(value = "/restAddNewWarehouse", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddNewWarehouse(@RequestBody WarehouseMasterRestModel wareHouse) {
		logger.info("Method : restAddNewWarehouse starts");
		logger.info("Method : restAddNewWarehouse endss");
		return warehouseMasterDao.saveWarehouse(wareHouse);
	}
	
	@RequestMapping(value = "/getAllWarehouseDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<WarehouseMasterRestModel>>> getAllWarehouseDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllWarehouseDetails starts");
		logger.info("Method : getAllWarehouseDetails endss");
		return warehouseMasterDao.getAllWarehouseDetails(request);
	}
	
	@RequestMapping(value = "/viewWarehouseData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<WarehouseMasterRestModel>> viewWarehouseData(@RequestParam("id") String id, @RequestParam("action") String action) {
		logger.info("Method : viewWarehouseData starts");
		logger.info("Method : viewWarehouseData ends");
		return warehouseMasterDao.viewWarehouseData(id, action);
	}
	
	@RequestMapping(value = "/deleteWarehouse", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteWarehouse(@RequestParam("id") String id, @RequestParam("deletedBy") String deletedBy) {
		logger.info("Method : deleteWarehouse starts");
		logger.info("Method : deleteWarehouse ends");
		return warehouseMasterDao.deleteWarehouse(id, deletedBy);
	}
	
	@RequestMapping(value = "/editSubInvForWarehouse", method = { RequestMethod.GET })
	public List<DropDownModel> editSubInvForWarehouse(@RequestParam("id") String id) {
		logger.info("Method : editSubInvForWarehouse starts");
		logger.info("Method : editSubInvForWarehouse ends");
		return warehouseMasterDao.editSubInvForWarehouse(id);
	}
}
