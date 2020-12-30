package nirmalya.aatithya.restmodule.asset.model;

public class AssetWithPOInventoryModel {

	private String assetId;
	private String assetCode;
	private String classification;
	private String grn;
	private String po;
	private String poDate;
	private String quotation;
	private String qrCode; 
	private String item;
	private String warranty;
	private String remainingDays;
	private String vendor;
	
	public AssetWithPOInventoryModel() {
		super();
	}

	public AssetWithPOInventoryModel(Object assetId, Object assetCode, Object classification, Object grn, Object po,
			Object poDate, Object quotation, Object qrCode, Object item, Object warranty, Object remainingDays, Object vendor) {
		super();
		this.assetId = (String) assetId;
		this.assetCode = (String) assetCode;
		this.classification = (String) classification;
		this.grn = (String) grn;
		this.po = (String) po;
		this.poDate = (String) poDate;
		this.quotation = (String) quotation;
		this.qrCode = (String) qrCode;
		this.item = (String) item;
		this.warranty = (String) warranty;
		this.remainingDays = (String) remainingDays;
		this.vendor = (String) vendor;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getGrn() {
		return grn;
	}

	public void setGrn(String grn) {
		this.grn = grn;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public String getQuotation() {
		return quotation;
	}

	public void setQuotation(String quotation) {
		this.quotation = quotation;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(String remainingDays) {
		this.remainingDays = remainingDays;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
}
