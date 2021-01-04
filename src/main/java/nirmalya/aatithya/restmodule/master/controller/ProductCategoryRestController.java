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

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ProductCategoryDao;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master/")
public class ProductCategoryRestController {

	Logger logger = LoggerFactory.getLogger(LocationMasterRestController.class);

	@Autowired
	ProductCategoryDao productCategoryDao;
	
	@RequestMapping(value = "saveProductCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ProductCategoryModel>> saveProductCategory(@RequestBody ProductCategoryModel category) {
		logger.info("Method : saveProductCategory starts");
		
		logger.info("Method : saveProductCategory ends");
		return productCategoryDao.saveProductCategory(category);
	}
	
	@RequestMapping(value = "saveProductSubCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<ProductCategoryModel>> saveProductSubCategory(@RequestBody ProductCategoryModel category) {
		logger.info("Method : saveProductSubCategory starts");
		
		logger.info("Method : saveProductSubCategory ends");
		return productCategoryDao.saveProductSubCategory(category);
	}
	
	@RequestMapping(value = "getAllProductCategoryList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getAllProductCategoryList() {
		logger.info("Method : getAllProductCategoryList starts");
		
		logger.info("Method : getAllProductCategoryList ends");
		return productCategoryDao.getAllProductCategoryList();
	}
	
	@RequestMapping(value = "getProductCategoryListById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryListById(@RequestParam String id) {
		logger.info("Method : getProductCategoryListById starts");
		
		logger.info("Method : getProductCategoryListById ends");
		return productCategoryDao.getProductCategoryListById(id);
	}
	
	@RequestMapping(value = "getProductCategoryById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<ProductCategoryModel>> getProductCategoryById(@RequestParam String id) {
		logger.info("Method : getProductCategoryById starts");
		
		logger.info("Method : getProductCategoryById ends");
		return productCategoryDao.getProductCategoryById(id);
	}
	
	@RequestMapping(value = "deleteCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCategory(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteCategory starts");
		
		logger.info("Method : deleteCategory ends");
		return productCategoryDao.deleteCategory(id,createdBy);
	}
}
