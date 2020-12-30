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
import nirmalya.aatithya.restmodule.property.dao.PropertyAssignAssetToStaffDao;
import nirmalya.aatithya.restmodule.property.model.PropertyAssignAssetToStaffModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "property/")
public class PropertyAssignAssetToStaffRestController {

	Logger logger = LoggerFactory.getLogger(PropertyAssignAssetToStaffRestController.class);

	@Autowired
	PropertyAssignAssetToStaffDao propertyAssignTabToStaffDao;

	/**
	 * returns cost center name drop down value
	 *
	 */
	@RequestMapping(value = "restGetCostCenter", method = { RequestMethod.GET })
	public List<DropDownModel> restGetCostCenter() {
		logger.info("Method : restGetCostCenter starts");

		logger.info("Method : restGetCostCenter ends");
		return propertyAssignTabToStaffDao.getCostCenterList();
	}

	/*
	 * for drop down of property category for staff that is electronics
	 */
	@RequestMapping(value = "getItemCategoryNameForAssignToStaff", method = { RequestMethod.GET })
	public List<DropDownModel> getPropertyCategoryname() {
		logger.info("Method in rest: getItemCategoryNameForAssignToStaff starts");

		logger.info("Method in rest: getItemCategoryNameForAssignToStaff starts");

		return propertyAssignTabToStaffDao.getItemNameStaff();
	}

	/*
	 * for drop down sub category item list
	 */
	@RequestMapping(value = "/assign-asset-to-staff-getSubCategoryItemList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryItemList(
			@RequestParam String proCategoryId) {
		logger.info("Method in rest: getSubCategoryItemList starts");

		logger.info("Method in rest: getSubCategoryItemList ends");

		return propertyAssignTabToStaffDao.getCategoryName(proCategoryId);
	}

	/*
	 * for Drop down item list
	 */

	@RequestMapping(value = "/assign-asset-to-staff-getItemList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemList(@RequestParam String ItemSubCat) {
		logger.info("Method in rest: getItemList starts");

		logger.info("Method in rest: getItemList ends");

		return propertyAssignTabToStaffDao.getItemList(ItemSubCat);
	}

	/**
	 * returns staff name drop down value
	 *
	 */
	@RequestMapping(value = "restGetStaffList", method = { RequestMethod.GET })
	public List<DropDownModel> restGetStaffList() {
		logger.info("Method : restGetStaffList starts");

		logger.info("Method : restGetStaffList ends");
		return propertyAssignTabToStaffDao.getStaffList();
	}

	/**
	 * returns all staff name by cost center dropdown value
	 *
	 */
	@RequestMapping(value = "/restGetUserList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUserNameList(@RequestParam String id) {
		logger.info("Method : getUserNameList starts");

		logger.info("Method : getUserNameList ends");
		return propertyAssignTabToStaffDao.getAllUser(id);
	}

	/**
	 * assign assets to staff
	 *
	 */
	@RequestMapping(value = "assignAssetToStaff", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAssignAssetToStaff(
			@RequestBody List<PropertyAssignAssetToStaffModel> assignAssetToStaff) {
		logger.info("Method : restAssignAssetToStaff for rest controller starts");

		logger.info("Method : restAssignAssetToStaff for rest controller ends");
		return propertyAssignTabToStaffDao.assignNewAssetToStaff(assignAssetToStaff);
	}

	/**
	 * returns all assigned asset to staff
	 *
	 */
	@RequestMapping(value = "/getAllAssignedAssetStaff", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssignAssetToStaffModel>>> getAllAssignedAssetToStaff(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllAssignedAssetToStaff starts");

		logger.info("Method : getAllAssignedAssetToStaff ends");
		return propertyAssignTabToStaffDao.getAllAssignedAssetToStaffDetails(request);
	}

	/**
	 * change the status rest side
	 *
	 */
	@RequestMapping(value = "/changeAssetStatusById", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> changeAssetStatusById(@RequestBody PropertyAssignAssetToStaffModel asignAssetToStaffModel) {
		logger.info("Method : changeAssetStatusById starts");

		logger.info("Method : changeAssetStatusById ends");
		return propertyAssignTabToStaffDao.changeAssetStatusById(asignAssetToStaffModel);
	}

	/**
	 * REST CONTROLLER - Get Item List By AutoSearch
	 *
	 */
	@RequestMapping(value = "/getItemListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<PropertyAssignAssetToStaffModel>>> getItemListByAutoSearch(@RequestParam String id) {
		logger.info("Method : getItemListByAutoSearch starts");

		logger.info("Method : getItemListByAutoSearch ends");
		return propertyAssignTabToStaffDao.getItemListByAutoSearch(id);
	}
	
	/*
	 * for drop down of getAssetLists
	 */
	@RequestMapping(value = "/getAssetListAsignStaff", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAssetList(@RequestParam String item) {
	
		logger.info("Method in rest: getAssetList starts");

		logger.info("Method in rest: getAssetList ends");
		
		return propertyAssignTabToStaffDao.getAssetLists(item);
	}
}
