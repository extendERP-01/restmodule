package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsDepartmentMasterModel {

	private String departmentId;
	private String departmentName;
	private String departmentDesc;
	private Boolean departmentStatus;
	private String createdBy;
	private String companyId;

	public HrmsDepartmentMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsDepartmentMasterModel(Object departmentId, Object departmentName, Object departmentDesc,
			Object departmentStatus) {
		super();
		try {
			this.departmentId = (String) departmentId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.departmentName = (String) departmentName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.departmentDesc = (String) departmentDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.departmentStatus = (Boolean) departmentStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDesc() {
		return departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	public Boolean getDepartmentStatus() {
		return departmentStatus;
	}

	public void setDepartmentStatus(Boolean departmentStatus) {
		this.departmentStatus = departmentStatus;
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
