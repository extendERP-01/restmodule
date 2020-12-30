package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.production.model.ProductionReturnModel;

public class GenerateProductReturnParam {

	private GenerateProductReturnParam() {
		throw new IllegalStateException("Utility class");
	}

	public static String getAddReturnParam(List<ProductionReturnModel> productionReturnModel) {

		String s = "";

		String asp = "";
		String pid = "";

		String createdBy = "";

		for (ProductionReturnModel a : productionReturnModel) {

			asp = asp + "(@p_returnId,\"" + a.getRawItemId() + "\",\"" + a.getRetQty() + "\"),";

			createdBy = a.getCreatedBy();
			pid = a.getReurnId();
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_returnDtls='" + asp + "',";
		if (pid != null && pid != "") {
			s = s + "@p_planId='" + pid + "',";
		}

		s = s + "@p_planId='" + productionReturnModel.get(0).getPlanId() + "',";
		s = s + "@p_storeId='" + productionReturnModel.get(0).getStoreID() + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_desc='" + productionReturnModel.get(0).getDescription() + "',";
		if (productionReturnModel.get(0).getReturnDate() != null) {
			s = s + "@p_date='" + DateFormatter.getStringDate(productionReturnModel.get(0).getReturnDate()) + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		} 
		return s;
	}

}
