package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeModel {
	private String employeeNo;
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
	private String employeeSupervisor;
	private String employeeIndSupervisor;
	private String employeeFirstApp;
	private String employeeSecApp;
	private String employeeThirdApp;
	private String employeeNotes;
	private String createdBy;
	private String companyId;
	private String employeepPin;
	private Boolean status;
	private String empDesignation;
	private String empDesignationName;
	private String employeeState;
	private String employeeCountyName;
	private String employeeStateName;
	private String employeeGenderName;
	private String employeePaygradeName;
	private String employeeMaritalName;
	private String employeeBranch;

	private String bankName;
	private String bankIfscCode;
	private String bankAcNo;

	private Boolean haveEpfNo;
	private String epfNo;
	private Boolean haveEsicNo;
	private String esicNo;
	private Boolean haveGroupInsu;
	private String groupInsuFromDate;
	private String groupInsuToDate;
	private Boolean haveHealthInsu;
	private String healthInsuFromDate;
	private String healthInsuToDate;
	private String nomineeName;
	private String nomineeRel;
	private String bloodGroup;
	private Boolean foodAllowStatus;
	private String bioMetricId;

	private List<HrmsEmployeeSalaryStructureModel> salaryStructureList = new ArrayList<HrmsEmployeeSalaryStructureModel>();
	private List<HrmsEmployeeDocumentsModel> documentList = new ArrayList<HrmsEmployeeDocumentsModel>();

	private String employeeAddress1;
	private String employeeCity1;
	private String employeeCountry1;
	private String employeeState1;
	private String employeePin1;

	private Integer empleave;
	private Byte addStatus;

	private String userId;
	private String fatherFName;
	private String fathreMName;
	private String fatherLName;
	private String fatherDob;
	private String motherFName;
	private String motherMName;
	private String motherLName;
	private String motherDob;
	private String whatsappNo;

	private String distPresentId;
	private String distPresentName;

	private String distPermanentId;
	private String distPermanentName;

	private List<HrmsEmployeeGroupInsuranceModel> groupInsurance = new ArrayList<HrmsEmployeeGroupInsuranceModel>();

	public HrmsEmployeeModel() {
		super();
	}

	public HrmsEmployeeModel(Object employeeNo, Object employeeFname, Object employeeMname, Object employeeLname,
			Object employeeNationality, Object employeeDob, Object employeeImage, Object employeeGender,
			Object employeeMarital, Object employeeEsicNo, Object employeePassword, Object employeeAdhar,
			Object employeeOtherId, Object employeeDl, Object employeeEmployment, Object employeeJobTitle,
			Object employeePayGrade, Object employeeWorkStationId, Object employeeAddress, Object employeeCity,
			Object employeeCountry, Object employeePin, Object employeeHomePhoneNo, Object employeeMobilePhoneNo,
			Object employeeWorkPhoneNo, Object employeeWorkEmail, Object employeePersonalEmail, Object employeeJoinDate,
			Object employeeConfirmDate, Object employeeTerminateDate, Object employeeDepartment,
			Object employeeSupervisor, Object employeeIndSupervisor, Object employeeFirstApp, Object employeeSecApp,
			Object employeeThirdApp, Object employeeNotes, Object employeepPin, Object status, Object empDesignation,
			Object empDesignationName, Object employeeState, Object employeeCountyName, Object employeeStateName,
			Object employeeGenderName, Object employeePaygradeName, Object employeeMaritalName, Object employeeBranch,
			Object bankName, Object bankIfscCode, Object bankAcNo, Object haveEpfNo, Object epfNo, Object haveEsicNo,
			Object esicNo, Object haveGroupInsu, Object groupInsuFromDate, Object groupInsuToDate,
			Object haveHealthInsu, Object healthInsuFromDate, Object healthInsuToDate, Object nomineeName,
			Object nomineeRel, Object bloodGroup, Object foodAllowStatus, Object bioMetricId, Object employeeAddress1,
			Object employeeCity1, Object employeeCountry1, Object employeeState1, Object employeePin1, Object empleave,
			Object addStatus, Object userId, Object fatherFName, Object fatherLName, Object fatherDob,
			Object motherFName, Object motherLName, Object motherDob, Object whatsappNo, Object distPresentId,
			Object distPresentName ,Object distPermanentId ,Object distPermanentName) {
		super();

		try {
			this.employeeNo = (String) employeeNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeFname = (String) employeeFname;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeMname = (String) employeeMname;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeLname = (String) employeeLname;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeNationality = (String) employeeNationality;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeDob = (String) employeeDob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeImage = (String) employeeImage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeGender = (String) employeeGender;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeMarital = (String) employeeMarital;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeEsicNo = (String) employeeEsicNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeePassword = (String) employeePassword;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeAdhar = (String) employeeAdhar;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeOtherId = (String) employeeOtherId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeDl = (String) employeeDl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeEmployment = (String) employeeEmployment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeJobTitle = (String) employeeJobTitle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeePayGrade = (String) employeePayGrade;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeWorkStationId = (String) employeeWorkStationId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeAddress = (String) employeeAddress;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeCity = (String) employeeCity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeCountry = (String) employeeCountry;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeePin = (String) employeePin;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeHomePhoneNo = (String) employeeHomePhoneNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeMobilePhoneNo = (String) employeeMobilePhoneNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeWorkPhoneNo = (String) employeeWorkPhoneNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeWorkEmail = (String) employeeWorkEmail;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeePersonalEmail = (String) employeePersonalEmail;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeJoinDate = (String) employeeJoinDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeConfirmDate = (String) employeeConfirmDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeTerminateDate = (String) employeeTerminateDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeDepartment = (String) employeeDepartment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeSupervisor = (String) employeeSupervisor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeIndSupervisor = (String) employeeIndSupervisor;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeFirstApp = (String) employeeFirstApp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeSecApp = (String) employeeSecApp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeThirdApp = (String) employeeThirdApp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeNotes = (String) employeeNotes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeepPin = (String) employeepPin;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.status = (Boolean) status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empDesignation = (String) empDesignation;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeState = (String) employeeState;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeeCountyName = (String) employeeCountyName;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeeStateName = (String) employeeStateName;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeeGenderName = (String) employeeGenderName;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeePaygradeName = (String) employeePaygradeName;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeeMaritalName = (String) employeeMaritalName;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeeBranch = (String) employeeBranch;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.bankName = (String) bankName;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			this.bankIfscCode = (String) bankIfscCode;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.bankAcNo = (String) bankAcNo;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.haveEpfNo = (Boolean) haveEpfNo;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.epfNo = (String) epfNo;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.haveEsicNo = (Boolean) haveEsicNo;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.esicNo = (String) esicNo;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.haveGroupInsu = (Boolean) haveGroupInsu;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.groupInsuFromDate = (String) groupInsuFromDate;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.groupInsuToDate = (String) groupInsuToDate;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.haveHealthInsu = (Boolean) haveHealthInsu;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.healthInsuFromDate = (String) healthInsuFromDate;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.healthInsuToDate = (String) healthInsuToDate;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.nomineeName = (String) nomineeName;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.nomineeRel = (String) nomineeRel;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.bloodGroup = (String) bloodGroup;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.foodAllowStatus = (Boolean) foodAllowStatus;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.bioMetricId = (String) bioMetricId;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			this.employeeAddress1 = (String) employeeAddress1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeeCity1 = (String) employeeCity1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeeCountry1 = (String) employeeCountry1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeeState1 = (String) employeeState1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.employeePin1 = (String) employeePin1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			this.empleave = (Integer) empleave;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			this.addStatus = (Byte) addStatus;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		this.userId = (String) userId;
		this.fatherFName = (String) fatherFName;
		this.fatherLName = (String)fatherLName;
		this.fatherDob = (String)fatherDob;
		this.motherFName = (String)motherFName;
		this.motherLName = (String)motherLName;
		this.motherDob = (String)motherDob;
		this.whatsappNo = (String)whatsappNo;
		this.distPresentId = (String)distPresentId;
		this.distPresentName = (String)distPresentName;
		this.distPermanentId = (String)distPermanentId;
		this.distPermanentName = (String)distPermanentName;

	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
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

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeEsicNo() {
		return employeeEsicNo;
	}

	public void setEmployeeEsicNo(String employeeEsicNo) {
		this.employeeEsicNo = employeeEsicNo;
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

	public String getEmployeeSupervisor() {
		return employeeSupervisor;
	}

	public void setEmployeeSupervisor(String employeeSupervisor) {
		this.employeeSupervisor = employeeSupervisor;
	}

	public String getEmployeeIndSupervisor() {
		return employeeIndSupervisor;
	}

	public void setEmployeeIndSupervisor(String employeeIndSupervisor) {
		this.employeeIndSupervisor = employeeIndSupervisor;
	}

	public String getEmployeeFirstApp() {
		return employeeFirstApp;
	}

	public void setEmployeeFirstApp(String employeeFirstApp) {
		this.employeeFirstApp = employeeFirstApp;
	}

	public String getEmployeeSecApp() {
		return employeeSecApp;
	}

	public void setEmployeeSecApp(String employeeSecApp) {
		this.employeeSecApp = employeeSecApp;
	}

	public String getEmployeeThirdApp() {
		return employeeThirdApp;
	}

	public void setEmployeeThirdApp(String employeeThirdApp) {
		this.employeeThirdApp = employeeThirdApp;
	}

	public String getEmployeeNotes() {
		return employeeNotes;
	}

	public void setEmployeeNotes(String employeeNotes) {
		this.employeeNotes = employeeNotes;
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

	public String getEmployeepPin() {
		return employeepPin;
	}

	public void setEmployeepPin(String employeepPin) {
		this.employeepPin = employeepPin;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpDesignationName() {
		return empDesignationName;
	}

	public void setEmpDesignationName(String empDesignationName) {
		this.empDesignationName = empDesignationName;
	}

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}

	public String getEmployeeCountyName() {
		return employeeCountyName;
	}

	public void setEmployeeCountyName(String employeeCountyName) {
		this.employeeCountyName = employeeCountyName;
	}

	public String getEmployeeStateName() {
		return employeeStateName;
	}

	public void setEmployeeStateName(String employeeStateName) {
		this.employeeStateName = employeeStateName;
	}

	public String getEmployeeGenderName() {
		return employeeGenderName;
	}

	public void setEmployeeGenderName(String employeeGenderName) {
		this.employeeGenderName = employeeGenderName;
	}

	public String getEmployeePaygradeName() {
		return employeePaygradeName;
	}

	public void setEmployeePaygradeName(String employeePaygradeName) {
		this.employeePaygradeName = employeePaygradeName;
	}

	public String getEmployeeMaritalName() {
		return employeeMaritalName;
	}

	public void setEmployeeMaritalName(String employeeMaritalName) {
		this.employeeMaritalName = employeeMaritalName;
	}

	public String getEmployeeBranch() {
		return employeeBranch;
	}

	public void setEmployeeBranch(String employeeBranch) {
		this.employeeBranch = employeeBranch;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankIfscCode() {
		return bankIfscCode;
	}

	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	public String getBankAcNo() {
		return bankAcNo;
	}

	public void setBankAcNo(String bankAcNo) {
		this.bankAcNo = bankAcNo;
	}

	public Boolean getHaveEpfNo() {
		return haveEpfNo;
	}

	public void setHaveEpfNo(Boolean haveEpfNo) {
		this.haveEpfNo = haveEpfNo;
	}

	public String getEpfNo() {
		return epfNo;
	}

	public void setEpfNo(String epfNo) {
		this.epfNo = epfNo;
	}

	public Boolean getHaveEsicNo() {
		return haveEsicNo;
	}

	public void setHaveEsicNo(Boolean haveEsicNo) {
		this.haveEsicNo = haveEsicNo;
	}

	public String getEsicNo() {
		return esicNo;
	}

	public void setEsicNo(String esicNo) {
		this.esicNo = esicNo;
	}

	public List<HrmsEmployeeSalaryStructureModel> getSalaryStructureList() {
		return salaryStructureList;
	}

	public void setSalaryStructureList(List<HrmsEmployeeSalaryStructureModel> salaryStructureList) {
		this.salaryStructureList = salaryStructureList;
	}

	public List<HrmsEmployeeDocumentsModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<HrmsEmployeeDocumentsModel> documentList) {
		this.documentList = documentList;
	}

	public Boolean getHaveGroupInsu() {
		return haveGroupInsu;
	}

	public void setHaveGroupInsu(Boolean haveGroupInsu) {
		this.haveGroupInsu = haveGroupInsu;
	}

	public String getGroupInsuFromDate() {
		return groupInsuFromDate;
	}

	public void setGroupInsuFromDate(String groupInsuFromDate) {
		this.groupInsuFromDate = groupInsuFromDate;
	}

	public String getGroupInsuToDate() {
		return groupInsuToDate;
	}

	public void setGroupInsuToDate(String groupInsuToDate) {
		this.groupInsuToDate = groupInsuToDate;
	}

	public Boolean getHaveHealthInsu() {
		return haveHealthInsu;
	}

	public void setHaveHealthInsu(Boolean haveHealthInsu) {
		this.haveHealthInsu = haveHealthInsu;
	}

	public String getHealthInsuFromDate() {
		return healthInsuFromDate;
	}

	public void setHealthInsuFromDate(String healthInsuFromDate) {
		this.healthInsuFromDate = healthInsuFromDate;
	}

	public String getHealthInsuToDate() {
		return healthInsuToDate;
	}

	public void setHealthInsuToDate(String healthInsuToDate) {
		this.healthInsuToDate = healthInsuToDate;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getNomineeRel() {
		return nomineeRel;
	}

	public void setNomineeRel(String nomineeRel) {
		this.nomineeRel = nomineeRel;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Boolean getFoodAllowStatus() {
		return foodAllowStatus;
	}

	public void setFoodAllowStatus(Boolean foodAllowStatus) {
		this.foodAllowStatus = foodAllowStatus;
	}

	public String getBioMetricId() {
		return bioMetricId;
	}

	public void setBioMetricId(String bioMetricId) {
		this.bioMetricId = bioMetricId;
	}

	public String getEmployeeAddress1() {
		return employeeAddress1;
	}

	public void setEmployeeAddress1(String employeeAddress1) {
		this.employeeAddress1 = employeeAddress1;
	}

	public String getEmployeeCity1() {
		return employeeCity1;
	}

	public void setEmployeeCity1(String employeeCity1) {
		this.employeeCity1 = employeeCity1;
	}

	public String getEmployeeCountry1() {
		return employeeCountry1;
	}

	public void setEmployeeCountry1(String employeeCountry1) {
		this.employeeCountry1 = employeeCountry1;
	}

	public String getEmployeeState1() {
		return employeeState1;
	}

	public void setEmployeeState1(String employeeState1) {
		this.employeeState1 = employeeState1;
	}

	public String getEmployeePin1() {
		return employeePin1;
	}

	public void setEmployeePin1(String employeePin1) {
		this.employeePin1 = employeePin1;
	}

	public Integer getEmpleave() {
		return empleave;
	}

	public void setEmpleave(Integer empleave) {
		this.empleave = empleave;
	}

	public Byte getAddStatus() {
		return addStatus;
	}

	public void setAddStatus(Byte addStatus) {
		this.addStatus = addStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFatherFName() {
		return fatherFName;
	}

	public void setFatherFName(String fatherFName) {
		this.fatherFName = fatherFName;
	}

	public String getFathreMName() {
		return fathreMName;
	}

	public void setFathreMName(String fathreMName) {
		this.fathreMName = fathreMName;
	}

	public String getFatherLName() {
		return fatherLName;
	}

	public void setFatherLName(String fatherLName) {
		this.fatherLName = fatherLName;
	}

	public String getFatherDob() {
		return fatherDob;
	}

	public void setFatherDob(String fatherDob) {
		this.fatherDob = fatherDob;
	}

	public String getMotherFName() {
		return motherFName;
	}

	public void setMotherFName(String motherFName) {
		this.motherFName = motherFName;
	}

	public String getMotherMName() {
		return motherMName;
	}

	public void setMotherMName(String motherMName) {
		this.motherMName = motherMName;
	}

	public String getMotherLName() {
		return motherLName;
	}

	public void setMotherLName(String motherLName) {
		this.motherLName = motherLName;
	}

	public String getMotherDob() {
		return motherDob;
	}

	public void setMotherDob(String motherDob) {
		this.motherDob = motherDob;
	}

	public String getWhatsappNo() {
		return whatsappNo;
	}

	public void setWhatsappNo(String whatsappNo) {
		this.whatsappNo = whatsappNo;
	}

	public String getDistPresentId() {
		return distPresentId;
	}

	public void setDistPresentId(String distPresentId) {
		this.distPresentId = distPresentId;
	}

	public String getDistPresentName() {
		return distPresentName;
	}

	public void setDistPresentName(String distPresentName) {
		this.distPresentName = distPresentName;
	}

	public String getDistPermanentId() {
		return distPermanentId;
	}

	public void setDistPermanentId(String distPermanentId) {
		this.distPermanentId = distPermanentId;
	}

	public String getDistPermanentName() {
		return distPermanentName;
	}

	public void setDistPermanentName(String distPermanentName) {
		this.distPermanentName = distPermanentName;
	}

	public List<HrmsEmployeeGroupInsuranceModel> getGroupInsurance() {
		return groupInsurance;
	}

	public void setGroupInsurance(List<HrmsEmployeeGroupInsuranceModel> groupInsurance) {
		this.groupInsurance = groupInsurance;
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
