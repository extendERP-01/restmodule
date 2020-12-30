package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.planning.model.HrmsWorksheetPlanningModel;

public class GenerateWorkSheetParameter {
	public static String saveWorkSheetParam(List<HrmsWorksheetPlanningModel> list) {

		String s = "";

		String asp = "";
		for (HrmsWorksheetPlanningModel a : list) {
			asp = asp + "(@P_planId,\"" + a.getEmployeeId() + "\",\"" + a.getCurrentGross() + "\",\""
					+ a.getCurrentCtc() + "\",\"" + a.getNewCtc() + "\",\"" + a.getNewGross() + "\",\""
					+ a.getIncrement() + "\",\"" + a.getCreatedBy() + "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_dtlsParam='" + asp + "',";
		if (list.get(0).getWorkForcePlanId() != null && list.get(0).getWorkForcePlanId() != "") {
			s = s + "@P_planId='" + list.get(0).getWorkForcePlanId() + "',";
		}

		s = s + "@p_deptId='" + list.get(0).getDepartmentId() + "',";
		s = s + "@p_createdBy='" + list.get(0).getCreatedBy() + "',";
		s = s + "@p_budget='" + list.get(0).getBudgetInAmount() + "',";
		s = s + "@p_budgetPer='" + list.get(0).getBudgetInPer() + "',";
		s = s + "@p_actual='" + list.get(0).getActualInAmount() + "',";
		s = s + "@p_actualPer='" + list.get(0).getActualInPer() + "',";
		s = s + "@p_fromDate='" + DateFormatter.getStringDate(list.get(0).getFromDate()) + "',";
		s = s + "@p_toDate='" + DateFormatter.getStringDate(list.get(0).getToDate()) + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
