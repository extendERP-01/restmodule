package nirmalya.aatithya.restmodule.employee.model;

public class HrmsDailyAttendanceExcelModel {
	private String date;
	private String employeeId;
	private String employeeName;
	private String inTime;
	private String outTime;
	private String action;
	private String bioMetricId;

	public HrmsDailyAttendanceExcelModel() {
		super();
	}

	public HrmsDailyAttendanceExcelModel(Object date, Object employeeId, Object employeeName, Object inTime,
			Object outTime, Object bioMetricId) {
		super();
		this.date = (String) date;
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.inTime = (String) inTime;
		this.outTime = (String) outTime;
		this.bioMetricId = (String) bioMetricId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getBioMetricId() {
		return bioMetricId;
	}

	public void setBioMetricId(String bioMetricId) {
		this.bioMetricId = bioMetricId;
	}

}
