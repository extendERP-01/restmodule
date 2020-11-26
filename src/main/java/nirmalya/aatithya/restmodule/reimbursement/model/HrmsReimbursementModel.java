package nirmalya.aatithya.restmodule.reimbursement.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsReimbursementModel {
	private String empName;
	private String empId;
	private String rembDate;
	private String rembDesc;
	private Double rembAmount;
	private List<String> rembFile = new ArrayList<String>();
	private String rembRefNo;
	private String editId;
	private String action;
	private String fileName;
	private String placeName;
	private String fromDate;
	private String toDate;
	private String purpose;
	private Double advanceAmount;
	private String rembType;
	private String reqId;
	private String rembId;
	private String createdBy;
	private String reimTypeName;
	private int reqStatus;
	private Boolean approveStatus;
	private Integer currentStageNo;
	private Integer approversStageNo;
	private String returnDesc;
	private String rejectionType;
	private String statusName;
	private String policyId;
	private String policyName;
	private String reimbType;

	public HrmsReimbursementModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsReimbursementModel(Object empName, Object empId, Object rembDate, Object rembDesc, Object rembAmount,
			Object rembRefNo, Object reimTypeName, Object fileName, Object placeName, Object fromDate, Object toDate,
			Object purpose, Object advanceAmount, Object rembType, Object reqId, Object rembId, Object reqStatus,
			Object approveStatus, Object currentStageNo, Object approversStageNo, Object policyId, Object policyName,
			Object reimbType) {
		super();
		this.empName = (String) empName;
		this.empId = (String) empId;
		this.rembDate = (String) rembDate;
		this.rembDesc = (String) rembDesc;
		this.rembAmount = (Double) rembAmount;
		this.rembRefNo = (String) rembRefNo;
		this.reimTypeName = (String) reimTypeName;
		this.fileName = (String) fileName;
		this.placeName = (String) placeName;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.purpose = (String) purpose;
		this.advanceAmount = (Double) advanceAmount;
		this.rembType = (String) rembType;
		this.reqId = (String) reqId;
		this.rembId = (String) rembId;
		this.reqStatus = (int) reqStatus;
		this.approveStatus = (Boolean) approveStatus;
		this.currentStageNo = (Integer) currentStageNo;
		this.approversStageNo = (Integer) approversStageNo;
		this.policyId = (String) policyId;
		this.policyName = (String) policyName;
		this.reimbType = (String) reimbType;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getRembDate() {
		return rembDate;
	}

	public void setRembDate(String rembDate) {
		this.rembDate = rembDate;
	}

	public String getRembDesc() {
		return rembDesc;
	}

	public void setRembDesc(String rembDesc) {
		this.rembDesc = rembDesc;
	}

	public Double getRembAmount() {
		return rembAmount;
	}

	public void setRembAmount(Double rembAmount) {
		this.rembAmount = rembAmount;
	}

	public List<String> getRembFile() {
		return rembFile;
	}

	public void setRembFile(List<String> rembFile) {
		this.rembFile = rembFile;
	}

	public String getRembRefNo() {
		return rembRefNo;
	}

	public void setRembRefNo(String rembRefNo) {
		this.rembRefNo = rembRefNo;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public Double getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(Double advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public String getRembType() {
		return rembType;
	}

	public void setRembType(String rembType) {
		this.rembType = rembType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getRembId() {
		return rembId;
	}

	public void setRembId(String rembId) {
		this.rembId = rembId;
	}

	public String getReimTypeName() {
		return reimTypeName;
	}

	public void setReimTypeName(String reimTypeName) {
		this.reimTypeName = reimTypeName;
	}

	public int getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(int reqStatus) {
		this.reqStatus = reqStatus;
	}

	public Boolean getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Boolean approveStatus) {
		this.approveStatus = approveStatus;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
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
