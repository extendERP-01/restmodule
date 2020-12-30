package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmploymentMasterModel;

public class GenerateEmploymentParameter {
	
	public static String getAddEmploymentParam(HrmsEmploymentMasterModel employment) {

		String s = "";
		
		if(employment.getEmploymentId()!=null)
		{
			s = s + "@P_EMPLId='" + employment.getEmploymentId() + "',";
		}
		if(employment.getEmploymentName()!=null && employment.getEmploymentName()!="")
		{
			s = s + "@p_employmentName='" + employment.getEmploymentName() + "',";
		}
		 
		if(employment.getEmploymentDesc()!=null && employment.getEmploymentDesc()!="")
		{
			s = s + "@p_employmentDesc='" + employment.getEmploymentDesc() + "',";
		}
		if(employment.getCreatedBy()!=null && employment.getCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + employment.getCreatedBy() + "',";
		}
		if(employment.getCompanyId()!=null && employment.getCompanyId()!="")
		{
			s = s + "@p_companyId='" + employment.getCompanyId() + "',";
		}
		if(employment.getEmploymentStatus()==true || employment.getEmploymentStatus()==false)
		{
			s = s + "@p_active=" + employment.getEmploymentStatus() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		return s;
	}
}
