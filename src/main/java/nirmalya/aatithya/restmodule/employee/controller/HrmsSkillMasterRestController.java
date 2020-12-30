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
import nirmalya.aatithya.restmodule.employee.dao.HrmsSkillMasterDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsSkillMasterModel;

@RestController
@RequestMapping("employee/")
public class HrmsSkillMasterRestController {

	Logger logger = LoggerFactory.getLogger(HrmsSkillMasterRestController.class);

	@Autowired
	HrmsSkillMasterDao hrmskillMasterDao;
	/*
	 * for All skill
	 */
	@RequestMapping(value="getskillDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsSkillMasterModel>>> getskillDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getskillDetails starts");
		
		logger.info("Method : getskillDetails ends");
		
		return hrmskillMasterDao.getskillDetails(request);
	}
	/*
	 * for All  Add skill
	 */
	@RequestMapping(value="restAddskills" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddskill(@RequestBody HrmsSkillMasterModel skill) 
	{
		logger.info("Method : restAddskill starts");
		
		logger.info("Method : restAddskill ends");
		
		return hrmskillMasterDao.addskill(skill);
	}
	/*
	 * for  skill Edit
	 */
	@RequestMapping(value="getskillById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsSkillMasterModel>> getskillById(@RequestParam String id) 
	{
		logger.info("Method : getskillById starts");
		
		logger.info("Method : getskillById ends");
		
		return hrmskillMasterDao.getskillById(id);
	}
	/*
	 * for skill Delete
	 */
	@RequestMapping(value="deleteskillById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteskillById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deleteskillById starts");
		
		logger.info("Method : deleteskillById ends");
		
		return hrmskillMasterDao.deleteskillById(id,createdBy);
	}
}

