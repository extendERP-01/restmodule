package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.user.model.UserTypeModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateUserTypeParameter {
	/**
	 * returns parameter set for user type parameter
	 **/

	public static String getAddUserTypeParam(UserTypeModel form) {
		String s = "";

		if (form.getUserType() != null && form.getUserType() != "") {
			s = s + "@p_userType='" + form.getUserType() + "',";
		}

		if (form.getUserTypeName() != null && form.getUserTypeName() != "") {
			s = s + "@p_userTypeName='" + form.getUserTypeName() + "',";
		}

		if (form.getUserTypeDescrptn() != null && form.getUserTypeDescrptn() != "") {
			s = s + "@p_userTypeDescrptn='" + form.getUserTypeDescrptn() + "',";
		}
		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";
		}

		if (form.getUserTypeActive() != null) {
			s = s + "@p_userTypeActive=" + form.getUserTypeActive() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
