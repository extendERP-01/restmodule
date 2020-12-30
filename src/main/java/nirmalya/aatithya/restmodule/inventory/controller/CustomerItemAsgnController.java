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
import nirmalya.aatithya.restmodule.inventory.dao.CustomerItemAssgnDao;
import nirmalya.aatithya.restmodule.inventory.model.CustomerItemModel;
import nirmalya.aatithya.restmodule.inventory.model.CustomerModel;
import nirmalya.aatithya.restmodule.inventory.model.ItemModel;

@RestController
@RequestMapping("inventory/")
public class CustomerItemAsgnController {
	Logger logger = LoggerFactory.getLogger(CustomerItemAsgnController.class);
	@Autowired
	CustomerItemAssgnDao customerItemAssgnDao;

	@PostMapping("add-coustomer-item")
	public ResponseEntity<JsonResponse<Object>> saveCustomerItem(@RequestBody List<CustomerItemModel> ciModel) {
		logger.info("method : saveCustomerItem starts");

		logger.info("method : saveCustomerItem ends");
		return customerItemAssgnDao.saveCustomerItem(ciModel);
	}

	@GetMapping("get-customer-items")
	public ResponseEntity<JsonResponse<List<CustomerItemModel>>> getCustomerItems(@RequestParam("id") String cid) {
		logger.info("method : getCustomerItems starts");

		logger.info("method : getCustomerItems ends");
		return customerItemAssgnDao.getCustomerItemDatails(cid);
	}

	@GetMapping("customer-get-item-auto-cmplt")
	public ResponseEntity<JsonResponse<List<ItemModel>>> getItemAutoCmplt(@RequestParam String key,
			@RequestParam String customerId) {
		logger.info("method : getItemAutoCmplt starts");

		logger.info("method : getItemAutoCmplt ends");
		return customerItemAssgnDao.getItemAutoCmplt(key, customerId);
	}

	@GetMapping("delete-coustomer-item")
	public ResponseEntity<JsonResponse<Object>> deleteItem(@RequestParam String params) {
		logger.info("deleting item.....");
		String[] s = params.split("-");
		return customerItemAssgnDao.deleteItem(s[0], s[1]);
	}

	@PostMapping("update-customer-item")
	public ResponseEntity<JsonResponse<Object>> updateCustomerItem(@RequestBody CustomerItemModel ciModel) {
		logger.info("saving  item for customers.....");
		return customerItemAssgnDao.updateCustomerItem(ciModel);
	}

	@GetMapping("customer-get-customer-auto-cmplt")
	public ResponseEntity<JsonResponse<List<CustomerModel>>> getCustomerAutoCmplt(@RequestParam String key) {
		logger.info("method : getCustomerAutoCmplt starts ");
		logger.info("method : getCustomerAutoCmplt ends ");
		return customerItemAssgnDao.getCustomerAutoCmplt(key);
	}
	
	@GetMapping("get-category-auto-cmplt")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCatagoryAutoCmplt(@RequestParam String key) {
		logger.info("method : getCatagoryAutoCmplt starts ");
		logger.info("method : getCatagoryAutoCmplt ends ");
		return customerItemAssgnDao.getCategoryAutoCmplt(key);
	}
	
}
