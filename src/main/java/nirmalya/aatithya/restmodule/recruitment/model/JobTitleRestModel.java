package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JobTitleRestModel {

	private String jobId;
	private String jObtitle;
	private String department;
	private String intPragraph;
	private String responsibility;
	private String jobType;
	private String workHourBenifit;
	private String skill;
	private String education;
	private Boolean status;
	private String createdBy;

	public JobTitleRestModel() {
		super(); 

	}

	public JobTitleRestModel(Object jobId, Object jObtitle, Object department, Object intPragraph,
			Object responsibility, Object jobType, Object workHourBenifit, Object skill, Object education,
			Object createdBy) {
		super();
		this.jobId = (String) jobId;
		this.jObtitle = (String) jObtitle;
		this.department = (String) department;
		this.intPragraph = (String) intPragraph;
		this.responsibility = (String) responsibility;
		this.jobType = (String) jobType;
		this.workHourBenifit = (String) workHourBenifit;
		this.skill = (String) skill;
		this.education = (String) education;
		this.createdBy = (String) createdBy;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getjObtitle() {
		return jObtitle;
	}

	public void setjObtitle(String jObtitle) {
		this.jObtitle = jObtitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getIntPragraph() {
		return intPragraph;
	}

	public void setIntPragraph(String intPragraph) {
		this.intPragraph = intPragraph;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getWorkHourBenifit() {
		return workHourBenifit;
	}

	public void setWorkHourBenifit(String workHourBenifit) {
		this.workHourBenifit = workHourBenifit;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
