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
import nirmalya.aatithya.restmodule.employee.dao.HrmsQualificationMasterDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsQualificationMasterModel;
@RestController
@RequestMapping("employee/")
public class HrmsQualificationMasterRestController {
	Logger logger = LoggerFactory.getLogger(HrmsQualificationMasterRestController.class);

	@Autowired
	HrmsQualificationMasterDao hrmqualificationMasterDao;
	/*
	 * for All qualification
	 */
	@RequestMapping(value="getqualificationDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsQualificationMasterModel>>> getqualificationDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getqualificationDetails starts");
		
		logger.info("Method : getqualificationDetails ends");
		
		return hrmqualificationMasterDao.getqualificationDetails(request);
	}
	/*
	 * for All  Add qualification
	 */
	@RequestMapping(value="restAddqualifications" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddqualification(@RequestBody HrmsQualificationMasterModel qualification) 
	{
		logger.info("Method : restAddqualification starts");
		
		logger.info("Method : restAddqualification ends");
		
		return hrmqualificationMasterDao.addqualification(qualification);
	}
	/*
	 * for  qualification Edit
	 */
	@RequestMapping(value="getqualificationById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsQualificationMasterModel>> getqualificationById(@RequestParam String id) 
	{
		logger.info("Method : getqualificationById starts");
		
		logger.info("Method : getqualificationById ends");
		
		return hrmqualificationMasterDao.getqualificationById(id);
	}
	/*
	 * for All qualification Delete
	 */
	@RequestMapping(value="deletequalificationById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deletequalificationById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deletequalificationById starts");
		
		logger.info("Method : deletequalificationById ends");
		
		return hrmqualificationMasterDao.deletequalificationById(id,createdBy);
	}
}

