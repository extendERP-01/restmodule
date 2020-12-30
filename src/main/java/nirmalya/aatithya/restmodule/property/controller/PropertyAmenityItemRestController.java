
/*
 * rest controller for PropertyAmenityItemRestController
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
import nirmalya.aatithya.restmodule.property.dao.PropertyAmenityItemDao;
import nirmalya.aatithya.restmodule.property.model.PropertyAmenityItemModel;

@RestController
@RequestMapping("property/")
public class PropertyAmenityItemRestController {

	Logger logger = LoggerFactory.getLogger(PropertyAmenityItemRestController.class);

	@Autowired
	PropertyAmenityItemDao amenityItemDao;

	/*
	 * for drop down of property category
	 */
	@RequestMapping(value = "getItemCategoryName", method = { RequestMethod.GET })
	public List<DropDownModel> getPropertyCategoryname() {
		logger.info("Method in rest: getItemCategoryName starts");

		logger.info("Method in rest: getItemCategoryName starts");

		return amenityItemDao.getItemName();
	}

	/*
	 * for drop down of property Type id
	 */
	@RequestMapping(value = "getpropertyTypeId", method = { RequestMethod.GET })
	public List<DropDownModel> getPropertyTypeId() {
		logger.info("Method in rest: getPropertyTypeId starts");

		logger.info("Method in rest: getPropertyTypeId starts");

		return amenityItemDao.getPropertyId();
	}

	/*
	 * for drop down of get amenity
	 */
	@RequestMapping(value = "getamenity", method = { RequestMethod.GET })
	public List<DropDownModel> getAmenityname1() {
		logger.info("Method in rest: getAmenityname1 starts");

		logger.info("Method in rest: getAmenityname1 starts");

		return amenityItemDao.getAmenityList();
	}

	/*
	 * for drop down of get Item Sub Category
	 */
	@RequestMapping(value = "getSubCategory", method = { RequestMethod.GET })
	public List<DropDownModel> getSubCategory() {
		logger.info("Method in rest: getSubCategory starts");

		logger.info("Method in rest: getSubCategory starts");

		return amenityItemDao.getSubCategory();
	}

	/*
	 * for drop down of get Item Name List
	 */
	@RequestMapping(value = "getItemNameList", method = { RequestMethod.GET })
	public List<DropDownModel> getItemName() {
		logger.info("Method in rest: getItemNameList starts");

		logger.info("Method in rest: getItemNameList ends");
		return amenityItemDao.getItemNameList();
	}
	

	/*
	 * for drop down of get getPropertyNameId
	 */
	@RequestMapping(value = "getPropertyIdNames", method = { RequestMethod.GET })
	public List<DropDownModel> getPropertyNameId() {
		logger.info("Method in rest: getPropertyNameId starts");

		logger.info("Method in rest: getPropertyNameId ends");
		return amenityItemDao.getPropertyNameId();
	}
	

	
	/*
	 * for drop down of property type
	 */
	@RequestMapping(value = "/getPropertyTypeName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyTypeName(@RequestParam String proCat) {
		logger.info("Method in rest: getPropertyTypeName starts");

		logger.info("Method in rest: getPropertyTypeName ends");
		return amenityItemDao.getPropertTypeName(proCat);
	}

	/*
	 * for drop down of property type
	 */
	@RequestMapping(value = "/getPropertyType", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyType(@RequestParam String proCat) {
		logger.info("Method in rest: getPropertyTypeName starts");

		logger.info("Method in rest: getPropertyTypeName ends");
		return amenityItemDao.getPropertType(proCat);
	}

	/*
	 * for drop down Amenity name list
	 */
	
	@RequestMapping(value = "/getAmenityName", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getAmenityName(@RequestParam String proType) {
		logger.info("Method in rest: getAmenityName starts");

		logger.info("Method in rest: getAmenityName ends");

		return amenityItemDao.getAmenityName(proType);
	}

	/*
	 * for drop down sub category item list
	 */
	@RequestMapping(value = "/getSubCategoryItemList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSubCategoryItemList(
			@RequestParam String proCategoryId) {
		logger.info("Method in rest: getSubCategoryItemList starts");

		logger.info("Method in rest: getSubCategoryItemList ends");

		return amenityItemDao.getCategoryName(proCategoryId);
	}

	/*
	 * for Drop down item list
	 */
	
	@RequestMapping(value = "/getItemList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getItemList(@RequestParam String ItemSubCat) {
		logger.info("Method in rest: getItemList starts");

		logger.info("Method in rest: getItemList ends");

		return amenityItemDao.getItemList(ItemSubCat);
	}

	/*
	 * for All Add Amenity Item
	 */
	@RequestMapping(value = "restAddAmenityItem", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restAddAmenityItem(@RequestBody PropertyAmenityItemModel amenityItem) {
		logger.info("Method in rest: restAddTheme starts");

		logger.info("Method in rest: restAddTheme ends");

		return amenityItemDao.addAmenityItem(amenityItem);
	}

	/*
	 * for All Amenity Item
	 */
	@RequestMapping(value = "getAllAmenityItem", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<List<PropertyAmenityItemModel>>> getAllThemes(@RequestBody DataTableRequest request) {
		logger.info("Method in rest: getAllThemes starts");

		logger.info("Method in rest: getAllThemes ends");

		return amenityItemDao.getAllAmenityItem(request);
	}

	/*
	 * for one Amenity Item
	 */
	@RequestMapping(value = "getAmenityItemById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<PropertyAmenityItemModel>> getAmenityItemById(@RequestParam String id, @RequestParam String am,
			@RequestParam String itm) {
		logger.info("Method in rest : getAmenityItemById starts");

		logger.info("Method in rest: getAmenityItemById ends");

		return amenityItemDao.getAmenityItemById(id, am, itm);
	}

	/*
	 * for Edit Amenity Item
	 */
	@RequestMapping(value = "restEditAmenityItem", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> restEditAmenity(@RequestBody PropertyAmenityItemModel amenityItem) {
		logger.info("Method in rest: rest Edit Amenity Item starts");

		logger.info("Method in rest: rest Edit Amenity Item ends");

		return amenityItemDao.editAmenityItem(amenityItem);
	}

}
