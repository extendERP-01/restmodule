package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHrmsJobTitleAssignModel {


	private String tDepartment;
	private String tJobTitle;
	private String tDeptAssignDesc;
	private Boolean tDeptAssignStatus;
		private String createdBy;
	private String companyId;
	private String isedit;
	private String deptId;
	private String jobTitleId;
	public RestHrmsJobTitleAssignModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestHrmsJobTitleAssignModel(Object tDepartment, Object tJobTitle, Object tDeptAssignDesc, Object tDeptAssignStatus,Object isedit,Object deptId,Object jobTitleId ) {
		super();
		try {
			this.isedit = (String) isedit;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.deptId = (String) deptId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.jobTitleId = (String) jobTitleId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tDepartment = (String) tDepartment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tJobTitle = (String) tJobTitle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tDeptAssignDesc = (String) tDeptAssignDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tDeptAssignStatus = (Boolean) tDeptAssignStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
}

	public String gettDepartment() {
		return tDepartment;
	}

	public void settDepartment(String tDepartment) {
		this.tDepartment = tDepartment;
	}

	public String gettJobTitle() {
		return tJobTitle;
	}

	public void settJobTitle(String tJobTitle) {
		this.tJobTitle = tJobTitle;
	}

	public String gettDeptAssignDesc() {
		return tDeptAssignDesc;
	}

	public void settDeptAssignDesc(String tDeptAssignDesc) {
		this.tDeptAssignDesc = tDeptAssignDesc;
	}

	public Boolean gettDeptAssignStatus() {
		return tDeptAssignStatus;
	}

	public void settDeptAssignStatus(Boolean tDeptAssignStatus) {
		this.tDeptAssignStatus = tDeptAssignStatus;
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
	

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getJobTitleId() {
		return jobTitleId;
	}

	public void setJobTitleId(String jobTitleId) {
		this.jobTitleId = jobTitleId;
	}

	public String getIsedit() {
		return isedit;
	}

	public void setIsedit(String isedit) {
		this.isedit = isedit;
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

