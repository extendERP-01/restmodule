package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AdditionalChargesModel {
	
	private String key;
	private Double name;
	
	public AdditionalChargesModel() {
		super();
	}

	public AdditionalChargesModel(Object key, Object name) {
		super();
		this.key = (String) key;
		this.name = (Double) name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Double getName() {
		return name;
	}

	public void setName(Double name) {
		this.name = name;
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
