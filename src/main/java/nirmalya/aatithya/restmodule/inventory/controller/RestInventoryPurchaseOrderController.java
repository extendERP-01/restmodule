/*
 * 
 * Class Define Rest PurchaseOrder Entity
 * 
 */

package nirmalya.aatithya.restmodule.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryPurchaseOrderDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryDataForDblValModel;
import nirmalya.aatithya.restmodule.inventory.model.InventorySearchPurchaseOrderModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryPurchaseOrderModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory/" })
public class RestInventoryPurchaseOrderController {
	Logger logger = LoggerFactory.getLogger(RestInventoryPurchaseOrderController.class);
	@Autowired
	InventoryPurchaseOrderDao purchaseOrderDao;

	/*
	 * 
	 * Get mapping for get ItemCategory for PurchaseOrder
	 * 
	 * 
	 */
	@RequestMapping(value = "get-pOrder-itemCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getPItemCategory() {
		logger.info("Method : getPItemCategory starts");
		logger.info("Method : getPItemCategory endss");
		return purchaseOrderDao.getPItemCategory();
	}

	@RequestMapping(value = "getPOrderStoreList", method = { RequestMethod.GET })
	public List<DropDownModel> getPOrderStoreList(@RequestParam String id) {
		logger.info("Method : getPOrderStoreList starts");

		logger.info("Method : getPOrderStoreList endss");
		return purchaseOrderDao.getPOrderStoreList(id);
	}

	/*
	 * 
	 * getCategoryEdit
	 * 
	 */
	@RequestMapping(value = "getCategoryEdit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCategoryEdit(String getCategoryEdit) {
		logger.info("Method : getCategoryEdit starts");
		logger.info("Method : getCategoryEdit ends");
		return purchaseOrderDao.getCategoryEdit("getCategoryEdit");
	}

	/*
	 * 
	 * getItemList
	 * 
	 */
	@RequestMapping(value = "getItemList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemList(String getItemList) {
		logger.info("Method : getItemList starts");
		logger.info("Method : getItemList ends");
		return purchaseOrderDao.getItemList("getItemList");
	}

	/*
	 * 
	 * Get mapping for get vendor list for PurchaseOrder
	 * 
	 * 
	 */
	@RequestMapping(value = "get-vendorList", method = { RequestMethod.GET })
	public List<DropDownModel> vendorList() {
		logger.info("Method : vendorList starts");
		logger.info("Method : vendorList endss");
		return purchaseOrderDao.vendorList();
	}
	/*
	 * 
	 * Get mapping for get ItemSubCategory for PurchaseOrder
	 * 
	 * 
	 */

	@RequestMapping(value = "get-pitemSubCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPSubItemCategory(@RequestParam String id) {
		logger.info("Method : getSubItemCategory starts");

		logger.info("Method : getSubItemCategory endss");
		return purchaseOrderDao.getPItemSubCategory(id);
	}

	/*
	 * 
	 * Get mapping for get ItemName for PurchaseOrder
	 * 
	 * 
	 */

	@RequestMapping(value = "get-pItemName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getpurItemName(@RequestParam String id) {
		logger.info("Method : getItemName starts");

		logger.info("Method : getItemName endss");
		return purchaseOrderDao.getpItemName(id);
	}

	/*
	 * 
	 * Get mapping for get Vendor Name for PurchaseOrder
	 * 
	 * 
	 */

	@RequestMapping(value = "get-pVendorName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getpurVendorName(@RequestParam String id) {
		logger.info("Method : getpurVendorName starts");

		logger.info("Method : getpurVendorName endss");
		return purchaseOrderDao.getpVendorName(id);
	}

	/*
	 * 
	 * Get mapping for getSelectedCat for PurchaseOrder
	 * 
	 * 
	 */

