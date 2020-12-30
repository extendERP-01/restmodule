package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsEmployeeSkillAssignModel;

public class GenerateEmployeeSkillAssignParam {

	public static String getAddEmployeeSkillParam(HrmsEmployeeSkillAssignModel Skill) {

		String s = "";
		String query  = "";
		System.out.println(Skill);
		String employeeID = null;
		String desc = null ;
		String createdBy = null; 
		String companyId = null;
		
		if(Skill.getEmployeeId()!=null && Skill.getEmployeeId()!="")
		{
			employeeID =  Skill.getEmployeeId() ;
		}
		 
		if(Skill.getEmployeeSkillDesc()!=null && Skill.getEmployeeSkillDesc()!="")
		{
			desc =  Skill.getEmployeeSkillDesc() ;
		}
		if(Skill.getCreatedby()!=null && Skill.getCreatedby()!="")
		{
			createdBy =  Skill.getCreatedby() ;
		}
		if(Skill.getCompanyId()!=null && Skill.getCompanyId()!="")
		{
			companyId = Skill.getCompanyId() ;
		}

		String[] acList = Skill.getSkillId().split(",");
		
		for (int i = 0; i < acList.length; i++) {
			query = query + "(\"" + employeeID  + "\",\"" + acList[i] + "\",\"" + desc +"\",\""+ createdBy +"\",\"" + companyId
					+ "\"),";

			
		}
		query = query.substring(0, query.length() - 1);

		s = s + "@p_assignSkill='" + query + "',";
		
		
		s = s + "@p_employeeId='" + employeeID + "',";
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		System.out.println(s);
		return s;
	}
}
