package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.IssueConsumedItemModel;

public class GenerateIssueItemVehicleParameter {

	public static String issueItemToVehicle(List<IssueConsumedItemModel> assignedAsset) {
		String s = "";
		String asset = "";
		
		if(assignedAsset.get(0).getVehicleAssetId()!="" && assignedAsset.get(0).getVehicleAssetId()!=null) {
			s = s + "@p_vehicle='" + assignedAsset.get(0).getVehicleAssetId() + "',";
		}
		if(assignedAsset.get(0).getCreatedDate()!="" && assignedAsset.get(0).getCreatedDate()!=null) {
			s = s + "@p_date='" + assignedAsset.get(0).getCreatedDate() + "',";
		}
		
		for(IssueConsumedItemModel m : assignedAsset) {
			asset = asset + "(\""+m.getStore()+"\",\""+m.getVehicleAssetId()+"\",\""+m.getVehicleNo()+"\",\""+m.getItemId()+"\","+m.getIssueQty()+",\""+m.getServeTypeId()+"\",\""+DateFormatter.getStringDate(m.getIssueDate())+"\",\""+m.getCreatedBy()+"\",\""+m.getJobCardId()+"\"),";
		}
		
		asset = asset.substring(0, asset.length() - 1);

		s = s + "@p_assetSubQuery='" + asset + "',";
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println(s);
		
		return s;
	}

}
