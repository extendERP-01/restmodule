/*
 * Model for Property theme
 */
package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyThemeModel {

	private String theme;

	private String thmName;
	private String propertyCategory;
	private String themeCategoryName;
	private String thmDescription;
	private Boolean thmActive;
	private String createdBy;

	public PropertyThemeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyThemeModel(Object theme, Object thmName, Object propertyCategory, Object themeCategoryName,
			Object thmDescription, Object thmActive) {
		super();
		try {
			this.theme = (String) theme;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.thmName = (String) thmName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyCategory = (String) propertyCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.themeCategoryName = (String) themeCategoryName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.thmDescription = (String) thmDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.thmActive = (Boolean) thmActive;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getPropertyCategory() {
		return propertyCategory;
	}

	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
	}

	public String getThmName() {
		return thmName;
	}

	public void setThmName(String thmName) {
		this.thmName = thmName;
	}

	public String getThemeCategoryName() {
		return themeCategoryName;
	}

	public void setThemeCategoryName(String themeCategoryName) {
		this.themeCategoryName = themeCategoryName;
	}

	public String getThmDescription() {
		return thmDescription;
	}

	public void setThmDescription(String thmDescription) {
		this.thmDescription = thmDescription;
	}

	public Boolean getThmActive() {
		return thmActive;
	}

	public void setThmActive(Boolean thmActive) {
		this.thmActive = thmActive;
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
