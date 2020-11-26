/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.user.model.UserPrefixManagementModel;

/**
 * @author USER
 *
 */
public class GenerateUserPrefixParameter {
	
	/**
	 * UPDATE USER PREFIX
	 *
	 */
	public static String getupdateUserPrefixParam(UserPrefixManagementModel form) {

		String s = "";

		if (form.getPrefix() != null) {
			s = s + "@p_prefix='" + form.getPrefix() + "',";
		}

		/*
		 * if (form.getPrfxTblName() != null && form.getPrfxTblName() != "") { s = s +
		 * "@p_prfxTblName='" + form.getPrfxTblName() + "',"; }
		 * 
		 * if (form.getPrfxTypeName() != null && form.getPrfxTypeName() != "") { s = s +
		 * "@p_prfxTypeName=" + form.getPrfxTypeName() + ","; }
		 */
		if (form.getPrfxCode() != null && form.getPrfxCode() != "") {
			s = s + "@p_prfxCode='" + form.getPrfxCode() + "',";
		}

		s = s + "@p_prfxNumberLength=" + form.getPrfxNumberLength() + ",";
		s = s + "@p_prfxStartNo=" + form.getPrfxStartNo() + ",";
		s = s + "@p_prfxFinYearStatus=" + form.getPrfxFinYearStatus() + ",";
		s = s + "@p_prfxActive=" + form.getPrfxActive() + ",";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
	

}
