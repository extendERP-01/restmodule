package nirmalya.aatithya.restmodule.production.model;

public class ProductionSummaryDetailsModel {

	private String planId;
	private String storeId;
	private String date;
	private String itemName;
	private Double planQty;
	private Double productionQty;
	private Double scrapQty;

	public ProductionSummaryDetailsModel() {
		super();
	}

	public ProductionSummaryDetailsModel(Object planId, Object storeId, Object date, Object itemName, Object planQty,
			Object productionQty, Object scrapQty) {
		super();
		this.planId = (String) planId;
		this.storeId = (String) storeId;
		this.date = (String) date;
		this.itemName = (String) itemName;
		this.planQty = (Double) planQty;
		this.productionQty = (Double) productionQty;
		this.scrapQty = (Double) scrapQty;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPlanQty() {
		return planQty;
	}

	public void setPlanQty(Double planQty) {
		this.planQty = planQty;
	}

	public Double getProductionQty() {
		return productionQty;
	}

	public void setProductionQty(Double productionQty) {
		this.productionQty = productionQty;
	}

	public Double getScrapQty() {
		return scrapQty;
	}

	public void setScrapQty(Double scrapQty) {
		this.scrapQty = scrapQty;
	}

}
