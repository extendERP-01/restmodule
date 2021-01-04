package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.GlobalMasterRestModel;

public class GenerateGlobalMasterParameter {

	
public static String Country(GlobalMasterRestModel country) {
		
		String s = "";
		
		
		/*
		 * if(country.getGlobalId()!=null && country.getGlobalId()!="") { s = s +
		 * "@p_globalId='" + country.getGlobalId() + "',"; }
		 */
		if(country.getCountryOrderId()!=null && country.getCountryOrderId()!="") {
			s = s + "@p_countryId='" + country.getCountryOrderId() + "',";
		}
		if(country.getCountryName()!=null && country.getCountryName()!="") {
			s = s + "@p_countryName='" + country.getCountryName() + "',";
		}
		if(country.getCountryCode()!=null && country.getCountryCode()!="") {
			s = s + "@p_countrycode='" + country.getCountryCode() + "',";
		}
		if(country.getCountryStatus()!=null && country.getCountryStatus()!="") {
			s = s + "@p_countrystatus='" + country.getCountryStatus() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}
}
