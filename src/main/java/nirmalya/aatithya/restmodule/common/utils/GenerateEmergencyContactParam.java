package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmergencyContactModel;

public class GenerateEmergencyContactParam {
	
	public static String getAddemergencyParam(HrmsEmergencyContactModel emergency) {
		
		String s = "";
	System.out.println(emergency);	
		if(emergency.getEmpId()!=null)
		{
			s = s + "@P_empId='" + emergency.getEmpId() + "',";
		}
		if(emergency.getName()!=null && emergency.getName()!="")
		{
			s = s + "@p_name='" + emergency.getName() + "',";
		}
		if(emergency.getMobileNo()!=null && emergency.getMobileNo()!="")
		{
			s = s + "@p_mobNo='" + emergency.getMobileNo() + "',";
		}
		if(emergency.getRelation()!=null && emergency.getRelation()!="")
		{
			s = s + "@p_relation='" + emergency.getRelation() + "',";
		}
		if(emergency.getAdharNo()!=null && emergency.getAdharNo()!="")
		{
			s = s + "@p_adharNo='" + emergency.getAdharNo() + "',";
		}
		if(emergency.getCreatedBy()!=null && emergency.getCreatedBy()!="")
		{
			s = s + "@p_createdBy='" + emergency.getCreatedBy() + "',";
		}
		if(emergency.getCompanyId()!=null && emergency.getCompanyId()!="")
		{
			s = s + "@p_companyId='" + emergency.getCompanyId() + "',";
		}
	
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		System.out.println(s);
		return s;
	}
}
