package nirmalya.aatithya.restmodule.production.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductionPipeProductionModel {
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
	private String editId;
	private String slitSubGroup;
	private String productionStartDate;
	private String productionEndDate;
	private Double productionQty;
	private Double productionWt;
	private Double scrapWt1;
	private Double scrapWt2;
	private Double scrapWt3;
	private Double scrapQty1;
	private Double scrapQty2;
	private Double scrapQty3;
	private Byte status;
	private String tMotherCoilThicknessName;
	private String tMotherCoilGradeName;
	private String tPipeSizeName;
	private String tPipeSlitWidthName;

	public ProductionPipeProductionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductionPipeProductionModel(Object tMotherCoilBatch, Object tMotherCoilThickness, Object tMotherCoilGrade,
			Object tPipeSlitBatch, Object tPipeScrapWeight, Object tPipeSlitStartDate, Object tPipeSlitEndDate,
			Object tPipeSlitWidth, Object tPipeSlitQty, Object tPipeSize, Object batchId, Object slitSubGroup,
			Object productionStartDate, Object productionEndDate, Object productionQty, Object productionWt,
			Object status, Object tMotherCoilThicknessName, Object tMotherCoilGradeName ,Object tPipeSizeName ,Object tPipeSlitWidthName) {
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
		this.batchId = (String) batchId;
		this.slitSubGroup = (String) slitSubGroup;
		this.productionStartDate = (String) productionStartDate;
		this.productionEndDate = (String) productionEndDate;
		this.productionQty = (Double) productionQty;
		this.productionWt = (Double) productionWt;
		this.status = (Byte) status;
		this.tMotherCoilThicknessName = (String) tMotherCoilThicknessName;
		this.tMotherCoilGradeName = (String) tMotherCoilGradeName;
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

	public String getEditId() {
		return editId;
	}

	public String getSlitSubGroup() {
		return slitSubGroup;
	}

	public String getProductionStartDate() {
		return productionStartDate;
	}

	public String getProductionEndDate() {
		return productionEndDate;
	}

	public Double getProductionQty() {
		return productionQty;
	}

	public Double getProductionWt() {
		return productionWt;
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

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public void setSlitSubGroup(String slitSubGroup) {
		this.slitSubGroup = slitSubGroup;
	}

	public void setProductionStartDate(String productionStartDate) {
		this.productionStartDate = productionStartDate;
	}

	public void setProductionEndDate(String productionEndDate) {
		this.productionEndDate = productionEndDate;
	}

	public void setProductionQty(Double productionQty) {
		this.productionQty = productionQty;
	}

	public void setProductionWt(Double productionWt) {
		this.productionWt = productionWt;
	}

	public Double getScrapWt1() {
		return scrapWt1;
	}

	public Double getScrapWt2() {
		return scrapWt2;
	}

	public Double getScrapWt3() {
		return scrapWt3;
	}

	public void setScrapWt1(Double scrapWt1) {
		this.scrapWt1 = scrapWt1;
	}

	public void setScrapWt2(Double scrapWt2) {
		this.scrapWt2 = scrapWt2;
	}

	public void setScrapWt3(Double scrapWt3) {
		this.scrapWt3 = scrapWt3;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Double getScrapQty1() {
		return scrapQty1;
	}

	public Double getScrapQty2() {
		return scrapQty2;
	}

	public Double getScrapQty3() {
		return scrapQty3;
	}

	public void setScrapQty1(Double scrapQty1) {
		this.scrapQty1 = scrapQty1;
	}

	public void setScrapQty2(Double scrapQty2) {
		this.scrapQty2 = scrapQty2;
	}

	public void setScrapQty3(Double scrapQty3) {
		this.scrapQty3 = scrapQty3;
	}

	public String gettMotherCoilThicknessName() {
		return tMotherCoilThicknessName;
	}

	public String gettMotherCoilGradeName() {
		return tMotherCoilGradeName;
	}

	public void settMotherCoilThicknessName(String tMotherCoilThicknessName) {
		this.tMotherCoilThicknessName = tMotherCoilThicknessName;
	}

	public void settMotherCoilGradeName(String tMotherCoilGradeName) {
		this.tMotherCoilGradeName = tMotherCoilGradeName;
	}

	public String gettPipeSizeName() {
		return tPipeSizeName;
	}

	public void settPipeSizeName(String tPipeSizeName) {
		this.tPipeSizeName = tPipeSizeName;
	}

	public String gettPipeSlitWidthName() {
		return tPipeSlitWidthName;
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
