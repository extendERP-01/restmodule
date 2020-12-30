package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WarehouseMasterRestModel {

	private String warehouseId;
	private String warehouseName;
	private String store;
	private String subInventory;
	private String whDesc;
	private String whActive;
	private String createdBy;
	
	public WarehouseMasterRestModel() {
		super();
	}

	public WarehouseMasterRestModel(Object warehouseId, Object warehouseName, Object store, Object subInventory,
			Object whDesc, Object whActive, Object createdBy) {
		super();
		this.warehouseId = (String) warehouseId;
		this.warehouseName = (String) warehouseName;
		this.store = (String) store;
		this.subInventory = (String) subInventory;
		this.whDesc = (String) whDesc;
		this.whActive = (String) whActive;
		this.createdBy = (String) createdBy;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getSubInventory() {
		return subInventory;
	}

	public void setSubInventory(String subInventory) {
		this.subInventory = subInventory;
	}

	public String getWhDesc() {
		return whDesc;
	}

	public void setWhDesc(String whDesc) {
		this.whDesc = whDesc;
	}

	public String getWhActive() {
		return whActive;
	}

	public void setWhActive(String whActive) {
		this.whActive = whActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
