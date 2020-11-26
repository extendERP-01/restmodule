package nirmalya.aatithya.restmodule.leave.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestLeavePeriodModel {
	
private String lPeriodId;//primary key
	
	private String lPeriodName; 

	private String lPeriodStartDate;
	
	private String lPeriodEndDate;
	
	private Boolean lPeriodStatus;
	 
    private String lPeriodCreatedOn;
	
	private String lPeriodUpdateOn;
	
	private String createdBy;
	
	public RestLeavePeriodModel() {
		super();
	}
	
	public RestLeavePeriodModel(Object lPeriodId,  Object lPeriodName, 
			Object lPeriodStartDate, Object lPeriodEndDate, Object lPeriodStatus) {
		super();
		try {
			this.lPeriodId = (String) lPeriodId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.lPeriodName = (String) lPeriodName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.lPeriodStartDate = (String) lPeriodStartDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.lPeriodEndDate = (String) lPeriodEndDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 

		try {
			this.lPeriodStatus = (Boolean) lPeriodStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		 

	}

	public String getlPeriodId() {
		return lPeriodId;
	}

	public void setlPeriodId(String lPeriodId) {
		this.lPeriodId = lPeriodId;
	}

	public String getlPeriodName() {
		return lPeriodName;
	}

	public void setlPeriodName(String lPeriodName) {
		this.lPeriodName = lPeriodName;
	}

	public String getlPeriodStartDate() {
		return lPeriodStartDate;
	}

	public void setlPeriodStartDate(String lPeriodStartDate) {
		this.lPeriodStartDate = lPeriodStartDate;
	}

	public String getlPeriodEndDate() {
		return lPeriodEndDate;
	}

	public void setlPeriodEndDate(String lPeriodEndDate) {
		this.lPeriodEndDate = lPeriodEndDate;
	}

	public Boolean getlPeriodStatus() {
		return lPeriodStatus;
	}

	public void setlPeriodStatus(Boolean lPeriodStatus) {
		this.lPeriodStatus = lPeriodStatus;
	}

	public String getlPeriodCreatedOn() {
		return lPeriodCreatedOn;
	}

	public void setlPeriodCreatedOn(String lPeriodCreatedOn) {
		this.lPeriodCreatedOn = lPeriodCreatedOn;
	}

	public String getlPeriodUpdateOn() {
		return lPeriodUpdateOn;
	}

	public void setlPeriodUpdateOn(String lPeriodUpdateOn) {
		this.lPeriodUpdateOn = lPeriodUpdateOn;
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
