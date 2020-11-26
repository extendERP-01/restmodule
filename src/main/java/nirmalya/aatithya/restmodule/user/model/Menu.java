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
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Menu(Object module,Object moduleLogo ,Object function, Object activity, Object url,Object activityStatus) {
		super();
		this.module = (String)module;
		this.moduleLogo = (String)moduleLogo;
		this.function = (String)function;
		this.activity = (String)activity;
		this.url      = (String)url;
		this.activityStatus      = (Boolean)activityStatus;
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



	/**
	 * Overrides toString method for converting class to string and back 
	**/
	@Override
	public String toString() {
		ObjectMapper  mapperObj=new ObjectMapper();
		String jsonStr;
		try{
			jsonStr=mapperObj.writeValueAsString(this);
		}catch(IOException ex){
			
			jsonStr=ex.toString();
		}
		return jsonStr;
	}
	
}
