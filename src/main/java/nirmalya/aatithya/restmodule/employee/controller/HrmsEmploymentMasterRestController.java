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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmploymentMasterDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmploymentMasterModel;
 
@RestController
@RequestMapping("employee/")
public class HrmsEmploymentMasterRestController {
	Logger logger = LoggerFactory.getLogger(HrmsEmploymentMasterRestController.class);

	@Autowired
	HrmsEmploymentMasterDao hrmEmploymentMasterDao;
	/*
	 * for All employment
	 */
	@RequestMapping(value="getemploymentDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsEmploymentMasterModel>>> getemploymentDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getemploymentDetails starts");
		
		logger.info("Method : getemploymentDetails ends");
		
		return hrmEmploymentMasterDao.getemploymentDetails(request);
	}
	/*
	 * for All  Add employment
	 */
	@RequestMapping(value="restAddemployments" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddemployment(@RequestBody HrmsEmploymentMasterModel employment) 
	{
		logger.info("Method : restAddemployment starts");
		
		logger.info("Method : restAddemployment ends");
		
		return hrmEmploymentMasterDao.addemployment(employment);
	}
	/*
	 * for  employment Edit
	 */
	@RequestMapping(value="getEmploymentById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsEmploymentMasterModel>> getEmploymentById(@RequestParam String id) 
	{
		logger.info("Method : getEmploymentById starts");
		
		logger.info("Method : getEmploymentById ends");
		
		return hrmEmploymentMasterDao.getEmploymentById(id);
	}
	/*
	 * for All employment Delete
	 */
	@RequestMapping(value="deleteEmploymentById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteEmploymentById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deleteEmploymentById starts");
		
		logger.info("Method : deleteEmploymentById ends");
		
		return hrmEmploymentMasterDao.deleteEmploymentById(id,createdBy);
	}
}
