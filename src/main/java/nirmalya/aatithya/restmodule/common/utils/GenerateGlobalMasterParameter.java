package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.GlobalMasterRestModel;

public class GenerateGlobalMasterParameter {

	public static String Country(GlobalMasterRestModel country) {

		String s = "";

		if (country.getGlobalId() != null && country.getGlobalId() != "") {
			s = s + "@p_globalId='" + country.getGlobalId() + "',";
		}

		if (country.getCountryOrderId() != null && country.getCountryOrderId() != "") {
			s = s + "@p_countryId='" + country.getCountryOrderId() + "',";
		}
		if (country.getCountryName() != null && country.getCountryName() != "") {
			s = s + "@p_countryName='" + country.getCountryName() + "',";
		}
		if (country.getCountryCode() != null && country.getCountryCode() != "") {
			s = s + "@p_countrycode='" + country.getCountryCode() + "',";
		}
		if (country.getCountryStatus() != null && country.getCountryStatus() != "") {
			s = s + "@p_countrystatus='" + country.getCountryStatus() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

	public static String State(GlobalMasterRestModel state) {

		String s = "";

		if (state.getStateId() != null && state.getStateId() != "") {
			s = s + "@p_stateId='" + state.getStateId() + "',";
		}

		if (state.getGlobalId() != null && state.getGlobalId() != "") {
			s = s + "@p_globalId='" + state.getGlobalId() + "',";
		}

		if (state.getStateOrderId() != null && state.getStateOrderId() != "") {
			s = s + "@p_stateorderId='" + state.getStateOrderId() + "',";
		}

		if (state.getStateCode() != null && state.getStateCode() != "") {
			s = s + "@p_statecode='" + state.getStateCode() + "',";
		}
		if (state.getStateName() != null && state.getStateName() != "") {
			s = s + "@p_stateName='" + state.getStateName() + "',";
		}
		if (state.getStateStatus() != null && state.getStateStatus() != "") {
			s = s + "@p_statestatus='" + state.getStateStatus() + "',";
		}
		if (state.getStateCreatedBy() != null && state.getStateCreatedBy() != "") {
			s = s + "@p_statecreatedBy='" + state.getStateCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
	
	public static String City(GlobalMasterRestModel city) {

		String s = "";

		if (city.getCityId() != null && city.getCityId() != "") {
			s = s + "@p_cityId='" + city.getCityId() + "',";
		}

		if (city.getGlobalId() != null && city.getGlobalId() != "") {
			s = s + "@p_globalId='" + city.getGlobalId() + "',";
		}

		if (city.getStateId() != null && city.getStateId() != "") {
			s = s + "@p_stateId='" + city.getStateId() + "',";
		}
		
		if (city.getDistrictId() != null && city.getDistrictId() != "") {
			s = s + "@p_districtId='" + city.getDistrictId() + "',";
		}
		
		if (city.getCityOrderId() != null && city.getCityOrderId() != "") {
			s = s + "@p_cityorderId='" + city.getCityOrderId() + "',";
		}

		if (city.getCityCode() != null && city.getCityCode() != "") {
			s = s + "@p_citycode='" + city.getCityCode() + "',";
		}
		if (city.getCityName() != null && city.getCityName() != "") {
			s = s + "@p_cityName='" + city.getCityName() + "',";
		}
		if (city.getCityStatus() != null && city.getCityStatus() != "") {
			s = s + "@p_citystatus='" + city.getCityStatus() + "',";
		}
		if (city.getCityCreatedBy() != null && city.getCityCreatedBy() != "") {
			s = s + "@p_citycreatedBy='" + city.getCityCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
