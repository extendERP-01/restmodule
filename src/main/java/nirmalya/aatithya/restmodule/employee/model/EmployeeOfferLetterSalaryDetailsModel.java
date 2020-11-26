package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException; 

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeOfferLetterSalaryDetailsModel {
	// salary components details
	private String tEmployeeId;
	private Double tAnnualCTC;
	private String tSalaryComponent;
	private String tEffectiveDate;
	private Double tSalaryComponentValue;
	private String tPayGrade;
	private String tJobTitle;
	private Double tBasicPay;
	private Double tDearnessAllowance;
	private Double tHouseRentAllowance;
	private Double tConveyanceAllowance;
	private Double tLeaveTravelAllowance;
	private Double tMedicalAllowance;
	private Double tEmployeeProvidentFund;
	private Double tESICscheme;
	private Double tPerquisites;
	private String tSalaryComponentName;
	// employee details
	private String employeeLetterId;
	private String employeeFname;
	private String employeeMname;
	private String employeeLname;
	private String employeeNationality;
	private String employeeDob;
	private String employeeImage;
	private String employeeGender;
	private String employeeMarital;
	private String employeeEsicNo;
	private String employeePassword;

	private String employeeAdhar;
	private String employeeOtherId;
	private String employeeDl;
	private String employeeEmployment;
	private String employeeJobTitle;
	private String employeePayGrade;
	private String employeeWorkStationId;
	private String employeeAddress;
	private String employeeCity;
	private String employeeState;
	private String employeeCountry;
	private String employeePin;
	private String employeeHomePhoneNo;
	private String employeeMobilePhoneNo;
	private String employeeWorkPhoneNo;
	private String employeeWorkEmail;
	private String employeePersonalEmail;
	private String employeeJoinDate;
	private String employeeConfirmDate;
	private String employeeTerminateDate;
	private String employeeDepartment;
	private String empDesignation;
	private String createdBy;
	private String companyId;
	private String passPin;
	private Double tTaxableAmount;
	private Double tPayableAmount;

	public EmployeeOfferLetterSalaryDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeOfferLetterSalaryDetailsModel(Object tEmployeeId, Object tAnnualCTC, Object tSalaryComponent,
			Object tEffectiveDate, Object tSalaryComponentValue, Object tPayGrade, Object tJobTitle, Object tBasicPay,
			Object tDearnessAllowance, Object tHouseRentAllowance, Object tConveyanceAllowance,
			Object tLeaveTravelAllowance, Object tMedicalAllowance, Object tEmployeeProvidentFund, Object tESICscheme,
			Object tPerquisites, Object tSalaryComponentName, Object employeeLetterId, Object employeeFname,
			Object employeeMname, Object employeeLname, Object employeeNationality, Object employeeDob,
			Object employeeImage, Object employeeGender, Object employeeMarital, Object employeeEsicNo,
			Object employeePassword, Object employeeAdhar, Object employeeOtherId, Object employeeDl,
			Object employeeEmployment, Object employeeJobTitle, Object employeePayGrade, Object employeeWorkStationId,
			Object employeeAddress, Object employeeCity, Object employeeState, Object employeeCountry,
			Object employeePin, Object employeeHomePhoneNo, Object employeeMobilePhoneNo, Object employeeWorkPhoneNo,
			Object employeeWorkEmail, Object employeePersonalEmail, Object employeeJoinDate, Object employeeConfirmDate,
			Object employeeTerminateDate, Object employeeDepartment, Object empDesignation, Object createdBy,
			Object companyId, Object passPin, Object tTaxableAmount, Object tPayableAmount) {
		super();
		this.tEmployeeId = (String) tEmployeeId;
		this.tAnnualCTC = (Double) tAnnualCTC;
		this.tSalaryComponent = (String) tSalaryComponent;
		this.tEffectiveDate = (String) tEffectiveDate;
		this.tSalaryComponentValue = (Double) tSalaryComponentValue;
		this.tPayGrade = (String) tPayGrade;
		this.tJobTitle = (String) tJobTitle;
		this.tBasicPay = (Double) tBasicPay;
		this.tDearnessAllowance = (Double) tDearnessAllowance;
		this.tHouseRentAllowance = (Double) tHouseRentAllowance;
		this.tConveyanceAllowance = (Double) tConveyanceAllowance;
		this.tLeaveTravelAllowance = (Double) tLeaveTravelAllowance;
		this.tMedicalAllowance = (Double) tMedicalAllowance;
		this.tEmployeeProvidentFund = (Double) tEmployeeProvidentFund;
		this.tESICscheme = (Double) tESICscheme;
		this.tPerquisites = (Double) tPerquisites;
		this.tSalaryComponentName = (String) tSalaryComponentName;
		this.employeeLetterId = (String) employeeLetterId;
		this.employeeFname = (String) employeeFname;
		this.employeeMname = (String) employeeMname;
		this.employeeLname = (String) employeeLname;
		this.employeeNationality = (String) employeeNationality;
		this.employeeDob = (String) employeeDob;
		this.employeeImage = (String) employeeImage;
		this.employeeGender = (String) employeeGender;
		this.employeeMarital = (String) employeeMarital;
		this.employeeEsicNo = (String) employeeEsicNo;
		this.employeePassword = (String) employeePassword;
		this.employeeAdhar = (String) employeeAdhar;
		this.employeeOtherId = (String) employeeOtherId;
		this.employeeDl = (String) employeeDl;
		this.employeeEmployment = (String) employeeEmployment;
		this.employeeJobTitle = (String) employeeJobTitle;
		this.employeePayGrade = (String) employeePayGrade;
		this.employeeWorkStationId = (String) employeeWorkStationId;
		this.employeeAddress = (String) employeeAddress;
		this.employeeCity = (String) employeeCity;
		this.employeeState = (String) employeeState;
		this.employeeCountry = (String) employeeCountry;
		this.employeePin = (String) employeePin;
		this.employeeHomePhoneNo = (String) employeeHomePhoneNo;
		this.employeeMobilePhoneNo = (String) employeeMobilePhoneNo;
		this.employeeWorkPhoneNo = (String) employeeWorkPhoneNo;
		this.employeeWorkEmail = (String) employeeWorkEmail;
		this.employeePersonalEmail = (String) employeePersonalEmail;
		this.employeeJoinDate = (String) employeeJoinDate;
		this.employeeConfirmDate = (String) employeeConfirmDate;
		this.employeeTerminateDate = (String) employeeTerminateDate;
		this.employeeDepartment = (String) employeeDepartment;
		this.empDesignation = (String) empDesignation;
		this.createdBy = (String) createdBy;
		this.companyId = (String) companyId;
		this.tTaxableAmount = (Double) tTaxableAmount;
		this.tPayableAmount = (Double) tPayableAmount;
		this.passPin = (String) passPin;

	}

	public Double gettTaxableAmount() {
		return tTaxableAmount;
	}

	public void settTaxableAmount(Double tTaxableAmount) {
		this.tTaxableAmount = tTaxableAmount;
	}

	public Double gettPayableAmount() {
		return tPayableAmount;
	}

	public void settPayableAmount(Double tPayableAmount) {
		this.tPayableAmount = tPayableAmount;
	}

	public String getEmployeeLetterId() {
		return employeeLetterId;
	}

	public void setEmployeeLetterId(String employeeLetterId) {
		this.employeeLetterId = employeeLetterId;
	}

	public String getPassPin() {
		return passPin;
	}

	public void setPassPin(String passPin) {
		this.passPin = passPin;
	}

	public String gettEmployeeId() {
		return tEmployeeId;
	}

	public void settEmployeeId(String tEmployeeId) {
		this.tEmployeeId = tEmployeeId;
	}

	public Double gettAnnualCTC() {
		return tAnnualCTC;
	}

	public void settAnnualCTC(Double tAnnualCTC) {
		this.tAnnualCTC = tAnnualCTC;
	}

	public String gettSalaryComponent() {
		return tSalaryComponent;
	}

	public void settSalaryComponent(String tSalaryComponent) {
		this.tSalaryComponent = tSalaryComponent;
	}

	public String gettEffectiveDate() {
		return tEffectiveDate;
	}

	public void settEffectiveDate(String tEffectiveDate) {
		this.tEffectiveDate = tEffectiveDate;
	}

	public Double gettSalaryComponentValue() {
		return tSalaryComponentValue;
	}

	public void settSalaryComponentValue(Double tSalaryComponentValue) {
		this.tSalaryComponentValue = tSalaryComponentValue;
	}

	public String gettPayGrade() {
		return tPayGrade;
	}

	public void settPayGrade(String tPayGrade) {
		this.tPayGrade = tPayGrade;
	}

	public String gettJobTitle() {
		return tJobTitle;
	}

	public void settJobTitle(String tJobTitle) {
		this.tJobTitle = tJobTitle;
	}

	public Double gettBasicPay() {
		return tBasicPay;
	}

	public void settBasicPay(Double tBasicPay) {
		this.tBasicPay = tBasicPay;
	}

	public Double gettDearnessAllowance() {
		return tDearnessAllowance;
	}

	public void settDearnessAllowance(Double tDearnessAllowance) {
		this.tDearnessAllowance = tDearnessAllowance;
	}

	public Double gettHouseRentAllowance() {
		return tHouseRentAllowance;
	}

	public void settHouseRentAllowance(Double tHouseRentAllowance) {
		this.tHouseRentAllowance = tHouseRentAllowance;
	}

	public Double gettConveyanceAllowance() {
		return tConveyanceAllowance;
	}

	public void settConveyanceAllowance(Double tConveyanceAllowance) {
		this.tConveyanceAllowance = tConveyanceAllowance;
	}

	public Double gettLeaveTravelAllowance() {
		return tLeaveTravelAllowance;
	}

	public void settLeaveTravelAllowance(Double tLeaveTravelAllowance) {
		this.tLeaveTravelAllowance = tLeaveTravelAllowance;
	}

	public Double gettMedicalAllowance() {
		return tMedicalAllowance;
	}

	public void settMedicalAllowance(Double tMedicalAllowance) {
		this.tMedicalAllowance = tMedicalAllowance;
	}

	public Double gettEmployeeProvidentFund() {
		return tEmployeeProvidentFund;
	}

	public void settEmployeeProvidentFund(Double tEmployeeProvidentFund) {
		this.tEmployeeProvidentFund = tEmployeeProvidentFund;
	}

	public Double gettESICscheme() {
		return tESICscheme;
	}

	public void settESICscheme(Double tESICscheme) {
		this.tESICscheme = tESICscheme;
	}

	public Double gettPerquisites() {
		return tPerquisites;
	}

	public void settPerquisites(Double tPerquisites) {
		this.tPerquisites = tPerquisites;
	}

	public String gettSalaryComponentName() {
		return tSalaryComponentName;
	}

	public void settSalaryComponentName(String tSalaryComponentName) {
		this.tSalaryComponentName = tSalaryComponentName;
	}

	public String getEmployeeFname() {
		return employeeFname;
	}

	public void setEmployeeFname(String employeeFname) {
		this.employeeFname = employeeFname;
	}

	public String getEmployeeMname() {
		return employeeMname;
	}

	public void setEmployeeMname(String employeeMname) {
		this.employeeMname = employeeMname;
	}

	public String getEmployeeLname() {
		return employeeLname;
	}

	public void setEmployeeLname(String employeeLname) {
		this.employeeLname = employeeLname;
	}

	public String getEmployeeNationality() {
		return employeeNationality;
	}

	public void setEmployeeNationality(String employeeNationality) {
		this.employeeNationality = employeeNationality;
	}

	public String getEmployeeDob() {
		return employeeDob;
	}

	public void setEmployeeDob(String employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeeImage() {
		return employeeImage;
	}

	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeMarital() {
		return employeeMarital;
	}

	public void setEmployeeMarital(String employeeMarital) {
		this.employeeMarital = employeeMarital;
	}

	public String getEmployeeEsicNo() {
		return employeeEsicNo;
	}

	public void setEmployeeEsicNo(String employeeEsicNo) {
		this.employeeEsicNo = employeeEsicNo;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeAdhar() {
		return employeeAdhar;
	}

	public void setEmployeeAdhar(String employeeAdhar) {
		this.employeeAdhar = employeeAdhar;
	}

	public String getEmployeeOtherId() {
		return employeeOtherId;
	}

	public void setEmployeeOtherId(String employeeOtherId) {
		this.employeeOtherId = employeeOtherId;
	}

	public String getEmployeeDl() {
		return employeeDl;
	}

	public void setEmployeeDl(String employeeDl) {
		this.employeeDl = employeeDl;
	}

	public String getEmployeeEmployment() {
		return employeeEmployment;
	}

	public void setEmployeeEmployment(String employeeEmployment) {
		this.employeeEmployment = employeeEmployment;
	}

	public String getEmployeeJobTitle() {
		return employeeJobTitle;
	}

	public void setEmployeeJobTitle(String employeeJobTitle) {
		this.employeeJobTitle = employeeJobTitle;
	}

	public String getEmployeePayGrade() {
		return employeePayGrade;
	}

	public void setEmployeePayGrade(String employeePayGrade) {
		this.employeePayGrade = employeePayGrade;
	}

	public String getEmployeeWorkStationId() {
		return employeeWorkStationId;
	}

	public void setEmployeeWorkStationId(String employeeWorkStationId) {
		this.employeeWorkStationId = employeeWorkStationId;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}

	public String getEmployeeCountry() {
		return employeeCountry;
	}

	public void setEmployeeCountry(String employeeCountry) {
		this.employeeCountry = employeeCountry;
	}

	public String getEmployeePin() {
		return employeePin;
	}

	public void setEmployeePin(String employeePin) {
		this.employeePin = employeePin;
	}

	public String getEmployeeHomePhoneNo() {
		return employeeHomePhoneNo;
	}

	public void setEmployeeHomePhoneNo(String employeeHomePhoneNo) {
		this.employeeHomePhoneNo = employeeHomePhoneNo;
	}

	public String getEmployeeMobilePhoneNo() {
		return employeeMobilePhoneNo;
	}

	public void setEmployeeMobilePhoneNo(String employeeMobilePhoneNo) {
		this.employeeMobilePhoneNo = employeeMobilePhoneNo;
	}

	public String getEmployeeWorkPhoneNo() {
		return employeeWorkPhoneNo;
	}

	public void setEmployeeWorkPhoneNo(String employeeWorkPhoneNo) {
		this.employeeWorkPhoneNo = employeeWorkPhoneNo;
	}

	public String getEmployeeWorkEmail() {
		return employeeWorkEmail;
	}

	public void setEmployeeWorkEmail(String employeeWorkEmail) {
		this.employeeWorkEmail = employeeWorkEmail;
	}

	public String getEmployeePersonalEmail() {
		return employeePersonalEmail;
	}

	public void setEmployeePersonalEmail(String employeePersonalEmail) {
		this.employeePersonalEmail = employeePersonalEmail;
	}

	public String getEmployeeJoinDate() {
		return employeeJoinDate;
	}

	public void setEmployeeJoinDate(String employeeJoinDate) {
		this.employeeJoinDate = employeeJoinDate;
	}

	public String getEmployeeConfirmDate() {
		return employeeConfirmDate;
	}

	public void setEmployeeConfirmDate(String employeeConfirmDate) {
		this.employeeConfirmDate = employeeConfirmDate;
	}

	public String getEmployeeTerminateDate() {
		return employeeTerminateDate;
	}

	public void setEmployeeTerminateDate(String employeeTerminateDate) {
		this.employeeTerminateDate = employeeTerminateDate;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
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
