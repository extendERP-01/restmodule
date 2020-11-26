package nirmalya.aatithya.restmodule.gatepass.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GatePassEntryModel {

	private String gatePass;
	private Byte weightType;
	private String entryDate;
	private String entryTime;
	private String refGatePassNo;
	private String store;
	private Byte passType;
	private String vendor;
	private String challanNo;
	private String vehicleNo;
	private String rstNo;
	private String clientRSTNo;
	private String driverName;
	private Double gross;
	private Double tare;
	private String exitTime;
	private String remarks;
	private String itemCode;
	private String itemName;
	private Double clientNetQty;
	private Double actualNetQty;
	private String serveTypeId;
	private String serveType;
	private String createdBy;
	private String itemCategory;
	private String subCategory;
	private String vendorId;
	private String pOrder;
	private Boolean grnStatus;
	private String customerId;
	private String customer;
	private Double weight;
	
	public GatePassEntryModel() {
		super();
	}

	public GatePassEntryModel(Object gatePass, Object weightType, Object entryDate, Object entryTime,
			Object refGatePassNo, Object store, Object passType, Object vendor, Object challanNo, Object vehicleNo,
			Object rstNo, Object clientRSTNo, Object driverName, Object gross, Object tare, Object exitTime,
			Object remarks, Object itemCode, Object itemName, Object clientNetQty, Object actualNetQty,
			Object serveTypeId, Object serveType, Object createdBy, Object itemCategory, Object subCategory,
			Object vendorId, Object pOrder, Object grnStatus, Object customerId, Object customer, Object weight) {
		super();
		this.gatePass = (String) gatePass;
		this.weightType = (Byte) weightType;
		this.entryDate = (String) entryDate;
		this.entryTime = (String) entryTime;
		this.refGatePassNo = (String) refGatePassNo;
		this.store = (String) store;
		this.passType = (Byte) passType;
		this.vendor = (String) vendor;
		this.challanNo = (String) challanNo;
		this.vehicleNo = (String) vehicleNo;
		this.rstNo = (String) rstNo;
		this.clientRSTNo = (String) clientRSTNo;
		this.driverName = (String) driverName;
		this.gross = (Double) gross;
		this.tare = (Double) tare;
		this.exitTime = (String) exitTime;
		this.remarks = (String) remarks;
		this.itemCode = (String) itemCode;
		this.itemName = (String) itemName;
		this.clientNetQty = (Double) clientNetQty;
		this.actualNetQty = (Double) actualNetQty;
		this.serveTypeId = (String) serveTypeId;
		this.serveType = (String) serveType;
		this.createdBy = (String) createdBy;
		this.itemCategory = (String) itemCategory;
		this.subCategory = (String) subCategory;
		this.vendorId = (String) vendorId;
		this.pOrder = (String) pOrder;
		this.grnStatus = (Boolean) grnStatus;
		this.customerId = (String) customerId;
		this.customer = (String) customer;
		this.weight = (Double) weight;
	}

	public String getGatePass() {
		return gatePass;
	}

	public void setGatePass(String gatePass) {
		this.gatePass = gatePass;
	}

	public Byte getWeightType() {
		return weightType;
	}

	public void setWeightType(Byte weightType) {
		this.weightType = weightType;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getRefGatePassNo() {
		return refGatePassNo;
	}

	public void setRefGatePassNo(String refGatePassNo) {
		this.refGatePassNo = refGatePassNo;
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getRstNo() {
		return rstNo;
	}

	public void setRstNo(String rstNo) {
		this.rstNo = rstNo;
	}

	public String getClientRSTNo() {
		return clientRSTNo;
	}

	public void setClientRSTNo(String clientRSTNo) {
		this.clientRSTNo = clientRSTNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
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

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Double getClientNetQty() {
		return clientNetQty;
	}

	public void setClientNetQty(Double clientNetQty) {
		this.clientNetQty = clientNetQty;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getpOrder() {
		return pOrder;
	}

	public void setpOrder(String pOrder) {
		this.pOrder = pOrder;
	}

	public Boolean getGrnStatus() {
		return grnStatus;
	}

	public void setGrnStatus(Boolean grnStatus) {
		this.grnStatus = grnStatus;
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
	
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
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
