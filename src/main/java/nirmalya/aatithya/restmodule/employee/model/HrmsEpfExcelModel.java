package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEpfExcelModel {
	private String fromDate;
	private String toDate;
	private String employeeId;
	private String employeeName;
	private Double Empl_Epf;
	private Double Empr_Epf;

	public HrmsEpfExcelModel() {
		super(); 
	}

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	public HrmsEpfExcelModel(Object fromDate, Object toDate, Object empId, Object empName,
			Object empl_Epf, Object empr_Epf) {

		this.fromDate = dateFormat.format(fromDate);
		this.toDate = dateFormat.format(toDate);
		this.employeeId = (String) empId;
		this.employeeName = (String) empName;
		this.Empl_Epf = (Double) empl_Epf;
		this.Empr_Epf = (Double) empr_Epf;
		
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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String empId) {
		this.employeeId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String empName) {
		this.employeeName = empName;
	}

	public Double getEmpl_Epf() {
		return Empl_Epf;
	}

	public void setEmpl_Epf(Double empl_Epf) {
		Empl_Epf = empl_Epf;
	}

	public Double getEmpr_Epf() {
		return Empr_Epf;
	}

	public void setEmpr_Epf(Double empr_Epf) {
		Empr_Epf = empr_Epf;
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
