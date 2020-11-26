package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExitFinancialSettelmentModel {
	private String financeId;
	private String employeeId;
	private String empName;
	private String empDepartment;
	private String manager;
	private Double salary;
	private String noticePeriod;
	private Double bonus;
	private Double other;
	private String comment;
	private Double recovery;
	private String createdBy;
	private String action;
	private String empDepartmentName;
	public ExitFinancialSettelmentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExitFinancialSettelmentModel(Object financeId, Object employeeId, Object empName, Object empDepartment, Object manager,
			Object salary, Object noticePeriod, Object bonus,Object other,Object comment,Object recovery,Object empDepartmentName) {
		super();
		try {
			this.financeId = (String) financeId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.employeeId = (String) employeeId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empName = (String) empName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empDepartment = (String) empDepartment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.manager = (String) manager;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.salary = (Double) salary;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.noticePeriod = (String) noticePeriod;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.bonus = (Double) bonus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.other = (Double) other;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.comment = (String) comment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {	
			this.recovery = (Double) recovery;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {	
			this.empDepartmentName = (String) empDepartmentName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public String getFinanceId() {
		return financeId;
	}
	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	public Double getOther() {
		return other;
	}
	public void setOther(Double other) {
		this.other = other;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public Double getRecovery() {
		return recovery;
	}
	public void setRecovery(Double recovery) {
		this.recovery = recovery;
	}
	
	public String getEmpDepartmentName() {
		return empDepartmentName;
	}
	public void setEmpDepartmentName(String empDepartmentName) {
		this.empDepartmentName = empDepartmentName;
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
