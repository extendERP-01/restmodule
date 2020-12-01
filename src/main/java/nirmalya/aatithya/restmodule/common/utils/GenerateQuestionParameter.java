package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.recruitment.model.QuestionModel;

public class GenerateQuestionParameter {

public static String getAddQuestionParam(QuestionModel question) {
		
		String s = "";
		
		if(question.getQuestionId()!=null && question.getQuestionId()!=" ")
		{
			s = s + "@p_questionId='" + question.getQuestionId() + "',";
		}
		if(question.getQuestionName()!=null && question.getQuestionName()!=" ")
		{
			s = s + "@p_questionName='" + question.getQuestionName() + "',";
		}
		if(question.getQuestionDesc()!=null && question.getQuestionDesc()!=" ")
		{
			s = s + "@p_questionDesc='" + question.getQuestionDesc() + "',";
		}
		if(question.getQuestionActive()==true || question.getQuestionActive()==false)
		{
			s = s + "@p_questionActive=" + question.getQuestionActive() + ",";
		}
		if(question.getQuestionCreatedBy()!=null && question.getQuestionCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + question.getQuestionCreatedBy() + "',";
		}
		
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		
		
		return s;
	}

}

