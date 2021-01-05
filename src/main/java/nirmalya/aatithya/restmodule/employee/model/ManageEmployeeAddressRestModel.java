package nirmalya.aatithya.restmodule.employee.model;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageEmployeeAddressRestModel {
	

	private String addressId;
	private String employeeId;
	private String type;
	private String address;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String status;
	private String createdBy;
	public ManageEmployeeAddressRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManageEmployeeAddressRestModel(Object addressId, Object employeeId, Object type, Object address, Object city,
			Object state, Object country, Object zipCode, Object status, Object createdBy) {
		super();
		this.addressId = (String)addressId;
		this.employeeId = (String)employeeId;
		this.type = (String)type;
		this.address = (String)address;
		this.city =(String) city;
		this.state = (String)state;
		this.country =(String) country;
		this.zipCode = (String)zipCode;
		this.status =(String) status;
		this.createdBy =(String) createdBy;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
