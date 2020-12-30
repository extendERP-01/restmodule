//package nirmalya.aatithya.restmodule.asset.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import nirmalya.aatithya.restmodule.asset.dao.AssetFuelConsumptionDao;
//import nirmalya.aatithya.restmodule.asset.model.AssetFuelConsumptionModel;
//import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
//import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
//import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
//import nirmalya.aatithya.restmodule.sales.model.DeliveryChallanInvoiceModel;
//import nirmalya.aatithya.restmodule.sales.model.PreviousDataModel;
//
//@RestController
//@RequestMapping("asset/")
//public class AssetFuelConsumptionRestController {
//
//	@Autowired
//	AssetFuelConsumptionDao assetFuelConsumptionDao;
//
//	Logger logger = LoggerFactory.getLogger(AssetFuelConsumptionRestController.class);
//
//	/*
//	 * for drop down for sales order
//	 */
//	@RequestMapping(value = "getFuel", method = { RequestMethod.GET })
//	public List<DropDownModel> getFuel() {
//		logger.info("Method in rest: getFuel starts");
//
//		logger.info("Method in rest: getFuel starts");
//		return assetFuelConsumptionDao.getFuel();
//	}
//	
//	@RequestMapping(value = "getStoreForFuelConsmption", method = { RequestMethod.GET })
//	public List<DropDownModel> getStoreForFuelConsmption() {
//		logger.info("Method in rest: getStoreForFuelConsmption starts");
//		
//		logger.info("Method in rest: getStoreForFuelConsmption starts");
//		return assetFuelConsumptionDao.getStoreForFuelConsmption();
//	}
//
//	/*
//	 * for drop down for po details
//	 */
//	@RequestMapping(value = "/driverDetailsVechileChange", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> driverDetailsVechileOnchange(
//			@RequestParam String vechileNo) {
//		logger.info("Method in rest: driverDetailsVechileOnchange starts");
//
//		logger.info("Method in rest: driverDetailsVechileOnchange ends");
//		return assetFuelConsumptionDao.driverDetailsVechileOnchange(vechileNo);
//	}
//
//	/*
//	 * for drop down for driver list auto search
//	 */
//	@RequestMapping(value = "/getDriverDetailsAutoSearch", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDriverDetailsAutoSearch(@RequestParam String id) {
//		logger.info("Method in rest: getDriverDetailsAutoSearch starts");
//
//		logger.info("Method in rest: getDriverDetailsAutoSearch ends");
//		return assetFuelConsumptionDao.getDriverDetailsAutoSearch(id);
//	}
//	
//	@RequestMapping(value = "/getDieselRate", method = { RequestMethod.GET })
//	//public ResponseEntity<JsonResponse<List<DropDownModel>>> getDieselRate() {
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDieselRate(@RequestParam String id) {
//		logger.info("Method in rest: getDieselRate starts");
//		
//		logger.info("Method in rest: getDieselRate ends");
//		return assetFuelConsumptionDao.getDieselRate(id);
//	}
//
//	/*
//	 * for drop down for vechile list
//	 */
//	@RequestMapping(value = "getVeichelList", method = { RequestMethod.GET })
//	public List<DropDownModel> getVeichelList() {
//		logger.info("Method in rest: getVeichelList starts");
//
//		logger.info("Method in rest: getVeichelList starts");
//
//		return assetFuelConsumptionDao.getVeichelList();
//	}
//
//	/*
//	 * for Add DeliveryChallan
//	 */
//	@RequestMapping(value = "restAddFuelConsumption", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<Object>> restAddFuelConsumption(
//			@RequestBody AssetFuelConsumptionModel AssetFuelConsumptionModel) {
//		logger.info("Method : restAddFuelConsumption starts");
//
//		logger.info("Method : restAddFuelConsumption ends");
//
//		return assetFuelConsumptionDao.restAddFuelConsumption(AssetFuelConsumptionModel);
//	}
//
//	/*
//	 * for view all DeliveryChallan
//	 */
//	@RequestMapping(value = "getAllFuelConsumption", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getAllDeliveryChallans(
//			@RequestBody DataTableRequest request) {
//		logger.info("Method : getAllFuelConsumption starts");
//
//		logger.info("Method : getAllFuelConsumption ends");
//
//		return assetFuelConsumptionDao.getAllFuelConsumption(request);
//	}
//
//	/*
//	 * for DeliveryChallan Edit
//	 */
//	@RequestMapping(value = "getfuelConsumptionById", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> getDeliveryChallanMasterById(
//			@RequestParam String id) {
//		logger.info("Method : getfuelConsumptionById starts");
//
//		logger.info("Method : getfuelConsumptionById ends");
//
//		return assetFuelConsumptionDao.getFuelConsumptionId(id);
//	}
//
//	/*
//	 * for DeliveryChallan Delete
//	 */
//	@RequestMapping(value = "deleteAssetFuelConsumptionModelById", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<Object>> deleteAssetFuelConsumptionModelById(@RequestParam String id,
//			@RequestParam String createdBy) {
//		logger.info("Method : deleteAssetFuelConsumptionModelById starts");
//
//		logger.info("Method : deleteAssetFuelConsumptionModelById ends");
//
//		return assetFuelConsumptionDao.deleteAssetFuelConsumptionModelById(id, createdBy);
//	}
//
//	/*
//	 * for get fuel Consumption modal
//	 */
//	@RequestMapping(value = "getfuelConsumptionModalById", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<AssetFuelConsumptionModel>> getfuelConsumptionModalById(
//			@RequestParam String id) {
//		logger.info("Method : getfuelConsumptionModalById starts");
//
//		logger.info("Method : getfuelConsumptionModalById ends");
//
//		return assetFuelConsumptionDao.getfuelConsumptionModalById(id);
//	}
//
//	/*
//	 * for get fuel Consumption pdf
//	 */
//	@RequestMapping(value = "getfuelConsumptionModalByIdPdf", method = { RequestMethod.GET })
//	public ResponseEntity<AssetFuelConsumptionModel> getfuelConsumptionModalByIdPdf(@RequestParam String id) {
//		logger.info("Method : getfuelConsumptionModalByIdPdf starts");
//
//		logger.info("Method : getfuelConsumptionModalByIdPdf ends");
//
//		return assetFuelConsumptionDao.getfuelConsumptionModalByIdPdf(id);
//	}
//
//	/*
//	 * for invoice delivery challan print preview
//	 */
//	@RequestMapping(value = "/getInvoiceDataPreview", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<DeliveryChallanInvoiceModel>>> getInvoiceDataPreview(
//			@RequestParam("id") String id) {
//		logger.info("Method : getInvoiceDataPreview for rest controller starts");
//
//		logger.info("Method : getInvoiceDataPreview for rest controller ends");
//		return assetFuelConsumptionDao.getInvoiceDataPreview(id);
//	}
//	
//	
//	@RequestMapping(value="restLogoImage-Fuel" , method={RequestMethod.GET})
//	public List<DropDownModel> restHotelLogoImage(@RequestParam("logoType") String logoType) {
//		logger.info("Method : restHotelLogoImage starts");
//
//		logger.info("Method : restHotelLogoImage ends");
//		return assetFuelConsumptionDao.getHotelLogoImage(logoType);
//	}
//	
//	@RequestMapping(value = "getVehicleFuelConsmpReportForPreview", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getVehicleFuelConsmpReportForPreview(
//			@RequestBody DataTableRequest request) {
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportForPreview starts");
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportForPreview end");
//		return assetFuelConsumptionDao.getVehicleFuelConsmpReportForPreview(request);
//	}
//	
//	@RequestMapping(value = "getVehicleFuelConsmpReportPdf", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getVehicleFuelConsmpReportPdf(
//			@RequestBody DataTableRequest request) {
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportPdf starts");
//		logger.info("Method : RESTMODULE getVehicleFuelConsmpReportPdf end");
//		return assetFuelConsumptionDao.getVehicleFuelConsmpReportPdf(request);
//	}
//	
//	@RequestMapping(value = "getGenerateFuelConsumptionVehicleReportForPreview", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getGenerateFuelConsumptionVehicleReportForPreview(
//			@RequestBody DataTableRequest request) {
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleReportForPreview starts");
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleReportForPreview end");
//		return assetFuelConsumptionDao.getGenerateFuelConsumptionVehicleReportForPreview(request);
//	}
//
//	@RequestMapping(value = "/getVehicleNoAutoCompleteForAssetReport", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVehicleNoAutoCompleteForReport(
//			@RequestParam String id) {
//		logger.info("Method in rest: getVehicleNoAutoCompleteForReport starts");
//
//		logger.info("Method in rest: getVehicleNoAutoCompleteForReport ends");
//		return assetFuelConsumptionDao.getVehicleNoAutoCompleteForReport(id);
//	}
//
//	@RequestMapping(value = "/getCouponNoAutoCompleteForReport", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCouponNoAutoCompleteForReport(@RequestParam String id) {
//		logger.info("Method in rest: getCouponNoAutoCompleteForReport starts");
//
//		logger.info("Method in rest: getCouponNoAutoCompleteForReport ends");
//		return assetFuelConsumptionDao.getCouponNoAutoCompleteForReport(id);
//	}
//
//	@RequestMapping(value = "getGenerateFuelConsumptionVehicleReportForPdf", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getGenerateFuelConsumptionVehicleReportForPdf(
//			@RequestBody DataTableRequest request) {
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleReportForPdf starts");
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleReportForPdf end");
//		return assetFuelConsumptionDao.getGenerateFuelConsumptionVehicleReportForPdf(request);
//	}
//	@RequestMapping(value = "getGenerateFuelConsumptionVehicleMilageReportForPreview", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getGenerateFuelConsumptionVehicleMilageReportForPreview(
//			@RequestBody DataTableRequest request) {
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleMilageReportForPreview starts");
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleMilageReportForPreview end");
//		return assetFuelConsumptionDao.getGenerateFuelConsumptionVehicleMilageReportForPreview(request);
//	}
//	
//	@RequestMapping(value = "getGenerateFuelConsumptionVehicleMilageReportForPdf", method = { RequestMethod.POST })
//	public ResponseEntity<JsonResponse<List<AssetFuelConsumptionModel>>> getGenerateFuelConsumptionVehicleMilageReportForPdf(
//			@RequestBody DataTableRequest request) {
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleMilageReportForPdf starts");
//		logger.info("Method : RESTMODULE getGenerateFuelConsumptionVehicleMilageReportForPdf end");
//		return assetFuelConsumptionDao.getGenerateFuelConsumptionVehicleMilageReportForPdf(request);
//	}
//	
//	@RequestMapping(value = "/getPreviousDataFuel", method = { RequestMethod.GET })
//	public ResponseEntity<JsonResponse<List<PreviousDataModel>>> getPreviousDataFuel(@RequestParam String id) {
//		logger.info("Method : getPreviousDataFuel starts");
//
//		logger.info("Method : getPreviousDataFuel ends");
//		return assetFuelConsumptionDao.getPreviousDataFuel(id);
//	}
//	
//	
//	/*
//	 * Added for Fuel consumption datewise slipno by subharam
//	 */
//	@GetMapping(value = "/getRefSlipNo")
//	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRefSlipNo(@RequestParam String id) {
//		logger.info("Method in rest: getRefChallanNo starts");
//		
//		logger.info("Method in rest: getRefChallanNo ends");
//		return assetFuelConsumptionDao.getRefSlipNo(id);
//	}
//	
//}
