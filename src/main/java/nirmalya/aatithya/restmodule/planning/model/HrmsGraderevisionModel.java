package nirmalya.aatithya.restmodule.planning.model;

public class HrmsGraderevisionModel {
	private String gradeRevId;
	private String startDate;
	private String endDate;
	private String departmentId;
	private String departmentName;
	private String employeeId;
	private String employeeName;
	private String currentGradeId;
	private String currentGradeName;
	private String newGradeId;
	private String newGradeName;
	private String designId;
	private String designName;
	private String effectiveDate;
	private String status;
	private String createdBy;

	public HrmsGraderevisionModel() {
		super();
	}

	public HrmsGraderevisionModel(Object gradeRevId, Object startDate, Object endDate, Object departmentId,
			Object departmentName, Object employeeId, Object employeeName, Object currentGradeId,
			Object currentGradeName, Object newGradeId, Object newGradeName, Object designId, Object designName,
			Object effectiveDate, Object status) {

		this.gradeRevId = (String) gradeRevId;
		this.startDate = (String) startDate;
		this.endDate = (String) endDate;
		this.departmentId = (String) departmentId;
		this.departmentName = (String) departmentName;
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.currentGradeId = (String) currentGradeId;
		this.currentGradeName = (String) currentGradeName;
		this.newGradeId = (String) newGradeId;
		this.newGradeName = (String) newGradeName;
		this.designId = (String) designId;
		this.designName = (String) designName;
		this.effectiveDate = (String) effectiveDate;
		this.status = (String) status;
	}

	public String getGradeRevId() {
		return gradeRevId;
	}

	public void setGradeRevId(String gradeRevId) {
		this.gradeRevId = gradeRevId;
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public String getCurrentGradeId() {
		return currentGradeId;
	}

	public void setCurrentGradeId(String currentGradeId) {
		this.currentGradeId = currentGradeId;
	}

	public String getCurrentGradeName() {
		return currentGradeName;
	}

	public void setCurrentGradeName(String currentGradeName) {
		this.currentGradeName = currentGradeName;
	}

	public String getNewGradeId() {
		return newGradeId;
	}

	public void setNewGradeId(String newGradeId) {
		this.newGradeId = newGradeId;
	}

	public String getNewGradeName() {
		return newGradeName;
	}

	public void setNewGradeName(String newGradeName) {
		this.newGradeName = newGradeName;
	}

	public String getDesignId() {
		return designId;
	}

	public void setDesignId(String designId) {
		this.designId = designId;
	}

	public String getDesignName() {
		return designName;
	}

	public void setDesignName(String designName) {
		this.designName = designName;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
