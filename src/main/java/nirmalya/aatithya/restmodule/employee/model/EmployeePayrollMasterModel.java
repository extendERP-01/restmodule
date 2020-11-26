package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
 

public class EmployeePayrollMasterModel {

	private String tId;
	private String tEmployeeId;
	private String tEmployeeName;
	private Double tNetSalary;
	private String tPayDate;
	private String tPayGrade;
	private BigDecimal tLeaveDays;
	private Double tBasicPay;
	private Double tDearnessAllowance;
	private Double tHouseRentAllowance;
	private Double tConveyanceAllowance;
	private Double tLeaveTravelAllowance;
	private Double tMedicalAllowance;
	private Double tEmployeeProvidentFund;
	private Double tESICscheme;
	private Double tEarnings;
	private Double tDeductions;
	private Boolean tStatus;
	private String tCreatedBy;
	private Integer approvalStatus;
	private Integer lastDay;
	private Double tCTC;
	private String tCity;
	private String tMobile;
	private String tEmailId;
	private BigDecimal tTaxableAmnt;
	private Double tPerquisites;
	private Integer currentStageNo;
	private Integer approverStageNo;
	private Integer currentLevelNo;
	private Integer approverLevelNo;
	private Byte approveStatus;
	private String approveStatusName;
	private Double paidLeave;
	private Double leaveWithOutPay;
	private BigInteger totalAttendance;
	private String paymentDate;
	private Double totalPaymentAmount;
	private String monthName;
	List<HrmsEmployeeSalaryComponentsModel> salaryComponentsDetails = new ArrayList<HrmsEmployeeSalaryComponentsModel>();
	
	public EmployeePayrollMasterModel() {
		super();
	}

	public EmployeePayrollMasterModel(Object tId, Object paymentDate, Object totalPaymentAmount, Object tStatus,
			Object monthName,Object currentStageNo, Object approverStageNo, Object currentLevelNo, Object approverLevelNo,
			Object approveStatus) {
		this.tId = (String) tId;
		this.paymentDate = (String) paymentDate;
		this.totalPaymentAmount = (Double) totalPaymentAmount;
		this.tStatus = (Boolean) tStatus;
		this.monthName = (String) monthName;
		this.currentStageNo = (Integer) currentStageNo;
		this.currentLevelNo = (Integer) currentLevelNo;
		this.approverStageNo = (Integer) approverStageNo;
		this.approverLevelNo = (Integer) approverLevelNo;
		this.approveStatus = (Byte) approveStatus;
	}

	public EmployeePayrollMasterModel(Object tId, Object tEmployeeId, Object tEmployeeName, Object tNetSalary,
			Object tPayDate, Object tPayGrade, Object tLeaveDays, Object tBasicPay, Object tDearnessAllowance,
			Object tHouseRentAllowance, Object tConveyanceAllowance, Object tLeaveTravelAllowance,
			Object tMedicalAllowance, Object tEmployeeProvidentFund, Object tESICscheme, Object tEarnings,
			Object tDeductions, Object tStatus, Object tCreatedBy, Object approvalStatus, Object lastDay, Object tCTC,
			Object tCity, Object tMobile, Object tEmailId, Object tTaxableAmnt, Object tPerquisites,
			Object currentStageNo, Object approverStageNo, Object currentLevelNo, Object approverLevelNo,
			Object approveStatus, Object approveStatusName, Object paidLeave, Object leaveWithOutPay,
			Object totalAttendance) {
		super();
		this.tId = (String) tId;
		this.tEmployeeId = (String) tEmployeeId;
		this.tEmployeeName = (String) tEmployeeName;
		this.tNetSalary = (Double) tNetSalary;
		this.tPayDate = (String) tPayDate;
		this.tPayGrade = (String) tPayGrade;
		this.tLeaveDays = (BigDecimal) tLeaveDays;
		this.tBasicPay = (Double) tBasicPay;
		this.tDearnessAllowance = (Double) tDearnessAllowance;
		this.tHouseRentAllowance = (Double) tHouseRentAllowance;
		this.tConveyanceAllowance = (Double) tConveyanceAllowance;
		this.tLeaveTravelAllowance = (Double) tLeaveTravelAllowance;
		this.tMedicalAllowance = (Double) tMedicalAllowance;
		this.tEmployeeProvidentFund = (Double) tEmployeeProvidentFund;
		this.tESICscheme = (Double) tESICscheme;
		this.tEarnings = (Double) tEarnings;
		this.tDeductions = (Double) tDeductions;
		this.tStatus = (Boolean) tStatus;
		this.tCreatedBy = (String) tCreatedBy;
		this.approvalStatus = (Integer) approvalStatus;
		this.lastDay = (Integer) lastDay;
		this.tCTC = (Double) tCTC;
		this.tCity = (String) tCity;
		this.tMobile = (String) tMobile;
		this.tEmailId = (String) tEmailId;
		this.tTaxableAmnt = (BigDecimal) tTaxableAmnt;
		this.tPerquisites = (Double) tPerquisites;
		this.currentStageNo = (Integer) currentStageNo;
		this.currentLevelNo = (Integer) currentLevelNo;
		this.approverStageNo = (Integer) approverStageNo;
		this.approverLevelNo = (Integer) approverLevelNo;
		this.approveStatus = (Byte) approveStatus;
		this.approveStatusName = (String) approveStatusName;
		this.paidLeave = (Double) paidLeave;
		this.leaveWithOutPay = (Double) leaveWithOutPay;
		this.totalAttendance = (BigInteger) totalAttendance;
	}

