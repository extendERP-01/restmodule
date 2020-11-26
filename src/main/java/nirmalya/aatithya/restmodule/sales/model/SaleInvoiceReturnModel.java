package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SaleInvoiceReturnModel {

	private String saleInvReturn;
	
	private String salesOrderId;
	
	private String salesOrder;
	
	private String saleInvId;
	
	private String saleInv;
	
	private String saleInvReturnDesc;
	
	private String sRItemCode;
	
	private String sRItemName;
	
	private Double sRItemPrice;
	
	private Double sRItemQty;
	
	private String sRServeTypeId;
	
	private String sRServeType;
	
	private Double sRAmount;
	
	private Double subTotal;
	
	private Double sRCGST;
	
	private Double sRSGST;
	
	private Double sRIGST;
	
	private Double grandTotal;
	
	private Double gstRate;
	
	private Boolean gstType;
	
	private String createdBy;
	
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
	
	private String invoiceRtnDate;
	
	private String costCenter;
	
	private Boolean payStatus;
	
	private Double sRDiscount;
	private Double saleQty;
	
	private Double itemCess;
	private Double totalCess;
	private Double saleDiscount;

	public SaleInvoiceReturnModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleInvoiceReturnModel(Object saleInvReturn, Object salesOrderId, Object salesOrder, Object saleInvId,
			Object saleInv, Object saleInvReturnDesc, Object sRItemCode, Object sRItemName, Object sRItemPrice,
			Object sRItemQty, Object sRServeTypeId, Object sRServeType, Object sRAmount, Object subTotal, Object sRCGST,
			Object sRSGST, Object sRIGST, Object grandTotal, Object gstRate, Object gstType, Object createdBy,
			Object hotelName, Object hotelAddress, Object hotelCity, Object hotelPhn, Object hotelGSTIn,
			Object custName, Object custId, Object custAddress, Object custCountry, Object custGmail, Object custPhn,
			Object custGSTIn, Object invoiceRtnDate, Object costCenter, Object payStatus, Object sRDiscount, Object saleQty, 
			Object itemCess, Object totalCess, Object saleDiscount) {
		super();
		try {
			this.saleInvReturn = (String) saleInvReturn;
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
			this.saleInvId = (String) saleInvId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleInv = (String) saleInv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleInvReturnDesc = (String) saleInvReturnDesc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRItemCode = (String) sRItemCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRItemName = (String) sRItemName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRItemPrice = (Double) sRItemPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRItemQty = (Double) sRItemQty;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRServeTypeId = (String) sRServeTypeId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRServeType = (String) sRServeType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRAmount = (Double) sRAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.subTotal = (Double) subTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRCGST = (Double) sRCGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRSGST = (Double) sRSGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRIGST = (Double) sRIGST;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grandTotal = (Double) grandTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gstRate = (Double) gstRate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gstType = (Boolean) gstType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
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
			this.invoiceRtnDate = (String) invoiceRtnDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.costCenter = (String) costCenter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.payStatus = (Boolean) payStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sRDiscount = (Double) sRDiscount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.saleQty = (Double) saleQty;
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
		try {
			this.saleDiscount = (Double) saleDiscount;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSaleInvReturn() {
		return saleInvReturn;
	}

	public void setSaleInvReturn(String saleInvReturn) {
		this.saleInvReturn = saleInvReturn;
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

	public String getSaleInvId() {
		return saleInvId;
	}

	public void setSaleInvId(String saleInvId) {
		this.saleInvId = saleInvId;
	}

	public String getSaleInv() {
		return saleInv;
	}

	public void setSaleInv(String saleInv) {
		this.saleInv = saleInv;
	}

	public String getSaleInvReturnDesc() {
		return saleInvReturnDesc;
	}

	public void setSaleInvReturnDesc(String saleInvReturnDesc) {
		this.saleInvReturnDesc = saleInvReturnDesc;
	}

	public String getsRItemCode() {
		return sRItemCode;
	}

	public void setsRItemCode(String sRItemCode) {
		this.sRItemCode = sRItemCode;
	}

	public String getsRItemName() {
		return sRItemName;
	}

	public void setsRItemName(String sRItemName) {
		this.sRItemName = sRItemName;
	}

	public Double getsRItemPrice() {
		return sRItemPrice;
	}

	public void setsRItemPrice(Double sRItemPrice) {
		this.sRItemPrice = sRItemPrice;
	}

	public Double getsRItemQty() {
		return sRItemQty;
	}

	public void setsRItemQty(Double sRItemQty) {
		this.sRItemQty = sRItemQty;
	}

	public String getsRServeTypeId() {
		return sRServeTypeId;
	}

	public void setsRServeTypeId(String sRServeTypeId) {
		this.sRServeTypeId = sRServeTypeId;
	}

	public String getsRServeType() {
		return sRServeType;
	}

	public void setsRServeType(String sRServeType) {
		this.sRServeType = sRServeType;
	}

	public Double getsRAmount() {
		return sRAmount;
	}

	public void setsRAmount(Double sRAmount) {
		this.sRAmount = sRAmount;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getsRCGST() {
		return sRCGST;
	}

	public void setsRCGST(Double sRCGST) {
		this.sRCGST = sRCGST;
	}

	public Double getsRSGST() {
		return sRSGST;
	}

	public void setsRSGST(Double sRSGST) {
		this.sRSGST = sRSGST;
	}

	public Double getsRIGST() {
		return sRIGST;
	}

	public void setsRIGST(Double sRIGST) {
		this.sRIGST = sRIGST;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public Boolean getGstType() {
		return gstType;
	}

	public void setGstType(Boolean gstType) {
		this.gstType = gstType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public String getInvoiceRtnDate() {
		return invoiceRtnDate;
	}

	public void setInvoiceRtnDate(String invoiceRtnDate) {
		this.invoiceRtnDate = invoiceRtnDate;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public Boolean getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Boolean payStatus) {
		this.payStatus = payStatus;
	}

	public Double getsRDiscount() {
		return sRDiscount;
	}

	public void setsRDiscount(Double sRDiscount) {
		this.sRDiscount = sRDiscount;
	}

	public Double getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(Double saleQty) {
		this.saleQty = saleQty;
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

	public Double getSaleDiscount() {
		return saleDiscount;
	}

	public void setSaleDiscount(Double saleDiscount) {
		this.saleDiscount = saleDiscount;
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
