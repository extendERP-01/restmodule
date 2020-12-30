package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.RestInventoryDamagedItemModel;

public class GenerateInventoryDamagedItemParameter {

	/**
	 * 
	 * ADD DAMAGED ITEM
	 * 
	 **/

	public static String addNewDamagedItemsParam(List<RestInventoryDamagedItemModel> damagedItem) {
		String s = "";
		String litem = "";

		for (RestInventoryDamagedItemModel m : damagedItem) {

			litem = litem + "(\"" + m.gettItem() + "\",\"" + m.gettItemSlNo() + "\",\"" + m.gettDamagedDesc() + "\","
					+ m.gettStatus() + "," + m.gettItemReSaleValue() + ",\"" + m.gettVendor() + "\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_childSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;
	}

	/**
	 * 
	 * MODIFY DAMAGED ITEM
	 * 
	 */

	public static String modifyDamagedItemsParam(List<RestInventoryDamagedItemModel> damagedItem) {
		String s = "";

		Integer id = null;
		String desc = "";
		Boolean status = null;
		Double reSale = 0.0;
		String vendor = "";
		for (RestInventoryDamagedItemModel m : damagedItem) {

			id = m.gettDamagedItemId();
			desc = m.gettDamagedDesc();
			status = m.gettStatus();
			reSale = m.gettItemReSaleValue();
			vendor = m.gettVendor();

		}
		s = s + "@p_id='" + id + "',";
		s = s + "@p_desc='" + desc + "',";
		s = s + "@p_status=" + status + ",";
		s = s + "@p_reSale=" + reSale + ",";
		s = s + "@p_vendor='" + vendor + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("s+++++++++++++++++++++++++" + s);

		return s;
	}

}
