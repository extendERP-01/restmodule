package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsQualificationMasterModel {
	private String qualificationId;
	private String qualificationName;
	private String qualificationDesc;
	private Boolean qualificationStatus;
	private String createdBy;
	private String companyId;

	public HrmsQualificationMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsQualificationMasterModel(Object qualificationId, Object qualificationName, Object qualificationDesc,
			Object qualificationStatus) {
		super();
		try {
			this.qualificationId = (String) qualificationId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qualificationName = (String) qualificationName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qualificationDesc = (String) qualificationDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qualificationStatus = (Boolean) qualificationStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getQualificationDesc() {
		return qualificationDesc;
	}

	public void setQualificationDesc(String qualificationDesc) {
		this.qualificationDesc = qualificationDesc;
	}

	public Boolean getQualificationStatus() {
		return qualificationStatus;
	}

	public void setQualificationStatus(Boolean qualificationStatus) {
		this.qualificationStatus = qualificationStatus;
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
