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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryItemCategoryDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryItemCategoryModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class RestInventoryItemCategoryController {
	Logger logger=LoggerFactory.getLogger(RestInventoryItemCategoryController.class);

	@Autowired
	InventoryItemCategoryDao itemCategoryDao;

	/*
	 * 
	 * post mapping for add rest ItemCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addnew-itemcategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddItem(@RequestBody RestInventoryItemCategoryModel itemCategoryModel) {
		logger.info("Method : restAddItem starts");
		logger.info("Method : restAddItem endss");
		return itemCategoryDao.addItemCategory(itemCategoryModel);
	}

	/*
	 * 
	 * post Mapping for listing itemCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-item-category", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryItemCategoryModel>>> getAllItem(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllItem starts");
		logger.info("Method : getAllItem endss");
		return itemCategoryDao.getAllItemList(request);
	}

	/**
	 * returns particular itemCategory to view/edit
	 *
	 */
	@RequestMapping(value = "get-item-category-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestInventoryItemCategoryModel>> getItemById(@RequestParam String id) {
		logger.info("Method : getItemById starts");
		logger.info("Method : getItemById endss");
		return itemCategoryDao.getItemById(id);
	}

	/*
	 * 
	 * GetMapping for delete ItemCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "/delete-item-category", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteItemCategory(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteItemCategory starts");
		logger.info("Method : deleteItemCategory endss");
		return itemCategoryDao.deletItemCategory(id,createdBy);
	}
}