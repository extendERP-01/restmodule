package nirmalya.aatithya.restmodule.inventory.controller;

import java.util.List;
import java.util.Map;
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
import nirmalya.aatithya.restmodule.inventory.dao.InventoryGoodsReturnDao;
import nirmalya.aatithya.restmodule.inventory.model.GRNReturnListModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryGoodsReturnsNoteModel;

/**
 * @author NirmalyaLabs
 *
 */

@RestController
@RequestMapping(value = "inventory")
public class InventoryGoodsReturnRestController {
	Logger logger = LoggerFactory.getLogger(InventoryGoodsReturnRestController.class);
	@Autowired
	InventoryGoodsReturnDao inventoryGoodsReturnDao;

	/**
	 * get mapping for drop down purchase order
	 */

	@RequestMapping(value = "/rest-get-purchase-order", method = { RequestMethod.GET })
	public List<DropDownModel> getpurchaseOrder() {
		logger.info("Method : getpurchaseOrder starts");
		logger.info("Method : getpurchaseOrder ends");
		return inventoryGoodsReturnDao.getpurchaseOrder();
	}

	/**
	 * get mapping for drop down invoice Number
	 */

	@RequestMapping(value = "/rest-get-invoice-number", method = { RequestMethod.GET })
	public List<DropDownModel> getinvoiceNumber() {
		logger.info("Method : getinvoiceNumber starts");
		logger.info("Method : getinvoiceNumber ends");
		return inventoryGoodsReturnDao.getInvoiceNumber();
	}

	// for get invoice onchange of purchase order for edit 
	
	@RequestMapping(value = "restGetINV", method = { RequestMethod.GET })
	public List<DropDownModel> restGetINV(@RequestParam String id) {
		logger.info("Method : restGetINV starts");

		logger.info("Method : restGetINV ends");
		return inventoryGoodsReturnDao.getInv(id);
	}
/*
 * 
 * get item category 
 */
	@RequestMapping(value = "rest-get-inv-itemCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getItemsCategories(@RequestParam String id) {
		logger.info("Method : getItemCategory starts");
		logger.info("Method : getItemCategory endss");
		return inventoryGoodsReturnDao.getItemCategory(id);
	}
	/*
	 * 
	 * Get mapping for get Item name
	 * 
	 * 
	 */

	@RequestMapping(value = "get-GRN-itemName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getsItemsNamesGReturn(@RequestParam String id,
			@RequestParam String gRNInvoiceId) {
		logger.info("Method : getsItemsNames starts");

		logger.info("Method : getsItemsNames endss");
		return inventoryGoodsReturnDao.getsItemsNames(id, gRNInvoiceId);
	}
	/*
	 * 
	 * Get mapping for get invoice no 
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-invoiceId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceId(@RequestParam String id,@RequestParam String gRNInvoiceId) {
		logger.info("Method : getInvoiceId starts");
		logger.info("Method : getInvoiceId endss");
		return inventoryGoodsReturnDao.getInvoiceId(id,gRNInvoiceId);
	}
	
	@RequestMapping(value = "/restGetGRNDetailsForReturn", method = { RequestMethod.GET })
	public List<GRNReturnListModel> restGetGRNDetailsForReturn(@RequestParam String id,@RequestParam String grn) {
		logger.info("Method : restGetGRNDetailsForReturn starts");
		logger.info("Method : restGetGRNDetailsForReturn endss");
		return inventoryGoodsReturnDao.getGRNDetailsForReturn(id,grn);
	}
	

	/*
	 * 
	 * Get mapping for get all goods receive list
	 * 
	 * 
	 */

	@RequestMapping(value = "get-allList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<GRNReturnListModel>>> getAllList(@RequestParam String id) {
		logger.info("Method : getAllList starts");
		logger.info("Method : getAllList endss");
		return inventoryGoodsReturnDao.getAllList(id);
	}

