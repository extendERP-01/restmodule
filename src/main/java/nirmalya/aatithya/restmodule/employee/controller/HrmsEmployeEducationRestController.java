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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeEducationDao;
import nirmalya.aatithya.restmodule.employee.model.HrmEmployeeEducationModel;

@RestController
@RequestMapping("employee/")
public class HrmsEmployeEducationRestController {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeSkillAssignRestController.class);

	@Autowired
	HrmsEmployeEducationDao hrmsEmployeEducationDao;

	/**
	 * 
	 * @return department list
	 */
	@RequestMapping(value = "getQualifList", method = { RequestMethod.GET })
	public List<DropDownModel> getQualifList() {

		logger.info("Method : getQualifList starts");
		logger.info("Method : getQualifList ends");

		return hrmsEmployeEducationDao.getQualifList();
	}

	/**
	 * 
	 * @return Employee list
	 */
	@RequestMapping(value = "getEmployeeList1", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeList() {

		logger.info("Method : getEmployeeList starts");
		logger.info("Method : getEmployeeList ends");

		return hrmsEmployeEducationDao.getEmployeeList();
	}

	/*
	 * for Add Other Service price getAssignEduDetails
	 */
	@RequestMapping(value = "restAddEmployeeEdu", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddEmployeeEdu(
			@RequestBody List<HrmEmployeeEducationModel> hrmEmployeeEducationModel) {
		logger.info("Method in rest: restAddEmployeeEdu starts");

		logger.info("Method in rest: restAddEmployeeEdu ends");

		return hrmsEmployeEducationDao.restAddEmployeeEdu(hrmEmployeeEducationModel);
	}

	/*
	 * for All assignSkill
	 */
	@RequestMapping(value = "getAssignEduDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmEmployeeEducationModel>>> getAssignEduDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAssignEduDetails starts");

		logger.info("Method : getAssignEduDetails ends");

		return hrmsEmployeEducationDao.getAssignEduDetails(request);
	}

	/*
	 * for assignSkill Edit
	 */
	@RequestMapping(value = "getAssignEducationById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmEmployeeEducationModel>>> getAssignEducationById(
			@RequestParam String empId) {
		logger.info("Method : getAssignEducationById starts");

		logger.info("Method : getAssignEducationById ends");

		return hrmsEmployeEducationDao.getAssignEducationById(empId);
	}

}
