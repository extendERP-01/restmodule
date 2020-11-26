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
import nirmalya.aatithya.restmodule.employee.dao.RestKRAMeasureDetailsDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsDepartmentMasterModel;
import nirmalya.aatithya.restmodule.employee.model.RestKRAMeasureDetailsModel;

@RestController
@RequestMapping("employee/")
public class RestKRAMeasureDetailsController {
	Logger logger = LoggerFactory.getLogger(RestKRAMeasureDetailsController.class);

	@Autowired
	RestKRAMeasureDetailsDao kraMeasureDao;
	
	/*
	 * for get department list
	 */
	@RequestMapping(value = "getDeptNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getDeptNameList() {

		logger.info("Method : getDeptNameList starts");
		logger.info("Method : getDeptNameList ends");

		return kraMeasureDao.getDeptNameList();
	}
	/*
	 * for get goal list
	 */
	@RequestMapping(value = "getGoalNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getGoalNameList() {

		logger.info("Method : getGoalNameList starts");
		logger.info("Method : getGoalNameList ends");

		return kraMeasureDao.getGoalNameList();
	}
	
	/*
	 * 
	 * Get mapping for get job title list
	 * 
	 */
	@RequestMapping(value = "rest-get-job-title", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getJobTitleName(@RequestParam String id) {
		logger.info("Method : getJobTitleName starts");
		logger.info("Method : getJobTitleName ends");
		return kraMeasureDao.getJobTitleName(id);
	}
	
	/*
	 * 
	 * PostMapping for add KRAMeasure details
	 * 
	 * 
	 */
	@RequestMapping(value = "add-KRAMeasuer-details", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addKRAMeasureDetails(
			@RequestBody List<RestKRAMeasureDetailsModel> measureDetails) {
		logger.info("Method : addKRAMeasureDetails starts");
		logger.info("Method : addKRAMeasureDetails ends");
		return kraMeasureDao.addKRAMeasureDetails(measureDetails);
	}
	
	/*
	 * for All KRAMeasure details
	 */
	@RequestMapping(value="getKRAMeasureDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<RestKRAMeasureDetailsModel>>> viewKRAMeasureDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : viewKRAMeasureDetails starts");
		
		logger.info("Method : viewKRAMeasureDetails ends");
		
		return kraMeasureDao.viewKRAMeasureDetails(request);
	}
	
	/*
	 * 
	 * Get Mapping for edit KRAMeasure details
	 * 
	 */
	@RequestMapping(value = "/edit-KRAMeasure-details-ById", method = { RequestMethod.GET })
	public List<RestKRAMeasureDetailsModel> editKRAMeasureDetails(@RequestParam("id") String deptId,
			@RequestParam("jobId") String jobId) {
		logger.info("Method : editKRAMeasureDetails for rest controller starts");

		logger.info("Method : editKRAMeasureDetails for rest controller ends");
		return kraMeasureDao.editKRAMeasureDetails(deptId, jobId);
	}
	

	
	/*
	 * Get job title foe edit
	 *
	 */
	@RequestMapping(value = "rest-get-jobTitle", method = { RequestMethod.GET })
	public List<DropDownModel> getJobTitle(@RequestParam String id) {
		logger.info("Method :  getJobTitle starts");
		logger.info("Method :  getJobTitle endss");
		return kraMeasureDao.getJobTitle(id);
	}
	
	
	
	
	/*
	 * Get KRAMeasure details to View in Modal
	 *
	 */
	@RequestMapping(value = "/getModalKRAMeasureDetailsById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestKRAMeasureDetailsModel>>> modalKRAMeasureDetails(
			@RequestParam("id") String deptId, @RequestParam("jobId") String jobId) {
		logger.info("Method : modalKRAMeasureDetails starts");

		logger.info("Method : modalKRAMeasureDetails ends");
		return kraMeasureDao.modalKRAMeasureDetails(deptId, jobId);
	}
}
