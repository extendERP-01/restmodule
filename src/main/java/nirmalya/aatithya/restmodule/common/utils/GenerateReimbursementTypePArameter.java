package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementTypeModel;

public class GenerateReimbursementTypePArameter {
	public static String getAddReimbursementTypeParam(HrmsReimbursementTypeModel reimbursementType) {
		String s = "";

		if (reimbursementType.getReimbursementTypeId() != null) {
			s = s + "@P_rembId='" + reimbursementType.getReimbursementTypeId() + "',";
		}
		if (reimbursementType.getReimbursementTypeName() != null
				&& reimbursementType.getReimbursementTypeName() != "") {
			s = s + "@p_reimbursementTypeName='" + reimbursementType.getReimbursementTypeName() + "',";
		}

		if (reimbursementType.getReimbursementTypeDesc() != null
				&& reimbursementType.getReimbursementTypeDesc() != "") {
			s = s + "@p_reimbursementTypeDesc='" + reimbursementType.getReimbursementTypeDesc() + "',";
		}
		if (reimbursementType.getCreatedBy() != null && reimbursementType.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + reimbursementType.getCreatedBy() + "',";
		}
		if (reimbursementType.getCompanyId() != null && reimbursementType.getCompanyId() != "") {
			s = s + "@p_companyId='" + reimbursementType.getCompanyId() + "',";
		}
		if (reimbursementType.getReimbursementTypeStatus() == true
				|| reimbursementType.getReimbursementTypeStatus() == false) {
			s = s + "@p_active=" + reimbursementType.getReimbursementTypeStatus() + ",";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
