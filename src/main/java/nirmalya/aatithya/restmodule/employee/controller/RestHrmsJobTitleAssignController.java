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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.RestHrmsJobTitleAssignDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsJobTitleAssignModel;

@RestController
@RequestMapping("employee/")
public class RestHrmsJobTitleAssignController {
	Logger logger = LoggerFactory.getLogger(RestHrmsJobTitleAssignController.class);

	@Autowired
	RestHrmsJobTitleAssignDao titleAssignDao;

	/*
	 * Department list
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-department", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {
		logger.info("Method : getDepartmentList starts");
		logger.info("Method : getDepartmentList ends");
		return titleAssignDao.getDepartmentList();
	}

	/*
	 * 
	 * @return job title list
	 */
	@RequestMapping(value = "rest-get-jobTitleList", method = { RequestMethod.GET })
	public List<DropDownModel> getDeptJobTitleList() {
		logger.info("Method : getDeptJobTitleList starts");
		logger.info("Method : getDeptJobTitleList ends");
		return titleAssignDao.getDeptJobTitleList();
	}

	/*
	 * add Department Job Title
	 * 
	 * 
	 * 
	 */
	@RequestMapping(value = "restAddDeptJobTitle", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>> restAddDeptJobTitle(
			@RequestBody RestHrmsJobTitleAssignModel jobTitle) {
		logger.info("Method : restAddDeptJobTitle starts");
		logger.info("Method : restAddDeptJobTitle ends");
		return titleAssignDao.restAddDeptJobTitle(jobTitle);
	}

	/*
	 * for job title list view
	 * 
	 * 
	 */
	@RequestMapping(value = "getDepartmentJobTitleAssign", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestHrmsJobTitleAssignModel>>> getDepartmentJobTitleAssignDetail(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getDepartmentJobTitleAssignDetail starts");
		logger.info("Method : getDepartmentJobTitleAssignDetail ends");
		return titleAssignDao.getDepartmentJobTitleAssignDetail(request);
	}

	/*
	 * for job title list Edit
	 */
	@RequestMapping(value = "edit-jobTitle-assign", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>> editJobTitle(@RequestParam String id) {
		logger.info("Method : editJobTitle starts");
		logger.info("Method : editJobTitle ends");
		return titleAssignDao.editJobTitle(id);
	}

	/*
	 * for job title list Delete
	 */
	@RequestMapping(value = "deleteJobTitleAssign", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteJobTitle(@RequestParam String id) {
		logger.info("Method : deleteJobTitle starts");
		logger.info("Method : deleteJobTitle ends");
		return titleAssignDao.deleteJobTitle(id);
	}

	/*
	 * returns particular job title list to view
	 *
	 */
	@RequestMapping(value = "/viewJobTitleModel", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestHrmsJobTitleAssignModel>> viewJobTitleModel(@RequestParam String id) {
		logger.info("Method : viewJobTitleModel starts");
		logger.info("Method : viewJobTitleModel ends");
		return titleAssignDao.viewJobTitleModel(id);
	}
}
