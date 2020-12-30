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
import nirmalya.aatithya.restmodule.inventory.dao.RackShelvesDao;
import nirmalya.aatithya.restmodule.inventory.model.AssignedItemModel;
import nirmalya.aatithya.restmodule.inventory.model.RackShelvesRestModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class RackShelvesRestController {

	@Autowired
	RackShelvesDao rackShelvesDao;

	Logger logger = LoggerFactory.getLogger(RackShelvesRestController.class);

	@RequestMapping(value = "/getDropDownWarehouse", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownWarehouse(@RequestParam("id") String id) {
		logger.info("Method : getDropDownWarehouse starts");

		logger.info("Method : getDropDownWarehouse ends");
		return rackShelvesDao.getDropDownWarehouse(id);
	}

	@RequestMapping(value = "/getDropDownRack", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownRack(@RequestParam("id") String id) {
		logger.info("Method : getDropDownRack starts");

		logger.info("Method : getDropDownRack ends");
		return rackShelvesDao.getDropDownRack(id);
	}

	@RequestMapping(value = "/getDropDownShelfs", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownShelfs(@RequestParam("id") String id) {
		logger.info("Method : getDropDownShelfs starts");

		logger.info("Method : getDropDownShelfs ends");
		return rackShelvesDao.getDropDownShelfs(id);
	}

	@RequestMapping(value = "/getDropDownItem", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDropDownItem() {
		logger.info("Method : getDropDownItem starts");

		logger.info("Method : getDropDownItem ends");
		return rackShelvesDao.getDropDownItem();
	}

	@RequestMapping(value = "/getPreviousDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> getPreviousDetails(@RequestParam String whId,
			@RequestParam String storeId, @RequestParam String subInvId) {
		logger.info("Method : getPreviousDetails starts");

		logger.info("Method : getPreviousDetails ends");
		return rackShelvesDao.getPreviousDetails(whId, storeId, subInvId);
	}

	@RequestMapping(value = "/assignItemToShelves", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> assignItemToShelves(
			@RequestBody List<RackShelvesRestModel> assigneItem) {
		logger.info("Method : assignItemToShelves starts");

		logger.info("Method : assignItemToShelves ends");
		return rackShelvesDao.assignItemToShelves(assigneItem);
	}

	@RequestMapping(value = "/getAllRackDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> getAllRackDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllRackDetails starts");

		logger.info("Method : getAllRackDetails endss");
		return rackShelvesDao.getAllRackDetails(request);
	}

	@RequestMapping(value = "/editRackDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> editRackDetails(@RequestParam String id) {
		logger.info("Method : editRackDetails starts");

		logger.info("Method : editRackDetails endss");
		return rackShelvesDao.editRackDetails(id);
	}

	@RequestMapping(value = "/editWarehouseForRack", method = { RequestMethod.GET })
	public List<DropDownModel> editWarehouseForRack(@RequestParam String id) {
		logger.info("Method : editWarehouseForRack starts");

		logger.info("Method : editWarehouseForRack endss");
		return rackShelvesDao.editWarehouseForRack(id);
	}

	@RequestMapping(value = "/editRackByWareHouse", method = { RequestMethod.GET })
	public List<DropDownModel> editRackByWareHouse(@RequestParam String id) {
		logger.info("Method : editRackByWareHouse starts");

		logger.info("Method : editRackByWareHouse endss");
		return rackShelvesDao.editRackByWareHouse(id);
	}

	@RequestMapping(value = "/editShelvesByRack", method = { RequestMethod.GET })
	public List<DropDownModel> editShelvesByRack(@RequestParam String id) {
		logger.info("Method : editShelvesByRack starts");

		logger.info("Method : editShelvesByRack endss");
		return rackShelvesDao.editShelvesByRack(id);
	}
	@RequestMapping(value = "/editShelves", method = { RequestMethod.GET })
	public List<DropDownModel> editShelves() {
		logger.info("Method : editShelves starts");
		
		logger.info("Method : editShelves endss");
		return rackShelvesDao.editShelves();
	}

	@RequestMapping(value = "/getSelectedItem", method = { RequestMethod.GET })
	public List<AssignedItemModel> getSelectedItem(@RequestParam String id) {
		logger.info("Method : getSelectedItem starts");

		logger.info("Method : getSelectedItem endss");
		return rackShelvesDao.getSelectedItem(id);
	}
	
	
	@RequestMapping(value = "/editRackShelf", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> editRackShelf(@RequestParam String id ,@RequestParam String storeId,
			@RequestParam String subId,@RequestParam String whId) {
		logger.info("Method : editRackShelf starts");

		logger.info("Method : editRackShelf endss");
		return rackShelvesDao.editRackShelf(id ,storeId ,subId , whId);
	}
	
}
