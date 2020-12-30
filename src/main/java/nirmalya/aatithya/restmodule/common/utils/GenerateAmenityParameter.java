package nirmalya.aatithya.restmodule.common.utils;

import java.util.Random;

import nirmalya.aatithya.restmodule.property.model.AmenityForm;

public class GenerateAmenityParameter {
	
	
	public static String getAmenityParam(AmenityForm form) {

		String s = "";
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int rand_int1 = rand.nextInt(100);

		if (!form.getAmenitiesId().contentEquals("0")) {
			s = s + "@amenities='" + form.getAmenitiesId() + "',";
		} else {
			s = s + "@amenities='" + "ame3222" + "',";
		}

		s = s + "@propertyCategory='" + form.getPropertyCategoryId() + "',";
		s = s + "@smntsName='" + form.getAmntsName() + "',";
		s = s + "@amntsDescription='" + form.getAmntsDescription() + "',";
		s = s + "@amntsActive=" + form.getAmntsActive() + ",";
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		//System.out.println("Amenity Param  : " + s);

		return s;
	}
	

}
