package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHrmGoalMasterModel {

	private String tGoalId;
	private String tGoalName;
	private String tGoalDesc;
	private Boolean tGoalStatus;
	private String tGoalCreatedBy;

	public RestHrmGoalMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestHrmGoalMasterModel(Object tGoalId, Object tGoalName, Object tGoalDesc, Object tGoalStatus) {
		super();
		try {
			this.tGoalStatus = (Boolean) tGoalStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tGoalDesc = (String) tGoalDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tGoalName = (String) tGoalName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tGoalId = (String) tGoalId;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String gettGoalId() {
		return tGoalId;
	}

	public void settGoalId(String tGoalId) {
		this.tGoalId = tGoalId;
	}

	public String gettGoalName() {
		return tGoalName;
	}

	public void settGoalName(String tGoalName) {
		this.tGoalName = tGoalName;
	}

	public String gettGoalDesc() {
		return tGoalDesc;
	}

	public void settGoalDesc(String tGoalDesc) {
		this.tGoalDesc = tGoalDesc;
	}

	public Boolean gettGoalStatus() {
		return tGoalStatus;
	}

	public void settGoalStatus(Boolean tGoalStatus) {
		this.tGoalStatus = tGoalStatus;
	}

	public String gettGoalCreatedBy() {
		return tGoalCreatedBy;
	}

	public void settGoalCreatedBy(String tGoalCreatedBy) {
		this.tGoalCreatedBy = tGoalCreatedBy;
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