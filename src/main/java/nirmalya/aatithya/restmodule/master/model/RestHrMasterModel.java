package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHrMasterModel {
	
	private String jobTypeId;
	private String jobTypeOrder;
	private String jobTypeName;
	private String jobTypeStatus;
	private String createdOn;
	private String createdBy;
	private String updatedOn;
	private String deletedFlag;
	
	
	public RestHrMasterModel(Object jobTypeId, Object jobTypeOrder,Object jobTypeName, Object jobTypeStatus, Object createdOn,Object createdBy, Object updatedOn, Object deletedFlag) {
		super();
		this.jobTypeId =(String) jobTypeId;
		this.jobTypeOrder = (String)jobTypeOrder;
		this.jobTypeName = (String)jobTypeName;
		this.jobTypeStatus = (String)jobTypeStatus;
		this.createdOn =(String) createdOn;
		this.updatedOn = (String)updatedOn;
		this.createdBy = (String)createdBy;
		this.deletedFlag = (String)deletedFlag;
	}


	public String getJobTypeId() {
		return jobTypeId;
	}


	public void setJobTypeId(String jobTypeId) {
		this.jobTypeId = jobTypeId;
	}

	public String getJobTypeOrder() {
		return jobTypeOrder;
	}


	public void setJobTypeOrder(String jobTypeOrder) {
		this.jobTypeOrder = jobTypeOrder;
	}


	public String getJobTypeName() {
		return jobTypeName;
	}


	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}


	public String getJobTypeStatus() {
		return jobTypeStatus;
	}


	public void setJobTypeStatus(String jobTypeStatus) {
		this.jobTypeStatus = jobTypeStatus;
	}


	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}


	public String getDeletedFlag() {
		return deletedFlag;
	}


	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
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
