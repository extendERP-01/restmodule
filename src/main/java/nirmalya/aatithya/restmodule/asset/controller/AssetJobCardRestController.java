//package nirmalya.aatithya.restmodule.asset.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import nirmalya.aatithya.restmodule.asset.dao.AssetJobCardDao;
//import nirmalya.aatithya.restmodule.asset.model.AssetJobCardModel;
//import nirmalya.aatithya.restmodule.asset.model.ItemAssetModel;
//import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
//import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
//import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//
//@RestController
//@RequestMapping(value = "asset/")
//public class AssetJobCardRestController {
//
//	Logger logger = LoggerFactory.getLogger(AssetJobCardRestController.class);
//
//	@Autowired
//	AssetJobCardDao assetJobCardDao;
//
//	@GetMapping("getServices")
//	public List<DropDownModel> getServices() {
//		logger.info("getServices starts");
//
//		logger.info("getServices ends ");
//		return assetJobCardDao.getServices();
//	}
//	
//	@RequestMapping(value = "/getMechanicAutoSearch", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetMechanicAutoSearch(@RequestParam String id) {
//		logger.info("Method : restGetMechanicAutoSearch starts");
//		
//		logger.info("Method : restGetMechanicAutoSearch ends");
//		return assetJobCardDao.getMechanicAutoSearchDao(id);
//	}
//	
//	@RequestMapping(value = "/getAsstMechanicAutoSearch", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetAsstMechanicAutoSearch(@RequestParam String id) {
//		logger.info("Method : restGetAsstMechanicAutoSearch starts");
//		
//		logger.info("Method : restGetAsstMechanicAutoSearch ends");
//		return assetJobCardDao.getAsstMechanicAutoSearchDao(id);
//	}
//
//	@PostMapping(value = "/getVehicleDetailsForJobCard")
//	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getVehicleDetailsForAssign(@RequestBody String id) {
//		logger.info("Method : getVehicleDetailsForJobCard starts");
//
//		logger.info("Method : getVehicleDetailsForJobCard ends");
//		return assetJobCardDao.getVehicleDetailsForJobCard(id);
//	}
//
//	@PostMapping(value = "addJobCard")
//	public ResponseEntity<JsonResponse<Object>> addJobCard(@RequestBody List<AssetJobCardModel> assignedAsset) {
//		logger.info("Method : addJobCard for rest controller starts");
//
//		logger.info("Method : addJobCard for rest controller ends");
//		return assetJobCardDao.addJobCard(assignedAsset);
//	}
//
//	@RequestMapping(value = "/getJobCardDetails", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<List<AssetJobCardModel>>> getJobCardDetails(
//			@RequestBody DataTableRequest request) {
//		logger.info("Method : getJobCardDetails starts");
//
//		logger.info("Method : getJobCardDetails ends");
//		return assetJobCardDao.getJobCardDetails(request);
//	}
//
//	@RequestMapping(value = "/editJobCard", method = { RequestMethod.GET })
//	public List<AssetJobCardModel> editJobCard(@RequestParam("id") String id) {
//		logger.info("Method : editJobCard for rest controller starts");
//
//		logger.info("Method : editJobCard for rest controller ends");
//		return assetJobCardDao.editJobCard(id);
//	}
//	
//	@RequestMapping(value = "/issueItemDetailsForJobCard", method = { RequestMethod.GET })
//	public List<ItemAssetModel> issueItemDetailsForJobCard(@RequestParam("id") String id, @RequestParam String vehicle) {
//		logger.info("Method : editJobCissueItemDetailsForJobCardard for rest controller starts");
//		
//		logger.info("Method : issueItemDetailsForJobCard for rest controller ends");
//		return assetJobCardDao.issueItemDetailsForJobCard(id,vehicle);
//	}
//
//	@RequestMapping(value = "/changeJobCardStatus", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<Object>> changeAssignStatus(@RequestBody AssetJobCardModel searchValue) {
//		logger.info("Method : changeJobCardStatus starts");
//
//		logger.info("Method : changeJobCardStatus ends");
//		return assetJobCardDao.changeJobCardStatus(searchValue);
//	}
//
//	/*
//	 * for modal view gym service experienced
//	 */
//	@RequestMapping(value = "/getJobCardModal", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<AssetJobCardModel>>> getJobCardModal(@RequestParam("id") String id) {
//		logger.info("Method : getJobCardModal for rest controller starts");
//
//		logger.info("Method : getJobCardModal for rest controller ends");
//		return assetJobCardDao.getJobCardModal(id);
//	}
//	
//	@RequestMapping(value = "/getIssuedItemModalForJobCard", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> getIssuedItemModalForJobCard(@RequestParam("id") String id, @RequestParam String asset) {
//		logger.info("Method : getIssuedItemModalForJobCard for rest controller starts");
//		
//		logger.info("Method : getIssuedItemModalForJobCard for rest controller ends");
//		return assetJobCardDao.getIssuedItemModalForJobCard(id,asset);
//	}
//
//	/*
//	 * for assign locker change status
//	 */
//	@RequestMapping(value = "changeJobCardStatus", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<Object>> changeJobCardStatus(@RequestParam String id,
//			@RequestParam Boolean status, @RequestParam String createdBy) {
//		logger.info("Method : changeJobCardStatus starts");
//
//		logger.info("Method : changeJobCardStatus ends");
//
//		return assetJobCardDao.changeJobCardStatus(id, status, createdBy);
//	}
//
//}
