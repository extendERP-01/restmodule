package nirmalya.aatithya.restmodule.production.model;

public class ProductionReturnModel {
	private String reurnId;
	private String storeID;
	private String planId;
	private String reqnId;
	private String description;
	private String rawItemName;
	private String rawItemId;
	private String retQty;
	private String createdBy;
	private String returnDate;

	public ProductionReturnModel() {
		super();
	}

	public ProductionReturnModel(Object reurnId, Object storeID, Object planId, Object reqnId, Object description,
			Object rawItemName, Object rawItemId, Object retQty, Object returnDate) {
		super();
		this.reurnId = (String) reurnId;
		this.storeID = (String) storeID;
		this.planId = (String) planId;
		this.reqnId = (String) reqnId;
		this.description = (String) description;
		this.rawItemName = (String) rawItemName;
		this.rawItemId = (String) rawItemId;
		this.retQty = (String) retQty;
		this.returnDate = (String) returnDate;
	}

	public String getReurnId() {
		return reurnId;
	}

	public void setReurnId(String reurnId) {
		this.reurnId = reurnId;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getReqnId() {
		return reqnId;
	}

	public void setReqnId(String reqnId) {
		this.reqnId = reqnId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRawItemName() {
		return rawItemName;
	}

	public void setRawItemName(String rawItemName) {
		this.rawItemName = rawItemName;
	}

	public String getRawItemId() {
		return rawItemId;
	}

	public void setRawItemId(String rawItemId) {
		this.rawItemId = rawItemId;
	}

	public String getRetQty() {
		return retQty;
	}

	public void setRetQty(String retQty) {
		this.retQty = retQty;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
