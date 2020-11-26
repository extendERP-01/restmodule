package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.EmployeeFoodTrackingRestModel;
import nirmalya.aatithya.restmodule.employee.model.EmployeeIncomeTaxDetails;
import nirmalya.aatithya.restmodule.employee.model.HrmsAdvancePaymentModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsAttendanceApprovalModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeBonousModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsExtraSalaryModel;
import nirmalya.aatithya.restmodule.employee.model.HrmsLeaveApprovalRestModel;

public class GenerateSalaryApprovalParam {

	public static String saveAdvancePaymentParam(List<HrmsAdvancePaymentModel> hrmsAdvancePaymentModelList) {

		String s = "";
		String data = "";

		for (HrmsAdvancePaymentModel m : hrmsAdvancePaymentModelList) {
			data = data + "(\"" + m.getEmployee() + "\",\"" + DateFormatter.getStringDate(m.getFromDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getToDate()) + "\"," + +m.getAmount() + "),";
		}
		if (data != null)
			data = data.substring(0, data.length() - 1);

		s = s + "@P_SubQueryToInsert='" + data + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("INSERT/UPDATE Advance  PARAM===" + s);

		return s;
	}

	public static String saveIncomeTaxParam(List<EmployeeIncomeTaxDetails> hrmsAdvancePaymentModelList) {

		String s = "";
		String data = "";

		for (EmployeeIncomeTaxDetails m : hrmsAdvancePaymentModelList) {
			data = data + "(\"" + m.getEmployeeId() + "\",\"" + DateFormatter.getStringDate(m.getFromDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getToDate()) + "\"," + +m.getTaxAmount() + "),";
		}
		if (data != null)
			data = data.substring(0, data.length() - 1);

		s = s + "@P_SubQueryToInsert='" + data + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("INSERT/UPDATE income  PARAM===" + s);

		return s;
	}

	public static String saveTripPaymentParam(List<HrmsEmployeeBonousModel> hrmsEmployeeBonousModelList) {

		String s = "";
		String data = "";

		for (HrmsEmployeeBonousModel m : hrmsEmployeeBonousModelList) {
			data = data + "(\"" + m.getEmployeeId() + "\",\"" + DateFormatter.getStringDate(m.getFromDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getToDate()) + "\"," + m.getTotalTrip() + "," + +m.getTotalBonous()
					+ "),";
		}
		if (data != null)
			data = data.substring(0, data.length() - 1);

		s = s + "@P_SubQueryToInsert='" + data + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("INSERT/UPDATE Trip PARAM===" + s);

		return s;
	}

	public static String saveFoodParam(List<EmployeeFoodTrackingRestModel> hrmsEmployeeBonousModelList) {

		String s = "";
		String data = "";

		for (EmployeeFoodTrackingRestModel m : hrmsEmployeeBonousModelList) {
			data = data + "(\"" + m.getEmployeeId() + "\",\"" + DateFormatter.getStringDate(m.getFromDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getToDate()) + "\"," + m.getDayMeal() + "," + m.getNightMeal() + ","
					+ m.getTotalMeal() + "),";
		}
		if (data != null)
			data = data.substring(0, data.length() - 1);

		s = s + "@P_SubQueryToInsert='" + data + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("INSERT/UPDATE saveFoodParam PARAM===" + s);

		return s;
	}

	public static String saveExtraSalaryParam(List<HrmsExtraSalaryModel> hrmsExtraSalaryModelList) {

		String s = "";
		String data = "";

		for (HrmsExtraSalaryModel m : hrmsExtraSalaryModelList) {
			data = data + "(\"" + m.getEmployeeId() + "\",\"" + DateFormatter.getStringDate(m.getFromDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getToDate()) + "\"," + m.getWorkingDay() + "," + m.getWorkDay()
					+ "," + m.getExtraDay() + "),";
		}
		if (data != null)
			data = data.substring(0, data.length() - 1);

		s = s + "@P_SubQueryToInsert='" + data + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("INSERT/UPDATE saveExtraSalaryParam PARAM===" + s);

		return s;
	}

	public static String saveAttendanceParam(List<HrmsAttendanceApprovalModel> hrmsAttendanceApprovalModelList) {

		String s = "";
		String data = "";

		for (HrmsAttendanceApprovalModel m : hrmsAttendanceApprovalModelList) {
			data = data + "(\"" + m.getEmployeeId() + "\",\"" + DateFormatter.getStringDate(m.getFromDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getToDate()) + "\"," + m.getWorkingDay() + "," + m.getWorkDay()
					+ "),";
		}
		if (data != null)
			data = data.substring(0, data.length() - 1);

		s = s + "@P_SubQueryToInsert='" + data + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println("INSERT/UPDATE saveAttendanceParam PARAM===" + s);

		return s;
	}
	public static String saveLeaveParam(List<HrmsLeaveApprovalRestModel> hrmsLeaveApprovalModelList) {
		
		String s = "";
		String data = "";
		
		for (HrmsLeaveApprovalRestModel m : hrmsLeaveApprovalModelList) {
			data = data + "(\"" + m.getEmployeeId() + "\",\"" + DateFormatter.getStringDate(m.getFromDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getToDate()) + "\"," + m.getWorkingDay() + "," + m.getPaidleave()
					+ "," + m.getUnpaidleave()+ "),";
		}
		if (data != null)
			data = data.substring(0, data.length() - 1);
		
		s = s + "@P_SubQueryToInsert='" + data + "',";
		
		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		
		System.out.println("INSERT/UPDATE saveleaveParam PARAM===" + s);
		
		return s;
	}

}
