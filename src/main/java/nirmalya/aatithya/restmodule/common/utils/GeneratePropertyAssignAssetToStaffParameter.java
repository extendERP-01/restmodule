package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.property.model.PropertyAssignAssetToStaffModel;

public class GeneratePropertyAssignAssetToStaffParameter {

	public static String getAssignAssetToStaff(List<PropertyAssignAssetToStaffModel> assignAssetToStaff) {
		String s = "";
		String assignAS = "";
		String asset = "";
		for(PropertyAssignAssetToStaffModel m: assignAssetToStaff){
			assignAS = assignAS + "(\""+m.getCostCenter()+"\",\""+m.getStaff()+"\",\""+m.getCategory()+"\",\""+m.getSubcategory()+"\",\""+m.getItem()+"\",\""+m.getAsset()+"\",\""+DateFormatter.getStringDate(m.getAssignDate())+"\",\""+m.getCreatedBy()+"\","+m.getActive()+"),";
			asset = asset +"\""+m.getAsset() +"\",";
		}
		assignAS = assignAS.substring(0, assignAS.length() - 1);
		asset = asset.substring(0, asset.length() - 1);
		
		s = s + "@p_assignAssetStf='" + assignAS + "',";
		s = s + "@p_asset='(" + asset + ")',";
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		System.out.println(s);
		return s;
	}

}
