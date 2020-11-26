package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsExtraSalaryModel {

	private String employeeId;
	private String employeeName;
	private Double workingDay;
	private Double workDay;
	private Double extraDay;
	private String fromDate;
	private String toDate;

	public HrmsExtraSalaryModel() {
		super();
	}

	public HrmsExtraSalaryModel(Object employeeId, Object employeeName, Object workingDay, Object workDay,
			Object extraDay) {
		super();
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.workingDay = (Double) workingDay;
		this.workDay = (Double) workDay;
		this.extraDay = (Double) extraDay;
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

	public Double getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(Double workingDay) {
		this.workingDay = workingDay;
	}

	public Double getWorkDay() {
		return workDay;
	}

	public void setWorkDay(Double workDay) {
		this.workDay = workDay;
	}

	public Double getExtraDay() {
		return extraDay;
	}

	public void setExtraDay(Double extraDay) {
		this.extraDay = extraDay;
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
