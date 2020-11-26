package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GRNReturnListModel {

	private String itemCategory;
	private String subCategory;
	private String itemId;
	private String itemName;
	private Double quantity;
	private Double price;
	private Double gst;
	private Boolean gstType;
	private String storeId;
	private String storeName;
	private Double cessAmount;
	
	public GRNReturnListModel() {
		super();
	}

	public GRNReturnListModel(Object itemCategory, Object subCategory, Object itemId, Object itemName, Object quantity,
			Object price, Object gst, Object gstType, Object storeId, Object storeName, Object cessAmount) {
		super();
		this.itemCategory = (String) itemCategory;
		this.subCategory = (String) subCategory;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.quantity = (Double) quantity;
		this.price = (Double) price;
		this.gst = (Double) gst;
		this.gstType = (Boolean) gstType;
		this.storeId = (String) storeId;
		this.storeName = (String) storeName;
		this.cessAmount = (Double) cessAmount;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}
	
	public Boolean getGstType() {
		return gstType;
	}

	public void setGstType(Boolean gstType) {
		this.gstType = gstType;
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

	public Double getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(Double cessAmount) {
		this.cessAmount = cessAmount;
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
