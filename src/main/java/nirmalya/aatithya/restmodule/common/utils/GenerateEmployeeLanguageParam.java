package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeLanguageModel;




public class GenerateEmployeeLanguageParam {


	public static String getAddEmployeeLangParam(
			List<HrmsEmployeeLanguageModel> hrmsEmployeeLanguageModel) {

		String s = "";

		String asp = "";
		String pid = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		for (HrmsEmployeeLanguageModel a : hrmsEmployeeLanguageModel) {
			
			
			
			
				asp = asp + "(\"" + a.getEmpId() + "\",\"" + a.getLangId() + "\",\"" + a.getReadId() + "\",\"" + a.getWriteId()+"\",\""+ a.getSpaekId() +"\",\"" + a.getCreatedBy() + "\",\""+ a.getCompanyId() + "\",\"" + currentDate + "\"),";
				pid=a.getEmpId();
				
				
			
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_assignEdu='" + asp + "',";
		
		s = s + "@p_empId='" + pid + "',";
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
	
	
}

