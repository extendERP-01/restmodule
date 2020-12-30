package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.RestHrmsJobTitleAssignModel;

public class GenerateDepartmentJobTitleAssignParameter {

	public static String getAddJobTitleParam(RestHrmsJobTitleAssignModel jobTitle) {
	String s = "";
	if (jobTitle.gettDepartment() != null && jobTitle.gettDepartment() != "") {	
	
	String dept = jobTitle.gettDepartment();
	String desc = jobTitle.gettDeptAssignDesc();
	Boolean status = jobTitle.gettDeptAssignStatus();
	String createdBy = jobTitle.getCreatedBy();
	
	
		String[] roleList = jobTitle.gettJobTitle().split(",");
	    String roles = "";
		for(int i = 0; i<roleList.length ;i++){
			
			
			roles = roles + "(\"" + dept + "\",\"" + roleList[i] + "\",\"" + desc +"\","+ status +",\""+ createdBy
					+ "\"),";
		}
		
		
		
		
		
		roles = roles.substring(0, roles.length() - 1);
		s = s +  "@p_userRoles='" + roles + "',";
	}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		System.out.println(s);
		return s;
	}
}
