package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;



public class AmenityForm {


	private String amenitiesId;

	private String propertyCategoryId;

	private String propertyCategoryName;

	private String amntsName;

	private String amntsDescription;

	private Boolean amntsActive;
	
	private String createdBy;

	public AmenityForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAmenitiesId() {
		return amenitiesId;
	}

	public void setAmenitiesId(String amenitiesId) {
		this.amenitiesId = amenitiesId;
	}

	public String getPropertyCategoryId() {
		return propertyCategoryId;
	}

	public void setPropertyCategoryId(String propertyCategoryId) {
		this.propertyCategoryId = propertyCategoryId;
	}

	public String getPropertyCategoryName() {
		return propertyCategoryName;
	}

	public void setPropertyCategoryName(String propertyCategoryName) {
		this.propertyCategoryName = propertyCategoryName;
	}

	public String getAmntsName() {
		return amntsName;
	}

	public void setAmntsName(String amntsName) {
		this.amntsName = amntsName;
	}

	public String getAmntsDescription() {
		return amntsDescription;
	}

	public void setAmntsDescription(String amntsDescription) {
		this.amntsDescription = amntsDescription;
	}

	public Boolean getAmntsActive() {
		return amntsActive;
	}

	public void setAmntsActive(Boolean amntsActive) {
		this.amntsActive = amntsActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public AmenityForm(Object amenitiesId, Object propertyCategoryId, Object propertyCategoryName, Object amntsName,
			Object amntsDescription, Object amntsActive) {
		super();

		try {
			this.amenitiesId = (String) amenitiesId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.propertyCategoryId = (String) propertyCategoryId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.propertyCategoryName = (String) propertyCategoryName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.amntsName = (String) amntsName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.amntsDescription = (String) amntsDescription;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.amntsActive = (Boolean) amntsActive;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
