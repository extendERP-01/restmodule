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
import nirmalya.aatithya.restmodule.employee.dao.RestGradeSalaryMasterDao;
import nirmalya.aatithya.restmodule.employee.model.RestGradeSalaryMasterModel;

@RestController
@RequestMapping("employee/")
public class RestGradeSalaryMasterController {
	Logger logger = LoggerFactory.getLogger(RestGradeSalaryMasterController.class);

	@Autowired
	RestGradeSalaryMasterDao gradeSalaryDao;

	/*
	 * for get grade name list
	 */
	@RequestMapping(value = "getGradeNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getGradeNameList() {

		logger.info("Method : getGradeNameList starts");
		logger.info("Method : getGradeNameList ends");

		return gradeSalaryDao.getGradeNameList();
	}

	/*
	 * for get components list
	 */
	@RequestMapping(value = "getComponentList", method = { RequestMethod.GET })
	public List<DropDownModel> getComponentList() {

		logger.info("Method : getComponentList starts");
		logger.info("Method : getComponentList ends");

		return gradeSalaryDao.getComponentList();
	}

	/*
	 * 
	 * Get mapping for get Grade Description
	 * 
	 * 
	 */

	@RequestMapping(value = "/rest-get-gradeDesc", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getGradeDesc(@RequestParam String id) {
		logger.info("Method : getGradeDesc starts");

		logger.info("Method : getGradeDesc endss");
		return gradeSalaryDao.getGradeDesc(id);
	}
	/*
	 * 
	 * Get mapping for get Grade Description
	 * 
	 * 
	 */

	@RequestMapping(value = "/rest-get-componentType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>> getComponentType(@RequestParam String id) {
		logger.info("Method : getComponentType starts");

		logger.info("Method : getComponentType endss");
		return gradeSalaryDao.getComponentType(id);
	}

	/*
	 * 
	 * PostMapping for add Grade Salary Master details
	 * 
	 * 
	 */
	@RequestMapping(value = "add-grade-salary-master", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addGradeSalaryMasterPost(
			@RequestBody List<RestGradeSalaryMasterModel> gradeSalaryMaster) {
		logger.info("Method : addGradeSalaryMasterPost starts");
		logger.info("Method : addGradeSalaryMasterPost ends");
		return gradeSalaryDao.addGradeSalaryMasterPost(gradeSalaryMaster);
	}

	/*
	 * for All Grade Salary Master details
	 */
	@RequestMapping(value = "getGradeSalaryMasterDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>> getGradeSalaryMasterDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getGradeSalaryMasterDetails starts");

		logger.info("Method : getGradeSalaryMasterDetails ends");

		return gradeSalaryDao.getGradeSalaryMasterDetails(request);
	}

	/*
	 * 
	 * Get Mapping for edit Grade Salary Master details
	 * 
	 */
	@RequestMapping(value = "/edit-grade-salary-master-ById", method = { RequestMethod.GET })
	public List<RestGradeSalaryMasterModel> editGradeSalaryMaster(@RequestParam("id") String id) {
		logger.info("Method : editGradeSalaryMaster for rest controller starts");

		logger.info("Method : editGradeSalaryMaster for rest controller ends");
		return gradeSalaryDao.editGradeSalaryMaster(id);
	}
	/*
	 * Get Grade Salary Master details to View in Modal
	 *
	 */

	@RequestMapping(value = "modelGradeSalaryMasterByTd", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestGradeSalaryMasterModel>>> modalGradeSalaryMaster(
			@RequestParam String id) {
		logger.info("Method : modalGradeSalaryMaster starts");

		logger.info("Method : modalGradeSalaryMaster ends");

		return gradeSalaryDao.modalGradeSalaryMaster(id);
	}

}
