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
import nirmalya.aatithya.restmodule.inventory.dao.InventoryStockTransferDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryStockTransferModel;
import nirmalya.aatithya.restmodule.inventory.model.StockItemModel;


/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class RestInventoryStockTransferController {
	Logger logger = LoggerFactory.getLogger(RestInventoryStockTransferController.class);
	@Autowired
	InventoryStockTransferDao stockTransferDao;
	

	/*
	 * 
	 * Get mapping for get From Store
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-stockTransfer-fromStore", method = { RequestMethod.GET })
	public List<DropDownModel> getStockTransferFromStore(@RequestParam String id) {
		logger.info("Method : getStockTransferFromStore starts");
		logger.info("Method : getStockTransferFromStore endss");
		return stockTransferDao.getStockTransferFromStore(id);
	}
	
	/*
	 * 
	 * Get mapping for get To Store
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-stockTransfer-toStore", method = { RequestMethod.GET })
	public List<DropDownModel> getStockTransferToStore() {
		logger.info("Method : getStockTransferToStore starts");
		logger.info("Method : getStockTransferToStore endss");
		return stockTransferDao.getStockTransferToStore();
	}
	/*
	 * 
	 * Get mapping for get To Store
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-taxRate", method = { RequestMethod.GET })
	public List<DropDownModel> getTaxRate(@RequestParam("id") String id) {
		logger.info("Method : getTaxRate starts");
		logger.info("Method : getTaxRate endss");
		return stockTransferDao.getTaxRate(id);
	}
	/*
	 * 
	 * method for Auto  Complete for item
	 */
	@RequestMapping(value = "/getItemAutoCompleteList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<StockItemModel>>> getItemAutoCompleteList(@RequestParam String id) {
	logger.info("Method : getItemAutoCompleteList starts");

	logger.info("Method : getItemAutoCompleteList ends");
	return stockTransferDao.getItemAutoCompleteList(id);
	
	}
	
	/*
	 * 
	 * GetMapping for get Item Details
	 * 
	 * 
	 */
	@RequestMapping(value = "getItemDetail", method = { RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>> getItemDetail(@RequestParam String id) {
		logger.info("Method :  getItemDetail starts");
		logger.info("Method :  getItemDetail endss");
		return stockTransferDao.getItemDetail(id);
	}
	/*
	 * 
	 * PostMapping for add rest GoodsReceive
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-add-stock-transfer", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addStockTransfer(
			@RequestBody List<RestInventoryStockTransferModel> invGoodsReceiveModel) {
		logger.info("Method : addStockTransfer starts");
		logger.info("Method : addStockTransfer ends");
		return stockTransferDao.addStockTransfer(invGoodsReceiveModel);
	}
	/*
	 * 
	 * post Mapping for listing stock transfer
	 * 
	 * 
	 */
	@RequestMapping(value = "get-alls-stock-transfer", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>> getAllStockTransfer(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllStockTransfer starts");
		logger.info("Method : getAllStockTransfer ends");
		return stockTransferDao.getAllStockTransfer(request);
	}
	/*
	 * 
	 * GetMapping for delete goodsREceive
	 * 
	 * 
	 */
	@RequestMapping(value = "/delete-stock-transfer", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteStockTransfer(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteStockTransfer starts");
		logger.info("Method : deleteStockTransfer ends");
		return stockTransferDao.deleteStockTransfer(id, createdBy);
	}
	
	@RequestMapping(value = "/changeStockStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changeStockStatus(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : changeStockStatus starts");
		logger.info("Method : changeStockStatus ends");
		return stockTransferDao.changeStockStatus(id, createdBy);
	}

	/*
	 * 
	 * Get mapping for get Stock Transfer note for modal view
	 * 
	 * 
	 */
	@RequestMapping(value = "gets-stock-modals", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestInventoryStockTransferModel>>> modalView(@RequestParam String id) {
		logger.info("Method : modalView starts");
		logger.info("Method : modalView endss");
		return stockTransferDao.modalView(id);
	}
	/*
	 * 
	 * Get mapping for  Stock Transfer note for edit
	 * 
	 * 
	 */
	@RequestMapping(value = "edit-stock-by-id", method = { RequestMethod.GET })
	public List<RestInventoryStockTransferModel> editStockById(@RequestParam String id) {
		logger.info("Method : editStockById starts");
		logger.info("Method : editStockById endss");
		return stockTransferDao.editStockById(id);
	}
}
