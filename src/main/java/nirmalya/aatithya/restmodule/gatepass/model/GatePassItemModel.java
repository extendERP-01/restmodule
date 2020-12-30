package nirmalya.aatithya.restmodule.gatepass.model;

public class GatePassItemModel {

	private String itemId;
	private String itemName;
	private String itemCategory;
	private String subCategory;
	private String serveTypeId;
	private String serveType;
	private Double quantity;
	private String vendorId;
	private String vendor;
	public GatePassItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GatePassItemModel(Object itemId, Object itemName, Object itemCategory, Object subCategory, Object serveTypeId, Object serveType, 
			Object quantity, Object vendorId, Object vendor) {
		super();
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.itemCategory = (String) itemCategory;
		this.subCategory = (String) subCategory;
		this.serveTypeId = (String) serveTypeId;
		this.serveType = (String) serveType;
		this.quantity = (Double) quantity;
		this.vendorId = (String) vendorId;
		this.vendor = (String) vendor;
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
	public String getServeTypeId() {
		return serveTypeId;
	}
	public void setServeTypeId(String serveTypeId) {
		this.serveTypeId = serveTypeId;
	}
	public String getServeType() {
		return serveType;
	}
	public void setServeType(String serveType) {
		this.serveType = serveType;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
}
