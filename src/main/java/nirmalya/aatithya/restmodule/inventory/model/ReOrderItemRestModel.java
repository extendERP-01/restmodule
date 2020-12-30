package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;

public class ReOrderItemRestModel {

	private String itemId;
	private String itemName;
	private Double avlQty;
	private Double minQty;
	private List<DropDownModel> vendorList = new ArrayList<DropDownModel>();
	private String vendor;
	private String vendorName;
	private Double price;
	private String createdBy;
	private String itemCategory;
	private String subCategory;
	private String po;
	private String date;
	
	public ReOrderItemRestModel() {
		super();
	}

	public ReOrderItemRestModel(Object itemId, Object itemName, Object avlQty, Object minQty,
			Object itemCategory, Object subCategory, Object po, Object date, Object vendorName) {
		super();
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.avlQty = (Double) avlQty;
		this.minQty = (Double) minQty;
		this.itemCategory = (String) itemCategory;
		this.subCategory = (String) subCategory;
		this.po = (String) po;
		this.date = (String) date;
		this.vendorName = (String) vendorName;
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

	public Double getAvlQty() {
		return avlQty;
	}

	public void setAvlQty(Double avlQty) {
		this.avlQty = avlQty;
	}

	public Double getMinQty() {
		return minQty;
	}

	public void setMinQty(Double minQty) {
		this.minQty = minQty;
	}

	public List<DropDownModel> getVendorList() {
		return vendorList;
	}

	public void setVendorList(List<DropDownModel> vendorList) {
		this.vendorList = vendorList;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
