/**
 * 
 */
package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author USER
 *
 */
public class PropertyAssignConsumedItemModel {

	private String propertyCategory;
	private String propertyNameId;
	private String amenity;
	private String itemCategory;
	private String itemSubCategory;
	private String itemNameId;
	private Float assignQuantity;
	private Boolean assignActive;
	private String propertyName;
	private String itemName;
	private String createdBy;
	private String createdOn;

	public PropertyAssignConsumedItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyAssignConsumedItemModel(Object propertyCategory, Object propertyNameId, Object amenity,
			Object itemCategory, Object itemSubCategory, Object itemNameId, Object assignQuantity, Object assignActive,
			Object propertyName, Object itemName, Object createdBy, Object createdOn) {
		super();
		this.propertyCategory = (String) propertyCategory;
		this.propertyNameId = (String) propertyNameId;
		this.amenity = (String) amenity;
		this.itemCategory = (String) itemCategory;
		this.itemSubCategory = (String) itemSubCategory;
		this.itemNameId = (String) itemNameId;
		this.assignQuantity = (Float) assignQuantity;
		this.assignActive = (Boolean) assignActive;
		this.propertyName = (String) propertyName;
		this.itemName = (String) itemName;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
	}

	public String getPropertyCategory() {
		return propertyCategory;
	}

	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
	}

	public String getPropertyNameId() {
		return propertyNameId;
	}

	public void setPropertyNameId(String propertyNameId) {
		this.propertyNameId = propertyNameId;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemSubCategory() {
		return itemSubCategory;
	}

	public void setItemSubCategory(String itemSubCategory) {
		this.itemSubCategory = itemSubCategory;
	}

	public String getItemNameId() {
		return itemNameId;
	}

	public void setItemNameId(String itemNameId) {
		this.itemNameId = itemNameId;
	}

	public Float getAssignQuantity() {
		return assignQuantity;
	}

	public void setAssignQuantity(Float assignQuantity) {
		this.assignQuantity = assignQuantity;
	}

	public Boolean getAssignActive() {
		return assignActive;
	}

	public void setAssignActive(Boolean assignActive) {
		this.assignActive = assignActive;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
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
