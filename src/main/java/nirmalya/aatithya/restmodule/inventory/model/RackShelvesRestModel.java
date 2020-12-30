package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RackShelvesRestModel {

	private String rackId;
	private String store;
	private String subInventory;
	private String warehouse;
	private String rackName;
	private Double shelvesCapacity;
	private String shelf;
	private String itemId;
	private Double itemCapacity;
	private String createdBy;
	private String slNo;
	
	public RackShelvesRestModel() {
		super();
	}
	
	public RackShelvesRestModel(Object rackId, Object store, Object subInventory, Object warehouse, Object rackName,
			Object shelvesCapacity, Object shelf, Object itemId, Object itemCapacity, Object createdBy, Object slNo) {
		super();
		this.rackId = (String) rackId;
		this.store = (String) store;
		this.subInventory = (String) subInventory;
		this.warehouse = (String) warehouse;
		this.rackName = (String) rackName;
		this.shelvesCapacity = (Double) shelvesCapacity;
		this.shelf = (String) shelf;
		this.itemId = (String) itemId;
		this.itemCapacity = (Double) itemCapacity;
		this.createdBy = (String) createdBy;
		this.slNo = (String) slNo;
	}

	public String getRackId() {
		return rackId;
	}
	public void setRackId(String rackId) {
		this.rackId = rackId;
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
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getRackName() {
		return rackName;
	}
	public void setRackName(String rackName) {
		this.rackName = rackName;
	}
	public Double getShelvesCapacity() {
		return shelvesCapacity;
	}
	public void setShelvesCapacity(Double shelvesCapacity) {
		this.shelvesCapacity = shelvesCapacity;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Double getItemCapacity() {
		return itemCapacity;
	}
	public void setItemCapacity(Double itemCapacity) {
		this.itemCapacity = itemCapacity;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getSlNo() {
		return slNo;
	}
	public void setSlNo(String slNo) {
		this.slNo = slNo;
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
