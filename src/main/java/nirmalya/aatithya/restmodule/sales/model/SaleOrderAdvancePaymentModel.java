package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SaleOrderAdvancePaymentModel {

	private String qutId;
	private String saleOrder;
	private String paymentModel;
	private Double amount;
	private String transId;
	private String posNo;
	private String refNo;
	private String transactionDate;
	
	public SaleOrderAdvancePaymentModel() {
		super(); 
	}

	public SaleOrderAdvancePaymentModel(Object qutId, Object saleOrder, Object paymentModel, Object amount,
			Object transId, Object posNo, Object refNo ,Object transactionDate) {
		super();
		this.qutId = (String) qutId;
		this.saleOrder = (String) saleOrder;
		this.paymentModel = (String) paymentModel;
		this.amount = (Double) amount;
		this.transId = (String) transId;
		this.posNo = (String) posNo;
		this.refNo = (String) refNo;
		this.transactionDate = (String) transactionDate;
	}

	public String getQutId() {
		return qutId;
	}

	public void setQutId(String qutId) {
		this.qutId = qutId;
	}

	public String getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(String saleOrder) {
		this.saleOrder = saleOrder;
	}

	public String getPaymentModel() {
		return paymentModel;
	}

	public void setPaymentModel(String paymentModel) {
		this.paymentModel = paymentModel;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getPosNo() {
		return posNo;
	}

	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
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
