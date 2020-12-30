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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmergencyContactDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmergencyContactModel;
/**
 * 
 * @author Nirmalya
 *
 */
@RestController
@RequestMapping("employee/")
public class HrmsEmergencyContactRestController {

	Logger logger = LoggerFactory.getLogger(HrmsEmergencyContactRestController.class);

	@Autowired
	HrmsEmergencyContactDao hrmemergencyMasterDao;
	/*
	 * for All emergency
	 */
	@RequestMapping(value="getemergencyDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsEmergencyContactModel>>> getemergencyDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getemergencyDetails starts");
		
		logger.info("Method : getemergencyDetails ends");
		
		return hrmemergencyMasterDao.getemergencyDetails(request);
	}
	/*
	 * for All  Add emergency
	 */
	@RequestMapping(value="restAddemergencys" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddemergency(@RequestBody HrmsEmergencyContactModel emergency) 
	{
		logger.info("Method : restAddemergency starts");
		
		logger.info("Method : restAddemergency ends");
		
		return hrmemergencyMasterDao.addemergency(emergency);
	}
	/*
	 * for  emergency Edit
	 */
	@RequestMapping(value="getemergencyById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsEmergencyContactModel>> getemergencyById(@RequestParam String empId) 
	{
		logger.info("Method : getemergencyById starts");
		
		logger.info("Method : getemergencyById ends");
		
		return hrmemergencyMasterDao.getemergencyById(empId);
	}
	/*
	 * for All emergency Delete
	 */
	@RequestMapping(value="deleteemergencyById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteemergencyById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deleteemergencyById starts");
		
		logger.info("Method : deleteemergencyById ends");
		
		return hrmemergencyMasterDao.deleteemergencyById(id,createdBy);
	}
}

