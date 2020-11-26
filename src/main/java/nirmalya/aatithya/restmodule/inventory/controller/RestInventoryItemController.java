/*
*Defines Inventory related method call for itemCategory
 * 
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
import nirmalya.aatithya.restmodule.inventory.dao.InventoryItemDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryItemModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class RestInventoryItemController {
	Logger logger = LoggerFactory.getLogger(RestInventoryItemController.class);
	@Autowired
	InventoryItemDao itemDao;

	/*
	 * 
	 * Get mapping for get accountGroup rest-getSubAccountGroup
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-itemType", method = { RequestMethod.GET })
	public List<DropDownModel> getItemType() {
		logger.info("Method : getItemType starts");
		logger.info("Method : getItemType endss");
		return itemDao.getItemType();
	}
	
	
	/*
	 * 
	 * Get mapping for get item Thickness
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-itemThickness", method = { RequestMethod.GET })
	public List<DropDownModel> getItemThickness() {
		logger.info("Method : getItemThickness starts");
		logger.info("Method : getItemThickness endss");
		return itemDao.getItemThickness();
	}
	
	
	
	/*
	 * 
	 * Get mapping for get accountGroup rest-getSubAccountGroupitem Grade
	 * 
	 */
	@RequestMapping(value = "rest-get-itemGrade", method = { RequestMethod.GET })
	public List<DropDownModel> getItemGrade() {
		logger.info("Method : getItemGrade starts");
		logger.info("Method : getItemGrade endss");
		return itemDao.getItemGrade();
	}
	
	/*
	 * 
	 * Get mapping for get accountGroup rest-getSubAccountGroupitem Grade
	 * 
	 */
	@RequestMapping(value = "rest-get-store", method = { RequestMethod.GET })
	public List<DropDownModel> getStore(@RequestParam String userId) {
		logger.info("Method : getStore starts");
		logger.info("Method : getStore endss");
		return itemDao.getStore(userId);
	}
	/*
	 * 
	 * Get mapping for get accountGroup rest-getSubAccountGroup
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-saccode-for-invitems", method = { RequestMethod.GET })
	public List<DropDownModel> getsaccodes() {
		logger.info("Method : getItemType starts");
		logger.info("Method : getItemType endss");
		return itemDao.getSacCodes();
	}

	/*
	 * 
	 * Get mapping for get ItemCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-itemCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getItemCategory() {
		logger.info("Method : getItemCategory starts");
		logger.info("Method : getItemCategory endss");
		return itemDao.getItemCategory();
	}

	/*
	 * 
	 * Get mapping for get ItemCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-productiontype", method = { RequestMethod.GET })
	public List<DropDownModel> getProductiontype() {
		logger.info("Method : getProductiontype starts");
		logger.info("Method : getProductiontype endss");
		return itemDao.getProductiontype();
	}

	
	/*
	 * 
	 * Get mapping for get ItemSubCategory
	 * 
	 * 
	 */

	@RequestMapping(value = "/rest-getSubAccountGroup", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubAccountGroup(@RequestParam String id) {
		logger.info("Method : getSubItemCategory starts");

		logger.info("Method : getSubItemCategory endss");
		return itemDao.getSubAccountGroup(id);
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory
	 * 
	 * 
	 */

	@RequestMapping(value = "/rest-get-itemSubCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubItemCategory(@RequestParam String id) {
		logger.info("Method : getSubItemCategory starts");

		logger.info("Method : getSubItemCategory endss");
		return itemDao.getItemSubCategory(id);
	}

	/*
	 * 
	 * Get mapping for get getServeType
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-serveType", method = { RequestMethod.GET })
	public List<DropDownModel> getServeType() {
		logger.info("Method : getServeType starts");
		logger.info("Method : getServeType endss");
		return itemDao.getServeType();
	}

	/*
	 * 
	 * Get mapping for get getServiceType
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-serviceType", method = { RequestMethod.GET })
	public List<DropDownModel> getServiceType() {
		logger.info("Method : getServiceType starts");
		logger.info("Method : getServiceType endss");
		return itemDao.getServiceType();
	}

	/*
	 * 
	 * PostMapping for add rest Items
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addNew-item", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddItem(@RequestBody List<RestInventoryItemModel> restItemModel) {
		logger.info("Method : restAddItem starts");
		logger.info("Method : restAddItem ends");
		return itemDao.addItem(restItemModel);
	}

	/*
	 * 
	 * PostMapping for get All items
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-Items", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> getAllItems(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllItems starts");
		logger.info("Method : getAllItems endss");
		return itemDao.getAllItems(request);
	}

	/*
	 * 
	 * GetMapping for delete Item
	 * 
	 * 
	 */
	@RequestMapping(value = "delete-item", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteItem(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteItem starts");
		logger.info("Method : deleteItem endss");
		return itemDao.deleteItem(id, createdBy);
	}

	/*
	 * 
	 * Get mapping for View Item in Model
	 * 
	 * 
	 */
	@RequestMapping(value = "get-item-forModel", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> getItemForModel(@RequestParam String id) {
		logger.info("Method : getItemForModel starts");
		logger.info("Method : getItemForModel endss");
		return itemDao.getItemForModelDao(id);
	}

	/*
	 * 
	 * Get mapping for edit Item
	 * 
	 * 
	 */
	@RequestMapping(value = "edit-item-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> editItemById(@RequestParam String id) {
		logger.info("Method : editItemById starts");
		logger.info("Method : editItemById endss");
		return itemDao.editItemByIdDao(id);
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-item-itemSubCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getItemItemSubCategory(@RequestParam String id) {
		logger.info("Method : Dao getItemItemSubCategory starts");
		logger.info("Method : Dao getItemItemSubCategory endss");
		return itemDao.getItemItemSubCategoryList(id);
	}

	/*
	 * 
	 * Get mapping of Item Name for Search Param1
	 * 
	 * 
	 */
	@RequestMapping(value = "param-itemName", method = { RequestMethod.GET })
	public List<DropDownModel> getParam1ItemName() {
		logger.info("Method : getParam1ItemName starts");
		logger.info("Method : getParam1ItemName endss");
		return itemDao.getParamItemName();
	}

	/*
	 * 
	 * Get mapping of Item Name for Search Param2
	 * 
	 * 
	 */
	@RequestMapping(value = "param-serveType", method = { RequestMethod.GET })
	public List<DropDownModel> getParam2ServeType() {
		logger.info("Method : getParam2ServeType starts");
		logger.info("Method : getParam2ServeType endss");
		return itemDao.getParamServeType();
	}

	/*
	 * 
	 * PostMapping for get All items PDF
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-ItemsPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> getAllItemsPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllItemsPdf starts");
		logger.info("Method : getAllItemsPdf endss");
		return itemDao.getAllItemsPdf(request);
	}

	/*
	 * 
	 * PostMapping for get All items PDF
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-ItemsReport", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryItemModel>>> getAllItemsRport(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllItemsRport starts");
		logger.info("Method : getAllItemsRport endss");
		return itemDao.getAllItemsReport(request);
	}

	/*
	 * 
	 * method for Auto Complete
	 * 
	 */
	@RequestMapping(value = "/getItemNameListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemNameListByAutoSearch(@RequestParam String id) {
		logger.info("Method : getItemNameListByAutoSearch starts");

		logger.info("Method : getItemNameListByAutoSearch ends");
		return itemDao.getItemNameListByAutoSearch(id);
	}

	/*
	 * 
	 * method for Auto Complete of generate report of item Name
	 * 
	 */
	@RequestMapping(value = "/generateItemNameListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> generateItemNameListByAutoSearch(@RequestParam String id ,@RequestParam String icat ) {
		logger.info("Method : generateItemNameListByAutoSearch starts");

		logger.info("Method : generateItemNameListByAutoSearch ends");
		return itemDao.generateItemNameListByAutoSearch(id,icat );
	}

	/*
	 * 
	 * Get mapping for get PurchaseSubGroup
	 * 
	 * 
	 */

	@RequestMapping(value = "/rest-getPurchaseSubGroup", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseSubGroup(@RequestParam String id) {
		logger.info("Method : getPurchaseSubGroup starts");

		logger.info("Method : getPurchaseSubGroup endss");
		return itemDao.getPurchaseSubGroup(id);
	}

	/*
	 * 
	 * Get mapping for get SalesSubGroup
	 * 
	 * 
	 */

	@RequestMapping(value = "/rest-getSalesSubGroup", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesSubGroup(@RequestParam String id) {
		logger.info("Method : getSalesSubGroup starts");

		logger.info("Method : getSalesSubGroup endss");
		return itemDao.getSalesSubGroup(id);
	}

	/*
	 * REST CONTROLLER - Get Hotel Logo
	 *
	 */
	@RequestMapping(value = "restLogoImage-item", method = { RequestMethod.GET })
	public List<DropDownModel> restGetLogoImage(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImage starts");

		logger.info("Method : restGetLogoImage ends");
		return itemDao.getHotelLogoItem(logoType);
	}

	/*
	 * 
	 * Get mapping for get PurchaseSubGroup for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-item-purchase", method = { RequestMethod.GET })
	public List<DropDownModel> getEditPurchase(@RequestParam String id) {
		logger.info("Method : Dao getEditPurchase starts");
		logger.info("Method : Dao getEditPurchase endss");
		return itemDao.getEditPurchase(id);
	}

	@RequestMapping(value = "get-edit-item-pipesize", method = { RequestMethod.GET })
	public List<DropDownModel> getEditPipeSize() {
		logger.info("Method : Dao getEditPipeSize starts");
		logger.info("Method : Dao getEditPipeSize endss");
		return itemDao.getEditPipeSize();
	}

	/*
	 * 
	 * Get mapping for get SalesSubGroup for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-edit-item-sales", method = { RequestMethod.GET })
	public List<DropDownModel> getEditSales(@RequestParam String id) {
		logger.info("Method : Dao getEditSales starts");
		logger.info("Method : Dao getEditSales endss");
		return itemDao.getEditSales(id);
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory
	 * 
	 * 
	 */

	@RequestMapping(value = "/rest-get-itemPipeSize", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemPipeSize(@RequestParam String id,
			@RequestParam String itemSubCategory) {
		logger.info("Method : getItemPipeSize starts");

		logger.info("Method : getItemPipeSize endss");
		return itemDao.getItemPipeSize(id, itemSubCategory);
	}
	/*
	 * 
	 * Get mapping for get ItemCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "param-itemCategory", method = { RequestMethod.GET })
	public List<DropDownModel> paramItemCategory() {
		logger.info("Method : paramItemCategory starts");
		logger.info("Method : paramItemCategory endss");
		return itemDao.paramItemCategory();
	}
	/*
	 * 
	 * Get mapping for get ItemCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "param-storeName", method = { RequestMethod.GET })
	public List<DropDownModel> paramstoreName() {
		logger.info("Method : paramstoreName starts");
		logger.info("Method : paramstoreName endss");
		return itemDao.paramstoreName();
	}
}
