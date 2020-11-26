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
import nirmalya.aatithya.restmodule.employee.dao.HrmsEmployeeSkillAssignDao;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeSkillAssignModel;


@RestController
@RequestMapping("employee/")
public class HrmsEmployeeSkillAssignRestController {

	Logger logger = LoggerFactory.getLogger(HrmsEmployeeSkillAssignRestController.class);

	@Autowired
	HrmsEmployeeSkillAssignDao hrmassignSkillMDao;
	/*
	 * for All assignSkill 
	 */
	@RequestMapping(value="getAssignSkillDetails" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<HrmsEmployeeSkillAssignModel>>> getassignSkillDetails(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getassignSkillDetails starts");
		
		logger.info("Method : getassignSkillDetails ends");
		
		return hrmassignSkillMDao.getassignSkillDetails(request);
	}
	/*
	 * for All  Add assignSkill
	 */
	@RequestMapping(value="restAddassignSkills" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddassignSkill(@RequestBody HrmsEmployeeSkillAssignModel assignSkill) 
	{
		logger.info("Method : restAddassignSkill starts");
		
		logger.info("Method : restAddassignSkill ends");
		
		return hrmassignSkillMDao.addassignSkill(assignSkill);
	}
	/*
	 * for  assignSkill Edit
	 */
	@RequestMapping(value="getAssignSkillById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<HrmsEmployeeSkillAssignModel>> getassignSkillById(@RequestParam String empId ) 
	{
		logger.info("Method : getassignSkillById starts");
		
		logger.info("Method : getassignSkillById ends");
		
		return hrmassignSkillMDao.getassignSkillById(empId);
	}
	/*
	 * for assignSkill Delete
	 */
	@RequestMapping(value="deleteAssignSkillById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteassignSkillById(@RequestParam String id, @RequestParam String skillId, @RequestParam String createdBy) 
	{
		logger.info("Method : deleteassignSkillById starts");
		
		logger.info("Method : deleteassignSkillById ends");
		
		return hrmassignSkillMDao.deleteassignSkillById(id,skillId,createdBy);
	}
	/**
	 * 
	 * @return department list
	 */
	@RequestMapping(value = "getSkillList", method = { RequestMethod.GET })
	public List<DropDownModel> getDepartmentList() {
		
		logger.info("Method : getSkillList starts");
		logger.info("Method : getSkillList ends");
		
		return hrmassignSkillMDao.getSkillList();
	}
	/**
	 * 
	 * @return Employee list
	 */
	@RequestMapping(value = "getEmployeeList", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeList() {
		
		logger.info("Method : getEmployeeList starts");
		logger.info("Method : getEmployeeList ends");
		
		return hrmassignSkillMDao.getEmployeeList();
	}
}

