package nirmalya.aatithya.restmodule.master.controller;

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
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestCategoryDao;
import nirmalya.aatithya.restmodule.master.model.RestCategoryModel;

@RestController
@RequestMapping(value = {"master"})
public class RestCategoryController {
	Logger logger=LoggerFactory.getLogger(RestCategoryController.class);

	@Autowired
	RestCategoryDao restCategoryDao;
	@Autowired
	ServerDao serverDao;
	/*
	 * 
	 * post mapping for add rest category
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addnew-category", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddCategory(@RequestBody RestCategoryModel restCategoryModel) {
		logger.info("Method : restAddCategory starts");
		logger.info("Method : restAddCategory endss");
		return restCategoryDao.addCategory(restCategoryModel);
	}
	/*
	 * 
	 * post Mapping for listing Country
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-category", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestCategoryModel>>> getAllCountry(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllCategory starts");
		logger.info("Method : getAllCategory ends");
		return restCategoryDao.getAllCategory(request);
	}
	/**
	 * returns particular country to view/edit
	 *
	 */
	@RequestMapping(value = "get-category-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestCategoryModel>> getCategoryById(@RequestParam String id) {
		logger.info("Method : getCategoryById starts");
		logger.info("Method : getCategoryById endss");
		return restCategoryDao.getCategoryById(id);
	}
	/*
	 * 
	 * GetMapping for delete Country
	 * 
	 * 
	 */
	@RequestMapping(value = "delete-category", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCategory(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteCategory starts");
		logger.info("Method : deleteCategory ends");
		return restCategoryDao.deleteCategory(id,createdBy);
	}
	
}
