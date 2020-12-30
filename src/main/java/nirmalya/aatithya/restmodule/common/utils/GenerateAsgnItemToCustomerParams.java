package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.CustomerItemModel;

public class GenerateAsgnItemToCustomerParams {

	/*
	 * private GenerateAsgnItemToCustomerParams() { throw new
	 * IllegalStateException("Utility class"); }
	 */
	public static String getCustomerItemParams(List<CustomerItemModel> ciModel) {

		String s = "";
		String asset = "";

		s = s + "@p_selectType='" + ciModel.get(0).getSelectType() + "',";
		if (ciModel.get(0).getSelectType().contentEquals("1")) {
			s = s + "@p_priceAll='" + ciModel.get(0).getPriceAll() / 100 + "',";
		} else if (ciModel.get(0).getSelectType().contentEquals("3")) {
			for (CustomerItemModel m : ciModel) {
				asset = asset + "(\"" + m.getCustomerName() + "\",\"" + m.getItemId() + "\",\""
						+ m.getItemSpecialPrice() + "\",\"" + m.getCreatedBy() + "\"),";
			}
			asset = asset.substring(0, asset.length() - 1);
			s = s + "@p_assetSubQuery='" + asset + "',";
		} else if (ciModel.get(0).getSelectType().contentEquals("3")) {
			for (CustomerItemModel m : ciModel) {
				asset = asset + "(\"" + m.getCustomerName() + "\",\"" + m.getItemId() + "\",\""
						+ m.getItemSpecialPrice() + "\",\"" + m.getCreatedBy() + "\"),";
			}
		}

		s = s + "@p_custId='" + ciModel.get(0).getCustomerName() + "',";
		s = s + "@p_createdBy='" + ciModel.get(0).getCreatedBy() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);

		return s;
	}
}
