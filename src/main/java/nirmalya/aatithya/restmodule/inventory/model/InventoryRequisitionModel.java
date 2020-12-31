package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryRequisitionModel {

	private String reqId;
	private String desc;
	private String reqType;
	private String reqPrior;
	private String receiveDate;
	private String holdStatus;

	private String sku;
	private String brand;
	private String itemName;
	private String itemId;
	private String model;
	private String itemCategoryId;
	private String itemCategoryName;
	private String uom;
	private Double qty;
	private String lastPoDate;
	private Double estimatedPrice;
	private Double estimatedTotalPrice;
	private Double lastPurchaseUnitPrice;
	private Double lastPurchaseTotalPrice;
	private String createdBy;
	private String createdOn;
	private String updatedon;
	private String updatedBy;
	private String costCenter;
	private String location;
	private String uomId;
	private String locationId;
	private String costCenterId;
	public InventoryRequisitionModel() {
		super();
	}

	public InventoryRequisitionModel(Object sku, Object brand, Object itemName, Object itemId, Object model,
			Object itemCategoryId, Object itemCategoryName, Object uom, Object qty, Object lastPoDate,
			Object estimatedPrice, Object lastPurchaseUnitPrice) {
		super();

		this.sku = (String) sku;
		this.brand = (String) brand;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.model = (String) model;
		this.itemCategoryId = (String) itemCategoryId;
		this.itemCategoryName = (String) itemCategoryName;
		this.uom = (String) uom;
		this.qty = (Double) qty;
		this.lastPoDate = (String) lastPoDate;
		this.estimatedPrice = (Double) estimatedPrice;
		this.lastPurchaseUnitPrice = (Double) lastPurchaseUnitPrice;

	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getReqPrior() {
		return reqPrior;
	}

	public void setReqPrior(String reqPrior) {
		this.reqPrior = reqPrior;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getHoldStatus() {
		return holdStatus;
	}

	public void setHoldStatus(String holdStatus) {
		this.holdStatus = holdStatus;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(String itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public String getLastPoDate() {
		return lastPoDate;
	}

	public void setLastPoDate(String lastPoDate) {
		this.lastPoDate = lastPoDate;
	}

	public Double getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(Double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getEstimatedTotalPrice() {
		return estimatedTotalPrice;
	}

	public void setEstimatedTotalPrice(Double estimatedTotalPrice) {
		this.estimatedTotalPrice = estimatedTotalPrice;
	}

	public Double getLastPurchaseUnitPrice() {
		return lastPurchaseUnitPrice;
	}

	public void setLastPurchaseUnitPrice(Double lastPurchaseUnitPrice) {
		this.lastPurchaseUnitPrice = lastPurchaseUnitPrice;
	}

	public Double getLastPurchaseTotalPrice() {
		return lastPurchaseTotalPrice;
	}

	public void setLastPurchaseTotalPrice(Double lastPurchaseTotalPrice) {
		this.lastPurchaseTotalPrice = lastPurchaseTotalPrice;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(String costCenterId) {
		this.costCenterId = costCenterId;
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
