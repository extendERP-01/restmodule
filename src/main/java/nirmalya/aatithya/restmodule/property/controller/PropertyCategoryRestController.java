/*
 * Defines property category Rest Controller

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

import nirmalya.aatithya.restmodule.property.dao.PropertyCategoryDao;
import nirmalya.aatithya.restmodule.property.model.PropertyCategoryModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping("property")
public class PropertyCategoryRestController {
	Logger logger = LoggerFactory.getLogger(PropertyCategoryRestController.class);

	@Autowired
	PropertyCategoryDao propcatDao;

	/**
	 * Post Mapping to Add new property category
	 *
	 */
	@RequestMapping(value = "/addCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addproperty(@RequestBody PropertyCategoryModel form) {

		logger.info("Method : addproperty starts");

		logger.info("Method : addproperty end");

		return propcatDao.addproperty(form);

	}

	/**
	 * Post Mapping to view property category
	 *
	 */
	@RequestMapping(value = "/getAllcategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyCategoryModel>>> getAllCategory(
			@RequestBody DataTableRequest request) {

		logger.info("Method : getAllCategory starts");

		logger.info("Method : getAllCategory end");

		return propcatDao.getAllCategory(request);
	}

	/**
	 * get Mapping to delete property category
	 *
	 */
	@RequestMapping(value = "/deleteCategoryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCategory(@RequestParam String id) {

		logger.info("Method : deleteCategory starts");

		logger.info("Method : deleteCategory end");

		return propcatDao.deleteCategory(id);
	}

	/**
	 * returns edit property category
	 *
	 */
	@RequestMapping(value = "/getCategoryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyCategoryModel>> getCategoryById(@RequestParam String id) {

		logger.info("Method : getCategoryById starts");

		logger.info("Method : getCategoryById end");

		return propcatDao.getCategoryById(id);
	}
}
