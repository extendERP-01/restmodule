
/*
 * Rest Controller for sitting plan
 */
package nirmalya.aatithya.restmodule.property.controller;

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
import nirmalya.aatithya.restmodule.property.dao.PropertySeatingPlanDao;
import nirmalya.aatithya.restmodule.property.model.PropertySeattingPlanModel;

/*
 * @author Nirmalya Labs
 */
@RestController
@RequestMapping("property/")
public class PropertySeatingPlanRestController {
	
	Logger logger = LoggerFactory.getLogger(PropertySeatingPlanRestController.class);
	
	@Autowired
	PropertySeatingPlanDao sittingDao;
	/*
	 * for All  Add Sitting
	 */
	@RequestMapping(value="restAddSitting" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddSetting(@RequestBody PropertySeattingPlanModel seattingPlan) 
	{
		logger.info("Method : restAddSetting starts");
		
		logger.info("Method : restAddSetting ends");
		
		return sittingDao.addSitting(seattingPlan);
	}
	/*
	 * for All Sitting
	 */
	@RequestMapping(value="getAllSitting" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<PropertySeattingPlanModel>>> getAllSettings(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllSitting starts");
		
		logger.info("Method : getAllSitting ends");
		
		return sittingDao.getSittingDetails(request);
	}
	/*
	 * for edit Setting
	 */
	@RequestMapping(value="getSittingById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<PropertySeattingPlanModel>> getSittingById(@RequestParam String id) 
	{
		logger.info("Method : getSittingById starts");
		
		logger.info("Method : getSittingById ends");
		
		return sittingDao.getSittingById(id);
	}
	/*
	 * for Setting Delete
	 */
	@RequestMapping(value="deleteSittingById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteSittingById(@RequestParam String id,@RequestParam String createdBy) 
	{
		logger.info("Method : deleteSittingById starts");
		
		logger.info("Method : deleteSittingById ends");
		
		return sittingDao.deleteSittingById(id,createdBy);
	}
}
