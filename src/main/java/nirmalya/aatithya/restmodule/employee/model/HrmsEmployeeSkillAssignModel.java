package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeSkillAssignModel {

	private String employeeName;
	private String employeeSkill;
	private String employeeSkillDesc;
	private String skillId;
	private String employeeId;
	private String createdby;
	private String companyId;
	private String editId;

	public HrmsEmployeeSkillAssignModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsEmployeeSkillAssignModel(Object employeeName, Object employeeSkill, Object employeeSkillDesc,
			Object skillId, Object employeeId) {
		super();
		try {
			this.employeeName = (String) employeeName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeSkill = (String) employeeSkill;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeSkillDesc = (String) employeeSkillDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.skillId = (String) skillId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeId = (String) employeeId;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeSkill() {
		return employeeSkill;
	}

	public void setEmployeeSkill(String employeeSkill) {
		this.employeeSkill = employeeSkill;
	}

	public String getEmployeeSkillDesc() {
		return employeeSkillDesc;
	}

	public void setEmployeeSkillDesc(String employeeSkillDesc) {
		this.employeeSkillDesc = employeeSkillDesc;
	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
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
