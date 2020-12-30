package nirmalya.aatithya.restmodule.gatepass.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GatePassOutModel {

	private String gatePassOut;
	private String delChallanId;
	private String delChallan;
	private String store;
	private Byte passType;
	private Byte weightType;
	private String outDate;
	private String outTime;
	private String refGatePassNo;
	private String rstNo;
	private String vehicleNo;
	private String driverName;
	private String customerId;
	private String customer;
	private Double gross;
	private Double tare;
	private String itemCategoryId;
	private String itemCategory;
	private String subCatId;
	private String subCat;
	private String itemCode;
	private String itemName;
	private Double actualNetQty;
	private String serveTypeId;
	private String serveType;
	private String remarks;
	private String createdBy;
	private Double weight;
	private String fileUpload;
	
	public GatePassOutModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GatePassOutModel(Object gatePassOut, Object delChallanId, Object delChallan, Object store, Object passType,
			Object weightType, Object outDate, Object outTime, Object refGatePassNo, Object rstNo, Object vehicleNo,
			Object driverName, Object customerId, Object customer, Object gross, Object tare, Object itemCategoryId,
			Object itemCategory, Object subCatId, Object subCat, Object itemCode, Object itemName, Object actualNetQty,
			Object serveTypeId, Object serveType, Object remarks, Object createdBy, Object weight, Object fileUpload) {
		super();
		this.gatePassOut = (String) gatePassOut;
		this.delChallanId = (String) delChallanId;
		this.delChallan = (String) delChallan;
		this.store = (String) store;
		this.passType = (Byte) passType;
		this.weightType = (Byte) weightType;
		this.outDate = (String) outDate;
		this.outTime = (String) outTime;
		this.refGatePassNo = (String) refGatePassNo;
		this.rstNo = (String) rstNo;
		this.vehicleNo = (String) vehicleNo;
		this.driverName = (String) driverName;
		this.customerId = (String) customerId;
		this.customer = (String) customer;
		this.gross = (Double) gross;
		this.tare = (Double) tare;
		this.itemCategoryId = (String) itemCategoryId;
		this.itemCategory = (String) itemCategory;
		this.subCatId = (String) subCatId;
		this.subCat = (String) subCat;
		this.itemCode = (String) itemCode;
		this.itemName = (String) itemName;
		this.actualNetQty = (Double) actualNetQty;
		this.serveTypeId = (String) serveTypeId;
		this.serveType = (String) serveType;
		this.remarks = (String) remarks;
		this.createdBy = (String) createdBy;
		this.weight = (Double) weight;
		this.fileUpload = (String) fileUpload;
	}

	public String getGatePassOut() {
		return gatePassOut;
	}

	public void setGatePassOut(String gatePassOut) {
		this.gatePassOut = gatePassOut;
	}

	public String getDelChallanId() {
		return delChallanId;
	}

	public void setDelChallanId(String delChallanId) {
		this.delChallanId = delChallanId;
	}

	public String getDelChallan() {
		return delChallan;
	}

	public void setDelChallan(String delChallan) {
		this.delChallan = delChallan;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public Byte getPassType() {
		return passType;
	}

	public void setPassType(Byte passType) {
		this.passType = passType;
	}

	public Byte getWeightType() {
		return weightType;
	}

	public void setWeightType(Byte weightType) {
		this.weightType = weightType;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getRefGatePassNo() {
		return refGatePassNo;
	}

	public void setRefGatePassNo(String refGatePassNo) {
		this.refGatePassNo = refGatePassNo;
	}

	public String getRstNo() {
		return rstNo;
	}

	public void setRstNo(String rstNo) {
		this.rstNo = rstNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Double getGross() {
		return gross;
	}

	public void setGross(Double gross) {
		this.gross = gross;
	}

	public Double getTare() {
		return tare;
	}

	public void setTare(Double tare) {
		this.tare = tare;
	}

	public String getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(String itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(String subCatId) {
		this.subCatId = subCatId;
	}

	public String getSubCat() {
		return subCat;
	}

	public void setSubCat(String subCat) {
		this.subCat = subCat;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getActualNetQty() {
		return actualNetQty;
	}

	public void setActualNetQty(Double actualNetQty) {
		this.actualNetQty = actualNetQty;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
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
