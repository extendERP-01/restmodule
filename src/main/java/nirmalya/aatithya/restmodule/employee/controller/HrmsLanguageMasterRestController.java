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
import nirmalya.aatithya.restmodule.employee.dao.HrmsLanguageMasterDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsLanguageMasterModel;
/**
 * 
 * @author Nirmalya
 *
 */
@RestController
@RequestMapping("employee/")
public class HrmsLanguageMasterRestController {
	Logger logger = LoggerFactory.getLogger(HrmsLanguageMasterRestController.class);

	@Autowired
	HrmsLanguageMasterDao hrmlanguageMasterDao;
	/*
	 * for All language
	 */
	@RequestMapping(value="getlanguageDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsLanguageMasterModel>>> getlanguageDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getlanguageDetails starts");
		
		logger.info("Method : getlanguageDetails ends");
		
		return hrmlanguageMasterDao.getlanguageDetails(request);
	}
	/*
	 * for All  Add language
	 */
	@RequestMapping(value="restAddlanguages" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddlanguage(@RequestBody HrmsLanguageMasterModel language) 
	{
		logger.info("Method : restAddlanguage starts");
		
		logger.info("Method : restAddlanguage ends");
		
		return hrmlanguageMasterDao.addlanguage(language);
	}
	/*
	 * for  language Edit
	 */
	@RequestMapping(value="getlanguageById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsLanguageMasterModel>> getlanguageById(@RequestParam String id) 
	{
		logger.info("Method : getlanguageById starts");
		
		logger.info("Method : getlanguageById ends");
		
		return hrmlanguageMasterDao.getlanguageById(id);
	}
	/*
	 * for All language Delete
	 */
	@RequestMapping(value="deletelanguageById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deletelanguageById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deletelanguageById starts");
		
		logger.info("Method : deletelanguageById ends");
		
		return hrmlanguageMasterDao.deletelanguageById(id,createdBy);
	}
}


