package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VendorItemModel {
	private String vendorName;
	private String itemId;
	private String itemName;
	private Double itemPrice;
	private Double priceAll;
	private String selectType;
	private String createdBy;

	public VendorItemModel(Object m, Object m2, Object m3, Object m4) {
		super();
		this.vendorName = (String) m;
		this.itemId = (String) m2;
		this.itemName = (String) m3;
		this.itemPrice = (Double) m4;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
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
