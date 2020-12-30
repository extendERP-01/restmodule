package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHrmsEmployeeAppraisalFormModel {
	private Integer tAppraisalSetupId;
	private String empId;
	private String empName;
	private String dept;
	private String jobTitle;
	private String fromDate;
	private String toDate;

	private Integer dueDate;
	private String frequency;
	private String createdDate;
	List<HrmsEmployeeAppraisalFormListModel> appraisalList;
	private Boolean tStatus;
	private String goal;
	private String kraMeasure;
	private Double target;
	private Double selfMarked;
	private String goalName;
	private String deptName;
	private String jobName;
	private String tCompanyId;
	private String tCreatedBy;
	private String isedit;
	private String userId;
	private Integer count;
	private String empDueDate;

	public RestHrmsEmployeeAppraisalFormModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestHrmsEmployeeAppraisalFormModel(Object tAppraisalSetupId, Object empId, Object empName, Object dept,
			Object jobTitle, Object fromDate, Object toDate, Object dueDate, Object frequency, Object createdDate,
			Object appraisalList, Object tStatus, Object goal, Object kraMeasure, Object target, Object selfMarked,
			Object goalName , Object deptName,Object jobName,Object empDueDate) {
		super();
		try {
			this.selfMarked = (Double) selfMarked;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empDueDate = (String) empDueDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.target = (Double) target;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.kraMeasure = (String) kraMeasure;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.goalName = (String) goalName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.jobName = (String) jobName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.deptName = (String) deptName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.goal = (String) goal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.appraisalList = (List<HrmsEmployeeAppraisalFormListModel>) appraisalList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tAppraisalSetupId = (Integer) tAppraisalSetupId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdDate = (String) createdDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.tStatus = (Boolean) tStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.frequency = (String) frequency;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dueDate = (Integer) dueDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.toDate = (String) toDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.fromDate = (String) fromDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.jobTitle = (String) jobTitle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.dept = (String) dept;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empName = (String) empName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empId = (String) empId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.count = (Integer) count;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getKraMeasure() {
		return kraMeasure;
	}

	public void setKraMeasure(String kraMeasure) {
		this.kraMeasure = kraMeasure;
	}

	public Double getTarget() {
		return target;
	}

	public String getEmpDueDate() {
		return empDueDate;
	}

	public void setEmpDueDate(String empDueDate) {
		this.empDueDate = empDueDate;
	}

	public void setTarget(Double target) {
		this.target = target;
	}

	public Double getSelfMarked() {
		return selfMarked;
	}

	public void setSelfMarked(Double selfMarked) {
		this.selfMarked = selfMarked;
	}

	public String gettCreatedBy() {
		return tCreatedBy;
	}

	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Integer gettAppraisalSetupId() {
		return tAppraisalSetupId;
	}

	public void settAppraisalSetupId(Integer tAppraisalSetupId) {
		this.tAppraisalSetupId = tAppraisalSetupId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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

	public Integer getDueDate() {
		return dueDate;
	}

	public void setDueDate(Integer dueDate) {
		this.dueDate = dueDate;
	}

	public String gettCompanyId() {
		return tCompanyId;
	}

	public void settCompanyId(String tCompanyId) {
		this.tCompanyId = tCompanyId;
	}

	public String getIsedit() {
		return isedit;
	}

	public void setIsedit(String isedit) {
		this.isedit = isedit;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<HrmsEmployeeAppraisalFormListModel> getAppraisalList() {
		return appraisalList;
	}

	public void setAppraisalList(List<HrmsEmployeeAppraisalFormListModel> appraisalList) {
		this.appraisalList = appraisalList;
	}

	public Boolean gettStatus() {
		return tStatus;
	}

	public void settStatus(Boolean tStatus) {
		this.tStatus = tStatus;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
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
