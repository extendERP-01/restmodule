package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FinancialModel {
	private String financialYearId;
	private String financialYear;
	private String financialFromDate;
	private String financialTodate;
	private Boolean financialStatus;
	private String createdBy;
	public FinancialModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinancialModel(Object financialYearId, Object financialYear, Object financialFromDate, Object financialTodate, Object financialStatus) {
		super();
		try {
			this.financialYearId = (String) financialYearId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.financialYear = (String) financialYear;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.financialFromDate = (String) financialFromDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.financialTodate = (String) financialTodate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.financialStatus = (Boolean) financialStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String getFinancialYearId() {
		return financialYearId;
	}

	public void setFinancialYearId(String financialYearId) {
		this.financialYearId = financialYearId;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getFinancialFromDate() {
		return financialFromDate;
	}

	public void setFinancialFromDate(String financialFromDate) {
		this.financialFromDate = financialFromDate;
	}

	public String getFinancialTodate() {
		return financialTodate;
	}

	public void setFinancialTodate(String financialTodate) {
		this.financialTodate = financialTodate;
	}

	public Boolean getFinancialStatus() {
		return financialStatus;
	}

	public void setFinancialStatus(Boolean financialStatus) {
		this.financialStatus = financialStatus;
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
