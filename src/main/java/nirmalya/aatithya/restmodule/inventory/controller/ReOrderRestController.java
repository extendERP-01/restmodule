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
import nirmalya.aatithya.restmodule.inventory.dao.ReOrderDao;
import nirmalya.aatithya.restmodule.inventory.model.AssignedItemModel;
import nirmalya.aatithya.restmodule.inventory.model.ReOrderItemRestModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class ReOrderRestController {

	Logger logger = LoggerFactory.getLogger(ReOrderRestController.class);

	@Autowired
	ReOrderDao reOrderDao;
	
	@RequestMapping(value = "restGetBelowMinQtyItem", method = { RequestMethod.GET })
	public List<ReOrderItemRestModel> getBelowMinQtyItem(@RequestParam String id) {
		logger.info("Method : getBelowMinQtyItem starts");
		logger.info("Method : getBelowMinQtyItem endss");
		return reOrderDao.getBelowMinQtyItem(id);
	}
	
	@RequestMapping(value = "restGetItemWiseVendor", method = { RequestMethod.GET })
	public List<AssignedItemModel> getItemWiseVendor(@RequestParam String id) {
		logger.info("Method : getItemWiseVendor starts");
		logger.info("Method : getItemWiseVendor endss");
		return reOrderDao.getItemWiseVendor(id);
	}
	
	@RequestMapping(value = "restSubmitVendorForPO", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restSubmitVendorForPO(@RequestBody List<ReOrderItemRestModel> restItemModel) {
		logger.info("Method : restSubmitVendorForPO starts");
		logger.info("Method : restSubmitVendorForPO ends");
		return reOrderDao.submitVendorForPO(restItemModel);
	}
	
	@RequestMapping(value = "getAllVendorsFromReOrder", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ReOrderItemRestModel>>> getAllVendorsFromReOrder(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllVendorsFromReOrder starts");
		logger.info("Method : getAllVendorsFromReOrder ends");
		return reOrderDao.getAllVendorsFromReOrder(request);
	}
}
