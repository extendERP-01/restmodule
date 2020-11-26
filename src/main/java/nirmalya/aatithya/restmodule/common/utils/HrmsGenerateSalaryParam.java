package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsSalaryModel;

public class HrmsGenerateSalaryParam {
	public static String saveSalaryDetails(List<HrmsSalaryModel> hrmsSalaryModelList) {

		String s = "";
		String data = "";

		for (HrmsSalaryModel m : hrmsSalaryModelList) {
			data = data + "(\"" + m.getEmployeeId() + "\",\"" + DateFormatter.getStringDate(m.getFromDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getToDate()) + "\"," + m.getWorkingDays() + "," + m.getEmpWorkDays()
					+ "," + m.getLeavDays() + "," + m.getExtraWorkDays() + "," + m.getPaidDays() + ","
					+ m.getMonthlyGross() + "," + m.getBasic() + "," + m.getHra() + "," + m.getOther() + ","
					+ m.getTotalTrip() + "," + m.getTotalTripAmount() + "," + m.getFoodConsumed() + ","
					+ m.getFoodAvail() + "," + m.getFoodAllowAmount() + "," + m.getFoodAmount() + ","
					+ m.getExtraSalary() + "," + m.getEmpEpf() + "," + m.getEmployerEpf() + "," + m.getEmpEsic() + ","
					+ m.getEmployerEsic() + "," + m.getAdvanceAmount() + "," + m.getIncomeTax() + ",\""
					+ m.getNetSalary() + "\"),";
			System.out.println(m);
		}
		if (data != null)
			data = data.substring(0, data.length() - 1);

		s = s + "@P_SubQueryToInsert='" + data + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("INSERT/UPDATE PARAM===" + s);

		return s;
	}

}
