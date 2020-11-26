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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.HrmsDepartmentMasterDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsDepartmentMasterModel;

@RestController
@RequestMapping("employee/")
public class HrmsDepartmentMasterRestController {

	Logger logger = LoggerFactory.getLogger(HrmsDepartmentMasterRestController.class);

	@Autowired
	HrmsDepartmentMasterDao hrmDepartmentMasterDao;
	/*
	 * for All department
	 */
	@RequestMapping(value="getdepartmentDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsDepartmentMasterModel>>> getdepartmentDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getdepartmentDetails starts");
		
		logger.info("Method : getdepartmentDetails ends");
		
		return hrmDepartmentMasterDao.getdepartmentDetails(request);
	}
	/*
	 * for All  Add department
	 */
	@RequestMapping(value="restAdddepartments" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAdddepartment(@RequestBody HrmsDepartmentMasterModel department) 
	{
		logger.info("Method : restAdddepartment starts");
		
		logger.info("Method : restAdddepartment ends");
		
		return hrmDepartmentMasterDao.adddepartment(department);
	}
	/*
	 * for  department Edit
	 */
	@RequestMapping(value="getdepartmentById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsDepartmentMasterModel>> getdepartmentById(@RequestParam String id) 
	{
		logger.info("Method : getdepartmentById starts");
		
		logger.info("Method : getdepartmentById ends");
		
		return hrmDepartmentMasterDao.getdepartmentById(id);
	}
	/*
	 * for All department Delete
	 */
	@RequestMapping(value="deletedepartmentById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deletedepartmentById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deletedepartmentById starts");
		
		logger.info("Method : deletedepartmentById ends");
		
		return hrmDepartmentMasterDao.deletedepartmentById(id,createdBy);
	}
}

