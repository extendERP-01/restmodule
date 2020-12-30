package nirmalya.aatithya.restmodule.employee.model;

public class ExitInitiateModel {
	private String intiateId;
	private String empId;
	private String empName;
	private String manager;
	private String empDepartment;
	private String empDepName;
	private String department;
	private String person;
	private Boolean clearanceStatus;
	private String comment;
	private String createdBy;
	
	
	public ExitInitiateModel(Object intiateId,Object empId, Object empName, Object manager, Object empDepartment,Object empDepName, Object department,
			Object person, Object clearanceStatus, Object comment,Object createdBy) {
		super();
		try {
			this.intiateId = (String) intiateId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.empId = (String) empId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empName = (String) empName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.manager = (String) manager;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empDepartment = (String) empDepartment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.empDepName = (String) empDepName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.department = (String) department;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.person = (String) person;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.clearanceStatus = (Boolean) clearanceStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.comment = (String) comment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ExitInitiateModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Boolean getClearanceStatus() {
		return clearanceStatus;
	}
	public void setClearanceStatus(Boolean clearanceStatus) {
		this.clearanceStatus = clearanceStatus;
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

	public String getEmpDepName() {
		return empDepName;
	}

	public void setEmpDepName(String empDepName) {
		this.empDepName = empDepName;
	}

	public String getIntiateId() {
		return intiateId;
	}

	public void setIntiateId(String intiateId) {
		this.intiateId = intiateId;
	}
	

	
}
