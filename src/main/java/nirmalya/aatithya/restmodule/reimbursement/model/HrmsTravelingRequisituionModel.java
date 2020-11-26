package nirmalya.aatithya.restmodule.reimbursement.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsTravelingRequisituionModel {
	private String placeName;
	private String fromDate;
	private String toDate;
	private String purpose;
	private Boolean advanceNeed;
	private Double advanceAmount;
	private String reqId;
	private String createdBy;
	private String companyId;
	private byte reqStatus ;
	private Integer  currentStageNo;
	private Integer approversStageNo;
	private String returnDesc;
	private String rejectionType;

	public HrmsTravelingRequisituionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsTravelingRequisituionModel(Object placeName, Object fromDate, Object toDate, Object purpose,
			Object advanceNeed, Object advanceAmount,Object reqStatus , Object reqId ,Object currentStageNo ,Object approversStageNo) {
		super();
		this.placeName = (String) placeName;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.purpose = (String) purpose;
		this.advanceNeed = (Boolean) advanceNeed;
		this.advanceAmount = (Double) advanceAmount;
		this.reqStatus = (byte) reqStatus ;
		this.reqId = (String) reqId;
		this.currentStageNo = (Integer) currentStageNo;
		this.approversStageNo = (Integer) approversStageNo;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	
	public Boolean getAdvanceNeed() {
		return advanceNeed;
	}

	public void setAdvanceNeed(Boolean advanceNeed) {
		this.advanceNeed = advanceNeed;
	}

	public Double getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(Double advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public byte getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(byte reqStatus) {
		this.reqStatus = reqStatus;
	}

	public Integer getCurrentStageNo() {
		return currentStageNo;
	}

	public void setCurrentStageNo(Integer currentStageNo) {
		this.currentStageNo = currentStageNo;
	}

	public Integer getApproversStageNo() {
		return approversStageNo;
	}

	public void setApproversStageNo(Integer approversStageNo) {
		this.approversStageNo = approversStageNo;
	}

	public String getReturnDesc() {
		return returnDesc;
	}

	public void setReturnDesc(String returnDesc) {
		this.returnDesc = returnDesc;
	}

	public String getRejectionType() {
		return rejectionType;
	}

	public void setRejectionType(String rejectionType) {
		this.rejectionType = rejectionType;
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
