/**
 * Defines Inventory related method call for itemSubCategory
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
import nirmalya.aatithya.restmodule.inventory.dao.InventoryItemSubCategoryDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryItemSubCategoryModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class InventoryItemSubCategoryRestController {
	Logger logger = LoggerFactory.getLogger(InventoryItemSubCategoryRestController.class);

	@Autowired
	InventoryItemSubCategoryDao itemSubCategoryDao;

	@RequestMapping(value = "get-itemCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getItemCategory() {
		logger.info("Method : getItemCategory starts");
		logger.info("Method : getItemCategory endss");
		return itemSubCategoryDao.getItemCategory();
	}

	/*
	 * 
	 * post mapping for add rest ItemSubCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addNew-item-SubCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddItem(
			@RequestBody InventoryItemSubCategoryModel itemSubCategoryModel) {

		return itemSubCategoryDao.addItemSubCategory(itemSubCategoryModel);

	}

	/*
	 * 
	 * post Mapping for listing itemSubCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "get-All-Item-SubCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<InventoryItemSubCategoryModel>>> getAllItem(
			@RequestBody DataTableRequest request) {
		return itemSubCategoryDao.getAllItemSubCategoryList(request);
	}

	/**
	 * returns particular itemSubCategory to view/edit
	 *
	 */
	@RequestMapping(value = "get-item-sub-category-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<InventoryItemSubCategoryModel>> getItemSubCatById(@RequestParam String id) {
		return itemSubCategoryDao.getItemSubCatById(id);
	}

	/*
	 * 
	 * GetMapping for delete ItemSubCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "/delete-item-sub-category", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteItemSubCategory(@RequestParam String id,
			@RequestParam String createdBy) {
		return itemSubCategoryDao.deletItemSubCategory(id, createdBy);
	}

}
