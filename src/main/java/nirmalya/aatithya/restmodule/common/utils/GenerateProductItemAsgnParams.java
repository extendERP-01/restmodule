package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.inventory.model.ProductModel;

public class GenerateProductItemAsgnParams {

	public static String getProductItemParams(List<ProductModel> pModel) {

		String s = "";
		String asset = "";
		String id = "";
		for (ProductModel m : pModel) {
			if (m.getProductId() == null || m.getProductId() == "") {
				asset = asset + "(@P_pid,\"" + m.getProductName() + "\",\"" + m.getQtyPerBatch() + "\",\""
						+ m.getItemId() + "\",\"" + m.getQty() +  "\"),";
			} else {
				id = m.getProductId();
				asset = asset + "(\"" + id + "\",\"" + m.getProductName() + "\",\"" + m.getQtyPerBatch()+ "\",\"" + m.getItemId()
						+ "\",\"" + m.getQty()  + "\"),";
			}
		}

		asset = asset.substring(0, asset.length() - 1);

		s = s + "@p_SubQuery='" + asset + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET @P_pid='" + id + "'," + s + ";";
		}

		System.out.println(s);

		return s;
	}

}
