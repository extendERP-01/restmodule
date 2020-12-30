package nirmalya.aatithya.restmodule.sales.model;

public class SaleOrderDisCountDetailsModel {

	private Double storeDiscount;
	private Double userDiscount;
	private Double totalDiscount;
	private Double canDiscount;

	public SaleOrderDisCountDetailsModel() {
		super();

	}

	public SaleOrderDisCountDetailsModel(Object storeDiscount, Object userDiscount, Object totalDiscount) {
		super();
		this.storeDiscount = (Double) storeDiscount;
		this.userDiscount = (Double) userDiscount;
		this.totalDiscount = (Double) totalDiscount;
	}

	public Double getStoreDiscount() {
		return storeDiscount;
	}

	public void setStoreDiscount(Double storeDiscount) {
		this.storeDiscount = storeDiscount;
	}

	public Double getUserDiscount() {
		return userDiscount;
	}

	public void setUserDiscount(Double userDiscount) {
		this.userDiscount = userDiscount;
	}

	public Double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Double getCanDiscount() {
		return canDiscount;
	}

	public void setCanDiscount(Double canDiscount) {
		this.canDiscount = canDiscount;
	}

}
