/*
 * Rest Model for Amenity Item
 */
package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyAmenityItemModel {
	public String propertyType;
	public String amenities;
	public String item;
	public Float amenityItemQty;
	public Boolean amntyItemActive;
	private String itemCategory;
	private String ItemSubCategory;
	private String propertyName;
	private String amntsName;
	private String itemName;
	private String propertyCategory;
	private String propertyCategoryName;
	private String createdBy;

	public PropertyAmenityItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyAmenityItemModel(Object propertyType, Object amenities, Object item, Object amenityItemQty,
			Object amntyItemActive, Object propertyName, Object amntsName, Object itemName, Object propertyCategory,
			Object ItemSubCategory, Object itemCategory, Object propertyCategoryName) {
		super();
		try {
			this.propertyType = (String) propertyType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.amenities = (String) amenities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.item = (String) item;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.amenityItemQty = (Float) amenityItemQty;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.amntyItemActive = (Boolean) amntyItemActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyName = (String) propertyName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.amntsName = (String) amntsName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemName = (String) itemName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyCategory = (String) propertyCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.ItemSubCategory = (String) ItemSubCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCategory = (String) itemCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyCategoryName = (String) propertyCategoryName;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Float getAmenityItemQty() {
		return amenityItemQty;
	}

	public void setAmenityItemQty(Float amenityItemQty) {
		this.amenityItemQty = amenityItemQty;
	}

	public Boolean getAmntyItemActive() {
		return amntyItemActive;
	}

	public void setAmntyItemActive(Boolean amntyItemActive) {
		this.amntyItemActive = amntyItemActive;
	}

	public String getPropertyCategory() {
		return propertyCategory;
	}

	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemSubCategory() {
		return ItemSubCategory;
	}

	public void setItemSubCategory(String itemSubCategory) {
		ItemSubCategory = itemSubCategory;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getAmntsName() {
		return amntsName;
	}

	public void setAmntsName(String amntsName) {
		this.amntsName = amntsName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPropertyCategoryName() {
		return propertyCategoryName;
	}

	public void setPropertyCategoryName(String propertyCategoryName) {
		this.propertyCategoryName = propertyCategoryName;
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
