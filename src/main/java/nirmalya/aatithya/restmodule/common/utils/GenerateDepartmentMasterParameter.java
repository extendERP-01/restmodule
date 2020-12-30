package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsDepartmentMasterModel;

public class GenerateDepartmentMasterParameter {
	public static String getAddDepartmentParam(HrmsDepartmentMasterModel Department) {

		String s = "";
		
		if(Department.getDepartmentId()!=null)
		{
			s = s + "@P_deptId='" + Department.getDepartmentId() + "',";
		}
		if(Department.getDepartmentName()!=null && Department.getDepartmentName()!="")
		{
			s = s + "@p_DepartmentName='" + Department.getDepartmentName() + "',";
		}
		 
		if(Department.getDepartmentDesc()!=null && Department.getDepartmentDesc()!="")
		{
			s = s + "@p_DepartmentDesc='" + Department.getDepartmentDesc() + "',";
		}
		if(Department.getCreatedBy()!=null && Department.getCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + Department.getCreatedBy() + "',";
		}
		if(Department.getCompanyId()!=null && Department.getCompanyId()!="")
		{
			s = s + "@p_companyId='" + Department.getCompanyId() + "',";
		}
		if(Department.getDepartmentStatus()==true || Department.getDepartmentStatus()==false)
		{
			s = s + "@p_active=" + Department.getDepartmentStatus() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		System.out.println(s);
		return s;
	}
}
