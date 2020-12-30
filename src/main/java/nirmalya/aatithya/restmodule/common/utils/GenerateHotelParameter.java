/**Defines SQL SET Parameters */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.model.PropertyHotelModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateHotelParameter {
	/**
	 * returns parameter set for property hotel class
	 **/
	public static String getAddHotelParam(PropertyHotelModel form) {
		String s = "";

		if (form.getHotelId() != null && form.getHotelId() != "") {
			s = s + "@p_hotelId='" + form.getHotelId() + "',";
		}

		if (form.getHotelName() != null && form.getHotelName() != "") {
			s = s + "@p_hotelName='" + form.getHotelName() + "',";
		}

		if (form.getHotelAdress() != null && form.getHotelAdress() != "") {
			s = s + "@p_hotelAdress='" + form.getHotelAdress() + "',";
		}

		if (form.getState() != null && form.getState() != "") {
			s = s + "@p_state='" + form.getState() + "',";
		}

		if (form.getHotelPin() != null && form.getHotelPin() != "") {
			s = s + "@p_hotelPin='" + form.getHotelPin() + "',";
		}
		if (form.getHotelCity() != null && form.getHotelCity() != "") {
			s = s + "@p_hotelCity='" + form.getHotelCity() + "',";
		}
		if (form.getHotelPhone() != null && form.getHotelPhone() != "") {
			s = s + "@p_hotelPhone='" + form.getHotelPhone() + "',";
		}

		if (form.getHotelWebsite() != null && form.getHotelWebsite() != "") {
			s = s + "@p_hotelWebsite='" + form.getHotelWebsite() + "',";
		}

		if (form.getHotelRegdNo() != null && form.getHotelRegdNo() != "") {
			s = s + "@p_hotelRegdNo='" + form.getHotelRegdNo() + "',";
		}

		if (form.getHotelCountry() != null && form.getHotelCountry() != "") {
			s = s + "@p_hotelCountry='" + form.getHotelCountry() + "',";
		}

		if (form.getDistrict() != null && form.getDistrict() != "") {
			s = s + "@p_district='" + form.getDistrict() + "',";
		}

		if (form.getHotelEmail() != null && form.getHotelEmail() != "") {
			s = s + "@p_hotelEmail='" + form.getHotelEmail() + "',";
		}

		if (form.getHotelTin() != null && form.getHotelTin() != "") {
			s = s + "@p_hotelTin='" + form.getHotelTin() + "',";
		}
		
		if (form.getHotelLogo() != null && form.getHotelLogo() != "") {
			s = s + "@p_hotelLogo='" + form.getHotelLogo() + "',";
		}
		if (form.getHotelCreatedBy() != null && form.getHotelCreatedBy() != "") {
			s = s + "@p_hotelCreatedBy='" + form.getHotelCreatedBy() + "',";
		}
		if (form.getHotelStatus() != null) {
			s = s + "@p_hotelStatus=" + form.getHotelStatus() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
}
