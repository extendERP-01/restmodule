package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeInsuranceDetailsModel {

	private String employeeId;
	private String insuranceNo;
	private String insuaranceStartDate;
	private String insuaranceEndDate;
	private String memberName;
	private String relation;

	public HrmsEmployeeInsuranceDetailsModel() {
		super();
	}

	public HrmsEmployeeInsuranceDetailsModel(Object employeeId, Object insuranceNo, Object insuaranceStartDate,
			Object insuaranceEndDate, Object memberName, Object relation) {
		super();
		this.employeeId = (String) employeeId;
		this.insuranceNo = (String) insuranceNo;
		this.insuaranceStartDate = (String) insuaranceStartDate;
		this.insuaranceEndDate = (String) insuaranceEndDate;
		this.memberName = (String) memberName;
		this.relation = (String) relation;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public String getInsuaranceStartDate() {
		return insuaranceStartDate;
	}

	public void setInsuaranceStartDate(String insuaranceStartDate) {
		this.insuaranceStartDate = insuaranceStartDate;
	}

	public String getInsuaranceEndDate() {
		return insuaranceEndDate;
	}

	public void setInsuaranceEndDate(String insuaranceEndDate) {
		this.insuaranceEndDate = insuaranceEndDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
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
