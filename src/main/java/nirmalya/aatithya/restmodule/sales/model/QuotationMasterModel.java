package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QuotationMasterModel {

	private String quotationId;

	private String quotationName;

	private String customerId;

	private String customerName;

	private String qDescription;

	private String quotationVDate;

	private String qNote;

	private Boolean qStatus;

	private String itemName;

	private String itemCode;

	private Double unitPrice;

	private Double quantity;

	private String qServeType;

	private Double lineTotal;

	private Boolean taxType;

	private Double gstRate;

	private Double subTotal;

	private Double qIGST;

	private Double qCGST;

	private Double qSGST;

	private Double grandTotal;

	private Boolean approveActive;

	private String createdBy;

	private String purchaseOrder;

	private String pOrderDate;

	private String pOrderImage;

	private String salesOrder;

	private String sOrderDate;

	private String hotelName;

	private String hotelAddress;

	private String hotelCity;

	private String hotelPhn;

	private String hotelGSTIn;

	private String custName;

	private String custId;

	private String custAddress;

	private String custCountry;

	private String custGmail;

	private String custPhn;

	private String custGSTIn;

	private Boolean invoiceType;

	private Boolean salesOrderActive;

	private Double discount;

	private Double advAmount;

	private String payMode;

	private String transId;

	private String checkId;

	private String payRefNo;

	private String voucherId;

	private String posNumber;

	private Double itemGST;

	private Double itemCGST;

	private Double itemSGST;

	private Double itemIGST;

	private Double availableStock;

	private String productionType;

	private String firstPayMode;

	private Double firstPayAmount;

	private Double secondPayAmount;
	
	private Double itemCess;

	public QuotationMasterModel() {
		super();
	}

	public QuotationMasterModel(Object quotationId, Object quotationName, Object customerId, Object customerName,
			Object qDescription, Object quotationVDate, Object qNote, Object qStatus, Object itemName, Object itemCode,
			Object unitPrice, Object quantity, Object qServeType, Object lineTotal, Object taxType, Object gstRate,
			Object subTotal, Object qIGST, Object qCGST, Object qSGST, Object grandTotal, Object approveActive,
			Object createdBy, Object purchaseOrder, Object pOrderDate, Object pOrderImage, Object salesOrder,
			Object sOrderDate, Object hotelName, Object hotelAddress, Object hotelCity, Object hotelPhn,
			Object hotelGSTIn, Object custName, Object custId, Object custAddress, Object custCountry, Object custGmail,
			Object custPhn, Object custGSTIn, Object invoiceType, Object salesOrderActive, Object discount,
			Object advAmount, Object payMode, Object transId, Object checkId, Object payRefNo, Object voucherId,
			Object posNumber, Object itemGST, Object itemCGST, Object itemSGST, Object itemIGST, Object availableStock,
			Object productionType, Object firstPayMode, Object firstPayAmount, Object secondPayAmount, Object itemCess) {
		super();
		try {
			this.quotationId = (String) quotationId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.quotationName = (String) quotationName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.customerId = (String) customerId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.customerName = (String) customerName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qDescription = (String) qDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.quotationVDate = (String) quotationVDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qNote = (String) qNote;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qStatus = (Boolean) qStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemName = (String) itemName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCode = (String) itemCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.unitPrice = (Double) unitPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.quantity = (Double) quantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qServeType = (String) qServeType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.lineTotal = (Double) lineTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.taxType = (Boolean) taxType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gstRate = (Double) gstRate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.subTotal = (Double) subTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qIGST = (Double) qIGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qCGST = (Double) qCGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qSGST = (Double) qSGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grandTotal = (Double) grandTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.approveActive = (Boolean) approveActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.purchaseOrder = (String) purchaseOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pOrderDate = (String) pOrderDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pOrderImage = (String) pOrderImage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.salesOrder = (String) salesOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sOrderDate = (String) sOrderDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.hotelName = (String) hotelName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.hotelAddress = (String) hotelAddress;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.hotelCity = (String) hotelCity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.hotelPhn = (String) hotelPhn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.hotelGSTIn = (String) hotelGSTIn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.custName = (String) custName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.custId = (String) custId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.custAddress = (String) custAddress;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.custCountry = (String) custCountry;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.custGmail = (String) custGmail;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.custPhn = (String) custPhn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.custGSTIn = (String) custGSTIn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.invoiceType = (Boolean) invoiceType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.salesOrderActive = (Boolean) salesOrderActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.discount = (Double) discount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.advAmount = (Double) advAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payMode = (String) payMode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.transId = (String) transId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.checkId = (String) checkId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payRefNo = (String) payRefNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.voucherId = (String) voucherId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.posNumber = (String) posNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemGST = (Double) itemGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCGST = (Double) itemCGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemSGST = (Double) itemSGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemIGST = (Double) itemIGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.availableStock = (Double) availableStock;
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.productionType = (String) productionType;
		try {
			this.firstPayMode = (String) firstPayMode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.firstPayAmount = (Double) firstPayAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.secondPayAmount = (Double) secondPayAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCess = (Double) itemCess;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getQuotationId() {
		return quotationId;
	}

	public String getProductionType() {
		return productionType;
	}

	public void setProductionType(String productionType) {
		this.productionType = productionType;
	}

	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}

	public String getQuotationName() {
		return quotationName;
	}

	public void setQuotationName(String quotationName) {
		this.quotationName = quotationName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getqDescription() {
		return qDescription;
	}

	public void setqDescription(String qDescription) {
		this.qDescription = qDescription;
	}

	public String getQuotationVDate() {
		return quotationVDate;
	}

	public void setQuotationVDate(String quotationVDate) {
		this.quotationVDate = quotationVDate;
	}

	public String getqNote() {
		return qNote;
	}

	public void setqNote(String qNote) {
		this.qNote = qNote;
	}

	public Boolean getqStatus() {
		return qStatus;
	}

	public void setqStatus(Boolean qStatus) {
		this.qStatus = qStatus;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getqServeType() {
		return qServeType;
	}

	public void setqServeType(String qServeType) {
		this.qServeType = qServeType;
	}

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getqIGST() {
		return qIGST;
	}

	public void setqIGST(Double qIGST) {
		this.qIGST = qIGST;
	}

	public Double getqCGST() {
		return qCGST;
	}

	public void setqCGST(Double qCGST) {
		this.qCGST = qCGST;
	}

	public Double getqSGST() {
		return qSGST;
	}

	public void setqSGST(Double qSGST) {
		this.qSGST = qSGST;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Boolean getApproveActive() {
		return approveActive;
	}

	public void setApproveActive(Boolean approveActive) {
		this.approveActive = approveActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getpOrderDate() {
		return pOrderDate;
	}

	public void setpOrderDate(String pOrderDate) {
		this.pOrderDate = pOrderDate;
	}

	public String getpOrderImage() {
		return pOrderImage;
	}

	public void setpOrderImage(String pOrderImage) {
		this.pOrderImage = pOrderImage;
	}

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	public String getsOrderDate() {
		return sOrderDate;
	}

	public void setsOrderDate(String sOrderDate) {
		this.sOrderDate = sOrderDate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getHotelPhn() {
		return hotelPhn;
	}

	public void setHotelPhn(String hotelPhn) {
		this.hotelPhn = hotelPhn;
	}

	public String getHotelGSTIn() {
		return hotelGSTIn;
	}

	public void setHotelGSTIn(String hotelGSTIn) {
		this.hotelGSTIn = hotelGSTIn;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustCountry() {
		return custCountry;
	}

	public void setCustCountry(String custCountry) {
		this.custCountry = custCountry;
	}

	public String getCustGmail() {
		return custGmail;
	}

	public void setCustGmail(String custGmail) {
		this.custGmail = custGmail;
	}

	public String getCustPhn() {
		return custPhn;
	}

	public void setCustPhn(String custPhn) {
		this.custPhn = custPhn;
	}

	public String getCustGSTIn() {
		return custGSTIn;
	}

	public void setCustGSTIn(String custGSTIn) {
		this.custGSTIn = custGSTIn;
	}

	public Boolean getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Boolean invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Boolean getSalesOrderActive() {
		return salesOrderActive;
	}

	public void setSalesOrderActive(Boolean salesOrderActive) {
		this.salesOrderActive = salesOrderActive;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getAdvAmount() {
		return advAmount;
	}

	public void setAdvAmount(Double advAmount) {
		this.advAmount = advAmount;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public String getPayRefNo() {
		return payRefNo;
	}

	public void setPayRefNo(String payRefNo) {
		this.payRefNo = payRefNo;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public String getPosNumber() {
		return posNumber;
	}

	public void setPosNumber(String posNumber) {
		this.posNumber = posNumber;
	}

	public Double getItemGST() {
		return itemGST;
	}

	public void setItemGST(Double itemGST) {
		this.itemGST = itemGST;
	}

	public Double getItemCGST() {
		return itemCGST;
	}

	public void setItemCGST(Double itemCGST) {
		this.itemCGST = itemCGST;
	}

	public Double getItemSGST() {
		return itemSGST;
	}

	public void setItemSGST(Double itemSGST) {
		this.itemSGST = itemSGST;
	}

	public Double getItemIGST() {
		return itemIGST;
	}

	public void setItemIGST(Double itemIGST) {
		this.itemIGST = itemIGST;
	}

	public Double getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Double availableStock) {
		this.availableStock = availableStock;
	}

	public String getFirstPayMode() {
		return firstPayMode;
	}

	public void setFirstPayMode(String firstPayMode) {
		this.firstPayMode = firstPayMode;
	}

	public Double getFirstPayAmount() {
		return firstPayAmount;
	}

	public void setFirstPayAmount(Double firstPayAmount) {
		this.firstPayAmount = firstPayAmount;
	}

	public Double getSecondPayAmount() {
		return secondPayAmount;
	}

	public void setSecondPayAmount(Double secondPayAmount) {
		this.secondPayAmount = secondPayAmount;
	}

	public Double getItemCess() {
		return itemCess;
	}

	public void setItemCess(Double itemCess) {
		this.itemCess = itemCess;
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
