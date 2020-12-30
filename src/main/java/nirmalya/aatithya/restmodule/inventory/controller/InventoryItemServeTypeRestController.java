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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryItemServeTypeDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryItemServeTypeModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class InventoryItemServeTypeRestController {
	Logger logger = LoggerFactory.getLogger(InventoryItemSubCategoryRestController.class);

	@Autowired
	InventoryItemServeTypeDao itemServeTypeDao;

	/*
	 * 
	 * post mapping for add rest ItemServe
	 * 
	 * 
	 */
	@RequestMapping(value = "addNewItemServeType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddItemServeType(
			@RequestBody InventoryItemServeTypeModel itemServeTypeModel) {

		return itemServeTypeDao.addItemServeType(itemServeTypeModel);

	}

	/*
	 * 
	 * post Mapping for listing itemServe
	 * 
	 * 
	 */
	@RequestMapping(value = "getAllItemServeType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<InventoryItemServeTypeModel>>> getAllItemServeType(
			@RequestBody DataTableRequest request) {
		return itemServeTypeDao.getAllItemServeTypeList(request);
	}

	/*
	 * 
	 * GetMapping for delete ItemServeType
	 * 
	 * 
	 */
	@RequestMapping(value = "/deleteItemServeType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteItemServeType(@RequestParam String id,
			@RequestParam String createdBy) {
		return itemServeTypeDao.deleteItemServeType(id, createdBy);
	}

	/**
	 * returns particular itemServeType to view/edit
	 *
	 */
	@RequestMapping(value = "getItemServeTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<InventoryItemServeTypeModel>> getItemServeTypeById(@RequestParam String id) {
		return itemServeTypeDao.getItemServeTypeById(id);
	}
}
