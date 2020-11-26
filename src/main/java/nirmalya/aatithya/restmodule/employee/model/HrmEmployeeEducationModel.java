package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmEmployeeEducationModel {
	private String empId;
	private String qualifId;
	private String insti;
	private String startDate;
	private String endDate;
	private String editId;
	private String emplName;
	private String qualifName;
	private String createdBy;
	private String companyId;
	private BigInteger slNo;

	public HrmEmployeeEducationModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmEmployeeEducationModel(Object empId, Object qualifId, Object insti, Object startDate, Object endDate,
			Object emplName, Object qualifName, Object slNo) {
		super();
		try {
			this.empId = (String) empId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qualifId = (String) qualifId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.insti = (String) insti;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.startDate = (String) startDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.endDate = (String) endDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.emplName = (String) emplName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.qualifName = (String) qualifName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.slNo = (BigInteger) slNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getQualifId() {
		return qualifId;
	}

	public void setQualifId(String qualifId) {
		this.qualifId = qualifId;
	}

	public String getInsti() {
		return insti;
	}

	public void setInsti(String insti) {
		this.insti = insti;
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

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getEmplName() {
		return emplName;
	}

	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}

	public String getQualifName() {
		return qualifName;
	}

	public void setQualifName(String qualifName) {
		this.qualifName = qualifName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public BigInteger getSlNo() {
		return slNo;
	}

	public void setSlNo(BigInteger slNo) {
		this.slNo = slNo;
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
