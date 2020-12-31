package nirmalya.aatithya.restmodule.master.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.LocationMasterDao;
import nirmalya.aatithya.restmodule.master.model.LocationMasterModel;
import nirmalya.aatithya.restmodule.master.model.LocationRoomModel;
import nirmalya.aatithya.restmodule.master.model.LocationSectionModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class LocationMasterRestController {
	
	Logger logger = LoggerFactory.getLogger(LocationMasterRestController.class);

	@Autowired
	LocationMasterDao locationMasterDao;

	@RequestMapping(value = "getLocationTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getLocationTypeList() {
		logger.info("Method : getLocationTypeList starts");
		
		logger.info("Method : getLocationTypeList ends");
		return locationMasterDao.getLocationTypeList();
	}
	
	@RequestMapping(value = "getRoomTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getRoomTypeList() {
		logger.info("Method : getRoomTypeList starts");
		
		logger.info("Method : getRoomTypeList ends");
		return locationMasterDao.getRoomTypeList();
	}
	
	@RequestMapping(value = "getCountryListForLocation", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryListForLocation() {
		logger.info("Method : getCountryListForLocation starts");
		
		logger.info("Method : getCountryListForLocation ends");
		return locationMasterDao.getCountryListForLocation();
	}
	
	@RequestMapping(value = "viewStateLocListByCountry", method = { RequestMethod.GET })
	public List<DropDownModel> viewStateLocListByCountry(@RequestParam String id) {
		logger.info("Method : viewStateLocListByCountry starts");
		
		logger.info("Method : viewStateLocListByCountry ends");
		return locationMasterDao.viewStateLocListByCountry(id);
	}
	
	@RequestMapping(value = "viewCityLocListByState", method = { RequestMethod.GET })
	public List<DropDownModel> viewCityLocListByState(@RequestParam String id) {
		logger.info("Method : viewCityLocListByState starts");
		
		logger.info("Method : viewCityLocListByState ends");
		return locationMasterDao.viewCityLocListByState(id);
	}
	
	@RequestMapping(value = "viewSectionListByFloor", method = { RequestMethod.GET })
	public List<LocationSectionModel> viewSectionListByFloor(@RequestParam String id) {
		logger.info("Method : viewSectionListByFloor starts");
		
		logger.info("Method : viewSectionListByFloor ends");
		return locationMasterDao.viewSectionListByFloor(id);
	}
	
	@RequestMapping(value = "viewRoomListBySection", method = { RequestMethod.GET })
	public List<LocationRoomModel> viewRoomListBySection(@RequestParam String id) {
		logger.info("Method : viewRoomListBySection starts");
		
		logger.info("Method : viewRoomListBySection ends");
		return locationMasterDao.viewRoomListBySection(id);
	}
	
	@RequestMapping(value = "getLocationList", method = { RequestMethod.GET })
	public List<LocationMasterModel> getLocationList() {
		logger.info("Method : getLocationList starts");
		
		logger.info("Method : getLocationList ends");
		return locationMasterDao.getLocationList();
	}
	
	@RequestMapping(value = "getStateListForLoc", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateListForLoc(@RequestParam String id) {
		logger.info("Method : getStateListForLoc starts");
		
		logger.info("Method : getStateListForLoc ends");
		return locationMasterDao.getStateListForLoc(id);
	}
	
	@RequestMapping(value = "getCityForLocation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCityForLocation(@RequestParam String id) {
		logger.info("Method : getCityForLocation starts");
		
		logger.info("Method : getCityForLocation ends");
		return locationMasterDao.getCityForLocation(id);
	}
	
	@RequestMapping(value = "getLocationDetailsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<LocationMasterModel>> getLocationDetailsById(@RequestParam String id) {
		logger.info("Method : getLocationDetailsById starts");
		
		logger.info("Method : getLocationDetailsById ends");
		return locationMasterDao.getLocationDetailsById(id);
	}
	
	@RequestMapping(value = "getLocationFloorDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<LocationMasterModel>>> getLocationFloorDetails(@RequestParam String id) {
		logger.info("Method : getLocationFloorDetails starts");
		
		logger.info("Method : getLocationFloorDetails ends");
		return locationMasterDao.getLocationFloorDetails(id);
	}
	
	@RequestMapping(value = "getLocationRoomDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<LocationRoomModel>>> getLocationRoomDetails(@RequestBody List<String> id) {
		logger.info("Method : getLocationRoomDetails starts");
		
		logger.info("Method : getLocationRoomDetails ends");
		return locationMasterDao.getLocationRoomDetails(id);
	}
	
	@RequestMapping(value = "getLocationExcelData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<LocationMasterModel>>> getLocationExcelData(@RequestBody List<String> id) {
		logger.info("Method : getLocationExcelData starts");
		
		logger.info("Method : getLocationExcelData ends");
		return locationMasterDao.getLocationExcelData(id);
	}
	
	@RequestMapping(value = "countFloorWiseRoom", method = { RequestMethod.POST })
	public List<DropDownModel> countFloorWiseRoom(@RequestBody List<String> id) {
		logger.info("Method : countFloorWiseRoom starts");
		
		logger.info("Method : countFloorWiseRoom ends");
		return locationMasterDao.countFloorWiseRoom(id);
	}
	
	@RequestMapping(value = "getLocationListing", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<LocationMasterModel>>> getLocationListing() {
		logger.info("Method : getLocationListing starts");
		
		logger.info("Method : getLocationListing ends");
		return locationMasterDao.getLocationListing();
	}
	
	@RequestMapping(value = "saveLocationMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<LocationMasterModel>> saveLocationMaster(@RequestBody LocationMasterModel location) {
		logger.info("Method : saveLocationMaster starts");
		
		logger.info("Method : saveLocationMaster ends");
		return locationMasterDao.saveLocationMaster(location);
	}
	
	@RequestMapping(value = "saveFloorMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<LocationMasterModel>> saveFloorMaster(@RequestBody LocationMasterModel location) {
		logger.info("Method : saveFloorMaster starts");
		
		logger.info("Method : saveFloorMaster ends");
		return locationMasterDao.saveFloorMaster(location);
	}
	
	@RequestMapping(value = "saveRoomMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<LocationRoomModel>> saveRoomMaster(@RequestBody LocationRoomModel location) {
		logger.info("Method : saveRoomMaster starts");
		
		logger.info("Method : saveRoomMaster ends");
		return locationMasterDao.saveRoomMaster(location);
	}
	
	@RequestMapping(value = "saveSectionMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<LocationSectionModel>> saveSectionMaster(@RequestBody LocationSectionModel location) {
		logger.info("Method : saveSectionMaster starts");
		
		logger.info("Method : saveSectionMaster ends");
		return locationMasterDao.saveSectionMaster(location);
	}
	
	@RequestMapping(value = "deleteFloorMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteFloorMaster(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteFloorMaster starts");
		
		logger.info("Method : deleteFloorMaster ends");
		return locationMasterDao.deleteFloorMaster(id,createdBy);
	}
	
	@RequestMapping(value = "deleteLocationFile", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteLocationFile(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteLocationFile starts");
		
		logger.info("Method : deleteLocationFile ends");
		return locationMasterDao.deleteLocationFile(id,createdBy);
	}
	
	@RequestMapping(value = "deleteSectionMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteSectionMaster(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteSectionMaster starts");
		
		logger.info("Method : deleteSectionMaster ends");
		return locationMasterDao.deleteSectionMaster(id,createdBy);
	}
	
	@RequestMapping(value = "deleteRoomMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRoomMaster(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteRoomMaster starts");
		
		logger.info("Method : deleteRoomMaster ends");
		return locationMasterDao.deleteRoomMaster(id,createdBy);
	}
	
	@RequestMapping(value = "deleteLocationMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> deleteLocationMaster(@RequestBody List<DropDownModel> locationList) {
		logger.info("Method : deleteLocationMaster starts");
		
		logger.info("Method : deleteLocationMaster ends");
		return locationMasterDao.deleteLocationMaster(locationList);
	}
	
	@RequestMapping(value = "editFloorMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<LocationMasterModel>> editFloorMaster(@RequestParam String id) {
		logger.info("Method : editFloorMaster starts");
		
		logger.info("Method : editFloorMaster ends");
		return locationMasterDao.editFloorMaster(id);
	}
	
	@RequestMapping(value = "editSectionMaster", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<LocationSectionModel>> editSectionMaster(@RequestParam String id) {
		logger.info("Method : editSectionMaster starts");
		
		logger.info("Method : editSectionMaster ends");
		return locationMasterDao.editSectionMaster(id);
	}
}
