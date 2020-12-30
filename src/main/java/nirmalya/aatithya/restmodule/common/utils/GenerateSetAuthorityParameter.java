package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.user.model.UserSetAuthority;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateSetAuthorityParameter {
	/**
	 * returns parameter set for user authority parameter
	 **/
	public static String getAddSetAuthorityParam(List<UserSetAuthority> setAuthority) {
		String s = "";
		String litem = "";
		String deleteAuthority = "";
		for (UserSetAuthority m : setAuthority) {

			deleteAuthority = deleteAuthority + "(\"" + m.getProcess() + "\"),";

			litem = litem + "(\"" + m.getProcess() + "\",\"" + m.getUserRole() + "\",\"" + m.getUser() + "\",\""
					+ m.getStageNo() + "\",\"" + m.getTat() + "\",\"" + m.getCreatedBy() + "\"),";

		}

		deleteAuthority = deleteAuthority.substring(0, deleteAuthority.length() - 1);
		litem = litem.substring(0, litem.length() - 1);
		s = s + "@p_deleteAuthority='" + "(" + deleteAuthority + ")" + "',";
		s = s + "@p_StaffSubQuery='" + litem + "',";

		if (s != "")

		{
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
