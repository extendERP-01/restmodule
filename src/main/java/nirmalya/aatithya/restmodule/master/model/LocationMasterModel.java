package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationMasterModel {

	private String locationId;
	private String locationName;
	private String locationCode;
	private String locationType;
	private String locCountry;
	private String locState;
	private String locCity;
	private String locStreet;
	private String locVirtual;
	private String locStatus;
	private String createdBy;
	private String fileLocation;
	private String createdDate;
	private String floorId;
	private Integer floorSlNo;
	private BigInteger locCount;
	private BigInteger floorCount;
	
	public LocationMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationMasterModel(Object locationId, Object locationName, Object locationCode, Object locationType,
			Object locCountry, Object locState, Object locCity, Object locStreet, Object locVirtual, Object locStatus,
			Object createdBy, Object fileLocation, Object createdDate, Object floorId, Object floorSlNo, Object locCount,
			Object floorCount) {
		super();
		this.locationId = (String) locationId;
		this.locationName = (String) locationName;
		this.locationCode = (String) locationCode;
		this.locationType = (String) locationType;
		this.locCountry = (String) locCountry;
		this.locState = (String) locState;
		this.locCity = (String) locCity;
		this.locStreet = (String) locStreet;
		this.locVirtual = (String) locVirtual;
		this.locStatus = (String) locStatus;
		this.createdBy = (String) createdBy;
		this.fileLocation = (String) fileLocation;
		this.createdDate = (String) createdDate;
		this.floorId = (String) floorId;
		this.floorSlNo = (Integer) floorSlNo;
		this.locCount = (BigInteger) locCount;
		this.floorCount = (BigInteger) floorCount;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLocCountry() {
		return locCountry;
	}

	public void setLocCountry(String locCountry) {
		this.locCountry = locCountry;
	}

	public String getLocState() {
		return locState;
	}

	public void setLocState(String locState) {
		this.locState = locState;
	}

	public String getLocCity() {
		return locCity;
	}

	public void setLocCity(String locCity) {
		this.locCity = locCity;
	}

	public String getLocStreet() {
		return locStreet;
	}

	public void setLocStreet(String locStreet) {
		this.locStreet = locStreet;
	}

	public String getLocVirtual() {
		return locVirtual;
	}

	public void setLocVirtual(String locVirtual) {
		this.locVirtual = locVirtual;
	}

	public String getLocStatus() {
		return locStatus;
	}

	public void setLocStatus(String locStatus) {
		this.locStatus = locStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public Integer getFloorSlNo() {
		return floorSlNo;
	}

	public void setFloorSlNo(Integer floorSlNo) {
		this.floorSlNo = floorSlNo;
	}

	public BigInteger getLocCount() {
		return locCount;
	}

	public void setLocCount(BigInteger locCount) {
		this.locCount = locCount;
	}

	public BigInteger getFloorCount() {
		return floorCount;
	}

	public void setFloorCount(BigInteger floorCount) {
		this.floorCount = floorCount;
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
