package nirmalya.aatithya.restmodule.sales.model;

public class DeliveryChallanInvoiceModel {

	private String challanNo;
	private String itemId;
	private String itemName;
	private Double Quantity;
	private Double price;
	private Boolean isPumUsed;
	private String pumpId;
	private String pumpName;
	private Double pumpPrice;
	private Double taxRate;
	private String customerName;
	private Double subTotal;
	private Double discount;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private Double grandTotal;
	private Boolean taxType;
	private String custAdress;
	private String phone;
	private String email;
	private String date;
	private String invoiceNo;

	public DeliveryChallanInvoiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryChallanInvoiceModel(Object challanNo, Object itemId, Object itemName, Object quantity, Object price,
			Object isPumUsed, Object pumpId, Object pumpName, Object pumpPrice, Object taxRate, Object customerName,
			Object subTotal, Object discount, Object sgst, Object cgst, Object igst, Object grandTotal, Object taxType,
			Object custAdress, Object phone, Object email, Object date, Object invoiceNo) {
		super();
		this.challanNo = (String) challanNo;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		Quantity = (Double) quantity;
		this.price = (Double) price;
		this.isPumUsed = (Boolean) isPumUsed;
		this.pumpId = (String) pumpId;
		this.pumpName = (String) pumpName;
		this.pumpPrice = (Double) pumpPrice;
		this.taxRate = (Double) taxRate;
		this.customerName = (String) customerName;
		this.subTotal = (Double) subTotal;
		this.discount = (Double) discount;
		this.sgst = (Double) sgst;
		this.cgst = (Double) cgst;
		this.igst = (Double) igst;
		this.grandTotal = (Double) grandTotal;
		this.taxType = (Boolean) taxType;
		this.custAdress = (String) custAdress;
		this.phone = (String) phone;
		this.email = (String) email;
		this.date = (String) date;
		this.invoiceNo = (String) invoiceNo;

	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getQuantity() {
		return Quantity;
	}

	public void setQuantity(Double quantity) {
		Quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getIsPumUsed() {
		return isPumUsed;
	}

	public void setIsPumUsed(Boolean isPumUsed) {
		this.isPumUsed = isPumUsed;
	}

	public String getPumpId() {
		return pumpId;
	}

	public void setPumpId(String pumpId) {
		this.pumpId = pumpId;
	}

	public String getPumpName() {
		return pumpName;
	}

	public void setPumpName(String pumpName) {
		this.pumpName = pumpName;
	}

	public Double getPumpPrice() {
		return pumpPrice;
	}

	public void setPumpPrice(Double pumpPrice) {
		this.pumpPrice = pumpPrice;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getIgst() {
		return igst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public String getCustAdress() {
		return custAdress;
	}

	public void setCustAdress(String custAdress) {
		this.custAdress = custAdress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

}
