package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class InventoryGoodsReturnsNoteModel {
	private String goodsReturnNote;
	private String purchaseOrder;
	private String gRNInvoiceId;
	private String gRtNDescription;
	private Boolean gRtNActive;
	private String itemCategory;
	private String itemSubCategory;
	private String itemId;
	private Double gRtNQty;
	private String itemName;
	private Double price;
	private String invNo;
	private String gRtN_CreatedOn;
	private String serveUnit;
	private Double quantityReceived;
	private String vendorName;
	private String vendorAddr;
	private String gRDtlsCreatedBy;
	private String porder;
	private String invNumber;
	private Double gsubTotal;
	private Double lineTotal;
	private Double discount;
	private Double rcvSubTotal;
	private Boolean gstType;
	private Double gstRate;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private Double grandTotal;
	private Double cessAmount;
	private Double totalCess;

	public InventoryGoodsReturnsNoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryGoodsReturnsNoteModel(Object goodsReturnNote, Object purchaseOrder, Object gRNInvoiceId,
			Object gRtNDescription, Object gRtNActive, Object itemCategory, Object itemSubCategory, Object itemId,
			Object gRtNQty, Object itemName, Object price, Object invNo, Object gRtN_CreatedOn, Object serveUnit,
			Object quantityReceived, Object vendorName, Object vendorAddr, Object gRDtlsCreatedBy, Object porder,
			Object invNumber, Object gsubTotal, Object lineTotal, Object discount, Object rcvSubTotal, Object gstType,
			Object gstRate, Object sgst, Object cgst, Object igst, Object grandTotal, Object cessAmount, Object totalCess) {
		super();
		try {
			this.goodsReturnNote = (String) goodsReturnNote;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.purchaseOrder = (String) purchaseOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRNInvoiceId = (String) gRNInvoiceId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRtNDescription = (String) gRtNDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRtNActive = (Boolean) gRtNActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCategory = (String) itemCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemSubCategory = (String) itemSubCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemId = (String) itemId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRtNQty = (Double) gRtNQty;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemName = (String) itemName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.price = (Double) price;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.invNo = (String) invNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRtN_CreatedOn = (String) gRtN_CreatedOn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.serveUnit = (String) serveUnit;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.quantityReceived = (Double) quantityReceived;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.vendorName = (String) vendorName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.vendorAddr = (String) vendorAddr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gRDtlsCreatedBy = (String) gRDtlsCreatedBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.porder = (String) porder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.invNumber = (String) invNumber;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gsubTotal = (Double) gsubTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.lineTotal = (Double) lineTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.discount = (Double) discount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.rcvSubTotal = (Double) rcvSubTotal;
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
			this.cessAmount = (Double) cessAmount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.totalCess = (Double) totalCess;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getGoodsReturnNote() {
		return goodsReturnNote;
	}

	public void setGoodsReturnNote(String goodsReturnNote) {
		this.goodsReturnNote = goodsReturnNote;
	}

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getgRtNDescription() {
		return gRtNDescription;
	}

	public void setgRtNDescription(String gRtNDescription) {
		this.gRtNDescription = gRtNDescription;
	}

	public Boolean getgRtNActive() {
		return gRtNActive;
	}

	public void setgRtNActive(Boolean gRtNActive) {
		this.gRtNActive = gRtNActive;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemSubCategory() {
		return itemSubCategory;
	}

	public void setItemSubCategory(String itemSubCategory) {
		this.itemSubCategory = itemSubCategory;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Double getgRtNQty() {
		return gRtNQty;
	}

	public void setgRtNQty(Double gRtNQty) {
		this.gRtNQty = gRtNQty;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getgRtN_CreatedOn() {
		return gRtN_CreatedOn;
	}

	public void setgRtN_CreatedOn(String gRtN_CreatedOn) {
		this.gRtN_CreatedOn = gRtN_CreatedOn;
	}

	public String getServeUnit() {
		return serveUnit;
	}

	public void setServeUnit(String serveUnit) {
		this.serveUnit = serveUnit;
	}

	public Double getQuantityReceived() {
		return quantityReceived;
	}

	public void setQuantityReceived(Double quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddr() {
		return vendorAddr;
	}

	public void setVendorAddr(String vendorAddr) {
		this.vendorAddr = vendorAddr;
	}

	public String getgRDtlsCreatedBy() {
		return gRDtlsCreatedBy;
	}

	public void setgRDtlsCreatedBy(String gRDtlsCreatedBy) {
		this.gRDtlsCreatedBy = gRDtlsCreatedBy;
	}

	public String getPorder() {
		return porder;
	}

	public void setPorder(String porder) {
		this.porder = porder;
	}

	public String getInvNumber() {
		return invNumber;
	}

	public void setInvNumber(String invNumber) {
		this.invNumber = invNumber;
	}

	public Double getGsubTotal() {
		return gsubTotal;
	}

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setGsubTotal(Double gsubTotal) {
		this.gsubTotal = gsubTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getRcvSubTotal() {
		return rcvSubTotal;
	}

	public void setRcvSubTotal(Double rcvSubTotal) {
		this.rcvSubTotal = rcvSubTotal;
	}

	public Boolean getGstType() {
		return gstType;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public void setGstType(Boolean gstType) {
		this.gstType = gstType;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public Double getSgst() {
		return sgst;
	}

	public Double getCgst() {
		return cgst;
	}

	public Double getIgst() {
		return igst;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Double getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(Double cessAmount) {
		this.cessAmount = cessAmount;
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
