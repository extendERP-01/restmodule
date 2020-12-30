package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsAdvancePaymentModel {

	private String advPayId;
	private String date;
	private String employee;
	private Double amount;
	private String paymentMadeBy;
	private String action;
	private String editId;
	private String paymentMode;
	private String transactionNo;
	private String chequeNo;
	private String employeeName;
	private String fromDate;
	private String toDate;

	public HrmsAdvancePaymentModel() {
		super();
	}

	public HrmsAdvancePaymentModel(Object advPayId, Object date, Object employee, Object amount, Object paymentMadeBy,
			Object paymentMode, Object transactionNo, Object chequeNo) {
		super();
		this.advPayId = (String) advPayId;
		this.date = (String) date;
		this.employee = (String) employee;
		this.amount = (Double) amount;
		this.paymentMadeBy = (String) paymentMadeBy;
		this.paymentMode = (String) paymentMode;
		this.transactionNo = (String) transactionNo;
		this.chequeNo = (String) chequeNo;
	}

	public HrmsAdvancePaymentModel(Object employee, Object employeeName, Object amount) {
		super();
		this.employee = (String) employee;
		this.employeeName = (String) employeeName;
		this.amount = (Double) amount;

	}

	public String getAdvPayId() {
		return advPayId;
	}

	public void setAdvPayId(String advPayId) {
		this.advPayId = advPayId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentMadeBy() {
		return paymentMadeBy;
	}

	public void setPaymentMadeBy(String paymentMadeBy) {
		this.paymentMadeBy = paymentMadeBy;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
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
