package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SpecificTypeModel {

	private String specificId;
	private String specificName;
	private String specificDesc;
	private Boolean specificActive;
	private String specificCreatedBy;

	public SpecificTypeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSpecificId() {
		return specificId;
	}

	public void setSpecificId(String specificId) {
		this.specificId = specificId;
	}

	public String getSpecificName() {
		return specificName;
	}

	public void setSpecificName(String specificName) {
		this.specificName = specificName;
	}

	

	public String getSpecificDesc() {
		return specificDesc;
	}

	public void setSpecificDesc(String specificDesc) {
		this.specificDesc = specificDesc;
	}

	public Boolean getSpecificActive() {
		return specificActive;
	}

	public void setSpecificActive(Boolean specificActive) {
		this.specificActive = specificActive;
	}

	public String getSpecificCreatedBy() {
		return specificCreatedBy;
	}

	public void setSpecificCreatedBy(String specificCreatedBy) {
		this.specificCreatedBy = specificCreatedBy;
	}

	public SpecificTypeModel(Object specificId, Object specificName,

			Object specificDesc, Object specificActive, Object specificCreatedBy) {
		super();
		this.specificId = (String) specificId;
		this.specificName = (String) specificName;

		this.specificDesc = (String) specificDesc;
		this.specificActive = (Boolean) specificActive;
		this.specificCreatedBy = (String) specificCreatedBy;

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
