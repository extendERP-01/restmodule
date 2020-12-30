package nirmalya.aatithya.restmodule.reimbursement.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsReimbursementTypeModel {
	private String reimbursementTypeId;
	private String reimbursementTypeName;
	private String reimbursementTypeDesc;
	private Boolean reimbursementTypeStatus;
	private String createdBy;
	private String companyId;

	public HrmsReimbursementTypeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsReimbursementTypeModel(Object reimbursementTypeId, Object reimbursementTypeName,
			Object reimbursementTypeDesc, Object reimbursementTypeStatus) {
		super();
		this.reimbursementTypeId = (String) reimbursementTypeId;
		this.reimbursementTypeName = (String) reimbursementTypeName;
		this.reimbursementTypeDesc = (String) reimbursementTypeDesc;
		this.reimbursementTypeStatus = (Boolean) reimbursementTypeStatus;
	}

	public String getReimbursementTypeId() {
		return reimbursementTypeId;
	}

	public void setReimbursementTypeId(String reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}

	public String getReimbursementTypeName() {
		return reimbursementTypeName;
	}

	public void setReimbursementTypeName(String reimbursementTypeName) {
		this.reimbursementTypeName = reimbursementTypeName;
	}

	public String getReimbursementTypeDesc() {
		return reimbursementTypeDesc;
	}

	public void setReimbursementTypeDesc(String reimbursementTypeDesc) {
		this.reimbursementTypeDesc = reimbursementTypeDesc;
	}

	public Boolean getReimbursementTypeStatus() {
		return reimbursementTypeStatus;
	}

	public void setReimbursementTypeStatus(Boolean reimbursementTypeStatus) {
		this.reimbursementTypeStatus = reimbursementTypeStatus;
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
