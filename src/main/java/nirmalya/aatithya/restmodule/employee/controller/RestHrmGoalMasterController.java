package nirmalya.aatithya.restmodule.employee.controller;

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
import nirmalya.aatithya.restmodule.employee.dao.RestHrmGoalMasterDao;
import nirmalya.aatithya.restmodule.employee.model.RestHrmGoalMasterModel;

@RestController
@RequestMapping("employee/")
public class RestHrmGoalMasterController {
	Logger logger = LoggerFactory.getLogger(RestHrmGoalMasterController.class);

	@Autowired
	RestHrmGoalMasterDao goalDao;

	/*
	 * for add goal
	 */
	@RequestMapping(value = "restAddGoal", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddGoal(@RequestBody RestHrmGoalMasterModel goalMaster) {
		logger.info("Method : restAddGoal starts");

		logger.info("Method : restAddGoal ends");

		return goalDao.adddepartment(goalMaster);
	}

	/*
	 * view all goal master
	 */
	@RequestMapping(value = "getGoalDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestHrmGoalMasterModel>>> getGoalDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getGoalDetails starts");

		logger.info("Method : getGoalDetails ends");

		return goalDao.getGoalDetails(request);
	}

	/*
	 * Get Goal Master for edit
	 */
	@RequestMapping(value = "getGoalMasterById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestHrmGoalMasterModel>> getGoalMasterById(@RequestParam String id) {
		logger.info("Method : getGoalMasterById starts");

		logger.info("Method : getGoalMasterById ends");

		return goalDao.getGoalMasterById(id);
	}

	/*
	 * Get Goal Master for Delete
	 */
	@RequestMapping(value = "deleteGoalMasterById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteGoalMasterById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteGoalMasterById starts");

		logger.info("Method : deleteGoalMasterById ends");

		return goalDao.deleteGoalMasterById(id, createdBy);
	}
}
