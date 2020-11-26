package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsJobTypeMasterModel {
	private String jobTypeId;
	private String jobTypeName;
	private String jobTypeDesc;
	private Boolean jobTypeStatus;
	private String createdBy;
	private String companyId;

	public HrmsJobTypeMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsJobTypeMasterModel(Object jobTypeId, Object jobTypeName, Object jobTypeDesc, Object jobTypeStatus) {
		super();
		try {
			this.jobTypeId = (String) jobTypeId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.jobTypeName = (String) jobTypeName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.jobTypeDesc = (String) jobTypeDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.jobTypeStatus = (Boolean) jobTypeStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getJobTypeId() {
		return jobTypeId;
	}

	public void setJobTypeId(String jobTypeId) {
		this.jobTypeId = jobTypeId;
	}

	public String getJobTypeName() {
		return jobTypeName;
	}

	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}

	public String getJobTypeDesc() {
		return jobTypeDesc;
	}

	public void setJobTypeDesc(String jobTypeDesc) {
		this.jobTypeDesc = jobTypeDesc;
	}

	public Boolean getJobTypeStatus() {
		return jobTypeStatus;
	}

	public void setJobTypeStatus(Boolean jobTypeStatus) {
		this.jobTypeStatus = jobTypeStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
