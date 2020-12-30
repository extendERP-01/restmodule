package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsQualificationMasterModel;

public class GenerateQualificationMasterParameter {

	public static String getAddQualificationParam(HrmsQualificationMasterModel Qualification) {

		String s = "";
		
		if(Qualification.getQualificationId()!=null)
		{
			s = s + "@P_QId='" + Qualification.getQualificationId() + "',";
		}
		if(Qualification.getQualificationName()!=null && Qualification.getQualificationName()!="")
		{
			s = s + "@p_QName='" + Qualification.getQualificationName() + "',";
		}
		 
		if(Qualification.getQualificationDesc()!=null && Qualification.getQualificationDesc()!="")
		{
			s = s + "@p_QDesc='" + Qualification.getQualificationDesc() + "',";
		}
		if(Qualification.getCreatedBy()!=null && Qualification.getCreatedBy()!="")
		{
			s = s + "@p_createdBy='" + Qualification.getCreatedBy() + "',";
		}if(Qualification.getCompanyId()!=null && Qualification.getCompanyId()!="")
		{
			s = s + "@p_companyId='" + Qualification.getCompanyId() + "',";
		}
		if(Qualification.getQualificationStatus()==true || Qualification.getQualificationStatus()==false)
		{
			s = s + "@p_active=" + Qualification.getQualificationStatus() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		return s;
	}
}
