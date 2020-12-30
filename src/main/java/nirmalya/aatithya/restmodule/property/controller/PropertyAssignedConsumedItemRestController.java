/**
 * Rest Controller For AssignConsumedItems
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.dao.PropertyAssignedConsumedItemDao;
import nirmalya.aatithya.restmodule.property.model.PropertyAssignConsumedItemModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "property")
public class PropertyAssignedConsumedItemRestController {

	Logger logger = LoggerFactory.getLogger(PropertyAssignedConsumedItemRestController.class);

	@Autowired
	PropertyAssignedConsumedItemDao propertyAssignedConsumedItemDao;

	/*
	 * 
	 * Get mapping for get ItemCategory
	 * 
	 * 
	 */
	@RequestMapping(value = "get-itemCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getItemCategory() {
		logger.info("Method : getItemCategory starts");
		logger.info("Method : getItemCategory endss");
		return propertyAssignedConsumedItemDao.getItemCategory();
	}

	/*
	 * 
	 * Get mapping for get ItemSubCategory
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-itemSubCategory", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubItemCategory(@RequestParam String id) {
		logger.info("Method : getSubItemCategory starts");

		logger.info("Method : getSubItemCategory endss");
		return propertyAssignedConsumedItemDao.getItemSubCategory(id);
	}
	/*
	 * 
	 * Get mapping for get ItemName
	 * 
	 * 
	 */

	@RequestMapping(value = "/get-itemName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemName(@RequestParam String id) {
		logger.info("Method : getItemName starts");

		logger.info("Method : getItemName endss");
		return propertyAssignedConsumedItemDao.getItemName(id);
	}

	@RequestMapping(value = "get-propertyCategory", method = { RequestMethod.GET })
	public List<DropDownModel> restGetProperty() {
		logger.info("Method : restGetProperty starts");

		logger.info("Method : restGetProperty ends");
		return propertyAssignedConsumedItemDao.getPropertyCategory();
	}

	@RequestMapping(value = "/get-propertyName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyName(@RequestParam String id) {
		logger.info("Method : getPropertyName starts");

		logger.info("Method : getPropertyName endss");
		return propertyAssignedConsumedItemDao.getPropertyName(id);
	}

	@RequestMapping(value = "/get-amenityName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAmenityName(@RequestParam String id) {
		logger.info("Method : getAmenityName starts");

		logger.info("Method : getAmenityName endss");
		return propertyAssignedConsumedItemDao.getAmenityName(id);
	}

	@RequestMapping(value = "/get-itemcategory-name", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemCategoryName(@RequestParam String id) {
		logger.info("Method : getItemCategoryName starts");

		logger.info("Method : getItemCategoryName endss");
		return propertyAssignedConsumedItemDao.getItemCategoryName(id);
	}

	/*
	 * 
	 * PostMapping for add rest add
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-add-assign-consumed", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addAssignConsumed(
			@RequestBody PropertyAssignConsumedItemModel propertyAssignConsumedItemModel) {
		logger.info("Method : addAssignConsumed starts");
		logger.info("Method : addAssignConsumed ends");
		System.out.println("in add assign" + propertyAssignConsumedItemModel);
		return propertyAssignedConsumedItemDao.addAssignConsumed(propertyAssignConsumedItemModel);
	}

	/*
	 * 
	 * post Mapping for listing AssignConsumed
	 * 
	 * 
	 */
	@RequestMapping(value = "get-all-assign-consumeditem", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>> getAllAssignConsumed(
			@RequestBody DataTableRequest request) {
		return propertyAssignedConsumedItemDao.getAllAssignConsumed(request);

	}

	/*
	 * for delete
	 */
	@RequestMapping(value = "deleteAssignConsumedItem", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAssignConsumedItem(@RequestParam String id,
			@RequestParam String ac, @RequestParam String createdBy) {
		logger.info("Method : deleteAssignConsumedItem starts in rest");

		logger.info("Method : deleteAssignConsumedItem ends in rest");

		return propertyAssignedConsumedItemDao.deleteAssignConsumedItem(id, ac, createdBy);
	}

	/*
	 * for one modal view
	 */
	@RequestMapping(value = "modalViewAssignConsumed", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyAssignConsumedItemModel>> modalViewAssignConsume(@RequestParam String id,
			@RequestParam String an) {
		logger.info("Method in rest : modalViewAssignConsume starts");

		logger.info("Method in rest: modalViewAssignConsume ends");

		return propertyAssignedConsumedItemDao.modalViewAssignConsume(id, an);
	}

	/*
	 * 
	 * Get mapping for get Property Name
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-propertyName", method = { RequestMethod.GET })
	public List<DropDownModel> getProperty() {
		logger.info("Method : getProperty starts");
		logger.info("Method : getProperty endss");
		return propertyAssignedConsumedItemDao.getProperty();
	}

	/*
	 * 
	 * Get mapping for get Item Name
	 * 
	 * 
	 */
	@RequestMapping(value = "rest-get-ItemName", method = { RequestMethod.GET })
	public List<DropDownModel> getItem() {
		logger.info("Method : getItem starts");
		logger.info("Method : getItem endss");
		return propertyAssignedConsumedItemDao.getItem();
	}

	@RequestMapping(value = "get-all-assign-consumeditem-pdf", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>> getAssignConsumedPdf(
			@RequestBody DataTableRequest request) {
		return propertyAssignedConsumedItemDao.getAssignConsumedPdf(request);

	}

	@RequestMapping(value = "get-all-assign-consumed-report", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAssignConsumedItemModel>>> getAssignConsumedReport(
			@RequestBody DataTableRequest request) {
		return propertyAssignedConsumedItemDao.getAssignConsumedReport(request);

	}
}
