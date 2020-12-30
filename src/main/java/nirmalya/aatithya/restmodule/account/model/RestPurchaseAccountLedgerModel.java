package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class RestPurchaseAccountLedgerModel {

	private String tPaymentVoucher;
	private String tVendor;
	private String tPaymentMode;
	private String tPymntTransactionNo;
	private String tPymntTransactionDate;
	private String tPymntCheckNo;
	private String tBank;
	private String tBankBranch;
	private String tBankAccountNo;
	private String tPymntGrnInvoice;

	private String tPymntReferenceNo;
	private Boolean tPymntGSTType;
	private Double tPymntGSTRate;
	private Double tPymntTDSRate;
	private Double tPymntTaxableAmount;
	private Double tPymntTDSAmount;
	private Double tPymntIGST;
	private Double tPymntCGST;
	private Double tPymntSGST;
	private Double tPymntTotalAmount;
	private Boolean tPymntActive;
	private String createdOn;
	private String createdBy;
	
	public RestPurchaseAccountLedgerModel(Object tPaymentVoucher, Object tVendor, Object tPaymentMode,
			Object tPymntTransactionNo, Object tPymntTransactionDate, Object tPymntCheckNo, Object tBank,
			Object tBankBranch, Object tBankAccountNo,Object tPymntGrnInvoice, Object tPymntReferenceNo, Object tPymntGSTType,
			Object tPymntGSTRate, Object tPymntTDSRate, Object tPymntTaxableAmount, Object tPymntTDSAmount,
			Object tPymntIGST, Object tPymntCGST, Object tPymntSGST, Object tPymntTotalAmount, Object tPymntActive,
			Object createdOn, Object createdBy) {
		this.tPaymentVoucher = (String) tPaymentVoucher;
		this.tVendor = (String) tVendor;
		this.tPaymentMode = (String) tPaymentMode;
		this.tPymntTransactionNo = (String) tPymntTransactionNo;
		this.tPymntTransactionDate = (String) tPymntTransactionDate;
		this.tPymntCheckNo = (String) tPymntCheckNo;
		this.tBank = (String) tBank;
		this.tBankBranch = (String) tBankBranch;
		this.tBankAccountNo = (String) tBankAccountNo;
		this.tPymntGrnInvoice = (String) tPymntGrnInvoice;
		this.tPymntReferenceNo = (String) tPymntReferenceNo;
		this.tPymntGSTType = (Boolean) tPymntGSTType;
		this.tPymntGSTRate = (Double) tPymntGSTRate;
		this.tPymntTDSRate = (Double) tPymntTDSRate;
		this.tPymntTaxableAmount = (Double) tPymntTaxableAmount;
		this.tPymntTDSAmount = (Double) tPymntTDSAmount;
		this.tPymntIGST = (Double) tPymntIGST;
		this.tPymntCGST = (Double) tPymntCGST;
		this.tPymntSGST = (Double) tPymntSGST;
		this.tPymntTotalAmount = (Double) tPymntTotalAmount;
		this.tPymntActive = (Boolean) tPymntActive;
		this.createdOn = (String) createdOn;
		this.createdBy = (String) createdBy;
	

	}

	public String gettPaymentVoucher() {
		return tPaymentVoucher;
	}

	public void settPaymentVoucher(String tPaymentVoucher) {
		this.tPaymentVoucher = tPaymentVoucher;
	}

	public String gettVendor() {
		return tVendor;
	}

	public void settVendor(String tVendor) {
		this.tVendor = tVendor;
	}

	public String gettPaymentMode() {
		return tPaymentMode;
	}

	public void settPaymentMode(String tPaymentMode) {
		this.tPaymentMode = tPaymentMode;
	}

	public String gettPymntTransactionNo() {
		return tPymntTransactionNo;
	}

	public void settPymntTransactionNo(String tPymntTransactionNo) {
		this.tPymntTransactionNo = tPymntTransactionNo;
	}

	public String gettPymntTransactionDate() {
		return tPymntTransactionDate;
	}

	public void settPymntTransactionDate(String tPymntTransactionDate) {
		this.tPymntTransactionDate = tPymntTransactionDate;
	}

	public String gettPymntCheckNo() {
		return tPymntCheckNo;
	}

	public void settPymntCheckNo(String tPymntCheckNo) {
		this.tPymntCheckNo = tPymntCheckNo;
	}

	public String gettBank() {
		return tBank;
	}

	public void settBank(String tBank) {
		this.tBank = tBank;
	}

	public String gettBankBranch() {
		return tBankBranch;
	}

	public void settBankBranch(String tBankBranch) {
		this.tBankBranch = tBankBranch;
	}

	public String gettBankAccountNo() {
		return tBankAccountNo;
	}

	public void settBankAccountNo(String tBankAccountNo) {
		this.tBankAccountNo = tBankAccountNo;
	}

	public String gettPymntReferenceNo() {
		return tPymntReferenceNo;
	}

	public void settPymntReferenceNo(String tPymntReferenceNo) {
		this.tPymntReferenceNo = tPymntReferenceNo;
	}

	public Boolean gettPymntGSTType() {
		return tPymntGSTType;
	}

	public void settPymntGSTType(Boolean tPymntGSTType) {
		this.tPymntGSTType = tPymntGSTType;
	}

	public Double gettPymntGSTRate() {
		return tPymntGSTRate;
	}

	public void settPymntGSTRate(Double tPymntGSTRate) {
		this.tPymntGSTRate = tPymntGSTRate;
	}

	public Double gettPymntTDSRate() {
		return tPymntTDSRate;
	}

	public void settPymntTDSRate(Double tPymntTDSRate) {
		this.tPymntTDSRate = tPymntTDSRate;
	}

	public Double gettPymntTaxableAmount() {
		return tPymntTaxableAmount;
	}

	public void settPymntTaxableAmount(Double tPymntTaxableAmount) {
		this.tPymntTaxableAmount = tPymntTaxableAmount;
	}

	public Double gettPymntTDSAmount() {
		return tPymntTDSAmount;
	}

	public void settPymntTDSAmount(Double tPymntTDSAmount) {
		this.tPymntTDSAmount = tPymntTDSAmount;
	}

	public Double gettPymntIGST() {
		return tPymntIGST;
	}

	public void settPymntIGST(Double tPymntIGST) {
		this.tPymntIGST = tPymntIGST;
	}

	public Double gettPymntCGST() {
		return tPymntCGST;
	}

	public void settPymntCGST(Double tPymntCGST) {
		this.tPymntCGST = tPymntCGST;
	}

	public Double gettPymntSGST() {
		return tPymntSGST;
	}

	public void settPymntSGST(Double tPymntSGST) {
		this.tPymntSGST = tPymntSGST;
	}

	public Double gettPymntTotalAmount() {
		return tPymntTotalAmount;
	}

	public void settPymntTotalAmount(Double tPymntTotalAmount) {
		this.tPymntTotalAmount = tPymntTotalAmount;
	}

	public Boolean gettPymntActive() {
		return tPymntActive;
	}

	public void settPymntActive(Boolean tPymntActive) {
		this.tPymntActive = tPymntActive;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String gettPymntGrnInvoice() {
		return tPymntGrnInvoice;
	}

	public void settPymntGrnInvoice(String tPymntGrnInvoice) {
		this.tPymntGrnInvoice = tPymntGrnInvoice;
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