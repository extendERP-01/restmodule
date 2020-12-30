package nirmalya.aatithya.restmodule.production.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductionGocoolProdModel {

	private String prodId;

	private String planId;

	private String batchId;

	private Double batchQty;

	private String prodItemId;

	private String prodItemName;

	private Double prodQty;

	private String rawMaterialItem;

	private String rawMaterialItemName;

	private Double quantity;

	private String storeId;

	private String prodStartDate;

	private String prodEndtDate;

	private Double srcapWt;

	private Double scrapQty;

	private String action;

	private String createdBy;

	private Double prodoductionQty;

	private Double prodoductionWt;

	private Byte productionStage;

	private Double mixWt;

	public ProductionGocoolProdModel(Object prodId, Object planId, Object batchId, Object batchQty, Object prodItemId,
			Object prodItemName, Object prodQty, Object rawMaterialItem, Object rawMaterialItemName, Object quantity,
			Object storeId, Object prodStartDate, Object prodEndtDate, Object srcapWt, Object scrapQty,
			Object prodoductionQty, Object prodoductionWt, Object productionStage, Object mixWt) {
		super();
		this.prodId = (String) prodId;
		this.planId = (String) planId;
		this.batchId = (String) batchId;
		this.batchQty = (Double) batchQty;
		this.prodItemId = (String) prodItemId;
		this.prodItemName = (String) prodItemName;
		this.prodQty = (Double) prodQty;
		this.rawMaterialItem = (String) rawMaterialItem;
		this.rawMaterialItemName = (String) rawMaterialItemName;
		this.quantity = (Double) quantity;
		this.storeId = (String) storeId;
		this.prodStartDate = (String) prodStartDate;
		this.prodEndtDate = (String) prodEndtDate;
		this.srcapWt = (Double) srcapWt;
		this.scrapQty = (Double) scrapQty;
		this.prodoductionQty = (Double) prodoductionQty;
		this.prodoductionWt = (Double) prodoductionWt;
		this.productionStage = (Byte) productionStage;
		this.mixWt = (Double) mixWt;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public Double getBatchQty() {
		return batchQty;
	}

	public void setBatchQty(Double batchQty) {
		this.batchQty = batchQty;
	}

	public String getProdItemId() {
		return prodItemId;
	}

	public void setProdItemId(String prodItemId) {
		this.prodItemId = prodItemId;
	}

	public String getProdItemName() {
		return prodItemName;
	}

	public void setProdItemName(String prodItemName) {
		this.prodItemName = prodItemName;
	}

	public Double getProdQty() {
		return prodQty;
	}

	public void setProdQty(Double prodQty) {
		this.prodQty = prodQty;
	}

	public String getRawMaterialItem() {
		return rawMaterialItem;
	}

	public void setRawMaterialItem(String rawMaterialItem) {
		this.rawMaterialItem = rawMaterialItem;
	}

	public String getRawMaterialItemName() {
		return rawMaterialItemName;
	}

	public void setRawMaterialItemName(String rawMaterialItemName) {
		this.rawMaterialItemName = rawMaterialItemName;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getProdStartDate() {
		return prodStartDate;
	}

	public void setProdStartDate(String prodStartDate) {
		this.prodStartDate = prodStartDate;
	}

	public String getProdEndtDate() {
		return prodEndtDate;
	}

	public void setProdEndtDate(String prodEndtDate) {
		this.prodEndtDate = prodEndtDate;
	}

	public Double getSrcapWt() {
		return srcapWt;
	}

	public void setSrcapWt(Double srcapWt) {
		this.srcapWt = srcapWt;
	}

	public Double getScrapQty() {
		return scrapQty;
	}

	public void setScrapQty(Double scrapQty) {
		this.scrapQty = scrapQty;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Double getProdoductionQty() {
		return prodoductionQty;
	}

	public void setProdoductionQty(Double prodoductionQty) {
		this.prodoductionQty = prodoductionQty;
	}

	public Double getProdoductionWt() {
		return prodoductionWt;
	}

	public void setProdoductionWt(Double prodoductionWt) {
		this.prodoductionWt = prodoductionWt;
	}

	public Byte getProductionStage() {
		return productionStage;
	}

	public void setProductionStage(Byte productionStage) {
		this.productionStage = productionStage;
	}

	public Double getMixWt() {
		return mixWt;
	}

	public void setMixWt(Double mixWt) {
		this.mixWt = mixWt;
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
