package nirmalya.aatithya.restmodule.leave.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestLeaveApplyModel {

	private String applyId;// primary key

	private String ltypeName;

	private String empName;

	private Double totalLeave;

	private String lApplyStartDate;

	private String lApplyEndDate;

	private String lReason;

	private String lApplyStatus;

	private String lApplyShowActive;

	private String createdBy;

	private String lApplyDate;

	private String editId;

	private Integer approveStatus;

	private Integer approveStageNo;

	private Integer currentStageNo;

	private String rejectionType;

	private String emplId;

	public RestLeaveApplyModel() {
		super();
	}

	public RestLeaveApplyModel(Object applyId, Object empName, Object lApplyDate, Object approveStatus,
			Object approveStageNo, Object ltypeName, Object lApplyStartDate, Object lApplyEndDate, Object lReason,
			Object totalLeave, Object currentStageNo, Object emplId) {
		super();
		this.applyId = (String) applyId;
		this.empName = (String) empName;
		this.lApplyDate = (String) lApplyDate;
		this.approveStatus = (Integer) approveStatus;
		this.approveStageNo = (Integer) approveStageNo;
		this.ltypeName = (String) ltypeName;
		this.lApplyStartDate = (String) lApplyStartDate;
		this.lApplyEndDate = (String) lApplyEndDate;
		this.lReason = (String) lReason;
		this.totalLeave = (Double) totalLeave;
		this.currentStageNo = (Integer) currentStageNo;
		this.emplId = (String) emplId;

	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getLtypeName() {
		return ltypeName;
	}

	public void setLtypeName(String ltypeName) {
		this.ltypeName = ltypeName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getTotalLeave() {
		return totalLeave;
	}

	public void setTotalLeave(Double totalLeave) {
		this.totalLeave = totalLeave;
	}

	public String getlApplyStartDate() {
		return lApplyStartDate;
	}

	public void setlApplyStartDate(String lApplyStartDate) {
		this.lApplyStartDate = lApplyStartDate;
	}

	public String getlApplyEndDate() {
		return lApplyEndDate;
	}

	public void setlApplyEndDate(String lApplyEndDate) {
		this.lApplyEndDate = lApplyEndDate;
	}

	public String getlReason() {
		return lReason;
	}

	public void setlReason(String lReason) {
		this.lReason = lReason;
	}

	public String getlApplyStatus() {
		return lApplyStatus;
	}

	public void setlApplyStatus(String lApplyStatus) {
		this.lApplyStatus = lApplyStatus;
	}

	public String getlApplyShowActive() {
		return lApplyShowActive;
	}

	public void setlApplyShowActive(String lApplyShowActive) {
		this.lApplyShowActive = lApplyShowActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getlApplyDate() {
		return lApplyDate;
	}

	public void setlApplyDate(String lApplyDate) {
		this.lApplyDate = lApplyDate;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public Integer getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}

	public Integer getApproveStageNo() {
		return approveStageNo;
	}

	public void setApproveStageNo(Integer approveStageNo) {
		this.approveStageNo = approveStageNo;
	}

	public Integer getCurrentStageNo() {
		return currentStageNo;
	}

	public void setCurrentStageNo(Integer currentStageNo) {
		this.currentStageNo = currentStageNo;
	}

	public String getRejectionType() {
		return rejectionType;
	}

	public void setRejectionType(String rejectionType) {
		this.rejectionType = rejectionType;
	}

	public String getEmplId() {
		return emplId;
	}

	public void setEmplId(String emplId) {
		this.emplId = emplId;
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
