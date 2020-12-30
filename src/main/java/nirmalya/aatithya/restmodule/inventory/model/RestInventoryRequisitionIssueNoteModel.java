/**
 * Class Showing Rest Requisition Issue Note Entity
 */
package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author NirmalyaLabs
 *
 */
public class RestInventoryRequisitionIssueNoteModel {
	private String reqstnIssueNote;
	private String itemRequisition;
	private String iNoteDescription;
	private Boolean pINoteActive;
	private String itemId;
	private String itemCategory;
	private String itemSubCategory;
	private String item;
	private Double iNoteQty;
	private String issueCreate;
	private String requisitionCreate;
	private String itemCode;
	private String serveUnit;
	private Double requestQuantity;
	private Double issueQuantity;
	private String createdBy;
	private String tStore;
	private String tGodown;
	private String tStoreName;
	private String batchCode;
	private Double reqQty;
	private Double totalIssueQty;
	private Double avlQty;

	public RestInventoryRequisitionIssueNoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestInventoryRequisitionIssueNoteModel(Object reqstnIssueNote, Object itemRequisition,
			Object iNoteDescription, Object pINoteActive, Object itemId, Object itemCategory, Object itemSubCategory,
			Object item, Object iNoteQty, Object issueCreate, Object requisitionCreate, Object itemCode,
			Object serveUnit, Object requestQuantity, Object issueQuantity, Object createdBy, Object tStore,
			Object tGodown, Object tStoreName, Object batchCode, Object reqQty,  Object totalIssueQty,Object avlQty) {

		try {
			this.tStoreName = (String) tStoreName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tGodown = (String) tGodown;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tStore = (String) tStore;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.reqstnIssueNote = (String) reqstnIssueNote;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemId = (String) itemId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemRequisition = (String) itemRequisition;
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
			this.iNoteQty = (Double) iNoteQty;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.issueCreate = (String) issueCreate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.requisitionCreate = (String) requisitionCreate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.iNoteDescription = (String) iNoteDescription;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pINoteActive = (Boolean) pINoteActive;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.itemCode = (String) itemCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.serveUnit = (String) serveUnit;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.requestQuantity = (Double) requestQuantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.issueQuantity = (Double) issueQuantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.batchCode = (String) batchCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.reqQty = (Double) reqQty;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.totalIssueQty = (Double) totalIssueQty;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.avlQty = (Double) avlQty;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getReqstnIssueNote() {
		return reqstnIssueNote;
	}

	public void setReqstnIssueNote(String reqstnIssueNote) {
		this.reqstnIssueNote = reqstnIssueNote;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemRequisition() {
		return itemRequisition;
	}

	public void setItemRequisition(String itemRequisition) {
		this.itemRequisition = itemRequisition;
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

	public Double getiNoteQty() {
		return iNoteQty;
	}

	public void setiNoteQty(Double iNoteQty) {
		this.iNoteQty = iNoteQty;
	}

	public String getiNoteDescription() {
		return iNoteDescription;
	}

	public void setiNoteDescription(String iNoteDescription) {
		this.iNoteDescription = iNoteDescription;
	}

	public Boolean getpINoteActive() {
		return pINoteActive;
	}

	public void setpINoteActive(Boolean pINoteActive) {
		this.pINoteActive = pINoteActive;
	}

	public String getIssueCreate() {
		return issueCreate;
	}

	public void setIssueCreate(String issueCreate) {
		this.issueCreate = issueCreate;
	}

	public String getRequisitionCreate() {
		return requisitionCreate;
	}

	public void setRequisitionCreate(String requisitionCreate) {
		this.requisitionCreate = requisitionCreate;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getServeUnit() {
		return serveUnit;
	}

	public void setServeUnit(String serveUnit) {
		this.serveUnit = serveUnit;
	}

	public Double getRequestQuantity() {
		return requestQuantity;
	}

	public void setRequestQuantity(Double requestQuantity) {
		this.requestQuantity = requestQuantity;
	}

	public Double getIssueQuantity() {
		return issueQuantity;
	}

	public void setIssueQuantity(Double issueQuantity) {
		this.issueQuantity = issueQuantity;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String gettStore() {
		return tStore;
	}

	public void settStore(String tStore) {
		this.tStore = tStore;
	}

	public String gettGodown() {
		return tGodown;
	}

	public void settGodown(String tGodown) {
		this.tGodown = tGodown;
	}

	public String gettStoreName() {
		return tStoreName;
	}

	public void settStoreName(String tStoreName) {
		this.tStoreName = tStoreName;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public Double getReqQty() {
		return reqQty;
	}

	public void setReqQty(Double reqQty) {
		this.reqQty = reqQty;
	}

	public Double getTotalIssueQty() {
		return totalIssueQty;
	}

	public void setTotalIssueQty(Double totalIssueQty) {
		this.totalIssueQty = totalIssueQty;
	}

	public Double getAvlQty() {
		return avlQty;
	}

	public void setAvlQty(Double avlQty) {
		this.avlQty = avlQty;
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
