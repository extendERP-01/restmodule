package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestSalesDeliveryChallanModel {

	private String delChallanId;

	private String saleOrderNo;

	private String customerId;

	private String customerName;

	private String toPlace;

	private String fromPlace;

	private String delChallanDate;

	private String transName;

	private String transMoNo;

	private String transVehNo;

	private String qNote;

	private String itemId;

	private String itemName;

	private Boolean taxType;

	private Double gstRate;

	private Double subTotal;

	private Double advanceAmnt;

	private Double remainAmnt;

	private Double unitPrice;

	private Double qIGST;

	private Double qCGST;

	private Double qSGST;

	private Double quantity;

	private Double lineTotal;

	private Double grandTotal;

	private String createdBy;

	private Byte approveStatus;

	private String logoName;

	private String subCat;

	private String category;

	private String imageName;

	private String invoiceNo;

	private String purchaseOrderNo;

	private Double totalDelItem;

	private String itemCat;

	private String itemSubCat;

	private String itemCatName;

	private String itemSubCatName;

	private Double itemWt;

	private Double bundles;

	private Double itemDiscount;

	private Double totalDiscount;

	private Double totalSgst;

	private Double totalIgst;

	private Double totalCgst;

	private String storeId;
	private Double itemCess;
	private Double totalCess;

	public RestSalesDeliveryChallanModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestSalesDeliveryChallanModel(Object delChallanId, Object saleOrderNo, Object customerId,
			Object customerName, Object toPlace, Object fromPlace, Object delChallanDate, Object transName,
			Object transMoNo, Object transVehNo, Object itemId, Object itemName, Object unitPrice, Object quantity,
			Object lineTotal, Object subTotal, Object qIGST, Object qCGST, Object qSGST, Object grandTotal,
			Object taxType, Object qNote, Object approveStatus, Object imageName, Object gstRate, Object advanceAmnt,
			Object remainAmnt, Object invoiceNo, Object purchaseOrderNo, Object totalDelItem, Object itemCat,
			Object itemSubCat, Object itemCatName, Object itemSubCatName, Object itemWt, Object bundles, Object itemCess, Object totalCess) {
		super();
		try {
			this.delChallanId = (String) delChallanId;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.saleOrderNo = (String) saleOrderNo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.customerId = (String) customerId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.customerName = (String) customerName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.toPlace = (String) toPlace;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.fromPlace = (String) fromPlace;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.delChallanDate = (String) delChallanDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.transName = (String) transName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.transMoNo = (String) transMoNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.transVehNo = (String) transVehNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.itemId = (String) itemId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.itemName = (String) itemName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.unitPrice = (Double) unitPrice;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.quantity = (Double) quantity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.lineTotal = (Double) lineTotal;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.subTotal = (Double) subTotal;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.qIGST = (Double) qIGST;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.qCGST = (Double) qCGST;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.qSGST = (Double) qSGST;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.grandTotal = (Double) grandTotal;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.taxType = (Boolean) taxType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.qNote = (String) qNote;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.approveStatus = (Byte) approveStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.imageName = (String) imageName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.gstRate = (Double) gstRate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.advanceAmnt = (Double) advanceAmnt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.remainAmnt = (Double) remainAmnt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.invoiceNo = (String) invoiceNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.purchaseOrderNo = (String) purchaseOrderNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.totalDelItem = (Double) totalDelItem;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.itemCat = (String) itemCat;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.itemSubCat = (String) itemSubCat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCatName = (String) itemCatName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemSubCatName = (String) itemSubCatName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemWt = (Double) itemWt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.bundles = (Double) bundles;
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

	public Double getTotalDelItem() {
		return totalDelItem;
	}

	public void setTotalDelItem(Double totalDelItem) {
		this.totalDelItem = totalDelItem;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Double getAdvanceAmnt() {
		return advanceAmnt;
	}

	public void setAdvanceAmnt(Double advanceAmnt) {
		this.advanceAmnt = advanceAmnt;
	}

	public Double getRemainAmnt() {
		return remainAmnt;
	}

	public void setRemainAmnt(Double remainAmnt) {
		this.remainAmnt = remainAmnt;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getDelChallanId() {
		return delChallanId;
	}

	public void setDelChallanId(String delChallanId) {
		this.delChallanId = delChallanId;
	}

	public String getSaleOrderNo() {
		return saleOrderNo;
	}

	public void setSaleOrderNo(String saleOrderNo) {
		this.saleOrderNo = saleOrderNo;
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

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getDelChallanDate() {
		return delChallanDate;
	}

	public void setDelChallanDate(String delChallanDate) {
		this.delChallanDate = delChallanDate;
	}

	public String getTransName() {
		return transName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public String getTransMoNo() {
		return transMoNo;
	}

	public void setTransMoNo(String transMoNo) {
		this.transMoNo = transMoNo;
	}

	public String getTransVehNo() {
		return transVehNo;
	}

	public void setTransVehNo(String transVehNo) {
		this.transVehNo = transVehNo;
	}

	public String getqNote() {
		return qNote;
	}

	public void setqNote(String qNote) {
		this.qNote = qNote;
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

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Byte getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Byte approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public String getSubCat() {
		return subCat;
	}

	public void setSubCat(String subCat) {
		this.subCat = subCat;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemCat() {
		return itemCat;
	}

	public String getItemSubCat() {
		return itemSubCat;
	}

	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}

	public void setItemSubCat(String itemSubCat) {
		this.itemSubCat = itemSubCat;
	}

	public String getItemCatName() {
		return itemCatName;
	}

	public String getItemSubCatName() {
		return itemSubCatName;
	}

	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}

	public void setItemSubCatName(String itemSubCatName) {
		this.itemSubCatName = itemSubCatName;
	}

	public Double getItemWt() {
		return itemWt;
	}

	public void setItemWt(Double itemWt) {
		this.itemWt = itemWt;
	}

	public Double getBundles() {
		return bundles;
	}

	public void setBundles(Double bundles) {
		this.bundles = bundles;
	}

	public Double getItemDiscount() {
		return itemDiscount;
	}

	public void setItemDiscount(Double itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

	public Double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Double getTotalSgst() {
		return totalSgst;
	}

	public void setTotalSgst(Double totalSgst) {
		this.totalSgst = totalSgst;
	}

	public Double getTotalIgst() {
		return totalIgst;
	}

	public void setTotalIgst(Double totalIgst) {
		this.totalIgst = totalIgst;
	}

	public Double getTotalCgst() {
		return totalCgst;
	}

	public void setTotalCgst(Double totalCgst) {
		this.totalCgst = totalCgst;
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
