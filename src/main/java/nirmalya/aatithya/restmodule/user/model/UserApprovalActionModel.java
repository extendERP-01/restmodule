package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserApprovalActionModel {
	private String approvalId;
	private String actName;
	private String buttonClass;
	private String description;
	private Boolean actStatus;
	private String createdBy;

	public UserApprovalActionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserApprovalActionModel(Object approvalId, Object actName, Object buttonClass, Object description,
			Object actStatus) {
		super();
		this.approvalId = (String) approvalId;
		this.actName = (String) actName;
		this.buttonClass = (String) buttonClass;
		this.description = (String) description;
		this.actStatus = (Boolean) actStatus;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getButtonClass() {
		return buttonClass;
	}

	public void setButtonClass(String buttonClass) {
		this.buttonClass = buttonClass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}

	public Boolean getActStatus() {
		return actStatus;
	}

	public void setActStatus(Boolean actStatus) {
		this.actStatus = actStatus;
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
