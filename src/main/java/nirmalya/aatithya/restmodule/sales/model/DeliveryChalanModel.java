package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeliveryChalanModel {

	private String challanNo;
	private String entryDate;
	private String challanType;
	private String saleOrder;
	private String refPoId;
	private String clientAccount;
	private String tin;
	private String deliveryAddress;
	private String deliverySite;

	private Double slurryPowder;
	private String batchPlant;
	private String batchTime;

	private String cementBrand;
	private Double batchQty;
	private Boolean cementSupplyByClient;
	private Double sand2;
	private Double chip310mm;
	private Double chip420mm;
	private Double cement;
	private Double flyAsh;
	private Double water;
	private Double addMix;
	private Double total;
	private Double density;
	private String rmcGrade;
	private Double slumpMM;
	private String qcRemark;
	private Double billQty;
	private Double noOfTm;
	private Double totalQty;
	private Boolean autoNoOfTmQty;
	private String referalChallanNo;
	private String refGatePassNo;
	private String vechileNo;
	private String rstNo;
	private Double grossWt;
	private Double tareWt;
	private Double netWt;
	private String driverId;
	private String helper;
	private String outTime;
	private Double okm;
	private Double ofhr;
	private Double obhr;
	private String pumpList;
	private String returnTime;
	private Double rKm;
	private Double rfhr;
	private Double rBhr;
	private String siteInTime;
	private String siteOutTime;
	private String siteSupervisor;
	private String remarks;
	private String action;
	private String createdBy;
	private String sand2Id;
	private String chip310mmId;
	private String chip420mmId;
	private String cementId;
	private String flyAshId;
	private String waterId;
	private String addMixId;
	private String recieveWt;
	private Boolean isPump;
	private String clientName;
	private String driverName;
	private String docketNo;
	private Boolean invoiceStatus;
	private String invoiceNumber;
	private String slurryPowderId;

	private String itemCat;

	private String itemSubCat;

	public DeliveryChalanModel(Object challanNo, Object entryDate, Object challanType, Object saleOrder, Object refPoId,
			Object clientAccount, Object tin, Object deliveryAddress, Object deliverySite, Object slurryPowder,
			Object batchPlant, Object batchTime, Object cementBrand, Object batchQty, Object cementSupplyByClient,
			Object sand2, Object chip310mm, Object chip420mm, Object cement, Object flyAsh, Object water, Object addMix,
			Object total, Object density, Object rmcGrade, Object slumpMM, Object qcRemark, Object billQty,
			Object noOfTm, Object totalQty, Object autoNoOfTmQty, Object referalChallanNo, Object refGatePassNo,
			Object vechileNo, Object rstNo, Object grossWt, Object tareWt, Object netWt, Object driverId, Object helper,
			Object outTime, Object okm, Object ofhr, Object obhr, Object pumpList, Object returnTime, Object rKm,
			Object rfhr, Object rBhr, Object siteInTime, Object siteOutTime, Object siteSupervisor, Object remarks,
			Object isPump, Object clientName, Object driverName, Object docketNo, Object invoiceStatus,
			Object invoiceNumber, Object itemCat, Object itemSubCat) {
		super();
		this.challanNo = (String) challanNo;
		this.entryDate = (String) entryDate;
		this.challanType = (String) challanType;
		this.saleOrder = (String) saleOrder;
		this.refPoId = (String) refPoId;
		this.clientAccount = (String) clientAccount;
		this.tin = (String) tin;
		this.deliveryAddress = (String) deliveryAddress;
		this.deliverySite = (String) deliverySite;
		this.slurryPowder = (Double) slurryPowder;
		this.batchPlant = (String) batchPlant;
		this.batchTime = (String) batchTime;
		this.cementBrand = (String) cementBrand;
		this.batchQty = (Double) batchQty;
		this.cementSupplyByClient = (Boolean) cementSupplyByClient;
		this.sand2 = (Double) sand2;
		this.chip310mm = (Double) chip310mm;
		this.chip420mm = (Double) chip420mm;
		this.cement = (Double) cement;
		this.flyAsh = (Double) flyAsh;
		this.water = (Double) water;
		this.addMix = (Double) addMix;
		this.total = (Double) total;
		this.density = (Double) density;
		this.rmcGrade = (String) rmcGrade;
		this.slumpMM = (Double) slumpMM;
		this.qcRemark = (String) qcRemark;
		this.billQty = (Double) billQty;
		this.noOfTm = (Double) noOfTm;
		this.totalQty = (Double) totalQty;
		this.autoNoOfTmQty = (Boolean) autoNoOfTmQty;
		this.referalChallanNo = (String) referalChallanNo;
		this.refGatePassNo = (String) refGatePassNo;
		this.vechileNo = (String) vechileNo;
		this.rstNo = (String) rstNo;
		this.grossWt = (Double) grossWt;
		this.tareWt = (Double) tareWt;
		this.netWt = (Double) netWt;
		this.driverId = (String) driverId;
		this.helper = (String) helper;
		this.outTime = (String) outTime;
		this.okm = (Double) okm;
		this.ofhr = (Double) ofhr;
		this.obhr = (Double) obhr;
		this.pumpList = (String) pumpList;
		this.returnTime = (String) returnTime;
		this.rKm = (Double) rKm;
		this.rfhr = (Double) rfhr;
		this.rBhr = (Double) rBhr;
		this.siteInTime = (String) siteInTime;
		this.siteOutTime = (String) siteOutTime;
		this.siteSupervisor = (String) siteSupervisor;
		this.remarks = (String) remarks;
		this.isPump = (Boolean) isPump;
		this.clientName = (String) clientName;
		this.driverName = (String) driverName;
		this.docketNo = (String) docketNo;
		this.invoiceStatus = (Boolean) invoiceStatus;
		this.invoiceNumber = (String) invoiceNumber;
		this.itemCat = (String) itemCat;
		this.itemSubCat = (String) itemSubCat;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getChallanType() {
		return challanType;
	}

	public void setChallanType(String challanType) {
		this.challanType = challanType;
	}

	public String getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(String saleOrder) {
		this.saleOrder = saleOrder;
	}

	public String getRefPoId() {
		return refPoId;
	}

	public void setRefPoId(String refPoId) {
		this.refPoId = refPoId;
	}

	public String getClientAccount() {
		return clientAccount;
	}

	public void setClientAccount(String clientAccount) {
		this.clientAccount = clientAccount;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliverySite() {
		return deliverySite;
	}

	public void setDeliverySite(String deliverySite) {
		this.deliverySite = deliverySite;
	}

	public Double getSlurryPowder() {
		return slurryPowder;
	}

	public void setSlurryPowder(Double slurryPowder) {
		this.slurryPowder = slurryPowder;
	}

	public String getBatchPlant() {
		return batchPlant;
	}

	public void setBatchPlant(String batchPlant) {
		this.batchPlant = batchPlant;
	}

	public String getBatchTime() {
		return batchTime;
	}

	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}

	public String getCementBrand() {
		return cementBrand;
	}

	public void setCementBrand(String cementBrand) {
		this.cementBrand = cementBrand;
	}

	public Double getBatchQty() {
		return batchQty;
	}

	public void setBatchQty(Double batchQty) {
		this.batchQty = batchQty;
	}

	public Double getSand2() {
		return sand2;
	}

	public void setSand2(Double sand2) {
		this.sand2 = sand2;
	}

	public Double getChip310mm() {
		return chip310mm;
	}

	public void setChip310mm(Double chip310mm) {
		this.chip310mm = chip310mm;
	}

	public Double getChip420mm() {
		return chip420mm;
	}

	public void setChip420mm(Double chip420mm) {
		this.chip420mm = chip420mm;
	}

	public Double getCement() {
		return cement;
	}

	public void setCement(Double cement) {
		this.cement = cement;
	}

	public Double getFlyAsh() {
		return flyAsh;
	}

	public void setFlyAsh(Double flyAsh) {
		this.flyAsh = flyAsh;
	}

	public Double getWater() {
		return water;
	}

	public void setWater(Double water) {
		this.water = water;
	}

	public Double getAddMix() {
		return addMix;
	}

	public void setAddMix(Double addMix) {
		this.addMix = addMix;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getDensity() {
		return density;
	}

	public void setDensity(Double density) {
		this.density = density;
	}

	public String getRmcGrade() {
		return rmcGrade;
	}

	public void setRmcGrade(String rmcGrade) {
		this.rmcGrade = rmcGrade;
	}

	public Double getSlumpMM() {
		return slumpMM;
	}

	public void setSlumpMM(Double slumpMM) {
		this.slumpMM = slumpMM;
	}

	public String getQcRemark() {
		return qcRemark;
	}

	public void setQcRemark(String qcRemark) {
		this.qcRemark = qcRemark;
	}

	public Double getBillQty() {
		return billQty;
	}

	public void setBillQty(Double billQty) {
		this.billQty = billQty;
	}

	public Double getNoOfTm() {
		return noOfTm;
	}

	public void setNoOfTm(Double noOfTm) {
		this.noOfTm = noOfTm;
	}

	public Double getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Double totalQty) {
		this.totalQty = totalQty;
	}

	public Boolean getAutoNoOfTmQty() {
		return autoNoOfTmQty;
	}

	public void setAutoNoOfTmQty(Boolean autoNoOfTmQty) {
		this.autoNoOfTmQty = autoNoOfTmQty;
	}

	public String getReferalChallanNo() {
		return referalChallanNo;
	}

	public void setReferalChallanNo(String referalChallanNo) {
		this.referalChallanNo = referalChallanNo;
	}

	public String getRefGatePassNo() {
		return refGatePassNo;
	}

	public void setRefGatePassNo(String refGatePassNo) {
		this.refGatePassNo = refGatePassNo;
	}

	public String getVechileNo() {
		return vechileNo;
	}

	public void setVechileNo(String vechileNo) {
		this.vechileNo = vechileNo;
	}

	public String getRstNo() {
		return rstNo;
	}

	public void setRstNo(String rstNo) {
		this.rstNo = rstNo;
	}

	public Double getGrossWt() {
		return grossWt;
	}

	public void setGrossWt(Double grossWt) {
		this.grossWt = grossWt;
	}

	public Double getTareWt() {
		return tareWt;
	}

	public void setTareWt(Double tareWt) {
		this.tareWt = tareWt;
	}

	public Double getNetWt() {
		return netWt;
	}

	public void setNetWt(Double netWt) {
		this.netWt = netWt;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getHelper() {
		return helper;
	}

	public void setHelper(String helper) {
		this.helper = helper;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public Double getOkm() {
		return okm;
	}

	public void setOkm(Double okm) {
		this.okm = okm;
	}

	public String getPumpList() {
		return pumpList;
	}

	public void setPumpList(String pumpList) {
		this.pumpList = pumpList;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public Double getrKm() {
		return rKm;
	}

	public void setrKm(Double rKm) {
		this.rKm = rKm;
	}

	public String getSiteInTime() {
		return siteInTime;
	}

	public void setSiteInTime(String siteInTime) {
		this.siteInTime = siteInTime;
	}

	public String getSiteOutTime() {
		return siteOutTime;
	}

	public void setSiteOutTime(String siteOutTime) {
		this.siteOutTime = siteOutTime;
	}

	public String getSiteSupervisor() {
		return siteSupervisor;
	}

	public void setSiteSupervisor(String siteSupervisor) {
		this.siteSupervisor = siteSupervisor;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getSand2Id() {
		return sand2Id;
	}

	public void setSand2Id(String sand2Id) {
		this.sand2Id = sand2Id;
	}

	public String getChip310mmId() {
		return chip310mmId;
	}

	public void setChip310mmId(String chip310mmId) {
		this.chip310mmId = chip310mmId;
	}

	public String getChip420mmId() {
		return chip420mmId;
	}

	public void setChip420mmId(String chip420mmId) {
		this.chip420mmId = chip420mmId;
	}

	public String getCementId() {
		return cementId;
	}

	public void setCementId(String cementId) {
		this.cementId = cementId;
	}

	public String getFlyAshId() {
		return flyAshId;
	}

	public void setFlyAshId(String flyAshId) {
		this.flyAshId = flyAshId;
	}

	public String getWaterId() {
		return waterId;
	}

	public void setWaterId(String waterId) {
		this.waterId = waterId;
	}

	public String getAddMixId() {
		return addMixId;
	}

	public void setAddMixId(String addMixId) {
		this.addMixId = addMixId;
	}

	public String getRecieveWt() {
		return recieveWt;
	}

	public void setRecieveWt(String recieveWt) {
		this.recieveWt = recieveWt;
	}

	public Boolean getIsPump() {
		return isPump;
	}

	public void setIsPump(Boolean isPump) {
		this.isPump = isPump;
	}

	public Boolean getCementSupplyByClient() {
		return cementSupplyByClient;
	}

	public void setCementSupplyByClient(Boolean cementSupplyByClient) {
		this.cementSupplyByClient = cementSupplyByClient;
	}

	public Double getOfhr() {
		return ofhr;
	}

	public void setOfhr(Double ofhr) {
		this.ofhr = ofhr;
	}

	public Double getObhr() {
		return obhr;
	}

	public void setObhr(Double obhr) {
		this.obhr = obhr;
	}

	public Double getRfhr() {
		return rfhr;
	}

	public void setRfhr(Double rfhr) {
		this.rfhr = rfhr;
	}

	public Double getrBhr() {
		return rBhr;
	}

	public void setrBhr(Double rBhr) {
		this.rBhr = rBhr;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDocketNo() {
		return docketNo;
	}

	public void setDocketNo(String docketNo) {
		this.docketNo = docketNo;
	}

	public Boolean getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(Boolean invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getSlurryPowderId() {
		return slurryPowderId;
	}

	public void setSlurryPowderId(String slurryPowderId) {
		this.slurryPowderId = slurryPowderId;
	}

	public String getItemCat() {
		return itemCat;
	}

	public String getItemSubCat() {
		return itemSubCat;
	}

	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}

	public void setItemSubCat(String itemSubCat) {
		this.itemSubCat = itemSubCat;
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
