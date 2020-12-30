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
import nirmalya.aatithya.restmodule.employee.dao.HrmsSupervisorMasterDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsSupervisorMasterModel;

@RestController
@RequestMapping("employee/")
public class HrmsSupervisorMasterRestController {

	Logger logger = LoggerFactory.getLogger(HrmsSupervisorMasterRestController.class);

	@Autowired
	HrmsSupervisorMasterDao hrmsSupervisorMasterDao;
	/*
	 * for All supervisor
	 */
	@RequestMapping(value="getsupervisorDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsSupervisorMasterModel>>> getsupervisorDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getsupervisorDetails starts");
		
		logger.info("Method : getsupervisorDetails ends");
		
		return hrmsSupervisorMasterDao.getsupervisorDetails(request);
	}
	/*
	 * for All  Add supervisor
	 */
	@RequestMapping(value="restAddsupervisors" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddsupervisor(@RequestBody HrmsSupervisorMasterModel supervisor) 
	{
		logger.info("Method : restAddsupervisor starts");
		
		logger.info("Method : restAddsupervisor ends");
		
		return hrmsSupervisorMasterDao.addsupervisor(supervisor);
	}
	/*
	 * for  supervisor Edit
	 */
	@RequestMapping(value="getsupervisorById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsSupervisorMasterModel>> getsupervisorById(@RequestParam String id) 
	{
		logger.info("Method : getsupervisorById starts");
		
		logger.info("Method : getsupervisorById ends");
		
		return hrmsSupervisorMasterDao.getsupervisorById(id);
	}
	/*
	 * for All supervisor Delete
	 */
	@RequestMapping(value="deletesupervisorById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deletesupervisorById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deletesupervisorById starts");
		
		logger.info("Method : deletesupervisorById ends");
		
		return hrmsSupervisorMasterDao.deletesupervisorById(id,createdBy);
	}
	/*
	 * get Employee list by auto search
	 */
	@RequestMapping(value = "getEmployeeByAutosearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEmployeeByAutosearch(@RequestParam String id) {
		logger.info("Method : getEmployeeByAutosearch starts");

		logger.info("Method : getEmployeeByAutosearch ends");
		return hrmsSupervisorMasterDao.getEmployeeByAutosearch(id);
	}
	/*
	 * for lang list
	 */
	@RequestMapping(value = "getDeptList", method = { RequestMethod.GET })
	public List<DropDownModel> getLangList() {

		logger.info("Method : getDeptList starts");
		logger.info("Method : getDeptList ends");

		return hrmsSupervisorMasterDao.getDeptList();
	}
	
}

