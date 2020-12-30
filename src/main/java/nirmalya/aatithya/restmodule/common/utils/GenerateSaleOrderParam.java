package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.SalesSaleOrderModel;

public class GenerateSaleOrderParam {

	@SuppressWarnings("unused")
	public static String addSaleOrderParam(List<SalesSaleOrderModel> quotation) {

		String s = "";
		String qItem = "";
		String customerId = "";
		String qDescription = "";
		String quotationVDate = null;
		String qNote = "";
		String quationId = "";
		Boolean qStatus = null;
		Double gstRate = 0.0;
		Boolean taxType = null;
		String createdBy = "";
		Double subTotal = 0.0;
		Double qIGST = 0.0;
		Double qCGST = 0.0;
		Double qSGST = 0.0;
		Double grandTotal = 0.0;
		Double totalCess = 0.0;

		for (SalesSaleOrderModel m : quotation) {
			customerId = m.getCustomerId();
			qDescription = m.getqDescription();
			if(m.getQuotationVDate()!=null && m.getQuotationVDate()!="") {
				quotationVDate = DateFormatter.getStringDate(m.getQuotationVDate());
			}
			qNote = m.getqNote();
			qStatus = m.getqStatus();
			gstRate = m.getGstRate();
			taxType = m.getTaxType();
			createdBy = m.getCreatedBy();
			subTotal = m.getSubTotal();
			qIGST = m.getqIGST();
			qCGST = m.getqCGST();
			qSGST = m.getqSGST();
			totalCess = m.getTotalCess();
			grandTotal = m.getGrandTotal();
			if (m.getQuationId() != null) {
				quationId = m.getQuationId();
			}
		}

		s = s + "@p_customerId='" + customerId + "',";
		s = s + "@p_qDescription='" + qDescription + "',";
		s = s + "@p_quotationVDate='" + quotationVDate + "',";
		s = s + "@p_qNote='" + qNote + "',";
		s = s + "@p_qStatus=" + qStatus + ",";
		s = s + "@p_gstRate=" + 0.00 + ",";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_subTotal=" + subTotal + ",";
		s = s + "@p_qIGST=" + qIGST + ",";
		s = s + "@p_qCGST=" + qCGST + ",";
		s = s + "@p_qSGST=" + qSGST + ",";
		s = s + "@p_totalCess=" + totalCess + ",";
		s = s + "@p_grandTotal=" + grandTotal + ",";
		s = s + "@p_advAmount=" + quotation.get(0).getAdvAmount() + ",";
		s = s + "@p_paymentMode='" + quotation.get(0).getPayMode() + "',";
		s = s + "@p_transNo='" + quotation.get(0).getTransId() + "',";
		s = s + "@p_posNo='" + quotation.get(0).getPosNumber() + "',";
		s = s + "@p_storeId='" + quotation.get(0).getStoreId() + "',";
		s = s + "@p_salesOrder='" + quotation.get(0).getSalesOrder() + "',";
		if(quotation.get(0).getOrderReceiveDate()!=null && quotation.get(0).getOrderReceiveDate()!="") {
			s = s + "@p_orderRcvDate='" + DateFormatter.getStringDate(quotation.get(0).getOrderReceiveDate()) + "',";
		}
		s = s + "@p_orderRcvTime='" +  quotation.get(0).getOrderReceiveTime() + "',";

		s = s + "@p_quotationId='" + quationId + "',";

		for (SalesSaleOrderModel m : quotation) {
			qItem = qItem + "(@p_quotationId,\"" + m.getItemName() + "\",\"" + m.getItemCode() + "\","
					+ m.getUnitPrice() + "," + m.getQuantity() + "," + m.getDiscount() + ",\"" + m.getqServeType()
					+ "\"," + m.getItemGST() + "," + m.getLineTotal() + "," + m.getItemCGST() + "," + m.getItemSGST()
					+ "," + m.getItemIGST() + ",\"" + m.getCreatedBy() + "\","+ m.getItemCess() +"),";
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
