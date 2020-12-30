package nirmalya.aatithya.restmodule.common.utils;

import java.text.DecimalFormat;
import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.PaymentVoucherModel;

public class GenerateInventoryPaymentVoucherParam {

	public static String getPaymentVoucherParam(List<PaymentVoucherModel> paymentVoucherModel) {
		String s = "";
		String p = "";
		DecimalFormat df = new DecimalFormat("#.##");
		for (PaymentVoucherModel a : paymentVoucherModel) {
			s = s + "@p_vendorName='" + a.getVendorName() + "',";
			s = s + "@p_paymentMode='" + a.getPaymentMode() + "',";
			s = s + "@p_transNo='" + a.getTransNo() + "',";
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
			s = s + "@p_taxType=" + a.getTaxType() + ",";
			s = s + "@p_cgst='" + df.format(a.getCgst()) + "',";
			s = s + "@p_sgst='" + df.format(a.getSgst()) + "',";
			s = s + "@p_igst='" + df.format(a.getIgst()) + "',";
			s = s + "@p_subTotal='" + df.format(a.getSubTotal()) + "',";
			s = s + "@p_total='" + a.getTotal() + "',";
			s = s + "@p_cretaedBy='" + a.getCreatedBy() + "',";
			s = s + "@p_chequeNo='" + a.getChequeNo() + "',";
			s = s + "@p_tdsRate='" + a.getTdsRate() + "',";
			s = s + "@p_tdsAmount='" + df.format(a.getTdsAmount()) + "',";
			s = s + "@p_cessAmount='" + df.format(a.getCessAmt()) + "',";
			s = s + "@p_grnNo='" + a.getGrnNo() + "',";
			s = s + "@p_paymentType=" + a.getPaymentType() + ",";
			if (a.getPaymentType()) {
				s = s + "@p_partialAmount='" + a.getTotal() + "',";
			} else {
				s = s + "@p_partialAmount='" + a.getPartialAmt() + "',";
			}

		}
		p = "(\"";
		for (PaymentVoucherModel a : paymentVoucherModel) {
			p = p + a.getGrnNo() + "\",\"";
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
