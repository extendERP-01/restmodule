package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.planning.model.HrmsGraderevisionModel;

public class GenerateGradeRevisionParam {
	public static String addGradeRevisionParam(List<HrmsGraderevisionModel> greadeRevisionList) {

		String s = "";

		String asp = "";
		for (HrmsGraderevisionModel a : greadeRevisionList) {
			asp = asp + "(@p_gradeRevId,\"" + a.getEmployeeId() + "\",\""
					+ DateFormatter.getStringDate(a.getEffectiveDate()) + "\",\"" + a.getNewGradeId() + "\",\""
					+ a.getDesignId() + "\",\"" + a.getCreatedBy() + "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_dtlsParam='" + asp + "',";
		s = s + "@p_graveRevId='" + greadeRevisionList.get(0).getGradeRevId() + "',";
		s = s + "@p_createdBy='" + greadeRevisionList.get(0).getCreatedBy() + "',";
		s = s + "@p_deptId='" + greadeRevisionList.get(0).getDepartmentId() + "',";
		s = s + "@p_fromDate='" + DateFormatter.getStringDate(greadeRevisionList.get(0).getStartDate()) + "',";
		s = s + "@p_toDate='" + DateFormatter.getStringDate(greadeRevisionList.get(0).getEndDate()) + "',";
		s = s + "@p_emplId='" + greadeRevisionList.get(0).getEmployeeId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
}
