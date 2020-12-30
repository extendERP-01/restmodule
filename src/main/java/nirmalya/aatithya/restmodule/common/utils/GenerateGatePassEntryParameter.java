package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.gatepass.model.GatePassEntryModel;

public class GenerateGatePassEntryParameter {

	public static String newGatePassEntry(List<GatePassEntryModel> gatePass) {
		String s = "";
		String gPass = "";

		s = s + "@p_weightType=" + gatePass.get(0).getWeightType() + ",";
		s = s + "@p_entryDate='" + DateFormatter.getStringDate(gatePass.get(0).getEntryDate()) + "',";
		s = s + "@p_entryTime='" + gatePass.get(0).getEntryTime() + "',";
		if (gatePass.get(0).getRefGatePassNo() != "" && gatePass.get(0).getRefGatePassNo() != null) {
			s = s + "@p_refGatePassNo='" + gatePass.get(0).getRefGatePassNo() + "',";
		}
		if (gatePass.get(0).getGatePass() != "" && gatePass.get(0).getGatePass() != null) {
			s = s + "@p_gatePass='" + gatePass.get(0).getGatePass() + "',";
		}
		if (gatePass.get(0).getStore() != "" && gatePass.get(0).getStore() != null) {
			s = s + "@p_store='" + gatePass.get(0).getStore() + "',";
		}
		if (gatePass.get(0).getPassType() != null) {
			s = s + "@p_passType=" + gatePass.get(0).getPassType() + ",";
		}
		if (gatePass.get(0).getVendor() != "" && gatePass.get(0).getVendor() != null) {
			s = s + "@p_vendor='" + gatePass.get(0).getVendor() + "',";
		}
		if (gatePass.get(0).getChallanNo() != "" && gatePass.get(0).getChallanNo() != null) {
			s = s + "@p_challanNo='" + gatePass.get(0).getChallanNo() + "',";
		}
		if (gatePass.get(0).getVehicleNo() != "" && gatePass.get(0).getVehicleNo() != null) {
			s = s + "@p_vehicleNo='" + gatePass.get(0).getVehicleNo() + "',";
		}
		if (gatePass.get(0).getRstNo() != "" && gatePass.get(0).getRstNo() != null) {
			s = s + "@p_rstNo='" + gatePass.get(0).getRstNo() + "',";
		}
		if (gatePass.get(0).getClientRSTNo() != "" && gatePass.get(0).getClientRSTNo() != null) {
			s = s + "@p_clientRSTNo='" + gatePass.get(0).getClientRSTNo() + "',";
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
		if (gatePass.get(0).getExitTime() != "" && gatePass.get(0).getExitTime() != null) {
			s = s + "@p_exitTime='" + gatePass.get(0).getExitTime() + "',";
		}
		if (gatePass.get(0).getRemarks() != "" && gatePass.get(0).getRemarks() != null) {
			s = s + "@p_remarks='" + gatePass.get(0).getRemarks() + "',";
		}
		if (gatePass.get(0).getCreatedBy() != "" && gatePass.get(0).getCreatedBy() != null) {
			s = s + "@p_createdBy='" + gatePass.get(0).getCreatedBy() + "',";
		}
		if (gatePass.get(0).getpOrder() != "" && gatePass.get(0).getpOrder() != null) {
			s = s + "@p_pOrder='" + gatePass.get(0).getpOrder() + "',";
		}
		if (gatePass.get(0).getCustomerId() != "" && gatePass.get(0).getCustomerId() != null) {
			s = s + "@p_customer='" + gatePass.get(0).getCustomerId() + "',";
		}

		for (GatePassEntryModel m : gatePass) {
			gPass = gPass + "(@p_gatePass,\"" + m.getItemCategory() + "\",\"" + m.getSubCategory() + "\",\""
					+ m.getItemCode() + "\"," + m.getClientNetQty() + "," + m.getActualNetQty() + ",\""
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
