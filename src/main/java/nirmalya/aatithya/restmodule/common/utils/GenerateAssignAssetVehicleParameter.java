package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetVehicleModel;

public class GenerateAssignAssetVehicleParameter {

	public static String assignAssetToVehicle(List<AssetVehicleModel> assignedAsset) {
		String s = "";
		String asset = "";
		
		for(AssetVehicleModel m : assignedAsset) {
			asset = asset + "(\""+m.getStore()+"\",\""+m.getVehicleAssetId()+"\",\""+m.getVehicleNo()+"\",\""+m.getAssetId()+"\",\""+m.getSerialNo()+"\","+m.getAssignKM()+",\""+DateFormatter.getStringDate(m.getAssignDate())+"\","+m.getAssignType()+",\""+m.getCreatedBy()+"\"),";
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
