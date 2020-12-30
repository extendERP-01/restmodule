package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.reimbursement.model.HrmsPolicyMasterModel;

public class GeneratePolicyMasterParameter {

	public static String getAddPolicyTypeParam(HrmsPolicyMasterModel hrmsPolicyMasterModel) {
		String s = "";

		if (hrmsPolicyMasterModel.getPolicyId() != null) {
			s = s + "@P_policyId='" + hrmsPolicyMasterModel.getPolicyId() + "',";
		}
		if (hrmsPolicyMasterModel.getPolicyName() != null
				&& hrmsPolicyMasterModel.getPolicyName() != "") {
			s = s + "@p_PolicyName='" + hrmsPolicyMasterModel.getPolicyName() + "',";
		}

		if (hrmsPolicyMasterModel.getDesc() != null
				&& hrmsPolicyMasterModel.getDesc() != "") {
			s = s + "@p_PolicyDesc='" + hrmsPolicyMasterModel.getDesc() + "',";
		}
		if (hrmsPolicyMasterModel.getCreatedBy() != null && hrmsPolicyMasterModel.getCreatedBy() != " ") {
			s = s + "@p_createdBy='" + hrmsPolicyMasterModel.getCreatedBy() + "',";
		}
		if (hrmsPolicyMasterModel.getCompanyId() != null && hrmsPolicyMasterModel.getCompanyId() != "") {
			s = s + "@p_companyId='" + hrmsPolicyMasterModel.getCompanyId() + "',";
		}
		if (hrmsPolicyMasterModel.getReimType() != null && hrmsPolicyMasterModel.getReimType() != "") {
			s = s + "@p_reimType='" + hrmsPolicyMasterModel.getReimType() + "',";
		}
		if (hrmsPolicyMasterModel.getTimePeriod() != null && hrmsPolicyMasterModel.getTimePeriod() != "") {
			s = s + "@p_timePeriod='" + hrmsPolicyMasterModel.getTimePeriod() + "',";
		}
		if (hrmsPolicyMasterModel.getAmount()!= null ) {
			s = s + "@p_amount='" + hrmsPolicyMasterModel.getAmount() + "',";
		}
		if (hrmsPolicyMasterModel.getUserRole()!= null  || hrmsPolicyMasterModel.getUserRole() !="") {
			s = s + "@p_userRole='" + hrmsPolicyMasterModel.getUserRole() + "',";
		}
		if (hrmsPolicyMasterModel.getStatus() == true
				|| hrmsPolicyMasterModel.getStatus() == false) {
			s = s + "@p_active=" + hrmsPolicyMasterModel.getStatus() + ",";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}
}
