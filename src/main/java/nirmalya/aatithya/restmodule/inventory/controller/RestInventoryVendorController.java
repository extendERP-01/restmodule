/*

*Defines Inventory related method call for Vendor
 * 
 */
package nirmalya.aatithya.restmodule.inventory.controller;

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
import nirmalya.aatithya.restmodule.inventory.dao.InventoryVendorDao;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryVendorModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "inventory" })
public class RestInventoryVendorController {
	Logger logger=LoggerFactory.getLogger(RestInventoryVendorController.class);
	@Autowired
	InventoryVendorDao vendorDao;

	/*
	 * 
	 * Get mapping for get Item Category
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-item-category", method = { RequestMethod.GET })
	public List<DropDownModel> getCategoryName() {
		logger.info("Method : getCategoryName starts");
		logger.info("Method : getCategoryName endss");
		return vendorDao.getCategoryName();
	}
	
	@RequestMapping(value = "getCountryForVendor", method = { RequestMethod.GET })
	public List<DropDownModel> getCountryForVendor() {
		logger.info("Method : getCountryForVendor starts");
		logger.info("Method : getCountryForVendor endss");
		return vendorDao.getCountryForVendor();
	}

	/*
	 * 
	 * PostMapping for add rest Vendors
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-addNew-vendor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddVendor(@RequestBody RestInventoryVendorModel restVendorModel) {
		logger.info("Method : restAddVendor starts");
		logger.info("Method : restAddVendor endss");
		return vendorDao.addVendor(restVendorModel);
	}
	
	@RequestMapping(value = "uploadVendorContract", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> uploadVendorContract(@RequestBody RestInventoryVendorModel restVendorModel) {
		logger.info("Method : uploadVendorContract starts");
		logger.info("Method : uploadVendorContract endss");
		return vendorDao.uploadVendorContract(restVendorModel);
	}
	
	@RequestMapping(value = "blacklistVendor", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> blacklistVendor(@RequestBody RestInventoryVendorModel restVendorModel) {
		logger.info("Method : blacklistVendor starts");
		logger.info("Method : blacklistVendor endss");
		return vendorDao.blacklistVendor(restVendorModel);
	}
	
	@RequestMapping(value = "submitVendorRate", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> submitVendorRate(@RequestBody RestInventoryVendorModel restVendorModel) {
		logger.info("Method : submitVendorRate starts");
		logger.info("Method : submitVendorRate endss");
		return vendorDao.submitVendorRate(restVendorModel);
	}

	/*
	 * 
	 * PostMapping for get All Vendors
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-vendors", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryVendorModel>>> getAllVendors(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllVendors starts");
		logger.info("Method : getAllVendors endss");
		return vendorDao.getAllVendors(request);
	}
	
	@RequestMapping(value = "get-all-blacklisted-vendors", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<RestInventoryVendorModel>>> getAllBlacklistedVendors(@RequestBody DataTableRequest request) {
		logger.info("Method : getAllBlacklistedVendors starts");
		logger.info("Method : getAllBlacklistedVendors endss");
		return vendorDao.getAllBlacklistedVendors(request);
	}
	
	@RequestMapping(value = "getStateForVendor", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateForVendor(@RequestParam String id) {
		logger.info("Method : getStateForVendor starts");
		logger.info("Method : getStateForVendor endss");
		return vendorDao.getStateForVendor(id);
	}
	
	@RequestMapping(value = "editStateForVendor", method = { RequestMethod.GET })
	public List<DropDownModel> editStateForVendor(@RequestParam String id) {
		logger.info("Method : editStateForVendor starts");
		logger.info("Method : editStateForVendor endss");
		return vendorDao.editStateForVendor(id);
	}

	/*
	 * 
	 * Get mapping for get One Vendor For Edit
	 * 
	 * 
	 */
	@RequestMapping(value = "get-vendor-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestInventoryVendorModel>> getVendorById(@RequestParam String id) {
		logger.info("Method : getVendorById starts");
		logger.info("Method : getVendorById endss");
		return vendorDao.getVendorById(id);
	}

	/*
	 * 
	 * Get mapping for get One Vendor For modal
	 * 
	 * 
	 */
	@RequestMapping(value = "get-vendor-for-model", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestInventoryVendorModel>> getVendorForModel(@RequestParam String id) {
		logger.info("Method : getVendorForModel starts");
		logger.info("Method : getVendorForModel endss");
		return vendorDao.getVendorForModel(id);
	}
	/*
	 * 
	 * GetMapping for delete Vendor
	 * 
	 * 
	 */
	@RequestMapping(value = "delete-vendor-byId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVendor(@RequestParam String id,@RequestParam String createdBy) {
		logger.info("Method : deleteVendor starts");
		logger.info("Method : deleteVendor endss");
		return vendorDao.deleteVendor(id,createdBy);
	}
	
	@RequestMapping(value = "/getVendorListByAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorListByAutoSearch(@RequestParam String id) {
		logger.info("Method : getVendorListByAutoSearch starts");

		logger.info("Method : getVendorListByAutoSearch ends");
		return vendorDao.getVendorListByAutoSearch(id);
	}
	
	@RequestMapping(value = "/blacklisttVendorAutoSearch", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> blacklisttVendorAutoSearch(@RequestParam String id) {
		logger.info("Method : blacklisttVendorAutoSearch starts");
		
		logger.info("Method : blacklisttVendorAutoSearch ends");
		return vendorDao.blacklisttVendorAutoSearch(id);
	}
	
	/*
	 * Get itemCategory By Id
	 */
	@RequestMapping(value = "rest-get-item-category-byId", method = { RequestMethod.GET })
	public List<DropDownModel> getItemCategoryById(@RequestParam String id) {
		logger.info("Method : getting item category.......");
		
		return vendorDao.getCategoryNameById(id);
	}
}
