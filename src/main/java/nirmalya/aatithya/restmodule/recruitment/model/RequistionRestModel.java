package nirmalya.aatithya.restmodule.recruitment.model;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequistionRestModel {
	
	
	private String requistionId;
	
	private String jobCode;
	private String jobTitle;
	private String Department;
	
	private String hiringManager;
	private String onboardBy;
	private Double Budget;
	
	private String createdBy;
	private String Action;
	public RequistionRestModel() {
		super(); 
	} 
	public RequistionRestModel(Object jobCode, Object jobTitle, Object Department,
			Object hiringManager, Object onboardBy, Object Budget,Object requistionId,
			Object createdBy) {
		super();
		try {
			this.jobCode = (String) jobCode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.jobTitle = (String) jobTitle;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.Department = (String) Department;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.hiringManager = (String) hiringManager;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.onboardBy = (String) onboardBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.Budget = (Double) Budget;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.requistionId = (String) requistionId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getHiringManager() {
		return hiringManager;
	}
	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}
	public String getOnboardBy() {
		return onboardBy;
	}
	public void setOnboardBy(String onboardBy) {
		this.onboardBy = onboardBy;
	}
	public Double getBudget() {
		return Budget;
	}
	public void setBudget(Double budget) {
		Budget = budget;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	
	public String getRequistionId() {
		return requistionId;
	}
	public void setRequistionId(String requistionId) {
		this.requistionId = requistionId;
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