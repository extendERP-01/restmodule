package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeDependentModel {
	private String empId;
	private String relName;
	private String relationId;
	private String adharNo;
	private String mobNo;
	private String empName;
	private String editId;
	private String createdBy;
	private String companyId;
	private String relationName;
	private BigInteger slNo;

	public HrmsEmployeeDependentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsEmployeeDependentModel(Object empId, Object relName, Object relationId, Object adharNo, Object mobNo,
			Object empName, Object relationName, Object slNo) {
		super();
		try {
			this.empId = (String) empId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.relName = (String) relName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.relationId = (String) relationId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.adharNo = (String) adharNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mobNo = (String) mobNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empName = (String) empName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.relationName = (String) relationName;
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

	public String getRelName() {
		return relName;
	}

	public void setRelName(String relName) {
		this.relName = relName;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEditId() {
		return editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
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

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
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
