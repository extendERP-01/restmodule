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
import nirmalya.aatithya.restmodule.inventory.dao.RackShelfMasterDao;
import nirmalya.aatithya.restmodule.inventory.model.RackShelvesRestModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class RackShelfMasterController {

	@Autowired
	RackShelfMasterDao rackShelfMasterDao;
	
	Logger logger = LoggerFactory.getLogger(RackShelvesRestController.class);
	
	@RequestMapping(value = "/assign-shelves-to-rack", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> assignItemToShelves(@RequestBody List<RackShelvesRestModel> assigneItem) {
		logger.info("Method : assignItemToShelves starts");
		
		logger.info("Method : assignItemToShelves ends");
		return rackShelfMasterDao.assignShelvesToRack(assigneItem);
	}
 
	@RequestMapping(value = "/get-rack-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> getAllRackDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllRackDetails starts");
		
		logger.info("Method : getAllRackDetails endss");
		return rackShelfMasterDao.getAllRackDetails(request);
	}
	
	@RequestMapping(value = "/edit-rack-master", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RackShelvesRestModel>>> editRackDetails(
			@RequestParam String id) {
		logger.info("Method : editRackDetails starts");
		
		logger.info("Method : editRackDetails endss");
		return rackShelfMasterDao.editRackDetails(id);
	}
}
