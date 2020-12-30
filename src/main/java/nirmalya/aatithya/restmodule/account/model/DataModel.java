package nirmalya.aatithya.restmodule.account.model;

public class DataModel {
	String vendor;
	String invoice;
	Double crdAmt;
	Double dbtAmt;
	Byte ledgerType;
	Double totalamt;

	public DataModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataModel(Object vendor, Object invoice, Object crdAmt, Object dbtAmt, Object ledgerType, Object totalamt) {
		super();
		this.vendor = (String) vendor;
		this.invoice = (String) invoice;
		this.crdAmt = (Double) crdAmt;
		this.dbtAmt = (Double) dbtAmt;
		this.ledgerType = (Byte) ledgerType;
		this.totalamt = (Double) totalamt;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public Double getCrdAmt() {
		return crdAmt;
	}
	public void setCrdAmt(Double crdAmt) {
		this.crdAmt = crdAmt;
	}
	public Double getDbtAmt() {
		return dbtAmt;
	}
	public void setDbtAmt(Double dbtAmt) {
		this.dbtAmt = dbtAmt;
	}
	public Byte getLedgerType() {
		return ledgerType;
	}
	public void setLedgerType(Byte ledgerType) {
		this.ledgerType = ledgerType;
	}
	public Double getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(Double totalamt) {
		this.totalamt = totalamt;
	}
	
	
}
