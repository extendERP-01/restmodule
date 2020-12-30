/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.util.Random;

import nirmalya.aatithya.restmodule.property.model.AmenityForm;
import nirmalya.aatithya.restmodule.property.model.PropertyModel;
import nirmalya.aatithya.restmodule.property.model.PropertyTypeForm;

/**
 * @author Manoranjan Nayak
 *
 */
public class GeneratePropertyParameter {

	/**
	 * returns parameter set for PropertyModel class
	 **/
	public static String addPropertyParam(PropertyModel prop) {

		String s = "";
		if (prop.getpTypeName() != null || prop.getpTypeName() != "") {
			s = s + "@p_pTypeName='" + prop.getpTypeName() + "',";
		}
		if (prop.getPropertyCategory() != null || prop.getPropertyCategory() != "") {
			s = s + "@p_propertyCategory='" + prop.getPropertyCategory() + "',";
		}
		if (prop.getpTypeActive() != null) {
			s = s + "@p_pTypeActive=" + prop.getpTypeActive() + ",";
		}
		if (prop.getpTypeDescription() != null || prop.getpTypeDescription() != "") {
			s = s + "@p_pTypeDescription='" + prop.getpTypeDescription() + "',";
		}

		if (prop.getPropertyType() != null) {
			s = s + "@p_propertyType='" + prop.getPropertyType() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("Paramerized Query 2= " + s);

		return s;

	}

	/**
	 * returns parameter set for AmenityForm class
	 **/
	public static String getAmenityParam(AmenityForm form) {

		String s = "";
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int rand_int1 = rand.nextInt(100);

		if (!form.getAmenitiesId().contentEquals("0")) {
			s = s + "@amenities='" + form.getAmenitiesId() + "',";
		} else {
			s = s + "@amenities='',";
		}

		s = s + "@propertyCategory='" + form.getPropertyCategoryId() + "',";
		s = s + "@smntsName='" + form.getAmntsName() + "',";
		s = s + "@amntsDescription='" + form.getAmntsDescription() + "',";
		s = s + "@amntsActive=" + form.getAmntsActive() + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	/**
	 * returns parameter set for PropertyTypeForm class
	 **/
	public static String getPropertyTypeParam(PropertyTypeForm propertyTypeForm) {

		String s = "";

		if (propertyTypeForm.getAmntsName() != null && propertyTypeForm.getAmntsName() != "") {

		}
		if (propertyTypeForm.getpTypeActive() != null) {

			s = s + "@p_pTypeActive=" + propertyTypeForm.getpTypeActive() + ",";

		}
		if (propertyTypeForm.getpCategoryName() != null && propertyTypeForm.getpCategoryName() != "") {

		}
		if (propertyTypeForm.getPropertyCategory() != null && propertyTypeForm.getPropertyCategory() != "") {

			s = s + "@p_propertyCategory='" + propertyTypeForm.getPropertyCategory() + "',";

		}
		if (propertyTypeForm.getPropertyType() != null && propertyTypeForm.getPropertyType() != "") {
			s = s + "@p_propertyType='" + propertyTypeForm.getPropertyType() + "',";
		}
		if (propertyTypeForm.getpTypeDescription() != null && propertyTypeForm.getpTypeDescription() != "") {

			s = s + "@p_pTypeDescription='" + propertyTypeForm.getpTypeDescription() + "',";

		}
		if (propertyTypeForm.getpTypeName() != null && propertyTypeForm.getpTypeName() != "") {

			s = s + "@p_pTypeName='" + propertyTypeForm.getpTypeName() + "',";
		}
		if (propertyTypeForm.getCreatedBy()!= null && propertyTypeForm.getCreatedBy() != "") {

			s = s + "@p_createdBy='" + propertyTypeForm.getCreatedBy() + "',";
		}
		if (propertyTypeForm.getAmenities() != null && propertyTypeForm.getAmenities() != "") {

			String am = "";

			String[] amList = propertyTypeForm.getAmenities().split(",");

			for (int i = 0; i < amList.length; i++) {

				am = am + "(@PrtId,\"" + amList[i] + "\"),";
			}

			am = am.substring(0, am.length() - 1);

			s = s + "@p_amenities='" + am + "'";

		}

		if (s != "") {
			s = "SET " + s + ";";
		}

		return s;
	}

	

}
