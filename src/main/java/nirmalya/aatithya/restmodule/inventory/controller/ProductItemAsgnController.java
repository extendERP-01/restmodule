package nirmalya.aatithya.restmodule.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DataTableRequest;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.ProductItemDao;
import nirmalya.aatithya.restmodule.inventory.model.ProductModel;

@RestController
@RequestMapping("inventory/")
public class ProductItemAsgnController {
	Logger logger = LoggerFactory.getLogger(ProductItemAsgnController.class);
	
	@Autowired
	ProductItemDao productItemDao;
	
	@PostMapping("add-product-item")
	public ResponseEntity<JsonResponse<Object>> addProductItem(@RequestBody List<ProductModel> viModel){
		logger.info("adding Product......");
		
		return productItemDao.addProductItem(viModel);
	}
	
	@PostMapping("get-product-items")
	public ResponseEntity<JsonResponse<List<ProductModel>>> getProductItems(@RequestBody DataTableRequest request){
		logger.info("getting All Products......");
		
		return productItemDao.getProductItemDatails(request);
	}
	
	@GetMapping("delete-product")
	public ResponseEntity<JsonResponse<Object>> unassignItem(@RequestParam String id){
		logger.info("deleting Product......");
		
		return productItemDao.deleteProduct(id);
	}
	
	@GetMapping("get-product-itemById")
	public ResponseEntity<JsonResponse<List<ProductModel>>> updateProduct(@RequestParam String id){
		logger.info("getting  item by id....");
		
		return productItemDao.updateProduct(id);
	}
	
	@GetMapping("get-product-item-auto-cmplt")
	public JsonResponse<List<DropDownModel>> getItemAutoCmplt(@RequestParam String key,@RequestParam String vid){
		logger.info("getting  item autoCmplt......");
		
		return productItemDao.getItemAutoCmplt(key,vid);
	}
	
	@GetMapping("get-product-auto-cmplt")
	public JsonResponse<List<DropDownModel>> getItemAutoCmplt(@RequestParam String key){
		logger.info("getItemAutoCmplt starts");
		logger.info("getItemAutoCmplt ends");
		
		return productItemDao.getItemAutoCmplt(key);
	}
}

