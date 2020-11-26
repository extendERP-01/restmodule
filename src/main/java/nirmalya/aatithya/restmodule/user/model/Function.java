package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nirmalya Labs
 *
 */
public class Function {

	private String name; 
	private List<Activity> function;

	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Activity> getFunction() {
		return function;
	}

	public void setFunction(List<Activity> function) {
		this.function = function;
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
