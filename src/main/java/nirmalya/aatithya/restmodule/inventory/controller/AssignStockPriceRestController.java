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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.AssignStockPriceRestDao;
import nirmalya.aatithya.restmodule.inventory.model.AssignStockPriceRestModel;
import nirmalya.aatithya.restmodule.inventory.model.ItemModel;

@RestController
@RequestMapping("inventory/")
public class AssignStockPriceRestController {

	Logger logger = LoggerFactory.getLogger(AssignStockPriceRestController.class);
	@Autowired
	AssignStockPriceRestDao assignStockPriceRestDao;
	
	@PostMapping("add-stock-item")
	public ResponseEntity<JsonResponse<Object>> saveStockItem(@RequestBody List<AssignStockPriceRestModel> ciModel){
		logger.info("saving  item for stores.....");
		return assignStockPriceRestDao.saveStockItem(ciModel);
	}
	
	@GetMapping("get-store-items")
	public ResponseEntity<JsonResponse<List<AssignStockPriceRestModel>>> getStockItems(@RequestParam("id") String cid){
		logger.info("fetching items.....");
		return assignStockPriceRestDao.getStockItemDatails(cid);
	}
	
	@GetMapping("store-get-item-auto-cmplt")
	public ResponseEntity<JsonResponse<List<ItemModel>>> getItemAutoCmplt(@RequestParam String key ,@RequestParam String storeId){
		logger.info("getting store Names.....");
		return assignStockPriceRestDao.getItemAutoCmplt(key,storeId);
	}
	
	@GetMapping("delete-stock-item")
	public ResponseEntity<JsonResponse<Object>> deleteItem(@RequestParam String params){
		logger.info("deleting item.....");
		String[] s = params.split("-");
		return assignStockPriceRestDao.deleteItem(s[0],s[1]);
	}
	
	@PostMapping("update-stock-item")
	public ResponseEntity<JsonResponse<Object>> updateStockItem(@RequestBody AssignStockPriceRestModel ciModel){
		logger.info("saving  item for stores.....");
		return assignStockPriceRestDao.updateStockItem(ciModel);
	}
	
	@GetMapping("store-get-store-auto-cmplt")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStoreAutoCmplt(@RequestParam String key){
		
		return assignStockPriceRestDao.getStoreAutoCmplt(key);
	}
}
