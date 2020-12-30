/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.BatchModel;
import nirmalya.aatithya.restmodule.inventory.model.InspectGoodsReceiveModel;
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryGoodsReceiveModel;
//import nirmalya.aatithya.restmodule.inventory.model.InventoryGoodsReceiveNoteModel;

/**
 * @author USER
 *
 */
public class GenerateInventoryGoodsReceiveInvoiceParameter {
	public static String getGoodsParam(List<RestInventoryGoodsReceiveModel> invGoodsReceiveModel) {
		String s = "";
		String litem = "";
		String aitem = "";

		String grnNumber = "";
		String invoicenumber = "";
		String purchaseorder = "";
		String description = "";
		Boolean status = null;
		String createdBy = "";
		Boolean gstType = null;
		Double gstRate = 0.0;
		Double gsubTotal = 0.0;
		Double discount = 0.0;
		Double sgst = 0.0;
		Double cgst = 0.0;
		Double igst = 0.0;
		Double grandTotal = 0.0;
		String vendorName = "";
		String invDate = "";
		String dueDate = "";
		String invImg = "";
		String vehicleNo = "";
		String driverName = "";
		String mobileNo = "";
		String godown = "";
		Double totalCess = 0.0;
		Double totalAdditionalCharges = 0.0;
		int i = 0;
		for (RestInventoryGoodsReceiveModel m : invGoodsReceiveModel) {
			i = i + 1;
			grnNumber = m.getgRNInvoiceId();
			invoicenumber = m.getgRnInvoiceNumber();
			purchaseorder = m.getgRNPurchaseOrderId();
			description = m.getgRnInvoiceDescription();
			status = m.getgRnInvoiceActive();
			createdBy = m.getCreatedBy();
			gstType = m.getGstType();
			gstRate = gstRate + m.getdGstRate();
			gsubTotal = m.getGsubTotal();
			discount = m.getDiscount();
			sgst = m.getSgst();
			cgst = m.getCgst();
			igst = m.getIgst();
			grandTotal = m.getGrandTotal();
			vendorName = m.getVendorName();
			if (m.getInvDate() != null && m.getInvDate() != "") {
				invDate = DateFormatter.getStringDate(m.getInvDate());
			}
			if (m.getDueDate() != null && m.getDueDate() != "") {
				dueDate = DateFormatter.getStringDate(m.getDueDate());
			}
			vehicleNo = m.getVehicleNo();
			driverName = m.getDriverName();
			mobileNo = m.getMobileNo();
			godown = m.getGodown();
			totalCess = m.getTotalCess();
			totalAdditionalCharges = m.getTotalAddCharges();
		}
		invImg = invGoodsReceiveModel.get(0).getInvImg();
		Double gstTotal = gstRate / i;
		s = s + "@p_grnNumber='" + grnNumber + "',";
		s = s + "@p_invoicenumber='" + invoicenumber + "',";
		s = s + "@p_purchaseorder='" + purchaseorder + "',";
		s = s + "@p_description='" + description + "',";
		s = s + "@p_status=" + status + ",";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_gstType=" + gstType + ",";
		s = s + "@p_gstRate=" + gstTotal + ",";
		s = s + "@p_gsubTotal=" + gsubTotal + ",";
		s = s + "@p_discount=" + discount + ",";
		s = s + "@p_sgst=" + sgst + ",";
		s = s + "@p_cgst=" + cgst + ",";
		s = s + "@p_igst=" + igst + ",";
		s = s + "@p_grandTotal=" + grandTotal + ",";
		s = s + "@p_vendorName='" + vendorName + "',";
		s = s + "@p_totalCess=" + totalCess + ",";
		s = s + "@p_totalAdditionalCharges=" + totalAdditionalCharges + ",";

		if (invDate != null && invDate != "") {
			s = s + "@p_invDate='" + invDate + "',";
		}

		if (dueDate != null && dueDate != "") {
			s = s + "@p_dueDate='" + dueDate + "',";
		}

		s = s + "@p_invImg='" + invImg + "',";
		s = s + "@p_vehicleNo='" + vehicleNo + "',";
		s = s + "@p_driverName='" + driverName + "',";
		s = s + "@p_mobileNo='" + mobileNo + "',";
		s = s + "@p_godown='" + godown + "',";
		for (RestInventoryGoodsReceiveModel m : invGoodsReceiveModel) {

			litem = litem + "(@p_gRNInvoiceId,\"" + m.getItmCategory() + "\",\"" + m.getItmSubCategory() + "\",\""
					+ m.getgRnInvoiceItmName() + "\",\"" + m.getgRnInvoiceQuantity() + "\"," + m.getdGstRate() + ","
					+ m.getPorder() + "," + m.getInvPrice() + "," + m.getgRnInvoiceQuantity() * m.getInvPrice() + "," + m.getCessAmount()  + "),";

		}

		litem = litem.substring(0, litem.length() - 1);
		
		if(invGoodsReceiveModel.get(0).getAddChargeDetails()!=null) {
			for (DropDownModel m : invGoodsReceiveModel.get(0).getAddChargeDetails()) {
				if(m.getKey()!=null && m.getKey()!="" && m.getName()!=null && m.getName()!="") {
					aitem = aitem + "(@p_gRNInvoiceId,\"" + m.getKey() + "\"," + m.getName() + "),";
				}
			}
			
			aitem = aitem.substring(0, aitem.length() - 1);
			s = s + "@p_addChargesSubQuery='" + aitem + "',";
		}
		
		s = s + "@p_litemSubQuery='" + litem + "',";
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;

	}

