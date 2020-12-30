/**
 * rest Controller for property master
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.property.dao.PropertyMasterDao;
import nirmalya.aatithya.restmodule.property.model.PropertyMasterModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("property")
public class PropertyMasterRestController {
	Logger logger = LoggerFactory.getLogger(PropertyMasterRestController.class);
	@Autowired
	PropertyMasterDao masterDao;

	/**
	 * returns property category for drop down model
	 *
	 */
	@RequestMapping(value = "/getCategoryName", method = { RequestMethod.GET })
	public List<DropDownModel> getCategoryName() {
		logger.info("Method : getCategoryName starts");

		logger.info("Method : getCategoryName end");
		return masterDao.getCategoryName();
	}

	/**
	 * returns property Type for drop down model
	 *
	 */
	@RequestMapping(value = "/getTypeName", method = { RequestMethod.GET })
	public List<DropDownModel> getTypeName() {
		logger.info("Method : getTypeName starts");

		logger.info("Method : getTypeName end");
		return masterDao.getTypeName();
	}

	/**
	 * returns property Type for drop down model for edit
	 *
	 */
	@RequestMapping(value = "getTypeNameEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getTypeNameEdit(@RequestParam String proCat) {
		logger.info("Method : getTypeNameEdit starts");

		logger.info("Method : getTypeNameEdit ends");
		return masterDao.getTypeNameEdit(proCat);
	}

	/**
	 * returns property floor for drop down model
	 *
	 */
	@RequestMapping(value = "/getFloorName", method = { RequestMethod.GET })
	public List<DropDownModel> getFloorName() {
		logger.info("Method : getFloorName starts");

		logger.info("Method : getFloorName end");
		return masterDao.getFloorName();
	}

	/*
	 * for drop down of property type
	 * 
	 * @RequestMapping(value = "/getPropertyTypeName", method = { RequestMethod.GET
	 * }) public ResponseEntity<JsonResponse<List<DropDownModel>>>
	 * getPropertyTypeName(@RequestParam String proCat) {
	 * logger.info("Method in rest: getPropertyTypeName starts");
	 * 
	 * logger.info("Method in rest: getPropertyTypeName ends"); return
	 * masterDao.getPropertTypeName(proCat); }
	 */

	/**
	 * returns add property master
	 *
	 */

	@RequestMapping(value = "/addPropertyMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPropertyMaster(@RequestBody PropertyMasterModel form) {
		logger.info("Method : addPropertyMaster starts");

		logger.info("Method : addPropertyMaster end");

		return masterDao.addPropertyMaster(form);

	}

	/**
	 * returns get all property master
	 *
	 */
	@RequestMapping(value = "/getAllPropertyMaster", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyMasterModel>>> getAllPropertyMaster(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllPropertyMaster starts");

		logger.info("Method : getAllPropertyMaster end");

		return masterDao.getAllPropertyMaster(request);
	}

	/**
	 * returns delete property master
	 *
	 */
	@RequestMapping(value = "/deletePropertyMasterById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePropertyMaster(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deletePropertyMaster starts");

		logger.info("Method : deletePropertyMaster end");

		return masterDao.deletePropertyMaster(id,createdBy);
	}

	/**
	 * returns edit property master
	 *
	 */
	@RequestMapping(value = "/getPropertyMasterById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyMasterModel>> getPropertyMasterById(@RequestParam String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getPropertyMasterById starts");

		logger.info("Method : getPropertyMasterById end");

		return masterDao.getPropertyMasterById(id, action);
	}
}
