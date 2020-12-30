package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.property.model.PropertyThemeModel;

public class GeneratePropertyThameParameter {
	
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
		
		return s;
	}

	
	public static String getAddThemeParam(PropertyThemeModel theme) {

		String s = "";
		
		if(theme.getTheme()!=null)
		{
			s = s + "@p_themeId='" + theme.getTheme() + "',";
		}
		if(theme.getThmName()!=null && theme.getThmName()!=" ")
		{
			s = s + "@p_themeName='" + theme.getThmName() + "',";
		}
		if(theme.getPropertyCategory()!=null && theme.getPropertyCategory()!=" ")
		{
			s = s + "@p_themeCategory='" + theme.getPropertyCategory() + "',";
		}
		if(theme.getThmDescription()!=null && theme.getThmDescription()!=" ")
		{
			s = s + "@p_themeDesc='" + theme.getThmDescription() + "',";
		}
		if(theme.getCreatedBy()!=null && theme.getCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + theme.getCreatedBy() + "',";
		}
		if(theme.getThmActive()==true || theme.getThmActive()==false)
		{
			s = s + "@p_active=" + theme.getThmActive() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		return s;
	}

}
