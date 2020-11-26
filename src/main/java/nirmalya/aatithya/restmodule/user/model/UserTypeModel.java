
/**
 * rest Module for User Type
 */
package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserTypeModel {

	private String userType;
	private String userTypeName;
	private String userTypeDescrptn;
	private Boolean userTypeActive;
	private String createdBy;
	public UserTypeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserTypeModel(Object userType,  Object userTypeName, Object userTypeDescrptn,Object userTypeActive)
			 {
		super();
		
		try {
			this.userType = (String) userType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			this.userTypeName = (String) userTypeName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.userTypeDescrptn = (String) userTypeDescrptn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.userTypeActive = (Boolean) userTypeActive;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public String getUserTypeDescrptn() {
		return userTypeDescrptn;
	}
	public void setUserTypeDescrptn(String userTypeDescrptn) {
		this.userTypeDescrptn = userTypeDescrptn;
	}
	public Boolean getUserTypeActive() {
		return userTypeActive;
	}
	public void setUserTypeActive(Boolean userTypeActive) {
		this.userTypeActive = userTypeActive;
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
