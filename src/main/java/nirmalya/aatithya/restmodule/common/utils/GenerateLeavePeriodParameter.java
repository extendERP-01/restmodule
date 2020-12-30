 

/**Defines SQL SET Parameters for Leave period */
package nirmalya.aatithya.restmodule.common.utils;
import nirmalya.aatithya.restmodule.leave.model.RestLeavePeriodModel; 

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateLeavePeriodParameter {
public static String getAddLeavePeriodParam(RestLeavePeriodModel table) {
		
		String s = "";
		
		if(table.getlPeriodId()!=null && table.getlPeriodId()!=" ")
		{
			s = s + "@p_Id='" + table.getlPeriodId() + "',";
		}
		if(table.getlPeriodName()!=null && table.getlPeriodName()!=" ")
		{
			s = s + "@p_Name='" + table.getlPeriodName() + "',";
		}
		if(table.getlPeriodStartDate()!=null)
		{
			String sdate = DateFormatter.getStringDate(table.getlPeriodStartDate());
			s = s + "@p_Start='" + sdate + "',";
			 
		}
		
		if(table.getlPeriodEndDate()!=null)
		{
			String edate = DateFormatter.getStringDate(table.getlPeriodEndDate());
			s = s + "@p_End='" + edate + "',";
			  
		}
		 
	 
		s = s + "@p_createdBy='" + table.getCreatedBy() + "',";
		 
		if(table.getlPeriodStatus()==true || table.getlPeriodStatus()==false)
		{
			s = s + "@p_Status=" + table.getlPeriodStatus() + ",";
		}
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println("Data in generated parameter"+s);
		
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
