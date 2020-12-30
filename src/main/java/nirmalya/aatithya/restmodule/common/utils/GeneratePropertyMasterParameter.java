/**Defines SQL SET Parameters */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.model.PropertyMasterModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GeneratePropertyMasterParameter {
	/**
	 * returns parameter set for property master
	 **/
	public static String getAddPropertyMasterParam(PropertyMasterModel form) {
		String s = "";

		if (form.getPropertyId() != null && form.getPropertyId() != "") {
			s = s + "@p_propertyId='" + form.getPropertyId() + "',";
		}
		if (form.getPropertyCreatedBy() != null && form.getPropertyCreatedBy() != "") {
			s = s + "@p_propertyCreatedBy='" + form.getPropertyCreatedBy() + "',";
		}


		if (form.getPropertyCategory() != null && form.getPropertyCategory() != "") {
			s = s + "@p_propertyCategory='" + form.getPropertyCategory() + "',";
		}

		if (form.getPropertyType() != null && form.getPropertyType() != "") {
			s = s + "@p_propertyType='" + form.getPropertyType() + "',";
		}

		if (form.getPropertyFloor() != null && form.getPropertyFloor() != "") {
			s = s + "@p_propertyFloor='" + form.getPropertyFloor() + "',";
		}

		if (form.getPropertyName() != null && form.getPropertyName() != "") {
			s = s + "@p_propertyName='" + form.getPropertyName() + "',";
		}

		if (form.getCleanStatus() != null) {
			s = s + "@p_cleanStatus=" + form.getCleanStatus() + ",";
		}
		if (form.getPropertyDescription() != null && form.getPropertyDescription() != "") {
			s = s + "@p_propertyDescription='" + form.getPropertyDescription() + "',";
		}

		if (form.getPropertyActive() != null) {
			s = s + "@p_propertyActive=" + form.getPropertyActive() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
}
