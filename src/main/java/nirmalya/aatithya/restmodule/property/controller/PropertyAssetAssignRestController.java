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

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.dao.PropertyAssetAssignDao;
import nirmalya.aatithya.restmodule.property.model.PropertyAssignAssetModel;

@RestController
@RequestMapping("property/")
public class PropertyAssetAssignRestController {

	Logger logger = LoggerFactory.getLogger(PropertyAssetAssignRestController.class);

	@Autowired
	PropertyAssetAssignDao propertyAssetAssignDao;

	/*
	 * for drop down item name list for fixed service type
	 */

	@RequestMapping(value = "getItemCAtegoryListFixed", method = { RequestMethod.GET })
	public List<DropDownModel> getAmenityname1() {
		
		logger.info("Method in rest: getItemCAtegoryListFixed starts");

		logger.info("Method in rest: getItemCAtegoryListFixed starts");

		return propertyAssetAssignDao.getItemCAtegoryListFixed();
	}

	/*
	 * for Add property Asset Assign
	 */
	@RequestMapping(value = "restAddAssignAsset", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddAssignAsset(
			@RequestBody PropertyAssignAssetModel propertyAssignAssetModel) {
		
		logger.info("Method in rest: restAddAssignAsset starts");

		logger.info("Method in rest: restAddAssignAsset ends");

		return propertyAssetAssignDao.addAssignAsset(propertyAssignAssetModel);
	}

	/*
	 * for drop down of getAssetLists
	 */
	@RequestMapping(value = "/getAssetList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssetList(@RequestParam String item) {
	
		logger.info("Method in rest: getAssetList starts");

		logger.info("Method in rest: getAssetList ends");
		
		return propertyAssetAssignDao.getAssetLists(item);
	}

	/*
	 * for drop down of getAssetLists
	 */
	@RequestMapping(value = "/getAssetListAll", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssetListAll(@RequestParam String item) {
	
		logger.info("Method in rest: getAssetList starts");

		logger.info("Method in rest: getAssetList ends");
		
		return propertyAssetAssignDao.getAssetListAll(item);
	}
	

	/*
	 * for drop down of getAmenity
	 */
	@RequestMapping(value = "/getAmenity", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAmenity(@RequestParam String proCat) {
	
		logger.info("Method in rest: getAmenity starts");

		logger.info("Method in rest: getAmenity ends");
		
		return propertyAssetAssignDao.getAmenity(proCat);
	}

	
	/*
	 * for drop down of getItemCategoryByAmenity
	 */
	@RequestMapping(value = "/getItemCategoryByAmenity", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemCategoryByAmenity(@RequestParam String amenity) {
	
		logger.info("Method in rest: getItemCategoryByAmenity starts");

		logger.info("Method in rest: getItemCategoryByAmenity ends");
		
		return propertyAssetAssignDao.getItemCategoryByAmenity(amenity);
	}
	
	/*
	 * for drop down of getSubCategoryItem
	 */
	@RequestMapping(value = "/getSubCategoryItem", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryItem(@RequestParam String itmCat) {
	
		logger.info("Method in rest: getSubCategoryItem starts");

		logger.info("Method in rest: getSubCategoryItem ends");
		
		return propertyAssetAssignDao.getSubCategoryItem(itmCat);
	}
	/*
	 * for Drop down item list fixed
	 */
	
	@RequestMapping(value = "/getItemListFixed", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemList(@RequestParam String ItemSubCat) {
		logger.info("Method in rest: getItemListFixed starts");

		logger.info("Method in rest: getItemListFixed ends");

		return propertyAssetAssignDao.getItemListFixed(ItemSubCat);
	}
	
	
	/*
	 * for All Asset Assigned
	 */
	@RequestMapping(value = "getAllAssignedAsset", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssignAssetModel>>> getAllAssignedAsset(
			@RequestBody DataTableRequest request) {
		logger.info("Method in rest: getAllAssignedAsset starts");

		logger.info("Method in rest: getAllAssignedAsset ends");

		return propertyAssetAssignDao.getAllAssignedAsset(request);
	}
	
	/*
	 * for All Asset Assigned for Pdf
	 */
	@RequestMapping(value = "getAllAssignedAssetPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssignAssetModel>>> getAllAssignedAssetPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method in rest: getAllAssignedAsset starts");

		logger.info("Method in rest: getAllAssignedAsset ends");

		return propertyAssetAssignDao.getAllAssignedAssetPdf(request);
	}
	

	/*
	 * for one modal view assigned asset
	 */
	@RequestMapping(value = "getAssignedAssetById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyAssignAssetModel>> getAssignedAssetById(@RequestParam String id,
			@RequestParam String an) {
		logger.info("Method in rest : getAssignedAssetById starts");

		logger.info("Method in rest: getAssignedAssetById ends");

		return propertyAssetAssignDao.getAssignedAssetById(id, an);
	}
	/*
	 * for delete assigned asset
	 */
	@RequestMapping(value="deleteAssignedAsset" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteSittingById(@RequestParam String id,@RequestParam String ac,@RequestParam String createdBy) 
	{
		logger.info("Method : deleteAssignedAsset starts");
		
		logger.info("Method : deleteAssignedAsset ends");
		
		return propertyAssetAssignDao.deleteAssignedAsset(id,ac,createdBy);
	}
}
