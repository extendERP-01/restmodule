package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.account.model.AccountHeadTypeModel;

public class GenerateAccountHeadTypeParameter {
	public static String getAddAccountHeadParam(AccountHeadTypeModel accountHeadTypeModel) {

		String s = "";

		if (accountHeadTypeModel.getAccountHeadTypeId() != null) {
			s = s + "@p_headId='" + accountHeadTypeModel.getAccountHeadTypeId() + "',";
		}
		if (accountHeadTypeModel.getAccountHeadType() != null && accountHeadTypeModel.getAccountHeadType() != " ") {
			s = s + "@p_headName='" + accountHeadTypeModel.getAccountHeadType() + "',";
		}
		if (accountHeadTypeModel.getDesc() != null && accountHeadTypeModel.getDesc() != " ") {
			s = s + "@p_headDesc='" + accountHeadTypeModel.getDesc() + "',";
		}
		if (accountHeadTypeModel.getCreatedBy() != null && accountHeadTypeModel.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + accountHeadTypeModel.getCreatedBy() + "',";
		}
		if (accountHeadTypeModel.getStatus() == true || accountHeadTypeModel.getStatus() == false) {
			s = s + "@p_active=" + accountHeadTypeModel.getStatus() + ",";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

}
