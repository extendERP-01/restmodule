package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyTypeForm {

	private String propertyType;
	
	private String pTypeName;

	private String propertyCategory;

	private String pCategoryName;
	
	private String amenities;

	private String amntsName;

	private String pTypeDescription;

	private Boolean pTypeActive;
	
	private String createdBy;

	public PropertyTypeForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public PropertyTypeForm(Object propertyType, Object pTypeName, Object propertyCategory, Object pCategoryName,
			Object amenities, Object amntsName, Object pTypeDescription, Object pTypeActive) {
		super();
		this.propertyType = (String)propertyType;
		this.pTypeName = (String)pTypeName;
		this.propertyCategory = (String)propertyCategory;
		this.pCategoryName = (String)pCategoryName;
		this.amenities = (String)amenities;
		this.amntsName = (String)amntsName;
		this.pTypeDescription = (String)pTypeDescription;
		this.pTypeActive = (Boolean)pTypeActive;
	}



	public String getPropertyType() {
		return propertyType;
	}


	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}


	public String getPropertyCategory() {
		return propertyCategory;
	}

	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
	}

	
	
	public String getpCategoryName() {
		return pCategoryName;
	}



	public void setpCategoryName(String pCategoryName) {
		this.pCategoryName = pCategoryName;
	}



	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}


	public String getAmntsName() {
		return amntsName;
	}

	public void setAmntsName(String amntsName) {
		this.amntsName = amntsName;
	}

	public String getpTypeName() {
		return pTypeName;
	}

	public void setpTypeName(String pTypeName) {
		this.pTypeName = pTypeName;
	}

	public String getpTypeDescription() {
		return pTypeDescription;
	}


	public void setpTypeDescription(String pTypeDescription) {
		this.pTypeDescription = pTypeDescription;
	}


	public Boolean getpTypeActive() {
		return pTypeActive;
	}

	public void setpTypeActive(Boolean pTypeActive) {
		this.pTypeActive = pTypeActive;
	}

	
	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	@Override
	public String toString() {
		ObjectMapper  mapperObj=new ObjectMapper();
		String jsonStr;
		try{
			jsonStr=mapperObj.writeValueAsString(this);
		}catch(IOException ex){
			
			jsonStr=ex.toString();
		}
		return jsonStr;
	}
}
