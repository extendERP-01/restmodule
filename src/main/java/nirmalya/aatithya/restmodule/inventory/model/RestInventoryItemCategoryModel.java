/**
 * Class Showing ItemCategory Entity
 */
package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestInventoryItemCategoryModel {

	private String itmCategory;
	private String itmCatName;
	private String itmCatDescription;
	private Boolean itmCatActive;
	private String createdBy;

	public String getItmCategory() {
		return itmCategory;
	}

	public void setItmCategory(String itmCategory) {
		this.itmCategory = itmCategory;
	}

	public String getItmCatName() {
		return itmCatName;
	}

	public void setItmCatName(String itmCatName) {
		this.itmCatName = itmCatName;
	}

	public String getItmCatDescription() {
		return itmCatDescription;
	}

	public void setItmCatDescription(String itmCatDescription) {
		this.itmCatDescription = itmCatDescription;
	}

	public Boolean getItmCatActive() {
		return itmCatActive;
	}

	public void setItmCatActive(Boolean itmCatActive) {
		this.itmCatActive = itmCatActive;
	}

	public RestInventoryItemCategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public RestInventoryItemCategoryModel(Object itmCategory, Object itmCatName, Object itmCatDescription, Object itmCatActive,Object createdBy) {
		super();
		try {
			this.itmCategory = (String) itmCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			this.itmCatName = (String) itmCatName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itmCatDescription = (String) itmCatDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itmCatActive = (Boolean) itmCatActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
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
