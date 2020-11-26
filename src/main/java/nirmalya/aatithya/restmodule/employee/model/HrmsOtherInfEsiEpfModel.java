package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsOtherInfEsiEpfModel {

	private String employeeId;
	private String idNo;
	private String nomineeName;
	private String nomineeRel;
	private Double sharePer;
	private String createdBy;

	public HrmsOtherInfEsiEpfModel() {
		super();
	}

	public HrmsOtherInfEsiEpfModel(Object employeeId, Object idNo, Object nomineeName, Object nomineeRel,
			Object sharePer) {
		super();
		this.employeeId = (String) employeeId;
		this.idNo = (String) idNo;
		this.nomineeName = (String) nomineeName;
		this.nomineeRel = (String) nomineeRel;
		this.sharePer = (Double) sharePer;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
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

	public Double getSharePer() {
		return sharePer;
	}

	public void setSharePer(Double sharePer) {
		this.sharePer = sharePer;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
