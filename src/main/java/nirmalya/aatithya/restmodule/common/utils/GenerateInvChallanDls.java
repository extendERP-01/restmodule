package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.RestSalesDeliveryChallanModel;

public class GenerateInvChallanDls {

	/**
	 * add parameter set for sales Challan
	 *
	 **/

	public static String getChallnDtlParam(List<RestSalesDeliveryChallanModel> RestSalesDeliveryChallanModel) {

		String s = "";
		String litem = "";

		String challanDate = "";
		String saleOrderNo = "";
		String challanNo = "";
		String customerId = "";
		String note = "";
		Double gstRate = 0.0;
		Double IgstAmnt = 0.0;
		Double CgstAmnt = 0.0;
		Double SgstAmnt = 0.0;
		Double subtotalAmnt = 0.0;
		Double grandTotal = 0.0;
		Boolean taxType = false;
		String createdBy = "";
		Double advanceAmnt = 0.0;
		Double remainAmnt = 0.0;
		String invoiceNo = "";
		for (RestSalesDeliveryChallanModel m : RestSalesDeliveryChallanModel) {
			challanNo = m.getDelChallanId();
			customerId = m.getCustomerId();
			note = m.getqNote();
			gstRate = m.getGstRate();
			IgstAmnt = m.getqIGST();
			CgstAmnt = m.getqCGST();
			SgstAmnt = m.getqSGST();
			subtotalAmnt = m.getSubTotal();
			grandTotal = m.getGrandTotal();
			createdBy = m.getCreatedBy();
			taxType = m.getTaxType();
			challanDate = DateFormatter.getStringDate(m.getDelChallanDate());
			saleOrderNo = m.getSaleOrderNo();
			advanceAmnt = m.getAdvanceAmnt();
			remainAmnt = m.getRemainAmnt();

			 invoiceNo = m.getInvoiceNo(); 
			if (IgstAmnt == null) {
				IgstAmnt = 0.00;
			}

			if (CgstAmnt == null) {
				CgstAmnt = 0.00;
			}

			if (SgstAmnt == null) {
				SgstAmnt = 0.00;
			}

		}

		s = s + "@p_challanNo='" + challanNo + "',";
		s = s + "@p_saleOrderNo='" + saleOrderNo + "',";
		s = s + "@p_customerId='" + customerId + "',";
		s = s + "@p_challanDate='" + challanDate + "',";
		s = s + "@p_gstRate=" + gstRate + ",";
		s = s + "@p_igstAmnt=" + IgstAmnt + ",";
		s = s + "@p_cgstAmnt=" + CgstAmnt + ",";
		s = s + "@p_sgstAmnt=" + SgstAmnt + ",";
		s = s + "@p_advanceAmnt=" + advanceAmnt + ",";
		s = s + "@p_remainAmnt=" + remainAmnt + ",";
		s = s + "@p_subtotalAmnt=" + subtotalAmnt + ",";
		s = s + "@p_grandTotal=" + grandTotal + ",";
		s = s + "@p_note='" + note + "',";
		s = s + "@p_created_by='" + createdBy + "',";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_invoiceNo='" + invoiceNo + "',";

		String serveType = "st003";

		for (RestSalesDeliveryChallanModel m : RestSalesDeliveryChallanModel) {

			litem = litem + "(@p_invoiceNo,\"" + m.getItemName() + "\",\"" + m.getItemId() + "\",\"" + m.getUnitPrice()
					+ "\",\"" + m.getQuantity() + "\",\"" + m.getItemWt() + "\",\"" + m.getLineTotal() + "\",\"" + serveType + "\",\""
					+ m.getCreatedBy() + "\"),";

		}

		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("generated param for Purchase Order With RFQ ++++++++++++++++ :-" + s);

		return s;
	}

	public static String getSearchParam(DataTableRequest request) {

		String s = "";
		Integer approved = 2;
		Integer pending = 1;
		String param2 = request.getParam2();
		/*
		 * String s = ""; Integer approved = 2; Integer pending = 1;
		 * 
		 * String param2 = request.getParam2();
		 * 
		 * if(param2 != null ) { if(param2 == "2") { s = s + "@p_param2=" + approved +
		 * ","; }else { s = s + "@p_param2=" + pending + ","; }
		 * 
		 * }
		 */

		if (request.getStart() != null) {
			s = s + "@p_start=" + request.getStart() + ",";
		}

		if (request.getLength() != null) {
			s = s + "@p_length=" + request.getLength() + ",";
		}

		if (request.getSearch() != null) {
			s = s + "@p_search='" + request.getSearch() + "',";
		}

		if (request.getParam1() != null) {
			s = s + "@p_param1='" + request.getParam1() + "',";
		}

	 

		if (param2 != null) {
			if (param2 == "2") {
				s = s + "@p_param2=" + approved + ",";
			} else {
				s = s + "@p_param2=" + pending + ",";
			}

		}

		if (request.getParam3() != null) {
			s = s + "@p_param3='" + request.getParam3() + "',";
		}

		if (request.getParam4() != null) {
			s = s + "@p_param4='" + request.getParam4() + "',";
		}

		/*
		 * if (!request.getParam3().contentEquals("")) { System.out.println("here1");
		 * String frmDate = DateFormatter.getStringDate(request.getParam3()); s = s +
		 * "@p_param4='" + frmDate + "',"; //request.setParam3(frmDate); } if
		 * (!request.getParam4().contentEquals("") ) { System.out.println("here2");
		 * String tDate = DateFormatter.getStringDate(request.getParam4()); s = s +
		 * "@p_param3='" + tDate + "',"; //request.setParam4(tDate); }
		 */

		if (request.getParam5() != null) {
			s = s + "@p_param5='" + request.getParam5() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("param  : " + s);

		return s;
	}

}
