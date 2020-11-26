package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestOfferLetterDetailModel {
	private String tOfferLetterId;
	private String tEmpFName;
	private String tEmpMName;
	private String tEmpLName;
	private String tEmpDOB;
	private String tNationality;
	private String tMobileNo;
	private String tEmpImage;
	private String tEmpGender;
	private String tEmpMarritalStatus;
	private String tJobTitle;
	private String tPayGrade;
	private String tCountry;
	private String tState;
	private String tDistrict;
	private String tPinCode;
	private String tAddress;
	private String tEmailId;
	private String tEmpDOJ;
	private Double tAnnualCTC;
	private String tComponentId;
	private Double tAnnualAmount;
	private String salaryComponent;
	private Integer calculationType;
	private Double monthlyAmnt;
	private Double annualAmnt;
	private Double variableAmnt;
	private String tCompanyId;
	private String tCreatedBy;
	private Integer calculationTypeId;
	private String reqisitionId;
	private Integer candidateId;
	private List<HrmsEmployeeSalaryStructureModel> salaryComponentList = new ArrayList<HrmsEmployeeSalaryStructureModel>();

	public String getReqisitionId() {
		return reqisitionId;
	}

	public void setReqisitionId(String reqisitionId) {
		this.reqisitionId = reqisitionId;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public RestOfferLetterDetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public RestOfferLetterDetailModel(Object tOfferLetterId, Object tEmpFName, Object tEmpMName, Object tEmpLName,
			Object tEmpDOB, Object tNationality, Object tMobileNo, Object tEmpImage, Object tEmpGender,
			Object tEmpMarritalStatus, Object tJobTitle, Object tPayGrade, Object tCountry, Object tState,
			Object tDistrict, Object tPinCode, Object tAddress, Object tEmailId, Object tEmpDOJ, Object tAnnualCTC,
			Object tComponentId, Object tAnnualAmount, Object salaryComponent, Object calculationType,
			Object monthlyAmnt, Object annualAmnt, Object variableAmnt, Object tCompanyId, Object tCreatedBy,
			Object calculationTypeId) {
		super();
		this.tOfferLetterId = (String) tOfferLetterId;
		this.tEmpFName = (String) tEmpFName;
		this.tEmpMName = (String) tEmpMName;
		this.tEmpLName = (String) tEmpLName;
		this.tEmpDOB = (String) tEmpDOB;
		this.tNationality = (String) tNationality;
		this.tMobileNo = (String) tMobileNo;
		this.tEmpImage = (String) tEmpImage;
		this.tEmpGender = (String) tEmpGender;
		this.tEmpMarritalStatus = (String) tEmpMarritalStatus;
		this.tJobTitle = (String) tJobTitle;
		this.tPayGrade = (String) tPayGrade;
		this.tCountry = (String) tCountry;
		this.tState = (String) tState;
		this.tDistrict = (String) tDistrict;
		this.tPinCode = (String) tPinCode;
		this.tAddress = (String) tAddress;
		this.tEmailId = (String) tEmailId;
		this.tEmpDOJ = (String) tEmpDOJ;
		this.tAnnualCTC = (Double) tAnnualCTC;
		this.tComponentId = (String) tComponentId;
		this.tAnnualAmount = (Double) tAnnualAmount;
		this.salaryComponent = (String) salaryComponent;
		this.calculationType = (Integer) calculationType;
		this.monthlyAmnt = (Double) monthlyAmnt;
		this.annualAmnt = (Double) annualAmnt;
		this.variableAmnt = (Double) variableAmnt;
		this.tCompanyId = (String) tCompanyId;
		this.tCreatedBy = (String) tCreatedBy;
		this.calculationTypeId = (Integer) calculationTypeId;
	}

	public Integer getCalculationTypeId() {
		return calculationTypeId;
	}

	public void setCalculationTypeId(Integer calculationTypeId) {
		this.calculationTypeId = calculationTypeId;
	}

	public String gettOfferLetterId() {
		return tOfferLetterId;
	}

	public void settOfferLetterId(String tOfferLetterId) {
		this.tOfferLetterId = tOfferLetterId;
	}

	public String gettEmpFName() {
		return tEmpFName;
	}

	public void settEmpFName(String tEmpFName) {
		this.tEmpFName = tEmpFName;
	}

	public String gettEmpMName() {
		return tEmpMName;
	}

	public void settEmpMName(String tEmpMName) {
		this.tEmpMName = tEmpMName;
	}

	public String gettEmpLName() {
		return tEmpLName;
	}

	public void settEmpLName(String tEmpLName) {
		this.tEmpLName = tEmpLName;
	}

	public String gettEmpDOB() {
		return tEmpDOB;
	}

	public void settEmpDOB(String tEmpDOB) {
		this.tEmpDOB = tEmpDOB;
	}

	public String gettNationality() {
		return tNationality;
	}

	public void settNationality(String tNationality) {
		this.tNationality = tNationality;
	}

	public String gettMobileNo() {
		return tMobileNo;
	}

	public void settMobileNo(String tMobileNo) {
		this.tMobileNo = tMobileNo;
	}

	public String gettEmpImage() {
		return tEmpImage;
	}

	public void settEmpImage(String tEmpImage) {
		this.tEmpImage = tEmpImage;
	}

	public String gettEmpGender() {
		return tEmpGender;
	}

	public void settEmpGender(String tEmpGender) {
		this.tEmpGender = tEmpGender;
	}

	public String gettEmpMarritalStatus() {
		return tEmpMarritalStatus;
	}

	public void settEmpMarritalStatus(String tEmpMarritalStatus) {
		this.tEmpMarritalStatus = tEmpMarritalStatus;
	}

	public String gettJobTitle() {
		return tJobTitle;
	}

	public void settJobTitle(String tJobTitle) {
		this.tJobTitle = tJobTitle;
	}

	public String gettPayGrade() {
		return tPayGrade;
	}

	public void settPayGrade(String tPayGrade) {
		this.tPayGrade = tPayGrade;
	}

	public String gettCountry() {
		return tCountry;
	}

	public void settCountry(String tCountry) {
		this.tCountry = tCountry;
	}

	public String gettState() {
		return tState;
	}

	public void settState(String tState) {
		this.tState = tState;
	}

	public String gettDistrict() {
		return tDistrict;
	}

	public void settDistrict(String tDistrict) {
		this.tDistrict = tDistrict;
	}

	public String gettPinCode() {
		return tPinCode;
	}

	public void settPinCode(String tPinCode) {
		this.tPinCode = tPinCode;
	}

	public String gettAddress() {
		return tAddress;
	}

	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}

	public String gettEmailId() {
		return tEmailId;
	}

	public void settEmailId(String tEmailId) {
		this.tEmailId = tEmailId;
	}

	public String gettEmpDOJ() {
		return tEmpDOJ;
	}

	public void settEmpDOJ(String tEmpDOJ) {
		this.tEmpDOJ = tEmpDOJ;
	}

	public Double gettAnnualCTC() {
		return tAnnualCTC;
	}

	public void settAnnualCTC(Double tAnnualCTC) {
		this.tAnnualCTC = tAnnualCTC;
	}

	public String gettComponentId() {
		return tComponentId;
	}

	public void settComponentId(String tComponentId) {
		this.tComponentId = tComponentId;
	}

	public Double gettAnnualAmount() {
		return tAnnualAmount;
	}

	public void settAnnualAmount(Double tAnnualAmount) {
		this.tAnnualAmount = tAnnualAmount;
	}

	public String getSalaryComponent() {
		return salaryComponent;
	}

	public void setSalaryComponent(String salaryComponent) {
		this.salaryComponent = salaryComponent;
	}

	public Integer getCalculationType() {
		return calculationType;
	}

	public void setCalculationType(Integer calculationType) {
		this.calculationType = calculationType;
	}

	public Double getMonthlyAmnt() {
		return monthlyAmnt;
	}

	public void setMonthlyAmnt(Double monthlyAmnt) {
		this.monthlyAmnt = monthlyAmnt;
	}

	public Double getAnnualAmnt() {
		return annualAmnt;
	}

	public void setAnnualAmnt(Double annualAmnt) {
		this.annualAmnt = annualAmnt;
	}

	public Double getVariableAmnt() {
		return variableAmnt;
	}

	public void setVariableAmnt(Double variableAmnt) {
		this.variableAmnt = variableAmnt;
	}

	public String gettCompanyId() {
		return tCompanyId;
	}

	public void settCompanyId(String tCompanyId) {
		this.tCompanyId = tCompanyId;
	}

	public String gettCreatedBy() {
		return tCreatedBy;
	}

	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
	}

	public List<HrmsEmployeeSalaryStructureModel> getSalaryComponentList() {
		return salaryComponentList;
	}

	public void setSalaryComponentList(List<HrmsEmployeeSalaryStructureModel> salaryComponentList) {
		this.salaryComponentList = salaryComponentList;
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
