package nirmalya.aatithya.restmodule.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSetForPropType1 {

	
	private String ptype1;
	
	private String ptype2;
	
	private String key;

	private String name;

	public DataSetForPropType1() {
		super();
	}
	
	public DataSetForPropType1(Object key, Object name) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.name = (String) name;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public String getPtype1() {
		return ptype1;
	}

	public void setPtype1(String ptype1) {
		this.ptype1 = ptype1;
	}

	public String getPtype2() {
		return ptype2;
	}

	public void setPtype2(String ptype2) {
		this.ptype2 = ptype2;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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
