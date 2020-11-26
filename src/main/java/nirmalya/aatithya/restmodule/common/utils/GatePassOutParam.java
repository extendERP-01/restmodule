package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.gatepass.model.GatePassOutModel; 

public class GatePassOutParam {
	/*
	 * public static String gateOut(List<OutGatePassModel> gateOut) { String s = "";
	 * String gPass = "";
	 * 
	 * if (gateOut.get(0).getpOrder() != "" && gateOut.get(0).getpOrder() != null) {
	 * s = s + "@p_pOrder='" + gateOut.get(0).getpOrder() + "',"; } if
	 * (gateOut.get(0).getGrn() != "" && gateOut.get(0).getGrn() != null) { s = s +
	 * "@p_grn='" + gateOut.get(0).getGrn() + "',"; } if
	 * (gateOut.get(0).getWeightType() != null) { s = s + "@p_weightType=" +
	 * gateOut.get(0).getWeightType() + ","; } if (gateOut.get(0).getRefGatePassNo()
	 * != "" && gateOut.get(0).getRefGatePassNo() != null) { s = s +
	 * "@p_refgateOutNo='" + gateOut.get(0).getRefGatePassNo() + "',"; } if
	 * (gateOut.get(0).getGatePassOut() != "" && gateOut.get(0).getGatePassOut() !=
	 * null) { s = s + "@p_gateOut='" + gateOut.get(0).getGatePassOut() + "',"; } if
	 * (gateOut.get(0).getStore() != "" && gateOut.get(0).getStore() != null) { s =
	 * s + "@p_store='" + gateOut.get(0).getStore() + "',"; } if
	 * (gateOut.get(0).getPassType() != null) { s = s + "@p_passType=" +
	 * gateOut.get(0).getPassType() + ","; } if (gateOut.get(0).getVendor() != "" &&
	 * gateOut.get(0).getVendor() != null) { s = s + "@p_vendor='" +
	 * gateOut.get(0).getVendor() + "',"; } if (gateOut.get(0).getChallanNo() != ""
	 * && gateOut.get(0).getChallanNo() != null) { s = s + "@p_challanNo='" +
	 * gateOut.get(0).getChallanNo() + "',"; } if (gateOut.get(0).getVehicleNo() !=
	 * "" && gateOut.get(0).getVehicleNo() != null) { s = s + "@p_vehicleNo='" +
	 * gateOut.get(0).getVehicleNo() + "',"; } if (gateOut.get(0).getRstNo() != ""
	 * && gateOut.get(0).getRstNo() != null) { s = s + "@p_rstNo='" +
	 * gateOut.get(0).getRstNo() + "',"; } if (gateOut.get(0).getDriverName() != ""
	 * && gateOut.get(0).getDriverName() != null) { s = s + "@p_driverName='" +
	 * gateOut.get(0).getDriverName() + "',"; } if (gateOut.get(0).getRunningKM() !=
	 * null) { s = s + "@p_runningKM=" + gateOut.get(0).getRunningKM() + ","; } if
	 * (gateOut.get(0).getFrontHR() != null) { s = s + "@p_frontHR=" +
	 * gateOut.get(0).getFrontHR() + ","; } if (gateOut.get(0).getBackHR() != null)
	 * { s = s + "@p_backHR=" + gateOut.get(0).getBackHR() + ","; } if
	 * (gateOut.get(0).getGross() != null) { s = s + "@p_gross=" +
	 * gateOut.get(0).getGross() + ","; } if (gateOut.get(0).getTare() != null) { s
	 * = s + "@p_tare=" + gateOut.get(0).getTare() + ","; } if
	 * (gateOut.get(0).getOutDate() != null) { s = s + "@p_outDate='" +
	 * DateFormatter.getStringDate(gateOut.get(0).getOutDate()) + "',"; } if
	 * (gateOut.get(0).getReturnDate() != null && gateOut.get(0).getReturnDate() !=
	 * "") { s = s + "@p_returnDate='" +
	 * DateFormatter.getStringDate(gateOut.get(0).getReturnDate()) + "',"; } if
	 * (gateOut.get(0).getOutTime() != null) { s = s + "@p_outTime='" +
	 * gateOut.get(0).getOutTime() + "',"; } if (gateOut.get(0).getReturnTime() !=
	 * null) { s = s + "@p_returnTime='" + gateOut.get(0).getReturnTime() + "',"; }
	 * 
	 * if (gateOut.get(0).getRemarks() != "" && gateOut.get(0).getRemarks() != null)
	 * { s = s + "@p_remarks='" + gateOut.get(0).getRemarks() + "',"; } if
	 * (gateOut.get(0).getCreatedBy() != "" && gateOut.get(0).getCreatedBy() !=
	 * null) { s = s + "@p_createdBy='" + gateOut.get(0).getCreatedBy() + "',"; }
	 * 
	 * if (gateOut.get(0).getIsSupplyByClient() != null) { s = s + "@p_isSupply=" +
	 * gateOut.get(0).getIsSupplyByClient() + ","; } if
	 * (gateOut.get(0).getQtyInBags() != null) { s = s + "@p_qtyInBags=" +
	 * gateOut.get(0).getQtyInBags() + ","; } if (gateOut.get(0).getCustomerId() !=
	 * "" && gateOut.get(0).getCustomerId() != null) { s = s + "@p_customer='" +
	 * gateOut.get(0).getCustomerId() + "',"; }
	 * 
	 * if(gateOut.get(0).getVehicleNo().contentEquals("OTH123")) {
	 * if(gateOut.get(0).getOtherDriverName()!="" &&
	 * gateOut.get(0).getOtherDriverName()!=null) { s = s + "@p_otherDriver='" +
	 * gateOut.get(0).getOtherDriverName()+ "',"; }
	 * if(gateOut.get(0).getOtherVehicleNo()!="" &&
	 * gateOut.get(0).getOtherVehicleNo()!=null) { s = s + "@p_otherVehicle='" +
	 * gateOut.get(0).getOtherVehicleNo()+ "',"; } }
	 * 
	 * for (OutGatePassModel m : gateOut) { gPass = gPass + "(@p_gateOut,\"" +
	 * m.getItemCategory() + "\",\"" + m.getSubCategory() + "\",\"" +
	 * m.getItemCode() + "\"," + m.getClientNetQty() + "," + m.getActualNetQty() +
	 * ",\"" + m.getServeTypeId() + "\"),"; }
	 * 
	 * gPass = gPass.substring(0, gPass.length() - 1);
	 * 
	 * s = s + "@p_gPassSubQuery='" + gPass + "',";
	 * 
	 * if (s != "") { s = s.substring(0, s.length() - 1);
	 * 
	 * s = "SET " + s + ";"; }
	 * 
	 * System.out.println(s);
	 * 
	 * return s; }
	 */

