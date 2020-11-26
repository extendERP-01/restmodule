package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.SaleInvoiceReturnModel;

public class GenerateSalesInvoiceReturnParameter {

	@SuppressWarnings("unused")
	public static String addSalesInvoiceReturnParam(List<SaleInvoiceReturnModel> salesInvoiceReturn) {
		String s = "";
		String sItem = "";
		
		String salesOrderId 		= "";
		String saleInvId 			= "";
		String saleInvReturnDesc 	= "";
		Boolean gstType 			= null;
		Double gstRate 				= 0.0;
		Double subTotal 			= 0.0;
		Double sRIGST 				= 0.0;
		Double sRCGST 				= 0.0;
		Double sRSGST 				= 0.0;
		Double grandTotal 			= 0.0;
		Double totalCess 			= 0.0;
		String createdBy 			= "";
		String costCenter 			= "";
		
		for(SaleInvoiceReturnModel m: salesInvoiceReturn){
			salesOrderId = m.getSalesOrderId();
			saleInvId = m.getSaleInvId();
			saleInvReturnDesc = m.getSaleInvReturnDesc();
			gstType = m.getGstType();
			gstRate = m.getGstRate();
			subTotal = m.getSubTotal();
			sRIGST = m.getsRIGST();
			sRCGST = m.getsRCGST();
			sRSGST = m.getsRSGST();
			grandTotal = m.getGrandTotal();
			createdBy = m.getCreatedBy();
			costCenter = m.getCostCenter();
			totalCess = m.getTotalCess();
		}
		
		s = s + "@p_salesOrderId='" + salesOrderId + "',";
		s = s + "@p_saleInvId='" + saleInvId + "',";
		s = s + "@p_saleInvReturnDesc='" + saleInvReturnDesc + "',";
		s = s + "@p_gstType=" + gstType + ",";
		s = s + "@p_gstRate=" + 0 + ",";
		s = s + "@p_subTotal=" + subTotal + ",";
		s = s + "@p_sRSGST=" + sRSGST + ",";
		s = s + "@p_sRCGST=" + sRCGST + ",";
		s = s + "@p_sRIGST=" + sRIGST + ",";
		s = s + "@p_grandTotal=" + grandTotal + ",";
		s = s + "@p_totalCess=" + totalCess + ",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_costCenter='" + costCenter + "',";
		Double cgst = 0.0;
		Double igst = 0.0;
		for(SaleInvoiceReturnModel m: salesInvoiceReturn){
			if(gstType) {
				igst = (m.getsRAmount()*m.getGstRate())/100;
			} else {
				cgst = (m.getsRAmount()*m.getGstRate())/200;
			}
			sItem = sItem +"(@p_saleInvReturn,\""+m.getsRItemName()+"\",\""+m.getsRItemCode()+"\","+m.getsRItemPrice()+","+m.getsRItemQty() +","+m.getsRDiscount() +","+m.getGstRate()+",\""+m.getsRServeTypeId()+"\","+m.getsRAmount()+","+cgst+","+cgst+","+igst+","+m.getItemCess()+"),";	
		}
		
		sItem = sItem.substring(0, sItem.length() - 1);
		
		s = s + "@p_sItemSubQuery='" + sItem + "',";
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println(s);
		
		return s;
	}

}
