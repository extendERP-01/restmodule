package nirmalya.aatithya.restmodule.reimbursement.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsPolicyMasterModel {

	private String policyName;
	private String policyId;
	private String reimType;
	private String timePeriod;
	private String desc;
	private Boolean status;
	private String reimName;
	private String timePeriodName;
	private String createdBy;
	private String companyId;
	private Double amount;
	private String userRole;
	private String userRoleName;

	public HrmsPolicyMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsPolicyMasterModel(Object policyName, Object policyId, Object reimType, Object timePeriod, Object desc,
			Object status, Object reimName, Object timePeriodName , Object amount ,Object userRole ,Object userRoleName) {
		super();
		this.policyName = (String) policyName;
		this.policyId = (String) policyId;
		this.reimType = (String) reimType;
		this.timePeriod = (String) timePeriod;
		this.desc = (String) desc;
		this.status = (Boolean) status;
		this.reimName = (String) reimName;
		this.timePeriodName = (String) timePeriodName;
		this.amount = (Double) amount;
		this.userRole = (String) userRole;
		this.userRoleName = (String) userRoleName;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getReimType() {
		return reimType;
	}

	public void setReimType(String reimType) {
		this.reimType = reimType;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
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

	public String getReimName() {
		return reimName;
	}

	public void setReimName(String reimName) {
		this.reimName = reimName;
	}

	public String getTimePeriodName() {
		return timePeriodName;
	}

	public void setTimePeriodName(String timePeriodName) {
		this.timePeriodName = timePeriodName;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
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
