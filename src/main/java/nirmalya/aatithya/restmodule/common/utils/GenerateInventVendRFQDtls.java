package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;
 
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryRFQVendorDetailModel; 

public class GenerateInventVendRFQDtls {
	
	 
	
	/**
	 * add parameter set for inventory PurchaseOrder class
	 *
	 **/

public static String getRFQVendorDtlParam(List<RestInventoryRFQVendorDetailModel> RestInventoryRFQVendorDetailModel) {
	
	String s = "";
	String litem = "";
	 
	String quotId 	= "";
	String quotName 	= "";
	String quotValidity 	= "";
	
	String rfqNo 	= "";
	String vendor 	= ""; 
	String note 	= ""; 
	Double gstRate 	= 0.0; 
	Double IgstAmnt	= 0.0; 
	Double CgstAmnt	= 0.0; 
	Double SgstAmnt	= 0.0;  
	Double subtotalAmnt	= 0.0;  
	Double grandTotal	= 0.0; 
	Boolean taxType=false;
	String createdBy="";
	
	
	for(RestInventoryRFQVendorDetailModel m: RestInventoryRFQVendorDetailModel){
		rfqNo=m.getRfqNo();
		vendor 	= m.getVendor();
		note	= m.getqNote();
		gstRate = m.getGstRate();
		IgstAmnt=m.getqIGST();
		CgstAmnt=m.getqCGST();
		SgstAmnt=m.getqSGST();
		subtotalAmnt=m.getSubTotal();
		grandTotal=m.getGrandTotal(); 
		createdBy=m.getCreatedBy();
		taxType=m.getTaxType();
		quotId=m.getVenQuotId();
		quotName=m.getQuotName();
		quotValidity=DateFormatter.getStringDate(m.getQuotValidity()); 
	 
		
	} 
	
	s = s + "@p_rfqno='" + rfqNo + "',";
	s = s + "@p_quotId='" + quotId + "',";
	s = s + "@p_note='" + note + "',";
	s = s + "@p_vendor='" + vendor + "',";
	s = s + "@p_gstRate=" + gstRate + ",";
	s = s + "@p_igstAmnt=" + IgstAmnt + ",";
	s = s + "@p_cgstAmnt=" + CgstAmnt + ",";
	s = s + "@p_sgstAmnt=" + SgstAmnt + ",";
	s = s + "@p_subtotalAmnt=" + subtotalAmnt + ",";
	s = s + "@p_grandTotal=" + grandTotal + ",";
	s = s + "@p_created_by='" + createdBy + "',"; 
	s = s + "@p_taxType=" + taxType + ","; 
	s = s + "@p_quotName='" + quotName + "',"; 
	s = s + "@p_quotValidity='" + quotValidity + "',"; 
	
	
	if(quotId  != null) {
	//	System.out.println("hello i m ready for update-------------------------------------"+quotId);
		for (RestInventoryRFQVendorDetailModel m : RestInventoryRFQVendorDetailModel) {


			litem = litem + "(\""+m.getVenQuotId()+"\",\"" + m.getItemId() + "\",\"" + m.getQuantity() + "\",\""+m.getUnitPrice()+"\",\"" + m.getLineTotal() + "\"),";
			
		}
	}
	else {
		
		for (RestInventoryRFQVendorDetailModel m : RestInventoryRFQVendorDetailModel) {

			 
			litem = litem + "(@P_QuotNo,\"" + m.getItemId() + "\",\"" + m.getQuantity() + "\",\""+m.getUnitPrice()+"\",\"" + m.getLineTotal() + "\"),";

		}
	}
	
	
	/*if(quotId  != null) {
		System.out.println("hello i m ready for update-------------------------------------"+quotId);
		for (RestInventoryRFQVendorDetailModel m : RestInventoryRFQVendorDetailModel) {


			litem = litem + "(\""+m.getVenQuotId()+"\",\"" + m.getItemId() + "\",\"" + m.getQuantity() + "\",\""+m.getUnitPrice()+"\",\"" + m.getLineTotal() + "\"),";
			
		}
	}*/

 

	litem = litem.substring(0, litem.length() - 1);

	s = s + "@p_litemSubQuery='" + litem + "',";

	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}
	 
		

	 
 	System.out.println("generated param for Vendor RFQ ++++++++++++++++ :-"+s);
	
	return s;
}

}
