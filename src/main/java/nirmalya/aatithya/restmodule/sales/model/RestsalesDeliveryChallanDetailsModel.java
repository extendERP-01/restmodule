package nirmalya.aatithya.restmodule.sales.model;

public class RestsalesDeliveryChallanDetailsModel {

	private String itemCat;
	private String itemCatName;
	private String itemSubCat;
	private String itemSubCatName;
	private String item;
	private String itemName;
	private Double price;
	private Double stockQuantity;
	private Double gstRate;
	private Boolean taxType;
	private Double deliverdItemNo;
	private Double soQuantity;
	private Double advAmount;
	private Double itemCess;
	private Double discount;

	public RestsalesDeliveryChallanDetailsModel() {
		super();
	}

	public RestsalesDeliveryChallanDetailsModel(Object itemCat, Object itemCatName, Object itemSubCat,
			Object itemSubCatName, Object item, Object itemName, Object price, Object stockQuantity, Object gstRate,
			Object taxType, Object deliverdItemNo, Object soQuantity ,Object advAmount, Object itemCess, Object discount) {
		super();
		this.itemCat = (String) itemCat;
		this.itemCatName = (String) itemCatName;
		this.itemSubCat = (String) itemSubCat;
		this.itemSubCatName = (String) itemSubCatName;
		this.item = (String) item;
		this.itemName = (String) itemName;
		this.price = (Double) price;
		this.stockQuantity = (Double) stockQuantity;
		this.gstRate = (Double) gstRate;
		this.taxType = (Boolean) taxType;
		this.deliverdItemNo = (Double) deliverdItemNo;
		this.soQuantity = (Double) soQuantity;
		this.advAmount = (Double) advAmount;
		this.itemCess = (Double) itemCess;
		this.discount = (Double) discount;
	}

	public String getItemCat() {
		return itemCat;
	}

	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}

	public String getItemCatName() {
		return itemCatName;
	}

	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}

	public String getItemSubCat() {
		return itemSubCat;
	}

	public void setItemSubCat(String itemSubCat) {
		this.itemSubCat = itemSubCat;
	}

	public String getItemSubCatName() {
		return itemSubCatName;
	}

	public void setItemSubCatName(String itemSubCatName) {
		this.itemSubCatName = itemSubCatName;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Double stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Double getGstRate() {
		return gstRate;
	}

	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}

	public Boolean getTaxType() {
		return taxType;
	}

	public void setTaxType(Boolean taxType) {
		this.taxType = taxType;
	}

	public Double getDeliverdItemNo() {
		return deliverdItemNo;
	}

	public void setDeliverdItemNo(Double deliverdItemNo) {
		this.deliverdItemNo = deliverdItemNo;
	}

	public Double getSoQuantity() {
		return soQuantity;
	}

	public void setSoQuantity(Double soQuantity) {
		this.soQuantity = soQuantity;
	}

	public Double getAdvAmount() {
		return advAmount;
	}

	public void setAdvAmount(Double advAmount) {
		this.advAmount = advAmount;
	}

	public Double getItemCess() {
		return itemCess;
	}

	public void setItemCess(Double itemCess) {
		this.itemCess = itemCess;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

}
