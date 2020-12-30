package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AllocateItemsToRackModel {
	private String poNo;
	private String grn;
	private String storeId;
	private String storeName;
	private String subInventoryId;
	private String subInventoryName;
	private String wareHouseId;
	private String wareHouseName;
	private String itemName;

	private String itemId;
	private Double quantity;
	private String shelfId;
	private String shelfName;
	private String barcodeNo;
	private String barCodeImageName;
	private String action;
	private String cratedBy;
	private String rackId;
	private String rackName;
	private Double inspQuantity;

	public AllocateItemsToRackModel() {
		super();
	}

	public AllocateItemsToRackModel(Object quantity, Object shelfId, Object shelfName, Object rackId, Object rackName) {

		this.quantity = (Double) quantity;
		this.shelfId = (String) shelfId;
		this.shelfName = (String) shelfName;
		this.rackId = (String) rackId;
		this.rackName = (String) rackName;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getGrn() {
		return grn;
	}

	public void setGrn(String grn) {
		this.grn = grn;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getSubInventoryId() {
		return subInventoryId;
	}

	public void setSubInventoryId(String subInventoryId) {
		this.subInventoryId = subInventoryId;
	}

	public String getSubInventoryName() {
		return subInventoryName;
	}

	public void setSubInventoryName(String subInventoryName) {
		this.subInventoryName = subInventoryName;
	}

	public String getWareHouseId() {
		return wareHouseId;
	}

	public void setWareHouseId(String wareHouseId) {
		this.wareHouseId = wareHouseId;
	}

	public String getWareHouseName() {
		return wareHouseName;
	}

	public void setWareHouseName(String wareHouseName) {
		this.wareHouseName = wareHouseName;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getShelfId() {
		return shelfId;
	}

	public void setShelfId(String shelfId) {
		this.shelfId = shelfId;
	}

	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	public String getBarcodeNo() {
		return barcodeNo;
	}

	public void setBarcodeNo(String barcodeNo) {
		this.barcodeNo = barcodeNo;
	}

	public String getBarCodeImageName() {
		return barCodeImageName;
	}

	public void setBarCodeImageName(String barCodeImageName) {
		this.barCodeImageName = barCodeImageName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCratedBy() {
		return cratedBy;
	}

	public void setCratedBy(String cratedBy) {
		this.cratedBy = cratedBy;
	}

	public String getRackId() {
		return rackId;
	}

	public void setRackId(String rackId) {
		this.rackId = rackId;
	}

	public String getRackName() {
		return rackName;
	}

	public void setRackName(String rackName) {
		this.rackName = rackName;
	}

	public Double getInspQuantity() {
		return inspQuantity;
	}

	public void setInspQuantity(Double inspQuantity) {
		this.inspQuantity = inspQuantity;
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
