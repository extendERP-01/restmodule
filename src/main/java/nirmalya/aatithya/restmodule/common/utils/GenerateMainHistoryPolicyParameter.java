package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.asset.model.AssetMaintenanceHistoryModel;

public class GenerateMainHistoryPolicyParameter {

	public static String addMainHistoryPolicy(AssetMaintenanceHistoryModel mainHistory) {
		String s = "";
		
		if(mainHistory.getAssetCode()!="" && mainHistory.getAssetCode()!=null) {
			s = s + "@p_assetCode='" + mainHistory.getAssetCode() + "',";
		}
		if(mainHistory.getServiceType()!="" && mainHistory.getServiceType()!=null) {
			s = s + "@p_serviceType='" + mainHistory.getServiceType() + "',";
		}
		if(mainHistory.getPolicyId()!=null) {
			s = s + "@p_policyId=" + mainHistory.getPolicyId() + ",";
		}
		if(mainHistory.getDesc()!="" && mainHistory.getDesc()!=null) {
			s = s + "@p_desc='" + mainHistory.getDesc() + "',";
		}
		if(mainHistory.getPrice()!=null) {
			s = s + "@p_price=" + mainHistory.getPrice() + ",";
		}
		if(mainHistory.getPerformedDate()!="" && mainHistory.getPerformedDate()!=null) {
			s = s + "@p_performDate='" + DateFormatter.getStringDate(mainHistory.getPerformedDate()) + "',";
		}
		if(mainHistory.getCreatedBy()!="" && mainHistory.getCreatedBy()!=null) {
			s = s + "@p_createdBy='" + mainHistory.getCreatedBy() + "',";
		}
		if(mainHistory.getFreqId()!="" && mainHistory.getFreqId()!=null) {
			s = s + "@p_frequency='" + mainHistory.getFreqId() + "',";
		}
		if(mainHistory.getKmHr()!=null) {
			s = s + "@p_kmHr=" + mainHistory.getKmHr() + ",";
		}
		
		Double nextKmHr = 0.0;
		if(mainHistory.getKmHr()!=null) {
			nextKmHr = mainHistory.getKmHr() + mainHistory.getPolicyKmHr();
		}
		
		s = s + "@p_nextKmHr=" + nextKmHr + ",";
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		System.out.println(s);
		return s;
	}

}
