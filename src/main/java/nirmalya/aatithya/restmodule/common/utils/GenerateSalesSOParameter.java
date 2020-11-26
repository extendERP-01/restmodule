package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.sales.model.RestsalesDataSetPriceModel;

public class GenerateSalesSOParameter {

	/*
	 * Function to send two param for property type1
	 *
	 */
	public static String getsendParam(List<RestsalesDataSetPriceModel> table) {
		String param1 = "";
		String param2 = "";
		String itemCat = "";
		String itemSubCat = "";
		String s = "";

		for (RestsalesDataSetPriceModel i : table) {
			param1 = i.getPtype1();
			param2 = i.getPtype2();
			itemCat = i.getItemCat();
			itemSubCat = i.getItemSubCat();
		}
		s = s + "@p_param1='" + param1 + "',";
		s = s + "@p_param2='" + param2 + "',";
		s = s + "@p_itemCat='" + itemCat + "',";
		s = s + "@p_itemSubCat='" + itemSubCat + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("data in generate parameter for listID" + s);
		return s;
	}
	/*
	 * ######################################## END
	 * #################################################
	 */

}
