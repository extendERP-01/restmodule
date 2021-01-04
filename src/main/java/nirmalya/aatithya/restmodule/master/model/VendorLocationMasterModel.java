package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VendorLocationMasterModel {
	private String vendorLocationId;
	private String vendorId;
	private String vendorLocationName;
	private String vendorLocationType;
	private String vendorBillingStatus;
	private String vendorPrimaryStatus;
	private String vendorLocAddress;
	private String vendorCountry;
	private String vendorCity;
	private String vendorState;
	private String createdBy;
	public VendorLocationMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VendorLocationMasterModel(Object vendorLocationId,Object vendorId, Object vendorLocationName, Object vendorLocationType, Object vendorBillingStatus,
			Object vendorPrimaryStatus, Object vendorLocAddress, Object vendorCountry,Object vendorState, Object vendorCity,  Object createdBy) {
		super();
		this.vendorLocationId = (String) vendorLocationId;
		this.vendorId = (String) vendorId;
		
		this.vendorLocationName = (String) vendorLocationName;
		this.vendorLocationType = (String) vendorLocationType;
		this.vendorBillingStatus = (String) vendorBillingStatus;
		this.vendorPrimaryStatus = (String) vendorPrimaryStatus;
		this.vendorLocAddress = (String) vendorLocAddress;
		this.vendorCountry = (String) vendorCountry;
		this.vendorState = (String) vendorState;
		this.vendorCity = (String) vendorCity;
		
		this.createdBy = (String) createdBy;
		
	}
	public String getVendorLocationId() {
		return vendorLocationId;
	}
	public void setVendorLocationId(String vendorLocationId) {
		this.vendorLocationId = vendorLocationId;
	}
	
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorLocationName() {
		return vendorLocationName;
	}
	public void setVendorLocationName(String vendorLocationName) {
		this.vendorLocationName = vendorLocationName;
	}
	public String getVendorLocationType() {
		return vendorLocationType;
	}
	public void setVendorLocationType(String vendorLocationType) {
		this.vendorLocationType = vendorLocationType;
	}
	public String getVendorBillingStatus() {
		return vendorBillingStatus;
	}
	public void setVendorBillingStatus(String vendorBillingStatus) {
		this.vendorBillingStatus = vendorBillingStatus;
	}
	public String getVendorPrimaryStatus() {
		return vendorPrimaryStatus;
	}
	public void setVendorPrimaryStatus(String vendorPrimaryStatus) {
		this.vendorPrimaryStatus = vendorPrimaryStatus;
	}
	public String getVendorLocAddress() {
		return vendorLocAddress;
	}
	public void setVendorLocAddress(String vendorLocAddress) {
		this.vendorLocAddress = vendorLocAddress;
	}
	public String getVendorCountry() {
		return vendorCountry;
	}
	public void setVendorCountry(String vendorCountry) {
		this.vendorCountry = vendorCountry;
	}
	public String getVendorCity() {
		return vendorCity;
	}
	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}
	public String getVendorState() {
		return vendorState;
	}
	public void setVendorState(String vendorState) {
		this.vendorState = vendorState;
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
