package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsJobTypeMasterModel;

public class GenerateJobTypeMasterParameter {

	public static String getAddJobTypeParam(HrmsJobTypeMasterModel jobType) {

		String s = "";
		
		if(jobType.getJobTypeId()!=null)
		{
			s = s + "@P_JobId='" + jobType.getJobTypeId() + "',";
		}
		if(jobType.getJobTypeName()!=null && jobType.getJobTypeName()!="")
		{
			s = s + "@p_jobTypeName='" + jobType.getJobTypeName() + "',";
		}
		
		if(jobType.getJobTypeDesc()!=null && jobType.getJobTypeDesc()!="")
		{
			s = s + "@p_jobTypeDesc='" + jobType.getJobTypeDesc() + "',";
		}
		if(jobType.getCreatedBy()!=null && jobType.getCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + jobType.getCreatedBy() + "',";
		}
		if(jobType.getCompanyId()!=null && jobType.getCompanyId()!="")
		{
			s = s + "@p_companyId='" + jobType.getCompanyId() + "',";
		}
		if(jobType.getJobTypeStatus()==true || jobType.getJobTypeStatus()==false)
		{
			s = s + "@p_active=" + jobType.getJobTypeStatus() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		return s;
	}
}
