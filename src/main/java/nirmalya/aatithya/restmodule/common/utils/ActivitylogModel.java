package nirmalya.aatithya.restmodule.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ActivitylogModel {

	private String moduleId;
	private String componentId;
	private String subSomponentId;
	private String operationId;
	private String operationName;
	private String operationBy;
	private String operationOn;

	public ActivitylogModel() {
		super();
	}

	public ActivitylogModel(Object moduleId, Object componentId, Object subSomponentId, Object operationId,
			Object operationName, Object operationBy, Object operationOn) {
		super();
		this.moduleId = (String) moduleId;
		this.componentId = (String) componentId;
		this.subSomponentId = (String) subSomponentId;
		this.operationId = (String) operationId;
		this.operationName = (String) operationName;
		this.operationBy = (String) operationBy;
		this.operationOn = (String) operationOn;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getSubSomponentId() {
		return subSomponentId;
	}

	public void setSubSomponentId(String subSomponentId) {
		this.subSomponentId = subSomponentId;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationBy() {
		return operationBy;
	}

	public void setOperationBy(String operationBy) {
		this.operationBy = operationBy;
	}

	public String getOperationOn() {
		return operationOn;
	}

	public void setOperationOn(String operationOn) {
		this.operationOn = operationOn;
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
