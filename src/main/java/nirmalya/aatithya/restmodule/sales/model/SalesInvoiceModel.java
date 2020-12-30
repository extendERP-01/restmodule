package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SalesInvoiceModel {

	private String salesInvoice;

	private String salesOrderId;

	private String salesOrder;

	private String purchaseOrder;

	private String quotationId;

	private String saleInvNote;

	private Boolean gstType;

	private Double gstRate;

	private Double subTotal;

	private Double sIGST;

	private Double sCGST;

	private Double sSGST;

	private Double grandTotal;

	private String saleItem;

	private String saleItemCode;

	private Double salePrice;

	private Double saleQuantity;

	private String sServeType;

	private Double saleAmount;

	private String createdBy;

	private String payMode;

	private String payRefNo;

	private String transactionId;

	private String transactionDate;

	private Boolean payStatus;

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

	private String invoiceDate;

	private String voucherId;

	private Boolean saleInvoiceType;

	private Double saleDiscount;

	private Double payableAmt;

	private Double advanceAmt;

	private String checkNumber;

	private String contraReceipt;

	private String posNumber;

	private Boolean paymentType;

	private Double outstndngAmt;

	private Double itemWt;
	private String payMode1;
	private String payMode2;
	private Double cardAmount;
	private Double cashAmount;
	private String storeId;
	
	private Double itemCess;
	private Double totalCess;

	public SalesInvoiceModel() {
		super();
	}

	public SalesInvoiceModel(Object salesInvoice, Object salesOrderId, Object salesOrder, Object purchaseOrder,
			Object quotationId, Object saleInvNote, Object gstType, Object gstRate, Object subTotal, Object sIGST,
			Object sCGST, Object sSGST, Object grandTotal, Object saleItem, Object saleItemCode, Object salePrice,
			Object saleQuantity, Object sServeType, Object saleAmount, Object createdBy, Object payMode,
			Object payRefNo, Object transactionId, Object transactionDate, Object payStatus, Object hotelName,
			Object hotelAddress, Object hotelCity, Object hotelPhn, Object hotelGSTIn, Object custName, Object custId,
			Object custAddress, Object custCountry, Object custGmail, Object custPhn, Object custGSTIn,
			Object invoiceDate, Object voucherId, Object saleInvoiceType, Object saleDiscount, Object payableAmt,
			Object advanceAmt, Object checkNumber, Object contraReceipt, Object posNumber, Object paymentType,
			Object outstndngAmt, Object itemWt, Object payMode1, Object payMode2, Object cardAmount, Object cashAmount,
			Object storeId, Object itemCess, Object totalCess) {
		super();
		try {
			this.salesInvoice = (String) salesInvoice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.salesOrderId = (String) salesOrderId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.salesOrder = (String) salesOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.purchaseOrder = (String) purchaseOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.quotationId = (String) quotationId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleInvNote = (String) saleInvNote;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gstType = (Boolean) gstType;
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
			this.sIGST = (Double) sIGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sCGST = (Double) sCGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sSGST = (Double) sSGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grandTotal = (Double) grandTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleItem = (String) saleItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleItemCode = (String) saleItemCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.salePrice = (Double) salePrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleQuantity = (Double) saleQuantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sServeType = (String) sServeType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleAmount = (Double) saleAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payMode = (String) payMode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payRefNo = (String) payRefNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.transactionId = (String) transactionId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.transactionDate = (String) transactionDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payStatus = (Boolean) payStatus;
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
			this.invoiceDate = (String) invoiceDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.voucherId = (String) voucherId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleInvoiceType = (Boolean) saleInvoiceType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleDiscount = (Double) saleDiscount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payableAmt = (Double) payableAmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.advanceAmt = (Double) advanceAmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.checkNumber = (String) checkNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.contraReceipt = (String) contraReceipt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.posNumber = (String) posNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.paymentType = (Boolean) paymentType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.outstndngAmt = (Double) outstndngAmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemWt = (Double) itemWt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payMode1 = (String) payMode1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payMode2 = (String) payMode2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.cardAmount = (Double) cardAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.cashAmount = (Double) cashAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.storeId = (String) storeId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCess = (Double) itemCess;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.totalCess = (Double) totalCess;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPayMode1() {
		return payMode1;
	}

	public void setPayMode1(String payMode1) {
		this.payMode1 = payMode1;
	}

	public String getPayMode2() {
		return payMode2;
	}

	public void setPayMode2(String payMode2) {
		this.payMode2 = payMode2;
	}

	public String getSalesInvoice() {
		return salesInvoice;
	}

	public void setSalesInvoice(String salesInvoice) {
		this.salesInvoice = salesInvoice;
	}

	public String getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}

	public String getSaleInvNote() {
		return saleInvNote;
	}

	public void setSaleInvNote(String saleInvNote) {
		this.saleInvNote = saleInvNote;
	}

	public Boolean getGstType() {
		return gstType;
	}

	public void setGstType(Boolean gstType) {
		this.gstType = gstType;
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

	public Double getsIGST() {
		return sIGST;
	}

	public void setsIGST(Double sIGST) {
		this.sIGST = sIGST;
	}

	public Double getsCGST() {
		return sCGST;
	}

	public void setsCGST(Double sCGST) {
		this.sCGST = sCGST;
	}

	public Double getsSGST() {
		return sSGST;
	}

	public void setsSGST(Double sSGST) {
		this.sSGST = sSGST;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getSaleItem() {
		return saleItem;
	}

	public void setSaleItem(String saleItem) {
		this.saleItem = saleItem;
	}

	public String getSaleItemCode() {
		return saleItemCode;
	}

	public void setSaleItemCode(String saleItemCode) {
		this.saleItemCode = saleItemCode;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getSaleQuantity() {
		return saleQuantity;
	}

	public void setSaleQuantity(Double saleQuantity) {
		this.saleQuantity = saleQuantity;
	}

	public Double getCardAmount() {
		return cardAmount;
	}

	public void setCardAmount(Double cardAmount) {
		this.cardAmount = cardAmount;
	}

	public Double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public String getsServeType() {
		return sServeType;
	}

	public void setsServeType(String sServeType) {
		this.sServeType = sServeType;
	}

	public Double getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(Double saleAmount) {
		this.saleAmount = saleAmount;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getPayRefNo() {
		return payRefNo;
	}

	public void setPayRefNo(String payRefNo) {
		this.payRefNo = payRefNo;
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

	public Boolean getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Boolean payStatus) {
		this.payStatus = payStatus;
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

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public Boolean getSaleInvoiceType() {
		return saleInvoiceType;
	}

	public void setSaleInvoiceType(Boolean saleInvoiceType) {
		this.saleInvoiceType = saleInvoiceType;
	}

	public Double getSaleDiscount() {
		return saleDiscount;
	}

	public void setSaleDiscount(Double saleDiscount) {
		this.saleDiscount = saleDiscount;
	}

	public Double getPayableAmt() {
		return payableAmt;
	}

	public void setPayableAmt(Double payableAmt) {
		this.payableAmt = payableAmt;
	}

	public Double getAdvanceAmt() {
		return advanceAmt;
	}

	public void setAdvanceAmt(Double advanceAmt) {
		this.advanceAmt = advanceAmt;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getContraReceipt() {
		return contraReceipt;
	}

	public void setContraReceipt(String contraReceipt) {
		this.contraReceipt = contraReceipt;
	}

	public String getPosNumber() {
		return posNumber;
	}

	public void setPosNumber(String posNumber) {
		this.posNumber = posNumber;
	}

	public Boolean getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Boolean paymentType) {
		this.paymentType = paymentType;
	}

	public Double getOutstndngAmt() {
		return outstndngAmt;
	}

	public void setOutstndngAmt(Double outstndngAmt) {
		this.outstndngAmt = outstndngAmt;
	}

	public Double getItemWt() {
		return itemWt;
	}

	public void setItemWt(Double itemWt) {
		this.itemWt = itemWt;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Double getItemCess() {
		return itemCess;
	}

	public void setItemCess(Double itemCess) {
		this.itemCess = itemCess;
	}

	public Double getTotalCess() {
		return totalCess;
	}

	public void setTotalCess(Double totalCess) {
		this.totalCess = totalCess;
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
