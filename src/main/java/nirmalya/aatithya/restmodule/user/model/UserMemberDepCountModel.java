package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserMemberDepCountModel {

	private String key;

	private Integer limit;
	
	private Integer agelimit;
	
	
	public UserMemberDepCountModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserMemberDepCountModel(Object key, Object limit,Object agelimit) {
		super();
		try {
			this.key = (String) key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.limit = (Integer) limit;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			this.agelimit = (Integer) agelimit;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	public Integer getAgelimit() {
		return agelimit;
	}

	public void setAgelimit(Integer agelimit) {
		this.agelimit = agelimit;
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
