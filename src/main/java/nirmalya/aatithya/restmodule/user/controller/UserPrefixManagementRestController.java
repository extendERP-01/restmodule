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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.user.dao.UserPrefixManagementDao;
import nirmalya.aatithya.restmodule.user.model.UserPrefixManagementModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "user/")
public class UserPrefixManagementRestController {

	Logger logger = LoggerFactory.getLogger(UserPrefixManagementRestController.class);

	@Autowired
	UserPrefixManagementDao userPrefixManagementDao;
	
	/**
	 * USER PREFIX REST UPDATE
	 *
	 */
	@RequestMapping(value = "restUpdateUserPrefix", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restUpdateUserPrefix(@RequestBody UserPrefixManagementModel form) {
		logger.info("Method : RESTMODULE UserPrefixManagementRestController restUpdateUserPrefix starts");
		logger.info("Method : RESTMODULE UserPrefixManagementRestController restUpdateUserPrefix end");
		return userPrefixManagementDao.updateUserPrefix(form);
	}
	/**
	 * USER PREFIX REST VIEW
	 *
	 */
		@RequestMapping(value = "restGetAllUserPrefix", method = { RequestMethod.POST })
		public ResponseEntity<JsonResponse<List<UserPrefixManagementModel>>> getAllUserPrefix(
				@RequestBody DataTableRequest request) {
			logger.info("Method : RESTMODULE UserPrefixManagementRestController getAllUserPrefix starts");
			logger.info("Method : RESTMODULE UserPrefixManagementRestController getAllUserPrefix end");
			return userPrefixManagementDao.getAllUserPrefixList(request);
		}

		/**
		 * USER PREFIX REST DELETE
		 *
		 */
	
		@RequestMapping(value = "restDeleteUserPrefix", method = { RequestMethod.GET })
		public ResponseEntity<JsonResponse<Object>> deleteUserPrefix(@RequestParam String id) {
			logger.info("Method : RESTMODULE UserPrefixManagementRestController deleteUserPrefix starts");
			logger.info("Method : RESTMODULE UserPrefixManagementRestController deleteUserPrefix end");
	
			return userPrefixManagementDao.deleteUserPrefixData(id);
		}
	 
		/**
		 * USER PREFIX REST EDIT
		 *
		 */
	
	@RequestMapping(value = "/restGetUserPrefixById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<UserPrefixManagementModel>> getUserPrefixById(@RequestParam String id) {

		logger.info("Method : RESTMODULE UserPrefixManagementRestController getUserPrefixById starts");
		logger.info("Method : RESTMODULE UserPrefixManagementRestController getUserPrefixById end");

		return userPrefixManagementDao.getUserPrefixByIdList(id);
	}
	 
}
