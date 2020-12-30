/**Defines property master Rest Controller*/
package nirmalya.aatithya.restmodule.property.controller;

import java.util.List;

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
import nirmalya.aatithya.restmodule.property.dao.PropertyDao;
import nirmalya.aatithya.restmodule.property.model.PropertyModel;


/**
 * @author Nirmalya Labs
 *
 */

@RestController
public class PropertyController {

	@Autowired
	PropertyDao propertyDAO;
	
	/**
	 * returns all properties
	 *
	 */
	@RequestMapping(value="/getAllProperty" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<PropertyModel>>> getAllProperty(@RequestBody DataTableRequest request) {
		return propertyDAO.getAllPropertiesList(request);
	}
	
	/**
	 * Post Mapping to Add new property
	 *
	 */
	@RequestMapping(value="/restAddNewProperty" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddProperty(@RequestBody PropertyModel prop) {
		
		return propertyDAO.addProperty(prop);
	}
	/**
	 * Post Mapping to model data
	 *
	 */
	@RequestMapping(value="/restGetPropertyForModel" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<PropertyModel>> restAddProperty(@RequestParam("index")Integer index) {
		

		return propertyDAO.modelForProperty(index);
	}
	/**
	 * Post Mapping to Edit 
	 *
	 */
	@RequestMapping(value="/restGetPropertyForEdit" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<PropertyModel>> restEditProperty(@RequestParam("index")Integer index) {
		
		
		return propertyDAO.modelForProperty(index);
	}
	@RequestMapping(value="/restGetPropertyPropertyCategory" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<DropDownModel>>> restGetPropertyPropertyCategory() {
		
		
		return propertyDAO.propertyCategory();
	}
}
