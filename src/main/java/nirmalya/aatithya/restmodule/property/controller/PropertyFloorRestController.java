/*
 * Defines property floor Rest Controller

 */
package nirmalya.aatithya.restmodule.property.controller;

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
import nirmalya.aatithya.restmodule.property.dao.PropertyFloorDao;
import nirmalya.aatithya.restmodule.property.model.PropertyFloorModel;

/**
 * @author Nirmalya Labs
 *
 */

@RestController
@RequestMapping("property")
public class PropertyFloorRestController {
	Logger logger = LoggerFactory.getLogger(PropertyFloorRestController.class);
	@Autowired
	PropertyFloorDao floorDao;

	/**
	 * Post Mapping to Add new property floor
	 *
	 */
	@RequestMapping(value = "/addFloor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addFloor(@RequestBody PropertyFloorModel form) {

		logger.info("Method : addFloor starts");

		logger.info("Method : addFloor end");

		return floorDao.addFloor(form);

	}

	/**
	 * returns all property floor
	 *
	 */
	@RequestMapping(value = "/getAllfloor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyFloorModel>>> getAllFloor(@RequestBody DataTableRequest request) {

		logger.info("Method : getAllFloor starts");

		logger.info("Method : getAllFloor end");

		return floorDao.getAllFloor(request);
	}

	/**
	 * return delete property floor
	 *
	 */
	@RequestMapping(value = "/deleteFloorById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteFloor(@RequestParam String id,@RequestParam String createdBy) {

		logger.info("Method : deleteFloor starts");

		logger.info("Method : deleteFloor end");

		return floorDao.deleteFloor(id,createdBy);
	}

	/**
	 * returns edit property floor
	 *
	 */
	@RequestMapping(value = "/getFloorById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyFloorModel>> getFloorById(@RequestParam String id) {

		logger.info("Method : getFloorById starts");

		logger.info("Method : getFloorById end");

		return floorDao.getFloorById(id);
	}

}
