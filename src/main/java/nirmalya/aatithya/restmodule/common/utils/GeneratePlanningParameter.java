package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.production.model.ProductionPlanningModel;

public class GeneratePlanningParameter {

	public static String getAddPlanningParam(List<ProductionPlanningModel> productionPlanningModel) {

		String s = "";

		String asp = "";
		String pid = "";

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		String startDate = "";
		String endDate = "";
		String createdBy = "";

		for (ProductionPlanningModel a : productionPlanningModel) {
			if (a.getFromDate() != null) {

				startDate = DateFormatter.getStringDate(a.getFromDate());
			}
		
			asp = asp + "(@p_planId,\"" + startDate + "\",\""
					+ productionPlanningModel.get(0).getStoreId() + "\",\"" + a.getItemId() + "\",\""
					+ a.getProdQuantity() + "\",\"" + a.getCreatedBy() + "\",\"" + a.getBatchCode() + "\",\""
					+ a.getBatchQty() + "\",\"" + currentDate + "\",@p_childItemRequisition),";
			pid = a.getPpId();
			createdBy = a.getCreatedBy();

		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_planning='" + asp + "',";
		if (pid != null && pid != "") {
			s = s + "@p_planId='" + pid + "',";
		}

		s = s + "@p_fromDate='" + startDate + "',";
		s = s + "@p_toDate='" + endDate + "',";
		s = s + "@p_createdBy='" + createdBy + "',";
		s = s + "@p_storeId='" + productionPlanningModel.get(0).getStoreId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("add planning param " + s);
		return s;
	}

	public static String getRawDataParam(List<ProductionPlanningModel> productionPlanningModel) {

		String s = "";

		String asp = "";

		for (ProductionPlanningModel a : productionPlanningModel) {

			asp = asp + "(\"" + a.getStoreId() + "\",\"" + a.getRawMaterialId() + "\",\"" + a.getRawMaterialQty()
					+ "\"),";

		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_subQuery='" + asp + "',";

		s = s + "@p_storeId='" + productionPlanningModel.get(0).getStoreId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("add planning param " + s);
		return s;
	}

}
