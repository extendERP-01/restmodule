package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventorySearchPurchaseOrderModel {

	private String purOrderId;
	private String costCenterName;
	private String requisitionType;
	private String categoryName;
	private String subCategoryName;
	private String itemName;
	private Double totalNoQuantity;
	private String action;
	private String requisition_p;
	private String costcenter_p;
	private String category_p;
	private String subcategory_p;
	private String item_p;
	// private String total;

	public String getPurOrderId() {
		return purOrderId;
	}

	public void setPurOrderId(String purOrderId) {
		this.purOrderId = purOrderId;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public String getRequisitionType() {
		return requisitionType;
	}

	public void setRequisitionType(String requisitionType) {
		this.requisitionType = requisitionType;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getTotalNoQuantity() {
		return totalNoQuantity;
	}

	public void setTotalNoQuantity(Double totalNoQuantity) {
		this.totalNoQuantity = totalNoQuantity;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRequisition_p() {
		return requisition_p;
	}

	public void setRequisition_p(String requisition_p) {
		this.requisition_p = requisition_p;
	}

	public String getCostcenter_p() {
		return costcenter_p;
	}

	public void setCostcenter_p(String costcenter_p) {
		this.costcenter_p = costcenter_p;
	}

	public String getCategory_p() {
		return category_p;
	}

	public void setCategory_p(String category_p) {
		this.category_p = category_p;
	}

	public String getSubcategory_p() {
		return subcategory_p;
	}

	public void setSubcategory_p(String subcategory_p) {
		this.subcategory_p = subcategory_p;
	}

	public String getItem_p() {
		return item_p;
	}

	public void setItem_p(String item_p) {
		this.item_p = item_p;
	}

	public InventorySearchPurchaseOrderModel() {
		super();

	}

	public InventorySearchPurchaseOrderModel(Object purOrderId, Object costCenterName, Object requisitionType,
			Object categoryName, Object subCategoryName, Object itemName, Object totalNoQuantity, Object item_p) {
		super();
		try {
			this.purOrderId = (String) purOrderId;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.costCenterName = (String) costCenterName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.requisitionType = (String) requisitionType;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.categoryName = (String) categoryName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.subCategoryName = (String) subCategoryName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemName = (String) itemName;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.totalNoQuantity = (Double) totalNoQuantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.item_p = (String) item_p;
		} catch (Exception ex) {
			ex.printStackTrace();
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
