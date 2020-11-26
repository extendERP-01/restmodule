package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;
import java.util.Map;

import nirmalya.aatithya.restmodule.inventory.model.InventoryGoodsReturnsNoteModel;

/**
 * @author Nirmalya Labs
 *
 */

public class GenerateInventoryGoodsReturnParameter {

	public static String getGoodsreturnDtlParam(List<InventoryGoodsReturnsNoteModel> inventoryGoodsReturnsNoteModel) {
		String s = "";
		String litem = "";
		String goodsReturn = "";
		String gRtNInvNo = "";
		String purchaseOrder = "";
		String gRtNDescription = "";
		String gRDtlsCreatedBy = "";
		Boolean gstType = null;
		Double gsubTotal = 0.0;
		Double discount = 0.0;
		Double sgst = 0.0;
		Double cgst = 0.0;
		Double igst = 0.0;
		Double cess = 0.0;
		Double grandTotal = 0.0;

		Boolean gRtNActive = null;
		for (InventoryGoodsReturnsNoteModel m : inventoryGoodsReturnsNoteModel) {
			goodsReturn = m.getGoodsReturnNote();
			gRtNInvNo = m.getgRNInvoiceId();
			purchaseOrder = m.getPurchaseOrder();
			gRtNDescription = m.getgRtNDescription();
			gRtNActive = m.getgRtNActive();
			gRDtlsCreatedBy = m.getgRDtlsCreatedBy();
			gstType = m.getGstType();
//			gstRate = m.getGstRate();
			gsubTotal = m.getGsubTotal();
			discount = m.getDiscount();
			cess = m.getTotalCess();
			if(m.getGstType()) {
				
				igst = m.getIgst();
			}else {			
				cgst = m.getCgst();
				sgst = m.getSgst();
			}
			grandTotal = m.getGrandTotal();

		}
		s = s + "@p_goodsReturn='" + goodsReturn + "',";
		s = s + "@p_gRtNInvNo='" + gRtNInvNo + "',";
		s = s + "@p_purchaseOrder='" + purchaseOrder + "',";
		s = s + "@p_gRtNDescription='" + gRtNDescription + "',";
		s = s + "@p_gRtNActive=" + gRtNActive + ",";
		s = s + "@p_gRDtlsCreatedBy='" + gRDtlsCreatedBy + "',";
		s = s + "@p_gstType=" + gstType + ",";
//		s = s + "@p_gstRate=" + gstRate + ",";
		s = s + "@p_gsubTotal=" + gsubTotal + ",";
		s = s + "@p_discount=" + discount + ",";
		s = s + "@p_sgst=" + sgst + ",";
		s = s + "@p_cgst=" + cgst + ",";
		s = s + "@p_igst=" + igst + ",";
		s = s + "@p_grandTotal=" + grandTotal + ",";
		s = s + "@p_totalCess=" + cess + ",";

		for (InventoryGoodsReturnsNoteModel m : inventoryGoodsReturnsNoteModel) {

			litem = litem + "(@p_goodsReturnNote,\"" + m.getItemCategory() + "\",\"" + m.getItemSubCategory() + "\",\""
					+ m.getItemName() + "\"," + m.getgRtNQty() + "," + m.getPrice() + "," + m.getLineTotal() + "," + m.getGstRate() + "," + m.getCessAmount() + "),";

		}

		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	public static String getCalculateInventoryItemPriceParam(Map<String, String> servicePrice) {
		String sqlParam = "";

		if ( servicePrice.get("itemId") != null && servicePrice.get("itemId") != "") {
			sqlParam = sqlParam + "@p_serviceUserTypeId='" + servicePrice.get("gRNInvoiceId") + "',";

			sqlParam = sqlParam + "@p_lItemId='" + servicePrice.get("itemId") + "',";
		}

		if (sqlParam != "") {
			sqlParam = sqlParam.substring(0, sqlParam.length() - 1);

			sqlParam = "SET " + sqlParam + ";";
		}
		return sqlParam;
	}

}
