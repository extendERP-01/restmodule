package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsSupervisorMasterModel {
	private String spId;
	private String empid;
	private String deptId;
	private String desc;
	private Boolean status;
	private String spName;
	private String empName;
	private String deptName;
	private String createdBy;
	private String companyId;

	public HrmsSupervisorMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsSupervisorMasterModel(Object spId, Object empid, Object deptId, Object desc, Object status,
			 Object empName, Object deptName) {
		super();
		this.spId = (String) spId;
		this.empid = (String) empid;
		this.deptId = (String) deptId;
		this.desc = (String) desc;
		this.status = (Boolean) status;
		this.empName = (String) empName;
		this.deptName = (String) deptName;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
