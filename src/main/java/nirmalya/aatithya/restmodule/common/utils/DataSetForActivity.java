package nirmalya.aatithya.restmodule.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSetForActivity {
	private String activityId;
	
	private String activityModuleId;
	
	private String parentActivityId;
	
	private String activityName;

	public DataSetForActivity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataSetForActivity(Object activityId, Object activityModuleId,Object parentActivityId,Object activityName) {
		super();
		try {
			this.activityId = (String) activityId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.activityModuleId = (String) activityModuleId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.parentActivityId = (String) parentActivityId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.activityName = (String) activityName;
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityModuleId() {
		return activityModuleId;
	}

	public void setActivityModuleId(String activityModuleId) {
		this.activityModuleId = activityModuleId;
	}

	public String getParentActivityId() {
		return parentActivityId;
	}

	public void setParentActivityId(String parentActivityId) {
		this.parentActivityId = parentActivityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
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
