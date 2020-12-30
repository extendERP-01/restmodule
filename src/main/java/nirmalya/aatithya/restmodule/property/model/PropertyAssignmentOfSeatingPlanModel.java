package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyAssignmentOfSeatingPlanModel {

	private String propertyType;
	private String seatingPlan;
	private Integer pSplanCapacity;
	private String sPlanImage;
	private String pSplanPrice;
	private Boolean pSplanActive;
	private String propertyCategory;
	private String propertyTypeName;
	private String propertyCategoryName;
	private String seatingPlanName;
	private String id;
	private String userType;
	private String createdBy;
	private String userTypeName;

	public PropertyAssignmentOfSeatingPlanModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyAssignmentOfSeatingPlanModel(Object propertyType, Object seatingPlan, Object pSplanCapacity,
			Object sPlanImage, Object pSplanPrice, Object pSplanActive, Object propertyCategory,
			Object propertyTypeName, Object propertyCategoryName, Object seatingPlanName, Object userType,
			Object createdBy, Object userTypeName) {
		super();
		try {
			this.propertyType = (String) propertyType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.seatingPlan = (String) seatingPlan;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pSplanCapacity = (Integer) pSplanCapacity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.sPlanImage = (String) sPlanImage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pSplanPrice = (String) pSplanPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pSplanActive = (Boolean) pSplanActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyCategory = (String) propertyCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyTypeName = (String) propertyTypeName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyCategoryName = (String) propertyCategoryName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.seatingPlanName = (String) seatingPlanName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.userType = (String) userType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.userTypeName = (String) userTypeName;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getSeatingPlan() {
		return seatingPlan;
	}

	public void setSeatingPlan(String seatingPlan) {
		this.seatingPlan = seatingPlan;
	}

	public Integer getpSplanCapacity() {
		return pSplanCapacity;
	}

	public void setpSplanCapacity(Integer pSplanCapacity) {
		this.pSplanCapacity = pSplanCapacity;
	}

	public String getsPlanImage() {
		return sPlanImage;
	}

	public void setsPlanImage(String sPlanImage) {
		this.sPlanImage = sPlanImage;
	}

	public String getpSplanPrice() {
		return pSplanPrice;
	}

	public void setpSplanPrice(String pSplanPrice) {
		this.pSplanPrice = pSplanPrice;
	}

	public Boolean getpSplanActive() {
		return pSplanActive;
	}

	public void setpSplanActive(Boolean pSplanActive) {
		this.pSplanActive = pSplanActive;
	}

	public String getPropertyCategory() {
		return propertyCategory;
	}

	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
	}

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}

	public String getPropertyCategoryName() {
		return propertyCategoryName;
	}

	public void setPropertyCategoryName(String propertyCategoryName) {
		this.propertyCategoryName = propertyCategoryName;
	}

	public String getSeatingPlanName() {
		return seatingPlanName;
	}

	public void setSeatingPlanName(String seatingPlanName) {
		this.seatingPlanName = seatingPlanName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
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
