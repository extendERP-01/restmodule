package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmEmployeeEducationModel;



public class GenerateEmployeeEducationParameter {

	public static String getAddEmployeeEduParam(
			List<HrmEmployeeEducationModel> hrmEmployeeEducationModel) {

		String s = "";

		String asp = "";
		String pid = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		String startDate = "";
		String endDate ="";
		for (HrmEmployeeEducationModel a : hrmEmployeeEducationModel) {

			String[] userTypeList = a.getQualifId().split(",");
			if (a.getStartDate() != null) {

				 startDate = DateFormatter.getStringDate(a.getStartDate());
			}
			if (a.getEndDate() != null) {

				endDate = DateFormatter.getStringDate(a.getEndDate());
			}
			
			
			for (int i = 0; i < userTypeList.length; i++) {
				asp = asp + "(\"" + a.getEmpId() + "\",\"" + a.getQualifId() + "\",\"" + a.getInsti() + "\",\"" + startDate+"\",\""+ endDate +"\",\"" + a.getCreatedBy() + "\",\""+ a.getCompanyId() + "\",\"" + currentDate + "\"),";
				pid=a.getEmpId();
				
				
			}
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_assignEdu='" + asp + "',";
		
		s = s + "@p_empId='" + pid + "',";
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		
		return s;
	}
	
	
}
