package nirmalya.aatithya.restmodule.common.utils;

import java.text.DecimalFormat;

import nirmalya.aatithya.restmodule.inventory.model.GRNListModel;

public class GenerateMultipleGRNParameter {

	public static String addInvoice(GRNListModel grn) {
		String s = "";
		String grnList = "";
		
		if(grn.getpOrder()!="" && grn.getpOrder()!=null) {
			s = s + "@p_pOrder='" + grn.getpOrder()+ "',";
		}
		if(grn.getInvNo()!="" && grn.getInvNo()!=null) {
			s = s + "@p_invNo='" + grn.getInvNo()+ "',";
		}
		if(grn.getInvDate()!="" && grn.getInvDate()!=null) {
			s = s + "@p_invDate='" + DateFormatter.getStringDate(grn.getInvDate())+ "',";
		}
		if(grn.getPayDueDate()!="" && grn.getPayDueDate()!=null) {
			s = s + "@p_dueDate='" + DateFormatter.getStringDate(grn.getPayDueDate())+ "',";
		}
		if(grn.getVendorId()!="" && grn.getVendorId()!=null) {
			s = s + "@p_vendorId='" + grn.getVendorId()+ "',";
		}
		if(grn.getStoreId()!="" && grn.getStoreId()!=null) {
			s = s + "@p_storeId='" + grn.getStoreId()+ "',";
		}
		if(grn.getGst()!=null) {
			s = s + "@p_gstRate=" + grn.getGst()+ ",";
		}
		if(grn.getAmount()!=null) {
			s = s + "@p_subTotal=" + grn.getAmount()+ ",";
		}
		if(grn.getTotalCGST()!=null) {
			s = s + "@p_cgst=" + grn.getTotalCGST()+ ",";
		}
		if(grn.getTotalIGST()!=null) {
			s = s + "@p_igst=" + grn.getTotalIGST()+ ",";
		}
		if(grn.getGstType()!=null) {
			s = s + "@p_gstType=" + grn.getGstType()+ ",";
		}
		if(grn.getGrandTotal()!=null) {
			s = s + "@p_grandTotal=" + Math.round(grn.getGrandTotal())+ ",";
		}
		DecimalFormat df = new DecimalFormat("#.##");
		if(grn.getCessAmount()!=null) {
			s = s + "@p_totalCess=" + df.format(grn.getCessAmount())+ ",";
		}
		if(grn.getCreatedBy()!="" && grn.getCreatedBy()!=null) {
			s = s + "@p_createdBy='" + grn.getCreatedBy()+ "',";
		}
		
		for(String m : grn.getGrnList()) {
			grnList = grnList + "\"" + m + "\",";
		}
		
		grnList = grnList.substring(0, grnList.length() - 1);
		
		s = s + "@p_grnList='" + "(" + grnList + ")" + "',";
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println(s);
		
		return s;
	}

}
