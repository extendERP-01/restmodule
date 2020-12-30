package nirmalya.aatithya.restmodule.asset.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class IssueConsumedItemModel {

	private String store;
	
	private String vehicleAssetId;
	
	private String vehicleNo;
	
	private String vehicleCategory;
	
	private String itemId;
	
	private String itemName;
	
	private String avlQty;
	
	private Double issueQty;
	
	private String serveTypeId;
	
	private String serveType;
	
	private String issueDate;
	
	private String createdBy;
	
	private String isEdit;
	
	private String createdDate;
	
	private String jobCardId;
	
	private String jobCard;

	public IssueConsumedItemModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IssueConsumedItemModel(Object store, Object vehicleAssetId, Object vehicleNo, Object vehicleCategory,
			Object itemId, Object itemName, Object avlQty, Object issueQty, Object serveTypeId, Object serveType,
			Object issueDate, Object createdBy, Object isEdit, Object createdDate, Object jobCardId, Object jobCard) {
		super();
		this.store = (String) store;
		this.vehicleAssetId = (String) vehicleAssetId;
		this.vehicleNo = (String) vehicleNo;
		this.vehicleCategory = (String) vehicleCategory;
		this.itemId = (String) itemId;
		this.itemName = (String) itemName;
		this.avlQty = (String) avlQty;
		this.issueQty = (Double) issueQty;
		this.serveTypeId = (String) serveTypeId;
		this.serveType = (String) serveType;
		this.issueDate = (String) issueDate;
		this.createdBy = (String) createdBy;
		this.isEdit = (String) isEdit;
		this.createdDate = (String) createdDate;
		this.jobCardId = (String) jobCardId;
		this.jobCard = (String) jobCard;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getVehicleAssetId() {
		return vehicleAssetId;
	}

	public void setVehicleAssetId(String vehicleAssetId) {
		this.vehicleAssetId = vehicleAssetId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getAvlQty() {
		return avlQty;
	}

	public void setAvlQty(String avlQty) {
		this.avlQty = avlQty;
	}

	public Double getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(Double issueQty) {
		this.issueQty = issueQty;
	}

	public String getServeTypeId() {
		return serveTypeId;
	}

	public void setServeTypeId(String serveTypeId) {
		this.serveTypeId = serveTypeId;
	}

	public String getServeType() {
		return serveType;
	}

	public void setServeType(String serveType) {
		this.serveType = serveType;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getJobCardId() {
		return jobCardId;
	}

	public void setJobCardId(String jobCardId) {
		this.jobCardId = jobCardId;
	}

	public String getJobCard() {
		return jobCard;
	}

	public void setJobCard(String jobCard) {
		this.jobCard = jobCard;
	}

	@Override
	public String toString() {
		ObjectMapper  mapperObj=new ObjectMapper();
		String jsonStr;
		try{
			jsonStr=mapperObj.writeValueAsString(this);
		}catch(IOException ex){
			
			jsonStr=ex.toString();
		}
		return jsonStr;
	}
}
