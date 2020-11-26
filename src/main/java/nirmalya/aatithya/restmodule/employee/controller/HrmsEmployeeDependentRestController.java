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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeDependentDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeDependentModel;

@RestController
@RequestMapping("employee/")
public class HrmsEmployeeDependentRestController {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeDependentRestController.class);

	@Autowired
	HrmsEmployeeDependentDao hrmsEmployeeDependentDao;

	/**
	 * 
	 * @return Dependent list
	 */
	@RequestMapping(value = "getDepndList1", method = { RequestMethod.GET })
	public List<DropDownModel> getDepndList() {

		logger.info("Method : getDepndList starts");
		logger.info("Method : getDepndList ends");

		return hrmsEmployeeDependentDao.getDepndList();
	}
	
	/**
	 * 
	 * @return can do  list
	 */
	@RequestMapping(value = "getRelations", method = { RequestMethod.GET })
	public List<DropDownModel> getRelations() {

		logger.info("Method : getRelations starts");
		logger.info("Method : getRelations ends");

		return hrmsEmployeeDependentDao.getRelations();
	}

	/**
	 * 
	 * @return Employee list
	 */
	@RequestMapping(value = "getEmployeeList45", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeList() {

		logger.info("Method : getEmployeeList starts");
		logger.info("Method : getEmployeeList ends");

		return hrmsEmployeeDependentDao.getEmployeeList();
	}

	/*
	 * for Add Other Service price getAssignEduDetails
	 */
	@RequestMapping(value = "restAddEmployeeDepnd", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddEmployeeEdu(
			@RequestBody List<HrmsEmployeeDependentModel> hrmEmployeeDependentModel) {
		logger.info("Method in rest: restAddEmployeeDepnd starts");

		logger.info("Method in rest: restAddEmployeeDepnd ends");

		return hrmsEmployeeDependentDao.restAddEmployeeDepnd(hrmEmployeeDependentModel);
	}

	/*
	 * for All assignSkill
	 */
	@RequestMapping(value = "getAssignDepndDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeDependentModel>>> getAssignEduDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAssignDepndDetails starts");

		logger.info("Method : getAssignDepndDetails ends");

		return hrmsEmployeeDependentDao.getAssignDepndDetails(request);
	}

	/*
	 * for assign Dependent  Edit
	 */
	@RequestMapping(value = "getAssigndDepndById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeDependentModel>>> getAssignDependentById(
			@RequestParam("empId") String empId) {
		logger.info("Method : getAssignDependentById starts");

		logger.info("Method : getAssignDependentById ends");

		return hrmsEmployeeDependentDao.getAssigndependentById(empId);
	}

}


