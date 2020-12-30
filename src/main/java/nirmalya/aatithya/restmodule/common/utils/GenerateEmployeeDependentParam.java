package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeDependentModel;




public class GenerateEmployeeDependentParam {
	public static String getAddEmployeeDependentParam(
			List<HrmsEmployeeDependentModel> hrmsEmployeeDependentModel) {

		String s = "";

		String asp = "";
		String pid = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		for (HrmsEmployeeDependentModel a : hrmsEmployeeDependentModel) {
			
			
			
			
				asp = asp + "(\"" + a.getEmpId() + "\",\"" + a.getRelName() + "\",\"" + a.getRelationId() + "\",\"" + a.getAdharNo()+"\",\""+ a.getMobNo() +"\",\"" + a.getCreatedBy() + "\",\""+ a.getCompanyId() + "\",\"" + currentDate + "\"),";
				pid=a.getEmpId();
				
				
			
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_assignDepnd='" + asp + "',";
		
		s = s + "@p_empId='" + pid + "',";
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		return s;
	}
	
}
