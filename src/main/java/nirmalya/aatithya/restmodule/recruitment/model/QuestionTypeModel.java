package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QuestionTypeModel {
	private String speTypeId;
    private String specificName;
    private String questionType;
    private String editId;
    private String CreatedBy;
	public QuestionTypeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionTypeModel(Object speTypeId, Object specificName, Object questionType, Object editId, Object CreatedBy) {
		super();
    	try {
			this.speTypeId = (String) speTypeId;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	try {
			this.specificName = (String) specificName;
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			this.questionType = (String) questionType;
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			this.editId = (String) editId;
		} catch (Exception e) {
			e.printStackTrace();
		}try {
			this.CreatedBy = (String) CreatedBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public String getSpeTypeId() {
		return speTypeId;
	}
	public void setSpeTypeId(String speTypeId) {
		this.speTypeId = speTypeId;
	}
	public String getSpecificName() {
		return specificName;
	}
	public void setSpecificName(String specificName) {
		this.specificName = specificName;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getEditId() {
		return editId;
	}
	public void setEditId(String editId) {
		this.editId = editId;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}
    
    
}
