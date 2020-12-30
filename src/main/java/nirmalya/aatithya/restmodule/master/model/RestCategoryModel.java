package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestCategoryModel {
	private String category;
	private String categoryName;
	private String description;
	private String categoryCreatedOn;
	private String categoryUpdatedOn;
	private String createdBy;
	public RestCategoryModel(Object category, Object categoryName, Object description,Object categoryCreatedOn, Object categoryUpdatedOn,Object createdBy) {
		super();
		this.category =(String) category;
		this.categoryName = (String)categoryName;
		this.description = (String)description;
		this.categoryCreatedOn =(String) categoryCreatedOn;
		this.categoryUpdatedOn = (String)categoryUpdatedOn;
		this.createdBy = (String)createdBy;
	}


	public RestCategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategoryCreatedOn() {
		return categoryCreatedOn;
	}


	public void setCategoryCreatedOn(String categoryCreatedOn) {
		this.categoryCreatedOn = categoryCreatedOn;
	}


	public String getCategoryUpdatedOn() {
		return categoryUpdatedOn;
	}


	public void setCategoryUpdatedOn(String categoryUpdatedOn) {
		this.categoryUpdatedOn = categoryUpdatedOn;
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
