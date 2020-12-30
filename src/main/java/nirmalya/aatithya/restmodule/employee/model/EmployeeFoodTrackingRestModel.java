package nirmalya.aatithya.restmodule.employee.model;

public class EmployeeFoodTrackingRestModel {

	private String employeeId;
	private String employeeName;
	private String date;
	private Integer dayMeal;
	private Integer nightMeal;
	private String isEdit;
	private String createdBy;
	private Integer totalMeal;
	private String fromDate;
	private String toDate;

	public EmployeeFoodTrackingRestModel() {
		super();
	}

	public EmployeeFoodTrackingRestModel(Object employeeId, Object employeeName, Object date, Object dayMeal,
			Object nightMeal, Object isEdit, Object createdBy) {
		super();
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.date = (String) date;
		this.dayMeal = (Integer) dayMeal;
		this.nightMeal = (Integer) nightMeal;
		this.isEdit = (String) isEdit;
		this.createdBy = (String) createdBy;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDayMeal() {
		return dayMeal;
	}

	public void setDayMeal(Integer dayMeal) {
		this.dayMeal = dayMeal;
	}

	public Integer getNightMeal() {
		return nightMeal;
	}

	public void setNightMeal(Integer nightMeal) {
		this.nightMeal = nightMeal;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getTotalMeal() {
		return totalMeal;
	}

	public void setTotalMeal(Integer totalMeal) {
		this.totalMeal = totalMeal;
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
}