	/*
	 * 
	 * PostMapping for add rest goods return note
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addNew-goods-returnnote", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addGoodsreturnsnote(
			@RequestBody List<InventoryGoodsReturnsNoteModel> inventoryGoodsReturnsNoteModel) {
		logger.info("Method : addGoodsreturnnote starts");
		logger.info("Method : addGoodsreturnnote ends");
		return inventoryGoodsReturnDao.addGoodsreturnsnote(inventoryGoodsReturnsNoteModel);
	}

	/*
	 * 
	 * PostMapping for view All goods return
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-goodsreturn", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getAllGoodsreturn(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllGoodsreturn starts");
		logger.info("Method :  getAllGoodsreturn endss");
		return inventoryGoodsReturnDao.getAllGoodsreturn(request);
	}

	/*
	 * 
	 * PostMapping for view pdf
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-goodsreturn-pdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getAllGoodsreturnpdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllGoodsreturnpdf starts");
		logger.info("Method :  getAllGoodsreturnpdf endss");
		return inventoryGoodsReturnDao.getAllGoodsreturnpdf(request);
	}

	/*
	 * 
	 * GetMapping for delete goods return
	 * 
	 * 
	 */
	@RequestMapping(value = "delete-goodsreturn", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGoodsreturn(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteGoodsreturn starts");
		logger.info("Method : deleteGoodsreturn endss");
		return inventoryGoodsReturnDao.deleteGoodsreturn(id, createdBy);
	}

	/*
	 * 
	 * Get mapping for goods return note for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "edit-goodsreturn-byId", method = { RequestMethod.GET })
	public List<InventoryGoodsReturnsNoteModel> editGoodsReturnById(@RequestParam String id) {
		logger.info("Method : editGoodsReturnById starts");
		logger.info("Method : editGoodsReturnById endss");
		return inventoryGoodsReturnDao.editGoodsReturnById(id);
	}
	
	@RequestMapping(value = "editGetStoreListByInv", method = { RequestMethod.GET })
	public List<DropDownModel> editGetStoreListByInv(@RequestParam String id) {
		logger.info("Method : editGetStoreListByInv starts");
		logger.info("Method : editGetStoreListByInv endss");
		return inventoryGoodsReturnDao.editGetStoreListByInv(id);
	}

	


	/*
	 * 
	 * Get mapping for get goods return note for model view
	 * 
	 * 
	 */

	@RequestMapping(value = "get-goodsreturn-modal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getGoodsreturnById(
			@RequestParam String id) {
		logger.info("Method : getGoodsreturnById starts");
		logger.info("Method : getGoodsreturnById endss");
		return inventoryGoodsReturnDao.getModalGoodsreturn(id);
	}
	/*
	 * 
	 * Get mapping for get goods return note for pdf
	 * 
	 * 
	 */

	@RequestMapping(value = "get-goodsreturn-modal-pdf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getGoodsreturnByPdf(
			@RequestParam String id) {
		logger.info("Method : getGoodsreturnByPdf starts");
		logger.info("Method : getGoodsreturnByPdf endss");
		return inventoryGoodsReturnDao.getGoodsreturnByPdf(id);
	}
	/*
	 * 
	 * Get mapping for get sub category
	 * 
	 * 
	 */
	@RequestMapping(value = "get-GRN-itemSubCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllSubCatList(@RequestParam String id,
			@RequestParam String gRNInvoiceId) {
		logger.info("Method : getAllSubCatList starts");

		logger.info("Method : getAllSubCatList endss");
		return inventoryGoodsReturnDao.getItemSubCategory(id, gRNInvoiceId);
	}
	/*
	 * 
	 * Get mapping for get sub category for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "getinvSubCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getSubcategoriess(@RequestParam String id) {
		logger.info("Method : getItemNames starts");
		logger.info("Method : getItemNames endss");
		return inventoryGoodsReturnDao.getSubcategoriess(id);
	}
	/*
	 * 
	 * Get mapping for get sub category for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "getinvItemId", method = { RequestMethod.GET })
	public List<DropDownModel> getItemNames(@RequestParam String id) {
		logger.info("Method : getItemNames starts");
		logger.info("Method : getItemNames endss");
		return inventoryGoodsReturnDao.getItemNames(id);
	}
	/*
	 * 
	 * Get mapping for get porder list
	 * 
	 * 
	 */
	@RequestMapping(value = "list-purchase-order", method = { RequestMethod.GET })
	public List<InventoryGoodsReturnsNoteModel> listGoodsDetails(@RequestParam String id) {
		logger.info("Method : listGoods starts");
		logger.info("Method : listGoods endss");
		return inventoryGoodsReturnDao.listGoodsDetails(id);
	}
	/*
	 * 
	 * Get mapping for get itgem category
	 * 
	 * 
	 */
	@RequestMapping(value = "get-itemCategry", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemCategry(@RequestParam String id) {
		logger.info("Method : getItemCategry starts");

		logger.info("Method : getItemCategry endss");
		return inventoryGoodsReturnDao.getItemCategry(id);
	}
	/*
	 * 
	 * Get mapping for get price list
	 * 
	 * 
	 */
	@RequestMapping(value = "calculateItemPrice", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> calculateItemPrice(
			@RequestBody Map<String, String> invService) {
		logger.info("Method : calculateItemPrice for rest controller starts");

		logger.info("Method : calculateItemPrice for rest controller ends");
		return inventoryGoodsReturnDao.calculateLItemPrice(invService);

	}

	/*
	 * 
	 * Get mapping for get Quantity
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-all-quantities", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAllQuantity(@RequestParam String id,
			@RequestParam String gRNInvoiceId) {
		logger.info("Method : getAllQuantity starts");

		logger.info("Method : getAllQuantity endss");
		return inventoryGoodsReturnDao.getAllQuantity(id, gRNInvoiceId);
	}

	// for report
	@RequestMapping(value = "get-all-goodsreturn-report", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getAllGoodsreturnReport(
			@RequestBody DataTableRequest request) {
		logger.info("Method :  getAllGoodsreturnReport starts");
		logger.info("Method :  getAllGoodsreturnReport endss");
		return inventoryGoodsReturnDao.getAllGoodsreturnReport(request);
	}
	/*
	 * 
	 * Get mapping for get porder auto sxearch
	 * 
	 * 
	 */
	@RequestMapping(value = "/getPurchaseOrderByAutosearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchseOrderByAutosearch(@RequestParam String id) {
		logger.info("Method : getPurchseOrderByAutosearch starts");

		logger.info("Method : getPurchseOrderByAutosearch ends");
		return inventoryGoodsReturnDao.getPurchseOrderByAutosearch(id);
	}
	/*
	 * 
	 * Get mapping for get porder list
	 * 
	 * 
	 */
	@RequestMapping(value = "/getPurchaseOrderByAutosuggest", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseOrderByAutosuggest(@RequestParam String id) {
		logger.info("Method : getPurchaseOrderByAutosuggest starts");

		logger.info("Method : getPurchaseOrderByAutosuggest ends");
		return inventoryGoodsReturnDao.getPurchaseOrderByAutosuggest(id);
	}
	
	
	
	@RequestMapping(value = "/getPurchaseOrderByPdfLists", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseOrderByPdfLists(@RequestParam String id) {
		logger.info("Method : getPurchaseOrderByPdfLists starts");

		logger.info("Method : getPurchaseOrderByPdfLists ends");
		return inventoryGoodsReturnDao.getPurchaseOrderByPdfLists(id);
	}
	
	
	
	@RequestMapping(value = "/getPurchaseOrderSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseOrderSearch(@RequestParam String id) {
		logger.info("Method : getPurchaseOrderSearch starts");

		logger.info("Method : getPurchaseOrderSearch ends");
		return inventoryGoodsReturnDao.getPurchaseOrderSearch(id);
	}
	
	
	
	@RequestMapping(value = "/getInvoiceNumberSuggestList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceNumberSuggestLists(@RequestParam String id) {
		logger.info("Method : getInvoiceNumberSuggestLists starts");

		logger.info("Method : getInvoiceNumberSuggestLists ends");
		return inventoryGoodsReturnDao.getInvoiceNumberSuggestLists(id);
	}
	
	
	@RequestMapping(value = "/getInvoiceNumberSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceNumberSearch(@RequestParam String id) {
		logger.info("Method : getInvoiceNumberSearch starts");

		logger.info("Method : getInvoiceNumberSearch ends");
		return inventoryGoodsReturnDao.getInvoiceNumberSearch(id);
	}
	
	
	@RequestMapping(value = "/getInvoiceNumberSuggestionList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceNumberSuggestionLists(@RequestParam String id) {
		logger.info("Method : getInvoiceNumberSuggestionLists starts");

		logger.info("Method : getInvoiceNumberSuggestionLists ends");
		return inventoryGoodsReturnDao.getInvoiceNumberSuggestLists(id);
	}
	
	
	@RequestMapping(value = "/get-discounts", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDiscounts(@RequestParam String id,@RequestParam String gRNInvoiceId) {
		logger.info("Method : getInvoiceId starts");
		logger.info("Method : getDiscounts endss");
		return inventoryGoodsReturnDao.getDiscounts(id,gRNInvoiceId);
	}
	
	
	
	@RequestMapping(value = "get-unitGst-goods-return", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUnitGst(@RequestParam String id) {
		logger.info("Method : getUnitGst starts");

		logger.info("Method : getUnitGst endss");
		return inventoryGoodsReturnDao.getUnitGst(id);
	}
	/**
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-goodsReturn" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
	return inventoryGoodsReturnDao.getHotelLogoReturn(logoType);
	}
	/*
	 * Get mapping for get Item Name
	 */

	@RequestMapping(value = "/getItemListByAutoSearchWithGRNINV", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<InventoryGoodsReturnsNoteModel>>> getItemListByAutoSearchWithGRNINV(@RequestParam String id , @RequestParam String poId) {
		logger.info("Method : getItemListByAutoSearchWithGRNINV starts");

		logger.info("Method : getItemListByAutoSearchWithGRNINV endss");
		return inventoryGoodsReturnDao.getItemListByAutoSearchWithGRNINV(id ,poId);
	}
}
