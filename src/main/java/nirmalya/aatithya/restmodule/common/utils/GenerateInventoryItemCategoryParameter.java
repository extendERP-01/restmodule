/**
 * Parameter Set For ItemCategory Class
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.inventory.model.RestInventoryItemCategoryModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateInventoryItemCategoryParameter {
	/**
	 * returns parameter set for inventory ItemCategoryModel class
	 **/

	public static String addItemCategoryParam(RestInventoryItemCategoryModel itemCategoryModel) {

		String s = "";

		if (itemCategoryModel.getItmCategory() != null) {
			s = s + "@p_itmCategory='" + itemCategoryModel.getItmCategory() + "',";
		}
		if (itemCategoryModel.getItmCatName() != null || itemCategoryModel.getItmCatName() != "") {
			s = s + "@p_itmCatName='" + itemCategoryModel.getItmCatName() + "',";
		}
		if (itemCategoryModel.getItmCatDescription() != null || itemCategoryModel.getItmCatDescription() != "") {
			s = s + "@p_itmCatDescription='" + itemCategoryModel.getItmCatDescription() + "',";
		}
		if (itemCategoryModel.getItmCatActive() != null) {
			s = s + "@p_itmCatActive=" + itemCategoryModel.getItmCatActive() + ",";
		}
		if (itemCategoryModel.getCreatedBy() != null || itemCategoryModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + itemCategoryModel.getCreatedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
	/**
	 * search parameter set for inventory Item
	 **/

	public static String getItemCategorySearchParam(DataTableRequest request) {

		String s = "";

		if (request.getStart() != null) {
			s = s + "@p_start=" + request.getStart() + ",";
		}

		if (request.getLength() != null) {
			s = s + "@p_length=" + request.getLength() + ",";
		}

		if (request.getSearch() != null) {
			s = s + "@p_search='" + request.getSearch() + "',";
		}

		if (request.getParam1() != null) {
			s = s + "@p_param1='" + request.getParam1() + "',";
		}

		if (request.getParam2() != null) {
			s = s + "@p_param2='" + request.getParam2() + "',";
		}

		if (request.getParam3() != null) {
			s = s + "@p_param3='" + request.getParam3() + "',";
		}

		if (request.getParam4() != null) {
			s = s + "@p_param4='" + request.getParam4() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
	



}
