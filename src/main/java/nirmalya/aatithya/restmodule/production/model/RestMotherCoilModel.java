package nirmalya.aatithya.restmodule.production.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestMotherCoilModel {

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
	private String batchId;
	private String editId;
	private String slitSubGroup;
	private Byte status;
	private String tMotherCoilThicknessName;
	private String tMotherCoilGradeName;
	private String tPipeSizeName;
	 private String tPipeSlitWidthName;
	public RestMotherCoilModel(Object tMotherCoilBatch, Object tMotherCoilThickness, Object tMotherCoilGrade,
			Object tPipeSlitBatch, Object tPipeScrapWeight, Object tPipeSlitStartDate, Object tPipeSlitEndDate,
			Object tPipeSlitWidth, Object tPipeSlitQty, Object tPipeSize, Object tPipeCreatedBy, Object batchId,
			Object slitSubGroup, Object status, Object tMotherCoilThicknessName, Object tMotherCoilGradeName,
			Object tPipeSizeName ,Object tPipeSlitWidthName) {
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
		this.tPipeCreatedBy = (String) tPipeCreatedBy;
		this.batchId = (String) batchId;
		this.slitSubGroup = (String) slitSubGroup;
		this.status = (Byte) status;
		this.tMotherCoilThicknessName = (String) tMotherCoilThicknessName;
		this.tMotherCoilGradeName = (String) tMotherCoilGradeName;
		this.tPipeSizeName = (String) tPipeSizeName;
		this.tPipeSlitWidthName = (String) tPipeSlitWidthName;

	}

	public String gettMotherCoilBatch() {
		return tMotherCoilBatch;
	}

	public void settMotherCoilBatch(String tMotherCoilBatch) {
		this.tMotherCoilBatch = tMotherCoilBatch;
	}

	public String gettMotherCoilThickness() {
		return tMotherCoilThickness;
	}

	public void settMotherCoilThickness(String tMotherCoilThickness) {
		this.tMotherCoilThickness = tMotherCoilThickness;
	}

	public String gettMotherCoilGrade() {
		return tMotherCoilGrade;
	}

	public void settMotherCoilGrade(String tMotherCoilGrade) {
		this.tMotherCoilGrade = tMotherCoilGrade;
	}

	public String gettPipeSlitBatch() {
		return tPipeSlitBatch;
	}

	public void settPipeSlitBatch(String tPipeSlitBatch) {
		this.tPipeSlitBatch = tPipeSlitBatch;
	}

	public Double gettPipeScrapWeight() {
		return tPipeScrapWeight;
	}

	public void settPipeScrapWeight(Double tPipeScrapWeight) {
		this.tPipeScrapWeight = tPipeScrapWeight;
	}

	public String gettPipeSlitStartDate() {
		return tPipeSlitStartDate;
	}

	public void settPipeSlitStartDate(String tPipeSlitStartDate) {
		this.tPipeSlitStartDate = tPipeSlitStartDate;
	}

	public String gettPipeSlitEndDate() {
		return tPipeSlitEndDate;
	}

	public void settPipeSlitEndDate(String tPipeSlitEndDate) {
		this.tPipeSlitEndDate = tPipeSlitEndDate;
	}

	public String gettPipeSlitWidth() {
		return tPipeSlitWidth;
	}

	public void settPipeSlitWidth(String tPipeSlitWidth) {
		this.tPipeSlitWidth = tPipeSlitWidth;
	}

	public Double gettPipeSlitQty() {
		return tPipeSlitQty;
	}

	public void settPipeSlitQty(Double tPipeSlitQty) {
		this.tPipeSlitQty = tPipeSlitQty;
	}

	public String gettPipeSize() {
		return tPipeSize;
	}

	public void settPipeSize(String tPipeSize) {
		this.tPipeSize = tPipeSize;
	}

	public String gettPipeCreatedBy() {
		return tPipeCreatedBy;
	}

	public void settPipeCreatedBy(String tPipeCreatedBy) {
		this.tPipeCreatedBy = tPipeCreatedBy;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getSlitSubGroup() {
		return slitSubGroup;
	}

	public void setSlitSubGroup(String slitSubGroup) {
		this.slitSubGroup = slitSubGroup;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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
