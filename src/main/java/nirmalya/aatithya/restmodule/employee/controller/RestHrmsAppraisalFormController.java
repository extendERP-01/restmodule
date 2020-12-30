package nirmalya.aatithya.restmodule.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import nirmalya.aatithya.restmodule.employee.dao.RestHrmsAppraisalFormDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeAppraisalFormListModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsEmployeeAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsAppraisalFormModel;

@RestController
@RequestMapping("employee/")
public class RestHrmsAppraisalFormController {
	Logger logger = LoggerFactory.getLogger(RestHrmsAppraisalFormController.class);

	@Autowired
	RestHrmsAppraisalFormDao formDao;

	/*************************************************************************************************************************************************/
	/****************************************
	 * REST CONTROLLER FOR MANAGER
	 ****************************************/
	/*************************************************************************************************************************************************/

	/*
	 * Get Appraisal Form First Stage Details 'Datatable' call
	 * 
	 */

	@RequestMapping(value = "getManagerAppraisalForm", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> getManagerAppraisalForm(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getEmployeeAppraisalForm starts");
		logger.info("Method : getEmployeeAppraisalForm ends");
		return formDao.getManagerAppraisalForm(request);
	}

	/*
	 * First Stage Approval
	 */
	@RequestMapping(value = "appraisalFormApproval-manager", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalFormManagerApproval(
			@RequestParam("id") String id,@RequestParam("fromDate") String fromDate) {
		logger.info("Method : appraisalFormManagerApproval starts");

		logger.info("Method : appraisalFormManagerApproval ends");

		return formDao.appraisalFormManagerApproval(id,fromDate);
	}

	/*
	 * for First Stage Approval - Submit
	 */

	@RequestMapping(value = "submit-appraisal-form-manager", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> appraisalFormSubmit(
			@RequestBody List<HrmsAppraisalFormModel> managerAppraisalForm) {
		logger.info("Method : appraisalFormSubmit starts");
		logger.info("Method : appraisalFormSubmit ends");
		return formDao.appraisalFormSubmit(managerAppraisalForm);
	}
	/*
	 * for change appraisal Setup status
	 */
	@RequestMapping(value = "changeAppraisalSetupStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changeAppraisalSetupStatus(@RequestParam("id") String id,@RequestParam("fdate") String fdate) {
		logger.info("Method : changeAppraisalSetupStatus starts");

		logger.info("Method : changeAppraisalSetupStatus ends");

		return formDao.changeAppraisalSetupStatus(id,fdate);
	}
	

	/*
	 * Get Appraisal details to View in Modal 
	 *
	 */
	@RequestMapping(value = "/appraisalModalView-manager", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalModalViewManager(
			@RequestParam("id") String id) {
		logger.info("Method : appraisalModalViewManager starts");

		logger.info("Method : appraisalModalViewManager ends");
		return formDao.appraisalModalViewManager(id);
	}
	/*************************************************************************************************************************************************/
	/****************************************
	 * REST CONTROLLER FOR SUPER ADMIN
	 ****************************************/
	/*************************************************************************************************************************************************/

	/*
	 * Get Appraisal Form Second Stage Details 'Datatable' call
	 * 
	 */

	@RequestMapping(value = "getSuperAdminAppraisalForm", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> getSuperAdminAppraisalForm(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getSuperAdminAppraisalForm starts");
		logger.info("Method : getSuperAdminAppraisalForm ends");
		return formDao.getSuperAdminAppraisalForm(request);
	}

	/*
	 * for Second Stage Approval
	 */
	@RequestMapping(value = "appraisalFormApproval-admin", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalFormAdminApproval(
			@RequestParam("id") String id,@RequestParam("fromDate") String fromDate) {
		logger.info("Method : appraisalFormAdminApproval starts");

		logger.info("Method : appraisalFormAdminApproval ends");

		return formDao.appraisalFormAdminApproval(id,fromDate);
	}

	/*
	 * for Second Stage Approval - Submit
	 */

	@RequestMapping(value = "submit-appraisal-form-admin", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> appraisalFormAdminSubmit(
			@RequestBody List<HrmsAppraisalFormModel> adminAppraisalForm) {
		logger.info("Method : appraisalFormAdminSubmit starts");
		logger.info("Method : appraisalFormAdminSubmit ends");
		return formDao.appraisalFormAdminSubmit(adminAppraisalForm);
	}
	/*
	 * for change appraisal status
	 */
	@RequestMapping(value = "changeAppraisalStatus", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> changeAppraisalStatus(@RequestParam("id") String id) {
		logger.info("Method : changeAppraisalStatus starts");

		logger.info("Method : changeAppraisalStatus ends");

		return formDao.changeAppraisalStatus(id);
	}
	
	/*
	 * Reject Appraisal-Super Admin
	 *
	 */
	@RequestMapping(value = "rejectAppraisalToManager", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> rejectAppraisalToManager(@RequestParam("id") String id,@RequestParam("fdate") String fdate) {
		logger.info("Method : rejectAppraisalToManager starts");

		logger.info("Method : rejectAppraisalToManager ends");

		return formDao.rejectAppraisalToManager(id,fdate);
	}
	/*
	 * Resubmit Appraisal-Super Admin
	 *
	 */
	@RequestMapping(value = "resubmitAppraisal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> resubmitAppraisal(@RequestParam("id") String id,@RequestParam("fdate") String fdate) {
		logger.info("Method : rejectAppraisalToManager starts");

		logger.info("Method : rejectAppraisalToManager ends");

		return formDao.resubmitAppraisal(id,fdate);
				
	}
	
	/*
	 * Get Appraisal details to View in Modal of Super Admin
	 *
	 */
	@RequestMapping(value = "/appraisalModalView-superAdmin", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalModalViewSuperAdmin(
			@RequestParam("id") String id) {
		logger.info("Method : appraisalModalViewSuperAdmin starts");

		logger.info("Method : appraisalModalViewSuperAdmin ends");
		return formDao.appraisalModalViewSuperAdmin(id);
	}
	/*************************************************************************************************************************************************/
	/****************************************
	 * REST CONTROLLER FOR COMMOM USE
	 ****************************************/
	/*************************************************************************************************************************************************/
	/*
	 * Get Appraisal Common Form Details 'Datatable' call
	 * 
	 */

	@RequestMapping(value = "getCommonAppraisalForm", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> getCommonAppraisalForm(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getCommonAppraisalForm starts");
		logger.info("Method : getCommonAppraisalForm ends");
		return formDao.getCommonAppraisalForm(request);
	}
	
	/*
	 * for Common Comments
	 */
	@RequestMapping(value = "appraisalCommonForm", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsAppraisalFormModel>>> appraisalCommonForm(
			@RequestParam("id") String id,@RequestParam("fromDate") String fromDate) {
		logger.info("Method : appraisalCommonForm starts");

		logger.info("Method : appraisalCommonForm ends");

		return formDao.appraisalCommonForm(id,fromDate);
	}
	/*
	 * for Common Comments - Submit
	 */

	@RequestMapping(value = "submit-appraisal-form-common", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> appraisalFormCommonSubmit(
			@RequestBody List<HrmsAppraisalFormModel> commonAppraisalForm) {
		logger.info("Method : appraisalFormCommonSubmit starts");
		logger.info("Method : appraisalFormCommonSubmit ends");
		return formDao.appraisalFormCommonSubmit(commonAppraisalForm);
	}
	
}
