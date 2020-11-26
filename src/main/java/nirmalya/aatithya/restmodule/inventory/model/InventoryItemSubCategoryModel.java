/**
 * Define RestItemSubCategoryEntity
 */
package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryItemSubCategoryModel {

	/**
	 * @author Nirmalya Labs
	 *
	 */
	private String itmSubCategoryId;
	private String itmSubCategoryName;
	private String itmCategory;
	private String itmSubDescription;
	private Boolean itmSubActive;
	private Date itmSubCreatedOn;
	private Date itmSubUpdatedOn;
	private String itmCategoryName;
	private String createdBy;

	public InventoryItemSubCategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryItemSubCategoryModel(Object itmSubCategoryId, Object itmSubCategoryName, Object itmCategory,
			Object itmSubDescription, Object itmSubActive, Object itmSubCreatedOn, Object itmSubUpdatedOn,
			Object itmCategoryName,Object createdBy) {
		super();
		this.itmSubCategoryId = (String) itmSubCategoryId;
		this.itmSubCategoryName = (String) itmSubCategoryName;
		this.itmCategory = (String) itmCategory;
		this.itmSubDescription = (String) itmSubDescription;
		this.itmSubActive = (Boolean) itmSubActive;
		this.itmSubCreatedOn = (Date) itmSubCreatedOn;
		this.itmSubUpdatedOn = (Date) itmSubUpdatedOn;
		this.itmCategoryName = (String) itmCategoryName;
		this.createdBy = (String) createdBy;
	}

	public String getItmSubCategoryId() {
		return itmSubCategoryId;
	}

	public void setItmSubCategoryId(String itmSubCategoryId) {
		this.itmSubCategoryId = itmSubCategoryId;
	}

	public String getItmSubCategoryName() {
		return itmSubCategoryName;
	}

	public void setItmSubCategoryName(String itmSubCategoryName) {
		this.itmSubCategoryName = itmSubCategoryName;
	}

	public String getItmCategory() {
		return itmCategory;
	}

	public void setItmCategory(String itmCategory) {
		this.itmCategory = itmCategory;
	}

	public String getItmSubDescription() {
		return itmSubDescription;
	}

	public void setItmSubDescription(String itmSubDescription) {
		this.itmSubDescription = itmSubDescription;
	}

	public Boolean getItmSubActive() {
		return itmSubActive;
	}

	public void setItmSubActive(Boolean itmSubActive) {
		this.itmSubActive = itmSubActive;
	}

	public Date getItmSubCreatedOn() {
		return itmSubCreatedOn;
	}

	public void setItmSubCreatedOn(Date itmSubCreatedOn) {
		this.itmSubCreatedOn = itmSubCreatedOn;
	}

	public Date getItmSubUpdatedOn() {
		return itmSubUpdatedOn;
	}

	public void setItmSubUpdatedOn(Date itmSubUpdatedOn) {
		this.itmSubUpdatedOn = itmSubUpdatedOn;
	}

	public String getItmCategoryName() {
		return itmCategoryName;
	}

	public void setItmCategoryName(String itmCategoryName) {
		this.itmCategoryName = itmCategoryName;
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
