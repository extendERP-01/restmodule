package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

public class RestInventoryGoodsReceiveModel {
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
	private String vehicleNo;
	private String driverName;
	private String mobileNo;
	private Double invPrice;
	private Double dGstRate;
	private Integer currentStageNo;
	private Integer approverStageNo;
	private Integer currentLevelNo;
	private Integer approverLevelNo;
	private Byte approveStatus;
	private String godown;
	private String vendor;
	private Double cessAmount;
	private Double totalCess;
	private Double totalAddCharges;
	private List<DropDownModel> addChargeDetails = null;
	private String inspectStatus;
	private String batchStatus;
	private Double inspectCount;
	private BigInteger allortmentCount;
	private BigInteger barcodeCount;

	@SuppressWarnings("unchecked")
	public RestInventoryGoodsReceiveModel(Object gRNInvoiceId, Object gRNPurchaseOrderId, Object gRNItmId,
			Object gRnInvoiceNumber, Object gRnInvoiceQuantity, Object gRnInvoiceDescription, Object gRnInvoiceActive,
			Object itmCategory, Object itmSubCategory, Object gRnInvoiceItmName, Object gRnPrice, Object createdOn,
			Object updatedOn, Object createdBy, Object porder, Object gstType, Object gstRate, Object gsubTotal,
			Object discount, Object sgst, Object cgst, Object igst, Object grandTotal, Object lineTotal,
			Object vendorName, Object invDate, Object dueDate, Object invImg, Object porderDate, Object itemName,
			Object vehicleNo, Object driverName, Object mobileNo, Object invPrice, Object dGstRate,
			Object currentStageNo, Object approverStageNo, Object currentLevelNo, Object approverLevelNo,
			Object approveStatus, Object godown, Object vendor, Object cessAmount, Object totalCess,
			Object totalAddCharges, Object addChargeDetails, Object inspectStatus, Object batchStatus) {
		super();
		this.gRNInvoiceId = (String) gRNInvoiceId;
		this.gRNPurchaseOrderId = (String) gRNPurchaseOrderId;
		this.gRNItmId = (String) gRNItmId;
		this.gRnInvoiceNumber = (String) gRnInvoiceNumber;
		this.gRnInvoiceQuantity = (Double) gRnInvoiceQuantity;
		this.gRnInvoiceDescription = (String) gRnInvoiceDescription;
		this.gRnInvoiceActive = (Boolean) gRnInvoiceActive;
		this.itmCategory = (String) itmCategory;
		this.itmSubCategory = (String) itmSubCategory;
		this.gRnInvoiceItmName = (String) gRnInvoiceItmName;
		this.gRnPrice = (Double) gRnPrice;
		this.createdOn = (String) createdOn;
		this.updatedOn = (String) updatedOn;
		this.createdBy = (String) createdBy;
		this.porder = (String) porder;
		this.gstType = (Boolean) gstType;
		this.gstRate = (Double) gstRate;
		this.gsubTotal = (Double) gsubTotal;
		this.discount = (Double) discount;
		this.sgst = (Double) sgst;
		this.cgst = (Double) cgst;
		this.igst = (Double) igst;
		this.grandTotal = (Double) grandTotal;
		this.lineTotal = (Double) lineTotal;
		this.vendorName = (String) vendorName;
		this.invDate = (String) invDate;
		this.dueDate = (String) dueDate;
		this.invImg = (String) invImg;
		this.porderDate = (String) porderDate;
		this.itemName = (String) itemName;
		this.vehicleNo = (String) vehicleNo;
		this.driverName = (String) driverName;
		this.mobileNo = (String) mobileNo;
		this.invPrice = (Double) invPrice;
		this.dGstRate = (Double) dGstRate;
		this.currentStageNo = (Integer) currentStageNo;
		this.approverStageNo = (Integer) approverStageNo;
		this.currentLevelNo = (Integer) currentLevelNo;
		this.approverLevelNo = (Integer) approverLevelNo;
		this.approveStatus = (Byte) approveStatus;
		this.godown = (String) godown;
		this.vendor = (String) vendor;
		this.cessAmount = (Double) cessAmount;
		this.totalCess = (Double) totalCess;
		this.totalAddCharges = (Double) totalAddCharges;
		this.addChargeDetails = (List<DropDownModel>) addChargeDetails;
		this.inspectStatus = (String) inspectStatus;
		this.batchStatus = (String) batchStatus;
	}

