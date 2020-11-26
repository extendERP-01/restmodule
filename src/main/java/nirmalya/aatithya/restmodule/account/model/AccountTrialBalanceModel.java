package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountTrialBalanceModel {
	private String costCenter;
	private String accountHeadId;
	private Double debitBal;
	private Double creditVal;
	private Double remainingBal;
	private Double totalDebit;
	private Double totalCredit;
	private String desc;

	public AccountTrialBalanceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountTrialBalanceModel(Object costCenter, Object accountHeadId, Object debitBal, Object creditVal,
			Object desc) {
		super();
		try {
			this.costCenter = (String) costCenter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.accountHeadId = (String) accountHeadId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.debitBal = (Double) debitBal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.creditVal = (Double) creditVal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.desc = (String) desc;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getAccountHeadId() {
		return accountHeadId;
	}

	public void setAccountHeadId(String accountHeadId) {
		this.accountHeadId = accountHeadId;
	}

	public Double getDebitBal() {
		return debitBal;
	}

	public void setDebitBal(Double debitBal) {
		this.debitBal = debitBal;
	}

	public Double getCreditVal() {
		return creditVal;
	}

	public void setCreditVal(Double creditVal) {
		this.creditVal = creditVal;
	}

	public Double getRemainingBal() {
		return remainingBal;
	}

	public void setRemainingBal(Double remainingBal) {
		this.remainingBal = remainingBal;
	}

	public Double getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(Double totalDebit) {
		this.totalDebit = totalDebit;
	}

	public Double getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(Double totalCredit) {
		this.totalCredit = totalCredit;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
