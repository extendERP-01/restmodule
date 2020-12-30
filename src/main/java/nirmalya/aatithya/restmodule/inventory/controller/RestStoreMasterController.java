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
import nirmalya.aatithya.restmodule.inventory.dao.RestStoreMasterDao;
import nirmalya.aatithya.restmodule.inventory.model.RestStoreMasterModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "inventory")
public class RestStoreMasterController {
	
	@Autowired
	RestStoreMasterDao storeDao;

	Logger logger = LoggerFactory.getLogger(RestStoreMasterController.class);

	/*
	 * 
	 * PostMapping for add get country name
	 * 
	 * 
	 */

	@RequestMapping(value = "get-country-name", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryNameList() {
		logger.info("Method : getCountryNameList starts");
		logger.info("Method : getCountryNameList ends");
		return storeDao.getCountryNameList();
	}

	/*
	 * 
	 * Get mapping for get State name
	 * 
	 */
	@RequestMapping(value = "get-state-name", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStoreStateName(@RequestParam String id) {
		logger.info("Method : getStoreStateName starts");
		logger.info("Method : getStoreStateName ends");
		return storeDao.getStoreStateName(id);
	}

	/*
	 * 
	 * Get mapping for get District name
	 * 
	 */
	@RequestMapping(value = "get-district-name", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStoreDistrictName(@RequestParam String id) {
		logger.info("Method : getStoreDistrictName starts");
		logger.info("Method : getStoreDistrictName ends");
		return storeDao.getStoreDistrictName(id);
	}

	/*
	 * Post Mapping to Add new Store
	 *
	 */
	@RequestMapping(value = "/restAddNewStore", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddNewStore(@RequestBody RestStoreMasterModel storeMaster) {
		logger.info("Method : restAddNewStore starts");
		logger.info("Method : restAddNewStore endss");
		return storeDao.restAddNewStore(storeMaster);
	}

	/*
	 * returns all Store Details
	 *
	 */
	@RequestMapping(value = "/getAllStoreDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestStoreMasterModel>>> viewStoreMasterDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewStoreMasterDetails starts");
		logger.info("Method : viewStoreMasterDetails endss");
		return storeDao.viewStoreMasterDetails(request);
	}

	/*
	 * returns particular store Details in model
	 *
	 */
	@RequestMapping(value = "/viewStoreDetailsModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestStoreMasterModel>> viewStoreDetailsModal(@RequestParam("id") String id) {
		logger.info("Method : viewStoreDetailsModal starts");
		logger.info("Method : viewStoreDetailsModal ends");
		return storeDao.viewStoreDetailsModal(id);
	}

	/*
	 * delete particular store Details
	 *
	 */
	@RequestMapping(value = "/deleteStoreDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteStoreDetails(@RequestParam String id) {
		logger.info("Method : deleteStoreDetails starts");
		logger.info("Method : deleteStoreDetails end");
		return storeDao.deleteStoreDetails(id);
	}

	/*
	 * 
	 * Get mapping for get State Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-state-name-editList", method = { RequestMethod.GET })
	public List<DropDownModel> getStateNameEditList(@RequestParam String id) {
		logger.info("Method :  getStateNameEditList starts");
		logger.info("Method :  getStateNameEditList endss");
		return storeDao.getStateNameEditList(id);
	}

	/*
	 * 
	 * Get mapping for get District Name for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-distName-editList", method = { RequestMethod.GET })
	public List<DropDownModel> getDistNameEditList(@RequestParam String id) {
		logger.info("Method :  getDistNameEditList starts");
		logger.info("Method :  getDistNameEditList endss");
		return storeDao.getDistNameEditList(id);
	}

	/*
	 * returns particular Store for edit
	 *
	 */
	@RequestMapping(value = "/editStoreDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestStoreMasterModel>> editStoreDetails(@RequestParam("id") String id) {
		logger.info("Method : editStoreDetails starts");
		logger.info("Method : editStoreDetails ends");
		return storeDao.editStoreDetails(id);
	}
	/*
	 * 
	 * PostMapping for add get store name search param
	 * 
	 * 
	 */

	@RequestMapping(value = "get-store-name", method = { RequestMethod.GET })
	public List<DropDownModel> getStoreList() {
		logger.info("Method : getStoreList starts");
		logger.info("Method : getStoreList ends");
		return storeDao.getStoreList();
	}
	/*
	 * 
	 * PostMapping for add get state name search param
	 * 
	 * 
	 */

	@RequestMapping(value = "get-state-search-param", method = { RequestMethod.GET })
	public List<DropDownModel> getStateListSearchParam() {
		logger.info("Method : getStateListSearchParam starts");
		logger.info("Method : getStateListSearchParam ends");
		return storeDao.getStateListSearchParam();
	}
}
