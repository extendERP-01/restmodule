package nirmalya.aatithya.restmodule.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.sales.model.UserRolesAndModuleIdModel;
import nirmalya.aatithya.restmodule.user.dao.MenuDao;
import nirmalya.aatithya.restmodule.user.model.Menu;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "user/")
public class MenuController {

	Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	MenuDao menuDao;

	/**
	 * Function to get user menu
	 *
	 */
	@PostMapping(value = "getMenu")
	public ResponseEntity<JsonResponse<List<Menu>>> getMenu(@RequestBody List<String> role) {
		logger.info("Method : getMenu starts");

		logger.info("Method : getMenu ends");
		return menuDao.getUserMenu(role);
	}

	/**
	 * Function to get user menu
	 *
	 */
	@PostMapping(value = "get-function-list")
	public ResponseEntity<JsonResponse<List<Menu>>> getFunctionList(@RequestBody UserRolesAndModuleIdModel userModel) {
		logger.info("Method : getMenu starts");

		logger.info("Method : getMenu ends");
		return menuDao.getFunctionList(userModel);
	}

}
