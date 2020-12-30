package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertySeattingPlanModel {
	private String seatingPlan;
	private String propertyCategory;
	private String planName;
	private String themeCategoryName;
	private String planlogo;
	private String planDescription;
	private Boolean planActive;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;

	public PropertySeattingPlanModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertySeattingPlanModel(Object seatingPlan, Object propertyCategory, Object planName,
			Object themeCategoryName, Object planlogo, Object planDescription, Object planActive) {
		super();
		try {
			this.seatingPlan = (String) seatingPlan;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyCategory = (String) propertyCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.planName = (String) planName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.themeCategoryName = (String) themeCategoryName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.planlogo = (String) planlogo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.planDescription = (String) planDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.planActive = (Boolean) planActive;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getSeatingPlan() {
		return seatingPlan;
	}

	public void setSeatingPlan(String seatingPlan) {
		this.seatingPlan = seatingPlan;
	}

	public String getPropertyCategory() {
		return propertyCategory;
	}

	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanlogo() {
		return planlogo;
	}

	public void setPlanlogo(String planlogo) {
		this.planlogo = planlogo;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public Boolean getPlanActive() {
		return planActive;
	}

	public void setPlanActive(Boolean planActive) {
		this.planActive = planActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getThemeCategoryName() {
		return themeCategoryName;
	}

	public void setThemeCategoryName(String themeCategoryName) {
		this.themeCategoryName = themeCategoryName;
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
