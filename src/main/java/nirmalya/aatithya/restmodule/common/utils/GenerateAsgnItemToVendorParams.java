package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.VendorItemModel;

public class GenerateAsgnItemToVendorParams {

	public static String getVendorItemParams(List<VendorItemModel> viModel) {

		String s = "";
		String asset = "";

		for (VendorItemModel m : viModel) {
			asset = asset + "(\"" + m.getVendorName() + "\",\"" + m.getItemName() + "\",\"" + m.getItemPrice() + "\",\""
					+ m.getCreatedBy() + "\"),";
		}
		asset = asset.substring(0, asset.length() - 1);
		s = s + "@p_assetSubQuery='" + asset + "',";

		s = s + "@p_vendorId='" + viModel.get(0).getVendorName() + "',";
		s = s + "@p_createdBy='" + viModel.get(0).getCreatedBy() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
