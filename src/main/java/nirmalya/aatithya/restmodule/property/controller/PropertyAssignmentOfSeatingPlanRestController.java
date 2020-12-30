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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.dao.PropertyAssignmentOfSeatingPlanDao;
import nirmalya.aatithya.restmodule.property.model.PropertyAssignmentOfSeatingPlanModel;


@RestController
@RequestMapping("property/")

public class PropertyAssignmentOfSeatingPlanRestController {
	
	Logger logger = LoggerFactory.getLogger(PropertyThemeRestController.class);
	@Autowired
	PropertyAssignmentOfSeatingPlanDao propertyAssignmentOfSeatingPlanDao;
	
/**
 * for get property id
 */
	@RequestMapping(value = "getPropertyId", method = { RequestMethod.GET })
	public List<DropDownModel> getPropertyId() {

		logger.info("Method in rest: getPropertyId starts");
		
		logger.info("Method in rest: getPropertyId starts");
		return propertyAssignmentOfSeatingPlanDao.getPropertyId();
	}
	

	/*
	 * for drop down of Seating plan Name for onChange 
	 */
	@RequestMapping(value = "/getSeatingPlanName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyTypeName(@RequestParam String proCat) {
		logger.info("Method in rest: getSeatingPlanName starts");

		logger.info("Method in rest: getSeatingPlanName ends");
		return propertyAssignmentOfSeatingPlanDao.getAssignmentOfSeatingPlan(proCat);
	}
	/*
	 * for  Add Assignment of seating plan 
	 */
	@RequestMapping(value = "restAddAssignmentOfSeatingPlanModel", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddAssignmentOfSeatingPlanModel(@RequestBody List<PropertyAssignmentOfSeatingPlanModel> propertyAssignmentOfSeatingPlan) {
		logger.info("Method in rest: restAddAssignmentOfSeatingPlanModel starts");

		logger.info("Method in rest: restAddAssignmentOfSeatingPlanModel ends");

		return propertyAssignmentOfSeatingPlanDao.addAssignmentOfSeatingPlan(propertyAssignmentOfSeatingPlan);
	}

	/*
	 * for view All Assignment of seating plan
	 */
	@RequestMapping(value = "getAllAssignmentSeatingPlan", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>> getAllAssignmentSeatingPlan(@RequestBody DataTableRequest request) {
		logger.info("Method in rest: getAllAssignmentSeatingPlan starts");

		logger.info("Method in rest: getAllAssignmentSeatingPlan ends");

		return propertyAssignmentOfSeatingPlanDao.getAllAssignmentOfSeating(request);
	}
	
	/*
	 * for view All Assignment of seating plan in pdf
	 */
	@RequestMapping(value = "getAllAssignmentSeatingPlanPdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>> getAllAssignmentSeatingPlanPdf(@RequestBody DataTableRequest request) {
		logger.info("Method in rest: getAllAssignmentSeatingPlan starts");

		logger.info("Method in rest: getAllAssignmentSeatingPlan ends");

		return propertyAssignmentOfSeatingPlanDao.getAllAssignmentSeatingPlanPdf(request);
	}
	/*
	 * for drop down of Seating plan 
	 */
	@RequestMapping(value = "getUserType", method = { RequestMethod.GET })
	public List<DropDownModel> getUserType() {
		
		logger.info("Method in rest: getUserType starts");

		logger.info("Method in rest: getUserType ends");

		return propertyAssignmentOfSeatingPlanDao.getUserType();
	}

	/*
	 * for drop down of Seating plan 
	 */
	@RequestMapping(value = "getPropertyIdEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getSeatingPlanEdit(@RequestParam String proCat) {
		
		logger.info("Method in rest: getPropertyIdEdit starts");

		logger.info("Method in rest: getPropertyIdEdit ends");

		return propertyAssignmentOfSeatingPlanDao.getPropertyIdEdit(proCat);
	}
	

	/*
	 * for drop down of Seating plan 
	 */
	@RequestMapping(value = "getSeatingPlan", method = { RequestMethod.GET })
	public List<DropDownModel> getSeatingPlanName() {
		
		logger.info("Method in rest: getSeatingPlan starts");

		logger.info("Method in rest: getSeatingPlan starts");

		return propertyAssignmentOfSeatingPlanDao.getSeatingPlanName();
	}

	/*
	 * get assignment of sitting plan by id
	 */
	@RequestMapping(value = "/getAssignmentById", method = { RequestMethod.GET })
	public List<PropertyAssignmentOfSeatingPlanModel> getAssignmentById(@RequestParam String id, @RequestParam String sp,@RequestParam String ut) {
		logger.info("Method : getAssignmentById for rest controller starts");
		
		logger.info("Method : getAssignmentById for rest controller ends");
		return propertyAssignmentOfSeatingPlanDao.getAssignmentById(id,sp,ut);
	}
	/*
	 * get assignment of sitting plan by id modal
	 */
	@RequestMapping(value = "/getAssignmentByIdModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<PropertyAssignmentOfSeatingPlanModel>>> getAssignmentByIdModal(@RequestParam String id, @RequestParam String sp,@RequestParam String ut) {
		logger.info("Method : getAssignmentByIdModal for rest controller starts");
		
		logger.info("Method : getAssignmentByIdModal for rest controller ends");
		return propertyAssignmentOfSeatingPlanDao.getAssignmentByIdModal(id,sp,ut);
	}

}
