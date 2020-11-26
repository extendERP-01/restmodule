package nirmalya.aatithya.restmodule.production.model;

public class AssignSlitPipeSizeModel {

	private String gradeId;
	private String grade;
	private String thicknessId;
	private String thickness;
	private String pipeSizeId;
	private String pipeSize;
	private Integer slitWidth;
	private Boolean status;
	private String createdBy;
	
	public AssignSlitPipeSizeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssignSlitPipeSizeModel(Object gradeId, Object grade, Object thicknessId, Object thickness,
			Object pipeSizeId, Object pipeSize, Object slitWidth, Object status, Object createdBy) {
		super();
		this.gradeId = (String) gradeId;
		this.grade = (String) grade;
		this.thicknessId = (String) thicknessId;
		this.thickness = (String) thickness;
		this.pipeSizeId = (String) pipeSizeId;
		this.pipeSize = (String) pipeSize;
		this.slitWidth = (Integer) slitWidth;
		this.status = (Boolean) status;
		this.createdBy = (String) createdBy;
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

	public Integer getSlitWidth() {
		return slitWidth;
	}

	public void setSlitWidth(Integer slitWidth) {
		this.slitWidth = slitWidth;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
