package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.production.model.ProductionGoCoolModel;

public class GenerateProductionMixParameter {
	public static String addProductionMixParam(List<ProductionGoCoolModel> productionGoCoolModelList) {

		String s = "";

		String asp = "";
double sum = 0;
		for (ProductionGoCoolModel a : productionGoCoolModelList) {

			asp = asp + "(@p_prodId,\"" + a.getProdItemId() + "\",\"" + a.getProdQty() + "\"),";
			sum = sum + a.getProdQty();
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_dtlsParam='" + asp + "',";
		s = s + "@p_planId='" + productionGoCoolModelList.get(0).getPlanId() + "',";
		s = s + "@p_StoreId='" + productionGoCoolModelList.get(0).getStoreId() + "',";
		s = s + "@p_scrapQty='" + productionGoCoolModelList.get(0).getScrapQty() + "',";
		s = s + "@p_createdBy='" + productionGoCoolModelList.get(0).getCreatedBy() + "',";
		s = s + "@p_totalProd='" + sum + "',";
		s = s + "@p_startDate='" + DateFormatter.getStringDate(productionGoCoolModelList.get(0).getMixStartDate())
				+ "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
