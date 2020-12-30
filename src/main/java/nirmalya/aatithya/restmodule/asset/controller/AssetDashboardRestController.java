package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.model.DataSetAccountTree;
import nirmalya.aatithya.restmodule.asset.dao.AssetDashboardDao;
import nirmalya.aatithya.restmodule.asset.model.AssetJobCardModel;
import nirmalya.aatithya.restmodule.asset.model.AssetMaintenanceHistoryModel;
import nirmalya.aatithya.restmodule.asset.model.AssetWithPOInventoryModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "asset/")
public class AssetDashboardRestController {

	Logger logger = LoggerFactory.getLogger(AssetDashboardRestController.class);
	
	@Autowired
	AssetDashboardDao assetDashboardDao;
	
	@RequestMapping(value = "/dashboardJobCard", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetJobCardModel>>> dashboardJobCard(
			@RequestBody DataTableRequest request) {
		logger.info("Method : dashboardJobCard starts");
  
		logger.info("Method : dashboardJobCard ends");
		return assetDashboardDao.dashboardJobCard(request);
	}
	
	@RequestMapping(value = "/dashboardMaintenance", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetMaintenanceHistoryModel>>> dashboardMaintenance(
			@RequestBody DataTableRequest request) {
		logger.info("Method : dashboardMaintenance starts");
		
		logger.info("Method : dashboardMaintenance ends");
		return assetDashboardDao.dashboardMaintenance(request);
	}
	
	@RequestMapping(value = "getAssetTreeDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> getAssetTreeDetails(String getAccountTreeDetails) {
		logger.info("Method : getAssetTreeDetails starts");
		logger.info("Method : getAssetTreeDetails ends");
		return assetDashboardDao.getAssetTreeDetails("getAssetTreeDetails");
	}
	
	@RequestMapping(value = "/getAllLinkedAssets", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetWithPOInventoryModel>>> getAllLinkedAssets(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllLinkedAssets starts");

		logger.info("Method : getAllLinkedAssets ends");
		return assetDashboardDao.getAllLinkedAssets(request);
	}
	
	@RequestMapping(value = "/getAllAssetsWithVendor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AssetWithPOInventoryModel>>> getAllAssetsWithVendor(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllAssetsWithVendor starts");
		
		logger.info("Method : getAllAssetsWithVendor ends");
		return assetDashboardDao.getAllAssetsWithVendor(request);
	}
}
