package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FoodOrderPaymentDetails {

	private String fooOrderId;
	private String voucherId;
	private String payMode;
	private String refNo;
	private Double amount;
	private String transactionDate;

	public FoodOrderPaymentDetails() {
		super();
	}

	public FoodOrderPaymentDetails(Object fooOrderId, Object voucherId, Object payMode, Object refNo, Object amount,
			Object transactionDate) {
		super();
		this.fooOrderId = (String) fooOrderId;
		this.voucherId = (String) voucherId;
		this.payMode = (String) payMode;
		this.refNo = (String) refNo;
		this.amount = (Double) amount;
		this.transactionDate = (String) transactionDate;
	}

	public String getFooOrderId() {
		return fooOrderId;
	}

	public void setFooOrderId(String fooOrderId) {
		this.fooOrderId = fooOrderId;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
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