	public Integer getCurrentStageNo() {
		return currentStageNo;
	}

	public void setCurrentStageNo(Integer currentStageNo) {
		this.currentStageNo = currentStageNo;
	}

	public Integer getApproverStageNo() {
		return approverStageNo;
	}

	public void setApproverStageNo(Integer approverStageNo) {
		this.approverStageNo = approverStageNo;
	}

	public Integer getCurrentLevelNo() {
		return currentLevelNo;
	}

	public void setCurrentLevelNo(Integer currentLevelNo) {
		this.currentLevelNo = currentLevelNo;
	}

	public Integer getApproverLevelNo() {
		return approverLevelNo;
	}

	public void setApproverLevelNo(Integer approverLevelNo) {
		this.approverLevelNo = approverLevelNo;
	}

	public Byte getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Byte approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveStatusName() {
		return approveStatusName;
	}

	public void setApproveStatusName(String approveStatusName) {
		this.approveStatusName = approveStatusName;
	}

	public Integer getLastDay() {
		return lastDay;
	}

	public void setLastDay(Integer lastDay) {
		this.lastDay = lastDay;
	}

	public Double gettPerquisites() {
		return tPerquisites;
	}

	public void settPerquisites(Double tPerquisites) {
		this.tPerquisites = tPerquisites;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String gettEmployeeId() {
		return tEmployeeId;
	}

	public void settEmployeeId(String tEmployeeId) {
		this.tEmployeeId = tEmployeeId;
	}

	public String gettEmployeeName() {
		return tEmployeeName;
	}

	public void settEmployeeName(String tEmployeeName) {
		this.tEmployeeName = tEmployeeName;
	}

	public Double gettNetSalary() {
		return tNetSalary;
	}

	public void settNetSalary(Double tNetSalary) {
		this.tNetSalary = tNetSalary;
	}

	public String gettPayDate() {
		return tPayDate;
	}

	public void settPayDate(String tPayDate) {
		this.tPayDate = tPayDate;
	}

	public String gettPayGrade() {
		return tPayGrade;
	}

	public void settPayGrade(String tPayGrade) {
		this.tPayGrade = tPayGrade;
	}

	public BigDecimal gettLeaveDays() {
		return tLeaveDays;
	}

	public void settLeaveDays(BigDecimal tLeaveDays) {
		this.tLeaveDays = tLeaveDays;
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

	public Double gettEarnings() {
		return tEarnings;
	}

	public void settEarnings(Double tEarnings) {
		this.tEarnings = tEarnings;
	}

	public Double gettDeductions() {
		return tDeductions;
	}

	public void settDeductions(Double tDeductions) {
		this.tDeductions = tDeductions;
	}

	public Boolean gettStatus() {
		return tStatus;
	}

	public void settStatus(Boolean tStatus) {
		this.tStatus = tStatus;
	}

	public String gettCreatedBy() {
		return tCreatedBy;
	}

	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
	}

	public Integer getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Double gettCTC() {
		return tCTC;
	}

	public void settCTC(Double tCTC) {
		this.tCTC = tCTC;
	}

	public String gettCity() {
		return tCity;
	}

	public void settCity(String tCity) {
		this.tCity = tCity;
	}

	public String gettMobile() {
		return tMobile;
	}

	public void settMobile(String tMobile) {
		this.tMobile = tMobile;
	}

	public String gettEmailId() {
		return tEmailId;
	}

	public void settEmailId(String tEmailId) {
		this.tEmailId = tEmailId;
	}

	public BigDecimal gettTaxableAmnt() {
		return tTaxableAmnt;
	}

	public void settTaxableAmnt(BigDecimal tTaxableAmnt) {
		this.tTaxableAmnt = tTaxableAmnt;
	}

	public Double getPaidLeave() {
		return paidLeave;
	}

	public void setPaidLeave(Double paidLeave) {
		this.paidLeave = paidLeave;
	}

	public Double getLeaveWithOutPay() {
		return leaveWithOutPay;
	}

	public void setLeaveWithOutPay(Double leaveWithOutPay) {
		this.leaveWithOutPay = leaveWithOutPay;
	}

	public BigInteger getTotalAttendance() {
		return totalAttendance;
	}

	public void setTotalAttendance(BigInteger totalAttendance) {
		this.totalAttendance = totalAttendance;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getTotalPaymentAmount() {
		return totalPaymentAmount;
	}

	public void setTotalPaymentAmount(Double totalPaymentAmount) {
		this.totalPaymentAmount = totalPaymentAmount;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public List<HrmsEmployeeSalaryComponentsModel> getSalaryComponentsDetails() {
		return salaryComponentsDetails;
	}

	public void setSalaryComponentsDetails(List<HrmsEmployeeSalaryComponentsModel> salaryComponentsDetails) {
		this.salaryComponentsDetails = salaryComponentsDetails;
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
