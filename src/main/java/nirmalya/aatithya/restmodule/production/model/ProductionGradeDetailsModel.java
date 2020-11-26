package nirmalya.aatithya.restmodule.production.model;

public class ProductionGradeDetailsModel {
	private String size;
	private Double sales;
	private Double ratio;
	private Double finishedProduct;
	private Double wip;
	private Double slit;
	private Double motherCoil;
	private Double total;
	private Double stock;
	private Double mplan;
	private Double gtotal;
	private Double afterProductionQty;
	private Double afterProductionPercentage;

	public ProductionGradeDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductionGradeDetailsModel(Object size, Object sales, Object ratio, Object finishedProduct, Object wip,
			Object slit, Object motherCoil, Object total, Object stock, Object mplan, Object gtotal,
			Object afterProductionQty, Object afterProductionPercentage) {
		super();
		this.size = (String) size;
		this.sales = (Double) sales;
		this.ratio = (Double) ratio;
		this.finishedProduct = (Double) finishedProduct;
		this.wip = (Double) wip;
		this.slit = (Double) slit;
		this.motherCoil = (Double) motherCoil;
		this.total = (Double) total;
		this.stock = (Double) stock;
		this.mplan = (Double) mplan;
		this.gtotal = (Double) gtotal;
		this.afterProductionQty = (Double) afterProductionQty;
		this.afterProductionPercentage = (Double) afterProductionPercentage;
	}

	public String getSize() {
		return size;
	}

	public Double getSales() {
		return sales;
	}

	public Double getRatio() {
		return ratio;
	}

	public Double getFinishedProduct() {
		return finishedProduct;
	}

	public Double getWip() {
		return wip;
	}

	public Double getSlit() {
		return slit;
	}

	public Double getMotherCoil() {
		return motherCoil;
	}

	public Double getTotal() {
		return total;
	}

	public Double getStock() {
		return stock;
	}

	public Double getMplan() {
		return mplan;
	}

	public Double getGtotal() {
		return gtotal;
	}

	public Double getAfterProductionQty() {
		return afterProductionQty;
	}

	public Double getAfterProductionPercentage() {
		return afterProductionPercentage;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setSales(Double sales) {
		this.sales = sales;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public void setFinishedProduct(Double finishedProduct) {
		this.finishedProduct = finishedProduct;
	}

	public void setWip(Double wip) {
		this.wip = wip;
	}

	public void setSlit(Double slit) {
		this.slit = slit;
	}

	public void setMotherCoil(Double motherCoil) {
		this.motherCoil = motherCoil;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setStock(Double stock) {
		this.stock = stock;
	}

	public void setMplan(Double mplan) {
		this.mplan = mplan;
	}

	public void setGtotal(Double gtotal) {
		this.gtotal = gtotal;
	}

	public void setAfterProductionQty(Double afterProductionQty) {
		this.afterProductionQty = afterProductionQty;
	}

	public void setAfterProductionPercentage(Double afterProductionPercentage) {
		this.afterProductionPercentage = afterProductionPercentage;
	}

}
