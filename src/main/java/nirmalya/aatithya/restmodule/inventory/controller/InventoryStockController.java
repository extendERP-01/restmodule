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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.InventoryStockDao;
import nirmalya.aatithya.restmodule.inventory.model.InventoryStockDailyReportFinalModel;
import nirmalya.aatithya.restmodule.inventory.model.InventoryStockModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class InventoryStockController {

	Logger logger = LoggerFactory.getLogger(InventoryStockController.class);
	@Autowired
	InventoryStockDao inventoryStockDao;

	/**
	 *  
	 */
	@PostMapping(value = "get-stock-details")
	public ResponseEntity<JsonResponse<List<InventoryStockModel>>> getAllStockDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllStockDetails starts");

		logger.info("Method : getAllStockDetails ends");
		return inventoryStockDao.getAllStockDetails(request);
	}

	@GetMapping(value = "view-stock-daily-report")
	public ResponseEntity<JsonResponse< InventoryStockDailyReportFinalModel>> restDailyStockReport(@RequestParam String id ,@RequestParam String empId) {
		logger.info("Method : restDailyStockReport starts");
		 System.out.println(id);
		logger.info("Method : restDailyStockReport ends");
		return inventoryStockDao.restDailyStockReport(id ,empId);
	}

}
