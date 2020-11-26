package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEsicExcelModel {

	private String fromDate;
	private String toDate;
	private String empId;
	private String empName;
	private Double empEsci;
	private Double empeerEsci;

	public HrmsEsicExcelModel() {
		super(); 
	}

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	public HrmsEsicExcelModel(Object fromDate, Object toDate, Object empId, Object empName, Object empEsci,
			Object empeerEsci) {
		super();
		this.fromDate = dateFormat.format(fromDate);
		this.toDate = dateFormat.format(toDate);
		this.empId = (String) empId;
		this.empName = (String) empName;
		this.empEsci = (Double) empEsci;
		this.empeerEsci = (Double) empeerEsci;
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

	public Double getEmpEsci() {
		return empEsci;
	}

	public void setEmpEsci(Double empEsci) {
		this.empEsci = empEsci;
	}

	public Double getEmpeerEsci() {
		return empeerEsci;
	}

	public void setEmpeerEsci(Double empeerEsci) {
		this.empeerEsci = empeerEsci;
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
