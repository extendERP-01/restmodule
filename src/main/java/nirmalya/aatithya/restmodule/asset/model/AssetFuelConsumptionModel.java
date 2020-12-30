package nirmalya.aatithya.restmodule.asset.model;

public class AssetFuelConsumptionModel {

	private String consumptionId;
	private String branch;
	private String fuel;
	private Double quantity;
	private String fuelSlipNumber;
	private String couponDate;
	private Double totalAmount;
	private String vechileNo;
	private String driverId;
	private String helper;
	private Double vehicleWt;
	private String time;
	private Double runningKm;
	private Double frontHrMeter;
	private Double backHrMeter;
	private String driverName;
	private Boolean isTankFuel;
	private Double rate;
	private String createdBy;
	private String action;
	private Double kmMilage;
	private Double fhr;
	private Double bhr;
	private String milage;
	private String oilSource;

	public AssetFuelConsumptionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetFuelConsumptionModel(Object consumptionId, Object branch, Object fuel, Object quantity,
			Object fuelSlipNumber, Object couponDate, Object totalAmount, Object vechileNo, Object driverId,
			Object helper, Object vehicleWt, Object time, Object runningKm, Object frontHrMeter, Object backHrMeter,
			Object driverName, Object isTankFuel, Object rate, Object kmMilage, Object fhr, Object bhr, Object milage, Object oilSource) {
		super();
		this.consumptionId = (String) consumptionId;
		this.branch = (String) branch;
		this.fuel = (String) fuel;
		this.quantity = (Double) quantity;
		this.fuelSlipNumber = (String) fuelSlipNumber;
		this.couponDate = (String) couponDate;
		this.totalAmount = (Double) totalAmount;
		this.vechileNo = (String) vechileNo;
		this.driverId = (String) driverId;
		this.helper = (String) helper;
		this.vehicleWt = (Double) vehicleWt;
		this.time = (String) time;
		this.runningKm = (Double) runningKm;
		this.frontHrMeter = (Double) frontHrMeter;
		this.backHrMeter = (Double) backHrMeter;
		this.driverName = (String) driverName;
		this.isTankFuel = (Boolean) isTankFuel;
		this.rate = (Double) rate;
		this.kmMilage = (Double) kmMilage;
		this.fhr = (Double) fhr;
		this.bhr = (Double) bhr;
		this.milage = (String) milage;
		this.oilSource = (String) oilSource;
	}

	public String getConsumptionId() {
		return consumptionId;
	}

	public void setConsumptionId(String consumptionId) {
		this.consumptionId = consumptionId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getFuelSlipNumber() {
		return fuelSlipNumber;
	}

	public void setFuelSlipNumber(String fuelSlipNumber) {
		this.fuelSlipNumber = fuelSlipNumber;
	}

	public String getCouponDate() {
		return couponDate;
	}

	public void setCouponDate(String couponDate) {
		this.couponDate = couponDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getVechileNo() {
		return vechileNo;
	}

	public void setVechileNo(String vechileNo) {
		this.vechileNo = vechileNo;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getHelper() {
		return helper;
	}

	public void setHelper(String helper) {
		this.helper = helper;
	}

	public Double getVehicleWt() {
		return vehicleWt;
	}

	public void setVehicleWt(Double vehicleWt) {
		this.vehicleWt = vehicleWt;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getRunningKm() {
		return runningKm;
	}

	public void setRunningKm(Double runningKm) {
		this.runningKm = runningKm;
	}

	public Double getFrontHrMeter() {
		return frontHrMeter;
	}

	public void setFrontHrMeter(Double frontHrMeter) {
		this.frontHrMeter = frontHrMeter;
	}

	public Double getBackHrMeter() {
		return backHrMeter;
	}

	public void setBackHrMeter(Double backHrMeter) {
		this.backHrMeter = backHrMeter;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Boolean getIsTankFuel() {
		return isTankFuel;
	}

	public void setIsTankFuel(Boolean isTankFuel) {
		this.isTankFuel = isTankFuel;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getKmMilage() {
		return kmMilage;
	}

	public void setKmMilage(Double kmMilage) {
		this.kmMilage = kmMilage;
	}

	public Double getFhr() {
		return fhr;
	}

	public void setFhr(Double fhr) {
		this.fhr = fhr;
	}

	public Double getBhr() {
		return bhr;
	}

	public void setBhr(Double bhr) {
		this.bhr = bhr;
	}

	public String getMilage() {
		return milage;
	}

	public void setMilage(String milage) {
		this.milage = milage;
	}

	public String getOilSource() {
		return oilSource;
	}

	public void setOilSource(String oilSource) {
		this.oilSource = oilSource;
	}
	
}
