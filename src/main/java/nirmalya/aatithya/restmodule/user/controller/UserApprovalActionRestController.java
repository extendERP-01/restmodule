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
import nirmalya.aatithya.restmodule.user.dao.UserApprovalActionDao;
import nirmalya.aatithya.restmodule.user.model.UserApprovalActionModel;

@RestController
@RequestMapping("user/")
public class UserApprovalActionRestController {

	Logger logger = LoggerFactory.getLogger(UserApprovalActionRestController.class);

	@Autowired
	UserApprovalActionDao userApprovalActionDao;

	/*
	 * for All approval action
	 */
	@RequestMapping(value = "getAllApprovals", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<UserApprovalActionModel>>> getAllApprovals(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllApprovals starts");

		logger.info("Method : getAllApprovals ends");

		return userApprovalActionDao.getAllApprovals(request);
	}

	/*
	 * for Add Approval action
	 */
	@RequestMapping(value = "restAddApproval", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddApproval(@RequestBody UserApprovalActionModel approval) {
		logger.info("Method : restAddApproval starts");

		logger.info("Method : restAddApproval ends");

		return userApprovalActionDao.addApproval(approval);
	}

	/*
	 * for get approval by id
	 */
	@RequestMapping(value = "getApprovalById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<UserApprovalActionModel>> getApprovalById(@RequestParam String id) {
		logger.info("Method : getApprovalById starts");

		logger.info("Method : getApprovalById ends");

		return userApprovalActionDao.getApprovalById(id);
	}

	/*
	 * for delete approval action
	 */
	@RequestMapping(value = "deleteApprovalById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteApprovalById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteApprovalById starts");

		logger.info("Method : deleteApprovalById ends");

		return userApprovalActionDao.deleteApprovalById(id, createdBy);
	}

}
