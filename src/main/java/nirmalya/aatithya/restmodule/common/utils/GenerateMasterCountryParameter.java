/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.RestMasterCountryModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateMasterCountryParameter {

	/**
	 * returns parameter set for inventory MasterCountryModel class
	 **/

	public static String addCountryParam(RestMasterCountryModel masterCountryModel) {

		String s ="";
		
		if (masterCountryModel.getCountryId() != null || masterCountryModel.getCountryId() != "") {
			s = s + "@p_masConId='" + masterCountryModel.getCountryId() + "',";
		}
		
		if (masterCountryModel.getCountryName() != null || masterCountryModel.getCountryName() != "") {
			s = s + "@p_masConName='" + masterCountryModel.getCountryName() + "',";
		}
		
		if (masterCountryModel.getCountryCode() != null || masterCountryModel.getCountryCode() != "") {
			s = s + "@p_masConCode='" + masterCountryModel.getCountryCode() + "',";
		}
		
		if (masterCountryModel.getCountryActive() != null) {
			s = s + "@p_masConActive= " + masterCountryModel.getCountryActive() + ",";
		}
		if (masterCountryModel.getCountryCreatedBy() != null || masterCountryModel.getCountryCreatedBy() != "") {
			s = s + "@p_masConCreatedBy='" + masterCountryModel.getCountryCreatedBy() + "',";
		}
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		return s;

	}
}
