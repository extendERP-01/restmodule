/**
 * Class defines property  entity.
 *
 */
package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class PropertyModel {
	
	private Integer propertyType;
	
	private String propertyCategory;
	
	private String pTypeName;
	
	private String pTypeDescription;
	
	private Boolean pTypeActive;
	
	private Date pTypeCreatedOn;
	
	private Date pTypeUpdatedOn;

	
	public Integer getPropertyType() {
		return propertyType;
	}


	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}


	public String getPropertyCategory() {
		return propertyCategory;
	}


	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
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


	public Date getpTypeCreatedOn() {
		return pTypeCreatedOn;
	}


	public void setpTypeCreatedOn(Date pTypeCreatedOn) {
		this.pTypeCreatedOn = pTypeCreatedOn;
	}


	public Date getpTypeUpdatedOn() {
		return pTypeUpdatedOn;
	}


	public void setpTypeUpdatedOn(Date pTypeUpdatedOn) {
		this.pTypeUpdatedOn = pTypeUpdatedOn;
	}


	public PropertyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PropertyModel(Object propertyType, Object propertyCategory, Object pTypeName,
			Object pTypeDescription, Object pTypeActive, Object pTypeCreatedOn,
			Object pTypeUpdatedOn) {
		super();
		try {
			this.propertyType = (Integer) propertyType;
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			this.propertyCategory = (String) propertyCategory;
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			this.pTypeName = (String) pTypeName;
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			this.pTypeDescription = (String) pTypeDescription;
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			this.pTypeActive = (Boolean) pTypeActive;
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			this.pTypeCreatedOn = (Date) pTypeCreatedOn;
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			this.pTypeUpdatedOn = (Date) pTypeUpdatedOn;
		}catch(Exception e){
			e.printStackTrace();
		}
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
