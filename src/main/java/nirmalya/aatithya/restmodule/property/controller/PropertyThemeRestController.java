
/*
 * Rest Controller for theme property
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
import nirmalya.aatithya.restmodule.property.dao.PropertyThemeDao;
import nirmalya.aatithya.restmodule.property.model.PropertyThemeModel;

/*
 * @author Nirmalya Labs
 */
 
@RestController
@RequestMapping("property/")
public class PropertyThemeRestController 
{
	Logger logger = LoggerFactory.getLogger(PropertyThemeRestController.class);

	@Autowired
	PropertyThemeDao propertyThemeDao;
	/*
	 * for All Theme
	 */
	@RequestMapping(value="getAllThemes" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<List<PropertyThemeModel>>> getAllThemes(@RequestBody DataTableRequest request) 
	{
		logger.info("Method : getAllThemes starts");
		
		logger.info("Method : getAllThemes ends");
		
		return propertyThemeDao.getThemeDetails(request);
	}
	/*
	 * for All  Add Theme
	 */
	@RequestMapping(value="restAddTheme" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> restAddTheme(@RequestBody PropertyThemeModel theme) 
	{
		logger.info("Method : restAddTheme starts");
		
		logger.info("Method : restAddTheme ends");
		
		return propertyThemeDao.addTheme(theme);
	}
	/*
	 * for  Theme Edit
	 */
	@RequestMapping(value="getThemeById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<PropertyThemeModel>> getThemeById(@RequestParam String id) 
	{
		logger.info("Method : getThemeById starts");
		
		logger.info("Method : getThemeById ends");
		
		return propertyThemeDao.getThemeById(id);
	}
	/*
	 * for All Theme Delete
	 */
	@RequestMapping(value="deleteThemeById" , method={RequestMethod.GET})
	public ResponseEntity<JsonResponse<Object>> deleteThemeById(@RequestParam String id, @RequestParam String createdBy) 
	{
		logger.info("Method : deleteThemeById starts");
		
		logger.info("Method : deleteThemeById ends");
		
		return propertyThemeDao.deleteThemeById(id,createdBy);
	}
}
