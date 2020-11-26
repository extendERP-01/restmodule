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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeLanguageDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeLanguageModel;



@RestController
@RequestMapping("employee/")
public class HrmsEmployeeLanguageRestController {


	Logger logger = LoggerFactory.getLogger(HrmsEmployeeLanguageRestController.class);

	@Autowired
	HrmsEmployeeLanguageDao hrmsEmployeeLanguageDao;

	/**
	 * 
	 * @return language list
	 */
	@RequestMapping(value = "getLangList", method = { RequestMethod.GET })
	public List<DropDownModel> getLangList() {

		logger.info("Method : getLangList starts");
		logger.info("Method : getLangList ends");

		return hrmsEmployeeLanguageDao.getLangList();
	}
	
	/**
	 * 
	 * @return can do  list
	 */
	@RequestMapping(value = "getCanDo", method = { RequestMethod.GET })
	public List<DropDownModel> getCanDo() {

		logger.info("Method : getCanDo starts");
		logger.info("Method : getCanDo ends");

		return hrmsEmployeeLanguageDao.getCanDo();
	}

	/**
	 * 
	 * @return Employee list
	 */
	@RequestMapping(value = "getEmployeeList3", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeList() {

		logger.info("Method : getEmployeeList starts");
		logger.info("Method : getEmployeeList ends");

		return hrmsEmployeeLanguageDao.getEmployeeList();
	}

	/*
	 * for Add Other Service price getAssignEduDetails
	 */
	@RequestMapping(value = "restAddEmployeeLang", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddEmployeeEdu(
			@RequestBody List<HrmsEmployeeLanguageModel> hrmEmployeeLanguageModel) {
		logger.info("Method in rest: restAddEmployeeLang starts");

		logger.info("Method in rest: restAddEmployeeLang ends");

		return hrmsEmployeeLanguageDao.restAddEmployeeLang(hrmEmployeeLanguageModel);
	}

	/*
	 * for All assignSkill
	 */
	@RequestMapping(value = "getAssignLangDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeLanguageModel>>> getAssignEduDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAssignLangDetails starts");

		logger.info("Method : getAssignLangDetails ends");

		return hrmsEmployeeLanguageDao.getAssignLangDetails(request);
	}

	/*
	 * for assignSkill Edit
	 */
	@RequestMapping(value = "getAssignLanguageById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeLanguageModel>>> getAssignLanguageById(
			@RequestParam String empId) {
		logger.info("Method : getAssignLanguageById starts");

		logger.info("Method : getAssignLanguageById ends");

		return hrmsEmployeeLanguageDao.getAssignLanguageById(empId);
	}

}

