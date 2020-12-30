package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.QuotationMasterModel;
import nirmalya.aatithya.restmodule.sales.model.SalesSaleOrderModel;

public class GenerateSalesQuotationParameter {

	public static String addQuotationParam(List< QuotationMasterModel> quotation) {
		
		String s = "";
		String qItem = "";

		String quotationName = "";
		String customerId = "";
		String qDescription = "";
		String quotationVDate = "";
		String qNote = "";
		Boolean qStatus = null;
		Double gstRate = 0.0;
		Boolean taxType = null;
		String createdBy = "";
		Double subTotal = 0.0;
		Double qIGST = 0.0;
		Double qCGST = 0.0;
		Double qSGST = 0.0;
		Double grandTotal = 0.0;

		for (QuotationMasterModel m : quotation) {
			quotationName = m.getQuotationName();
			customerId = m.getCustomerId();
			qDescription = m.getqDescription();
			quotationVDate = DateFormatter.getStringDate(m.getQuotationVDate());
			qNote = m.getqNote();
			qStatus = m.getqStatus();
			gstRate = m.getGstRate();
			taxType = m.getTaxType();
			createdBy = m.getCreatedBy();
			subTotal = m.getSubTotal();
			qIGST = m.getqIGST();
			qCGST = m.getqCGST();
			qSGST = m.getqSGST();
			grandTotal = m.getGrandTotal();
		}

		s = s + "@p_quotationName='" + quotationName + "',";
		s = s + "@p_customerId='" + customerId + "',";
		s = s + "@p_qDescription='" + qDescription + "',";
		s = s + "@p_quotationVDate='" + quotationVDate + "',";
		s = s + "@p_qNote='" + qNote + "',";
		s = s + "@p_qStatus=" + qStatus + ",";
		s = s + "@p_gstRate=" + 0 + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_subTotal=" + subTotal + ",";
		s = s + "@p_qIGST=" + qIGST + ",";
		s = s + "@p_qCGST=" + qCGST + ",";
		s = s + "@p_qSGST=" + qSGST + ",";
		s = s + "@p_grandTotal=" + grandTotal + ",";

		for (QuotationMasterModel m : quotation) {
			qItem = qItem + "(@p_quotationId,\"" + m.getItemName() + "\",\"" + m.getItemCode() + "\","
					+ m.getUnitPrice() + "," + m.getQuantity() + "," + m.getDiscount() + ",\"" + m.getqServeType()
					+ "\"," + m.getItemGST() + "," + m.getLineTotal() + "," + m.getItemCGST() + "," + m.getItemSGST()
					+ "," + m.getItemIGST() + ",\"" + m.getCreatedBy() + "\"),";
		}

		qItem = qItem.substring(0, qItem.length() - 1);

		s = s + "@p_qItemSubQuery='" + qItem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
