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
import nirmalya.aatithya.restmodule.user.dao.UserAuthorityDao;
import nirmalya.aatithya.restmodule.user.model.UserSetAuthority;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "user/")
public class UserSetAuthorityRestController {
	Logger logger = LoggerFactory.getLogger(UserSetAuthorityRestController.class);

	@Autowired
	UserAuthorityDao userAuthorityDao;

	/**
	 * returns Process for drop down model
	 *
	 */
	@RequestMapping(value = "/getProcess", method = { RequestMethod.GET })
	public List<DropDownModel> getProcess() {
		logger.info("Method : getProcess starts");

		logger.info("Method : getProcess end");
		return userAuthorityDao.getProcess();
	}

	/**
	 * returns user role for drop down model
	 *
	 */
	@RequestMapping(value = "/getUserRole", method = { RequestMethod.GET })
	public List<DropDownModel> getUserRole() {
		logger.info("Method : getUserRole starts");

		logger.info("Method : getUserRole end");
		return userAuthorityDao.getUserRole();
	}

	/**
	 * GetMapping to get user name from user role
	 * 
	 */

	@RequestMapping(value = "get-username-from-userrole", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUserNameFromUserRole(@RequestParam String id) {
		logger.info("Method : getUserNameFromUserRole starts");
		logger.info("Method : getUserNameFromUserRole endss");
		return userAuthorityDao.getUserNameFromUserRole(id);
	}

	/**
	 * returns user data for drop down model
	 *
	 */
	@RequestMapping(value = "/getUserData", method = { RequestMethod.GET })
	public List<DropDownModel> getUserData() {
		logger.info("Method : getUserData starts");

		logger.info("Method : getUserData end");
		return userAuthorityDao.getUserData();
	}

	/**
	 * returns language for drop down model
	 *
	 */
	@RequestMapping(value = "/getApproval", method = { RequestMethod.GET })
	public List<DropDownModel> getApproval() {
		logger.info("Method : getApproval starts");
		logger.info("Method : getApproval end");
		return userAuthorityDao.getApproval();
	}

	/**
	 * returns add user set authority
	 *
	 */
	@RequestMapping(value = "addSetAuthority", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addSetAuthority(@RequestBody List<UserSetAuthority> setAuthority) {
		logger.info("Method : addSetAuthority starts");
		logger.info("Method : addSetAuthority ends");
		return userAuthorityDao.addSetAuthority(setAuthority);
	}

	/**
	 * returns get all user set authority
	 *
	 */
	@RequestMapping(value = "/getAllSetAuthority", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserSetAuthority>>> getAllSetAuthority(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllSetAuthority starts");
		logger.info("Method : getAllSetAuthority end");
		return userAuthorityDao.getAllSetAuthority(request);
	}

	/**
	 * returns edit user list
	 *
	 */
	@RequestMapping(value = "get-user-edit-list", method = { RequestMethod.GET })
	public List<DropDownModel> getUserEditList(@RequestParam String id) {
		logger.info("Method : getUserEditList starts");
		logger.info("Method : getUserEditList ends");
		return userAuthorityDao.getUserEditList(id);
	}

	/**
	 * returns edit set authority
	 *
	 */
	@RequestMapping(value = "/edit-set-authority-ById", method = { RequestMethod.GET })
	public List<UserSetAuthority> getSetAuthorityById(@RequestParam("id") String id) {
		logger.info("Method : getSetAuthorityById starts");
		logger.info("Method : getSetAuthorityById ends");
		return userAuthorityDao.getSetAuthorityById(id);
	}

	/**
	 * returns get data of selected user for edit
	 *
	 */
	@RequestMapping(value = "rest-selected-user", method = { RequestMethod.GET })
	public List<DropDownModel> selectedUserList(@RequestParam String id, @RequestParam String catId) {
		logger.info("Method : selectedUserList starts");
		logger.info("Method : selectedUserList ends");
		return userAuthorityDao.selectedUserList(id, catId);
	}

	/**
	 * returns model view for set authority
	 *
	 */
	@RequestMapping(value = "/get-set-authority-ById-model", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<UserSetAuthority>>> getSetAuthorityByIdModel(@RequestParam String id) {
		logger.info("Method : getSetAuthorityByIdModel starts");
		logger.info("Method : getSetAuthorityByIdModel ends");
		return userAuthorityDao.getSetAuthorityByIdModel(id);
	}
}
