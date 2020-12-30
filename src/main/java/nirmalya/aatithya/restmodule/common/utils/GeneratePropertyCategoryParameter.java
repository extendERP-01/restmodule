/**Defines SQL SET Parameters */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.model.PropertyCategoryModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GeneratePropertyCategoryParameter {
	/**
	 * returns parameter set for property category class
	 **/

	public static String getAddPropertyCategoryParam(PropertyCategoryModel form) {
		String s = "";

		if (form.getPropertyCatId() != null && form.getPropertyCatId() != "") {
			s = s + "@p_propertyCatId='" + form.getPropertyCatId() + "',";
		}

		if (form.getCategoryName() != null && form.getCategoryName() != "") {
			s = s + "@p_categoryName='" + form.getCategoryName() + "',";
		}

		if (form.getCategoryDescription() != null && form.getCategoryDescription() != "") {
			s = s + "@p_categoryDescription='" + form.getCategoryDescription() + "',";
		}

		if (form.getCategoryActive() != null) {
			s = s + "@p_categoryActive=" + form.getCategoryActive() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
