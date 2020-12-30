/*
 * Defines GenerateCompareParameter
 *
 */
package nirmalya.aatithya.restmodule.common.utils;

/**
 * @author Nirmalya Labs
 *
 */
import java.util.List;

public class GenerateCompareParameter {
	/*
	 * Function to send two param for property type1
	 *
	 */
	public static String getsendParam(List<DataSetForPropType1> table) {
		String param1="";
		String param2 = "";
		String s = "";

		for(DataSetForPropType1 i : table) {
			param1			=i.getPtype1();
			param2 		    = i.getPtype2();
		}
		s = s + "@p_param1='"+ param1 +"',";
		s = s + "@p_param2='"+ param2 +"',";

		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println("data in generate parameter for listID"+ s);
		return s;
	}
	/*######################################## END #################################################*/
	
	/*
	 * Function to send two param for property type2
	 *
	 */
	public static String getsendParam2(List<DataSetForPropType1> table) {
		String param1="";
		String param3 = "";
		String s = "";

		for(DataSetForPropType1 i : table) {
			param1			=i.getPtype1();
			param3 		    = i.getPtype2();
		}
		s = s + "@p_param1='"+ param1 +"',";
		s = s + "@p_param3='"+ param3 +"',";

		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		System.out.println("data in generate parameter for listID"+ s);
		return s;
	}
	
	/*######################################## END #################################################*/

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
/*######################################## END #################################################*/
}
