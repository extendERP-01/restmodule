package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsAdvancePaymentModel;

public class GenerateEmployeeAdvanceParam {
	public static String getAddadvanceParam(HrmsAdvancePaymentModel advance) {

		String s = "";
		System.out.println(advance);
		if (advance.getAdvPayId() != null) {
			s = s + "@p_advId='" + advance.getAdvPayId() + "',";
		}
		if (advance.getDate() != null && advance.getDate() != "") {
			s = s + "@p_date='" + DateFormatter.getStringDate(advance.getDate()) + "',";
		}
		if (advance.getEmployee() != null && advance.getEmployee() != "") {
			s = s + "@p_name='" + advance.getEmployee() + "',";
		}
		if (advance.getAdvPayId() != null) {
			s = s + "@p_advAmount=" + advance.getAmount() + ",";
		}
		if (advance.getPaymentMadeBy() != null && advance.getPaymentMadeBy() != "") {
			s = s + "@p_paymentBy='" + advance.getPaymentMadeBy() + "',";
		}
		if (advance.getPaymentMode() != null && advance.getPaymentMode() != "") {
			s = s + "@p_payMode='" + advance.getPaymentMode() + "',";
		}
		if (advance.getTransactionNo() != null && advance.getTransactionNo() != "") {
			s = s + "@p_transNo='" + advance.getTransactionNo() + "',";
		}
		if (advance.getChequeNo() != null && advance.getChequeNo() != "") {
			s = s + "@p_chequeNo='" + advance.getChequeNo() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
