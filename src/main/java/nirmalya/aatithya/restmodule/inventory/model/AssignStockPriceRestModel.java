package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AssignStockPriceRestModel {

	private String storeName;
	private String storeId;
	private String itemName;
	private String itemId;
	private Double itemSalePrice;
	private Double itemSpecialPrice;
	private Double priceAll;
	private String selectType;
	private String createdBy;

	public AssignStockPriceRestModel() {
		super(); 
	}

	public AssignStockPriceRestModel(Object storeName, Object storeId, Object itemName, Object itemId,
			Object itemSalePrice, Object itemSpecialPrice, Object createdBy) {
		super();
		this.storeName = (String) storeName;
		this.storeId = (String) storeId;
		this.itemName = (String) itemName;
		this.itemId = (String) itemId;
		this.itemSalePrice = (Double) itemSalePrice;
		this.itemSpecialPrice = (Double) itemSpecialPrice;
		this.createdBy = (String) createdBy;
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Double getItemSalePrice() {
		return itemSalePrice;
	}

	public void setItemSalePrice(Double itemSalePrice) {
		this.itemSalePrice = itemSalePrice;
	}

	public Double getItemSpecialPrice() {
		return itemSpecialPrice;
	}

	public void setItemSpecialPrice(Double itemSpecialPrice) {
		this.itemSpecialPrice = itemSpecialPrice;
	}

	public Double getPriceAll() {
		return priceAll;
	}

	public void setPriceAll(Double priceAll) {
		this.priceAll = priceAll;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
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
