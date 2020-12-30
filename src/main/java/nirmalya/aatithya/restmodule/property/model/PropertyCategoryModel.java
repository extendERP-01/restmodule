/*
 *  model for property category in rest
 */
package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyCategoryModel {
	private String propertyCatId;
	private String categoryName;
	private String categoryDescription;
	private Boolean categoryActive;

	public PropertyCategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyCategoryModel(Object propertyCatId, Object categoryName, Object categoryDescription,
			Object categoryActive) {
		super();

		try {
			this.propertyCatId = (String) propertyCatId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.categoryName = (String) categoryName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.categoryDescription = (String) categoryDescription;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.categoryActive = (Boolean) categoryActive;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPropertyCatId() {
		return propertyCatId;
	}

	public void setPropertyCatId(String propertyCatId) {
		this.propertyCatId = propertyCatId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Boolean getCategoryActive() {
		return categoryActive;
	}

	public void setCategoryActive(Boolean categoryActive) {
		this.categoryActive = categoryActive;
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
