package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestSubInventoryMasterModel {

	private String subInventoryId;
	private String subInventoryName;
	private String store;
	private String subInvDesc;
	private String subInvActive;
	private String createdBy;
	
	public RestSubInventoryMasterModel() {
		super();
	}

	public RestSubInventoryMasterModel(Object subInventoryId, Object subInventoryName, Object store, Object subInvDesc,
			Object subInvActive, Object createdBy) {
		super();
		this.subInventoryId = (String) subInventoryId;
		this.subInventoryName = (String) subInventoryName;
		this.store = (String) store;
		this.subInvDesc = (String) subInvDesc;
		this.subInvActive = (String) subInvActive;
		this.createdBy = (String) createdBy;
	}

	public String getSubInventoryId() {
		return subInventoryId;
	}

	public void setSubInventoryId(String subInventoryId) {
		this.subInventoryId = subInventoryId;
	}

	public String getSubInventoryName() {
		return subInventoryName;
	}

	public void setSubInventoryName(String subInventoryName) {
		this.subInventoryName = subInventoryName;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getSubInvDesc() {
		return subInvDesc;
	}

	public void setSubInvDesc(String subInvDesc) {
		this.subInvDesc = subInvDesc;
	}

	public String getSubInvActive() {
		return subInvActive;
	}

	public void setSubInvActive(String subInvActive) {
		this.subInvActive = subInvActive;
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
