/**Defines UserComparePropertyController*/
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
import nirmalya.aatithya.restmodule.common.utils.DataSetForPropType1;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.dao.PropertyCompareDao;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "property")
public class ComparePropertyController {

	Logger logger = LoggerFactory.getLogger(ComparePropertyController.class);
	@Autowired
	PropertyCompareDao propertyCompareDao;

	/*
	 * Get Property category Name
	 *
	 */
	@RequestMapping(value = "getPropCatgName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateName(String getStateName) {
		logger.info("Method : getPropCatgName starts");
		logger.info("Method : getPropCatgName ends");
		return propertyCompareDao.getPropCatgName("getPropCatgName");
	}
	/*
	 * ############################### END
	 * #############################################
	 */

	/*
	 * Get Property type Name onchange
	 *
	 */

	@RequestMapping(value = "restGetPropertyTypeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyTypeByProCatId(@RequestParam String proType) {
		logger.info("Method : RESTMODULE  getPropertyTypeByProCatId starts");
		logger.info("Method : RESTMODULE  getPropertyTypeByProCatId ends");
		return propertyCompareDao.getPropertyTypeListById(proType);
	}
	/*
	 * ######################################## END
	 * #################################################
	 */

	/*
	 * Get Attribute Name onchange
	 *
	 */

	@RequestMapping(value = "restGetAttributeById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAttributeList(@RequestParam String proType) {
		logger.info("Method : RESTMODULE  getAttributeList starts");
		logger.info("Method : RESTMODULE  getAttributeList ends");
		return propertyCompareDao.getAttributeList(proType);
	}

	/*
	 * ######################################## END
	 * #################################################
	 */

	/*
	 * Get Property type1 Name onchange
	 *
	 */

	@RequestMapping(value = "restPropertyType11", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DataSetForPropType1>>> restPropertyType11(
			@RequestBody List<DataSetForPropType1> table) {
		logger.info("Method : restPropertyType11 starts");
		logger.info("Method : restPropertyType11 ends");
		return propertyCompareDao.getPropertyType11(table);
	}

	/*
	 * ######################################## END
	 * #################################################
	 */

	/*
	 * Get Property type2 Name onchange
	 *
	 */

	@RequestMapping(value = "restPropertyType22", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<DataSetForPropType1>>> restPropertyType22(
			@RequestBody List<DataSetForPropType1> table) {
		logger.info("Method : restPropertyType22 starts");
		logger.info("Method : restPropertyType22 ends");
		return propertyCompareDao.getPropertyType22(table);
	}
	/*
	 * ######################################## END
	 * #################################################
	 */
}
