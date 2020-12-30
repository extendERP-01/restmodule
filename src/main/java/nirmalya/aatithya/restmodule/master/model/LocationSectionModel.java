package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationSectionModel {
	
	private String locationId;
	private String floorId;
	private String sectionId;
	private String sectionCode;
	private String sectionName;
	private String createdBy;
	private Integer floorSlNo;
	private Integer secSlNo;
	private String floorCode;
	private BigInteger sectionCount;
	
	public LocationSectionModel() {
		super();
	}

	public LocationSectionModel(Object locationId, Object floorId, Object sectionId, Object sectionCode,
			Object sectionName, Object createdBy, Object floorSlNo, Object secSlNo, Object floorCode,
			Object sectionCount) {
		super();
		this.locationId = (String) locationId;
		this.floorId = (String) floorId;
		this.sectionId = (String) sectionId;
		this.sectionCode = (String) sectionCode;
		this.sectionName = (String) sectionName;
		this.createdBy = (String) createdBy;
		this.floorSlNo = (Integer) floorSlNo;
		this.secSlNo = (Integer) secSlNo;
		this.floorCode = (String) floorCode;
		this.sectionCount = (BigInteger) sectionCount;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Integer getFloorSlNo() {
		return floorSlNo;
	}

	public void setFloorSlNo(Integer floorSlNo) {
		this.floorSlNo = floorSlNo;
	}

	public Integer getSecSlNo() {
		return secSlNo;
	}

	public void setSecSlNo(Integer secSlNo) {
		this.secSlNo = secSlNo;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public BigInteger getSectionCount() {
		return sectionCount;
	}

	public void setSectionCount(BigInteger sectionCount) {
		this.sectionCount = sectionCount;
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
