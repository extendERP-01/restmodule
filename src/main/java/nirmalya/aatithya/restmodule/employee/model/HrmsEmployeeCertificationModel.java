package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeCertificationModel {

	private String empId;
	private String certifId;
	private String insti;
	private String grantDate;
	private String validDate;
	private String editId;
	private String empName;
	private String certifName;
	private Integer slNo;
	private String createdBy;
	private String companyId;

	public HrmsEmployeeCertificationModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsEmployeeCertificationModel(Object empId, Object certifId, Object insti, Object grantDate,
			Object validDate, Object empName, Object certifName, Object slNo) {
		super();
		try {
			this.empId = (String) empId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.certifId = (String) certifId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.insti = (String) insti;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.grantDate = (String) grantDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.validDate = (String) validDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empName = (String) empName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.certifName = (String) certifName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.slNo = (Integer) slNo;
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

	public String getCertifId() {
		return certifId;
	}

	public void setCertifId(String certifId) {
		this.certifId = certifId;
	}

	public String getInsti() {
		return insti;
	}

	public void setInsti(String insti) {
		this.insti = insti;
	}

	public String getGrantDate() {
		return grantDate;
	}

	public void setGrantDate(String grantDate) {
		this.grantDate = grantDate;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCertifName() {
		return certifName;
	}

	public void setCertifName(String certifName) {
		this.certifName = certifName;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
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
