package nirmalya.aatithya.restmodule.property.model;

/**
 * @author Nirmalya Labs
 *
 */
public class PropertyAssignAssetToStaffModel {

	private String costCenter;

	private String staff;

	private String category;

	private String subcategory;

	private String item;

	private String asset;

	private String assignDate;

	private Boolean active;

	private String costId;

	private String staffId;

	private String categoryID;

	private String subcategoryId;

	private String itemId;

	private String assetId;
	private String createdBy;

	public PropertyAssignAssetToStaffModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyAssignAssetToStaffModel(Object costCenter, Object staff, Object category, Object subcategory,
			Object item, Object asset, Object assignDate, Object active, Object costId, Object staffId,
			Object categoryID, Object subcategoryId, Object itemId, Object assetId) {
		super();
		try {
			this.costCenter = (String) costCenter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.staff = (String) staff;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.category = (String) category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.subcategory = (String) subcategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.item = (String) item;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.asset = (String) asset;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.assignDate = (String) assignDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.active = (Boolean) active;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.costId = (String) costId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.staffId = (String) staffId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.categoryID = (String) categoryID;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.subcategoryId = (String) subcategoryId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemId = (String) itemId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.assetId = (String) assetId;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
