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
import nirmalya.aatithya.restmodule.inventory.dao.RestInventoryDamagedItemDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryDamagedItemModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class RestInventoryDamagedItemController {
	Logger logger = LoggerFactory.getLogger(RestInventoryDamagedItemController.class);
	@Autowired
	RestInventoryDamagedItemDao damagedItemDao;

	/*
	 * 
	 * Get mapping for get vendor name
	 * 
	 * 
	 */
	@RequestMapping(value = "get-damagedItem-vendorName", method = { RequestMethod.GET })
	public List<DropDownModel> getDamagedItemVendorName() {
		logger.info("Method : getDamagedItemVendorName starts");
		logger.info("Method : getDamagedItemVendorName endss");
		return damagedItemDao.getDamagedItemVendorName();
	}

	/*
	 * Get mapping for get Item Name
	 */
	@RequestMapping(value = "/getInventoryItemAutoSearchList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInventoryItemAutoSearchList(@RequestParam String id) {
		logger.info("Method : getInventoryItemAutoSearchList starts");

		logger.info("Method : getInventoryItemAutoSearchList ends");
		return damagedItemDao.getInventoryItemAutoSearchList(id);

	}

	/*
	 * 
	 * PostMapping for add damaged item
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addNew-damaged-item", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addNewDamagedItems(
			@RequestBody List<RestInventoryDamagedItemModel> damagedItem) {
		logger.info("Method : addNewDamagedItems starts");
		logger.info("Method : addNewDamagedItems ends");
		return damagedItemDao.addNewDamagedItems(damagedItem);
	}

	/*
	 * 
	 * PostMapping for get All damaged item list
	 * 
	 * 
	 */
	@RequestMapping(value = "view-damaged-item-list", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryDamagedItemModel>>> getAllDamagedItemsList(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllDamagedItemsList starts");
		logger.info("Method : getAllDamagedItemsList endss");
		return damagedItemDao.getAllDamagedItemsList(request);
	}

	/*
	 * 
	 * Get mapping for edit damaged Item
	 * 
	 * 
	 */
	@RequestMapping(value = "edit-damagedItem-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestInventoryDamagedItemModel>> editDamagedItem(@RequestParam String id) {
		logger.info("Method : editDamagedItem starts");
		logger.info("Method : editDamagedItem endss");
		return damagedItemDao.editDamagedItem(id);
	}

	/*
	 * 
	 * Get mapping for View Damaged Item in Model
	 * 
	 * 
	 */
	@RequestMapping(value = "get-damagedItem-forModel", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestInventoryDamagedItemModel>> getDamagedItemForModel(@RequestParam String id) {
		logger.info("Method : getDamagedItemForModel starts");
		logger.info("Method : getDamagedItemForModel endss");
		return damagedItemDao.getDamagedItemForModel(id);
	}

	/*
	 * 
	 * GetMapping for delete Item
	 * 
	 * 
	 */
	@RequestMapping(value = "deleteDamagedItem", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDamagedItem(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteDamagedItem starts");
		logger.info("Method : deleteDamagedItem endss");
		return damagedItemDao.deleteDamagedItem(id, createdBy);
	}

	/*
	 * 
	 * GetMapping for Change item status
	 * 
	 * 
	 */
	@RequestMapping(value = "changeStatusToReSale", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changeStatusToReSale(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : changeStatusToReSale starts");
		logger.info("Method : changeStatusToReSale endss");
		return damagedItemDao.changeStatusToReSale(id, createdBy);
	}

	/*
	 * 
	 * GetMapping for Change item status
	 * 
	 * 
	 */
	@RequestMapping(value = "changeStatusToScrapped", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changeStatusToScrapped(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : changeStatusToScrapped starts");
		logger.info("Method : changeStatusToScrapped endss");
		return damagedItemDao.changeStatusToScrapped(id, createdBy);
	}

	/*
	 * 
	 * method for Auto Search of Itemin search param
	 */
	@RequestMapping(value = "/getParamItemListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getParamItemListByAutoSearch(@RequestParam String id) {
		logger.info("Method : getParamItemListByAutoSearch starts");

		logger.info("Method : getParamItemListByAutoSearch ends");
		return damagedItemDao.getParamItemListByAutoSearch(id);

	}
}
