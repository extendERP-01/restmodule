package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsSkillMasterModel {
	private String skillId;
	private String skillName;
	private String skillDesc;
	private Boolean skillStatus;
	private String createdBy;
	private String companyId;

	public HrmsSkillMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsSkillMasterModel(Object skillId, Object skillName, Object skillDesc, Object skillStatus) {
		super();
		try {
			this.skillId = (String) skillId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.skillName = (String) skillName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.skillDesc = (String) skillDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.skillStatus = (Boolean) skillStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	public Boolean getSkillStatus() {
		return skillStatus;
	}

	public void setSkillStatus(Boolean skillStatus) {
		this.skillStatus = skillStatus;
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
