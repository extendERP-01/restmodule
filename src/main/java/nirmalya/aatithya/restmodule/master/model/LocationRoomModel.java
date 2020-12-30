package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationRoomModel {

	private String locationId;
	private String floorId;
	private String sectionId;
	private String roomId;
	private String locationCode;
	private String floorCode;
	private String sectionCode;
	private String roomCode;
	private String floorName;
	private String sectionName;
	private String roomName;
	private Integer floorSlNo;
	private Integer sectionSlNO;
	private Integer roomSlNO;
	private String roomType;
	private String createdBy;
	
	public LocationRoomModel() {
		super();
	}

	public LocationRoomModel(Object locationId, Object floorId, Object sectionId, Object roomId, Object locationCode,
			Object floorCode, Object sectionCode, Object roomCode, Object floorName, Object sectionName,
			Object roomName, Object floorSlNo, Object sectionSlNO, Object roomSlNO, Object roomType, Object createdBy) {
		super();
		this.locationId = (String) locationId;
		this.floorId = (String) floorId;
		this.sectionId = (String) sectionId;
		this.roomId = (String) roomId;
		this.locationCode = (String) locationCode;
		this.floorCode = (String) floorCode;
		this.sectionCode = (String) sectionCode;
		this.roomCode = (String) roomCode;
		this.floorName = (String) floorName;
		this.sectionName = (String) sectionName;
		this.roomName = (String) roomName;
		this.floorSlNo = (Integer) floorSlNo;
		this.sectionSlNO = (Integer) sectionSlNO;
		this.roomSlNO = (Integer) roomSlNO;
		this.roomType = (String) roomType;
		this.createdBy = (String) createdBy;
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

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getFloorSlNo() {
		return floorSlNo;
	}

	public void setFloorSlNo(Integer floorSlNo) {
		this.floorSlNo = floorSlNo;
	}

	public Integer getSectionSlNO() {
		return sectionSlNO;
	}

	public void setSectionSlNO(Integer sectionSlNO) {
		this.sectionSlNO = sectionSlNO;
	}

	public Integer getRoomSlNO() {
		return roomSlNO;
	}

	public void setRoomSlNO(Integer roomSlNO) {
		this.roomSlNO = roomSlNO;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
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
