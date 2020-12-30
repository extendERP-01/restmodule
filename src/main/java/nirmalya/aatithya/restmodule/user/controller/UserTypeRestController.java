package nirmalya.aatithya.restmodule.user.controller;

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
import nirmalya.aatithya.restmodule.user.dao.UserTypeDao;
import nirmalya.aatithya.restmodule.user.model.UserTypeModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "user/")
public class UserTypeRestController {
	Logger logger = LoggerFactory.getLogger(UserTypeRestController.class);

	@Autowired
	UserTypeDao userTypeDao;
	/**
	 * returns add user type 
	 *
	 */

	@RequestMapping(value = "/addUserType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addUserType(@RequestBody UserTypeModel form) {
		logger.info("Method : addUserType starts");

		logger.info("Method : addUserType end");

		return userTypeDao.addUserType(form);

	}
	/**
	 * returns get all user type
	 *
	 */
	@RequestMapping(value = "/getAllUserTypes", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserTypeModel>>> getAllUserTypes(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllUserTypes starts");

		logger.info("Method : getAllUserTypes end");

		return userTypeDao.getAllUserTypes(request);
	}
	/**
	 * returns delete user type
	 *
	 */
	@RequestMapping(value = "/deleteUserTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteUserTypeById(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteUserTypeById starts");

		logger.info("Method : deleteUserTypeById end");

		return userTypeDao.deleteUserTypeById(id,createdBy);
	}
	/**
	 * returns edit property floor
	 *
	 */
	@RequestMapping(value = "/getUserTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<UserTypeModel>> getFloorById(@RequestParam String id) {

		logger.info("Method : getUserTypeById starts");

		logger.info("Method : getUserTypeById end");

		return userTypeDao.getUserTypeById(id);
	}

}
