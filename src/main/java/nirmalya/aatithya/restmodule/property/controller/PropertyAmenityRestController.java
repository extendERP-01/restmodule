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
import nirmalya.aatithya.restmodule.property.dao.PropertyAmenityDao;
import nirmalya.aatithya.restmodule.property.model.AmenityForm;


@RestController
@RequestMapping(value="property/")
public class PropertyAmenityRestController {

	@Autowired
	PropertyAmenityDao amenityDao;
	Logger logger = LoggerFactory.getLogger(PropertyAmenityRestController.class);
	
	/*
	 * for get property name
	 */
	@RequestMapping(value = "getPropertyName", method = { RequestMethod.GET })
	public List<DropDownModel> getModulename() {
		
		logger.info("Method : getPropertyName starts");
		logger.info("Method : getPropertyName ends");
		
		return amenityDao.getPropertyName();
	}
 /*
  * 
  *  for rest add amenity
  */
	@RequestMapping(value = "restAddAmenity", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddUser(@RequestBody AmenityForm addAmenity) {
		
		logger.info("Method : restAddAmenity starts");
		logger.info("Method : restAddAmenity ends");
		
		return amenityDao.addAmenity(addAmenity);
	}
/*
 * for get all amenity
 */
	@RequestMapping(value = "/getAllAmenity", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<AmenityForm>>> getAllUsers(@RequestBody DataTableRequest request) {

		logger.info("Method : getAllAmenity starts");
		logger.info("Method : getAllAmenity ends");
		
		return amenityDao.getAllAmenityList(request);
	}
/*
 * get amenity by id
 */
	@RequestMapping(value = "/getAmenityById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<AmenityForm>> getActivityById(@RequestParam String id) {

		logger.info("Method : getAmenityById starts");
		logger.info("Method : getAmenityById ends");
		
		return amenityDao.getAmenitytById(id);
	}
/*
 * delete amenity by id
 */
	@RequestMapping(value = "/deleteAmenityById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteActivityManagementById(@RequestParam String id,@RequestParam String createdBy) {

		logger.info("Method : deleteAmenityById starts");
		logger.info("Method : deleteAmenityById ends");
		
		return amenityDao.deleteAmenityById(id,createdBy);
	}

}