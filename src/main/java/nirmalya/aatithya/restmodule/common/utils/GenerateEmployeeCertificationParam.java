package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeCertificationModel;


public class GenerateEmployeeCertificationParam {
	public static String getAddEmployeeCertiParam(
			List<HrmsEmployeeCertificationModel> hrmEmployeecertificationModel) {

		String s = "";

		String asp = "";
		String pid = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		String startDate = "";
		String endDate ="";
		for (HrmsEmployeeCertificationModel a : hrmEmployeecertificationModel) {
			if (a.getGrantDate() != null) {

				 startDate = DateFormatter.getStringDate(a.getGrantDate());
			}
			if (a.getValidDate() != null) {

				endDate = DateFormatter.getStringDate(a.getValidDate());
			}
			
			
				asp = asp + "(\"" + a.getEmpId() + "\",\"" + a.getCertifId() + "\",\"" + a.getInsti() + "\",\"" + startDate+"\",\""+ endDate +"\",\"" + a.getCreatedBy() + "\",\""+ a.getCompanyId() + "\",\"" + currentDate + "\"),";
				pid=a.getEmpId();
				
				
			
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

