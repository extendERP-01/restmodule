package nirmalya.aatithya.restmodule.common.utils;

/*
 * generate param for approve active
 */
import nirmalya.aatithya.restmodule.user.model.UserApprovalActionModel;

public class GenerateUserApprovalParameter {

	public static String getAddaprovalParam(UserApprovalActionModel aproval) {

		String s = "";

		if (aproval.getApprovalId() != null && aproval.getApprovalId() != "") {
			s = s + "@p_aprovalId='" + aproval.getApprovalId() + "',";
		}
		if (aproval.getActName() != null && aproval.getActName() != " ") {
			s = s + "@p_aprovalName='" + aproval.getActName() + "',";
		}
		if (aproval.getButtonClass() != null && aproval.getButtonClass() != " ") {
			s = s + "@p_buttonClass='" + aproval.getButtonClass() + "',";
		}
		if (aproval.getDescription() != null && aproval.getDescription() != " ") {
			s = s + "@p_aprovalDesc='" + aproval.getDescription() + "',";
		}
		if (aproval.getActStatus() == true || aproval.getActStatus() == false) {
			s = s + "@p_active=" + aproval.getActStatus() + ",";
		}
		if (aproval.getCreatedBy() != null || aproval.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + aproval.getCreatedBy() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
