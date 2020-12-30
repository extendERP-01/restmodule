package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */

public class RestDebitCreditLedgerModel {

	private String tLedger;

	private String tCostCenter;

	private String tSaleOrder;
	
	private String tInvoice;

	private String tAccountGroup;

	private String tRegistration;

	private String tRegistrationType;

	private String tGroup;

	private Byte tLedgerType;

	private String tNotes;

	private Double tTotalAmount;

	private String tVoucherNumber;

	private String tBank;

	private String tPaymentMode;

	private String tPaymentReferenceNo;

	private String tTransactionId;

	private String tChequeNo;

	private String tTransactionDate;
	
	private Boolean tPayStatus;

	private String createdBy;

	private String createdOn;
	
private Double creditAmount;
	
	private Double debitAmount;
	
	public RestDebitCreditLedgerModel(Object tLedger, Object tCostCenter, Object tSaleOrder, Object tInvoice,
			Object tAccountGroup, Object tRegistration, Object tRegistrationType, Object tGroup, Object tLedgerType,
			Object tNotes, Object tTotalAmount, Object tVoucherNumber, Object tBank, Object tPaymentMode,
			Object tPaymentReferenceNo, Object tTransactionId, Object tChequeNo, Object tTransactionDate, Object tPayStatus,
			Object createdBy,Object createdOn,Object creditAmount,Object debitAmount ) {
		
		this.tLedger = (String)tLedger;
		this.tCostCenter = (String)tCostCenter;
		this.tSaleOrder = (String)tSaleOrder;
		this.tInvoice = (String)tInvoice;
		this.tAccountGroup = (String)tAccountGroup;
		this.tRegistration = (String)tRegistration;
		this.tRegistrationType = (String)tRegistrationType;
		this.tGroup = (String)tGroup;
		this.tLedgerType = (Byte)tLedgerType;
		this.tNotes = (String)tNotes;
		this.tTotalAmount = (Double)tTotalAmount;
		this.tVoucherNumber = (String)tVoucherNumber;
		this.tBank = (String)tBank;
		this.tPaymentMode = (String)tPaymentMode;
		this.tPaymentReferenceNo = (String)tPaymentReferenceNo;
		this.tTransactionId = (String)tTransactionId;
		this.tChequeNo = (String)tChequeNo;
		this.tTransactionDate = (String)tTransactionDate;
		this.tPayStatus = (Boolean)tPayStatus;
		this.createdBy = (String)createdBy;
		this.createdOn = (String)createdOn;
		this.creditAmount = (Double)creditAmount;
		this.debitAmount = (Double)debitAmount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public String gettLedger() {
		return tLedger;
	}

	public void settLedger(String tLedger) {
		this.tLedger = tLedger;
	}

	public String gettCostCenter() {
		return tCostCenter;
	}

	public void settCostCenter(String tCostCenter) {
		this.tCostCenter = tCostCenter;
	}

	public String gettSaleOrder() {
		return tSaleOrder;
	}

	public void settSaleOrder(String tSaleOrder) {
		this.tSaleOrder = tSaleOrder;
	}

	public String gettInvoice() {
		return tInvoice;
	}

	public void settInvoice(String tInvoice) {
		this.tInvoice = tInvoice;
	}

	public String gettAccountHead() {
		return tAccountGroup;
	}

	public void settAccountHead(String tAccountGroup) {
		this.tAccountGroup = tAccountGroup;
	}

	public String gettRegistration() {
		return tRegistration;
	}

	public void settRegistration(String tRegistration) {
		this.tRegistration = tRegistration;
	}

	public String gettRegistrationType() {
		return tRegistrationType;
	}

	public void settRegistrationType(String tRegistrationType) {
		this.tRegistrationType = tRegistrationType;
	}

	public String gettGroup() {
		return tGroup;
	}

	public void settGroup(String tGroup) {
		this.tGroup = tGroup;
	}

	public Byte gettLedgerType() {
		return tLedgerType;
	}

	public void settLedgerType(Byte tLedgerType) {
		this.tLedgerType = tLedgerType;
	}

	public String gettNotes() {
		return tNotes;
	}

	public void settNotes(String tNotes) {
		this.tNotes = tNotes;
	}

	public Double gettTotalAmount() {
		return tTotalAmount;
	}

	public void settTotalAmount(Double tTotalAmount) {
		this.tTotalAmount = tTotalAmount;
	}

	public String gettVoucherNumber() {
		return tVoucherNumber;
	}

	public void settVoucherNumber(String tVoucherNumber) {
		this.tVoucherNumber = tVoucherNumber;
	}

	public String gettBank() {
		return tBank;
	}

	public void settBank(String tBank) {
		this.tBank = tBank;
	}

	public String gettPaymentMode() {
		return tPaymentMode;
	}

	public void settPaymentMode(String tPaymentMode) {
		this.tPaymentMode = tPaymentMode;
	}

	public String gettPaymentReferenceNo() {
		return tPaymentReferenceNo;
	}

	public void settPaymentReferenceNo(String tPaymentReferenceNo) {
		this.tPaymentReferenceNo = tPaymentReferenceNo;
	}

	public String gettTransactionId() {
		return tTransactionId;
	}

	public void settTransactionId(String tTransactionId) {
		this.tTransactionId = tTransactionId;
	}

	public String gettChequeNo() {
		return tChequeNo;
	}

	public void settChequeNo(String tChequeNo) {
		this.tChequeNo = tChequeNo;
	}

	public String gettTransactionDate() {
		return tTransactionDate;
	}

	public void settTransactionDate(String tTransactionDate) {
		this.tTransactionDate = tTransactionDate;
	}

	public Boolean gettPayStatus() {
		return tPayStatus;
	}

	public void settPayStatus(Boolean tPayStatus) {
		this.tPayStatus = tPayStatus;
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
