package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VendorMasterModel {
	private String vendorId;
	private String vendorName;
	private String code;
	private String category;
	private String categoryType;
	private String comapanyOverview;
	private String vendorStatus;
	private String createdOn;
	private String createdBy;
	private String fileVendor;
	public VendorMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VendorMasterModel(Object vendorId, Object vendorName, Object code, Object category,
			Object categoryType, Object comapanyOverview, Object vendorStatus, Object createdOn, Object createdBy, Object fileVendor) {
		super();
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.code = (String) code;
		this.category = (String) category;
		this.categoryType = (String) categoryType;
		this.comapanyOverview = (String) comapanyOverview;
		this.vendorStatus = (String) vendorStatus;
		this.createdOn = (String) createdOn;
		this.createdBy = (String) createdBy;
		this.fileVendor = (String) fileVendor;
		
	}

	
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getComapanyOverview() {
		return comapanyOverview;
	}
	public void setComapanyOverview(String comapanyOverview) {
		this.comapanyOverview = comapanyOverview;
	}
	public String getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getFileVendor() {
		return fileVendor;
	}
	public void setFileVendor(String fileVendor) {
		this.fileVendor = fileVendor;
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
