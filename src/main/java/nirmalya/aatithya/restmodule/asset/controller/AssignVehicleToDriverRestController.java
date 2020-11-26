package nirmalya.aatithya.restmodule.asset.controller;

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

import nirmalya.aatithya.restmodule.asset.dao.AssignVehcicleToDriverDao;
import nirmalya.aatithya.restmodule.asset.model.AssignVehicleToDriverModel;
import nirmalya.aatithya.restmodule.asset.model.ItemAssetModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "asset/")
public class AssignVehicleToDriverRestController {
	
	Logger logger = LoggerFactory.getLogger(AssignVehicleToDriverRestController.class);
	
	@Autowired
	AssignVehcicleToDriverDao assignVehcicleToDriverDao;

	@RequestMapping(value = "/getDriverAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssetForAssign(@RequestParam String id) {
		logger.info("Method : getDriverAutoSearch starts");
		
		logger.info("Method : getDriverAutoSearch ends");
		return assignVehcicleToDriverDao.getDriverAutoSearch(id);
	}
	
	@RequestMapping(value = "/getVehicleAutoSearchList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getVehicleAutoSearchList(@RequestParam String id) {
		logger.info("Method : getVehicleAutoSearchList starts");
		
		logger.info("Method : getVehicleAutoSearchList ends");
		return assignVehcicleToDriverDao.getVehicleAutoSearchList(id);
	}
	
	@RequestMapping(value = "/getVehicleAutoSearchListForSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getVehicleAutoSearchListForSearch(@RequestParam String id) {
		logger.info("Method : getVehicleAutoSearchListForSearch starts");
		
		logger.info("Method : getVehicleAutoSearchListForSearch ends");
		return assignVehcicleToDriverDao.getVehicleAutoSearchListForSearch(id);
	}
	
	@RequestMapping(value="assignVehicleToDriver" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> assignVehicleToDriver(@RequestBody  List<AssignVehicleToDriverModel> assignedDriver) {
		logger.info("Method : assignVehicleToDriver for rest controller starts");
		
		logger.info("Method : assignVehicleToDriver for rest controller ends");
		return assignVehcicleToDriverDao.assignAssetToVehicle(assignedDriver);
	}
	
	@RequestMapping(value = "/getAssignedVehicleDriverDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssignVehicleToDriverModel>>> getAssignedVehicleDriverDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAssignedVehicleDriverDetails starts");

		logger.info("Method : getAssignedVehicleDriverDetails ends");
		return assignVehcicleToDriverDao.getAssignedVehicleDriverDetails(request);
	}
	
	@RequestMapping(value = "/changeAssignedDriverStatus", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> changeAssignedDriverStatus(@RequestBody AssignVehicleToDriverModel searchValue) {
		logger.info("Method : changeAssignedDriverStatus starts");
		
		logger.info("Method : changeAssignedDriverStatus ends");
		return assignVehcicleToDriverDao.changeAssignedDriverStatus(searchValue);
	}
}
