package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.ExitManagementModel;
import nirmalya.aatithya.restmodule.employee.model.RestHrmGoalMasterModel;

public class GenerateExitManagementParameter {
	public static String getAddExitManagementParam(ExitManagementModel exitManagement) {
		String s = "";
			
			if(exitManagement.getExitManagementId()!=null && exitManagement.getExitManagementId()!="")
			{
				s = s + "@p_exitMangementId='" + exitManagement.getExitManagementId() + "',";
			}
			if(exitManagement.getEmpId()!=null && exitManagement.getEmpId()!="")
			{
				s = s + "@p_empId='" + exitManagement.getEmpId() + "',";
			}
			 
			if(exitManagement.getEmpDesignation()!=null && exitManagement.getEmpDesignation()!="")
			{
				s = s + "@p_empdesignation='" + exitManagement.getEmpDesignation() + "',";
			}
			
			if (exitManagement.getResignationDate() != null && exitManagement.getResignationDate() != "") {
				s = s + "@p_resignationDate='" + DateFormatter.getStringDate(exitManagement.getResignationDate()) + "',";
			}
			if(exitManagement.getSalary()!=null)
			{
				s = s + "@p_salary=" + exitManagement.getSalary() + ",";
			}
			if(exitManagement.getBonus()!=null)
			{
				s = s + "@p_bonus=" + exitManagement.getBonus() + ",";
			}
			if(exitManagement.getRecovery()!=null) {
				s = s + "@p_recovery=" + exitManagement.getRecovery() + ",";
			}
			
			if(exitManagement.getNoticeperiod()!=null && exitManagement.getNoticeperiod()!="")
			{
				s = s + "@p_noticeperiod='" + exitManagement.getNoticeperiod() + "',";
			}
			
			if (exitManagement.getReleaseDate() != null && exitManagement.getReleaseDate() != "") {
				s = s + "@p_releaseDate='" + DateFormatter.getStringDate(exitManagement.getReleaseDate()) + "',";
			}
			if(exitManagement.getResignation()!=null && exitManagement.getResignation()!="")
			{
				s = s + "@p_resignation='" + exitManagement.getResignation() + "',";
			}
			if(exitManagement.getCreatedBy()!=null && exitManagement.getCreatedBy()!=" ")
			{
				s = s + "@p_createdBy='" + exitManagement.getCreatedBy() + "',";
			}
			if(s != "") {
				s = s.substring(0, s.length()-1);
				
				s = "SET " + s + ";" ;
			}
			System.out.println(s);
			return s;
		}
}
