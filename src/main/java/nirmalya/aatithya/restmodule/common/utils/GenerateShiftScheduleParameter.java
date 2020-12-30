package nirmalya.aatithya.restmodule.common.utils;


import java.util.List;

import nirmalya.aatithya.restmodule.recruitment.model.ShiftSchedulingModel;

public class GenerateShiftScheduleParameter {
	public static String getAddShiftScheduleParam(
			List<ShiftSchedulingModel> shiftSchedulingModel) {

		String s = "";
		String litem = "";
		String fromDate = "";
		String tSchedule = "";
		String tSection = "";
		String toDate = "";
		String tDepartment = "";
		String createdBy = "";
		for (ShiftSchedulingModel m : shiftSchedulingModel) {
			fromDate =DateFormatter.getStringDate(m.getFromDate());
			tSchedule = m.gettSchedule();
			tSection = m.gettSection();
			toDate = DateFormatter.getStringDate(m.getToDate());
			tDepartment = m.gettDepartment();
			createdBy = m.getCreatedBy();
		}
		s = s + "@p_fromDate='" + fromDate + "',";
		s = s + "@p_tSchedule='" + tSchedule + "',";
		s = s + "@p_tSection='" + tSection + "',";
		s = s + "@p_toDate='" + toDate + "',";
		s = s + "@p_tDepartment='" + tDepartment + "',";
		s = s + "@p_createdBy='" + createdBy + "',";

		for (ShiftSchedulingModel m : shiftSchedulingModel) {

			litem = litem + "(@p_shiftIdId,\"" + m.gettShift() + "\",\"" + m.gettEmp()
					+ "\",\"" + m.gettRemark() + "\"),";

		}
		litem = litem.substring(0, litem.length() - 1);

		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}