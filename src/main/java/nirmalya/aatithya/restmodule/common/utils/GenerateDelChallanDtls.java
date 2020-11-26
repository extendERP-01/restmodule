package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.RestSalesDeliveryChallanModel;

public class GenerateDelChallanDtls {

	/**
	 * add parameter set for delivery Challan sales
	 *
	 **/

	public static String getSalesChallanDtlParam(List<RestSalesDeliveryChallanModel> RestSalesDeliveryChallanModel) throws Exception {
		System.out.println("object data are " + RestSalesDeliveryChallanModel);
		String s = "";
		String litem = "";
		String saleInvItem = "";
		String delChallanId = "";
		String salesOderNo = "";
		String customerId = "";
		String customerName = "";
		String toPlace = "";
		String fromPlace = "";
		String delChallanDate = "";
		String transName = "";
		String transMobileNo = "";
		String transVehicle = "";
		String note = "";
		Double gstRate = 0.0;
		Double subtotalAmnt = 0.0;
		Double grandTotal = 0.0;
		Boolean taxType = false;
		String createdBy = "";
		Double advanceAmount = 0.0;
		Double remainAmnt = 0.0;
		Double totalCess = 0.0;

		for (RestSalesDeliveryChallanModel m : RestSalesDeliveryChallanModel) {
			delChallanId = m.getDelChallanId();
			salesOderNo = m.getSaleOrderNo();
			customerId = m.getCustomerId();
			customerName = m.getCustomerName();
			toPlace = m.getToPlace();
			fromPlace = m.getFromPlace();
			delChallanDate = DateFormatter.getStringDate(m.getDelChallanDate());
			transName = m.getTransName();
			transMobileNo = m.getTransMoNo();
			transVehicle = m.getTransVehNo();
			note = m.getqNote();
			gstRate = m.getGstRate();
			//subtotalAmnt = m.getSubTotal();
			//grandTotal = m.getGrandTotal();
			createdBy = m.getCreatedBy();
			taxType = m.getTaxType();
			totalCess = m.getTotalCess();
			/*
			 * if(m.getAdvanceAmnt()!=null) { advanceAmount = m.getAdvanceAmnt(); }
			 * remainAmnt = grandTotal - advanceAmount;
			 */

		}

		s = s + "@p_storeId='" + RestSalesDeliveryChallanModel.get(0).getStoreId() + "',";
		s = s + "@p_delChallanId='" + delChallanId + "',";
		s = s + "@p_salesOderNo='" + salesOderNo + "',";
		s = s + "@p_note='" + note + "',";
		s = s + "@p_customerId='" + customerId + "',";
		s = s + "@p_customerName='" + customerName + "',";
		s = s + "@p_toPlace='" + toPlace + "',";
		s = s + "@p_fromPlace='" + fromPlace + "',";
		s = s + "@p_delChallanDate='" + delChallanDate + "',";
		s = s + "@p_transName='" + transName + "',";
		s = s + "@p_transMobileNo='" + transMobileNo + "',";
		s = s + "@p_transVehicle='" + transVehicle + "',";
		s = s + "@p_gstRate=" + gstRate + ",";
		s = s + "@p_igstAmnt=" + RestSalesDeliveryChallanModel.get(0).getTotalIgst() + ",";
		s = s + "@p_cgstAmnt=" + RestSalesDeliveryChallanModel.get(0).getTotalCgst() + ",";
		s = s + "@p_sgstAmnt=" + RestSalesDeliveryChallanModel.get(0).getTotalSgst() + ",";
		s = s + "@p_advanceAmount=" + RestSalesDeliveryChallanModel.get(0).getAdvanceAmnt() + ",";
		s = s + "@p_subtotalAmnt=" + RestSalesDeliveryChallanModel.get(0).getSubTotal() + ",";
		s = s + "@p_remainAmnt=" + RestSalesDeliveryChallanModel.get(0).getRemainAmnt() + ",";
		s = s + "@p_grandTotal=" + RestSalesDeliveryChallanModel.get(0).getGrandTotal() + ",";
		s = s + "@p_created_by='" + createdBy + "',";
		s = s + "@p_taxType=" + taxType + ",";
		s = s + "@p_totalCess=" + totalCess + ",";

		for (RestSalesDeliveryChallanModel m : RestSalesDeliveryChallanModel) {

			litem = litem + "(@p_ChallanId,@p_salesOderNo,\"" + m.getItemId() + "\",\"" + m.getUnitPrice() + "\",\""
					+ m.getQuantity() + "\",\"" + m.getLineTotal() + "\",\"" + m.getGstRate() + "\",\"" + m.getqIGST()
					+ "\",\"" + m.getqCGST() + "\",\"" + m.getqSGST() + "\","+m.getItemCess()+","+m.getItemDiscount()+"),";

		}

		for (RestSalesDeliveryChallanModel m : RestSalesDeliveryChallanModel) {

			saleInvItem = saleInvItem + "(@p_salesInvoice,\"" + m.getItemName() + "\",\"" + m.getItemId() + "\",\""
					+ m.getUnitPrice() + "\",\"" + m.getQuantity() + "\",\"" + m.getItemDiscount() + "\",\""
					+ m.getGstRate() + "\",\"" + m.getqSGST() + "\",\"" + m.getqCGST() + "\",\"" + m.getqIGST()
					+ "\",\"st005\",\"" + m.getLineTotal() + "\","+m.getItemCess()+"),";

		}

		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		saleInvItem = saleInvItem.substring(0, saleInvItem.length() - 1);

		s = s + "@p_invSubQuery='" + saleInvItem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("generated param for Delivery Challan SalesOrderNo --------------- :-" + s);

		return s;
	}

}
