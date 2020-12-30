package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.recruitment.model.SpecificTypeModel;

public class GenerateMasterSpecificTypeParameter {

public static String getAddSpecificParam(SpecificTypeModel specific) {
		
		String s = "";
		
		if(specific.getSpecificId()!=null && specific.getSpecificId()!=" ")
		{
			s = s + "@p_specificId='" + specific.getSpecificId() + "',";
		}
		if(specific.getSpecificName()!=null && specific.getSpecificName()!=" ")
		{
			s = s + "@p_specificName='" + specific.getSpecificName() + "',";
		}
		if(specific.getSpecificDesc()!=null && specific.getSpecificDesc()!=" ")
		{
			s = s + "@p_specificDesc='" + specific.getSpecificDesc() + "',";
		}
		if(specific.getSpecificActive()==true || specific.getSpecificActive()==false)
		{
			s = s + "@p_specificActive=" + specific.getSpecificActive() + ",";
		}
		if(specific.getSpecificCreatedBy()!=null && specific.getSpecificCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + specific.getSpecificCreatedBy() + "',";
		}
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		
		return s;
	}

}
