package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsSkillMasterModel;

public class GenerateSkillMasterParameter {

		public static String getAddSkillParam(HrmsSkillMasterModel Skill) {

			String s = "";
			
			if(Skill.getSkillId()!=null)
			{
				s = s + "@P_skillId='" + Skill.getSkillId() + "',";
			}
			if(Skill.getSkillName()!=null && Skill.getSkillName()!="")
			{
				s = s + "@p_SkillName='" + Skill.getSkillName() + "',";
			}
			 
			if(Skill.getSkillDesc()!=null && Skill.getSkillDesc()!="")
			{
				s = s + "@p_SkillDesc='" + Skill.getSkillDesc() + "',";
			}
			if(Skill.getCreatedBy()!=null && Skill.getCreatedBy()!="")
			{
				s = s + "@p_createdBy='" + Skill.getCreatedBy() + "',";
			}
			if(Skill.getCompanyId()!=null && Skill.getCompanyId()!="")
			{
				s = s + "@p_companyId='" + Skill.getCompanyId() + "',";
			}
			if(Skill.getSkillStatus()==true || Skill.getSkillStatus()==false)
			{
				s = s + "@p_active=" + Skill.getSkillStatus() + ",";
			}
			if(s != "") {
				s = s.substring(0, s.length()-1);
				
				s = "SET " + s + ";" ;
			}
			return s;
		}
	}
