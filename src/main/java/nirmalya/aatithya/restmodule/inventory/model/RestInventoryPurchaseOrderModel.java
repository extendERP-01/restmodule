/**
 *  Class Showing Purchase Order Entity
 */
package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestInventoryPurchaseOrderModel {
	private String purchaseOrder;
	private String vendor;
	private String pODescription;
	private Boolean pOStatus;
	private String itemCategory;
	private String itemSubCategory;
	private String itemName;
	private Double pOQty;
	private String checkedItem;
	private Double price;
	private String checkedPoStatus;
	private Double minStock;
	private Double totalReq;
	private Double availQnt;
	private String createdBy;
	private String subGroup;
	private String currentDate;
	private String porderDate;
	private String deliveryPeriod;
	private String termsAndConditions;
	private Integer currentStageNo;
	private Integer approverStageNo;
	private Integer currentLevelNo;
	private Integer approverLevelNo;
	private Byte approveStatus;
	private String store;
	private String venderName;

	public RestInventoryPurchaseOrderModel() {
		super();
	}

	public RestInventoryPurchaseOrderModel(Object purchaseOrder, Object vendor, Object pODescription, Object pOStatus,
			Object itemCategory, Object itemSubCategory, Object itemName, Object pOQty, Object price, Object minStock,
			Object totalReq, Object availQnt, Object porderDate, Object deliveryPeriod, Object termsAndConditions,
			Object currentStageNo, Object approverStageNo, Object currentLevelNo, Object approverLevelNo,
			Object approveStatus, Object store, Object venderName) {
		try {
			this.purchaseOrder = (String) purchaseOrder;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.vendor = (String) vendor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pODescription = (String) pODescription;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.pOStatus = (Boolean) pOStatus;
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
			this.itemName = (String) itemName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pOQty = (Double) pOQty;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			this.price = (Double) price;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.minStock = (Double) minStock;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.totalReq = (Double) totalReq;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.availQnt = (Double) availQnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.porderDate = (String) porderDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.deliveryPeriod = (String) deliveryPeriod;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.termsAndConditions = (String) termsAndConditions;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.currentStageNo = (Integer) currentStageNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.approverStageNo = (Integer) approverStageNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.currentLevelNo = (Integer) currentLevelNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.approverLevelNo = (Integer) approverLevelNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.approveStatus = (Byte) approveStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.store = (String) store;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.venderName = (String) venderName;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getpODescription() {
		return pODescription;
	}

	public void setpODescription(String pODescription) {
		this.pODescription = pODescription;
	}

	public Boolean getpOStatus() {
		return pOStatus;
	}

	public void setpOStatus(Boolean pOStatus) {
		this.pOStatus = pOStatus;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getpOQty() {
		return pOQty;
	}

	public void setpOQty(Double pOQty) {
		this.pOQty = pOQty;
	}

	public String getCheckedItem() {
		return checkedItem;
	}

	public void setCheckedItem(String checkedItem) {
		this.checkedItem = checkedItem;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCheckedPoStatus() {
		return checkedPoStatus;
	}

	public void setCheckedPoStatus(String checkedPoStatus) {
		this.checkedPoStatus = checkedPoStatus;
	}

	public Double getMinStock() {
		return minStock;
	}

	public void setMinStock(Double minStock) {
		this.minStock = minStock;
	}

	public Double getTotalReq() {
		return totalReq;
	}

	public void setTotalReq(Double totalReq) {
		this.totalReq = totalReq;
	}

	public Double getAvailQnt() {
		return availQnt;
	}

	public void setAvailQnt(Double availQnt) {
		this.availQnt = availQnt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getPorderDate() {
		return porderDate;
	}

	public void setPorderDate(String porderDate) {
		this.porderDate = porderDate;
	}

	public String getDeliveryPeriod() {
		return deliveryPeriod;
	}

	public void setDeliveryPeriod(String deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public Integer getCurrentStageNo() {
		return currentStageNo;
	}

	public void setCurrentStageNo(Integer currentStageNo) {
		this.currentStageNo = currentStageNo;
	}

	public Integer getApproverStageNo() {
		return approverStageNo;
	}

	public void setApproverStageNo(Integer approverStageNo) {
		this.approverStageNo = approverStageNo;
	}

	public Integer getCurrentLevelNo() {
		return currentLevelNo;
	}

	public void setCurrentLevelNo(Integer currentLevelNo) {
		this.currentLevelNo = currentLevelNo;
	}

	public Integer getApproverLevelNo() {
		return approverLevelNo;
	}

	public void setApproverLevelNo(Integer approverLevelNo) {
		this.approverLevelNo = approverLevelNo;
	}

	public Byte getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Byte approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getVenderName() {
		return venderName;
	}

	public void setVenderName(String venderName) {
		this.venderName = venderName;
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
