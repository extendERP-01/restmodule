package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHrmEmployeeReviewerDetailsModel {

	private String tUserRole;
	private String tEmployee;
	private Integer tSetAuthorityStageNo;
	private String tSetAuthorityTAT;
	private String tSetAuthorityNFA;
	private String tAppraisalFrequency;
	private Integer tAppraisalDueDate;
	private String tCompanyId;
	private String tSetAuthorityCreatedBy;
	private String isedit;
	private String tStaff;
	private String staff;
	private String tNFA;
	private String userId;
	private String financialDate;
	private String financialFromDate;
	private String financialToDate;

	public RestHrmEmployeeReviewerDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestHrmEmployeeReviewerDetailsModel(Object tUserRole, Object tEmployee, Object tSetAuthorityStageNo,
			Object tSetAuthorityTAT, Object tSetAuthorityNFA, Object tAppraisalDueDate, Object isedit, Object tStaff,
			Object staff, Object tNFA, Object tAppraisalFrequency, Object financialDate, Object financialFromDate, Object financialToDate) {
		super();
		try {
			this.financialFromDate = (String) financialFromDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.financialToDate = (String) financialToDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.financialDate = (String) financialDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAppraisalFrequency = (String) tAppraisalFrequency;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.userId = (String) userId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tNFA = (String) tNFA;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tUserRole = (String) tUserRole;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tStaff = (String) tStaff;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.staff = (String) staff;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.isedit = (String) isedit;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAppraisalDueDate = (Integer) tAppraisalDueDate;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tSetAuthorityNFA = (String) tSetAuthorityNFA;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.tSetAuthorityTAT = (String) tSetAuthorityTAT;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tSetAuthorityStageNo = (Integer) tSetAuthorityStageNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tEmployee = (String) tEmployee;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String gettUserRole() {
		return tUserRole;
	}

	public void settUserRole(String tUserRole) {
		this.tUserRole = tUserRole;
	}

	public String gettEmployee() {
		return tEmployee;
	}

	public void settEmployee(String tEmployee) {
		this.tEmployee = tEmployee;
	}

	public Integer gettSetAuthorityStageNo() {
		return tSetAuthorityStageNo;
	}

	public void settSetAuthorityStageNo(Integer tSetAuthorityStageNo) {
		this.tSetAuthorityStageNo = tSetAuthorityStageNo;
	}

	public String gettSetAuthorityTAT() {
		return tSetAuthorityTAT;
	}

	public void settSetAuthorityTAT(String tSetAuthorityTAT) {
		this.tSetAuthorityTAT = tSetAuthorityTAT;
	}

	public String gettSetAuthorityNFA() {
		return tSetAuthorityNFA;
	}

	public void settSetAuthorityNFA(String tSetAuthorityNFA) {
		this.tSetAuthorityNFA = tSetAuthorityNFA;
	}

	public Integer gettAppraisalDueDate() {
		return tAppraisalDueDate;
	}

	public void settAppraisalDueDate(Integer tAppraisalDueDate) {
		this.tAppraisalDueDate = tAppraisalDueDate;
	}

	public String gettCompanyId() {
		return tCompanyId;
	}

	public void settCompanyId(String tCompanyId) {
		this.tCompanyId = tCompanyId;
	}

	public String gettSetAuthorityCreatedBy() {
		return tSetAuthorityCreatedBy;
	}

	public void settSetAuthorityCreatedBy(String tSetAuthorityCreatedBy) {
		this.tSetAuthorityCreatedBy = tSetAuthorityCreatedBy;
	}

	public String getIsedit() {
		return isedit;
	}

	public void setIsedit(String isedit) {
		this.isedit = isedit;
	}

	public String gettStaff() {
		return tStaff;
	}

	public void settStaff(String tStaff) {
		this.tStaff = tStaff;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String gettNFA() {
		return tNFA;
	}

	public void settNFA(String tNFA) {
		this.tNFA = tNFA;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String gettAppraisalFrequency() {
		return tAppraisalFrequency;
	}

	public void settAppraisalFrequency(String tAppraisalFrequency) {
		this.tAppraisalFrequency = tAppraisalFrequency;
	}

	public String getFinancialDate() {
		return financialDate;
	}

	public void setFinancialDate(String financialDate) {
		this.financialDate = financialDate;
	}

	public String getFinancialFromDate() {
		return financialFromDate;
	}

	public void setFinancialFromDate(String financialFromDate) {
		this.financialFromDate = financialFromDate;
	}

	public String getFinancialToDate() {
		return financialToDate;
	}

	public void setFinancialToDate(String financialToDate) {
		this.financialToDate = financialToDate;
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
