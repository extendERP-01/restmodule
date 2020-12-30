package nirmalya.aatithya.restmodule.common.utils;


import nirmalya.aatithya.restmodule.account.model.TdsMasterModel;

public class GenerateTdsMasterParameter {
	public static String getAddTdsParam(TdsMasterModel form) {
		String s = "";

		if (form.getTdsId() != null && form.getTdsId() != "") {
			s = s + "@p_tdsId='" + form.getTdsId() + "',";
		}
		if (form.getTdsType() != null && form.getTdsType() != "") {
			s = s + "@p_tdsType='" + form.getTdsType() + "',";
		}
		if (form.getTdsRate() != null) {
			s = s + "@p_tdsRate=" + form.getTdsRate() + ",";
		}
		

		if (form.getCreatedBy() != null && form.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + form.getCreatedBy() + "',";

		}

		if (form.getTdsStatus() != null) {
			s = s + "@p_tdsStatus=" + form.getTdsStatus() + ",";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
			System.out.println(s);
		}

		return s;

	}
}
