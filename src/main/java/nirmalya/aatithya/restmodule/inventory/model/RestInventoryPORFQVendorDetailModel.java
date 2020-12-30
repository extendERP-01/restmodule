package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestInventoryPORFQVendorDetailModel {
	
private String venQuotId;
	
	private String rfqNo;
	
	private String vendor;
	
	private String vendorName;

	private String qNote;
	
	private String itemId;
	
	private String itemName;
	
	private Boolean taxType;
	
	private Double gstRate;
	
	private Double subTotal;
	
	private Double unitPrice;

	private Double qIGST;
	
	private Double qCGST;
	
	private Double qSGST;
	
	private Double quantity;
	
	private Double lineTotal;
	
	private Double grandTotal; 
	
	private String createdBy;
	
	private Byte approveStatus;
	
	private String rfqName;
	
	private String quotName;
	
	private String quotValidity;
	
	private String logoName;
	
	private String action;
	
	private String subCat;
	
	private String category;
	
	

	
	
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

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public String getQuotName() {
		return quotName;
	}

	public void setQuotName(String quotName) {
		this.quotName = quotName;
	}

	public String getQuotValidity() {
		return quotValidity;
	}

	public void setQuotValidity(String quotValidity) {
		this.quotValidity = quotValidity;
	}

	public String getVenQuotId() {
		return venQuotId;
	}

	public void setVenQuotId(String venQuotId) {
		this.venQuotId = venQuotId;
	}

	public String getRfqNo() {
		return rfqNo;
	}

	public void setRfqNo(String rfqNo) {
		this.rfqNo = rfqNo;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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

	public String getRfqName() {
		return rfqName;
	}

	public void setRfqName(String rfqName) {
		this.rfqName = rfqName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
	public RestInventoryPORFQVendorDetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestInventoryPORFQVendorDetailModel(Object venQuotId,Object rfqNo, Object vendor
			,Object qNote, Object itemId, Object taxType,Object gstRate,Object subTotal,Object unitPrice,Object qIGST, Object qCGST,
			Object qSGST,Object quantity,Object lineTotal,Object grandTotal,Object itemName,Object vendorName,Object approveStatus,
			Object rfqName,Object quotName,Object quotValidity,Object logoName,Object subCat,Object category) {
		super();
		try {
			this.venQuotId = (String) venQuotId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.rfqNo = (String) rfqNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.vendor = (String) vendor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.qNote = (String) qNote;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.itemId = (String) itemId;
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
			this.unitPrice = (Double) unitPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.gstRate = (Double) gstRate;
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
			this.quantity = (Double) quantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.lineTotal = (Double) lineTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.grandTotal = (Double) grandTotal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			this.itemName = (String) itemName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.vendorName = (String) vendorName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.approveStatus = (Byte) approveStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			this.rfqName = (String) rfqName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			this.quotName = (String) quotName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.quotValidity = (String) quotValidity;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		try {
			this.logoName = (String) logoName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.subCat = (String) subCat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.category = (String) category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
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
