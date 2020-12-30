package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountCashBookDebitModel {

	private String date;
	private String voucherNO;
	private String desc;
	private double amount;

	public AccountCashBookDebitModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountCashBookDebitModel(Object date, Object voucherNO, Object desc, Object amount) {
		super();
		try {
			this.date = (String) date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.voucherNO = (String) voucherNO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.desc = (String) desc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.amount = (double) amount;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVoucherNO() {
		return voucherNO;
	}

	public void setVoucherNO(String voucherNO) {
		this.voucherNO = voucherNO;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
