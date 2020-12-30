package nirmalya.aatithya.restmodule.production.model;

public class ProductionGradePlanningModel {

	private String ppId;
	private String fromDate;
	private String toDate;
	private Integer sizeId;
	private String size;

	private Double slit;
	private Double mcoil;
	private Double plan;
	private Double sales;
	private Double wip;
	private Double fp;

	public ProductionGradePlanningModel() {

	}

	public ProductionGradePlanningModel(Object ppId, Object fromDate, Object toDate, Object sizeId, Object size,
			Object slit, Object mcoil, Object plan, Object sales, Object wip, Object fp) {

		this.ppId = (String) ppId;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.sizeId = (Integer) sizeId;
		this.size = (String) size;
		this.slit = (Double) slit;
		this.mcoil = (Double) mcoil;
		this.plan = (Double) plan;
		this.sales = (Double) sales;
		this.wip = (Double) wip;
		this.fp = (Double) fp;
	}

	public String getPpId() {
		return ppId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public String getSize() {
		return size;
	}

	public Double getSlit() {
		return slit;
	}

	public Double getMcoil() {
		return mcoil;
	}

	public Double getPlan() {
		return plan;
	}

	public Double getSales() {
		return sales;
	}

	public Double getWip() {
		return wip;
	}

	public Double getFp() {
		return fp;
	}

	public void setPpId(String ppId) {
		this.ppId = ppId;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setSlit(Double slit) {
		this.slit = slit;
	}

	public void setMcoil(Double mcoil) {
		this.mcoil = mcoil;
	}

	public void setPlan(Double plan) {
		this.plan = plan;
	}

	public void setSales(Double sales) {
		this.sales = sales;
	}

	public void setWip(Double wip) {
		this.wip = wip;
	}

	public void setFp(Double fp) {
		this.fp = fp;
	}

}
