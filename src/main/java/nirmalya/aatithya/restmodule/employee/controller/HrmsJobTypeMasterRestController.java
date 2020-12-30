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
import nirmalya.aatithya.restmodule.employee.dao.HrmsJobTypeMasterDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsJobTypeMasterModel;
 
@RestController
@RequestMapping("employee/")
public class HrmsJobTypeMasterRestController {

	Logger logger = LoggerFactory.getLogger(HrmsJobTypeMasterRestController.class);

	@Autowired
	HrmsJobTypeMasterDao hrmJobTypeMasterDao;
	/*
	 * for All jobType
	 */
	@RequestMapping(value="getjobTypeDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsJobTypeMasterModel>>> getjobTypeDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getjobTypeDetails starts");
		
		logger.info("Method : getjobTypeDetails ends");
		
		return hrmJobTypeMasterDao.getjobTypeDetails(request);
	}
	/*
	 * for All  Add jobType
	 */
	@RequestMapping(value="restAddjobTypes" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddjobType(@RequestBody HrmsJobTypeMasterModel jobType) 
	{
		logger.info("Method : restAddjobType starts");
		
		logger.info("Method : restAddjobType ends");
		
		return hrmJobTypeMasterDao.addjobType(jobType);
	}
	/*
	 * for  jobType Edit
	 */
	@RequestMapping(value="getjobTypeById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsJobTypeMasterModel>> getjobTypeById(@RequestParam String id) 
	{
		logger.info("Method : getjobTypeById starts");
		
		logger.info("Method : getjobTypeById ends");
		
		return hrmJobTypeMasterDao.getjobTypeById(id);
	}
	/*
	 * for All jobType Delete
	 */
	@RequestMapping(value="deletejobTypeById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deletejobTypeById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deletejobTypeById starts");
		
		logger.info("Method : deletejobTypeById ends");
		
		return hrmJobTypeMasterDao.deletejobTypeById(id,createdBy);
	}
}

