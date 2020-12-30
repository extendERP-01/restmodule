package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TrainingCreationRestModel {
	private String trainingId;
	private String trainingName;
	private String trainingType;
	private String trainingCriteria;
	private String trainingDesc;
	private Boolean status;
	private String createdBy;

	public TrainingCreationRestModel() {
		super();
	}

	public TrainingCreationRestModel(Object trainingId, Object trainingName, Object trainingType,
			Object trainingCriteria, Object trainingDesc, Object createdBy) {
		super();
		this.trainingId = (String) trainingId;
		this.trainingName = (String) trainingName;
		this.trainingType = (String) trainingType;
		this.trainingCriteria = (String) trainingCriteria;
		this.trainingDesc = (String) trainingDesc;
		this.createdBy = (String) createdBy;
	}

	public String getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getTrainingCriteria() {
		return trainingCriteria;
	}

	public void setTrainingCriteria(String trainingCriteria) {
		this.trainingCriteria = trainingCriteria;
	}

	public String getTrainingDesc() {
		return trainingDesc;
	}

	public void setTrainingDesc(String trainingDesc) {
		this.trainingDesc = trainingDesc;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
