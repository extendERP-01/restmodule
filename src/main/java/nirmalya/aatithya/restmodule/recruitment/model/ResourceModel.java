package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResourceModel {

	private String requisitionId;
	private String jobId;
	private String jobTitle;
	private String jobType;
	private String deptId;
	private String deptName;
	private String empId;
	private String hiringManager;
	private String boardBy;
	private Double budget;
	private String vendorId;
	private String vedorName;
	private List<String> vendorList;
	private Boolean asgnStatus;
	private String fatherName;
	private String dob;
	private String candidateName;
	private List<String> file = new ArrayList<String>();
	private String document;
	private String createdBy;
	private String employeeId;
	private String employeeName;
	private String fromTime;
	private String toTime;
	private String status;
	private Integer candidateId;
	private String specificId;
	private String question;
	private String remark;
	private Integer feedbackStatus;
	private String isEdit;
	private String comment;
	private String specificName;
	

	public String getSpecificName() {
		return specificName;
	}


	public void setSpecificName(String specificName) {
		this.specificName = specificName;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	

	public String getIsEdit() {
		return isEdit;
	}


	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	

	public Integer getFeedbackStatus() {
		return feedbackStatus;
	}


	public void setFeedbackStatus(Integer feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@SuppressWarnings("unchecked")
	public ResourceModel(Object requisitionId, Object jobId, Object jobTitle, Object jobType, Object deptId, Object deptName, Object empId,
			Object hiringManager, Object boardBy, Object budget, Object vendorId, Object vendorName, Object asgnStatus, Object file, Object document,
			Object candidateName, Object dob, Object employeeId, Object employeeName, Object status, Object candidateId, Object fromTime, 
			Object toTime, Object feedbackStatus, Object isEdit, Object comment, Object specificId,Object specificName, Object question, Object remark) {
		this.requisitionId = (String) requisitionId;
		this.jobId = (String) jobId;
		this.jobTitle = (String) jobTitle;
		this.jobType = (String) jobType;
		this.deptId = (String) deptId;
		this.deptName = (String) deptName;
		this.empId = (String) empId;
		this.hiringManager = (String) hiringManager;
		this.boardBy = (String) boardBy;
		this.budget = (Double) budget;
		this.vedorName = (String) vendorName;
		this.vendorId = (String) vendorId;
		this.asgnStatus = (Boolean) asgnStatus;
		this.file = (List<String>) file;
		this.document = (String) document;
		this.candidateName = (String) candidateName;
		this.dob = (String) dob;
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.status = (String) status;
		this.candidateId = (Integer) candidateId;
		this.fromTime = (String) fromTime;
		this.toTime = (String) toTime;
		this.feedbackStatus = (Integer) feedbackStatus;
		this.isEdit = (String) isEdit;
		this.comment = (String) comment;
		this.specificId = (String) specificId;
		this.specificName = (String) specificName;
		this.question = (String) question;
		this.remark = (String) remark;
		
	}


	public ResourceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getHiringManager() {
		return hiringManager;
	}
	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}
	
	public String getBoardBy() {
		return boardBy;
	}


	public void setBoardBy(String boardBy) {
		this.boardBy = boardBy;
	}


	public Double getBudget() {
		return budget;
	}


	public void setBudget(Double budget) {
		this.budget = budget;
	}


	public String getVendorId() {
		return vendorId;
	}


	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}


	public String getVedorName() {
		return vedorName;
	}


	public void setVedorName(String vedorName) {
		this.vedorName = vedorName;
	}


	public List<String> getVendorList() {
		return vendorList;
	}


	public void setVendorList(List<String> vendorList) {
		this.vendorList = vendorList;
	}


	public Boolean getAsgnStatus() {
		return asgnStatus;
	}


	public void setAsgnStatus(Boolean asgnStatus) {
		this.asgnStatus = asgnStatus;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public List<String> getFile() {
		return file;
	}


	public void setFile(List<String> file) {
		this.file = file;
	}


	public String getDocument() {
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getFromTime() {
		return fromTime;
	}


	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}


	public String getToTime() {
		return toTime;
	}


	public void setToTime(String toTime) {
		this.toTime = toTime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getCandidateId() {
		return candidateId;
	}


	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}
	public String getSpecificId() {
		return specificId;
	}
	public void setSpecificId(String specificId) {
		this.specificId = specificId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
