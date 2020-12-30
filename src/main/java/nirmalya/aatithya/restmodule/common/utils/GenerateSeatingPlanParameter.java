package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.model.PropertySeattingPlanModel;

public class GenerateSeatingPlanParameter {
	/**
	 * returns parameter set for DataTableRequest class 
	**/
	public static String getSearchParam(DataTableRequest request) {
		
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
		
		//System.out.println("param  : " + s );
		
		return s;
	}


	public static String getAddSeatingPlan(PropertySeattingPlanModel seattingPlan) {

		String s = "";
		
		if(seattingPlan.getSeatingPlan()!=null)
		{
			s = s + "@p_sittingPlan='" + seattingPlan.getSeatingPlan()+ "',";
		}
		if(seattingPlan.getPropertyCategory()!=null &&seattingPlan.getPropertyCategory()!=" ")
		{
			s = s + "@p_propertyCategory='" + seattingPlan.getPropertyCategory() + "',";
		}
		if(seattingPlan.getPlanName()!=null && seattingPlan.getPlanName()!=" ")
		{
			s = s + "@p_planName='" + seattingPlan.getPlanName() + "',";
		}
		if(seattingPlan.getPlanlogo()!=null && seattingPlan.getPlanlogo()!=" ")
		{
			s = s + "@p_planPhoto='" + seattingPlan.getPlanlogo() + "',";
		}
		
		if(seattingPlan.getPlanDescription()!=null && seattingPlan.getPlanDescription()!=" ")
		{
			s = s + "@p_planDesc='" + seattingPlan.getPlanDescription() + "',";
		}
		if(seattingPlan.getCreatedBy()!=null && seattingPlan.getCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + seattingPlan.getCreatedBy() + "',";
		}
		if(seattingPlan.getPlanActive()==true || seattingPlan.getPlanActive()==false)
		{
			s = s + "@p_active=" + seattingPlan.getPlanActive() + ",";
		}
		
		
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		
		
	//	System.out.println("param for Seating add  : " + s );
		
		return s;
	}
	
}
