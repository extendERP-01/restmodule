package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeBonousModel;

public class GenerateTripBonousParameter {
	public static String addTripBonousParam(List<HrmsEmployeeBonousModel> tripBonousList) {

		String s = "";

		String asp = "";
		double sum = 0;
		for (HrmsEmployeeBonousModel a : tripBonousList) {
			asp = asp + "(\"" + a.getEmployeeId() + "\",\"" + DateFormatter.getStringDate(a.getFromDate())
					+ "\",\"" + DateFormatter.getStringDate(a.getToDate()) + "\",\"" + a.getAttendance() + "\",\""
					+ a.getTotalTrip() + "\",\"" + a.getTotalBonous() + "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_dtlsParam='" + asp + "',";
		s = s + "@p_empId='" + tripBonousList.get(0).getEmployeeId() + "',";
		s = s + "@p_createdBy='" + tripBonousList.get(0).getCreatedBy() + "',";
		s = s + "@p_totalProd='" + sum + "',";
		s = s + "@p_date='" + DateFormatter.getStringDate(tripBonousList.get(0).getToDate()) + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
