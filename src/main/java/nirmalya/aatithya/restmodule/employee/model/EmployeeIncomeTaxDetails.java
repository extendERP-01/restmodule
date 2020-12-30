package nirmalya.aatithya.restmodule.employee.model;

public class EmployeeIncomeTaxDetails {

	private String incomeTaxId;
	private String employeeId;
	private String employeeName;
	private String fromDate;
	private String toDate; 
	private Double taxAmount;
	private String approveBy;
	private String createdBy;

	public EmployeeIncomeTaxDetails() {
		super();
	}

	public EmployeeIncomeTaxDetails(Object incomeTaxId, Object employeeId, Object employeeName, Object fromDate,
			Object toDate,  Object taxAmount, Object approveBy) {
		super();
		this.incomeTaxId = (String) incomeTaxId;
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.fromDate = (String) fromDate;
		this.toDate = (String) toDate;
		this.taxAmount = (Double) taxAmount;
		this.approveBy = (String) approveBy;
	}

	public String getIncomeTaxId() {
		return incomeTaxId;
	}

	public void setIncomeTaxId(String incomeTaxId) {
		this.incomeTaxId = incomeTaxId;
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

		public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
