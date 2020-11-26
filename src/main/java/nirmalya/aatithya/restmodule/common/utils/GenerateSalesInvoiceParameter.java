package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.SalesInvoiceModel;

public class GenerateSalesInvoiceParameter {

	public static String addSalesInvoiceParam(List<SalesInvoiceModel> salesInvoice) {
		String s = "";
		String sItem = "";

		String salesOrderId = "";
		String purchaseOrder = "";
		String quotationId = "";
		String saleInvNote = "";
		Boolean gstType = null;
		Double gstRate = 0.0;
		Double subTotal = 0.0;
		Double sIGST = 0.0;
		Double sCGST = 0.0;
		Double sSGST = 0.0;
		Double grandTotal = 0.0;
		String createdBy = "";
		Boolean saleInvoiceType = null;
		Double payableAmt = 0.0;
		Double advAmt = 0.0;
		Double totalCess = 0.0;

		for (SalesInvoiceModel m : salesInvoice) {
			salesOrderId = m.getSalesOrderId();
			purchaseOrder = m.getPurchaseOrder();
			quotationId = m.getQuotationId();
			saleInvNote = m.getSaleInvNote();
			gstType = m.getGstType();
			gstRate = m.getGstRate();
			subTotal = m.getSubTotal();
			sIGST = m.getsIGST();
			sCGST = m.getsCGST();
			sSGST = m.getsSGST();
			grandTotal = m.getGrandTotal();
			createdBy = m.getCreatedBy();
			saleInvoiceType = m.getSaleInvoiceType();
			payableAmt = m.getPayableAmt();
			advAmt = m.getAdvanceAmt();
			totalCess = m.getTotalCess();
		}
		
		Double igst = 0.0;
		Double cgst = 0.0;

		s = s + "@p_salesOrderId='" + salesOrderId + "',";
		s = s + "@p_purchaseOrder='" + purchaseOrder + "',";
		s = s + "@p_quotationId='" + quotationId + "',";
		s = s + "@p_saleInvNote='" + saleInvNote + "',";
		s = s + "@p_gstType=" + gstType + ",";
		s = s + "@p_gstRate=" + 0 + ",";
		s = s + "@p_subTotal=" + subTotal + ",";
		s = s + "@p_sIGST=" + sIGST + ",";
		s = s + "@p_sCGST=" + sCGST + ",";
		s = s + "@p_sSGST=" + sSGST + ",";
		s = s + "@p_grandTotal=" + grandTotal + ",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_invoiceType=" + saleInvoiceType + ",";
		s = s + "@p_payableAmt=" + payableAmt + ",";
		s = s + "@p_advAmt=" + advAmt + ",";
		s = s + "@p_totalCess=" + totalCess + ",";

		for (SalesInvoiceModel m : salesInvoice) {
			
			if(gstType) {
				igst = (m.getSaleAmount() * m.getGstRate()) / 100;
			} else {
				cgst = (m.getSaleAmount() * m.getGstRate()) / 200;
			}
			
			sItem = sItem + "(@p_saleInvoice,\"" + m.getSaleItem() + "\",\"" + m.getSaleItemCode() + "\","
					+ m.getSalePrice() + "," + m.getSaleQuantity() + "," + m.getSaleDiscount() + "," + m.getGstRate()
					+ ",\"" + m.getsServeType() + "\"," + m.getSaleAmount() + "," + cgst + "," + cgst
					+ "," + igst + ",\"" + m.getCreatedBy() + "\","+m.getItemCess()+"),";
		}

		sItem = sItem.substring(0, sItem.length() - 1);

		s = s + "@p_sItemSubQuery='" + sItem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
