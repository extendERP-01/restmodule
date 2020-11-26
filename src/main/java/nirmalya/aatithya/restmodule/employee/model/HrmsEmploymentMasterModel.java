package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmploymentMasterModel {
	private String employmentId;
	private String employmentName;
	private String employmentDesc;
	private Boolean employmentStatus;
	private String createdBy;
	private String companyId;

	public HrmsEmploymentMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsEmploymentMasterModel(Object employmentId, Object employmentName, Object employmentDesc,
			Object employmentStatus) {
		super();
		try {
			this.employmentId = (String) employmentId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employmentName = (String) employmentName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employmentDesc = (String) employmentDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employmentStatus = (Boolean) employmentStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getEmploymentId() {
		return employmentId;
	}

	public void setEmploymentId(String employmentId) {
		this.employmentId = employmentId;
	}

	public String getEmploymentName() {
		return employmentName;
	}

	public void setEmploymentName(String employmentName) {
		this.employmentName = employmentName;
	}

	public String getEmploymentDesc() {
		return employmentDesc;
	}

	public void setEmploymentDesc(String employmentDesc) {
		this.employmentDesc = employmentDesc;
	}

	public Boolean getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(Boolean employmentStatus) {
		this.employmentStatus = employmentStatus;
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
