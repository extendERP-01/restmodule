package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.sales.model.DeliveryChalanModel;

public class GenerateDeliveryChallanParam {
	public static String getAddDeliveryChallanParam(DeliveryChalanModel deliveryChalanModel) {

		String s = "";

		if (deliveryChalanModel.getEntryDate() != null && deliveryChalanModel.getEntryDate() != "") {
			s = s + "@p_entryDate='" + DateFormatter.getStringDate(deliveryChalanModel.getEntryDate()) + "',";
		}
		if (deliveryChalanModel.getChallanNo() != null && deliveryChalanModel.getChallanNo() != "") {
			s = s + "@p_challanNo='" + deliveryChalanModel.getChallanNo() + "',";
		}
		if (deliveryChalanModel.getChallanType() != null) {
			s = s + "@p_challanType='" + deliveryChalanModel.getChallanType() + "',";
		}
		if (deliveryChalanModel.getSaleOrder() != null && deliveryChalanModel.getSaleOrder() != " ") {
			s = s + "@p_saleOrder='" + deliveryChalanModel.getSaleOrder() + "',";
		}
		if (deliveryChalanModel.getRefPoId() != null && deliveryChalanModel.getRefPoId() != " ") {
			s = s + "@p_refPoId='" + deliveryChalanModel.getRefPoId() + "',";
		}
		if (deliveryChalanModel.getClientAccount() != null && deliveryChalanModel.getClientAccount() != " ") {
			s = s + "@p_clientAccount='" + deliveryChalanModel.getClientAccount() + "',";
		}
		if (deliveryChalanModel.getTin() != null && deliveryChalanModel.getTin() != "") {
			s = s + "@p_tin='" + deliveryChalanModel.getTin() + "',";
		}
		if (deliveryChalanModel.getDeliveryAddress() != null && deliveryChalanModel.getDeliveryAddress() != "") {
			s = s + "@p_deliveryAddress='" + deliveryChalanModel.getDeliveryAddress() + "',";
		}
		if (deliveryChalanModel.getDeliverySite() != null && deliveryChalanModel.getDeliverySite() != "") {
			s = s + "@p_deliverySite='" + deliveryChalanModel.getDeliverySite() + "',";
		}
		 
		if (deliveryChalanModel.getSlurryPowder() != null) {
			s = s + "@p_slurryPowder=" + deliveryChalanModel.getSlurryPowder() + ",";
		}
		if (deliveryChalanModel.getBatchPlant() != null && deliveryChalanModel.getBatchPlant() != "") {
			s = s + "@p_batchPlant='" + deliveryChalanModel.getBatchPlant() + "',";
		}
		if (deliveryChalanModel.getBatchTime() != null) {
			s = s + "@p_batchTime='" + deliveryChalanModel.getBatchTime() + "',";
		}
		if (deliveryChalanModel.getCementBrand() != null) {
			s = s + "@p_cementBrand='" + deliveryChalanModel.getCementBrand() + "',";
		}
		if (deliveryChalanModel.getBatchQty() != null) {
			s = s + "@p_batchQty='" + deliveryChalanModel.getBatchQty() + "',";
		}
		if (deliveryChalanModel.getRmcGrade() != null && deliveryChalanModel.getRmcGrade() != "") {
			s = s + "@p_rmcGrade='" + deliveryChalanModel.getRmcGrade() + "',";
		}
		if (deliveryChalanModel.getSlumpMM() != null) {
			s = s + "@p_slumpMM='" + deliveryChalanModel.getSlumpMM() + "',";
		}
		if (deliveryChalanModel.getQcRemark() != null && deliveryChalanModel.getQcRemark() != "") {
			s = s + "@p_qcRemark='" + deliveryChalanModel.getQcRemark() + "',";
		}
		if (deliveryChalanModel.getBillQty() != null) {
			s = s + "@p_billQty='" + deliveryChalanModel.getBillQty() + "',";
		}
		if (deliveryChalanModel.getNoOfTm() != null ) {
			s = s + "@p_noOfTm='" + deliveryChalanModel.getNoOfTm() + "',";
		}
		if (deliveryChalanModel.getTotalQty() != null) {
			s = s + "@p_totalQty='" + deliveryChalanModel.getTotalQty() + "',";
		}
		if (deliveryChalanModel.getTotal() != null) {
			s = s + "@p_totalRaw='" + deliveryChalanModel.getTotal() + "',";
		}
		if (deliveryChalanModel.getDensity() != null) {
			s = s + "@p_density='" + deliveryChalanModel.getDensity() + "',";
		}
		if (deliveryChalanModel.getAutoNoOfTmQty() != null ) {
			s = s + "@p_autoNoOfTmQty=" + deliveryChalanModel.getAutoNoOfTmQty() + ",";
		}
		if (deliveryChalanModel.getReferalChallanNo() != null && deliveryChalanModel.getReferalChallanNo() != "") {
			s = s + "@p_referalChallanNo='" + deliveryChalanModel.getReferalChallanNo() + "',";
		}
		if (deliveryChalanModel.getRefGatePassNo() != null && deliveryChalanModel.getRefGatePassNo() != "") {
			s = s + "@p_refGatePassNo='" + deliveryChalanModel.getRefGatePassNo() + "',";
		}
		if (deliveryChalanModel.getVechileNo() != null && deliveryChalanModel.getVechileNo() != "") {
			s = s + "@p_vechileNo='" + deliveryChalanModel.getVechileNo() + "',";
		}
		if (deliveryChalanModel.getRstNo() != null && deliveryChalanModel.getRstNo() != "") {
			s = s + "@p_rstNo='" + deliveryChalanModel.getRstNo() + "',";
		}
		if (deliveryChalanModel.getGrossWt() != null) {
			s = s + "@p_grossWt='" + deliveryChalanModel.getGrossWt() + "',";
		}
		if (deliveryChalanModel.getTareWt() != null) {
			s = s + "@p_tareWt='" + deliveryChalanModel.getTareWt() + "',";
		}
		if (deliveryChalanModel.getNetWt() != null) {
			s = s + "@p_netWt='" + deliveryChalanModel.getNetWt() + "',";
		}
		if (deliveryChalanModel.getDriverId() != null) {
			s = s + "@p_driverId='" + deliveryChalanModel.getDriverId() + "',";
		}
		if (deliveryChalanModel.getHelper() != null) {
			s = s + "@p_helper='" + deliveryChalanModel.getHelper() + "',";
		}
		if (deliveryChalanModel.getOutTime() != null) {
			s = s + "@p_outTime='" + deliveryChalanModel.getOutTime() + "',";
		}
		if (deliveryChalanModel.getOkm() != null) {
			s = s + "@p_okm='" + deliveryChalanModel.getOkm() + "',";
		}
		if (deliveryChalanModel.getOfhr() != null) {
			s = s + "@p_ofhr='" + deliveryChalanModel.getOfhr() + "',";
		}
		if (deliveryChalanModel.getObhr() != null) {
			s = s + "@p_obhr='" + deliveryChalanModel.getObhr() + "',";
		}
		/*
		 * if (deliveryChalanModel.getRstNo() != null && deliveryChalanModel.getRstNo()
		 * != "") { s = s + "@p_rstNo=" + deliveryChalanModel.getRstNo() + ","; }
		 */

		if (deliveryChalanModel.getPumpList() != null) {
			s = s + "@p_pumpId='" + deliveryChalanModel.getPumpList() + "',";
		}
		if (deliveryChalanModel.getReturnTime() != null) {
			s = s + "@p_returnTime='" + deliveryChalanModel.getReturnTime() + "',";
		}
		if (deliveryChalanModel.getrKm() != null) {
			s = s + "@p_rKm='" + deliveryChalanModel.getrKm() + "',";
		}
		if (deliveryChalanModel.getRfhr() != null) {
			s = s + "@p_rfhr='" + deliveryChalanModel.getRfhr() + "',";
		}
		if (deliveryChalanModel.getrBhr() != null) {
			s = s + "@p_rBhr='" + deliveryChalanModel.getrBhr() + "',";
		}
		if (deliveryChalanModel.getSiteInTime() != null) {
			s = s + "@p_siteInTime='" + deliveryChalanModel.getSiteInTime() + "',";
		}
		if (deliveryChalanModel.getSiteOutTime() != null) {
			s = s + "@p_siteOutTime='" + deliveryChalanModel.getSiteOutTime() + "',";
		}
		if (deliveryChalanModel.getSiteSupervisor() != null) {
			s = s + "@p_siteSupervisor='" + deliveryChalanModel.getSiteSupervisor() + "',";
		}
		if (deliveryChalanModel.getRemarks() != null) {
			s = s + "@p_remarks='" + deliveryChalanModel.getRemarks() + "',";
		}
		if (deliveryChalanModel.getIsPump() != null) {
			s = s + "@p_isPumpUsed=" + deliveryChalanModel.getIsPump() + ",";
		}
		if (deliveryChalanModel.getCreatedBy() != null) {
			s = s + "@p_createdBy='" + deliveryChalanModel.getCreatedBy() + "',";
		}
		if (deliveryChalanModel.getDocketNo() != null) {
			s = s + "@p_docketNo='" + deliveryChalanModel.getDocketNo() + "',";
		}
		if (deliveryChalanModel.getCementSupplyByClient() != null) {
			s = s + "@p_isCementSupplyByClient=" + deliveryChalanModel.getCementSupplyByClient() + ",";
		}
		
		 
		String assignParam = "";

		assignParam = assignParam + "(@p_challanNo,\"" + deliveryChalanModel.getSand2Id() + "\",\""
				+ deliveryChalanModel.getSand2() + "\"),";
		assignParam = assignParam + "(@p_challanNo,\"" + deliveryChalanModel.getChip310mmId() + "\",\""
				+ deliveryChalanModel.getChip310mm() + "\"),";
		assignParam = assignParam + "(@p_challanNo,\"" + deliveryChalanModel.getChip420mmId() + "\",\""
				+ deliveryChalanModel.getChip420mm() + "\"),";
		assignParam = assignParam + "(@p_challanNo,\"" + deliveryChalanModel.getCementId() + "\",\""
				+ deliveryChalanModel.getCement() + "\"),";
		assignParam = assignParam + "(@p_challanNo,\"" + deliveryChalanModel.getWaterId() + "\",\""
				+ deliveryChalanModel.getWater() + "\"),";
		assignParam = assignParam + "(@p_challanNo,\"" + deliveryChalanModel.getAddMixId() + "\",\""
				+ deliveryChalanModel.getAddMix() + "\"),";
		assignParam = assignParam + "(@p_challanNo,\"" + deliveryChalanModel.getFlyAshId() + "\",\""
				+ deliveryChalanModel.getAddMix() + "\"),";
		assignParam = assignParam + "(@p_challanNo,\"" + deliveryChalanModel.getSlurryPowderId() + "\",\""
				+ deliveryChalanModel.getSlurryPowder() + "\"),";

		assignParam = assignParam.substring(0, assignParam.length() - 1);
		s = s + "@p_assignParam='" + assignParam + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
