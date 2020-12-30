package nirmalya.aatithya.restmodule.inventory.model;

public class ItemModel {
	private String itemId;
	private String itemName;
	private Double salePrice;
	
	public ItemModel(Object Id, Object name, Object salePrice) {
		this.itemId = (String) Id;
		this.itemName = (String) name;
		this.salePrice = (Double) salePrice;
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
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	@Override
	public String toString() {
		return "ItemModel [itemId=" + itemId + ", itemName=" + itemName + ", salePrice=" + salePrice + "]";
	}
	
}
