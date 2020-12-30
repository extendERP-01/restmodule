package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.AccountGroupMasterModel;


public class GenerateAccountGroupMasterParameter {
	public static String getAddAccountGroupParam(AccountGroupMasterModel form) {
		String s = "";

		if (form.getAccGroup() != null && form.getAccGroup() != "") {
			s = s + "@p_accgroupId='" + form.getAccGroup() + "',";
		}

		if (form.getAccGroupName() != null && form.getAccGroupName() != "") {
			s = s + "@p_accgroupName='" + form.getAccGroupName() + "',";
		}
		

		if (form.getAccGroupCode() != null && form.getAccGroupCode() != "") {
			s = s + "@p_accgroupCode='" + form.getAccGroupCode() + "',";
		}
		if (form.getAccGrupDescription() != null && form.getAccGrupDescription() != "") {
			s = s + "@p_accgroupDesc='" + form.getAccGrupDescription() + "',";
		}
		
		if (form.getAccGrupActive() != null) {
			s = s + "@p_accgroupActive=" + form.getAccGrupActive() + ",";
		}
		if (form.getAccGrupCreatedBy() != null && form.getAccGrupCreatedBy() != "") {
			s = s + "@p_accCreatedBy='" + form.getAccGrupCreatedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
	//System.out.println("s+++" +s);
		return s;
	}
}
