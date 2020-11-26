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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeCertificationDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeCertificationModel;

@RestController
@RequestMapping("employee/")
public class HrmsEmployeeCertificationRestController {


	Logger logger = LoggerFactory.getLogger(HrmsEmployeeSkillAssignRestController.class);

	@Autowired
	HrmsEmployeeCertificationDao hrmsEmployeeCertificationDao;

	/**
	 * 
	 * @return certification  list
	 */
	@RequestMapping(value = "getCertifList", method = { RequestMethod.GET })
	public List<DropDownModel> getCertifList() {

		logger.info("Method : getCertifList starts");
		logger.info("Method : getCertifList ends");

		return hrmsEmployeeCertificationDao.getCertifList();
	}

	/**
	 * 
	 * @return Employee list
	 */
	@RequestMapping(value = "getEmployeeList2", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeList() {

		logger.info("Method : getEmployeeList starts");
		logger.info("Method : getEmployeeList ends");

		return hrmsEmployeeCertificationDao.getEmployeeList();
	}

	/*
	 * for Add  Assign certification Details
	 */
	@RequestMapping(value = "restAddEmployeeCert", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddEmployeeCert(
			@RequestBody List<HrmsEmployeeCertificationModel> hrmsEmployeeCertificationModel) {
		logger.info("Method in rest: restAddEmployeeCert starts");

		logger.info("Method in rest: restAddEmployeeCert ends");

		return hrmsEmployeeCertificationDao.restAddEmployeeCert(hrmsEmployeeCertificationModel);
	}

	/*
	 * for All assign certifications
	 */
	@RequestMapping(value = "getAssignCertDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeCertificationModel>>> getAssignEduDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAssignCertDetails starts");

		logger.info("Method : getAssignCertDetails ends");

		return hrmsEmployeeCertificationDao.getAssignCertDetails(request);
	}

	/*
	 * for assign certification Edit
	 */
	@RequestMapping(value = "getAssigncertificationById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeCertificationModel>>> getAssigncertificationById(
			@RequestParam String empId) {
		logger.info("Method : getAssigncertificationById starts");

		logger.info("Method : getAssigncertificationById ends");

		return hrmsEmployeeCertificationDao.getAssigncertificationById(empId);
	}

}
