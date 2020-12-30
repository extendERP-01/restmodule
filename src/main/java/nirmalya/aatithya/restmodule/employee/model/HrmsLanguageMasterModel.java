package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsLanguageMasterModel {
	private String languageId;
	private String languageName;
	private String languageDesc;
	private Boolean languageStatus;
	private String createdBy;
	private String companyId;

	public HrmsLanguageMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsLanguageMasterModel(Object languageId, Object languageName, Object languageDesc, Object languageStatus) {
		super();
		try {
			this.languageId = (String) languageId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.languageName = (String) languageName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.languageDesc = (String) languageDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.languageStatus = (Boolean) languageStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLanguageDesc() {
		return languageDesc;
	}

	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}

	public Boolean getLanguageStatus() {
		return languageStatus;
	}

	public void setLanguageStatus(Boolean languageStatus) {
		this.languageStatus = languageStatus;
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
