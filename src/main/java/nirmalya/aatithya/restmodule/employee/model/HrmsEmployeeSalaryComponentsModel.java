package nirmalya.aatithya.restmodule.employee.model;

public class HrmsEmployeeSalaryComponentsModel {

	private String salaryComponent;
	private String salaryComponentName;
	private Integer calculationtype;
	private String amount;
	private String gradeId;
	private String empId;
	
	public HrmsEmployeeSalaryComponentsModel() {
		super(); 
	}
	
	public HrmsEmployeeSalaryComponentsModel(Object salaryComponent, Object salaryComponentName,
			Object calculationtype, Object amount, Object gradeId ,Object empId) {
		super();
		this.salaryComponent = (String) salaryComponent;
		this.salaryComponentName = (String) salaryComponentName;
		this.calculationtype = (Integer) calculationtype;
		this.amount = (String) amount;
		this.gradeId = (String) gradeId;
		this.empId = (String) empId;
	}

	public String getSalaryComponent() {
		return salaryComponent;
	}
	public void setSalaryComponent(String salaryComponent) {
		this.salaryComponent = salaryComponent;
	}
	public String getSalaryComponentName() {
		return salaryComponentName;
	}
	public void setSalaryComponentName(String salaryComponentName) {
		this.salaryComponentName = salaryComponentName;
	}
	public Integer getCalculationtype() {
		return calculationtype;
	}
	public void setCalculationtype(Integer calculationtype) {
		this.calculationtype = calculationtype;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	
}
