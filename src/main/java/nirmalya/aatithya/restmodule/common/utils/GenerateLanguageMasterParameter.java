package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsLanguageMasterModel;

public class GenerateLanguageMasterParameter {
	public static String getAddLanguageParam(HrmsLanguageMasterModel Language) {

		String s = "";
		
		if(Language.getLanguageId()!=null)
		{
			s = s + "@P_langId='" + Language.getLanguageId() + "',";
		}
		if(Language.getLanguageName()!=null && Language.getLanguageName()!="")
		{
			s = s + "@p_LangName='" + Language.getLanguageName() + "',";
		}
		 
		if(Language.getLanguageDesc()!=null && Language.getLanguageDesc()!="")
		{
			s = s + "@p_LangDesc='" + Language.getLanguageDesc() + "',";
		}
		if(Language.getCreatedBy()!=null && Language.getCreatedBy()!="")
		{
			s = s + "@p_createdBy='" + Language.getCreatedBy() + "',";
		}
		if(Language.getCompanyId()!=null && Language.getCompanyId()!="")
		{
			s = s + "@p_companyId='" + Language.getCompanyId() + "',";
		}
		if(Language.getLanguageStatus()==true || Language.getLanguageStatus()==false)
		{
			s = s + "@p_active=" + Language.getLanguageStatus() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		return s;
	}
}


