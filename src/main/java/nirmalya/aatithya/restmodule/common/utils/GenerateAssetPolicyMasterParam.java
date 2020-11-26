package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.asset.model.AssetPolicyMaster;

public class GenerateAssetPolicyMasterParam {

	public static String getAddPolicyParam(List<AssetPolicyMaster> assetPolicyMaster) {

		String s = "";

		String asp = "";
		String pid = "";
		
		for (AssetPolicyMaster a : assetPolicyMaster) {
			asp = asp + "(\"" + a.getItemId() + "\",\"" + a.getServiceName() + "\",\"" + a.getFreqId() + "\",\""
					+ a.getTaskPerform() + "\",\"" + a.getCreatedBy() + "\"),";
			pid = a.getItemId();
			System.out.println(a.getFreqName());
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_addPolicy='" + asp + "',";

		s = s + "@p_itemId='" + pid + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
