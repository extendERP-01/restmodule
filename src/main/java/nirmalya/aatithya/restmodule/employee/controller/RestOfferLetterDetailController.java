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
import nirmalya.aatithya.restmodule.employee.dao.RestOfferLetterDetailDao;
import nirmalya.aatithya.restmodule.employee.model.EmployeeOfferLetterSalaryDetailsModel;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeModel;

import nirmalya.aatithya.restmodule.employee.model.RestOfferLetterDetailModel;
import nirmalya.aatithya.restmodule.recruitment.model.ResourceModel;

/**
 * 
 * @author Nirmalya
 *
 */
@RestController
@RequestMapping("employee/")
public class RestOfferLetterDetailController {
	Logger logger = LoggerFactory.getLogger(RestOfferLetterDetailController.class);

	@Autowired
	RestOfferLetterDetailDao offerLetterDao;

	/*
	 * 
	 * PostMapping for add get nationality
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-nationalityList", method = { RequestMethod.GET })
	public List<DropDownModel> getNationality() {
		logger.info("Method : getNationality starts");
		logger.info("Method : getNationality ends");
		return offerLetterDao.getNationality();
	}

	/*
	 * 
	 * PostMapping for add get Pay Grade List
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-payGradeList", method = { RequestMethod.GET })
	public List<DropDownModel> getPayGradeList() {
		logger.info("Method : getPayGradeList starts");
		logger.info("Method : getPayGradeList ends");
		return offerLetterDao.getPayGradeList();
	}
	/*
	 * 
	 * PostMapping for add get Job Title List
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-jobList", method = { RequestMethod.GET })
	public List<DropDownModel> getJobTitle() {
		logger.info("Method : getJobTitle starts");
		logger.info("Method : getJobTitle ends");
		return offerLetterDao.getJobTitle();
	}
	/*
	 * 
	 * PostMapping for add get Country List
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-countryList", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryList() {
		logger.info("Method : getCountryList starts");
		logger.info("Method : getCountryList ends");
		return offerLetterDao.getCountryList();
	}

	/*
	 * 
	 * Get mapping for get State name
	 * 
	 */
	@RequestMapping(value = "rest-get-stateNameList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateList(@RequestParam String id) {
		logger.info("Method : getStateList starts");
		logger.info("Method : getStateList ends");
		return offerLetterDao.getStateList(id);
	}

	/*
	 * 
	 * Get mapping for get District name
	 * 
	 */
	@RequestMapping(value = "rest-get-districtNameList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictList(@RequestParam String id) {
		logger.info("Method : getDistrictList starts");
		logger.info("Method : getDistrictList ends");
		return offerLetterDao.getDistrictList(id);
	}

