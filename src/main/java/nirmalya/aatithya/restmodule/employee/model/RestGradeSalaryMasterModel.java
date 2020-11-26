package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestGradeSalaryMasterModel {
	private Integer tGradeSalaryId;
	private String tGradeId;
	private String tDescription;
	private String tSalaryComponent;
	private Byte tComponentType;
	private Integer tCalculationType;
	private Double tAmount;
	private String tCalculation;
	private String tCreatedBy;
	private Double basicSalary;
	private Double ctc;
	private String tGrade;

	public RestGradeSalaryMasterModel() {
		super();
	}

	public RestGradeSalaryMasterModel(Object tGradeSalaryId, Object tGradeId, Object tDescription,
			Object tSalaryComponent, Object tComponentType, Object tCalculationType, Object tAmount,
			Object tCalculation, Object tCreatedBy, Object basicSalary, Object ctc ,Object tGrade) {
		super();
		this.tGradeSalaryId = (Integer) tGradeSalaryId;
		this.tGradeId = (String) tGradeId;
		this.tDescription = (String) tDescription;
		this.tSalaryComponent = (String) tSalaryComponent;
		this.tComponentType = (Byte) tComponentType;
		this.tCalculationType = (Integer) tCalculationType;
		this.tAmount = (Double) tAmount;
		this.tCalculation = (String) tCalculation;
		this.tCreatedBy = (String) tCreatedBy;
		this.basicSalary = (Double) basicSalary;
		this.ctc = (Double) ctc;
		this.tGrade = (String) tGrade;
	}

	public Integer gettGradeSalaryId() {
		return tGradeSalaryId;
	}

	public void settGradeSalaryId(Integer tGradeSalaryId) {
		this.tGradeSalaryId = tGradeSalaryId;
	}

	public String gettGradeId() {
		return tGradeId;
	}

	public void settGradeId(String tGradeId) {
		this.tGradeId = tGradeId;
	}

	public String gettDescription() {
		return tDescription;
	}

	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}

	public String gettSalaryComponent() {
		return tSalaryComponent;
	}

	public void settSalaryComponent(String tSalaryComponent) {
		this.tSalaryComponent = tSalaryComponent;
	}

	public Byte gettComponentType() {
		return tComponentType;
	}

	public void settComponentType(Byte tComponentType) {
		this.tComponentType = tComponentType;
	}

	public Integer gettCalculationType() {
		return tCalculationType;
	}

	public void settCalculationType(Integer tCalculationType) {
		this.tCalculationType = tCalculationType;
	}

	public Double gettAmount() {
		return tAmount;
	}

	public void settAmount(Double tAmount) {
		this.tAmount = tAmount;
	}

	public String gettCalculation() {
		return tCalculation;
	}

	public void settCalculation(String tCalculation) {
		this.tCalculation = tCalculation;
	}

	public String gettCreatedBy() {
		return tCreatedBy;
	}

	public void settCreatedBy(String tCreatedBy) {
		this.tCreatedBy = tCreatedBy;
	}

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Double getCtc() {
		return ctc;
	}

	public void setCtc(Double ctc) {
		this.ctc = ctc;
	}

	public String gettGrade() {
		return tGrade;
	}

	public void settGrade(String tGrade) {
		this.tGrade = tGrade;
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
