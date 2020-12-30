package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.RestGradeSalaryMasterModel;

public class GenerateGradeSalaryMasterParameter {

	public static String addGradeSalaryParam(List<RestGradeSalaryMasterModel> gradeSalaryMaster) {
		String s = "";
		String litem = "";
		String deleteGradeSalary = "";
		for (RestGradeSalaryMasterModel m : gradeSalaryMaster) {

			deleteGradeSalary = deleteGradeSalary + "(\"" + m.gettGradeId() + "\",\"" + m.gettSalaryComponent()
					+ "\"),";
			litem = litem + "(\"" + m.gettGradeId() + "\",\"" + m.gettSalaryComponent() + "\","
					+ m.gettCalculationType() + "," + m.gettAmount() + ",\"" + m.gettCreatedBy() + "\"),";
		}
		litem = litem.substring(0, litem.length() - 1);
		deleteGradeSalary = deleteGradeSalary.substring(0, deleteGradeSalary.length() - 1);

		s = s + "@p_deleteSubQuery='" + "(" + deleteGradeSalary + ")" + "',";
		s = s + "@p_gradeId='" + gradeSalaryMaster.get(0).gettGradeId() + "',";
		s = s + "@p_litem='" + litem + "',";
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println("data are " + s);
		return s;
	}

}
