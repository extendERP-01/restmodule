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
import nirmalya.aatithya.restmodule.employee.dao.HrmsCertificationMasterDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsCertificationMasterModel;




/**
 * 
 * @author Nirmalya
 *
 */
@RestController
@RequestMapping("employee/")
public class HrmsCertificationMasterRestController {

	Logger logger = LoggerFactory.getLogger(HrmsCertificationMasterRestController.class);

	@Autowired
	HrmsCertificationMasterDao hrmcertificationMasterDao;
	/*
	 * for All certification
	 */
	@RequestMapping(value="getcertificationDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsCertificationMasterModel>>> getcertificationDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getcertificationDetails starts");
		
		logger.info("Method : getcertificationDetails ends");
		
		return hrmcertificationMasterDao.getcertificationDetails(request);
	}
	/*
	 * for All  Add certification
	 */
	@RequestMapping(value="restAddcertifications" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddcertification(@RequestBody HrmsCertificationMasterModel certification) 
	{
		logger.info("Method : restAddcertification starts");
		
		logger.info("Method : restAddcertification ends");
		
		return hrmcertificationMasterDao.addcertification(certification);
	}
	/*
	 * for  certification Edit
	 */
	@RequestMapping(value="getcertificationById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsCertificationMasterModel>> getcertificationById(@RequestParam String id) 
	{
		logger.info("Method : getcertificationById starts");
		
		logger.info("Method : getcertificationById ends");
		
		return hrmcertificationMasterDao.getcertificationById(id);
	}
	/*
	 * for All certification Delete
	 */
	@RequestMapping(value="deletecertificationById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deletecertificationById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deletecertificationById starts");
		
		logger.info("Method : deletecertificationById ends");
		
		return hrmcertificationMasterDao.deletecertificationById(id,createdBy);
	}
}

