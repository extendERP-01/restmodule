package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import nirmalya.aatithya.restmodule.recruitment.model.QuestionTypeModel;




public class GenerateQuestionTypeParameter {
	
	public static String getAddQuestionTypeParam(
			List<QuestionTypeModel> questionTypeModel) {

		String s = "";

		String asp = "";
		String pid = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		for (QuestionTypeModel a : questionTypeModel) {
			
			
			
			
				asp = asp + "(\"" + a.getSpeTypeId() + "\",\""  + a.getQuestionType() + "\",\""+ a.getCreatedBy() + "\",\"" + currentDate + "\"),";
				pid=a.getSpeTypeId();
				
				
			
		}
		asp = asp.substring(0, asp.length() - 1);

		s = s + "@p_assignSpec='" + asp + "',";
		
		s = s + "@p_speTypeId='" + pid + "',";
		
		

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;
	}
	
}
