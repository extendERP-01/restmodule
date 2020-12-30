/*
 * model for assign assets
 */
package nirmalya.aatithya.restmodule.property.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyAssignAssetModel {

	private String propertyCategory;
	private String property;
	private String itemCategory;
	private String itemSubCategory;
	private String item;
	private List<String> assetsList = new ArrayList<String>();
	private String assetsName;
	private String propertyName;
	private String itemName;
	private String itemCategoryName;
	private String itemSubCategoryName;
	private String propertyTypeName;
	private String amenity;
	private String createdBy;
	private Float pAsstQty;

	public PropertyAssignAssetModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyAssignAssetModel(Object propertyCategory, Object property, Object itemCategory,
			Object itemSubCategory, Object item, Object assetsName, Object propertyName, Object itemName,
			Object itemCategoryName, Object itemSubCategoryName, Object propertyTypeName, Object createdBy) {
		super();
		try {
			this.propertyCategory = (String) propertyCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.property = (String) property;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCategory = (String) itemCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemSubCategory = (String) itemSubCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.item = (String) item;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.assetsName = (String) assetsName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyName = (String) propertyName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemName = (String) itemName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCategoryName = (String) itemCategoryName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemSubCategoryName = (String) itemSubCategoryName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.propertyTypeName = (String) propertyTypeName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPropertyCategory() {
		return propertyCategory;
	}

	public void setPropertyCategory(String propertyCategory) {
		this.propertyCategory = propertyCategory;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<String> getAssetsList() {
		return assetsList;
	}

	public void setAssetsList(List<String> assetsList) {
		this.assetsList = assetsList;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
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

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public String getItemSubCategoryName() {
		return itemSubCategoryName;
	}

	public void setItemSubCategoryName(String itemSubCategoryName) {
		this.itemSubCategoryName = itemSubCategoryName;
	}

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Float getpAsstQty() {
		return pAsstQty;
	}

	public void setpAsstQty(Float pAsstQty) {
		this.pAsstQty = pAsstQty;
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
