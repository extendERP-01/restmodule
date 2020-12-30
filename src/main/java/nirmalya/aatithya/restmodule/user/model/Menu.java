package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class Menu {

	private String module;
	private String moduleLogo;
	private String function;
	private String activity;
	private String url;
	private Boolean activityStatus;
	private String moduleId;
	private String functionId;
	private String activityId;

	public Menu() {
		super();
	}

	public Menu(Object module, Object moduleLogo, Object function, Object activity, Object url, Object activityStatus,
			Object moduleId, Object functionId, Object activityId) {
		super();
		this.module = (String) module;
		this.moduleLogo = (String) moduleLogo;
		this.function = (String) function;
		this.activity = (String) activity;
		this.url = (String) url;
		this.activityStatus = (Boolean) activityStatus;
		this.moduleId = (String) moduleId;
		this.functionId = (String) functionId;
		this.activityId = (String) activityId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getModuleLogo() {
		return moduleLogo;
	}

	public void setModuleLogo(String moduleLogo) {
		this.moduleLogo = moduleLogo;
	}

	public Boolean getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(Boolean activityStatus) {
		this.activityStatus = activityStatus;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	/**
	 * Overrides toString method for converting class to string and back
	 **/
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
