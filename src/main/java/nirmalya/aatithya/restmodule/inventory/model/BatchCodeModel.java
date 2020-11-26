package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BatchCodeModel {

	private String batchId;
	private String grnId;
	private String grn;
	private String gradeId;
	private String grade;
	private String thicknessId;
	private String thickness;
	private String pipeSizeId;
	private String pipeSize;
	private String batchCode;;
	private Double quantity;
	private String createdBy;
	
	public BatchCodeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BatchCodeModel(Object batchId, Object grnId, Object grn, Object gradeId, Object grade, Object thicknessId,
			Object thickness, Object pipeSizeId, Object pipeSize, Object batchCode, Object createdBy ,Object quantity) {
		super();
		this.batchId = (String) batchId;
		this.grnId = (String) grnId;
		this.grn = (String) grn;
		this.gradeId = (String) gradeId;
		this.grade = (String) grade;
		this.thicknessId = (String) thicknessId;
		this.thickness = (String) thickness;
		this.pipeSizeId = (String) pipeSizeId;
		this.pipeSize = (String) pipeSize;
		this.batchCode = (String) batchCode;
		this.createdBy = (String) createdBy;
		this.quantity = (Double) quantity;
	}

	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getGrnId() {
		return grnId;
	}
	public void setGrnId(String grnId) {
		this.grnId = grnId;
	}
	public String getGrn() {
		return grn;
	}
	public void setGrn(String grn) {
		this.grn = grn;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getThicknessId() {
		return thicknessId;
	}
	public void setThicknessId(String thicknessId) {
		this.thicknessId = thicknessId;
	}
	public String getThickness() {
		return thickness;
	}
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	public String getPipeSizeId() {
		return pipeSizeId;
	}
	public void setPipeSizeId(String pipeSizeId) {
		this.pipeSizeId = pipeSizeId;
	}
	public String getPipeSize() {
		return pipeSize;
	}
	public void setPipeSize(String pipeSize) {
		this.pipeSize = pipeSize;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
