package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.master.model.PaymentModeMasterModel;

public class GeneratePaymentModeMasterParameter {

	public static String getAddPaymentParam(PaymentModeMasterModel form) {
		String s = "";

		if (form.getPaymentMode() != null && form.getPaymentMode() != "") {
			s = s + "@p_paymentId='" + form.getPaymentMode() + "',";
		}

		if (form.getPaytModName() != null && form.getPaytModName() != "") {
			s = s + "@p_paymentName='" + form.getPaytModName() + "',";
		}
		

		if (form.getPaytModDescription() != null && form.getPaytModDescription() != "") {
			s = s + "@p_paymentDesc='" + form.getPaytModDescription() + "',";
		}

		if (form.getPayModActive() != null) {
			s = s + "@p_paymentActive=" + form.getPayModActive() + ",";
		}
		if (form.getPayModCreatedBy() != null && form.getPayModCreatedBy() != "") {
			s = s + "@p_paymentCreatedBy='" + form.getPayModCreatedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
