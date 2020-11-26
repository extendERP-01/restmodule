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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.RestHrmEmployeeAppraisalFormDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeAppraisalFormListModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsEmployeeAppraisalFormModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmsEmployeeAppraisalFormModel;

@RestController
@RequestMapping("employee/")
public class RestHrmsEmployeeAppraisalFormController {
	Logger logger = LoggerFactory.getLogger(RestHrmsEmployeeAppraisalFormController.class);

	@Autowired
	RestHrmEmployeeAppraisalFormDao formDao;
	/*
	 * 
	 * view Appraisal Form
	 * 
	 * 
	 */
	@RequestMapping(value = "getEmployeeAppraisalForm", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>> getEmployeeAppraisalForm(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getEmployeeAppraisalForm starts");
		logger.info("Method : getEmployeeAppraisalForm ends");
		return formDao.getEmployeeAppraisalForm(request);
	}

	
	/*
	 * 
	 * view Appraisal Form-data table call
	 * 
	 * 
	 */
	@RequestMapping(value = "/fill-Appraisal-Form", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestHrmsEmployeeAppraisalFormModel>> fillAppraisalForm(
			@RequestParam("id") String id) {
		logger.info("Method : fillAppraisalForm for rest controller starts");
		////////////////////////////////////////////////////////////////////////////////////////
		RestHrmsEmployeeAppraisalFormModel abcd = formDao.fillAppraisalForm(id);

		List<HrmsEmployeeAppraisalFormListModel> childData = formDao.getChildData(abcd.getDept());
		abcd.setAppraisalList(childData);

		JsonResponse<RestHrmsEmployeeAppraisalFormModel> resp = new JsonResponse<RestHrmsEmployeeAppraisalFormModel>();
		resp.setBody(abcd);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<RestHrmsEmployeeAppraisalFormModel>> response = new ResponseEntity<JsonResponse<RestHrmsEmployeeAppraisalFormModel>>(
				resp, responseHeaders, HttpStatus.CREATED);
		///////////////////////////////////////////////////////////////////////////////////////

		logger.info("Method : fillAppraisalForm for rest controller ends");
		System.out.println(response);
		return response;
	}

	/*
	 * 
	 * PostMapping for submit Appraisal Form
	 * 
	 * 
	 */
	@RequestMapping(value = "submit-appraisal-form", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> submitAppraisalForm(
			@RequestBody List<RestHrmsEmployeeAppraisalFormModel> appraisalForm) {
		logger.info("Method : submitAppraisalForm starts");
		logger.info("Method : submitAppraisalForm ends");
		return formDao.submitAppraisalForm(appraisalForm);
	}
	
	
	/*
	 * Get Appraisal details to View in Modal of employee
	 *
	 */
	@RequestMapping(value = "/employeeAppraisalModalView", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestHrmsEmployeeAppraisalFormModel>>> employeeAppraisalModalView(
			@RequestParam("id") String id) {
		logger.info("Method : employeeAppraisalModalView starts");

		logger.info("Method : employeeAppraisalModalView ends");
		return formDao.employeeAppraisalModalView(id);
	}

}
