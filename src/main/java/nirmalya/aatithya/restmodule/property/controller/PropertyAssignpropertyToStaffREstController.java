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
import nirmalya.aatithya.restmodule.property.dao.PropertyAssignPropertyToSatffDao;
import nirmalya.aatithya.restmodule.property.model.PropertyAssignPropertyToStaffModel;



@RestController
@RequestMapping("property/")
public class PropertyAssignpropertyToStaffREstController {

	Logger logger = LoggerFactory.getLogger(PropertyAssignpropertyToStaffREstController.class);

	@Autowired
	PropertyAssignPropertyToSatffDao propertyAssignPropertyToSatffDao;
	
	
	/**
	 * returns cost center name drop down value
	 *
	 */
	@RequestMapping(value="assign-property-staff-restGetCostCenter" , method={RequestMethod.GET})
	public List<DropDownModel> restGetCostCenter() {
		logger.info("Method : restGetCostCenter starts");

		logger.info("Method : restGetCostCenter ends");
		return propertyAssignPropertyToSatffDao.getCostCenterList();
	}
	
	/*
	 * for drop down of User Role by cost center
	 */
	@RequestMapping(value = "/getUserRole", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUserRole(@RequestParam String costCenter) {
		logger.info("Method in rest: getUserRole starts");

		logger.info("Method in rest: getUserRole ends");
		return propertyAssignPropertyToSatffDao.getUserRole(costCenter);
	}
	
	/*
	 * for drop down of User List by user role
	 */
	@RequestMapping(value = "/getUserList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getUserList(@RequestParam String userRole) {
		logger.info("Method in rest: getUserList starts");

		logger.info("Method in rest: getUserList ends");
		return propertyAssignPropertyToSatffDao.getUserList(userRole);
	}
	

	/*
	 * for drop down of property list by cost center
	 */
	@RequestMapping(value = "/getPropertyList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyList(@RequestParam String costCenter) {
		logger.info("Method in rest: getPropertyList starts");

		logger.info("Method in rest: getPropertyList ends");
		return propertyAssignPropertyToSatffDao.getPropertyList(costCenter);
	}
	

	@RequestMapping(value = "restAssignPropertyToStaff", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAssignPropertyToStaff(@RequestBody PropertyAssignPropertyToStaffModel propertyAssignPropertyToStaffModel) {
		logger.info("Method : restAddPropertyType starts");

		logger.info("Method : restAddPropertyType ends");
		return propertyAssignPropertyToSatffDao.restAssignPropertyToStaff(propertyAssignPropertyToStaffModel);
	}
	
	/*
	 * for All  Assigned property to staff
	 */
	@RequestMapping(value = "getAllAssignedProperty", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssignPropertyToStaffModel>>> getAllAssignedProperty(
			@RequestBody DataTableRequest request) {
		logger.info("Method in rest: getAllAssignedProperty starts");

		logger.info("Method in rest: getAllAssignedProperty ends");

		return propertyAssignPropertyToSatffDao.getAllAssignedProperty(request);
	}
	/*
	 * for assign property to staff by id
	 */
	@RequestMapping(value = "/getAssignedPropertyById", method = { RequestMethod.GET })
	public List<PropertyAssignPropertyToStaffModel> getAssignedPropertyById(@RequestParam String id, @RequestParam String ur,@RequestParam String ui) {
		logger.info("Method : getAssignedPropertyById for rest controller starts");
		
		logger.info("Method : getAssignedPropertyById for rest controller ends");
		return propertyAssignPropertyToSatffDao.getAssignedPropertyById(id,ur,ui);
	}
	/*
	 * for modal view
	 */
	@RequestMapping(value = "/getAssignedPropertyModal", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyAssignPropertyToStaffModel>> getAssignedPropertyModal(@RequestParam String id, @RequestParam String ur,@RequestParam String ui,@RequestParam String pi) {
		logger.info("Method : getAssignedPropertyModal for rest controller starts");
		
		logger.info("Method : getAssignedPropertyModal for rest controller ends");
		return propertyAssignPropertyToSatffDao.getAssignedPropertyByIdModal(id,ur,ui,pi);
	}
/*
 * for change status 
 */
	@RequestMapping(value="/changePropertyStatusById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> changePropertyStatusById(@RequestParam String id, @RequestParam String ur, @RequestParam String userid,
			@RequestParam String propertyId,@RequestParam Boolean status ,@RequestParam String createdBy) 
	{
		logger.info("Method : changePropertyStatusById starts");
		
		logger.info("Method : changePropertyStatusById ends");
		return propertyAssignPropertyToSatffDao.changePropertyStatusById(id,ur,userid,propertyId,status,createdBy);
	}
	/**
 	* REST CONTROLLER - Get Hotel Logo
 	*
 	*/
	@RequestMapping(value="restLogoImage-AssignedProperty" , method={RequestMethod.GET})
	public List<DropDownModel> restGetLogoImageForAssignedProperty(@RequestParam("logoType") String logoType) {
		logger.info("Method : restGetLogoImageForAssignedProperty starts");

		logger.info("Method : restGetLogoImageForAssignedProperty ends");
	return propertyAssignPropertyToSatffDao.getHotelLogoAssignedProperty(logoType);
	}
	
}
