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
import nirmalya.aatithya.restmodule.employee.model.ExitInitiateModel;
import nirmalya.aatithya.restmodule.inventory.dao.PhysicalIVerificationWareHouseDao;
import nirmalya.aatithya.restmodule.inventory.model.PhysicalVarificationWareHouseModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "inventory/")
public class RestPhysicalVericationWareHouseController {

	@Autowired
	PhysicalIVerificationWareHouseDao physicalIVerificationWareHouseDao;

	Logger logger = LoggerFactory.getLogger(RestPhysicalVericationWareHouseController.class);

	/*
	 * 
	 * dropdown for inventory
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-subInventory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubInventory(@RequestParam String id) {
		logger.info("Method : getSubInventory starts");
		logger.info("Method : getSubInventory ends");
		return physicalIVerificationWareHouseDao.getSubInventory(id);
	}

	/*
	 * 
	 * dropdown for store name
	 * 
	 * 
	 */

	@RequestMapping(value = "getstoreList", method = { RequestMethod.GET })
	public List<DropDownModel> getstoreList() {
		logger.info("Method : getstoreList starts");
		logger.info("Method : getstoreList ends");
		return physicalIVerificationWareHouseDao.getstoreList();
	}

	/*
	 * 
	 * dropdown for ware house
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-warehouse", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getWareHouse(@RequestParam String id) {
		logger.info("Method : getWareHouse starts");
		logger.info("Method : getWareHouse ends");
		return physicalIVerificationWareHouseDao.getWareHouse(id);
	}

	/*
	 * 
	 * dropdown for rack
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-rack", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRackFromWareHouse(@RequestParam String id) {
		logger.info("Method : getWareHouse starts");
		logger.info("Method : getWareHouse ends");
		return physicalIVerificationWareHouseDao.getRackFromWareHouse(id);
	}

	/*
	 * 
	 * dropdown for rack
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-item", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<PhysicalVarificationWareHouseModel>>> getItemFromRack(
			@RequestParam String id) {
		logger.info("Method : getItemFromRack starts");
		logger.info("Method : getItemFromRack ends");
		return physicalIVerificationWareHouseDao.getItemFromRack(id);
	}

	@RequestMapping(value = "rest-add-physicalVerification", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddPhysicalVerification(
			@RequestBody List<PhysicalVarificationWareHouseModel> physicalVarificationWareHouseModel) {
		logger.info("Method in rest: restAddPhysicalVerification starts");

		logger.info("Method in rest: restAddPhysicalVerification ends");

		return physicalIVerificationWareHouseDao.restAddPhysicalVerification(physicalVarificationWareHouseModel);
	}
	@RequestMapping(value = "/getAllPhysicalVerification", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PhysicalVarificationWareHouseModel>>> getAllPhysicalVerification(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllPhysicalVerification starts");
		
		logger.info("Method : getAllPhysicalVerification end");
		
		return physicalIVerificationWareHouseDao.getAllPhysicalVerification(request);
	}
}
