package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.EmployeeFoodTrackingRestModel;

public class GenerateFoodTrackParameter {

	public static String addFoodTrackData(List<EmployeeFoodTrackingRestModel> testData) {
		
		String s = "";
		String data = "";
		
		if(testData.get(0).getDate()!="" && testData.get(0).getDate()!=null) {
			s = s + "@p_date='" + DateFormatter.getStringDate(testData.get(0).getDate())+ "',";
		}
		
		for(EmployeeFoodTrackingRestModel m : testData) {
			data = data +"(\""+m.getEmployeeId()+"\",\""+DateFormatter.getStringDate(m.getDate())+"\","+m.getDayMeal()+","+m.getNightMeal()+",\""+m.getCreatedBy()+"\"),";
		}
		
		data = data.substring(0, data.length() - 1);
		
		s = s + "@P_SubQueryToInsert='" + data + "',";
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println("INSERT/UPDATE PARAM==="+s);
		
		return s;
	}

}
