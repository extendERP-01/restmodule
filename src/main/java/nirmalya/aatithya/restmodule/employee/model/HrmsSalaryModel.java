package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsSalaryModel {

	private String salId;
	private String employeeId;
	private String employeeName;
	private String fromDate;
	private String toDate;
	private BigInteger totalDays;
	private Double workingDays;
	private Double empWorkDays;
	private Double leavDays;
	private Double extraWorkDays;
	private Double paidDays;
	private Double basic;
	private Double hra;
	private Double other;
	private Double totalTrip;
	private Double totalTripAmount;
	private Double foodConsumed;
	private Double foodAvail;
	private Double foodAllowAmount;
	private Double foodAmount;
	private Double totalGrossSalary;
	private Double empEpf;
	private Double employerEpf;
	private Double empEsic;
	private Double employerEsic;
	private Double incomeTax;
	private Double netSalary;
	private Double extraSalary;
	private Double monthlyGross;
	private Double advanceAmount;

	public HrmsSalaryModel() {
		super();
	}

	public HrmsSalaryModel(Object salId, Object employeeId, Object employeeName, Object fromDate, Object toDate,
			Object totalDays, Object workingDays, Object empWorkDays, Object leavDays, Object extraWorkDays,
			Object paidDays, Object basic, Object hra, Object other, Object totalTrip, Object totalTripAmount,
			Object foodConsumed, Object foodAvail, Object foodAllowAmount, Object foodAmount, Object monthlyGross,
			Object extraSalary, Object empEpf, Object employerEpf, Object empEsic, Object employerEsic,
			Object incomeTax, Object netSalary, Object advanceAmount) {
		super();
		this.salId = (String) salId;
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.totalDays = (BigInteger) totalDays;
		this.workingDays = (Double) workingDays;
		this.empWorkDays = (Double) empWorkDays;
		this.leavDays = (Double) leavDays;
		this.extraWorkDays = (Double) extraWorkDays;
		this.paidDays = (Double) paidDays;
		this.basic = (Double) basic;
		this.hra = (Double) hra;
		this.other = (Double) other;
		this.totalTrip = (Double) totalTrip;
		this.totalTripAmount = (Double) totalTripAmount;
		this.foodConsumed = (Double) foodConsumed;
		this.foodAvail = (Double) foodAvail;
		this.foodAllowAmount = (Double) foodAllowAmount;
		this.foodAmount = (Double) foodAmount;
		this.monthlyGross = (Double) monthlyGross;
		this.extraSalary = (Double) extraSalary;
		this.empEpf = (Double) empEpf;
		this.employerEpf = (Double) employerEpf;
		this.empEsic = (Double) empEsic;
		this.employerEsic = (Double) employerEsic;
		this.incomeTax = (Double) incomeTax;
		this.netSalary = (Double) netSalary;
		this.advanceAmount = (Double) advanceAmount;
	}

	public HrmsSalaryModel(Object salId, Object employeeId, Object employeeName, Object fromDate, Object toDate,
			Object totalDays, Object workingDays, Object empWorkDays, Object leavDays, Object extraWorkDays,
			Object paidDays, Object basic, Object hra, Object other, Object totalTrip, Object totalTripAmount,
			Object foodConsumed, Object foodAvail, Object foodAllowAmount, Object foodAmount, Object totalGrossSalary,
			Object empEpf, Object employerEpf, Object empEsic, Object employerEsic, Object incomeTax, Object netSalary,
			Object advanceAmount) {
		super();
		this.salId = (String) salId;
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.totalDays = (BigInteger) totalDays;
		this.workingDays = (Double) workingDays;
		this.empWorkDays = (Double) empWorkDays;
		this.leavDays = (Double) leavDays;
		this.extraWorkDays = (Double) extraWorkDays;
		this.paidDays = (Double) paidDays;
		this.basic = (Double) basic;
		this.hra = (Double) hra;
		this.other = (Double) other;
		this.totalTrip = (Double) totalTrip;
		this.totalTripAmount = (Double) totalTripAmount;
		this.foodConsumed = (Double) foodConsumed;
		this.foodAvail = (Double) foodAvail;
		this.foodAllowAmount = (Double) foodAllowAmount;
		this.foodAmount = (Double) foodAmount;
		this.totalGrossSalary = (Double) totalGrossSalary;
		this.empEpf = (Double) empEpf;
		this.employerEpf = (Double) employerEpf;
		this.empEsic = (Double) empEsic;
		this.employerEsic = (Double) employerEsic;
		this.incomeTax = (Double) incomeTax;
		this.netSalary = (Double) netSalary;
		this.advanceAmount = (Double) advanceAmount;
	}

	public String getSalId() {
		return salId;
	}

	public void setSalId(String salId) {
		this.salId = salId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public BigInteger getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(BigInteger totalDays) {
		this.totalDays = totalDays;
	}

	public Double getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(Double workingDays) {
		this.workingDays = workingDays;
	}

	public Double getEmpWorkDays() {
		return empWorkDays;
	}

	public void setEmpWorkDays(Double empWorkDays) {
		this.empWorkDays = empWorkDays;
	}

	public Double getLeavDays() {
		return leavDays;
	}

	public void setLeavDays(Double leavDays) {
		this.leavDays = leavDays;
	}

	public Double getExtraWorkDays() {
		return extraWorkDays;
	}

	public void setExtraWorkDays(Double extraWorkDays) {
		this.extraWorkDays = extraWorkDays;
	}

	public Double getPaidDays() {
		return paidDays;
	}

	public void setPaidDays(Double paidDays) {
		this.paidDays = paidDays;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public Double getHra() {
		return hra;
	}

	public void setHra(Double hra) {
		this.hra = hra;
	}

	public Double getOther() {
		return other;
	}

	public void setOther(Double other) {
		this.other = other;
	}

	public Double getTotalTrip() {
		return totalTrip;
	}

	public void setTotalTrip(Double totalTrip) {
		this.totalTrip = totalTrip;
	}

	public Double getTotalTripAmount() {
		return totalTripAmount;
	}

	public void setTotalTripAmount(Double totalTripAmount) {
		this.totalTripAmount = totalTripAmount;
	}

	public Double getFoodConsumed() {
		return foodConsumed;
	}

	public void setFoodConsumed(Double foodConsumed) {
		this.foodConsumed = foodConsumed;
	}

	public Double getFoodAvail() {
		return foodAvail;
	}

	public void setFoodAvail(Double foodAvail) {
		this.foodAvail = foodAvail;
	}

	public Double getFoodAllowAmount() {
		return foodAllowAmount;
	}

	public void setFoodAllowAmount(Double foodAllowAmount) {
		this.foodAllowAmount = foodAllowAmount;
	}

	public Double getFoodAmount() {
		return foodAmount;
	}

	public void setFoodAmount(Double foodAmount) {
		this.foodAmount = foodAmount;
	}

	public Double getTotalGrossSalary() {
		return totalGrossSalary;
	}

	public void setTotalGrossSalary(Double totalGrossSalary) {
		this.totalGrossSalary = totalGrossSalary;
	}

	public Double getEmpEpf() {
		return empEpf;
	}

	public void setEmpEpf(Double empEpf) {
		this.empEpf = empEpf;
	}

	public Double getEmployerEpf() {
		return employerEpf;
	}

	public void setEmployerEpf(Double employerEpf) {
		this.employerEpf = employerEpf;
	}

	public Double getEmpEsic() {
		return empEsic;
	}

	public void setEmpEsic(Double empEsic) {
		this.empEsic = empEsic;
	}

	public Double getEmployerEsic() {
		return employerEsic;
	}

	public void setEmployerEsic(Double employerEsic) {
		this.employerEsic = employerEsic;
	}

	public Double getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(Double incomeTax) {
		this.incomeTax = incomeTax;
	}

	public Double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}

	public Double getExtraSalary() {
		return extraSalary;
	}

	public void setExtraSalary(Double extraSalary) {
		this.extraSalary = extraSalary;
	}

	public Double getMonthlyGross() {
		return monthlyGross;
	}

	public void setMonthlyGross(Double monthlyGross) {
		this.monthlyGross = monthlyGross;
	}

	public Double getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(Double advanceAmount) {
		this.advanceAmount = advanceAmount;
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
