package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InvGoodsReceiveModel {
	private String gRNInvoiceId;
	private String gRNPurchaseOrderId;
	private String gRNItmId;
	private String gRnInvoiceNumber;
	private Double gRnInvoiceQuantity;
	private String gRnInvoiceDescription;
	private Boolean gRnInvoiceActive;
	private String itmCategory;
	private String itmSubCategory;
	private String gRnInvoiceItmName;
	private Double gRnPrice;
	private String createdOn;
	private String updatedOn;
	private String createdBy;
	private String porder;
	private Boolean gstType;
	private Double gstRate;
	private Double gsubTotal;
	private Double discount;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private Double grandTotal;
	private Double lineTotal;
	private String vendorName;
	private String invDate;
	private String dueDate;
	private String invImg;
	private String porderDate;
	private String itemName;

	public InvGoodsReceiveModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvGoodsReceiveModel(Object gRNInvoiceId, Object gRNPurchaseOrderId, Object gRNItmId,
			Object gRnInvoiceNumber, Object gRnInvoiceQuantity, Object gRnInvoiceDescription, Object gRnInvoiceActive,
			Object itmCategory, Object itmSubCategory, Object gRnInvoiceItmName, Object gRnPrice, Object createdOn,
			Object updatedOn, Object createdBy, Object porder, Object gstType, Object gstRate, Object gsubTotal,
			Object discount, Object sgst, Object cgst, Object igst, Object grandTotal, Object lineTotal,
			Object vendorName, Object invDate, Object dueDate, Object invImg, Object porderDate, Object itemName) {
		super();
		try {
			this.gRNInvoiceId = (String) gRNInvoiceId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRNPurchaseOrderId = (String) gRNPurchaseOrderId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRNItmId = (String) gRNItmId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRnInvoiceNumber = (String) gRnInvoiceNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRnInvoiceQuantity = (Double) gRnInvoiceQuantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRnInvoiceDescription = (String) gRnInvoiceDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRnInvoiceActive = (Boolean) gRnInvoiceActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itmCategory = (String) itmCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itmSubCategory = (String) itmSubCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRnInvoiceItmName = (String) gRnInvoiceItmName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRnPrice = (Double) gRnPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdOn = (String) createdOn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.updatedOn = (String) updatedOn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.porder = (String) porder;
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
			this.gsubTotal = (Double) gsubTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.discount = (Double) discount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sgst = (Double) sgst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.cgst = (Double) cgst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.igst = (Double) igst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grandTotal = (Double) grandTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.lineTotal = (Double) lineTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.vendorName = (String) vendorName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.invDate = (String) invDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dueDate = (String) dueDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.invImg = (String) invImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.porderDate = (String) porderDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemName = (String) itemName;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getgRNInvoiceId() {
		return gRNInvoiceId;
	}

	public void setgRNInvoiceId(String gRNInvoiceId) {
		this.gRNInvoiceId = gRNInvoiceId;
	}

	public String getgRNPurchaseOrderId() {
		return gRNPurchaseOrderId;
	}

	public void setgRNPurchaseOrderId(String gRNPurchaseOrderId) {
		this.gRNPurchaseOrderId = gRNPurchaseOrderId;
	}

	public String getgRNItmId() {
		return gRNItmId;
	}

	public void setgRNItmId(String gRNItmId) {
		this.gRNItmId = gRNItmId;
	}

	public String getgRnInvoiceNumber() {
		return gRnInvoiceNumber;
	}

	public void setgRnInvoiceNumber(String gRnInvoiceNumber) {
		this.gRnInvoiceNumber = gRnInvoiceNumber;
	}

	public Double getgRnInvoiceQuantity() {
		return gRnInvoiceQuantity;
	}

	public void setgRnInvoiceQuantity(Double gRnInvoiceQuantity) {
		this.gRnInvoiceQuantity = gRnInvoiceQuantity;
	}

	public String getgRnInvoiceDescription() {
		return gRnInvoiceDescription;
	}

	public void setgRnInvoiceDescription(String gRnInvoiceDescription) {
		this.gRnInvoiceDescription = gRnInvoiceDescription;
	}

	public Boolean getgRnInvoiceActive() {
		return gRnInvoiceActive;
	}

	public void setgRnInvoiceActive(Boolean gRnInvoiceActive) {
		this.gRnInvoiceActive = gRnInvoiceActive;
	}

	public String getItmCategory() {
		return itmCategory;
	}

	public void setItmCategory(String itmCategory) {
		this.itmCategory = itmCategory;
	}

	public String getItmSubCategory() {
		return itmSubCategory;
	}

	public void setItmSubCategory(String itmSubCategory) {
		this.itmSubCategory = itmSubCategory;
	}

	public String getgRnInvoiceItmName() {
		return gRnInvoiceItmName;
	}

	public void setgRnInvoiceItmName(String gRnInvoiceItmName) {
		this.gRnInvoiceItmName = gRnInvoiceItmName;
	}

	public Double getgRnPrice() {
		return gRnPrice;
	}

	public void setgRnPrice(Double gRnPrice) {
		this.gRnPrice = gRnPrice;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getPorder() {
		return porder;
	}

	public void setPorder(String porder) {
		this.porder = porder;
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

	public Double getGsubTotal() {
		return gsubTotal;
	}

	public void setGsubTotal(Double gsubTotal) {
		this.gsubTotal = gsubTotal;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
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

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getPorderDate() {
		return porderDate;
	}

	public void setPorderDate(String porderDate) {
		this.porderDate = porderDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getInvImg() {
		return invImg;
	}

	public void setInvImg(String invImg) {
		this.invImg = invImg;
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
