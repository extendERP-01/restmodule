/**
 * Defines restaurant menuItem entity
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
public class RestaurantItemMasterModel {

	private String menuItems;			//primarykey

	private String property;

	private String mItmCategory;

	private String mealType;

	private String mnuItemName;

	private String mnuItemDescription;

	private Integer mnuItemPreferences;

	private String tMnuItemImage;

	private Integer mnuItemDisplay;

	private Double mnuItemPrice;

	private Double mnuItemQuantity;

	private Date mnuItemFromDate;

	private Date mnuItemToDate;

	private Integer mnuItemServiceType;

	private Boolean mnuItemActive;

	private Date mnuItemCreatedOn;

	private Date mnuItem_UpdatedOn;

	public RestaurantItemMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantItemMasterModel(Object menuItems, Object property, Object mItmCategory, Object mealType, Object mnuItemName,
			Object mnuItemDescription, Object mnuItemPreferences, Object tMnuItemImage, Object mnuItemDisplay,
			Object mnuItemPrice, Object mnuItemQuantity, Object mnuItemFromDate, Object mnuItemToDate,
			Object mnuItemServiceType, Object mnuItemActive, Object mnuItemCreatedOn, Object mnuItem_UpdatedOn) {
		super();
		try {
			this.menuItems = (String) menuItems;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.property = (String) property;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mItmCategory = (String) mItmCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mealType = (String) mealType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemName = (String) mnuItemName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemDescription = (String) mnuItemDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemPreferences = (Integer) mnuItemPreferences;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tMnuItemImage = (String) tMnuItemImage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemDisplay = (Integer) mnuItemDisplay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemPrice = (Double) mnuItemPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemQuantity = (Double) mnuItemQuantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemFromDate = (Date) mnuItemFromDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemToDate = (Date) mnuItemToDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemServiceType = (Integer) mnuItemServiceType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemActive = (Boolean) mnuItemActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItemCreatedOn = (Date) mnuItemCreatedOn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mnuItem_UpdatedOn = (Date) mnuItem_UpdatedOn;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(String menuItems) {
		this.menuItems = menuItems;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getmItmCategory() {
		return mItmCategory;
	}

	public void setmItmCategory(String mItmCategory) {
		this.mItmCategory = mItmCategory;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getMnuItemName() {
		return mnuItemName;
	}

	public void setMnuItemName(String mnuItemName) {
		this.mnuItemName = mnuItemName;
	}

	public String getMnuItemDescription() {
		return mnuItemDescription;
	}

	public void setMnuItemDescription(String mnuItemDescription) {
		this.mnuItemDescription = mnuItemDescription;
	}

	public Integer getMnuItemPreferences() {
		return mnuItemPreferences;
	}

	public void setMnuItemPreferences(Integer mnuItemPreferences) {
		this.mnuItemPreferences = mnuItemPreferences;
	}

	public String gettMnuItemImage() {
		return tMnuItemImage;
	}

	public void settMnuItemImage(String tMnuItemImage) {
		this.tMnuItemImage = tMnuItemImage;
	}

	public Integer getMnuItemDisplay() {
		return mnuItemDisplay;
	}

	public void setMnuItemDisplay(Integer mnuItemDisplay) {
		this.mnuItemDisplay = mnuItemDisplay;
	}

	public Double getMnuItemPrice() {
		return mnuItemPrice;
	}

	public void setMnuItemPrice(Double mnuItemPrice) {
		this.mnuItemPrice = mnuItemPrice;
	}

	public Double getMnuItemQuantity() {
		return mnuItemQuantity;
	}

	public void setMnuItemQuantity(Double mnuItemQuantity) {
		this.mnuItemQuantity = mnuItemQuantity;
	}

	public Date getMnuItemFromDate() {
		return mnuItemFromDate;
	}

	public void setMnuItemFromDate(Date mnuItemFromDate) {
		this.mnuItemFromDate = mnuItemFromDate;
	}

	public Date getMnuItemToDate() {
		return mnuItemToDate;
	}

	public void setMnuItemToDate(Date mnuItemToDate) {
		this.mnuItemToDate = mnuItemToDate;
	}

	public Integer getMnuItemServiceType() {
		return mnuItemServiceType;
	}

	public void setMnuItemServiceType(Integer mnuItemServiceType) {
		this.mnuItemServiceType = mnuItemServiceType;
	}

	public Boolean getMnuItemActive() {
		return mnuItemActive;
	}

	public void setMnuItemActive(Boolean mnuItemActive) {
		this.mnuItemActive = mnuItemActive;
	}

	public Date getMnuItemCreatedOn() {
		return mnuItemCreatedOn;
	}

	public void setMnuItemCreatedOn(Date mnuItemCreatedOn) {
		this.mnuItemCreatedOn = mnuItemCreatedOn;
	}

	public Date getMnuItem_UpdatedOn() {
		return mnuItem_UpdatedOn;
	}

	public void setMnuItem_UpdatedOn(Date mnuItem_UpdatedOn) {
		this.mnuItem_UpdatedOn = mnuItem_UpdatedOn;
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
