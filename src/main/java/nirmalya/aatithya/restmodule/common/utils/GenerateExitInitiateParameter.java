package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.employee.model.ExitInitiateModel;



public class GenerateExitInitiateParameter {
	public static String getExitInitiateParam(List<ExitInitiateModel> exitInitiateModel) {
		String s = "";
		String litem = "";
		
		String deleteDetermination= "";
		String initiateId= "";
		String empId = "";
		String empName = "";
		String empDepartmentName = "";
		String manager="";
		String department = "";
		String person = "";
		String clearanceStatus = "";
		String comment = "";	
		String createdBy = "";

		Double average = 0.0;

			initiateId = exitInitiateModel.get(0).getIntiateId();
			empId = exitInitiateModel.get(0).getEmpId();
			empName = exitInitiateModel.get(0).getEmpName();
			empDepartmentName=exitInitiateModel.get(0).getEmpDepartment();
			manager=exitInitiateModel.get(0).getManager();
			createdBy = exitInitiateModel.get(0).getCreatedBy();
	
		s = s + "@p_initiateId='" + initiateId + "',";
		s = s + "@p_empId='" + empId + "',";
		s = s + "@p_empName='" + empName + "',";
		s = s + "@p_empDepartmentName='" + empDepartmentName + "',";	
		s = s + "@p_manager='" + manager + "',";	
		s = s + "@p_createdBy='" + createdBy + "',";	
		

		for (ExitInitiateModel m : exitInitiateModel) {
			
			deleteDetermination = deleteDetermination + "(\""+ m.getIntiateId()+"\"),";
			litem = litem + "(@p_initiateId,\"" + m.getEmpId() + "\",\"" + m.getDepartment() + "\",\"" + m.getPerson() + "\","+m.getClearanceStatus()+ ",\"" + m.getCreatedBy() + "\",\"" + m.getComment() + "\"),";

		}
		deleteDetermination = deleteDetermination.substring(0, deleteDetermination.length() - 1);
		litem = litem.substring(0, litem.length() - 1);
		s = s + "@p_deleteDetermination='" + "(" + deleteDetermination + ")" + "',";
		s = s + "@p_litemSubQuery='" + litem + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);
			
			s = "SET " + s + ";";
		}
		System.out.println("s"+s);
		return s;
	}
}
