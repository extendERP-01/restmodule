package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.account.model.DataSetAccountTree;

public class GenerateDataforChildParameter {
	
	public static String getAddChild(DataSetAccountTree form) {

		String s = "";

		if (form.getGroupName() != null && form.getGroupName() != "") {
			s = s + "@p_groupName='" + form.getGroupName() + "',";
		}
		
		if (form.getLevelName() != null && form.getLevelName() != "") {
			s = s + "@p_levelName='" + form.getLevelName() + "',";
		}

		if (form.getParentId() != null && form.getParentId() != "") {
			s = s + "@p_parentId='" + form.getParentId() + "',";
		}
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
	public static String getAddParent(DataSetAccountTree form) {

		String s = "";

		if (form.getParentName() != null && form.getParentName() != "") {
			s = s + "@p_parentName='" + form.getParentName() + "',";
		}

		  

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}
	
	
	

}
