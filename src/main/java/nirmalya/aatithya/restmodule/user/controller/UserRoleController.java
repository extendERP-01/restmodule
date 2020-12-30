/**Defines User Role Rest Controller*/
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

import nirmalya.aatithya.restmodule.common.utils.DataSetForActivity;
import nirmalya.aatithya.restmodule.common.utils.DataSetForFunction; 
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse; 
import nirmalya.aatithya.restmodule.user.dao.UserRoleDao;
import nirmalya.aatithya.restmodule.user.model.UserRoleModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "user")
public class UserRoleController {

	Logger logger = LoggerFactory.getLogger(UserRoleController.class);

	@Autowired
	UserRoleDao userroleDao;

	/*
	 * 
	 * getCostCenterName
	 * 
	 */
	@RequestMapping(value = "getCostCenterName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCostCenterName(String getStateName) {
		logger.info("Method : getCostCenterName starts");
		logger.info("Method : getCostCenterName ends");
		return userroleDao.getCostCenterName("getCostCenterName");
	}

	/*
	 * 
	 * getModuleDetails
	 * 
	 */
	@RequestMapping(value = "getModuleDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getModuleDetails(String getModuleDetails) {
		logger.info("Method : getModuleDetails starts");
		logger.info("Method : getModuleDetails ends");
		return userroleDao.getModuleDetails("getModuleDetails");
	}

	/*
	 * 
	 * getActivityDetails
	 * 
	 */
	@RequestMapping(value = "getActivityDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DataSetForActivity>>> getActivityDetails(String getActivityDetails) {
		logger.info("Method : getActivityDetails starts");
		logger.info("Method : getActivityDetails ends");
		return userroleDao.getActivityDetails("getActivityDetails");
	}

	/*
	 * 
	 * getfunctionDetails getActivityDetails
	 * 
	 */
	@RequestMapping(value = "getfunctionDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DataSetForFunction>>> getfunctionDetails(String getfunctionDetails) {
		logger.info("Method : getfunctionDetails starts");
		logger.info("Method : getfunctionDetails ends");
		return userroleDao.getfunctionDetails("getfunctionDetails");
	}

	/*
	 * 
	 * getParentName
	 * 
	 */
	@RequestMapping(value = "getParentName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getParentName(String getParentName) {
		logger.info("Method : getParentName starts");
		logger.info("Method : getParentName ends");
		return userroleDao.getParentName("getParentName");
	}

	/**
	 * Post Mapping to AddUserRole Record
	 *
	 */
	@RequestMapping(value = "restAddUserRole", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddUserRole(@RequestBody List<UserRoleModel> table) {
		logger.info("Method : restAddUserRole starts");
		logger.info("Method : restAddUserRole ends");
		return userroleDao.addUserRole(table);
	}

	@RequestMapping(value = "getUserRoleData", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserRoleModel>>> getTableMaster(@RequestBody DataTableRequest request) {
		logger.info("Method : getUserRoleData starts");
		logger.info("Method : getUserRoleData ends");
		return userroleDao.getUserRoleDetails(request);
	}

	/*
	 * returns particular to delete
	 *
	 */

	@RequestMapping(value = "/deleteUserRoleById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteUserRoleById(@RequestParam("id") String id) {
		logger.info("Method : deleteUserRoleById starts");
		logger.info("Method : deleteUserRoleById ends");
		return userroleDao.deleteUserRoleById(id);
	}

	/*
	 * returns particular to getModuleCheckDtls
	 *
	 */
	@RequestMapping(value = "getModuleCheckDtls", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getModuleCheckDtls(String getModuleCheckDtls,
			@RequestParam String id) {
		logger.info("Method : getModuleCheckDtls starts");

		logger.info("Method : getModuleCheckDtls ends");
		return userroleDao.getModuleCheckDtls("getModuleCheckDtls", id);
	}

	/*
	 * returns particular to getFunctionCheckDtls
	 *
	 */
	@RequestMapping(value = "getFunctionCheckDtls", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getFunctionCheckDtls(String getFunctionCheckDtls,
			@RequestParam String id) {
		logger.info("Method : getFunctionCheckDtls starts");

		logger.info("Method : getFunctionCheckDtls ends");
		return userroleDao.getFunctionCheckDtls("getFunctionCheckDtls", id);
	}

	/*
	 * returns particular to getActivityCheckDtls
	 *
	 */
	@RequestMapping(value = "getActivityCheckDtls", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getActivityCheckDtls(String getActivityCheckDtls,
			@RequestParam String id) {
		logger.info("Method : getActivityCheckDtls starts");

		logger.info("Method : getActivityCheckDtls ends");
		return userroleDao.getActivityCheckDtls("getActivityCheckDtls", id);
	}

	/*
	 * returns particular UserRole to view/edit
	 *
	 */
	@RequestMapping(value = "/getUserRoleById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<UserRoleModel>> getUserRoleById(@RequestParam("id") String id,
			@RequestParam("Action") String action) {
		logger.info("Method : getUserRoleById starts");

		logger.info("Method : getUserRoleById ends");
		return userroleDao.getUserRoleById(id, action);
	}

}
