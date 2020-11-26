package nirmalya.aatithya.restmodule.inventory.model;

public class RequisitionDetailsModel {
	
	private String itemCategory;
	private String subCategory;
	private String item;
	private String itemName;
	private Double totalIssuedQty;
	private Double availableQty;
	private Double requisitionQty;
	
	public RequisitionDetailsModel() {
		super();
	}

	public RequisitionDetailsModel(Object itemCategory, Object subCategory, Object item, Object itemName,
			Object totalIssuedQty, Object availableQty, Object requisitionQty) {
		super();
		this.itemCategory = (String) itemCategory;
		this.subCategory = (String) subCategory;
		this.item = (String) item;
		this.itemName = (String) itemName;
		this.totalIssuedQty = (Double) totalIssuedQty;
		this.availableQty = (Double) availableQty;
		this.requisitionQty = (Double) requisitionQty;
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getTotalIssuedQty() {
		return totalIssuedQty;
	}

	public void setTotalIssuedQty(Double totalIssuedQty) {
		this.totalIssuedQty = totalIssuedQty;
	}

	public Double getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(Double availableQty) {
		this.availableQty = availableQty;
	}

	public Double getRequisitionQty() {
		return requisitionQty;
	}

	public void setRequisitionQty(Double requisitionQty) {
		this.requisitionQty = requisitionQty;
	}
}
