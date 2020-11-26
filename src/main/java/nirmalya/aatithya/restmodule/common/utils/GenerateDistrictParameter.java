/**Defines SQL SET Parameters for district */
package nirmalya.aatithya.restmodule.common.utils;
import nirmalya.aatithya.restmodule.master.model.UserDistrictModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateDistrictParameter {
public static String getAddDistrictParam(UserDistrictModel table) {
		
		String s = "";
		
		if(table.getDistrictId()!=null && table.getDistrictId()!=" ")
		{
			s = s + "@p_districtId='" + table.getDistrictId() + "',";
		}
		if(table.getDistrictName()!=null && table.getDistrictName()!=" ")
		{
			s = s + "@p_districtName='" + table.getDistrictName() + "',";
		}
		if(table.getStateName()!=null && table.getStateName()!=" ")
		{
			s = s + "@p_stateName='" + table.getStateName() + "',";
			
			
		}
		 
	 
		s = s + "@p_createdBy='" + table.getCreatedBy() + "',";
		 
		if(table.getDistrictStatus()==true || table.getDistrictStatus()==false)
		{
			s = s + "@p_districtStatus=" + table.getDistrictStatus() + ",";
		}
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		
		return s;
	}

public static String getDistrictDetails(UserDistrictModel table) {
	
	String s = "";
	
	if(table.getDistrictId()!=null && table.getDistrictId()!=" ")
	{
		s = s + "@p_districtId='" + table.getDistrictId() + "',";
	}
	if(table.getDistrictName()!=null && table.getDistrictName()!=" ")
	{
		s = s + "@p_districtName='" + table.getDistrictName() + "',";
	}
	if(table.getStateName()!=null && table.getStateName()!=" ")
	{
		s = s + "@p_stateName='" + table.getStateName() + "',";
	}
	 
 
	 
	if(table.getDistrictStatus()==true || table.getDistrictStatus()==false)
	{
		s = s + "@p_districtStatus=" + table.getDistrictStatus() + ",";
	}
	
	if(s != "") {
		s = s.substring(0, s.length()-1);
		
		s = "SET " + s + ";" ;
	}
	
	
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
