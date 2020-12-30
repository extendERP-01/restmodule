package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryStoreDetailsModel {

	private String storeId;
	private String storeName;
	private String storeAddrs;
	private String storeCity;
	private String storePin;
	private String storeMob;
	private String storeGst;

	public InventoryStoreDetailsModel() {
		super();
	}

	public InventoryStoreDetailsModel(Object storeId, Object storeName, Object storeAddrs, Object storeCity,
			Object storePin, Object storeMob, Object storeGst) {
		super();
		this.storeId = (String) storeId;
		this.storeName = (String) storeName;
		this.storeAddrs = (String) storeAddrs;
		this.storeCity = (String) storeCity;
		this.storePin = (String) storePin;
		this.storeMob = (String) storeMob;
		this.storeGst = (String) storeGst;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddrs() {
		return storeAddrs;
	}

	public void setStoreAddrs(String storeAddrs) {
		this.storeAddrs = storeAddrs;
	}

	public String getStoreCity() {
		return storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}

	public String getStorePin() {
		return storePin;
	}

	public void setStorePin(String storePin) {
		this.storePin = storePin;
	}

	public String getStoreMob() {
		return storeMob;
	}

	public void setStoreMob(String storeMob) {
		this.storeMob = storeMob;
	}

	public String getStoreGst() {
		return storeGst;
	}

	public void setStoreGst(String storeGst) {
		this.storeGst = storeGst;
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
