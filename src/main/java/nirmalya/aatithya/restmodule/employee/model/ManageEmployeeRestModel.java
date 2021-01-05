package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageEmployeeRestModel {
	
	private String employeeId;
	private String fileEmployeeimg;
	
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String bloodGroup;
	private String maritalStatus;
	private String nationality;
	private String fatherName;
	private String motherName;
	private String mobileNo;
	private String personalMail;
	private String workMail;
	private String createdBy;
	
	//address
	
	
	/*
	 * private String type; private String address; private String city; private
	 * String state; private String country; private String zipCode; private Boolean
	 * status;
	 */
	
	public ManageEmployeeRestModel() {
		
		super();
	}
	public ManageEmployeeRestModel(Object employeeId, Object fileEmployeeimg, Object firstName, Object lastName,
			Object gender,  Object dob, Object bloodGroup   , Object maritalStatus,  Object nationality, Object fatherName
			, Object motherName,  Object mobileNo, Object personalMail ,  Object workMail,Object createdBy
			
				) {
		super();
		this.employeeId = (String) employeeId;
		this.fileEmployeeimg = (String) fileEmployeeimg;
		this.firstName = (String) firstName;
		this.lastName = (String) lastName;
		this.gender = (String) gender;
		this.dob = (String) dob;
		this.bloodGroup = (String) bloodGroup;
		this.maritalStatus = (String) maritalStatus;
		this.nationality = (String) nationality;
		this.fatherName = (String) fatherName;
		this.motherName = (String) motherName;
		this.mobileNo = (String) mobileNo;
		this.personalMail = (String) personalMail;
		this.workMail = (String) workMail;
		this.createdBy = (String) createdBy;
		/*
		 * this.type = (String) type; this.address = (String) address; this.city =
		 * (String) motherName; this.state = (String) state; this.country = (String)
		 * country; this.zipCode = (String) zipCode; this.status = (Boolean) status;
		 */
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFileEmployeeimg() {
		return fileEmployeeimg;
	}
	public void setFileEmployeeimg(String fileEmployeeimg) {
		this.fileEmployeeimg = fileEmployeeimg;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPersonalMail() {
		return personalMail;
	}
	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}
	public String getWorkMail() {
		return workMail;
	}
	public void setWorkMail(String workMail) {
		this.workMail = workMail;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	/*
	 * public String getType() { return type; } public void setType(String type) {
	 * this.type = type; } public String getAddress() { return address; } public
	 * void setAddress(String address) { this.address = address; } public String
	 * getCity() { return city; } public void setCity(String city) { this.city =
	 * city; } public String getState() { return state; } public void
	 * setState(String state) { this.state = state; } public String getCountry() {
	 * return country; } public void setCountry(String country) { this.country =
	 * country; } public String getZipCode() { return zipCode; } public void
	 * setZipCode(String zipCode) { this.zipCode = zipCode; } public Boolean
	 * getStatus() { return status; } public void setStatus(Boolean status) {
	 * this.status = status; }
	 */
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
