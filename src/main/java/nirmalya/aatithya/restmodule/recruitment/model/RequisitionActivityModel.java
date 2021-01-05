package nirmalya.aatithya.restmodule.recruitment.model;

public class RequisitionActivityModel {

	private Integer activityId;
	private String activityHistoryDate; 
	private String activityHistoryStatus;
	private String activityHistoryCretaedBy;
	
	
	
	
	public RequisitionActivityModel(Object activityId, Object activityHistoryDate, Object activityHistoryStatus,
			Object activityHistoryCretaedBy) {
		super();
		this.activityId = (Integer) activityId;
		this.activityHistoryDate = (String) activityHistoryDate;
		this.activityHistoryStatus = (String) activityHistoryStatus;
		this.activityHistoryCretaedBy = (String) activityHistoryCretaedBy;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getActivityHistoryDate() {
		return activityHistoryDate;
	}
	public void setActivityHistoryDate(String activityHistoryDate) {
		this.activityHistoryDate = activityHistoryDate;
	}
	public String getActivityHistoryStatus() {
		return activityHistoryStatus;
	}
	public void setActivityHistoryStatus(String activityHistoryStatus) {
		this.activityHistoryStatus = activityHistoryStatus;
	}
	public String getActivityHistoryCretaedBy() {
		return activityHistoryCretaedBy;
	}
	public void setActivityHistoryCretaedBy(String activityHistoryCretaedBy) {
		this.activityHistoryCretaedBy = activityHistoryCretaedBy;
	}
	
}
