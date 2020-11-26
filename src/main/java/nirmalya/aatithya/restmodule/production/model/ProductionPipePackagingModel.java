package nirmalya.aatithya.restmodule.production.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductionPipePackagingModel {
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
	private String slitSubGroup;
	private Double polishingQty;
	private Double polishingWt;
	private String packagingStartDate;
	private String packagingEndDate;
	private Double packagingQty;
	private Double packagingWt;
	private Double packagingTotal;
	private Double noOfBundles;

	private Byte status;

	private String barcodeImageName;
	private String barcodeImageNumber;
	private String tMotherCoilGradeName;
	private String tMotherCoilThicknessName;
	private String tPipeSizeName;
	private String tPipeSlitWidthName;

	public ProductionPipePackagingModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductionPipePackagingModel(Object tMotherCoilBatch, Object tMotherCoilThickness, Object tMotherCoilGrade,
			Object tPipeSlitBatch, Object tPipeScrapWeight, Object tPipeSlitStartDate, Object tPipeSlitEndDate,
			Object tPipeSlitWidth, Object tPipeSlitQty, Object tPipeSize, Object slitSubGroup, Object polishingQty,
			Object polishingWt, Object packagingStartDate, Object packagingEndDate, Object packagingQty,
			Object packagingWt, Object packagingTotal, Object noOfBundles, Object status, Object barcodeImageName,
			Object barcodeImageNumber, Object tMotherCoilGradeName, Object tMotherCoilThicknessName,
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
		this.polishingQty = (Double) polishingQty;
		this.polishingWt = (Double) polishingWt;
		this.packagingStartDate = (String) packagingStartDate;
		this.packagingEndDate = (String) packagingEndDate;
		this.packagingQty = (Double) packagingQty;
		this.packagingWt = (Double) packagingWt;
		this.packagingTotal = (Double) packagingTotal;
		this.noOfBundles = (Double) noOfBundles;
		this.status = (Byte) status;
		this.barcodeImageName = (String) barcodeImageName;
		this.barcodeImageNumber = (String) barcodeImageNumber;
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

	public String getSlitSubGroup() {
		return slitSubGroup;
	}

	public Double getPolishingQty() {
		return polishingQty;
	}

	public Double getPolishingWt() {
		return polishingWt;
	}

	public String getPackagingStartDate() {
		return packagingStartDate;
	}

	public String getPackagingEndDate() {
		return packagingEndDate;
	}

	public Double getPackagingQty() {
		return packagingQty;
	}

	public Double getPackagingWt() {
		return packagingWt;
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

	public void setSlitSubGroup(String slitSubGroup) {
		this.slitSubGroup = slitSubGroup;
	}

	public void setPolishingQty(Double polishingQty) {
		this.polishingQty = polishingQty;
	}

	public void setPolishingWt(Double polishingWt) {
		this.polishingWt = polishingWt;
	}

	public void setPackagingStartDate(String packagingStartDate) {
		this.packagingStartDate = packagingStartDate;
	}

	public void setPackagingEndDate(String packagingEndDate) {
		this.packagingEndDate = packagingEndDate;
	}

	public void setPackagingQty(Double packagingQty) {
		this.packagingQty = packagingQty;
	}

	public void setPackagingWt(Double packagingWt) {
		this.packagingWt = packagingWt;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Double getPackagingTotal() {
		return packagingTotal;
	}

	public void setPackagingTotal(Double packagingTotal) {
		this.packagingTotal = packagingTotal;
	}

	public Double getNoOfBundles() {
		return noOfBundles;
	}

	public void setNoOfBundles(Double noOfBundles) {
		this.noOfBundles = noOfBundles;
	}

	public String getBarcodeImageName() {
		return barcodeImageName;
	}

	public String getBarcodeImageNumber() {
		return barcodeImageNumber;
	}

	public void setBarcodeImageName(String barcodeImageName) {
		this.barcodeImageName = barcodeImageName;
	}

	public void setBarcodeImageNumber(String barcodeImageNumber) {
		this.barcodeImageNumber = barcodeImageNumber;
	}

	public String gettMotherCoilGradeName() {
		return tMotherCoilGradeName;
	}

	public String gettMotherCoilThicknessName() {
		return tMotherCoilThicknessName;
	}

	public void settMotherCoilGradeName(String tMotherCoilGradeName) {
		this.tMotherCoilGradeName = tMotherCoilGradeName;
	}

	public void settMotherCoilThicknessName(String tMotherCoilThicknessName) {
		this.tMotherCoilThicknessName = tMotherCoilThicknessName;
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
