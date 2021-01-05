package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AddRecruitentModel {

	private String requisitionId;
	private List<String> benefits;
	private String jobTitle;
	private String jobType;
	private String jobLocation;
	private String minEducation;
	private Double minSalary;
	private Double maxSalary;
	private String department;
	private String hiringManager;
	private Integer noPosition;
	private String workHour;
	private String band;
	private String joinDate;
	private String positionSummary;
	private String positionResponsibility;
	private String requiredSkillExperience;
	private String approver;
	private String about;
	private String createdBy;
	private String createdOn;
	private String activityStatus;
	private String reqBenefits;
	 
	
	@SuppressWarnings("unchecked")
	public AddRecruitentModel(Object requisitionId, Object benefits, Object jobTitle, Object jobType,
			Object jobLocation, Object minEducation, Object minSalary, Object maxSalary, Object department,
			Object hiringManager, Object noPosition, Object workHour, Object band, Object joinDate,
			Object positionSummary, Object positionResponsibility, Object requiredSkillExperience, Object approver,
			Object about,Object createdBy, Object createdOn, Object activityStatus, Object reqBenefits) {
		super();
		this.requisitionId = (String) requisitionId;
		this.benefits = (List<String>) benefits;
		this.jobTitle = (String) jobTitle;
		this.jobType = (String) jobType;
		this.jobLocation = (String) jobLocation;
		this.minEducation = (String) minEducation;
		this.minSalary = (Double) minSalary;
		this.maxSalary = (Double) maxSalary;
		this.department = (String) department;
		this.hiringManager = (String) hiringManager;
		this.noPosition = (Integer) noPosition;
		this.workHour = (String) workHour;
		this.band = (String) band;
		this.joinDate = (String) joinDate;
		this.positionSummary = (String) positionSummary;
		this.positionResponsibility = (String) positionResponsibility;
		this.requiredSkillExperience = (String) requiredSkillExperience;
		this.approver = (String) approver;
		this.about = (String) about;
		this.createdBy = (String) createdBy;
		this.createdOn = (String) createdOn;
		this.activityStatus = (String) activityStatus;
		this.reqBenefits = (String) reqBenefits;
		
		
		
	}
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public List<String> getBenefits() {
		return benefits;
	}
	public void setBenefits(List<String> benefits) {
		this.benefits = benefits;
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
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getMinEducation() {
		return minEducation;
	}
	public void setMinEducation(String minEducation) {
		this.minEducation = minEducation;
	}
	public Double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}
	public Double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHiringManager() {
		return hiringManager;
	}
	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}
	public Integer getNoPosition() {
		return noPosition;
	}
	public void setNoPosition(Integer noPosition) {
		this.noPosition = noPosition;
	}
	public String getWorkHour() {
		return workHour;
	}
	public void setWorkHour(String workHour) {
		this.workHour = workHour;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getPositionSummary() {
		return positionSummary;
	}
	public void setPositionSummary(String positionSummary) {
		this.positionSummary = positionSummary;
	}
	public String getPositionResponsibility() {
		return positionResponsibility;
	}
	public void setPositionResponsibility(String positionResponsibility) {
		this.positionResponsibility = positionResponsibility;
	}
	public String getRequiredSkillExperience() {
		return requiredSkillExperience;
	}
	public void setRequiredSkillExperience(String requiredSkillExperience) {
		this.requiredSkillExperience = requiredSkillExperience;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	public String getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	public String getReqBenefits() {
		return reqBenefits;
	}
	public void setReqBenefits(String reqBenefits) {
		this.reqBenefits = reqBenefits;
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
