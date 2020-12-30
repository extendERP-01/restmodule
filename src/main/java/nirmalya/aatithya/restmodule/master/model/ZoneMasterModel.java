package nirmalya.aatithya.restmodule.master.model;

public class ZoneMasterModel {
private String zoneId;
private String zoneCode;
private String zoneName;
private String createdBy;
private String warehouseId;
private Integer zoneSlNo;
public ZoneMasterModel() {
	super();
	// TODO Auto-generated constructor stub
}
public ZoneMasterModel(Object zoneId,Object warehouseId, Object zoneCode, Object zoneName,Object zoneSlNo) {
	super();
	this.zoneId = (String) zoneId;
	this.warehouseId = (String) warehouseId;
	this.zoneCode = (String) zoneCode;
	this.zoneName = (String) zoneName;
	this.zoneSlNo = (Integer) zoneSlNo;
	
}
public String getZoneId() {
	return zoneId;
}
public void setZoneId(String zoneId) {
	this.zoneId = zoneId;
}

public String getWarehouseId() {
	return warehouseId;
}
public void setWarehouseId(String warehouseId) {
	this.warehouseId = warehouseId;
}
public String getZoneCode() {
	return zoneCode;
}
public void setZoneCode(String zoneCode) {
	this.zoneCode = zoneCode;
}
public String getZoneName() {
	return zoneName;
}
public void setZoneName(String zoneName) {
	this.zoneName = zoneName;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public Integer getZoneSlNo() {
	return zoneSlNo;
}
public void setZoneSlNo(Integer zoneSlNo) {
	this.zoneSlNo = zoneSlNo;
}

}
