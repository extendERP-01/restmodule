package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountHeadTypeModel {

	private String accountHeadTypeId;
	private String accountHeadType;
	private String desc;
	private Boolean status;
	private String createdBy;

	public AccountHeadTypeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountHeadTypeModel(Object accountHeadTypeId, Object accountHeadType, Object desc, Object status) {
		super();
		try {
			this.accountHeadTypeId = (String) accountHeadTypeId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.accountHeadType = (String) accountHeadType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.desc = (String) desc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.status = (Boolean) status;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAccountHeadTypeId() {
		return accountHeadTypeId;
	}

	public void setAccountHeadTypeId(String accountHeadTypeId) {
		this.accountHeadTypeId = accountHeadTypeId;
	}

	public String getAccountHeadType() {
		return accountHeadType;
	}

	public void setAccountHeadType(String accountHeadType) {
		this.accountHeadType = accountHeadType;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
