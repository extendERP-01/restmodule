package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeLeaveUpdateRestModel;

public class GenerateEmployeeleaveParameter {

	public static String getupdateEmployeeLeave(
			List<HrmsEmployeeLeaveUpdateRestModel> hrmsEmployeeLeaveRestModel) {

		String s = "";

		String asp = "";
		
		
		for (HrmsEmployeeLeaveUpdateRestModel a : hrmsEmployeeLeaveRestModel) {

			
			if (a.getDate() != null) {

				 
				 asp = asp + "(\"" + a.getEmpId() + "\",\"" + DateFormatter.getStringDate(a.getDate())+ "\",\"" + a.getAvlLeave() + "\",\"" + a.getCreatedBy() + "\",\"" + a.getApvStatus() + "\"),";
					
			}
			
			
			
			
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_updateLeave='" + asp + "',";
		
		//s = s + "@p_empId='" + pid + "',";
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		return s;
	}
	
	
}

