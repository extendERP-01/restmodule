package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ManageEmployeeWorkdetailsRestModel {

	private String employeeworkId;
	private String employeeId;
	private String startDate;
	private String endDate;
	private String jobTitle;
	private String jobType;
	
	private String department;
	private String employmentStatus;
	private String degination;
	private String band;
	private String manager;
	private String annualCTC;
	
	
	private String createdBy;
public ManageEmployeeWorkdetailsRestModel() {
		
		super();
	}
	public ManageEmployeeWorkdetailsRestModel(Object employeeworkId, Object employeeId, Object startDate, Object endDate,
			Object jobTitle,Object jobType,  Object department, Object employmentStatus   , Object degination,  Object band, Object manager
			, Object annualCTC,Object createdBy
			
				) {
		super();
		this.employeeworkId = (String) employeeworkId;
		this.employeeId = (String) employeeId;
		this.startDate = (String) startDate;
		this.endDate = (String) endDate;
		this.jobType = (String) jobType;
		this.jobTitle = (String) jobTitle;
		this.department = (String) department;
		this.employmentStatus = (String) employmentStatus;
		this.degination = (String) degination;
		this.band = (String) band;
		this.manager = (String) manager;
		this.annualCTC = (String) annualCTC;	
		this.createdBy = (String) createdBy;
		
		

}
	public String getEmployeeworkId() {
		return employeeworkId;
	}
	public void setEmployeeworkId(String employeeworkId) {
		this.employeeworkId = employeeworkId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getDegination() {
		return degination;
	}
	public void setDegination(String degination) {
		this.degination = degination;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getAnnualCTC() {
		return annualCTC;
	}
	public void setAnnualCTC(String annualCTC) {
		this.annualCTC = annualCTC;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
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
