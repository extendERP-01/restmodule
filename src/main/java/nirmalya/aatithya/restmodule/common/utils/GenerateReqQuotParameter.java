package nirmalya.aatithya.restmodule.common.utils;
 
import nirmalya.aatithya.restmodule.inventory.model.RestInventoryReqDetailsModel;

public class GenerateReqQuotParameter {

public static String getAddReqQuotParam(RestInventoryReqDetailsModel table) {
		
		String s = "";
		
		if(table.getReqQuotId()!=null && table.getReqQuotId()!=" ")
		{
			s = s + "@p_Id='" + table.getReqQuotId() + "',";
		}
		if(table.getRfqName()!=null && table.getRfqName()!=" ")
		{
			s = s + "@p_Name='" + table.getRfqName() + "',";
		}
		
		if(table.getRfqBackground()!=null && table.getRfqBackground()!=" ")
		{
			s = s + "@p_background='" + table.getRfqBackground() + "',";
		}
		
		if(table.getRfqValidDate()!=null)
		{
			String sdate = DateFormatter.getStringDate(table.getRfqValidDate());
			s = s + "@p_valid='" + sdate + "',";
			 
		}
		
	 
		s = s + "@p_createdBy='" + table.getCreatedBy() + "',";
		 
		if(table.getRfqDetails()!=null && table.getRfqDetails()!=" ")
		{
			s = s + "@p_Details='" + table.getRfqDetails() + "',";
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
/**
 * ADD USER MANAGEMENT
 */
public static String getAddVendors(RestInventoryReqDetailsModel form) {

	String s = "";
 

	if (form.getRfqVendor() != null && form.getRfqVendor() != "") {

		// s = s + "@p_userRole='" + form.getUserRole() + "',";
		 s = s + "@p_Id='" + form.getReqQuotId() + "',";
		//@PrtId

		String am = "";

		String[] amList = form.getRfqVendor().split(",");

		for (int i = 0; i < amList.length; i++) {

			am = am + "(@p_Id,\"" + amList[i] + "\"),";
		}

		am = am.substring(0, am.length() - 1);

		s = s + "@p_vendersList='" + am + "',";
	}

	 

	if (s != "") {
		s = s.substring(0, s.length() - 1);

		s = "SET " + s + ";";
	}
	 System.out.println("S in generate parameter for vendor add RFQ-----------------"+s);
	return s;
}


}
