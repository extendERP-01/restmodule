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
import nirmalya.aatithya.restmodule.property.dao.PropertyTypeDao;
import nirmalya.aatithya.restmodule.property.model.PropertyTypeForm;

@RestController
@RequestMapping("property/")
public class PropertyTypeRestController {

	Logger logger = LoggerFactory.getLogger(PropertyTypeRestController.class);

	@Autowired
	PropertyTypeDao propertyTypeDao;

	@RequestMapping(value = "getAmenityName01", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAmenityName(@RequestParam String proCat) {
		logger.info("Method : getAmenityName starts");

		logger.info("Method : getAmenityName ends");
		return propertyTypeDao.getAmenityTypeName(proCat);
	}

	@RequestMapping(value = "getAmenityNameEdit", method = { RequestMethod.GET })
	public List<DropDownModel> getAmenityNameEdit(@RequestParam String proCat) {
		logger.info("Method : getAmenityName starts");

		logger.info("Method : getAmenityName ends");
		return propertyTypeDao.getAmenityTypeNameEdit(proCat);
	}

	@RequestMapping(value = "restAddPropertyType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddUser(@RequestBody PropertyTypeForm propertyTypeForm) {
		logger.info("Method : restAddPropertyType starts");

		logger.info("Method : restAddPropertyType ends");
		return propertyTypeDao.addPropertyType(propertyTypeForm);
	}

	@RequestMapping(value = "getAllPropertyType", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyTypeForm>>> getAllPropertyType(
			@RequestBody DataTableRequest request) {
		logger.info("Method : getAllPropertyType starts");

		logger.info("Method : getAllPropertyType ends");
		return propertyTypeDao.getAllPropertyTypeList(request);
	}

	@RequestMapping(value = "getPropertyTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<PropertyTypeForm>>> getPropertyTypeById(@RequestParam String id) {
		logger.info("Method : getPropertyTypeById starts");

		logger.info("Method : getPropertyTypeById ends");
		return propertyTypeDao.getPropertyTypeById(id);
	}

	@RequestMapping(value = "/getPropertyTypeByIdEdit", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyTypeForm>> getPropertyTypeByIdEdit(@RequestParam String id) {
		logger.info("Method : getPropertyTypeByIdEdit starts");

		logger.info("Method : getPropertyTypeByIdEdit ends");
		return propertyTypeDao.getPropertyTypeByIdEdit(id);
	}
	
	
	
	@RequestMapping(value = "/deletePropertyById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePropertyById(@RequestParam String id,@RequestParam String createdBy) {

		return propertyTypeDao.deletePropertyById(id,createdBy);
	}

}
