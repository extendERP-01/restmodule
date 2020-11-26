package nirmalya.aatithya.restmodule.production.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductionPipePolishingModel {
	private String tMotherCoilBatch;
	private String tMotherCoilThickness;
	private String tMotherCoilGrade;
	private String tPipeSlitBatch;
	private Double tPipeScrapWeight;
	private String tPipeSlitStartDate;
	private String tPipeSlitEndDate;
	private String tPipeSlitWidth;
	private Double tPipeSlitQty;
	private String tPipeSize;
	private String tPipeCreatedBy;
	private String action;
	private String batchId;
	private String slitSubGroup;
	private Double productionQty;
	private Double productionWt;
	private String polishingStartDate;
	private String polishingEndDate;
	private Double polishingQty;
	private Double polishingWt;
	private Byte status;
	private String tMotherCoilGradeName;
	private String tMotherCoilThicknessName;
	private String tPipeSizeName;
	private String tPipeSlitWidthName;

	public ProductionPipePolishingModel(Object tMotherCoilBatch, Object tMotherCoilThickness, Object tMotherCoilGrade,
			Object tPipeSlitBatch, Object tPipeScrapWeight, Object tPipeSlitStartDate, Object tPipeSlitEndDate,
			Object tPipeSlitWidth, Object tPipeSlitQty, Object tPipeSize, Object slitSubGroup, Object productionQty,
			Object productionWt, Object polishingStartDate, Object polishingEndDate, Object polishingQty,
			Object polishingWt, Object status, Object tMotherCoilGradeName, Object tMotherCoilThicknessName,
			Object tPipeSizeName, Object tPipeSlitWidthName) {
		super();
		this.tMotherCoilBatch = (String) tMotherCoilBatch;
		this.tMotherCoilThickness = (String) tMotherCoilThickness;
		this.tMotherCoilGrade = (String) tMotherCoilGrade;
		this.tPipeSlitBatch = (String) tPipeSlitBatch;
		this.tPipeScrapWeight = (Double) tPipeScrapWeight;
		this.tPipeSlitStartDate = (String) tPipeSlitStartDate;
		this.tPipeSlitEndDate = (String) tPipeSlitEndDate;
		this.tPipeSlitWidth = (String) tPipeSlitWidth;
		this.tPipeSlitQty = (Double) tPipeSlitQty;
		this.tPipeSize = (String) tPipeSize;
		this.slitSubGroup = (String) slitSubGroup;
		this.productionQty = (Double) productionQty;
		this.productionWt = (Double) productionWt;
		this.polishingStartDate = (String) polishingStartDate;
		this.polishingEndDate = (String) polishingEndDate;
		this.polishingQty = (Double) polishingQty;
		this.polishingWt = (Double) polishingWt;
		this.status = (Byte) status;
		this.tMotherCoilGradeName = (String) tMotherCoilGradeName;
		this.tMotherCoilThicknessName = (String) tMotherCoilThicknessName;
		this.tPipeSizeName = (String) tPipeSizeName;
		this.tPipeSlitWidthName = (String) tPipeSlitWidthName;
	}

	public String gettMotherCoilBatch() {
		return tMotherCoilBatch;
	}

	public String gettMotherCoilThickness() {
		return tMotherCoilThickness;
	}

	public String gettMotherCoilGrade() {
		return tMotherCoilGrade;
	}

	public String gettPipeSlitBatch() {
		return tPipeSlitBatch;
	}

	public Double gettPipeScrapWeight() {
		return tPipeScrapWeight;
	}

	public String gettPipeSlitStartDate() {
		return tPipeSlitStartDate;
	}

	public String gettPipeSlitEndDate() {
		return tPipeSlitEndDate;
	}

	public String gettPipeSlitWidth() {
		return tPipeSlitWidth;
	}

	public Double gettPipeSlitQty() {
		return tPipeSlitQty;
	}

	public String gettPipeSize() {
		return tPipeSize;
	}

	public String gettPipeCreatedBy() {
		return tPipeCreatedBy;
	}

	public String getAction() {
		return action;
	}

	public String getBatchId() {
		return batchId;
	}

	public String getSlitSubGroup() {
		return slitSubGroup;
	}

	public Double getProductionQty() {
		return productionQty;
	}

	public Double getProductionWt() {
		return productionWt;
	}

	public String getPolishingStartDate() {
		return polishingStartDate;
	}

	public String getPolishingEndDate() {
		return polishingEndDate;
	}

	public Double getPolishingQty() {
		return polishingQty;
	}

	public Double getPolishingWt() {
		return polishingWt;
	}

	public Byte getStatus() {
		return status;
	}

	public void settMotherCoilBatch(String tMotherCoilBatch) {
		this.tMotherCoilBatch = tMotherCoilBatch;
	}

	public void settMotherCoilThickness(String tMotherCoilThickness) {
		this.tMotherCoilThickness = tMotherCoilThickness;
	}

	public void settMotherCoilGrade(String tMotherCoilGrade) {
		this.tMotherCoilGrade = tMotherCoilGrade;
	}

	public void settPipeSlitBatch(String tPipeSlitBatch) {
		this.tPipeSlitBatch = tPipeSlitBatch;
	}

	public void settPipeScrapWeight(Double tPipeScrapWeight) {
		this.tPipeScrapWeight = tPipeScrapWeight;
	}

	public void settPipeSlitStartDate(String tPipeSlitStartDate) {
		this.tPipeSlitStartDate = tPipeSlitStartDate;
	}

	public void settPipeSlitEndDate(String tPipeSlitEndDate) {
		this.tPipeSlitEndDate = tPipeSlitEndDate;
	}

	public void settPipeSlitWidth(String tPipeSlitWidth) {
		this.tPipeSlitWidth = tPipeSlitWidth;
	}

	public void settPipeSlitQty(Double tPipeSlitQty) {
		this.tPipeSlitQty = tPipeSlitQty;
	}

	public void settPipeSize(String tPipeSize) {
		this.tPipeSize = tPipeSize;
	}

	public void settPipeCreatedBy(String tPipeCreatedBy) {
		this.tPipeCreatedBy = tPipeCreatedBy;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public void setSlitSubGroup(String slitSubGroup) {
		this.slitSubGroup = slitSubGroup;
	}

	public void setProductionQty(Double productionQty) {
		this.productionQty = productionQty;
	}

	public void setProductionWt(Double productionWt) {
		this.productionWt = productionWt;
	}

	public void setPolishingStartDate(String polishingStartDate) {
		this.polishingStartDate = polishingStartDate;
	}

	public void setPolishingEndDate(String polishingEndDate) {
		this.polishingEndDate = polishingEndDate;
	}

	public void setPolishingQty(Double polishingQty) {
		this.polishingQty = polishingQty;
	}

	public void setPolishingWt(Double polishingWt) {
		this.polishingWt = polishingWt;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String gettMotherCoilGradeName() {
		return tMotherCoilGradeName;
	}

	public String gettMotherCoilThicknessName() {
		return tMotherCoilThicknessName;
	}

	public String gettPipeSizeName() {
		return tPipeSizeName;
	}

	public String gettPipeSlitWidthName() {
		return tPipeSlitWidthName;
	}

	public void settMotherCoilGradeName(String tMotherCoilGradeName) {
		this.tMotherCoilGradeName = tMotherCoilGradeName;
	}

	public void settMotherCoilThicknessName(String tMotherCoilThicknessName) {
		this.tMotherCoilThicknessName = tMotherCoilThicknessName;
	}

	public void settPipeSizeName(String tPipeSizeName) {
		this.tPipeSizeName = tPipeSizeName;
	}

	public void settPipeSlitWidthName(String tPipeSlitWidthName) {
		this.tPipeSlitWidthName = tPipeSlitWidthName;
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
