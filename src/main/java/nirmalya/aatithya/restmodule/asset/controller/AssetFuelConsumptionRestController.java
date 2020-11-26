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

import nirmalya.aatithya.restmodule.asset.dao.AssetFuelConsumptionDao;
import nirmalya.aatithya.restmodule.asset.model.AssetFuelConsumptionModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.controller.DeliveryChallanRestController; 

@RestController
@RequestMapping("asset/")
public class AssetFuelConsumptionRestController {

	@Autowired
	AssetFuelConsumptionDao assetFuelConsumptionDao;

	Logger logger = LoggerFactory.getLogger(DeliveryChallanRestController.class);

	/*
	 * for drop down for get fuel
	 */
	@RequestMapping(value = "getFuel", method = { RequestMethod.GET })
	public List<DropDownModel> getFuel() {
		logger.info("Method in rest: getFuel starts");

		logger.info("Method in rest: getFuel starts");

		return assetFuelConsumptionDao.getFuel();
	}

	/*
	 * for drop down for driver details vehicle
	 */
	@RequestMapping(value = "/driverDetailsVechileChange", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> driverDetailsVechileOnchange(
			@RequestParam String vechileNo) {
		logger.info("Method in rest: driverDetailsVechileOnchange starts");

		logger.info("Method in rest: driverDetailsVechileOnchange ends");
		return assetFuelConsumptionDao.driverDetailsVechileOnchange(vechileNo);
	}

	/*
	 * for drop down for driver list auto search
	 */
	@RequestMapping(value = "/getDriverDetailsAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDriverDetailsAutoSearch(@RequestParam String id) {
		logger.info("Method in rest: getDriverDetailsAutoSearch starts");

		logger.info("Method in rest: getDriverDetailsAutoSearch ends");
		return assetFuelConsumptionDao.getDriverDetailsAutoSearch(id);
	}

	/*
	 * for drop down for vehicle list
	 */
	@RequestMapping(value = "getVeichelList", method = { RequestMethod.GET })
	public List<DropDownModel> getVeichelList() {
		logger.info("Method in rest: getVeichelList starts");

		logger.info("Method in rest: getVeichelList starts");

		return assetFuelConsumptionDao.getVeichelList();
	}

	/*
	 * for Add fuel consumption
	 */
	@RequestMapping(value = "restAddFuelConsumption", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddFuelConsumption(
			@RequestBody AssetFuelConsumptionModel AssetFuelConsumptionModel) {
		logger.info("Method : restAddFuelConsumption starts");

		logger.info("Method : restAddFuelConsumption ends");

		return assetFuelConsumptionDao.restAddFuelConsumption(AssetFuelConsumptionModel);
	}

	/*
	 * for view all fuel consumption
	 */
	@RequestMapping(value = "getAllFuelConsumption", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getAllDeliveryChallans(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllFuelConsumption starts");

		logger.info("Method : getAllFuelConsumption ends");

		return assetFuelConsumptionDao.getAllFuelConsumption(request);
	}

	/*
	 * for DeliveryChallan Edit
	 */
	@RequestMapping(value = "getfuelConsumptionById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> getDeliveryChallanMasterById(
			@RequestParam String id) {
		logger.info("Method : getfuelConsumptionById starts");

		logger.info("Method : getfuelConsumptionById ends");

		return assetFuelConsumptionDao.getFuelConsumptionId(id);
	}

	/*
	 * for fuel consumption Delete
	 */
	@RequestMapping(value = "deleteAssetFuelConsumptionModelById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAssetFuelConsumptionModelById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteAssetFuelConsumptionModelById starts");

		logger.info("Method : deleteAssetFuelConsumptionModelById ends");

		return assetFuelConsumptionDao.deleteAssetFuelConsumptionModelById(id, createdBy);
	}

	/*
	 * for get fuel Consumption modal
	 */
	@RequestMapping(value = "getfuelConsumptionModalById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> getfuelConsumptionModalById(
			@RequestParam String id) {
		logger.info("Method : getfuelConsumptionModalById starts");

		logger.info("Method : getfuelConsumptionModalById ends");

		return assetFuelConsumptionDao.getfuelConsumptionModalById(id);
	}

 
}
