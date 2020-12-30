package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestKRAMeasureDetailsModel {
	private String kDepartment;
	private String kJobTitle;
	private String kGoal;
	private String kMeasure;
	private Double kTarget;
	private String kCompanyId;
	private String kCreatedBy;
	private String isedit;
	private String deptId;
	private String jobTitleId;

	public RestKRAMeasureDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestKRAMeasureDetailsModel(Object kDepartment, Object kJobTitle, Object kGoal, Object kMeasure,
			Object kTarget,Object isedit ,Object deptId,Object jobTitleId) {
		super();
		try {
			this.isedit = (String) isedit;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.deptId = (String) deptId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.jobTitleId = (String) jobTitleId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.kTarget = (Double) kTarget;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.kMeasure = (String) kMeasure;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.kGoal = (String) kGoal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.kJobTitle = (String) kJobTitle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.kDepartment = (String) kDepartment;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getkDepartment() {
		return kDepartment;
	}

	public void setkDepartment(String kDepartment) {
		this.kDepartment = kDepartment;
	}

	public String getkJobTitle() {
		return kJobTitle;
	}

	public void setkJobTitle(String kJobTitle) {
		this.kJobTitle = kJobTitle;
	}

	public String getkGoal() {
		return kGoal;
	}

	public void setkGoal(String kGoal) {
		this.kGoal = kGoal;
	}

	public String getkMeasure() {
		return kMeasure;
	}

	public void setkMeasure(String kMeasure) {
		this.kMeasure = kMeasure;
	}

	

	public Double getkTarget() {
		return kTarget;
	}

	public void setkTarget(Double kTarget) {
		this.kTarget = kTarget;
	}

	public String getkCompanyId() {
		return kCompanyId;
	}

	public void setkCompanyId(String kCompanyId) {
		this.kCompanyId = kCompanyId;
	}

	public String getkCreatedBy() {
		return kCreatedBy;
	}

	public void setkCreatedBy(String kCreatedBy) {
		this.kCreatedBy = kCreatedBy;
	}
	

	public String getIsedit() {
		return isedit;
	}

	public void setIsedit(String isedit) {
		this.isedit = isedit;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getJobTitleId() {
		return jobTitleId;
	}

	public void setJobTitleId(String jobTitleId) {
		this.jobTitleId = jobTitleId;
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
