package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountIndividualAccountDetailsModal {
	private String accountHead;
	private String costCenter;
	private double amount;
	private String date;

	public AccountIndividualAccountDetailsModal(Object accountHead, Object costCenter, Object amount, Object date) {
		super();
		try {
			this.accountHead = (String) accountHead;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.costCenter = (String) costCenter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.amount = (double) amount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.date = (String) date;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
