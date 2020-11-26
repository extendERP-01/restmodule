package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.EmployeeIncomeTaxDetails;

public class GenerateEmployeeIncomeTaxParam {

	public static String addFoodTrackData(List<EmployeeIncomeTaxDetails> testData) {

		String s = "";
		String data = "";
		if(testData.get(0).getFromDate() != null) {
			s += "@p_fromDate='" + DateFormatter.getStringDate(testData.get(0).getFromDate()) + "',";
		}
		
		if(testData.get(0).getToDate() != null) {
			s += "@p_toDate='" + DateFormatter.getStringDate(testData.get(0).getToDate()) + "',";
		}
		
		for (EmployeeIncomeTaxDetails m : testData) {
			data = data + "(\"" + m.getEmployeeId() + "\",\"" + DateFormatter.getStringDate(m.getFromDate()) + "\",\""
					+ DateFormatter.getStringDate(m.getToDate()) + "\","  + m.getTaxAmount()
					+ ",\"" + m.getCreatedBy() + "\"),";
		}

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
