package nirmalya.aatithya.restmodule.recruitment.controller;

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
import nirmalya.aatithya.restmodule.recruitment.dao.JobTitleDao;
import nirmalya.aatithya.restmodule.recruitment.model.JobTitleRestModel;

@RestController
@RequestMapping("recruitment")
public class JobTitleRestController {
	Logger logger = LoggerFactory.getLogger(JobTitleRestController.class);

	@Autowired
	JobTitleDao jobTitleDao;

	/**
	 * Rest Controller - Get department For Drop Down
	 *
	 */
	@RequestMapping(value = "/dropDownJobDepartment", method = { RequestMethod.GET })
	public List<DropDownModel> dropDownJobDepartment() {
		logger.info("Method : dropDownJobDepartment starts");

		logger.info("Method : dropDownJobDepartment ends");
		return jobTitleDao.getjobDepartmentList();
	}

	/**
	 * 
	 * Rest COntroller-get job type for Drop Down
	 */
	@RequestMapping(value = "/dropDownJobType", method = { RequestMethod.GET })
	public List<DropDownModel> getjobTypeList() {
		logger.info("Method : dropDownJobType starts");

		logger.info("Method : dropDownJobType ends");
		return jobTitleDao.getjobTypeList();
	}
	/**
	 * 
	 * Rest COntroller-get job Tittle for Drop Down
	 */
	@RequestMapping(value = "/dropDownJobTittle", method = { RequestMethod.GET })
	public List<DropDownModel> getjobTittleList() {
		logger.info("Method : dropDownJobType starts");

		logger.info("Method : dropDownJobType ends");
		return jobTitleDao.getjobTittleList();
	}



	/*
	 * 
	 * PostMapping for add Patient details
	 * 
	 * 
	 */
	@RequestMapping(value = "add-jobtitle-through-ajax", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addPatientDetailsPost(@RequestBody JobTitleRestModel job) {
		logger.info("Method : addJobDetailsPost starts");
		logger.info("Method : addJobDetailsPost ends");
		return jobTitleDao.addJobDetailsPost(job);
	}
	/**
	 * Ajax call to view patient details
	 */
	@RequestMapping(value = "getJobDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<JobTitleRestModel>>> getJobDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getJobDetails starts");

		logger.info("Method : getJobDetails ends");

		return jobTitleDao.getJobDetails(request);
	}
	/**
	 * delete particular Patient Details in model
	 *
	 */
	@RequestMapping(value = "/job-tittle-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteJobDetail(@RequestParam String id,@RequestParam String createdBy) {

		logger.info("Method : deleteJobDetails starts");

		logger.info("Method : deleteJobDetails end");

		return jobTitleDao.deleteJobDetail(id,createdBy);
	}
	 /**
	 * 
	 * view job For modal
	 * 
	 */
	@RequestMapping(value = "/view-job-modal-index", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<JobTitleRestModel>> getJobTitleModel(@RequestBody String id) {
		logger.info("Method : getVendorForModel starts");
		System.out.println("##############"+id);
		logger.info("Method : getVendorForModel endss");
		return jobTitleDao.getJobTitleModel(id);
	}
	/**
	 * for Patient Details Edit
	 */
	@RequestMapping(value = "/edit-job-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<JobTitleRestModel>> getJobDetailsEdit(@RequestParam String id) {
		logger.info("Method : getJobDetailsEdit starts");

		logger.info("Method : getJobDetailsEdit ends");

		return jobTitleDao.getJobDetailsEdit(id);
	}

}
/**
 * Rest Controller -Add Jobtitle
 *//*
	 * 
	 * @RequestMapping(value = "/restAddJob", method = { RequestMethod.POST })
	 * public ResponseEntity<JsonResponse<Object>> addJobDetailsPost(@RequestBody
	 * JobTitleRestModel job) { logger.info("Method : addJobDetailsPost starts");
	 * 
	 * logger.info("Method : addJobDetailsPost ends"); return
	 * jobTitleDao.addJobDetailsPost(job); }
	 */