	public static String addGateOut(List<GatePassOutModel> gatePass) {
		String s = "";
		String gPass = "";
		
		if (gatePass.get(0).getWeightType() != null) {
			s = s + "@p_weightType=" + gatePass.get(0).getWeightType() + ",";
		}
		if (gatePass.get(0).getRefGatePassNo() != "" && gatePass.get(0).getRefGatePassNo() != null) {
			s = s + "@p_refgateOutNo='" + gatePass.get(0).getRefGatePassNo() + "',";
		}
		if (gatePass.get(0).getGatePassOut() != "" && gatePass.get(0).getGatePassOut() != null) {
			s = s + "@p_gateOut='" + gatePass.get(0).getGatePassOut() + "',";
		}
		if (gatePass.get(0).getStore() != "" && gatePass.get(0).getStore() != null) {
			s = s + "@p_store='" + gatePass.get(0).getStore() + "',";
		}
		if (gatePass.get(0).getPassType() != null) {
			s = s + "@p_passType=" + gatePass.get(0).getPassType() + ",";
		}
		if (gatePass.get(0).getDelChallanId() != "" && gatePass.get(0).getDelChallanId() != null) {
			s = s + "@p_challanId='" + gatePass.get(0).getDelChallanId() + "',";
		}
		if (gatePass.get(0).getVehicleNo() != "" && gatePass.get(0).getVehicleNo() != null) {
			s = s + "@p_vehicleNo='" + gatePass.get(0).getVehicleNo() + "',";
		}
		if (gatePass.get(0).getRstNo() != "" && gatePass.get(0).getRstNo() != null) {
			s = s + "@p_rstNo='" + gatePass.get(0).getRstNo() + "',";
		}
		if (gatePass.get(0).getDriverName() != "" && gatePass.get(0).getDriverName() != null) {
			s = s + "@p_driverName='" + gatePass.get(0).getDriverName() + "',";
		}
		if (gatePass.get(0).getGross() != null) {
			s = s + "@p_gross=" + gatePass.get(0).getGross() + ",";
		}
		if (gatePass.get(0).getTare() != null) {
			s = s + "@p_tare=" + gatePass.get(0).getTare() + ",";
		}
		if (gatePass.get(0).getOutDate() != null) {
			s = s + "@p_outDate='" + DateFormatter.getStringDate(gatePass.get(0).getOutDate()) + "',";
		}
//		if (gatePass.get(0).gatePass() != null && gatePass.get(0).getReturnDate() != "") {
//			s = s + "@p_returnDate='" + DateFormatter.getStringDate(gatePass.get(0).getReturnDate()) + "',";
//		}
		if (gatePass.get(0).getOutTime() != null) {
			s = s + "@p_outTime='" + gatePass.get(0).getOutTime() + "',";
		}
//		if (gatePass.get(0).getReturnTime() != null) {
//			s = s + "@p_returnTime='" + gatePass.get(0).getReturnTime() + "',";
//		}
		if (gatePass.get(0).getRemarks() != "" && gatePass.get(0).getRemarks() != null) {
			s = s + "@p_remarks='" + gatePass.get(0).getRemarks() + "',";
		}
		if (gatePass.get(0).getCreatedBy() != "" && gatePass.get(0).getCreatedBy() != null) {
			s = s + "@p_createdBy='" + gatePass.get(0).getCreatedBy() + "',";
		}
		if (gatePass.get(0).getCustomerId() != "" && gatePass.get(0).getCustomerId() != null) {
			s = s + "@p_customer='" + gatePass.get(0).getCustomerId() + "',";
		}
		if (gatePass.get(0).getFileUpload() != "" && gatePass.get(0).getFileUpload() != null) {
			s = s + "@p_fileUpload='" + gatePass.get(0).getFileUpload() + "',";
		}

		for (GatePassOutModel m : gatePass) {
			gPass = gPass + "(@p_gateOut,\"" + m.getItemCategoryId() + "\",\"" + m.getSubCatId() + "\",\""
					+ m.getItemCode() + "\"," + m.getActualNetQty() + "," + m.getActualNetQty() +","+m.getWeight()+ ",\""
					+ m.getServeTypeId() + "\"),";
		}
		
		gPass = gPass.substring(0, gPass.length() - 1);

		s = s + "@p_gPassSubQuery='" + gPass + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

}
