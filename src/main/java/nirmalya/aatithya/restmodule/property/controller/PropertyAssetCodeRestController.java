/**
 * rest Controller for property Assetcode
 */
package nirmalya.aatithya.restmodule.property.controller;

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

import nirmalya.aatithya.restmodule.asset.model.AssetModel;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.dao.PropertyAssetCodeDao;
import nirmalya.aatithya.restmodule.property.model.AssetItemModel;
import nirmalya.aatithya.restmodule.property.model.PropertyAssetCodeModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("property")
public class PropertyAssetCodeRestController {
	Logger logger = LoggerFactory.getLogger(PropertyAssetCodeRestController.class);
	@Autowired
	PropertyAssetCodeDao assetCodeDao;

	/**
	 * returns item name for drop down model
	 *
	 */
	@RequestMapping(value = "/getItemNameForAsset", method = { RequestMethod.GET })
	public List<AssetItemModel> getItemNameForAsset() {
		logger.info("Method : getItemNameForAsset starts");

		logger.info("Method : getItemNameForAsset end");
		return assetCodeDao.getItemName();
	}
	
	@RequestMapping(value = "/getStoreForAsset", method = { RequestMethod.GET })
	public List<DropDownModel> getStoreForAsset() {
		logger.info("Method : getStoreForAsset starts");
		
		logger.info("Method : getStoreForAsset end");
		return assetCodeDao.getStoreForAsset();
	}

	/**
	 * returns add property asset code
	 *
	 */

	@RequestMapping(value = "/addAssetCode", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addAssetCode(@RequestBody PropertyAssetCodeModel form) {
		logger.info("Method : addAssetCode starts");

		logger.info("Method : addAssetCode end");
		return assetCodeDao.addAssetCode(form);

	}

	/**
	 * returns get all property hotels
	 *
	 */
	@RequestMapping(value = "/getAllAssetCode", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssetCodeModel>>> getAllAssetCode(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllAssetCode starts");

		logger.info("Method : getAllAssetCode end");
		return assetCodeDao.getAllAssetCode(request);
	}

	/**
	 * returns delete property asset code
	 *
	 */
	@RequestMapping(value = "/deleteAssetCodeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAssetCode(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteAssetCode starts");

		logger.info("Method : deleteAssetCode end");
		return assetCodeDao.deleteAssetCode(id, createdBy);
	}

	/**
	 * returns edit property asset code
	 *
	 */
	@RequestMapping(value = "/getAssetCodeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyAssetCodeModel>> getAssetCodeById(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getAssetCodeById starts");

		logger.info("Method : getAssetCodeById end");
		return assetCodeDao.getAssetCodeById(id, action);
	}
	
	@RequestMapping(value = "/getItemCategoryForAsset", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemCategoryForAsset(@RequestParam String id) {
		logger.info("Method : getItemCategoryForAsset starts");
		
		logger.info("Method : getItemCategoryForAsset ends");
		return assetCodeDao.getItemCategoryForAsset(id);
	}
	
	@RequestMapping(value = "/getItemBarcodeForAsset", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemBarcodeForAsset(@RequestParam String id) {
		logger.info("Method : getItemBarcodeForAsset starts");
		
		logger.info("Method : getItemBarcodeForAsset ends");
		return assetCodeDao.getItemBarcodeForAsset(id);
	}
	
	@RequestMapping(value = "/getItemForAsset", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<AssetModel>>> getItemForAsset(@RequestParam String id,@RequestParam String cat) {
		logger.info("Method : getItemForAsset starts");
		
		logger.info("Method : getItemForAsset ends");
		return assetCodeDao.getItemForAsset(id,cat);
	}

}
