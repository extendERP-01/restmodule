package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsAppraisalFormModel {
	private Integer tAppraisalSetupId;
	private String tEmployeeId;
	private String tEmployeeName;
	private String tEmployeeDept;
	private String tEmployeeJobTitle;
	private String tAppraisalFromDate;
	private String tAppraisalToDate;
	private String tAppraisalDueDate;
	private String tGoal;
	private String tKRAMeasure;
	private Double tTarget;
	private Double tSelfRate;
	private Double tFirstStageRating;
	private Double tSecondStageRating;
	private Boolean tAppraisalStatus;
	private Integer tStageNo;
	private String tStage1Comment;
	private String tStage2Comment;
	private String tCompanyId;
	private String tCreatedBy;
	private String tFinalComment;
	private Boolean tAppraisalFinalStatus;
	private String deptName;
	private String jobTitleName;
	private String goalName;
	private String commonComment;

	// List<HrmsEmployeeAppraisalFormListModel> appraisalList;
	public HrmsAppraisalFormModel(Object tAppraisalSetupId, Object tEmployeeId, Object tEmployeeName,
			Object tEmployeeDept, Object tEmployeeJobTitle, Object tAppraisalFromDate, Object tAppraisalToDate,
			Object tAppraisalDueDate, Object tGoal, Object tKRAMeasure, Object tTarget, Object tSelfRate,
			Object tFirstStageRating, Object tSecondStageRating, Object tAppraisalStatus, Object tStageNo,
			Object tStage1Comment, Object tStage2Comment, Object tCompanyId, Object tCreatedBy, Object tFinalComment,
			Object tAppraisalFinalStatus, Object deptName, Object jobTitleName, Object goalName, Object commonComment) {
		super();

		try {
			this.tAppraisalSetupId = (Integer) tAppraisalSetupId;
			this.tEmployeeId = (String) tEmployeeId;
			this.tEmployeeName = (String) tEmployeeName;
			this.tEmployeeDept = (String) tEmployeeDept;
			this.tEmployeeJobTitle = (String) tEmployeeJobTitle;
			this.tAppraisalFromDate = (String) tAppraisalFromDate;
			this.tAppraisalToDate = (String) tAppraisalToDate;
			this.tAppraisalDueDate = (String) tAppraisalDueDate;
			this.tGoal = (String) tGoal;
			this.tKRAMeasure = (String) tKRAMeasure;
			this.tTarget = (Double) tTarget;
			this.tSelfRate = (Double) tSelfRate;
			this.tFirstStageRating = (Double) tFirstStageRating;
			this.tSecondStageRating = (Double) tSecondStageRating;
			this.tAppraisalStatus = (Boolean) tAppraisalStatus;
			this.tStageNo = (Integer) tStageNo;
			this.tStage1Comment = (String) tStage1Comment;
			this.tStage2Comment = (String) tStage2Comment;
			this.tCompanyId = (String) tCompanyId;
			this.tCreatedBy = (String) tCreatedBy;
			this.tFinalComment = (String) tFinalComment;
			this.tAppraisalFinalStatus = (Boolean) tAppraisalFinalStatus;
			this.deptName = (String) deptName;
			this.jobTitleName = (String) jobTitleName;
			this.goalName = (String) goalName;
			this.commonComment = (String) commonComment;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer gettAppraisalSetupId() {
		return tAppraisalSetupId;
	}

	public void settAppraisalSetupId(Integer tAppraisalSetupId) {
		this.tAppraisalSetupId = tAppraisalSetupId;
	}

	public String gettEmployeeId() {
		return tEmployeeId;
	}

	public void settEmployeeId(String tEmployeeId) {
		this.tEmployeeId = tEmployeeId;
	}

	public String gettEmployeeName() {
		return tEmployeeName;
	}

	public void settEmployeeName(String tEmployeeName) {
		this.tEmployeeName = tEmployeeName;
	}

	public String gettEmployeeDept() {
		return tEmployeeDept;
	}

	public void settEmployeeDept(String tEmployeeDept) {
		this.tEmployeeDept = tEmployeeDept;
	}

	public String gettEmployeeJobTitle() {
		return tEmployeeJobTitle;
	}

	public void settEmployeeJobTitle(String tEmployeeJobTitle) {
		this.tEmployeeJobTitle = tEmployeeJobTitle;
	}

	public String gettAppraisalFromDate() {
		return tAppraisalFromDate;
	}

	public void settAppraisalFromDate(String tAppraisalFromDate) {
		this.tAppraisalFromDate = tAppraisalFromDate;
	}

	public String gettAppraisalToDate() {
		return tAppraisalToDate;
	}

	public void settAppraisalToDate(String tAppraisalToDate) {
		this.tAppraisalToDate = tAppraisalToDate;
	}

	public String gettAppraisalDueDate() {
		return tAppraisalDueDate;
	}

	public void settAppraisalDueDate(String tAppraisalDueDate) {
		this.tAppraisalDueDate = tAppraisalDueDate;
	}

	public String gettGoal() {
		return tGoal;
	}

	public void settGoal(String tGoal) {
		this.tGoal = tGoal;
	}

	public String gettKRAMeasure() {
		return tKRAMeasure;
	}

	public void settKRAMeasure(String tKRAMeasure) {
		this.tKRAMeasure = tKRAMeasure;
	}

	public Double gettTarget() {
		return tTarget;
	}

	public void settTarget(Double tTarget) {
		this.tTarget = tTarget;
	}

	public Double gettSelfRate() {
		return tSelfRate;
	}

	public void settSelfRate(Double tSelfRate) {
		this.tSelfRate = tSelfRate;
	}

	public Double gettFirstStageRating() {
		return tFirstStageRating;
	}

	public void settFirstStageRating(Double tFirstStageRating) {
		this.tFirstStageRating = tFirstStageRating;
	}

	public Double gettSecondStageRating() {
		return tSecondStageRating;
	}

	public void settSecondStageRating(Double tSecondStageRating) {
		this.tSecondStageRating = tSecondStageRating;
	}

	public Boolean gettAppraisalStatus() {
		return tAppraisalStatus;
	}

	public void settAppraisalStatus(Boolean tAppraisalStatus) {
		this.tAppraisalStatus = tAppraisalStatus;
	}

	public Integer gettStageNo() {
		return tStageNo;
	}

	public void settStageNo(Integer tStageNo) {
		this.tStageNo = tStageNo;
	}

	public String gettStage1Comment() {
		return tStage1Comment;
	}

	public void settStage1Comment(String tStage1Comment) {
		this.tStage1Comment = tStage1Comment;
	}

	public String gettStage2Comment() {
		return tStage2Comment;
	}

	public void settStage2Comment(String tStage2Comment) {
		this.tStage2Comment = tStage2Comment;
	}

	public String gettCompanyId() {
		return tCompanyId;
	}

	public void settCompanyId(String tCompanyId) {
		this.tCompanyId = tCompanyId;
	}

	public String gettCreatedBy() {
		return tCreatedBy;
	}

	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
	}

	public HrmsAppraisalFormModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String gettFinalComment() {
		return tFinalComment;
	}

	public void settFinalComment(String tFinalComment) {
		this.tFinalComment = tFinalComment;
	}

	public Boolean gettAppraisalFinalStatus() {
		return tAppraisalFinalStatus;
	}

	public void settAppraisalFinalStatus(Boolean tAppraisalFinalStatus) {
		this.tAppraisalFinalStatus = tAppraisalFinalStatus;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getJobTitleName() {
		return jobTitleName;
	}

	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public String getCommonComment() {
		return commonComment;
	}

	public void setCommonComment(String commonComment) {
		this.commonComment = commonComment;
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
