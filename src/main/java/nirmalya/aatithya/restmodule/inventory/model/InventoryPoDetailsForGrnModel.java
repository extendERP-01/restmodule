package nirmalya.aatithya.restmodule.inventory.model;

public class InventoryPoDetailsForGrnModel {

	private String po;
	private String itemId;
	private String itemName;
	private String category;
	private String subCategory;
	private Double poPrice;
	private Double gstRate;
	private Double orderQuantity;
	private Double receiveQuantity;
	private Boolean gstType;
	private Double cessAmount;
	private String storeId;
	
	public InventoryPoDetailsForGrnModel() {
		super();
	}

	public InventoryPoDetailsForGrnModel(Object po, Object itemId, Object itemName, Object category, Object subCategory,
			Object poPrice, Object gstRate ,Object orderQuantity ,Object receiveQuantity, Object gstType, Object cessAmount,
			Object storeId) {
		super();
		this.po = (String) po;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.category = (String) category;
		this.subCategory = (String) subCategory;
		this.poPrice = (Double) poPrice;
		this.gstRate = (Double) gstRate;
		this.orderQuantity = (Double) orderQuantity;
		this.receiveQuantity = (Double) receiveQuantity;
		this.gstType = (Boolean) gstType;
		this.cessAmount = (Double) cessAmount;
		this.storeId = (String) storeId;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Double getPoPrice() {
		return poPrice;
	}

	public void setPoPrice(Double poPrice) {
		this.poPrice = poPrice;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public Double getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Double orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Double getReceiveQuantity() {
		return receiveQuantity;
	}

	public void setReceiveQuantity(Double receiveQuantity) {
		this.receiveQuantity = receiveQuantity;
	}

	public Boolean getGstType() {
		return gstType;
	}

	public void setGstType(Boolean gstType) {
		this.gstType = gstType;
	}

	public Double getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(Double cessAmount) {
		this.cessAmount = cessAmount;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

}
