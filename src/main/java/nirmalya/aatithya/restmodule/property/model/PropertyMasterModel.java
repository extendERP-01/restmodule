/*
 * Rest model for property master 
 */
package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyMasterModel {
	private String propertyId;
	private String propertyCategory;
	private String propertyType;
	private String propertyFloor;
	private String propertyName;
	private Boolean cleanStatus;
	private String propertyDescription;
	private Boolean propertyActive;
	private String propertyCreatedBy;
	private Boolean pBookingStatus;
	private Boolean reservationStatus;

	public PropertyMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyMasterModel(Object propertyId, Object propertyCategory, Object propertyType, Object propertyFloor,

			Object propertyName, Object cleanStatus, Object propertyDescription, Object propertyActive,
			Object pBookingStatus, Object reservationStatus) {
		super();

		try {
			this.propertyId = (String) propertyId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.propertyCategory = (String) propertyCategory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.propertyType = (String) propertyType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.propertyFloor = (String) propertyFloor;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.propertyName = (String) propertyName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.cleanStatus = (Boolean) cleanStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.propertyDescription = (String) propertyDescription;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.propertyActive = (Boolean) propertyActive;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.pBookingStatus = (Boolean) pBookingStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.reservationStatus = (Boolean) reservationStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyCategory() {
		return propertyCategory;
	}

	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyFloor() {
		return propertyFloor;
	}

	public void setPropertyFloor(String propertyFloor) {
		this.propertyFloor = propertyFloor;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Boolean getCleanStatus() {
		return cleanStatus;
	}

	public void setCleanStatus(Boolean cleanStatus) {
		this.cleanStatus = cleanStatus;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public Boolean getPropertyActive() {
		return propertyActive;
	}

	public void setPropertyActive(Boolean propertyActive) {
		this.propertyActive = propertyActive;
	}

	public String getPropertyCreatedBy() {
		return propertyCreatedBy;
	}

	public void setPropertyCreatedBy(String propertyCreatedBy) {
		this.propertyCreatedBy = propertyCreatedBy;
	}

	public Boolean getpBookingStatus() {
		return pBookingStatus;
	}

	public void setpBookingStatus(Boolean pBookingStatus) {
		this.pBookingStatus = pBookingStatus;
	}

	public Boolean getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(Boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
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
