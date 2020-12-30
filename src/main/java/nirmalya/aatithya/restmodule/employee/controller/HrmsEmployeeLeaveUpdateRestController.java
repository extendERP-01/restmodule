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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeLeaveRestDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeLeaveUpdateRestModel;

@RestController
@RequestMapping("employee/")
public class HrmsEmployeeLeaveUpdateRestController {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeLeaveUpdateRestController.class);

	@Autowired
	HrmsEmployeeLeaveRestDao hrmsEmployeeLeaveRestDao; 
	
	
	/*
	 * Get mapping for get Employee Id
	 */
	@RequestMapping(value = "/getEmpIdAutoSearchList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmpIdAutoSearchList(@RequestParam String id) {
		logger.info("Method : getEmpIdAutoSearchList starts");

		logger.info("Method : getEmpIdAutoSearchList ends");
		return hrmsEmployeeLeaveRestDao.getEmpIdAutoSearchList(id);

	}
	
	@RequestMapping(value = "getEmployeeDtls", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<HrmsEmployeeLeaveUpdateRestModel>> getAllList(@RequestParam String id) {
		logger.info("Method : getAllList starts");
		logger.info("Method : getAllList endss");
		return hrmsEmployeeLeaveRestDao.getEmployeeDtls(id);
	}
	
	/*
	 * for Add Other Service price getAssignEduDetails
	 */
	@RequestMapping(value = "restUpdateEmployeeLeave", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restUpdateEmployeeLeave(
			@RequestBody List<HrmsEmployeeLeaveUpdateRestModel> hrmsEmployeeLeaveRestModel) {
		logger.info("Method in rest: restUpdateEmployeeLeave starts");

		logger.info("Method in rest: restUpdateEmployeeLeave ends");

		return hrmsEmployeeLeaveRestDao.restUpdateEmployeeLeave(hrmsEmployeeLeaveRestModel);
	}
	
	/*
	 * for View All Leave
	 */
	@RequestMapping(value = "getAssignleaveDetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<HrmsEmployeeLeaveUpdateRestModel>>> getAssignLeaveDetails(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAssignLeaveDetails starts");

		logger.info("Method : getAssignLeaveDetails ends");

		return hrmsEmployeeLeaveRestDao.getAssignLeaveDetails(request);
	}
	
	
	/*
	 * for delete leave
	 */
	@RequestMapping(value="deleteLeaveById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteLeaveById(@RequestParam String id, @RequestParam String lid,@RequestParam String createdBy) 
	{
		logger.info("Method : deleteLeaveById starts");
		
		logger.info("Method : deleteLeaveById ends");
		
		return hrmsEmployeeLeaveRestDao.deleteLeaveById(id,lid,createdBy);
	}
	
	@RequestMapping(value = "rest-update-date", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> updateLeaveDate(@RequestBody HrmsEmployeeLeaveUpdateRestModel hrmsEmployeeLeaveRestModel) {
		logger.info("Method : updateLeaveDate starts");
		
		logger.info("Method : updateLeaveDate ends");
		return hrmsEmployeeLeaveRestDao.updateLeaveDate(hrmsEmployeeLeaveRestModel);
	}


}
