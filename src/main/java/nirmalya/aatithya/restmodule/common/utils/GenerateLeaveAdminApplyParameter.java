package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.leave.model.RestLeaveApplyAdminModel; 

public class GenerateLeaveAdminApplyParameter {
public static String getChangeStatusParam(RestLeaveApplyAdminModel table) {
		
		String s = "";
		
		if(table.getApplyId()!=null && table.getApplyId()!=" ")
		{
			s = s + "@p_Id='" + table.getApplyId() + "',";
		}
		
		if(table.getlApplyStatus()!=null && table.getlApplyStatus()!=" ")
		{
			s = s + "@p_statusType='" + table.getlApplyStatus() + "',";
		}
		
		if(table.getlReason()!=null && table.getlReason()!=" ")
		{
			s = s + "@p_reason='" + table.getlReason() + "',";
		}
		
		  
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println("Data in generated parameter for chnage status-------------------"+s);
		
		return s;
		
	
	}

public static String getSearchParam(DataTableRequest request) 
{

	String s = "";
	
	if(request.getStart() != null) {
		s = s + "@p_start=" + request.getStart() + ",";
	}
	
	if(request.getLength() != null ) {
		s = s + "@p_length=" + request.getLength() + ",";
	}
	
	if(request.getSearch() != null ) {
		s = s + "@p_search='" + request.getSearch() + "',";
	}
	
	if(request.getParam1() != null ) {
		s = s + "@p_param1='" + request.getParam1() + "',";
	}
	
	if(request.getParam2() != null ) {
		s = s + "@p_param2='" + request.getParam2() + "',";
	}
	
	if(request.getParam3() != null ) {
		s = s + "@p_param3='" + request.getParam3() + "',";
	}
	
	if(request.getParam4() != null ) {
		s = s + "@p_param4='" + request.getParam4() + "',";
	}
	
	
	
	if(s != "") {
		s = s.substring(0, s.length()-1);
		
		s = "SET " + s + ";" ;
	}
	
	System.out.println("param  : " + s );
	
	return s;
}

}
