package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryCustomerMailModel {

	private String customerName;
	private String custMail;
	private String grnNo;
	private String poNumber;
	private String receivedAt;
	private String store;

	public InventoryCustomerMailModel() {
		super();
	}

	public InventoryCustomerMailModel(Object customerName, Object custMail, Object grnNo, Object poNumber,
			Object receivedAt, Object store) {
		super();
		this.customerName = (String) customerName;
		this.custMail = (String) custMail;
		this.grnNo = (String) grnNo;
		this.poNumber = (String) poNumber;
		this.receivedAt = (String) receivedAt;
		this.store = (String) store;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustMail() {
		return custMail;
	}

	public void setCustMail(String custMail) {
		this.custMail = custMail;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
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