	public static String saveBatchDetails(List<BatchModel> batch) {
		String s = "";
		String litem = "";
		
		if(batch.get(0).getGrn()!=null && batch.get(0).getGrn()!="") {
			s = s + "@p_grnInvoice='" + batch.get(0).getGrn() + "',";
		}
		if(batch.get(0).getItemId()!=null && batch.get(0).getItemId()!="") {
			s = s + "@p_grnItem='" + batch.get(0).getItemId() + "',";
		}
		
		for(BatchModel m : batch) {
			litem = litem + "(@p_packetId,\"" + m.getPo() + "\",\"" + m.getGrn() + "\",\"" + m.getItemId() + "\",\""
					+ m.getBatchNo() + "\"," + m.getQty() + ",\"" + m.getMulSlNo() + "\", \"" + m.getCreatedBy() + "\"),";
		}
		litem = litem.substring(0, litem.length() - 1);
		s = s + "@p_batchSubQuery='" + litem + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}
	
	public static String saveInspectDetails(List<InspectGoodsReceiveModel> batch) {
		String s = "";
		String litem = "";
		
		if(batch.get(0).getGrn()!=null && batch.get(0).getGrn()!="") {
			s = s + "@p_grnInvoice='" + batch.get(0).getGrn() + "',";
		}
		if(batch.get(0).getPo()!=null && batch.get(0).getPo()!="") {
			s = s + "@p_po='" + batch.get(0).getPo() + "',";
		}
		if(batch.get(0).getItemId()!=null && batch.get(0).getItemId()!="") {
			s = s + "@p_grnItem='" + batch.get(0).getItemId() + "',";
		}
 
		for(InspectGoodsReceiveModel m : batch) {
			litem = litem + "\""+   m.getSequenceNo() + "\",";
		}
	
		litem = litem.substring(0, litem.length() - 1);
 
		s = s + "@p_sequence='" + litem + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

	
	public static String updateReturn(InspectGoodsReceiveModel batch) {
		String s = ""; 
		
		if(batch.getGrn()!=null && batch .getGrn()!="") {
			s = s + "@p_grnInvoice='" + batch .getGrn() + "',";
		}
		if(batch.getPo()!=null && batch .getPo()!="") {
			s = s + "@p_po='" + batch .getPo() + "',";
		}
		if(batch.getItemId()!=null && batch .getItemId()!="") {
			s = s + "@p_grnItem='" + batch .getItemId() + "',";
		}
		if(batch.getSequenceNo()!=null && batch .getSequenceNo()!="") {
			s = s + "@p_sequence='" + batch .getSequenceNo() + "',";
		}
		if(batch.getComment()!=null && batch .getComment()!="") {
			s = s + "@p_comment='" + batch .getComment() + "',";
		}
	 
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

}
