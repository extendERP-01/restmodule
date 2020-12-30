package nirmalya.aatithya.restmodule.master.model;

public class ZoneRackModel {
	private String warehouseId;
	private String zoneId;
	private String rackId;
	private String rackCode;
	private String rackName;
	private Integer rackSlNo;
	private String createdBy;
	
	public ZoneRackModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZoneRackModel(Object warehouseId,Object zoneId, Object rackId, Object rackCode,Object rackName,Object rackSlNo) {
		super();
		this.warehouseId = (String) warehouseId;
		this.zoneId = (String) zoneId;
		this.rackId = (String) rackId;
		this.rackCode = (String) rackCode;
		this.rackName = (String) rackName;		
		this.rackSlNo = (Integer) rackSlNo;
		
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getRackId() {
		return rackId;
	}
	public void setRackId(String rackId) {
		this.rackId = rackId;
	}
	public String getRackCode() {
		return rackCode;
	}
	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}
	public String getRackName() {
		return rackName;
	}
	public void setRackName(String rackName) {
		this.rackName = rackName;
	}
	public Integer getRackSlNo() {
		return rackSlNo;
	}
	public void setRackSlNo(Integer rackSlNo) {
		this.rackSlNo = rackSlNo;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
