package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.planning.model.EmployeeSalaryIncementModel;
import nirmalya.aatithya.restmodule.planning.model.HrmsGraderevisionModel;

public class GenerateGradeRevisionParam {
	/*
	 * for grade revision
	 */
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
		s = s + "@p_gradeId='" + greadeRevisionList.get(0).getNewGradeId() + "',";
		s = s + "@p_empId='" + greadeRevisionList.get(0).getEmployeeId() + "',";
		s = s + "@p_desnId='" + greadeRevisionList.get(0).getDesignId() + "',";
		s = s + "@p_fromDate='" + DateFormatter.getStringDate(greadeRevisionList.get(0).getStartDate()) + "',";
		s = s + "@p_toDate='" + DateFormatter.getStringDate(greadeRevisionList.get(0).getEndDate()) + "',";
		s = s + "@p_emplId='" + greadeRevisionList.get(0).getEmployeeId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

	/*
	 * for add employee increment
	 */
	public static String addIncrementParam(List<EmployeeSalaryIncementModel> salaryIncrementList) {

		String s = "";

		String asp = "";

		for (EmployeeSalaryIncementModel a : salaryIncrementList) {
			asp = asp + "(\"" + a.getEmpId() + "\",\"" + a.getCtc() + "\",\"" + a.getComponentId() + "\",\""
					+ a.getCalculationType() + "\",\"" + DateFormatter.getStringDate(a.getEffectiveDate()) + "\",\""
					+ a.getNewAnnualAmount() + "\",\"" + a.getNewMonthlyAmount() + "\",\"" + a.getAmount() + "\"),";
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_dtlsParam='" + asp + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}

}
