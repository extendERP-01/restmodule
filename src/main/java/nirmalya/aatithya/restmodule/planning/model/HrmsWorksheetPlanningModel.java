package nirmalya.aatithya.restmodule.planning.model;

public class HrmsWorksheetPlanningModel {

	private String workForcePlanId;
	private String fromDate;
	private String toDate;
	private String departmentId;
	private String departmentName;
	private String sectionId;
	private String sectionName;
	private Double budgetInPer;
	private Double budgetInAmount;
	private Double actualInAmount;
	private Double actualInPer;
	private String employeeId;
	private String employeeName;
	private Double currentGross;
	private Double increment;
	private Double newGross;
	private Double currentCtc;
	private Double newCtc;
	private String action;
	
	private String createdBy;

	public HrmsWorksheetPlanningModel() {
		super();
	}

	public HrmsWorksheetPlanningModel(Object workForcePlanId, Object fromDate, Object toDate, Object departmentId,
			Object departmentName, Object sectionId, Object sectionName, Object budgetInPer, Object budgetInAmount,
			Object actualInAmount, Object actualInPer, Object employeeId, Object employeeName, Object currentGross,
			Object increment, Object newGross, Object currentCtc ,Object newCtc) {
		super();
		this.workForcePlanId = (String) workForcePlanId;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.departmentId = (String) departmentId;
		this.departmentName = (String) departmentName;
		this.sectionId = (String) sectionId;
		this.sectionName = (String) sectionName;
		this.budgetInPer = (Double) budgetInPer;
		this.budgetInAmount = (Double) budgetInAmount;
		this.actualInAmount = (Double) actualInAmount;
		this.actualInPer = (Double) actualInPer;
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.currentGross = (Double) currentGross;
		this.increment = (Double) increment;
		this.newGross = (Double) newGross;
		this.currentCtc = (Double) currentCtc;
		this.newCtc = (Double) newCtc;
	}

	public String getWorkForcePlanId() {
		return workForcePlanId;
	}

	public void setWorkForcePlanId(String workForcePlanId) {
		this.workForcePlanId = workForcePlanId;
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

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Double getBudgetInPer() {
		return budgetInPer;
	}

	public void setBudgetInPer(Double budgetInPer) {
		this.budgetInPer = budgetInPer;
	}

	public Double getBudgetInAmount() {
		return budgetInAmount;
	}

	public void setBudgetInAmount(Double budgetInAmount) {
		this.budgetInAmount = budgetInAmount;
	}

	public Double getActualInAmount() {
		return actualInAmount;
	}

	public void setActualInAmount(Double actualInAmount) {
		this.actualInAmount = actualInAmount;
	}

	public Double getActualInPer() {
		return actualInPer;
	}

	public void setActualInPer(Double actualInPer) {
		this.actualInPer = actualInPer;
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

	public Double getCurrentGross() {
		return currentGross;
	}

	public void setCurrentGross(Double currentGross) {
		this.currentGross = currentGross;
	}

	public Double getIncrement() {
		return increment;
	}

	public void setIncrement(Double increment) {
		this.increment = increment;
	}

	public Double getNewGross() {
		return newGross;
	}

	public void setNewGross(Double newGross) {
		this.newGross = newGross;
	}

	public Double getNewCtc() {
		return newCtc;
	}

	public void setNewCtc(Double newCtc) {
		this.newCtc = newCtc;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Double getCurrentCtc() {
		return currentCtc;
	}

	public void setCurrentCtc(Double currentCtc) {
		this.currentCtc = currentCtc;
	}

}
