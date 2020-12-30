package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsSupervisorMasterModel;

public class GenerateSupervisorMasterParameter {

	public static String getAddsupervisorParam(HrmsSupervisorMasterModel supervisor) {

		String s = "";
		
		if(supervisor.getSpId()!=null)
		{
			s = s + "@P_spId='" + supervisor.getSpId() + "',";
		}
		if(supervisor.getEmpid()!=null && supervisor.getEmpid()!="")
		{
			s = s + "@p_empId='" + supervisor.getEmpid() + "',";
		}
		if(supervisor.getDeptId()!=null && supervisor.getDeptId()!="")
		{
			s = s + "@p_deptId='" + supervisor.getDeptId() + "',";
		}
		 
		if(supervisor.getDesc()!=null && supervisor.getDesc()!="")
		{
			s = s + "@p_supervisorDesc='" + supervisor.getDesc() + "',";
		}
		if(supervisor.getCreatedBy()!=null && supervisor.getCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + supervisor.getCreatedBy() + "',";
		}
		if(supervisor.getCompanyId()!=null && supervisor.getCompanyId()!="")
		{
			s = s + "@p_companyId='" + supervisor.getCompanyId() + "',";
		}
		if(supervisor.getStatus()==true || supervisor.getStatus()==false)
		{
			s = s + "@p_active=" + supervisor.getStatus() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		return s;
	}
}
