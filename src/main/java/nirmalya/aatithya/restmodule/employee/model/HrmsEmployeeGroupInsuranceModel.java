package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeGroupInsuranceModel {

	private String employeeId;
	private String fName;
	private String mName;
	private String lName;
	private String relationship;
	private String dob;

	public HrmsEmployeeGroupInsuranceModel() {
		super();
		 
	}

	public HrmsEmployeeGroupInsuranceModel(Object employeeId, Object fName, Object mName, Object lName,
			Object relationship, Object dob) {
		super();
		this.employeeId = (String) employeeId;
		this.fName = (String) fName;
		this.mName = (String) mName;
		this.lName = (String) lName;
		this.relationship = (String) relationship;
		this.dob = (String) dob;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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
