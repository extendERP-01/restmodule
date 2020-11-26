package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.RestHrmGoalMasterModel;

public class GenerateGoalMasterParameter {

	

	public static String getAddGoalMasterParam(RestHrmGoalMasterModel goalMaster) {
	String s = "";
		
		if(goalMaster.gettGoalId()!=null)
		{
			s = s + "@P_goalId='" + goalMaster.gettGoalId() + "',";
		}
		if(goalMaster.gettGoalName()!=null && goalMaster.gettGoalName()!="")
		{
			s = s + "@p_GoalName='" + goalMaster.gettGoalName() + "',";
		}
		 
		if(goalMaster.gettGoalDesc()!=null && goalMaster.gettGoalDesc()!="")
		{
			s = s + "@p_GoalDesc='" + goalMaster.gettGoalDesc() + "',";
		}
		if(goalMaster.gettGoalCreatedBy()!=null && goalMaster.gettGoalCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + goalMaster.gettGoalCreatedBy() + "',";
		}
		
		if(goalMaster.gettGoalStatus()==true || goalMaster.gettGoalStatus()==false)
		{
			s = s + "@p_active=" + goalMaster.gettGoalStatus() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		System.out.println(s);
		return s;
	}
}
