package nirmalya.aatithya.restmodule.asset.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AssignVehicleToDriverModel {

	private String driverId;
	
	private String driverName;
	
	private String vAssetId;
	
	private String vehicleNo;
	
	private String category;
	
	private String assignDate;
	
	private Boolean assignStatus;
	
	private String createdBy;
	
	private String removeDate;
	
	private String comment;
	
	private String createdOnDate;
	
	private String createdOnTime;

	public AssignVehicleToDriverModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssignVehicleToDriverModel(Object driverId, Object driverName, Object vAssetId, Object vehicleNo,
			Object category, Object assignDate, Object assignStatus, Object createdBy, Object removeDate, Object comment,
			Object createdOnDate, Object createdOnTime) {
		super();
		this.driverId = (String) driverId;
		this.driverName = (String) driverName;
		this.vAssetId = (String) vAssetId;
		this.vehicleNo = (String) vehicleNo;
		this.category = (String) category;
		this.assignDate = (String) assignDate;
		this.assignStatus = (Boolean) assignStatus;
		this.createdBy = (String) createdBy;
		this.removeDate = (String) removeDate;
		this.comment = (String) comment;
		this.createdOnDate = (String) createdOnDate;
		this.createdOnTime = (String) createdOnTime;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getvAssetId() {
		return vAssetId;
	}

	public void setvAssetId(String vAssetId) {
		this.vAssetId = vAssetId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}

	public Boolean getAssignStatus() {
		return assignStatus;
	}

	public void setAssignStatus(Boolean assignStatus) {
		this.assignStatus = assignStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreatedOnDate() {
		return createdOnDate;
	}

	public void setCreatedOnDate(String createdOnDate) {
		this.createdOnDate = createdOnDate;
	}

	public String getCreatedOnTime() {
		return createdOnTime;
	}

	public void setCreatedOnTime(String createdOnTime) {
		this.createdOnTime = createdOnTime;
	}

	@Override
	public String toString() {
		ObjectMapper  mapperObj=new ObjectMapper();
		String jsonStr;
		try{
			jsonStr=mapperObj.writeValueAsString(this);
		}catch(IOException ex){
			
			jsonStr=ex.toString();
		}
		return jsonStr;
	}
}
