package nirmalya.aatithya.restmodule.inventory.model;

public class CustomerItemModel {

	private String customerName;
	private String itemName;
	private String itemId;
	private Double itemSalePrice;
	private Double itemSpecialPrice;
	private Double priceAll;
	private String selectType;
	private String createdBy;

	public CustomerItemModel(Object iname, Object cname, Object iId, Object sprice, Object sp) {
		super();
		this.itemName = (String) iname;
		this.customerName = (String) cname;
		this.itemId = (String) iId;
		this.itemSalePrice = (Double) sprice;
		this.itemSpecialPrice = (Double) sp;

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

}