	public RestInventoryGoodsReceiveModel(Object gRNInvoiceId, Object gRNPurchaseOrderId, Object gRNItmId,
			Object gRnInvoiceNumber, Object gRnInvoiceQuantity, Object gRnInvoiceDescription, Object gRnInvoiceActive,
			Object itmCategory, Object itmSubCategory, Object gRnInvoiceItmName, Object gRnPrice, Object createdOn,
			Object updatedOn, Object createdBy, Object porder, Object gstType, Object gstRate, Object gsubTotal,
			Object discount, Object sgst, Object cgst, Object igst, Object grandTotal, Object lineTotal,
			Object vendorName, Object invDate, Object dueDate, Object invImg, Object porderDate, Object itemName,
			Object vehicleNo, Object driverName, Object mobileNo, Object invPrice, Object dGstRate,
			Object currentStageNo, Object approverStageNo, Object currentLevelNo, Object approverLevelNo,
			Object approveStatus, Object godown, Object vendor, Object cessAmount, Object totalCess,
			Object totalAddCharges, Object addChargeDetails, Object inspectStatus, Object batchStatus,
			Object inspectCount, Object allortmentCount ,Object barcodeCount) {
		super();
		this.gRNInvoiceId = (String) gRNInvoiceId;
		this.gRNPurchaseOrderId = (String) gRNPurchaseOrderId;
		this.gRNItmId = (String) gRNItmId;
		this.gRnInvoiceNumber = (String) gRnInvoiceNumber;
		this.gRnInvoiceQuantity = (Double) gRnInvoiceQuantity;
		this.gRnInvoiceDescription = (String) gRnInvoiceDescription;
		this.gRnInvoiceActive = (Boolean) gRnInvoiceActive;
		this.itmCategory = (String) itmCategory;
		this.itmSubCategory = (String) itmSubCategory;
		this.gRnInvoiceItmName = (String) gRnInvoiceItmName;
		this.gRnPrice = (Double) gRnPrice;
		this.createdOn = (String) createdOn;
		this.updatedOn = (String) updatedOn;
		this.createdBy = (String) createdBy;
		this.porder = (String) porder;
		this.gstType = (Boolean) gstType;
		this.gstRate = (Double) gstRate;
		this.gsubTotal = (Double) gsubTotal;
		this.discount = (Double) discount;
		this.sgst = (Double) sgst;
		this.cgst = (Double) cgst;
		this.igst = (Double) igst;
		this.grandTotal = (Double) grandTotal;
		this.lineTotal = (Double) lineTotal;
		this.vendorName = (String) vendorName;
		this.invDate = (String) invDate;
		this.dueDate = (String) dueDate;
		this.invImg = (String) invImg;
		this.porderDate = (String) porderDate;
		this.itemName = (String) itemName;
		this.vehicleNo = (String) vehicleNo;
		this.driverName = (String) driverName;
		this.mobileNo = (String) mobileNo;
		this.invPrice = (Double) invPrice;
		this.dGstRate = (Double) dGstRate;
		this.currentStageNo = (Integer) currentStageNo;
		this.approverStageNo = (Integer) approverStageNo;
		this.currentLevelNo = (Integer) currentLevelNo;
		this.approverLevelNo = (Integer) approverLevelNo;
		this.approveStatus = (Byte) approveStatus;
		this.godown = (String) godown;
		this.vendor = (String) vendor;
		this.cessAmount = (Double) cessAmount;
		this.totalCess = (Double) totalCess;
		this.totalAddCharges = (Double) totalAddCharges;
		this.addChargeDetails = (List<DropDownModel>) addChargeDetails;
		this.inspectStatus = (String) inspectStatus;
		this.batchStatus = (String) batchStatus;
		this.inspectCount = (Double) inspectCount;
		this.allortmentCount = (BigInteger) allortmentCount;
		this.barcodeCount = (BigInteger) barcodeCount;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public RestInventoryGoodsReceiveModel() {
		super();
	}

	public String getgRNInvoiceId() {
		return gRNInvoiceId;
	}

	public String getgRNPurchaseOrderId() {
		return gRNPurchaseOrderId;
	}

	public String getgRNItmId() {
		return gRNItmId;
	}

	public String getgRnInvoiceNumber() {
		return gRnInvoiceNumber;
	}

	public Double getgRnInvoiceQuantity() {
		return gRnInvoiceQuantity;
	}

	public String getgRnInvoiceDescription() {
		return gRnInvoiceDescription;
	}

	public Boolean getgRnInvoiceActive() {
		return gRnInvoiceActive;
	}

	public String getItmCategory() {
		return itmCategory;
	}

	public String getItmSubCategory() {
		return itmSubCategory;
	}

	public String getgRnInvoiceItmName() {
		return gRnInvoiceItmName;
	}

	public Double getgRnPrice() {
		return gRnPrice;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public String getGodown() {
		return godown;
	}

	public void setGodown(String godown) {
		this.godown = godown;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getPorder() {
		return porder;
	}

	public Boolean getGstType() {
		return gstType;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public Double getGsubTotal() {
		return gsubTotal;
	}

	public Double getDiscount() {
		return discount;
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

	public Double getLineTotal() {
		return lineTotal;
	}

	public String getVendorName() {
		return vendorName;
	}

	public String getInvDate() {
		return invDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getInvImg() {
		return invImg;
	}

	public String getPorderDate() {
		return porderDate;
	}

	public String getItemName() {
		return itemName;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public Double getInvPrice() {
		return invPrice;
	}

	public Double getdGstRate() {
		return dGstRate;
	}

	public Integer getCurrentStageNo() {
		return currentStageNo;
	}

	public Integer getApproverStageNo() {
		return approverStageNo;
	}

	public Integer getCurrentLevelNo() {
		return currentLevelNo;
	}

	public Integer getApproverLevelNo() {
		return approverLevelNo;
	}

	public Byte getApproveStatus() {
		return approveStatus;
	}

	public void setgRNInvoiceId(String gRNInvoiceId) {
		this.gRNInvoiceId = gRNInvoiceId;
	}

	public void setgRNPurchaseOrderId(String gRNPurchaseOrderId) {
		this.gRNPurchaseOrderId = gRNPurchaseOrderId;
	}

	public void setgRNItmId(String gRNItmId) {
		this.gRNItmId = gRNItmId;
	}

	public void setgRnInvoiceNumber(String gRnInvoiceNumber) {
		this.gRnInvoiceNumber = gRnInvoiceNumber;
	}

	public void setgRnInvoiceQuantity(Double gRnInvoiceQuantity) {
		this.gRnInvoiceQuantity = gRnInvoiceQuantity;
	}

	public void setgRnInvoiceDescription(String gRnInvoiceDescription) {
		this.gRnInvoiceDescription = gRnInvoiceDescription;
	}

	public void setgRnInvoiceActive(Boolean gRnInvoiceActive) {
		this.gRnInvoiceActive = gRnInvoiceActive;
	}

	public void setItmCategory(String itmCategory) {
		this.itmCategory = itmCategory;
	}

	public void setItmSubCategory(String itmSubCategory) {
		this.itmSubCategory = itmSubCategory;
	}

	public void setgRnInvoiceItmName(String gRnInvoiceItmName) {
		this.gRnInvoiceItmName = gRnInvoiceItmName;
	}

	public void setgRnPrice(Double gRnPrice) {
		this.gRnPrice = gRnPrice;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setPorder(String porder) {
		this.porder = porder;
	}

	public void setGstType(Boolean gstType) {
		this.gstType = gstType;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public void setGsubTotal(Double gsubTotal) {
		this.gsubTotal = gsubTotal;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
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

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void setInvImg(String invImg) {
		this.invImg = invImg;
	}

	public void setPorderDate(String porderDate) {
		this.porderDate = porderDate;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setInvPrice(Double invPrice) {
		this.invPrice = invPrice;
	}

	public void setdGstRate(Double dGstRate) {
		this.dGstRate = dGstRate;
	}

	public void setCurrentStageNo(Integer currentStageNo) {
		this.currentStageNo = currentStageNo;
	}

	public void setApproverStageNo(Integer approverStageNo) {
		this.approverStageNo = approverStageNo;
	}

	public void setCurrentLevelNo(Integer currentLevelNo) {
		this.currentLevelNo = currentLevelNo;
	}

	public void setApproverLevelNo(Integer approverLevelNo) {
		this.approverLevelNo = approverLevelNo;
	}

	public void setApproveStatus(Byte approveStatus) {
		this.approveStatus = approveStatus;
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

	public Double getTotalAddCharges() {
		return totalAddCharges;
	}

	public void setTotalAddCharges(Double totalAddCharges) {
		this.totalAddCharges = totalAddCharges;
	}

	public List<DropDownModel> getAddChargeDetails() {
		return addChargeDetails;
	}

	public void setAddChargeDetails(List<DropDownModel> addChargeDetails) {
		this.addChargeDetails = addChargeDetails;
	}

	public String getInspectStatus() {
		return inspectStatus;
	}

	public void setInspectStatus(String inspectStatus) {
		this.inspectStatus = inspectStatus;
	}

	public String getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public Double getInspectCount() {
		return inspectCount;
	}

	public void setInspectCount(Double inspectCount) {
		this.inspectCount = inspectCount;
	}

	public BigInteger getAllortmentCount() {
		return allortmentCount;
	}

	public void setAllortmentCount(BigInteger allortmentCount) {
		this.allortmentCount = allortmentCount;
	}

	public BigInteger getBarcodeCount() {
		return barcodeCount;
	}

	public void setBarcodeCount(BigInteger barcodeCount) {
		this.barcodeCount = barcodeCount;
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
