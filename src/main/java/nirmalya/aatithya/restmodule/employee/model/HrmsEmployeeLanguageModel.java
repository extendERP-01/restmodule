package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeLanguageModel {

	private String empId;
	private String langId;
	private String readId;
	private String writeId;
	private String spaekId;
	private String editId;
	private String createdBy;
	private String companyId;
	private String empName;
	private String langName;
	private String readName;
	private String writeName;
	private String spaekName;
	private BigInteger slNo;

	public HrmsEmployeeLanguageModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsEmployeeLanguageModel(Object empId, Object langId, Object readId, Object writeId, Object spaekId,
			Object empName, Object langName, Object readName, Object writeName, Object spaekName, Object slNo) {
		super();
		try {
			this.empId = (String) empId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.langId = (String) langId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.readId = (String) readId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.writeId = (String) writeId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.spaekId = (String) spaekId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empName = (String) empName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.langName = (String) langName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.readName = (String) readName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.writeName = (String) writeName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.spaekName = (String) spaekName;
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

	public String getLangId() {
		return langId;
	}

	public void setLangId(String langId) {
		this.langId = langId;
	}

	public String getReadId() {
		return readId;
	}

	public void setReadId(String readId) {
		this.readId = readId;
	}

	public String getWriteId() {
		return writeId;
	}

	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}

	public String getSpaekId() {
		return spaekId;
	}

	public void setSpaekId(String spaekId) {
		this.spaekId = spaekId;
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

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

	public String getReadName() {
		return readName;
	}

	public void setReadName(String readName) {
		this.readName = readName;
	}

	public String getWriteName() {
		return writeName;
	}

	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}

	public String getSpaekName() {
		return spaekName;
	}

	public void setSpaekName(String spaekName) {
		this.spaekName = spaekName;
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
