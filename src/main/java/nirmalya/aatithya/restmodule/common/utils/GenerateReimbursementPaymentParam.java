package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.reimbursement.model.HrmsReimbursementPaymentModal;

public class GenerateReimbursementPaymentParam {
	public static String getReimPaymentParam(List<HrmsReimbursementPaymentModal> paymentVoucherModel) {
		String s = "";
		String p = "";
		for (HrmsReimbursementPaymentModal a : paymentVoucherModel) {
			s = s + "@p_empName='" + a.getEmployeeId() + "',";
			s = s + "@p_paymentMode='" + a.getPaymentMode() + "',";
			s = s + "@p_reimbNo='" + a.getReimbNo() + "',";
			s = s + "@p_reqNo='" + a.getReqNo() + "',";
			s = s + "@p_transDate='" + DateFormatter.getStringDate(a.getTransactionDate()) + "',";
			if (a.getBankName() != null) {
				s = s + "@p_bank='" + a.getBankName() + "',";
				s = s + "@p_branch='" + a.getBranchName() + "',";
				s = s + "@p_accno='" + a.getAccNo() + "',";
			} else {
				s = s + "@p_bank=null,";
				s = s + "@p_branch=null,";
				s = s + "@p_accno=null,";
			}
			 
			s = s + "@p_cretaedBy='" + a.getCreatedBy() + "',";
			s = s + "@p_chequeNo='" + a.getChequeNo() + "',";
			s = s + "@p_transNo='" + a.getTransactionNo() + "',";

		}
		p = "(\"";
		for (HrmsReimbursementPaymentModal a : paymentVoucherModel) {
			p = p + a.getReqNo() + "\",\"";
		}
		if (p != "") {
			p = p.substring(0, p.length() - 2);

		}
		p = p + ")";

		s = s + "@p_transSubQuery='" + p + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
