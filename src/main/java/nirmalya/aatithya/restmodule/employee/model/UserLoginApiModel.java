package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserLoginApiModel {
	private String userId;
	private String userRole;
	private String userName;
	private String resturantName;
	private String resturantId;
	private String userImage;
	private String pin;
	private String authKey;
	private BigInteger validImie;
	private String email;
	private String mobileNo;

	public UserLoginApiModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLoginApiModel(Object userId, Object userRole, Object userName, Object resturantName, Object resturantId,
			Object userImage, Object pin, Object authKey, Object validImie, Object email, Object mobileNo) {
		super();
		try {
			this.userId = (String) userId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.userRole = (String) userRole;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.userName = (String) userName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.resturantName = (String) resturantName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.resturantId = (String) resturantId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.userImage = (String) userImage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pin = (String) pin;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.authKey = (String) authKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.validImie = (BigInteger) validImie;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.email = (String) email;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.mobileNo = (String) mobileNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getResturantName() {
		return resturantName;
	}

	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}

	public String getResturantId() {
		return resturantId;
	}

	public void setResturantId(String resturantId) {
		this.resturantId = resturantId;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public BigInteger getValidImie() {
		return validImie;
	}

	public void setValidImie(BigInteger validImie) {
		this.validImie = validImie;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
