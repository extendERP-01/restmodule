package nirmalya.aatithya.restmodule.reimbursement.model;

public class HrmsEmployeeCompanyDetailsModel {

	private String empName;
	private String empAddrs;
	private String empMod;
	private String empEmail;
	private  String empGstNo;
	private String compName;
	private String compAddrs;
	private String compMod;
	private String compEmail;
	private  String compGstNo;
	
	
	public HrmsEmployeeCompanyDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrmsEmployeeCompanyDetailsModel(Object empName, Object empAddrs, Object empMod, Object empEmail,
			Object empGstNo, Object compName, Object compAddrs, Object compMod, Object compEmail, Object compGstNo) {
		super();
		this.empName = (String) empName;
		this.empAddrs = (String) empAddrs;
		this.empMod = (String) empMod;
		this.empEmail = (String) empEmail;
		this.empGstNo = (String) empGstNo;
		this.compName = (String) compName;
		this.compAddrs = (String) compAddrs;
		this.compMod = (String) compMod;
		this.compEmail = (String) compEmail;
		this.compGstNo = (String) compGstNo;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddrs() {
		return empAddrs;
	}
	public void setEmpAddrs(String empAddrs) {
		this.empAddrs = empAddrs;
	}
	public String getEmpMod() {
		return empMod;
	}
	public void setEmpMod(String empMod) {
		this.empMod = empMod;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpGstNo() {
		return empGstNo;
	}
	public void setEmpGstNo(String empGstNo) {
		this.empGstNo = empGstNo;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompAddrs() {
		return compAddrs;
	}
	public void setCompAddrs(String compAddrs) {
		this.compAddrs = compAddrs;
	}
	public String getCompMod() {
		return compMod;
	}
	public void setCompMod(String compMod) {
		this.compMod = compMod;
	}
	public String getCompEmail() {
		return compEmail;
	}
	public void setCompEmail(String compEmail) {
		this.compEmail = compEmail;
	}
	public String getCompGstNo() {
		return compGstNo;
	}
	public void setCompGstNo(String compGstNo) {
		this.compGstNo = compGstNo;
	}
	
}
