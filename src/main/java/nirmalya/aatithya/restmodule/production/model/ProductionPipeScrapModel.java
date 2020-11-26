package nirmalya.aatithya.restmodule.production.model;

public class ProductionPipeScrapModel {
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
	private String slitSubGroup;
	private Double scrapWt1;
	private Double scrapWt2;
	private Double scrapQty1;
	private Double scrapQty2;
	private Double scrapQty3;
	private Double scrapWt3;
	private String action;
	private String status;

	public ProductionPipeScrapModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductionPipeScrapModel(Object tMotherCoilBatch, Object tMotherCoilThickness, Object tMotherCoilGrade,
			Object tPipeSlitBatch, Object tPipeScrapWeight, Object tPipeSlitStartDate, Object tPipeSlitEndDate,
			Object tPipeSlitWidth, Object tPipeSlitQty, Object tPipeSize, Object slitSubGroup ,Object scrapWt1, Object scrapWt2,
			Object scrapQty1, Object scrapQty2, Object scrapQty3, Object scrapWt3) {
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
		this.scrapWt1 = (Double) scrapWt1;
		this.scrapWt2 = (Double) scrapWt2;
		this.scrapQty1 = (Double) scrapQty1;
		this.scrapQty2 = (Double) scrapQty2;
		this.scrapQty3 = (Double) scrapQty3;
		this.scrapWt3 = (Double) scrapWt3;
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

	public Double getScrapWt1() {
		return scrapWt1;
	}

	public Double getScrapWt2() {
		return scrapWt2;
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

	public Double getScrapWt3() {
		return scrapWt3;
	}

	public String getAction() {
		return action;
	}

	public String getStatus() {
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

	public void setScrapWt1(Double scrapWt1) {
		this.scrapWt1 = scrapWt1;
	}

	public void setScrapWt2(Double scrapWt2) {
		this.scrapWt2 = scrapWt2;
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

	public void setScrapWt3(Double scrapWt3) {
		this.scrapWt3 = scrapWt3;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSlitSubGroup() {
		return slitSubGroup;
	}

	public void setSlitSubGroup(String slitSubGroup) {
		this.slitSubGroup = slitSubGroup;
	}

}
