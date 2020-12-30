/**
 *  Class Showing ItemRequisition Entity
 */
package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestItemRequisitonModel {
	private String itemRequisition;
	private String costCenter;
	private Double iRQty;
	private String iRDescription;
	private String iRExpectedDate;
	private String iRType;
	private Boolean iRStatus;
	private String dlItemRequisition;
	private String dlItemCategory;
	private String dlItemSubCategory;
	private String dlItem;
	private String dlItemId;
	private Double dlQty;
	private Boolean dlActive;
	private String createdDate;
	private String updatedDate;
	private String createdBy;
	private String serveUnit;
	private Double minStock;
	private String crntInvStore;
	private Integer currentStageNo;
	private Integer approverStageNo;
	private Integer currentLevelNo;
	private Integer approverLevelNo;
	private Byte approveStatus;
	private String tStore;

	public RestItemRequisitonModel(Object itemRequisition, Object costCenter, Object iRQty, Object iRDescription,
			Object iRExpectedDate, Object iRType, Object iRStatus, Object dlItemRequisition, Object dlItemCategory,
			Object dlItemSubCategory, Object dlItem, Object dlItemId, Object dlQty, Object dlActive, Object createdDate,
			Object updatedDate, Object createdBy, Object serveUnit, Object minStock, Object crntInvStore,
			Object currentStageNo, Object approverStageNo, Object currentLevelNo, Object approverLevelNo,
			Object approveStatus, Object tStore) {
		super();
		try {
			this.tStore = (String) tStore;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemRequisition = (String) itemRequisition;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.costCenter = (String) costCenter;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.iRQty = (Double) iRQty;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.iRDescription = (String) iRDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.iRExpectedDate = (String) iRExpectedDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.iRType = (String) iRType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.iRStatus = (Boolean) iRStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dlItemRequisition = (String) dlItemRequisition;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dlItemCategory = (String) dlItemCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dlItemSubCategory = (String) dlItemSubCategory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dlItem = (String) dlItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dlItemId = (String) dlItemId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dlQty = (Double) dlQty;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dlActive = (Boolean) dlActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdDate = (String) createdDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.updatedDate = (String) updatedDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.serveUnit = (String) serveUnit;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.minStock = (Double) minStock;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.crntInvStore = (String) crntInvStore;
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
	}

	public RestItemRequisitonModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getItemRequisition() {
		return itemRequisition;
	}

	public void setItemRequisition(String itemRequisition) {
		this.itemRequisition = itemRequisition;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public Double getiRQty() {
		return iRQty;
	}

	public void setiRQty(Double iRQty) {
		this.iRQty = iRQty;
	}

	public String getiRDescription() {
		return iRDescription;
	}

	public void setiRDescription(String iRDescription) {
		this.iRDescription = iRDescription;
	}

	public String getiRExpectedDate() {
		return iRExpectedDate;
	}

	public void setiRExpectedDate(String iRExpectedDate) {
		this.iRExpectedDate = iRExpectedDate;
	}

	public String getiRType() {
		return iRType;
	}

	public void setiRType(String iRType) {
		this.iRType = iRType;
	}

	public Boolean getiRStatus() {
		return iRStatus;
	}

	public void setiRStatus(Boolean iRStatus) {
		this.iRStatus = iRStatus;
	}

	public String getDlItemRequisition() {
		return dlItemRequisition;
	}

	public void setDlItemRequisition(String dlItemRequisition) {
		this.dlItemRequisition = dlItemRequisition;
	}

	public String getDlItemCategory() {
		return dlItemCategory;
	}

	public void setDlItemCategory(String dlItemCategory) {
		this.dlItemCategory = dlItemCategory;
	}

	public String getDlItemSubCategory() {
		return dlItemSubCategory;
	}

	public void setDlItemSubCategory(String dlItemSubCategory) {
		this.dlItemSubCategory = dlItemSubCategory;
	}

	public String getDlItem() {
		return dlItem;
	}

	public void setDlItem(String dlItem) {
		this.dlItem = dlItem;
	}

	public String getDlItemId() {
		return dlItemId;
	}

	public void setDlItemId(String dlItemId) {
		this.dlItemId = dlItemId;
	}

	public Double getDlQty() {
		return dlQty;
	}

	public void setDlQty(Double dlQty) {
		this.dlQty = dlQty;
	}

	public Boolean getDlActive() {
		return dlActive;
	}

	public void setDlActive(Boolean dlActive) {
		this.dlActive = dlActive;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getServeUnit() {
		return serveUnit;
	}

	public void setServeUnit(String serveUnit) {
		this.serveUnit = serveUnit;
	}

	public Double getMinStock() {
		return minStock;
	}

	public void setMinStock(Double minStock) {
		this.minStock = minStock;
	}

	public String getCrntInvStore() {
		return crntInvStore;
	}

	public void setCrntInvStore(String crntInvStore) {
		this.crntInvStore = crntInvStore;
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

	public String gettStore() {
		return tStore;
	}

	public void settStore(String tStore) {
		this.tStore = tStore;
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