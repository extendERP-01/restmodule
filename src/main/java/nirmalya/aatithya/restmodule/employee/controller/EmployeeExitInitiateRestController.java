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
import nirmalya.aatithya.restmodule.employee.dao.ExitInitateDao;
import nirmalya.aatithya.restmodule.employee.model.ExitInitiateModel;

@RestController
@RequestMapping("employee/")
public class EmployeeExitInitiateRestController {
	Logger logger = LoggerFactory.getLogger(ExitManagementRestController.class);

	@Autowired
	ExitInitateDao exitInitateDao;
	
	@RequestMapping(value = "/getEmpAutoComplete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ExitInitiateModel>>> getEmpAutoComplete(@RequestParam String id) {
		logger.info("Method : getEmpAutoComplete starts");

		logger.info("Method : getEmpAutoComplete ends");
		return exitInitateDao.getEmpAutoComplete(id);
	}
	
	@RequestMapping(value = "/getEmpDepartmentList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {
		logger.info("Method : getDepartmentList starts");

		logger.info("Method : getDepartmentList end");
		return exitInitateDao.getDepartmentList();
		
	}
	
	@RequestMapping(value = "rest-add-exit-initiate", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddExitInitiate(
			@RequestBody List<ExitInitiateModel> exitInitiateModel) {
		logger.info("Method in rest: restAddDlbd starts");

		logger.info("Method in rest: restAddDlbd ends");

		return exitInitateDao.restAddExitInitiate(exitInitiateModel);
	}
	@RequestMapping(value = "/getAllExitIntiate", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ExitInitiateModel>>> getAllExitIntiate(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllExitIntiate starts");
		
		logger.info("Method : getAllExitIntiate end");
		
		return exitInitateDao.getAllExitIntiate(request);
	}
	@RequestMapping(value = "editExitIntiateById", method = { RequestMethod.GET })
	public List<ExitInitiateModel> editExitIntiateById(@RequestParam String id) {
		logger.info("Method : editExitIntiateById starts");

		logger.info("Method : editExitIntiateById ends");
		return exitInitateDao.editExitIntiateById(id);
	}
}
