package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginDataModel {

	private String userId;
	private String authKey;
	private String pinAvailable;
	private Integer otp;
	private String pin;
	private String mobileNo;
	private String imieNo;
	
	

	public LoginDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDataModel(Object userId, Object authKey, Object pin ,Object otp) {
		super();
		this.userId = (String) userId;
		this.authKey = (String) authKey;
		this.pin = (String) pin;
		this.otp = (Integer) otp;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getPinAvailable() {
		return pinAvailable;
	}

	public void setPinAvailable(String pinAvailable) {
		this.pinAvailable = pinAvailable;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getImieNo() {
		return imieNo;
	}

	public void setImieNo(String imieNo) {
		this.imieNo = imieNo;
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
