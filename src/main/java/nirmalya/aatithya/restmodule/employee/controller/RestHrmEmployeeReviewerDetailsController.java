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
import nirmalya.aatithya.restmodule.employee.dao.RestHrmEmployeeReviewerDetailsDao;
import nirmalya.aatithya.restmodule.employee.model.RestHrmEmployeeReviewerDetailsModel;

@RestController
@RequestMapping("employee/")
public class RestHrmEmployeeReviewerDetailsController {
	Logger logger = LoggerFactory.getLogger(RestHrmEmployeeReviewerDetailsController.class);

	@Autowired
	RestHrmEmployeeReviewerDetailsDao reviewerDao;

	/*
	 * 
	 * method for Auto Search of Employee
	 */
	@RequestMapping(value = "/getEmployeeListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeListAutoComplete(@RequestParam String id) {
		logger.info("Method : getEmployeeListAutoComplete starts");

		logger.info("Method : getEmployeeListAutoComplete ends");
		return reviewerDao.getEmployeeListAutoComplete(id);

	}

	/*
	 * for get Employee role list
	 */
	@RequestMapping(value = "getEmployeeRoleList", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeRoleList() {

		logger.info("Method : getEmployeeRoleList starts");
		logger.info("Method : getEmployeeRoleList ends");

		return reviewerDao.getEmployeeRoleList();
	}

	/*
	 * for get Employee role list
	 */
	@RequestMapping(value = "getAppraisalPolicyList", method = { RequestMethod.GET })
	public List<DropDownModel> getAppraisalPolicyList() {

		logger.info("Method : getAppraisalPolicyList starts");
		logger.info("Method : getAppraisalPolicyList ends");

		return reviewerDao.getAppraisalPolicyList();
	}
	/*
	 * for get Employee role list
	 */
	@RequestMapping(value = "getAppraisalFinancialYear", method = { RequestMethod.GET })
	public List<DropDownModel> getAppraisalFinancialYear() {

		logger.info("Method : getAppraisalFinancialYear starts");
		logger.info("Method : getAppraisalFinancialYear ends");

		return reviewerDao.getAppraisalFinancialYear();
	}
	/*
	 * 
	 * Get mapping for get employee name list
	 * 
	 */
	@RequestMapping(value = "rest-get-emp-name", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeNameAJAX(@RequestParam String id) {
		logger.info("Method : getEmployeeNameAJAX starts");
		logger.info("Method : getEmployeeNameAJAX ends");
		return reviewerDao.getEmployeeNameAJAX(id);
	}

	/*
	 * 
	 * PostMapping for add KRAMeasure details
	 * 
	 * 
	 */

	@RequestMapping(value = "add-employee-appraisal-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addEmployeeAppraisalDetails(
			@RequestBody List<RestHrmEmployeeReviewerDetailsModel> reviewerAssign) {
		logger.info("Method : addEmployeeAppraisalDetails starts");
		logger.info("Method : addEmployeeAppraisalDetails ends");
		return reviewerDao.addEmployeeAppraisalDetails(reviewerAssign);
	}

	/*
	 * for job title list view
	 * 
	 * 
	 */
	@RequestMapping(value = "getEmployeereviewDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestHrmEmployeeReviewerDetailsModel>>> getEmployeereviewDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getEmployeereviewDetails starts");
		logger.info("Method : getEmployeereviewDetails ends");
		return reviewerDao.getEmployeereviewDetails(request);
	}

	/*
	 * for job title list Delete
	 */
	@RequestMapping(value = "deleteAppraisalDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAppraisalDetails(@RequestParam String id) {
		logger.info("Method : deleteAppraisalDetails starts");
		logger.info("Method : deleteAppraisalDetails ends");
		return reviewerDao.deleteAppraisalDetails(id);
	}

	/*
	 * returns particular job title list to view
	 *
	 */

	@RequestMapping(value = "/viewAppraisalDetailsModel", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestHrmEmployeeReviewerDetailsModel>> viewAppraisalDetailsModel(
			@RequestParam String id) {
		logger.info("Method : viewAppraisalDetailsModel starts");
		logger.info("Method : viewAppraisalDetailsModel ends");
		return reviewerDao.viewAppraisalDetailsModel(id);
	}

	/*
	 * for appraisal details Edit
	 */

	@RequestMapping(value = "/edit-appraisal-details", method = { RequestMethod.GET })
	public List<RestHrmEmployeeReviewerDetailsModel> editAppraisalDetails(@RequestParam("id") String id) {
		logger.info("Method : editAppraisalDetails for rest controller starts");

		logger.info("Method : editAppraisalDetails for rest controller ends");
		return reviewerDao.editAppraisalDetails(id);
	}

	/*
	 * 
	 * Get mapping for get employee name list
	 * 
	 */
	@RequestMapping(value = "get-user-nameEdit-list", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeName(@RequestParam String id) {
		logger.info("Method : getEmployeeName starts");
		logger.info("Method : getEmployeeName ends");
		return reviewerDao.getEmployeeName(id);
	}

	@RequestMapping(value = "get-user-selected-list", method = { RequestMethod.GET })
	public List<DropDownModel> getSelectedList(@RequestParam String id, @RequestParam String role) {
		logger.info("Method : getSelectedList starts");
		logger.info("Method : getSelectedList ends");
		return reviewerDao.getSelectedList(id, role);
	}
	
	/*
	 * 
	 * Get mapping for get job title list
	 * 
	 */
	@RequestMapping(value = "rest-get-financial-fromdate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getFinancialFromDate(@RequestParam String id) {
		logger.info("Method : getFinancialFromDate starts");
		logger.info("Method : getFinancialFromDate ends");
		return reviewerDao.getFinancialFromDate(id);
	}
}
