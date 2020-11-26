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
import nirmalya.aatithya.restmodule.employee.dao.ExitManagementDao;
import nirmalya.aatithya.restmodule.employee.model.ExitManagementModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsSupervisorMasterModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmGoalMasterModel;
import nirmalya.aatithya.restmodule.employee.model.RestOfferLetterDetailModel;

@RestController
@RequestMapping("employee/")
public class ExitManagementRestController {
	Logger logger = LoggerFactory.getLogger(ExitManagementRestController.class);

	@Autowired
	ExitManagementDao exitManagementDao;

	@RequestMapping(value = "restAddExitManagement", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddExitManagement(@RequestBody ExitManagementModel exitManagement) {
		logger.info("Method : restAddExitManagement starts");

		logger.info("Method : restAddExitManagement ends");

		return exitManagementDao.restAddExitManagement(exitManagement);
	}

	@RequestMapping(value = "rest-get-empdegination", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpNameDegination(@RequestParam String id) {
		logger.info("Method : getEmpNameDegination starts");
		logger.info("Method : getEmpNameDegination ends");
		return exitManagementDao.getEmpNameDegination(id);
	}
	@RequestMapping(value = "viewExitManagementDtls", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<ExitManagementModel>>> viewExitManagementDtls(
			@RequestBody DataTableRequest request) {
		logger.info("Method : viewExitManagementDtls starts");

		logger.info("Method : viewExitManagementDtls ends");

		return exitManagementDao.viewExitManagementDtls(request);
	}
	
	@RequestMapping(value = "getExitById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ExitManagementModel>> getExitById(@RequestParam String id) {
		logger.info("Method : getExitById starts");

		logger.info("Method : getExitById ends");

		return exitManagementDao.getExitById(id);
	}
	@RequestMapping(value = "getEmpDesignationEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getEmpDesignationEdit(@RequestParam String id) {

		logger.info("Method : getEmpDesignationEdit starts");
		logger.info("Method : getEmpDesignationEdit ends");

		return exitManagementDao.getEmpDesignationEdit(id);
	}
	
	@RequestMapping(value = "deleteExitManagementById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteExitManagementById(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteExitManagementById starts");

		logger.info("Method : deleteExitManagementById ends");

		return exitManagementDao.deleteExitManagementById(id, createdBy);
	}
}
