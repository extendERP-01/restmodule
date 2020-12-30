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

import nirmalya.aatithya.restmodule.asset.dao.AssetMaintenancePolicyHistoryDao;
import nirmalya.aatithya.restmodule.asset.model.AssetMaintenanceHistoryModel;
import nirmalya.aatithya.restmodule.asset.model.AssetPolicyMaster;
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
public class AssetMaintenancePolicyHistoryRestController {

Logger logger = LoggerFactory.getLogger(AssetMaintenancePolicyHistoryRestController.class);
	
	@Autowired
	AssetMaintenancePolicyHistoryDao assetMaintenancePolicyHistoryDao;

	@RequestMapping(value = "/getAssetCodeAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ItemAssetModel>>> restAssetCodeAutoSearch(@RequestParam String id) {
		logger.info("Method : restAssetCodeAutoSearch starts");
		
		logger.info("Method : restAssetCodeAutoSearch ends");
		return assetMaintenancePolicyHistoryDao.getAssetCodeAutoSearch(id);
	}
	
	@RequestMapping(value = "/getMaintenanceDetailsByAsset", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AssetPolicyMaster>>> restMaintenanceDetailsByAsset(@RequestParam String id) {
		logger.info("Method : restMaintenanceDetailsByAsset starts");
		
		logger.info("Method : restMaintenanceDetailsByAsset ends");
		return assetMaintenancePolicyHistoryDao.getMaintenanceDetailsByAsset(id);
	}
	
	@RequestMapping(value="addMaintenanceHistory" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddMaintenanceHistory(@RequestBody  AssetMaintenanceHistoryModel mainHistory) {
		logger.info("Method : restAddMaintenanceHistory for rest controller starts");
		
		logger.info("Method : restAddMaintenanceHistory for rest controller ends");
		return assetMaintenancePolicyHistoryDao.addMaintenanceHistory(mainHistory);
	}
	
	@RequestMapping(value = "getMaintenanceReportForPreview", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>> getMaintenanceReportForPreview(
			@RequestBody DataTableRequest request) {
		logger.info("Method : RESTMODULE getMaintenanceReportForPreview starts");
		logger.info("Method : RESTMODULE getMaintenanceReportForPreview end");
		return assetMaintenancePolicyHistoryDao.getMaintenanceReportForPreview(request);
	}
	
	@RequestMapping(value = "getMaintenanceReportPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>> getMaintenanceReportPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : RESTMODULE getMaintenanceReportPdf starts");
		logger.info("Method : RESTMODULE getMaintenanceReportPdf end");
		return assetMaintenancePolicyHistoryDao.getMaintenanceReportPdf(request);
	}
	
	@RequestMapping(value="restLogoImage-Maintenance" , method={RequestMethod.GET})
	public List<DropDownModel> restHotelLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restHotelLogoImage starts");

		logger.info("Method : restHotelLogoImage ends");
		return assetMaintenancePolicyHistoryDao.getHotelLogoImage(logoType);
	}
}
