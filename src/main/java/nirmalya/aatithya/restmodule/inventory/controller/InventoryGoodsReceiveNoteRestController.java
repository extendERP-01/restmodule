/**
 * Inventory GoodsReceiveNote RestController
 */
package nirmalya.aatithya.restmodule.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryGoodsReceiveNoteDao;
import nirmalya.aatithya.restmodule.inventory.model.AdditionalChargesModel;
import nirmalya.aatithya.restmodule.inventory.model.BatchModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryCustomerMailModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryPoDetailsForGrnModel;
import nirmalya.aatithya.restmodule.inventory.model.InventorySearchPurchaseOrderModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryStoreDetailsModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryGoodsReceiveModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class InventoryGoodsReceiveNoteRestController {

	Logger logger = LoggerFactory.getLogger(InventoryGoodsReceiveNoteRestController.class);

	@Autowired
	InventoryGoodsReceiveNoteDao inventoryGoodsReceiveNoteDao;

	@RequestMapping(value = "rest-gets-purchases-orders", method = { RequestMethod.GET })
	public List<DropDownModel> getPurchaseOrderNumber() {
		logger.info("Method : getPurchaseOrderNumber starts");
		logger.info("Method : getPurchaseOrderNumber endss");
		return inventoryGoodsReceiveNoteDao.getPurchaseOrderNumber();
	}

	/*
	 * 
	 * Get mapping for get godown list
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-godown", method = { RequestMethod.GET })
	public List<DropDownModel> getGodownList(@RequestParam String userId) {
		logger.info("Method : getGodownList starts");
		logger.info("Method : getGodownList endss");
		return inventoryGoodsReceiveNoteDao.getGodownList(userId);
	}

	/*
	 * 
	 * Get mapping for get vendor
	 * 
	 * 
	 */
	@RequestMapping(value = "editVendor", method = { RequestMethod.GET })
	public List<DropDownModel> getsVendor(@RequestParam String id) {
		logger.info("Method : getsVendor starts");
		logger.info("Method : getsVendor endss");
		return inventoryGoodsReceiveNoteDao.getsVendor(id);
	}
	
	@RequestMapping(value = "editAdditionalCharges", method = { RequestMethod.GET })
	public List<AdditionalChargesModel> editAdditionalCharges(@RequestParam String id) {
		logger.info("Method : editAdditionalCharges starts");
		logger.info("Method : editAdditionalCharges endss");
		return inventoryGoodsReceiveNoteDao.editAdditionalCharges(id);
	}

	/*
	 * 
	 * Get mapping for get ItemCategory onchange of PurchaseOrder
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-items-categories", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOnchangeItemCategory(@RequestParam String id) {
		logger.info("Method : getOnchangeItemCategory starts");

		logger.info("Method : getOnchangeItemCategory endss");
		return inventoryGoodsReceiveNoteDao.getOnchangeItemCategory(id);
	}

	@RequestMapping(value = "/getGSTAutoSerach", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGSTAutoSerach(@RequestParam String id) {
		logger.info("Method : getGSTAutoSerach starts");

		logger.info("Method : getGSTAutoSerach endss");
		return inventoryGoodsReceiveNoteDao.getGSTAutoSerach(id);
	}

	/*
	 * Rest controller for due date
	 */
	@RequestMapping(value = "/get-due-date", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDueDate(@RequestParam String id,
			@RequestParam String invDate) {
		logger.info("Method : getDueDate starts");

		logger.info("Method : getDueDate endss");
		return inventoryGoodsReceiveNoteDao.getDueDate(id, invDate);
	}
	/*
	 * 
	 * Get mapping for get VendorName onChange of PurchaseOrder
	 * 
	 * 
	 */

	@RequestMapping(value = "/getVendor", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOnchangeVendorName(@RequestParam String id) {
		logger.info("Method : getOnchangeVendorName starts");

		logger.info("Method : getOnchangeVendorName endss");
		return inventoryGoodsReceiveNoteDao.getOnchangeVendorName(id);
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-itemSubCategories", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubItemCategory(@RequestParam String id,
			@RequestParam String gRNPurchaseOrderId) {
		logger.info("Method : getSubItemCategory starts");

		logger.info("Method : getSubItemCategory endss");
		return inventoryGoodsReceiveNoteDao.getItemSubCategory(id, gRNPurchaseOrderId);
	}

	/*
	 * 
	 * Get mapping for get ItemName
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-items-Name", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemName(@RequestParam String id,
			@RequestParam String gRNPurchaseOrderId) {
		logger.info("Method : getItemName starts");

		logger.info("Method : getItemName endss");
		return inventoryGoodsReceiveNoteDao.getItemName(id, gRNPurchaseOrderId);
	}
	/*
	 * 
	 * Get mapping for get Quantity
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-quantity", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getQuantity(@RequestParam String id,
			@RequestParam String gRNPurchaseOrderId) {
		logger.info("Method : getQuantity starts");

		logger.info("Method : getQuantity endss");
		return inventoryGoodsReceiveNoteDao.getQuantity(id, gRNPurchaseOrderId);
	}

	/*
	 * 
	 * post Mapping for listing goodsReceive
	 * 
	 * 
	 */
	@RequestMapping(value = "get-alls-goodsreceives", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getAllGoodsReceive(
			@RequestBody DataTableRequest request) {
		return inventoryGoodsReceiveNoteDao.getAllGoodsReceive(request);
	}

	/*
	 * 
	 * GetMapping for delete goodsREceive
	 * 
	 * 
	 */
	@RequestMapping(value = "/delete-goods-receives-notes", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGoodsReceive(@RequestParam String id,
			@RequestParam String createdBy) {
		return inventoryGoodsReceiveNoteDao.deleteGoodsReceive(id, createdBy);
	}

	/*
	 * 
	 * Get mapping for goods receive note for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "edit-goods-receives-byId", method = { RequestMethod.GET })
	public List<RestInventoryGoodsReceiveModel> editGoodsReceiveById(@RequestParam String id) {
		logger.info("Method : editGoodsReceiveById starts");
		logger.info("Method : editGoodsReceiveById endss");
		return inventoryGoodsReceiveNoteDao.editGoodsReceiveById(id);
	}

	/*
	 * 
	 * Get mapping for get goods receive note for modal view
	 * 
	 * 
	 */
	@RequestMapping(value = "gets-goods-receives-modals", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getGoodsReceiveById(
			@RequestParam String id) {
		logger.info("Method : getGoodsReceiveById starts");
		logger.info("Method : getGoodsReceiveById endss");
		return inventoryGoodsReceiveNoteDao.getGoodsReceiveById(id);
	}

	/*
	 * 
	 * Get mapping for get Invoice Number in DropDown
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-invoices-numbers", method = { RequestMethod.GET })
	public List<DropDownModel> getInvoiceNumber() {
		logger.info("Method : getInvoiceNumber starts");
		logger.info("Method : getInvoiceNumber endss");
		return inventoryGoodsReceiveNoteDao.getInvoiceNumber();
	}

	/*
	 * 
	 * Get mapping for get goods receive note in List
	 * 
	 * 
	 */
	@RequestMapping(value = "list-goods-receives", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> listGoods(@RequestParam("id") String id) {
		logger.info("Method : listGoods starts");
		logger.info("Method : listGoods endss");
		return inventoryGoodsReceiveNoteDao.listGoods(id);
	}

	/*
	 * 
	 * PostMapping for get All list itemRequisition to be Approve
	 * 
	 * 
	 */
	@RequestMapping(value = "/get-all-goods-receive-approve", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getAllGoodsReceiveApprove(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllGoodsReceiveApprove starts");
		logger.info("Method :  getAllGoodsReceiveApprove endss");
		return inventoryGoodsReceiveNoteDao.getAllGoodsReceiveApprove(request);

	}

	/*
	 * 
	 * GetMapping for save-requisition-approval-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-goods-receive-approval-action", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> saveGoodsreceiveApprovalAction(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : saveGoodsreceiveApprovalAction starts");
		logger.info("Method : saveGoodsreceiveApprovalAction endss");
		return inventoryGoodsReceiveNoteDao.saveGoodsreceiveApprovalAction(id, createdBy);
	}

	/*
	 * 
	 * GetMapping for save-requisition-reject-action
	 * 
	 * 
	 */
	@RequestMapping(value = "save-goods-receive-reject-action", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveGoodsreceiveRejectAction(
			@RequestBody RestInventoryGoodsReceiveModel reqobject) {
		logger.info("Method : saveGoodsreceiveRejectAction starts");
		logger.info("Method : saveGoodsreceiveRejectAction endss");
		return inventoryGoodsReceiveNoteDao.saveGoodsreceiveRejectAction(reqobject);
	}

	@RequestMapping(value = "lists-purchases-orders", method = { RequestMethod.GET })
	public List<RestInventoryGoodsReceiveModel> listGoodsDetails(@RequestParam("id") String id,
			@RequestParam("invId") String invId) {
		logger.info("Method : listGoods starts");
		logger.info("Method : listGoods endss");
		return inventoryGoodsReceiveNoteDao.listGoodsDetails(id, invId);
	}

	/*
	 * 
	 * PostMapping for add rest GoodsReceive
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-adds-goods-receives", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> invGoodsReceive(
			@RequestBody List<RestInventoryGoodsReceiveModel> invGoodsReceiveModel) {
		logger.info("Method : invGoodsReceive starts");
		logger.info("Method : invGoodsReceive ends");
		return inventoryGoodsReceiveNoteDao.invGoodsReceive(invGoodsReceiveModel);
	}
	
	@RequestMapping(value = "saveBatchDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveBatchDetails(
			@RequestBody List<BatchModel> batch) {
		logger.info("Method : saveBatchDetails starts");
		logger.info("Method : invGoodsResaveBatchDetailsceive ends");
		return inventoryGoodsReceiveNoteDao.saveBatchDetails(batch);
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "get-subs-categories", method = { RequestMethod.GET })
	public List<DropDownModel> getEditItemSubCategory(@RequestParam String id) {
		logger.info("Method : getItemSubCategory starts");
		logger.info("Method : getItemSubCategory endss");
		return inventoryGoodsReceiveNoteDao.getItemSubCat(id);
	}

	/*
	 * 
	 * Get mapping for get Item Name
	 * 
	 * 
	 */
	@RequestMapping(value = "get-item-Id", method = { RequestMethod.GET })
	public List<DropDownModel> getEditItemNames(@RequestParam String id) {
		logger.info("Method : getItemNames starts");
		logger.info("Method : getItemNames endss");
		return inventoryGoodsReceiveNoteDao.getItemNames(id);
	}

	@RequestMapping(value = "/get-edit-quantity", method = { RequestMethod.GET })
	public List<DropDownModel> getEditQuantities(@RequestParam("id") String id,
			@RequestParam("gRNPurchaseOrderId") String gRNPurchaseOrderId,
			@RequestParam("gRNInvoiceId") String gRNInvoiceId) {

		logger.info("Method : getEditQuantities starts");

		logger.info("Method : getEditQuantities endss");
		return inventoryGoodsReceiveNoteDao.getEditQuantities(id, gRNPurchaseOrderId, gRNInvoiceId);
	}

	/*
	 * 
	 * Get mapping for get pdf list
	 * 
	 * 
	 */
	@RequestMapping(value = "gets-alls-goods-receives-pdfs", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getAllGoodsReceivePdf1(
			@RequestBody DataTableRequest request) {
		return inventoryGoodsReceiveNoteDao.getAllGoodsReceivePdf1(request);
	}

	/*
	 * 
	 * Get mapping for get goods receive note for pdf view in new format
	 * 
	 * 
	 */
	@RequestMapping(value = "gets-goods-receives-news-pdfs", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getGoodsReceiveByIdPdf(
			@RequestParam String id) {
		logger.info("Method : getGoodsReceiveByIdPdf starts");
		logger.info("Method : getGoodsReceiveByIdPdf endss");
		return inventoryGoodsReceiveNoteDao.getGoodsReceiveByIdPdf(id);
	}

	/*
	 * 
	 * Get mapping for get porder by auto search
	 * 
	 * 
	 */
	@RequestMapping(value = "/getPOrderByAutosearch1", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPOrderByAutosearch(@RequestParam String id) {
		logger.info("Method : getPOrderByAutosearch starts");

		logger.info("Method : getPOrderByAutosearch ends");
		return inventoryGoodsReceiveNoteDao.getPOrderByAutosearch(id);
	}

	/*
	 * 
	 * Get mapping for get goods receive note report
	 * 
	 * 
	 */
	@RequestMapping(value = "gets-alls-goods-receives-report", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryGoodsReceiveModel>>> getAllGoodsReceiveReport(
			@RequestBody DataTableRequest request) {
		return inventoryGoodsReceiveNoteDao.getAllGoodsReceiveReport(request);
	}

	/*
	 * 
	 * Get mapping for get porder auto search
	 * 
	 * 
	 */
	@RequestMapping(value = "/getPurchseOrderBySuggestion", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchseOrderByAutosearch(@RequestParam String id) {
		logger.info("Method : getPurchseOrderByAutosearch starts");

		logger.info("Method : getPurchseOrderByAutosearch ends");
		return inventoryGoodsReceiveNoteDao.getPurchseOrderByAutosearch(id);
	}

	/*
	 * 
	 * Get mapping for get porder auto search
	 * 
	 * 
	 */
	@RequestMapping(value = "/getPurchseOrderBySuggests", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchseOrderBySuggests(@RequestParam String id) {
		logger.info("Method : getPurchseOrderBySuggests starts");

		logger.info("Method : getPurchseOrderBySuggests ends");
		return inventoryGoodsReceiveNoteDao.getPurchseOrderBySuggests(id);
	}

	/*
	 * 
	 * Get mapping for get invoice no auto search
	 * 
	 * 
	 */
	@RequestMapping(value = "/getInvoiceBySuggests", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceBySuggests(@RequestParam String id) {
		logger.info("Method : getInvoiceBySuggests starts");

		logger.info("Method : getInvoiceBySuggests ends");
		return inventoryGoodsReceiveNoteDao.getInvoiceBySuggests(id);
	}
	/*
	 * 
	 * Get mapping for get pending quantity onChange of Item name
	 * 
	 * 
	 */

	@RequestMapping(value = "/getPendingQuantity", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPendingQty(@RequestParam String id,
			@RequestParam String gRNPurchaseOrderId) {
		logger.info("Method : getPendingQty starts");

		logger.info("Method : getPendingQty endss");
		return inventoryGoodsReceiveNoteDao.getPendingQty(id, gRNPurchaseOrderId);
	}

	/*
	 * 
	 * Get mapping for get pending quantity for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "/get-edit-pending", method = { RequestMethod.GET })
	public List<DropDownModel> getEditPendings(@RequestParam String id, @RequestParam String gRNPurchaseOrderId,
			@RequestParam String gRNInvoiceId) {

		logger.info("Method : getEditPendings starts");

		logger.info("Method : getEditPendings endss");
		return inventoryGoodsReceiveNoteDao.getEditPendings(id, gRNPurchaseOrderId, gRNInvoiceId);
	}

	/*
	 * 
	 * Get mapping for get price
	 * 
	 * 
	 */
	@RequestMapping(value = "/getPriceCalculate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPriceCalculate(@RequestParam("id") String id,
			@RequestParam("pOrder") String pOrder) {
		logger.info("Method : getPriceCalculate starts");

		logger.info("Method : getPriceCalculate endss");
		return inventoryGoodsReceiveNoteDao.getPriceCalculate(id, pOrder);
	}

	/*
	 * 
	 * Get mapping for edit price
	 * 
	 * 
	 */
	@RequestMapping(value = "/editPrice", method = { RequestMethod.GET })
	public List<DropDownModel> getEditPrices(@RequestParam("id") String id) {

		logger.info("Method : getEditPrice starts");

		logger.info("Method : getEditPrice endss");
		return inventoryGoodsReceiveNoteDao.getEditPrices(id);
	}

	/**
	 * REST CONTROLLER - Get Hotel Logo
	 *
	 */
	@RequestMapping(value = "restLogoImage-goodsReceive", method = { RequestMethod.GET })
	public List<DropDownModel> restGetLogoImageForSpaService(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImageForSpaService starts");

		logger.info("Method : restGetLogoImageForSpaService ends");
		return inventoryGoodsReceiveNoteDao.getHotelLogoForSpaService(logoType);
	}
	/*
	 * Get mapping for get Item Name
	 */

	@RequestMapping(value = "/getItemListByAutoSearchWithPO", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<InventorySearchPurchaseOrderModel>>> getItemListByAutoSearchWithPO(
			@RequestParam String id, @RequestParam String po) {
		logger.info("Method : getItemListByAutoSearchWithPO starts");

		logger.info("Method : getItemListByAutoSearchWithPO endss");
		return inventoryGoodsReceiveNoteDao.getItemListByAutoSearchWithPO(id, po);
	}

	/*
	 * Get mapping for get Item Name
	 */

	@GetMapping(value = "/get-purchase-order-details")
	public ResponseEntity<JsonResponse<List<InventoryPoDetailsForGrnModel>>> getPurchaseOrderDetails(
			@RequestParam String id) {
		logger.info("Method : getPurchaseOrderDetails starts");
		
		logger.info("Method : getPurchaseOrderDetails endss");
		return inventoryGoodsReceiveNoteDao.getPurchaseOrderDetails(id);
	}

	@GetMapping(value = "getStoreDetails" )
	public List<DropDownModel> getStoreDetails(@RequestParam("id") String id) {
		logger.info("Method : getStoreDetails starts");
		logger.info("Method : getStoreDetails endss");
		return inventoryGoodsReceiveNoteDao.getStoreDetailsDao(id); 
	}
	
	/*
	 * for drop down of charge name
	 */
	@RequestMapping(value = "getStoresDetails", method = { RequestMethod.GET })
	public List<InventoryStoreDetailsModel> getVenderDetails(@RequestParam String id) {
		logger.info("Method in rest: getStoresDetails starts");

		logger.info("Method in rest: getStoresDetails ends");
		return inventoryGoodsReceiveNoteDao.getVenderDetails(id);
	}
	
	/*
	 * 
	 * Get mapping for get goods receive note for modal view
	 * 
	 * 
	 */
	@GetMapping(value = "get-details-for-mail")
	public ResponseEntity<JsonResponse<List<InventoryCustomerMailModel>>> getDetailsForMail(
			@RequestParam String id) {
		logger.info("Method : getDetailsForMail starts");
		logger.info("Method : getDetailsForMail endss");
		return inventoryGoodsReceiveNoteDao.getPurchaseOrderDetails1(id);
	}
	
	@PostMapping(value = "editViewBatchDetails")
	public ResponseEntity<JsonResponse<List<BatchModel>>> editViewBatchDetails(
			@RequestBody BatchModel id) {
		logger.info("Method : editViewBatchDetails starts");
		logger.info("Method : editViewBatchDetails endss");
		return inventoryGoodsReceiveNoteDao.editViewBatchDetails(id);
	}
	
	@GetMapping(value = "restGetSequenceNumber")
	public List<DropDownModel> getSequenceNumber(@RequestParam String id,@RequestParam String grn,@RequestParam String item) {
		logger.info("Method : getSequenceNumber starts");
		logger.info("Method : getSequenceNumber endss");
		return inventoryGoodsReceiveNoteDao.getSequenceNumber(id,grn,item);
	}
	
}