	/*
	 * 
	 * Get mapping for get salary Component
	 * 
	 */
	@RequestMapping(value = "rest-get-salaryComponent", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> getSalaryComponentAjax(
			@RequestParam String id) {
		logger.info("Method : getSalaryComponentAjax starts");

		logger.info("Method : getSalaryComponentAjax ends");
		return offerLetterDao.getSalaryComponentAjax(id);
	}

	
	/*
	 * 
	 * PostMapping for add get nationality
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-employeeGenderList", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeGenderList() {
		logger.info("Method : getEmployeeGenderList starts");
		logger.info("Method : getEmployeeGenderList ends");
		return offerLetterDao.getEmployeeGenderList();
	}

	/*
	 * 
	 * PostMapping for add get nationality
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-employeeMaritalList", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeMaritalList() {
		logger.info("Method : getEmployeeMaritalList starts");
		logger.info("Method : getEmployeeMaritalList ends");
		return offerLetterDao.getEmployeeMaritalList();
	}

	
	
	/*
	 * 
	 * PostMapping for add KRAMeasure details
	 * 
	 * 
	 */
	@RequestMapping(value = "add-offer-letter-dtls", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addOfferLetterDetailsPost(
			@RequestBody List<RestOfferLetterDetailModel> offerLetterDtls) {
		logger.info("Method : addOfferLetterDetailsPost starts");
		logger.info("Method : addOfferLetterDetailsPost ends");
		return offerLetterDao.addOfferLetterDetailsPost(offerLetterDtls);
	}

	/*
	 * view all Offer Letter Details
	 */
	@RequestMapping(value = "viewOfferLetterDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> viewOfferLetterDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewOfferLetterDetails starts");

		logger.info("Method : viewOfferLetterDetails ends");

		return offerLetterDao.viewOfferLetterDetails(request);
	}

	/*
	 * Get Goal Master for edit
	 */
	@RequestMapping(value = "editOfferLetterDtlsById", method = { RequestMethod.GET })
	public List<RestOfferLetterDetailModel> editOfferLetterDtls(@RequestParam("id") String id,
			@RequestParam("grade") String grade) {
		logger.info("Method : editOfferLetterDtls for rest controller starts");

		logger.info("Method : editOfferLetterDtls for rest controller ends");
		return offerLetterDao.editOfferLetterDtls(id, grade);
	}

	/*
	 * 
	 * PostMapping for add property type in dropdown
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-editDistList", method = { RequestMethod.GET })
	public List<DropDownModel> getDistListForEdit(@RequestParam("id") String tState) {
		logger.info("Method : getDistListForEdit starts");
		logger.info("Method : getDistListForEdit ends");
		return offerLetterDao.getDistListForEdit(tState);
	}
	/*
	 * 
	 * PostMapping for add property type in dropdown
	 * 
	 * 
	 */

	@RequestMapping(value = "rest-get-editStateList", method = { RequestMethod.GET })
	public List<DropDownModel> getStateListForEdit(@RequestParam("id") String tCountry) {
		logger.info("Method : getStateListForEdit starts");
		logger.info("Method : getStateListForEdit ends");
		return offerLetterDao.getStateListForEdit(tCountry);
	}
	/*
	 * Get Offer Letter Details Model View
	 */

	@RequestMapping(value = "/offerLetterDetailsModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> offerLetterDetailsModal(
			@RequestParam String id) {
		logger.info("Method : offerLetterDetailsModal starts");

		logger.info("Method : offerLetterDetailsModal ends");
		return offerLetterDao.offerLetterDetailsModal(id);
	}

	/*
	 * Get particular offer letter details for Delete
	 */
	@RequestMapping(value = "deleteLetterDetailsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteLetterDetailsById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteLetterDetailsById starts");

		logger.info("Method : deleteLetterDetailsById ends");

		return offerLetterDao.deleteLetterDetailsById(id, createdBy);
	}
	
	/*
	 * for Beauty service expenses invoice
	 */
	@RequestMapping(value = "/offerLetterDetailsPDF", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> viewOfferLetterDetailsPDF(
			@RequestParam("id") String id) {
		logger.info("Method : viewOfferLetterDetailsPDF for rest controller starts");

		logger.info("Method : viewOfferLetterDetailsPDF for rest controller ends");
		return offerLetterDao.viewOfferLetterDetailsPDF(id);
	}
	
	

	/***************************************************************************************************************************************************/
	/********************************************APPOINTMENT LETTER CONTROLLER**************************************************/
	/***************************************************************************************************************************************************/
	


	/*
	 * First Stage Approval
	 */
	@RequestMapping(value = "getEmployeeDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<EmployeeOfferLetterSalaryDetailsModel>>> getEmployeeDetails(
			@RequestParam("id") String id) {
		logger.info("Method : getEmployeeDetails starts");

		logger.info("Method : getEmployeeDetails ends");

		return offerLetterDao.getEmployeeDetails(id);
	}
	
	/*
	 * 
	 * Get mapping for get Designation name
	 * 
	 */
	@RequestMapping(value = "rest-get-designation", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDesignationList(@RequestParam String id) {
		logger.info("Method : getDesignationList starts");
		logger.info("Method : getDesignationList ends");
		return offerLetterDao.getDesignationList(id);
	}
	/*
	 * for First Stage Approval - Submit
	 */

	@RequestMapping(value = "submit-employee-details-form", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> employeeDetailsFormSubmit(
			@RequestBody List<EmployeeOfferLetterSalaryDetailsModel> employeeComponentDetails) {
		logger.info("Method : employeeDetailsFormSubmit starts");
		logger.info("Method : employeeDetailsFormSubmit ends");
		return offerLetterDao.employeeDetailsFormSubmit(employeeComponentDetails);
	}
	
	@RequestMapping(value = "viewOfferLetter", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestOfferLetterDetailModel>>> viewOfferLetter() {
		logger.info("Method : viewOfferLetter starts");

		logger.info("Method : viewOfferLetter ends");
		return offerLetterDao.viewOfferLetter();
	}
	
	@RequestMapping(value = "generateAppointmentletter", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestOfferLetterDetailModel>> generateAppointmentLetter(@RequestParam String id) {
		logger.info("Method : generateAppointmentLetter starts");

		logger.info("Method : generateAppointmentLetter ends");
		return offerLetterDao.generateAppointmentLetter(id);
	}
	
}
