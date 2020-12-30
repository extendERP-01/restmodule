package nirmalya.aatithya.restmodule.asset.model;

public class AssetJobCardModel {

	private String jobbCardId;
	private String vehicleNo;
	private String entryDate;
	private String entryTime;
	private Double runKm;
	private Double fHr;
	private Double bHr;
	private String mechanic;
	private String service;
	private Boolean status;
	private String ation;
	private String createdBy;
	private String statusName;
	private Boolean jobStatus;
	private String vehicle;
	private String mechanicId;
	private String asstMechanicId;
	private String asstMechanic;
	private String outSideMechanic;
	private String mechanicMob;
	private String serviceType;
	private String fromDateTime;
	private String toDateTime;
	private String desc;
	private Double costPrice;

	public AssetJobCardModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetJobCardModel(Object jobbCardId, Object vehicleNo, Object entryDate, Object entryTime, Object runKm,
			Object fHr, Object bHr, Object mechanic, Object service, Object status, Object jobStatus, Object vehicle, Object mechanicId, Object asstMechanicId,
			Object asstMechanic, Object outSideMechanic, Object mechanicMob, Object serviceType, Object fromDateTime,
			Object toDateTime, Object desc, Object costPrice) {
		super();
		this.jobbCardId = (String) jobbCardId;
		this.vehicleNo = (String) vehicleNo;
		this.entryDate = (String) entryDate;
		this.entryTime = (String) entryTime;
		this.runKm = (Double) runKm;
		this.fHr = (Double) fHr;
		this.bHr = (Double) bHr;
		this.mechanic = (String) mechanic;
		this.service = (String) service;
		this.status = (Boolean) status;
		this.jobStatus = (Boolean) jobStatus;
		this.vehicle = (String) vehicle;
		this.mechanicId = (String) mechanicId;
		this.asstMechanicId = (String) asstMechanicId;
		this.asstMechanic = (String) asstMechanic;
		this.outSideMechanic = (String) outSideMechanic;
		this.mechanicMob = (String) mechanicMob;
		this.serviceType = (String) serviceType;
		this.fromDateTime = (String) fromDateTime;
		this.toDateTime = (String) toDateTime;
		this.desc = (String) desc;
		this.costPrice = (Double) costPrice;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public Double getRunKm() {
		return runKm;
	}

	public void setRunKm(Double runKm) {
		this.runKm = runKm;
	}

	public Double getfHr() {
		return fHr;
	}

	public void setfHr(Double fHr) {
		this.fHr = fHr;
	}

	public Double getbHr() {
		return bHr;
	}

	public void setbHr(Double bHr) {
		this.bHr = bHr;
	}

	public String getMechanic() {
		return mechanic;
	}

	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getAtion() {
		return ation;
	}

	public void setAtion(String ation) {
		this.ation = ation;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getJobbCardId() {
		return jobbCardId;
	}

	public void setJobbCardId(String jobbCardId) {
		this.jobbCardId = jobbCardId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public boolean isJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(boolean jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Boolean getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Boolean jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getMechanicId() {
		return mechanicId;
	}

	public void setMechanicId(String mechanicId) {
		this.mechanicId = mechanicId;
	}

	public String getAsstMechanicId() {
		return asstMechanicId;
	}

	public void setAsstMechanicId(String asstMechanicId) {
		this.asstMechanicId = asstMechanicId;
	}

	public String getAsstMechanic() {
		return asstMechanic;
	}

	public void setAsstMechanic(String asstMechanic) {
		this.asstMechanic = asstMechanic;
	}

	public String getOutSideMechanic() {
		return outSideMechanic;
	}

	public void setOutSideMechanic(String outSideMechanic) {
		this.outSideMechanic = outSideMechanic;
	}

	public String getMechanicMob() {
		return mechanicMob;
	}

	public void setMechanicMob(String mechanicMob) {
		this.mechanicMob = mechanicMob;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(String fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public String getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(String toDateTime) {
		this.toDateTime = toDateTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

}
