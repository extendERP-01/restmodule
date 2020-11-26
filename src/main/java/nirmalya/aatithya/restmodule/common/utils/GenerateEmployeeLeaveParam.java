package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeLeaveModel;

public class GenerateEmployeeLeaveParam {
	public static String getAddLeaveParam(HrmsEmployeeLeaveModel advance) {

		String s = "";
		System.out.println(advance);
		if (advance.getLeaveId() != null) {
			s = s + "@p_leaveId='" + advance.getLeaveId() + "',";
		}
		if (advance.getEmployeeId() != null && advance.getEmployeeId() != "") {
			s = s + "@p_employeeId='" + advance.getEmployeeId() + "',";
		}
		if (advance.getFromDate() != null && advance.getFromDate() != "") {
			s = s + "@p_fromDate='" + DateFormatter.getStringDate(advance.getFromDate()) + "',";
		}
		if (advance.getToDate() != null && advance.getToDate() != "") {
			s = s + "@p_fromDate='" + DateFormatter.getStringDate(advance.getFromDate()) + "',";
		}
		if (advance.getLeaveDays() != null) {
			s = s + "@p_leave=" + advance.getLeaveDays() + ",";
		}
		if (advance.getLeaveGrantBy() != null && advance.getLeaveGrantBy() != "") {
			s = s + "@p_grantBy='" + advance.getLeaveGrantBy() + "',";
		}
		if (advance.getCreatedBy() != null && advance.getCreatedBy() != "") {
			s = s + "@p_created='" + advance.getCreatedBy() + "',";
		} 

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
}