	@RequestMapping(value = "getSelectedCat", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSelectedCat(@RequestParam String id) {
		logger.info("Method : getSelectedCat starts");

		logger.info("Method : getSelectedCat endss");
		return purchaseOrderDao.getSelectedCat(id);
	}

	/*
	 * 
	 * Get mapping for PurchaseOrder
	 * 
	 * 
	 */
	@RequestMapping(value = "get-purchaseOrder", method = { RequestMethod.GET })
	public List<DropDownModel> getPurchaseOrder() {
		logger.info("Method : getPurchaseOrder starts");
		logger.info("Method : getPurchaseOrder endss");
		return purchaseOrderDao.getPurchaseOrder();
	}

	/*
	 * 
	 * PostMapping for add PurchaseOrder
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addpurchase-order", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPurchaseOrder(
			@RequestBody List<RestInventoryPurchaseOrderModel> restPurchaseOrderModel) {
		logger.info("Method : addItemRequisition starts");
		logger.info("Method : addItemRequisition ends");
		return purchaseOrderDao.addPurchaseOrder(restPurchaseOrderModel);
	}

	/*
	 * 
	 * PostMapping for Edit PurchaseOrder
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-update-purchase-order", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> updatePurchaseOrder(
			@RequestBody List<RestInventoryPurchaseOrderModel> restPurchaseOrderModel) {
		logger.info("Method : updatePurchaseOrder starts");
		logger.info("Method : updatePurchaseOrder ends");
		return purchaseOrderDao.updatePurchaseOrder(restPurchaseOrderModel);
	}

	/*
	 * 
	 * PostMapping for get All Purchase Order get-approve-purchase-order
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-purchase-order", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getAllPurchaseOrder(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllPurchaseOrder starts");
		logger.info("Method : getAllPurchaseOrder endss");
		return purchaseOrderDao.getAllPurchaseOrder(request);
	}

	/*
	 * 
	 * Get mapping for get one PurchaseOrder for model view
	 * 
	 * 
	 */
	@RequestMapping(value = "get-purchaseOrder-forModel", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getPurchaseOrderForModel(
			@RequestParam("id") String id) {
		logger.info("Method : getPurchaseOrderForModel starts");
		logger.info("Method : getPurchaseOrderForModel endss");
		return purchaseOrderDao.getPurchaseOrderForModel(id);
	}

	/*
	 * 
	 * GetMapping for delete PurchaseOrder
	 * 
	 * 
	 */

	@RequestMapping(value = "/delete-purchase-order", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePurchaseOrder(@RequestParam("id") String id) {
		logger.info("Method : deletePurchaseOrder starts");
		logger.info("Method : deletePurchaseOrder ends");
		return purchaseOrderDao.deletePurchaseOrder(id);
	}

	/*
	 * 
	 * Get mapping for get One PurchaseOrder for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "edit-purchase-order-byId", method = { RequestMethod.GET })
	public List<RestInventoryPurchaseOrderModel> editPurchaseOrderById(@RequestParam("id") String id) {
		logger.info("Method : editPurchaseOrderById starts");
		logger.info("Method : editPurchaseOrderById endss");
		return purchaseOrderDao.editPurchaseOrderById(id);
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory for edit
	 * 
	 * 
	 */

	@RequestMapping(value = "get-edit-porder-SubCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getPurchaseItemSubCategory(@RequestParam String id) {
		logger.info("Method : getPurchaseItemSubCategory starts");
		logger.info("Method : getPurchaseItemSubCategory endss");
		return purchaseOrderDao.getPurchaseItemSubCategory(id);
	}

	/*
	 * 
	 * Get mapping for get ItemName for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-porder-itemName", method = { RequestMethod.GET })
	public List<DropDownModel> getPurchaseItemName(@RequestParam String id) {
		logger.info("Method : getPurchaseItemName starts");
		logger.info("Method : getPurchaseItemName endss");
		return purchaseOrderDao.getPurchaseItemName(id);
	}

	/*
	 * 
	 * Get mapping for get VendorName for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-porder-vendorName", method = { RequestMethod.GET })
	public List<DropDownModel> getPurchaseVendorName(@RequestParam String id) {
		logger.info("Method : getPurchaseVendorName starts");
		logger.info("Method : getPurchaseVendorName endss");
		return purchaseOrderDao.getPurchaseVendorName(id);
	}

	/*
	 * 
	 * PostMapping for get All Purchase Order Pdf
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-purchase-orderPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getAllPurchaseOrderPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllPurchaseOrder starts");
		logger.info("Method : getAllPurchaseOrder endss");
		return purchaseOrderDao.getAllPurchaseOrderPdf(request);
	}

	/*
	 * 
	 * PostMapping for Purchase Order Details Pdf
	 * 
	 * 
	 */
	@RequestMapping(value = "get-purchase-order-report-Pdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getPurchaseOrderDetailsPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getPurchaseOrderDetailsPdf starts");

		System.out.println("Purchase order id is in rest Controller------------" + request.getParam1());
		logger.info("Method : getPurchaseOrderDetailsPdf endss");
		return purchaseOrderDao.getPurchaseOrderDetailsPdf(request);
	}

	/*
	 * returns all Purchase Order Excel
	 *
	 */
	@RequestMapping(value = "get-all-purchase-order-excel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> getAllPurchaseOrderDownload(
			@RequestBody DataTableRequest request) {
		return purchaseOrderDao.getAllPurchaseOrderDownload(request);
	}

	/*
	 * 
	 * Get MinStock for selecting item
	 * 
	 * 
	 */

	@RequestMapping(value = "getMinStock", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<InventoryDataForDblValModel>>> getMinStock(@RequestParam String id ,@RequestParam String store) {
		logger.info("Method : getMinStock starts");

		logger.info("Method : getMinStock endss");
		return purchaseOrderDao.getMinStock(id ,store);
	}

	/*
	 * Get mapping for get Item Name
	 */

	@GetMapping(value = "/getItemListByAutoSearchWithCategory")
	public ResponseEntity<JsonResponse<List<InventorySearchPurchaseOrderModel>>> getItemListByAutoSearchWithCategory(
			@RequestParam String id, @RequestParam String vendorId) {
		logger.info("Method : getItemListByAutoSearchWithCategory starts");

		logger.info("Method : getItemListByAutoSearchWithCategory endss");
		return purchaseOrderDao.getItemListByAutoSearchWithCategory(id, vendorId);
	}
	/*
	 * 
	 * Get MinStock for selecting item
	 * 
	 * 
	 */

	@RequestMapping(value = "getTotalPrice", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<InventoryDataForDblValModel>> getTotalPrice(@RequestParam String itemId,
			@RequestParam String vendor) {
		logger.info("Method : getTotalPrice starts");

		logger.info("Method : getTotalPrice endss");
		return purchaseOrderDao.getTotalPrice(itemId, vendor);
	}

	/*
	 * 
	 * PostMapping for get All Purchase Order
	 * 
	 * 
	 */
	@RequestMapping(value = "get-approve-purchase-order", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryPurchaseOrderModel>>> approvePurchaseOrder(
			@RequestBody DataTableRequest request) {
		logger.info("Method : approvePurchaseOrder starts");
		logger.info("Method : approvePurchaseOrder endss");
		return purchaseOrderDao.approvePurchaseOrder(request);
	}

	/*
	 * 
	 * GetMapping for save-requisition-approval-action
	 * 
	 * 
	 */
	@RequestMapping(value = "forwardPurchase", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> forwardPurchase(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : forwardPurchase starts");
		logger.info("Method : forwardPurchase endss");
		return purchaseOrderDao.forwardPurchase(id, createdBy);
	}

	/*
	 * 
	 * GetMapping for save-requisition-reject-action
	 * 
	 * 
	 */
	@RequestMapping(value = "rejectPurchase", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> rejectPurchase(@RequestBody RestInventoryPurchaseOrderModel reqobject) {
		logger.info("Method : rejectPurchase starts");
		logger.info("Method : rejectPurchase endss");
		return purchaseOrderDao.rejectPurchase(reqobject);
	}
	
	@RequestMapping(value = "getVendorEMailIdByPO", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorEMailIdByPO(@RequestParam String id) {
		logger.info("Method : getVendorEMailIdByPO starts");
		logger.info("Method : getVendorEMailIdByPO endss");
		return purchaseOrderDao.getVendorEMailIdByPO(id);
	}
}
