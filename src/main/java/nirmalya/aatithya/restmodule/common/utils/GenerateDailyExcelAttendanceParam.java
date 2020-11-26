package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsDailyAttendanceExcelModel;

public class GenerateDailyExcelAttendanceParam {

	public static String getAddDailyAttendanceParam(List<HrmsDailyAttendanceExcelModel> hrmsEmployeeDependentModel) {

		String s = "";

		String asp = "";
		for (HrmsDailyAttendanceExcelModel a : hrmsEmployeeDependentModel) {

			asp = asp + "(\"" + a.getDate() + "\",\"" + a.getBioMetricId() + "\",\"" + a.getEmployeeName() + "\",\""
					+ a.getInTime() + "\",\"" + a.getOutTime() + "\"),";

		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_subQuery='" + asp + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	public static String getDailyAttendanceUpdateParam(
			List<HrmsDailyAttendanceExcelModel> hrmsEmployeeDependentModel) {

		String s = "";

		String asp = "";
		for (HrmsDailyAttendanceExcelModel a : hrmsEmployeeDependentModel) {

			asp = asp + "(\"" + a.getDate() + "\",\"" + a.getEmployeeId() + "\",\"" + a.getBioMetricId() + "\",\""
					+ a.getEmployeeName() + "\",\"" + a.getInTime() + "\",\"" + a.getOutTime() + "\"),";

		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_subQuery='" + asp + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
