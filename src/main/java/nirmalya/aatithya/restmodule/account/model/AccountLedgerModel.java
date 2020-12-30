package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */

public class AccountLedgerModel {
	
	private String ledgerId ;
	
	private String costCenter ;
	
	private String invoice ;
	
	private String accountHead ;
	
	private String regestrationId ;
	
	private String registrationType ;
	
	private String group ;
	
	private Byte ledgerType ;
	
	private String notes ;
	
	private Double totalAmount ;
	
	private String voucherNumber ;
	
	private String bank ;
	
	private String paymentMode ;
	
	private String referenceNumber ;
	
	private String transactionId ;
	
	private String transactionDate ;
	
	private Boolean paymentStatus ;
	
	private String createdBy ;
	
	private String createdOn ;

	

	public AccountLedgerModel(Object ledgerId, Object costCenter, Object invoice, Object accountHead,
			Object regestrationId, Object registrationType, Object group, Object ledgerType, Object notes,
			Object totalAmount, Object voucherNumber, Object bank, Object paymentMode, Object referenceNumber,
			Object transactionId, Object transactionDate, Object paymentStatus, Object createdBy, Object createdOn) {
		this.ledgerId = (String)ledgerId;
		this.costCenter = (String)costCenter;
		this.invoice = (String)invoice;
		this.accountHead = (String)accountHead;
		this.regestrationId = (String)regestrationId;
		this.registrationType = (String)registrationType;
		this.group = (String)group;
		this.ledgerType = (Byte)ledgerType;
		this.notes = (String)notes;
		this.totalAmount = (Double)totalAmount;
		this.voucherNumber = (String)voucherNumber;
		this.bank = (String)bank;
		this.paymentMode = (String)paymentMode;
		this.referenceNumber = (String)referenceNumber;
		this.transactionId = (String)transactionId;
		this.transactionDate = (String)transactionDate;
		this.paymentStatus = (Boolean)paymentStatus;
		this.createdBy = (String)createdBy;
		this.createdOn = (String)createdOn;
	}

	public String getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(String ledgerId) {
		this.ledgerId = ledgerId;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public String getRegestrationId() {
		return regestrationId;
	}

	public void setRegestrationId(String regestrationId) {
		this.regestrationId = regestrationId;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Byte getLedgerType() {
		return ledgerType;
	}

	public void setLedgerType(Byte ledgerType) {
		this.ledgerType = ledgerType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
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