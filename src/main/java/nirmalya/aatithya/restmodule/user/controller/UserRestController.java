/**
 * 
 */
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.dao.UserDao;
import nirmalya.aatithya.restmodule.user.model.UserModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "user/")
public class UserRestController {

	Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	UserDao userDao;

 
	
	/*
	 * Get Country master
	 *
	 */
	@RequestMapping(value = "getCountryName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCountryName(String getCountryName) {
    	logger.info("Method : getCountryName starts");

		logger.info("Method : getCountryName ends");
		return userDao.getCountryName("getCountryName");
	}
	
	/*
	 * Get state
	 *
	 */
	
	@RequestMapping(value = "getStateName1", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName1(@RequestParam String id) {
		logger.info("Method : RESTMODULE UserRestController getStateName1 starts");
		logger.info("Method : RESTMODULE UserRestController getStateName1 end");
		return userDao.getStateName1(id);
	}
	
	/*
	 * Get state
	 *
	 */
	
	@RequestMapping(value = "getDistName1", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistName1(@RequestParam String id) {
		logger.info("Method : RESTMODULE UserRestController getDistName1 starts");
		logger.info("Method : RESTMODULE UserRestController getDistName1 end");
		return userDao.getDistName1(id);
	}

	/**
	 * GET USER ROLE
	 *
	 */

	@RequestMapping(value = "restGetUserRole", method = { RequestMethod.GET })
	public List<DropDownModel> getUserRole() {
		logger.info("Method : RESTMODULE UserRestController getUserRole starts");
		logger.info("Method : RESTMODULE UserRestController getUserRole ends");
		return userDao.getUserRoleData();
	}

	/**
	 * GET USER ROLE
	 *
	 */

	@RequestMapping(value = "rest-get-user-type-list", method = { RequestMethod.GET })
	public List<DropDownModel> getUserType() {
		logger.info("Method : RESTMODULE UserRestController getUserRole starts");
		logger.info("Method : RESTMODULE UserRestController getUserRole ends");
		return userDao.userTypeList();
	}

	/**
	 * ADD USER
	 *
	 */
	@RequestMapping(value = "restAddUser", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addUserData(@RequestBody UserModel form) {
		logger.info("Method : RESTMODULE UserRestController addUserData starts");
		logger.info("Method : RESTMODULE UserRestController addUserData end");
		return userDao.addUserDataList(form);
	}

	/**
	 * VIEW USER
	 *
	 */
	@RequestMapping(value = "restGetAllUsers", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserModel>>> getAllUsers(@RequestBody DataTableRequest request) {
		logger.info("Method : RESTMODULE UserRestController getAllUsers starts");
		logger.info("Method : RESTMODULE UserRestController getAllUsers end");
		return userDao.getAllUserList(request);
	}

	/**
	 * EDIT USER
	 *
	 */
	@RequestMapping(value = "restGetUserById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<UserModel>> getUserById(@RequestParam String id) {
		logger.info("Method : RESTMODULE UserRestController getUserById starts");
		logger.info("Method : RESTMODULE UserRestController getUserById end");
		return userDao.getUserByIdData(id);
	}
	
	
	/**
	 * EDIT USER
	 *
	 */
	@RequestMapping(value = "restGetModelById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<UserModel>> restGetModelById(@RequestParam String id) {
		logger.info("Method : RESTMODULE UserRestController restGetModelById starts");
		logger.info("Method : RESTMODULE UserRestController restGetModelById end");
		return userDao.restGetModelById(id);
	}
	/**
	 * DELETE USER
	 *
	 */
	@RequestMapping(value = "restDeleteUser", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> restDeleteUser(@RequestParam String id) {
		logger.info("Method : RESTMODULE UserRestController restDeleteUser starts");
		logger.info("Method : RESTMODULE UserRestController restDeleteUser end");
		return userDao.deleteUserData(id);
	}
	
	
	/**
	 * ONCHANGE  STATE on Country
	 *
	 */
	
	@RequestMapping(value = "restStateListByCntId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateByCntId(@RequestParam String proCat) {
		logger.info("Method : RestController getStateByCntId starts");

		logger.info("Method : RestController getStateByCntId ends");
		return userDao.getStateByCntId(proCat);
	}
	
	
	/**
	 * ONCHANGE  STATE on Country
	 *
	 */
	
	@RequestMapping(value = "restGetStateListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateListByCatId(@RequestParam String proCat) {
		logger.info("Method : RestController getStateListByCatId starts");

		logger.info("Method : RestController getStateListByCatId ends");
		return userDao.getStateListByCatId(proCat);
	}
	
	
	
	
	/**
	 * ONCHANGE DATA FETCH FOR STATE DISTRICT
	 *
	 */
	
	@RequestMapping(value = "restGetDistrictListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDIstrictListByCatId(@RequestParam String proCat) {
		logger.info("Method : RestController getDIstrictListByCatId starts");

		logger.info("Method : RestController getDIstrictListByCatId ends");
		return userDao.getDistListById(proCat);
	}
	/**
	 * VIEW STAFF USER LIST PDF
	 *
	 */
	@RequestMapping(value = "restGetAllFoodOrderDataPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserModel>>> restGetAllFoodOrderDataPdf(
			@RequestBody DataTableRequest request) {
		logger.info("Method : RESTMODULE UserRestController restGetAllFoodOrderDataPdf starts");
		logger.info("Method : RESTMODULE UserRestController restGetAllFoodOrderDataPdf end");
		return userDao.getAllFoodOrderDataPdf(request);
	}

}
