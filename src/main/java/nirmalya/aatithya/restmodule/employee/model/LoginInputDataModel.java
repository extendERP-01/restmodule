package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginInputDataModel {
	private String mobileNo;
	private String imieNo;
	private String pin;
	private String userId;
	private  String otp;

	public LoginInputDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginInputDataModel(Object mobileNo, Object imieNo) {
		super();
		this.mobileNo = (String) mobileNo;
		this.imieNo = (String) imieNo;
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

	public void setImieNo(String imeNo) {
		this.imieNo = imeNo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
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


