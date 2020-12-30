/**
 * Define RestItemServeTypeEntity
 */
package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 */
public class InventoryItemServeTypeModel
{

	private String itmServeTypeId;
	private String itmServeTypeName;
	private String itmServeTypeDescription;
	private Boolean itmServeTypeActive;
	private Date itmServeTypeCreatedOn;
	private Date itmServeTypeUpdatedOn;
	private String createdBy;
	
	public InventoryItemServeTypeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryItemServeTypeModel(Object itmServeTypeId, Object itmServeTypeName, Object itmServeTypeDescription,
			Object itmServeTypeActive, Object itmServeTypeCreatedOn, Object itmServeTypeUpdatedOn,Object createdBy) {
		super();
		this.itmServeTypeId = (String) itmServeTypeId;
		this.itmServeTypeName = (String) itmServeTypeName;
		this.itmServeTypeDescription = (String) itmServeTypeDescription;
		this.itmServeTypeActive = (Boolean) itmServeTypeActive;
		this.itmServeTypeCreatedOn = (Date) itmServeTypeCreatedOn;
		this.itmServeTypeUpdatedOn = (Date) itmServeTypeUpdatedOn;
		this.createdBy = (String) createdBy;
	}

	public String getItmServeTypeId() {
		return itmServeTypeId;
	}

	public void setItmServeTypeId(String itmServeTypeId) {
		this.itmServeTypeId = itmServeTypeId;
	}

	public String getItmServeTypeName() {
		return itmServeTypeName;
	}

	public void setItmServeTypeName(String itmServeTypeName) {
		this.itmServeTypeName = itmServeTypeName;
	}

	public String getItmServeTypeDescription() {
		return itmServeTypeDescription;
	}

	public void setItmServeTypeDescription(String itmServeTypeDescription) {
		this.itmServeTypeDescription = itmServeTypeDescription;
	}

	public Boolean getItmServeTypeActive() {
		return itmServeTypeActive;
	}

	public void setItmServeTypeActive(Boolean itmServeTypeActive) {
		this.itmServeTypeActive = itmServeTypeActive;
	}

	public Date getItmServeTypeCreatedOn() {
		return itmServeTypeCreatedOn;
	}

	public void setItmServeTypeCreatedOn(Date itmServeTypeCreatedOn) {
		this.itmServeTypeCreatedOn = itmServeTypeCreatedOn;
	}

	public Date getItmServeTypeUpdatedOn() {
		return itmServeTypeUpdatedOn;
	}

	public void setItmServeTypeUpdatedOn(Date itmServeTypeUpdatedOn) {
		this.itmServeTypeUpdatedOn = itmServeTypeUpdatedOn;
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
