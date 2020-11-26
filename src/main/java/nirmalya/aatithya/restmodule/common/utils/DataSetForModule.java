package nirmalya.aatithya.restmodule.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSetForModule {
	
	private String moduleId;
	
	private String moduleName;

	private String functionId;
	
	private String functionParentId;
	
	private String functionName;

	private String activityId;

	private String moduleIdInActivity;
	
	private String activityParentId;
	
	private String activityName;

public DataSetForModule() {
	super();
	// TODO Auto-generated constructor stub
}
public DataSetForModule(Object moduleId, Object moduleName,Object functionId, Object  functionParentId,
Object functionName,Object activityId,Object moduleIdInActivity,Object  activityParentId,Object activityName) {
	super();
	try {
		this.moduleId = (String) moduleId;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		this.moduleName = (String) moduleName;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		this.functionId = (String) functionId;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	try {
		this.functionParentId = (String) functionParentId;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	try {
		this.functionName = (String) functionName;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	try {
		this.activityId = (String) activityId;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	try {
		this.moduleIdInActivity = (String) moduleIdInActivity;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		this.activityParentId = (String) activityParentId;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		this.activityName = (String) activityName;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public String getModuleId() {
	return moduleId;
}
public void setModuleId(String moduleId) {
	this.moduleId = moduleId;
}
public String getModuleName() {
	return moduleName;
}
public void setModuleName(String moduleName) {
	this.moduleName = moduleName;
}
public String getFunctionId() {
	return functionId;
}
public void setFunctionId(String functionId) {
	this.functionId = functionId;
}
public String getFunctionParentId() {
	return functionParentId;
}
public void setFunctionParentId(String functionParentId) {
	this.functionParentId = functionParentId;
}
public String getFunctionName() {
	return functionName;
}
public void setFunctionName(String functionName) {
	this.functionName = functionName;
}
public String getActivityId() {
	return activityId;
}
public void setActivityId(String activityId) {
	this.activityId = activityId;
}
public String getModuleIdInActivity() {
	return moduleIdInActivity;
}
public void setModuleIdInActivity(String moduleIdInActivity) {
	this.moduleIdInActivity = moduleIdInActivity;
}
public String getActivityParentId() {
	return activityParentId;
}
public void setActivityParentId(String activityParentId) {
	this.activityParentId = activityParentId;
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
