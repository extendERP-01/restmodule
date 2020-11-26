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
import nirmalya.aatithya.restmodule.inventory.dao.VendorItemDao;
import nirmalya.aatithya.restmodule.inventory.model.VendorItemModel;

@RestController
@RequestMapping("inventory/")
public class VendorItemController {
	Logger logger = LoggerFactory.getLogger(VendorItemController.class);

	@Autowired
	VendorItemDao vendorItemDao;

	@PostMapping("add-vendor-item")
	public ResponseEntity<JsonResponse<Object>> addVenderItem(@RequestBody List<VendorItemModel> viModel) {
		logger.info("addVenderItem starts");

		logger.info("addVenderItem ends");

		return vendorItemDao.addVenderItem(viModel);
	}

	@GetMapping("get-vendor-items")
	public ResponseEntity<JsonResponse<List<VendorItemModel>>> getVendorItems(@RequestParam String id) {

		logger.info("getVendorItems Starts");

		logger.info("getVendorItems ends");

		return vendorItemDao.getVendorItemDatails(id);
	}

	@GetMapping("unassign-vendor-items")
	public ResponseEntity<JsonResponse<Object>> unassignItem(@RequestParam String id, @RequestParam String name) {

		logger.info("unassignItem Starts");

		logger.info("unassignItem Starts");
		return vendorItemDao.unassignItem(id, name);
	}

	@PostMapping("update-vendor-item")
	public ResponseEntity<JsonResponse<Object>> updateVenderItem(@RequestBody VendorItemModel viModel) {
		logger.info("updateVenderItem starts");

		logger.info("updateVenderItem ends");

		return vendorItemDao.updateVenderItem(viModel);
	}

	@GetMapping("get-item-auto-cmplt")
	public JsonResponse<List<DropDownModel>> getItemAutoCmplt(@RequestParam String key, @RequestParam String vid) {
		logger.info("getItemAutoCmplt starts");
		logger.info("getItemAutoCmplt ends");
		return vendorItemDao.getItemAutoCmplt(key, vid);
	}

	@GetMapping("get-vendor-auto-cmplt")
	public JsonResponse<List<DropDownModel>> getVendorCmplt(@RequestParam String key) {
		logger.info("getVendorCmplt starts");
		logger.info("getVendorCmplt ends");
		return vendorItemDao.getVendorCmplt(key);
	}
}
