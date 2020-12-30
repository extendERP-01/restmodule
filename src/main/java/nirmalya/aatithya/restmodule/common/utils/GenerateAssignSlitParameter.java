package nirmalya.aatithya.restmodule.common.utils;

import java.util.List;

import nirmalya.aatithya.restmodule.production.model.AssignSlitPipeSizeModel;

public class GenerateAssignSlitParameter {

	public static String assignSlitParam(List<AssignSlitPipeSizeModel> assignment) {
		String s = "";
		String assign = "";
		
		for(AssignSlitPipeSizeModel m : assignment) {
			assign = assign + "(\""+m.getGradeId()+"\",\""+m.getThicknessId()+"\","+m.getSlitWidth()+",\""+m.getPipeSizeId()+"\","+m.getStatus()+"),";
		}
		
		assign = assign.substring(0, assign.length() - 1);

		s = s + "@p_assignSubQuery='" + assign + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		System.out.println(s);
		
		return s;
	}

}
