/**
 * Class define model for itemRequisition Entity
 */
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
import nirmalya.aatithya.restmodule.inventory.dao.InventoryItemRequisitionDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryItemModel;
import nirmalya.aatithya.restmodule.inventory.model.RestItemRequisitonModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class RestInventoryItemRequisitionController {
	Logger logger = LoggerFactory.getLogger(RestInventoryItemRequisitionController.class);
	@Autowired
	InventoryItemRequisitionDao itemRequisitionDao;

	/*
	 * Get mapping for get Item Name
	 */

	@RequestMapping(value = "/getItemListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getItemName(@RequestParam String id) {
		logger.info("Method : getItemName starts");

		logger.info("Method : getItemName endss");
		return itemRequisitionDao.getItemName(id);
	}
	/*
	 * 
	 * Get mapping for get CostCenter
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-cost-center", method = { RequestMethod.GET })
	public List<DropDownModel> getCostCenter() {
		logger.info("Method : getCostCenter starts");
		logger.info("Method : getCostCenter endss");
		return itemRequisitionDao.getCostCenter();
	}
	/*
	 * 
	 * Get mapping for get Store
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-store", method = { RequestMethod.GET })
	public List<DropDownModel> getStore(@RequestParam("id") String id) {
		logger.info("Method : getStore starts");
		logger.info("Method : getStore endss");
		return itemRequisitionDao.getStore(id);
	}
	
	/*
	 * 
	 * method for Auto Search of Requisition Number
	 */
	@RequestMapping(value = "/view-item-req-getRequisitionNo", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getRequisitionNumberAutocompleteList(
			@RequestParam String id) {
		logger.info("Method : getRequisitionNumberAutocompleteList starts");

		logger.info("Method : getRequisitionNumberAutocompleteList ends");
		return itemRequisitionDao.getRequisitionNumberAutocompleteList(id);
	}

	/*
	 * 
	 * method for Auto Search of Requisition Number
	 * view-item-req-generateRequisitionNo
	 */
	@RequestMapping(value = "/view-item-req-generateRequisitionNo", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> generateRequisitionNumber(@RequestParam String id) {
		logger.info("Method : generateRequisitionNumber starts");

		logger.info("Method : generateRequisitionNumber ends");
		return itemRequisitionDao.generateRequisitionNumber(id);
	}

	/*
	 * 
	 * Get mapping for get Requisition Type
	 * 
	 * 
	 */
	@RequestMapping(value = "get-requisitionType", method = { RequestMethod.GET })
	public List<DropDownModel> getRequisitionType() {
		logger.info("Method : getRequisitionType starts");
		logger.info("Method : getRequisitionType endss");
		return itemRequisitionDao.getRequisitionType();
	}

	/*
	 * 
	 * PostMapping for add rest ItemRequisition
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addNew-item-requisition", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> userLaundryItemService(
			@RequestBody List<RestItemRequisitonModel> restItemRequisitonModel) {
		logger.info("Method : addItemRequisition starts");
		logger.info("Method : addItemRequisition ends");
		return itemRequisitionDao.addItemRequisition(restItemRequisitonModel);
	}

	/*
	 * 
	 * PostMapping for get All list itemRequisition to be Approve
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-Item-requsitions-approve", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getAllRequisitionsApprove(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllRequisitionsApprove starts");
		logger.info("Method :  getAllRequisitionsApprove endss");
		return itemRequisitionDao.getAllRequisitionsApprove(request);
	}

	/*
	 * 
	 * GetMapping for save-requisition-approval-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-requisition-approval-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> saveRequisitionApprovalAction(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : saveRequisitionApprovalAction starts");
		logger.info("Method : saveRequisitionApprovalAction endss");
		return itemRequisitionDao.saveRequisitionApprovalAction(id, createdBy);
	}

	/*
	 * 
	 * GetMapping for save-requisition-reject-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-requisition-reject-action", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveRequisitionRejectAction(
			@RequestBody RestItemRequisitonModel reqobject) {
		logger.info("Method : saveRequisitionRejectAction starts");
		logger.info("Method : saveRequisitionRejectAction endss");
		return itemRequisitionDao.saveRequisitionRejectAction(reqobject);
	}

	/*
	 * 
	 * PostMapping for get All ItemRequisition
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-Item-requsitions", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getAllRequisitions(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllRequisitions starts");
		logger.info("Method :  getAllRequisitions endss");
		return itemRequisitionDao.getAllRequisitions(request);
	}

	/*
	 * 
	 * Get mapping for get One ItemRequisition for model view
	 * 
	 * 
	 */
	@RequestMapping(value = "/getRequisitionById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getItemRequisitionById(
			@RequestParam("id") String id) {
		logger.info("Method : getGuestLaundryServiceById for rest controller starts");
		logger.info("Method : getItemRequisitionById for rest controller ends");
		return itemRequisitionDao.getItemRequisitionById(id);
	}

	/*
	 * 
	 * GetMapping for delete ItemRequisition
	 * 
	 * 
	 */
	@RequestMapping(value = "delete-requisition", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteRequisition(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteRequisition starts");
		logger.info("Method : deleteRequisition endss");
		return itemRequisitionDao.deleteRequisition(id, createdBy);
	}
	/*
	 * 
	 * Get mapping for get One ItemRequisition for edit
	 * 
	 * 
	 */

	@RequestMapping(value = "edit-itemRequisition-byId", method = { RequestMethod.GET })
	public List<RestItemRequisitonModel> editRequisitionById(@RequestParam("id") String id) {
		logger.info("Method : editRequisitionById starts");
		logger.info("Method : editRequisitionById endss");
		return itemRequisitionDao.editItemRequisitionById(id);
	}

	/*
	 * GetMapping for get Sub Category
	 * 
	 * 
	 */
	@RequestMapping(value = "getSubCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getItemSubCategory(@RequestParam String id) {
		logger.info("Method : getItemSubCategory starts");
		logger.info("Method : getItemSubCategory endss");
		return itemRequisitionDao.getItemSubCat(id);
	}

	/*
	 * GetMapping for get item Name
	 * 
	 * 
	 */
	@RequestMapping(value = "getItemName", method = { RequestMethod.GET })
	public List<DropDownModel> getEditItemName(@RequestParam String id) {
		logger.info("Method : getItemName starts");
		logger.info("Method : getItemName endss");
		return itemRequisitionDao.getEditItemName(id);
	}

	/*
	 * 
	 * PostMapping for get All ItemRequisition Pdf
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-Item-requsitionsPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getAllRequisitionsPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllRequisitionsPdf starts");
		logger.info("Method :  getAllRequisitionsPdf endss");
		return itemRequisitionDao.getAllRequisitionsPdf(request);
	}

	/*
	 * 
	 * PostMapping for get All ItemRequisition generate Report
	 * 
	 * 
	 */
	@RequestMapping(value = "generate-all-Item-requsitionsPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> generateAllRequisitionsPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  generateAllRequisitionsPdf starts");
		logger.info("Method :  generateAllRequisitionsPdf endss");
		return itemRequisitionDao.generateAllRequisitionsPdf(request);
	}

	/*
	 * 
	 * Get mapping for get One ItemRequisition for pdf
	 * 
	 * 
	 */
	@RequestMapping(value = "getRequisitionPdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getItemRequisitionPdf(
			@RequestParam("id") String id) {
		logger.info("Method : getItemRequisitionPdf for rest controller starts");
		logger.info("Method : getItemRequisitionPdf for rest controller ends");
		return itemRequisitionDao.getItemRequisitionPdf(id);
	}

	/*
	 * returns all Item Requisition Excel
	 *
	 */
	@RequestMapping(value = "get-all-item-requisition-excel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestItemRequisitonModel>>> getAllItemRequisitionDownload(
			@RequestBody DataTableRequest request) {
		return itemRequisitionDao.getAllItemRequisitionDownload(request);
	}

	/*
	 * 
	 * Get mapping for get accountGroup rest-getSubAccountGroup
	 * 
	 * 
	 */
	@RequestMapping(value = "get-item-type", method = { RequestMethod.GET })
	public List<DropDownModel> getItemListType() {
		logger.info("Method : getItemType starts");
		logger.info("Method : getItemType endss");
		return itemRequisitionDao.getItemListType();
	}

	/*
	 * 
	 * Get mapping for get ItemCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "get-item-category", method = { RequestMethod.GET })
	public List<DropDownModel> restGetItemCategory() {
		logger.info("Method : restGetItemCategory starts");
		logger.info("Method : restGetItemCategory endss");
		return itemRequisitionDao.restGetItemCategory();
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-item-subCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetSubItemCategory(@RequestParam String id) {
		logger.info("Method : restGetSubItemCategory starts");

		logger.info("Method : restGetSubItemCategory endss");
		return itemRequisitionDao.restGetSubItemCategory(id);
	}
	/*
	 * 
	 * Get mapping for get PurchaseSubGroup
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-purchaseSubGroup", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetPurchaseSubGroup(@RequestParam String id) {
		logger.info("Method : restGetPurchaseSubGroup starts");

		logger.info("Method : restGetPurchaseSubGroup endss");
		return itemRequisitionDao.restGetPurchaseSubGroup(id);
	}
	/*
	 * 
	 * Get mapping for get SalesSubGroup
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-salesSubGroup", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetSalesSubGroup(@RequestParam String id) {
		logger.info("Method : restGetSalesSubGroup starts");

		logger.info("Method : restGetSalesSubGroup endss");
		return itemRequisitionDao.restGetSalesSubGroup(id);
	}

	/*
	 * 
	 * Get mapping for get getServeType
	 * 
	 * 
	 */
	@RequestMapping(value = "get-serveType", method = { RequestMethod.GET })
	public List<DropDownModel> restGetServeType() {
		logger.info("Method : restGetServeType starts");
		logger.info("Method : restGetServeType endss");
		return itemRequisitionDao.restGetServeType();
	}

	/*
	 * 
	 * Get mapping for get getServiceType
	 * 
	 * 
	 */
	@RequestMapping(value = "get-serviceType", method = { RequestMethod.GET })
	public List<DropDownModel> restGetServiceType() {
		logger.info("Method : restGetServiceType starts");
		logger.info("Method : restGetServiceType endss");
		return itemRequisitionDao.restGetServiceType();
	}

	/*
	 * 
	 * Get mapping for get getSacCode
	 * 
	 * 
	 */
	@RequestMapping(value = "get-sacCode", method = { RequestMethod.GET })
	public List<DropDownModel> restGetSacCode() {
		logger.info("Method : restGetSacCode starts");
		logger.info("Method : restGetSacCode endss");
		return itemRequisitionDao.restGetSacCode();
	}
	/*
	 * 
	 * PostMapping for add rest Items
	 * 
	 * 
	 */
	@RequestMapping(value = "add-newItem", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addNewItem(@RequestBody RestInventoryItemModel restItemModel) {
		logger.info("Method : restAddNewItem starts");
		logger.info("Method : restAddNewItem ends");
		return itemRequisitionDao.addNewItem(restItemModel);
	}

}
