/**Defines SQL SET Parameters for State */
package nirmalya.aatithya.restmodule.common.utils;
import nirmalya.aatithya.restmodule.master.model.UserStateModel;

/**
 * @author Nirmalya Labs
 *
 */
public class GenerateStateParameter {
	
public static String getAddStateParam(UserStateModel table) {
		
		String s = "";
		
		if(table.getStateId() !=null && table.getStateId()!=" ")
		{
			s = s + "@p_stateId='" + table.getStateId() + "',";
		}
		if(table.getStateName()!=null && table.getStateName()!=" ")
		{
			s = s + "@p_stateName='" + table.getStateName() + "',";
		}
		
		s = s + "@p_createdBy='" + table.getCreatedBy() + "',";
		if(table.getStateStatus()==true || table.getStateStatus()==false)
		{
			s = s + "@p_stateStatus=" + table.getStateStatus() + ",";
		}
		
		if(table.getCountryName()!=null && table.getCountryName()!=" ")
		{
			s = s + "@p_countryName='" + table.getCountryName() + "',";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println("param  : " + s );
		
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
